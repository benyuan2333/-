import ttkbootstrap as tb
from ttkbootstrap import ttk
from ttkbootstrap.dialogs import Messagebox
from ttkbootstrap.constants import *
from tkinter import filedialog
import os
import re
import csv
import json
import time
import requests
import lxml.html
import threading
import concurrent.futures
from bs4 import BeautifulSoup

class StravaDownloader(tb.Window):
    def __init__(self):
        super().__init__(title="Strava 路书下载", themename="flatly")
        self.pause_event = threading.Event()
        self.pause_event.set()
        self.is_downloading = False  
        self.create_widgets()
        self.protocol("WM_DELETE_WINDOW", self.on_closing) 

    def create_widgets(self):
        # 创建主要框架
        frame = ttk.Frame(self, padding=20)
        frame.grid(row=0, column=0, sticky=(W, E, N, S), padx=10, pady=10)

        # 主题切换下拉菜单
        themes = self.style.theme_names()
        self.theme_var = tb.StringVar(value=self.style.theme_use())
        ttk.Label(frame, text="选择主题:").grid(row=0, column=0, sticky=E, pady=5)
        ttk.Combobox(frame, textvariable=self.theme_var, values=themes, bootstyle=SUCCESS).grid(row=0, column=1, sticky=W, pady=5)
        ttk.Button(frame, text="切换主题", command=self.change_theme, bootstyle="outline").grid(row=0, column=2, sticky=W, pady=5)

        # 其他控件
        ttk.Label(frame, text="Cookies (用@号分隔):").grid(row=1, column=0, sticky=E, pady=5)
        self.cookies_entry = ttk.Entry(frame, width=50, bootstyle=SUCCESS)
        self.cookies_entry.grid(row=1, column=1, columnspan=2, sticky=W, pady=5)
        self.set_default_entry(self.cookies_entry, self.default_cookie(), 50)

        ttk.Label(frame, text="使用代理:").grid(row=2, column=0, sticky=E, pady=5)
        self.use_proxy_var = tb.BooleanVar(value=True)
        ttk.Checkbutton(frame, variable=self.use_proxy_var, bootstyle="round-toggle").grid(row=2, column=1, sticky=W, pady=5)

        ttk.Label(frame, text="城市 (分号分隔):").grid(row=3, column=0, sticky=E, pady=5)
        self.cities_entry = ttk.Entry(frame, width=50, bootstyle=SUCCESS)
        self.cities_entry.grid(row=3, column=1, columnspan=2, sticky=W, pady=5)

        ttk.Label(frame, text="页码范围 (例如 1-50):").grid(row=4, column=0, sticky=E, pady=5)
        self.pages_entry = ttk.Entry(frame, width=10, bootstyle=INFO)
        self.pages_entry.grid(row=4, column=1, sticky=W, pady=5)

        ttk.Label(frame, text="尝试次数下限:").grid(row=5, column=0, sticky=E, pady=5)
        self.attempts_threshold_entry = ttk.Entry(frame, width=10, bootstyle=INFO)
        self.attempts_threshold_entry.grid(row=5, column=1, sticky=W, pady=5)
        self.set_default_entry(self.attempts_threshold_entry, "10000", 10)

        ttk.Label(frame, text="线程数量（建议2）:").grid(row=6, column=0, sticky=E, pady=5)
        self.num_threads_entry = ttk.Entry(frame, width=10, bootstyle=WARNING)
        self.num_threads_entry.grid(row=6, column=1, sticky=W, pady=5)
        self.set_default_entry(self.num_threads_entry, "2", 10)

        ttk.Label(frame, text="保存目录:").grid(row=7, column=0, sticky=E, pady=5)
        self.folder_entry = ttk.Entry(frame, width=20, bootstyle=SUCCESS)
        self.folder_entry.grid(row=7, column=1, sticky=W, pady=5)
        ttk.Button(frame, text="选择目录", command=self.browse_folder, bootstyle="outline").grid(row=7, column=2, sticky=W, pady=5)

        ttk.Button(frame, text="开始下载", command=self.start_download, bootstyle="primary-outline").grid(row=8, column=0, columnspan=2, pady=10)
        self.pause_button = ttk.Button(frame, text="暂停下载", command=self.toggle_pause, bootstyle="secondary-outline")
        self.pause_button.grid(row=8, column=2, columnspan=1, sticky=W, pady=10)

        self.log_text = tb.Text(self, height=10, wrap='word')
        self.log_text.grid(row=9, column=0, columnspan=3, sticky=(W, E, N, S), padx=10, pady=10)
        self.log_text.config(state=DISABLED)

        self.status_label = ttk.Label(frame, text="准备下载...")
        self.status_label.grid(row=10, column=0, columnspan=3, sticky=(W, E), pady=5)

        self.progress_var = tb.DoubleVar()
        self.progress_bar = ttk.Progressbar(frame, variable=self.progress_var, maximum=100, length=300)
        self.progress_bar.grid(row=11, column=0, columnspan=3, sticky=(W, E), pady=5)

    def change_theme(self):
        new_theme = self.theme_var.get()
        self.style.theme_use(new_theme)

    def default_cookie(self):
        return ("")

    def set_default_entry(self, entry, default_value, width):
        entry.config(width=width)
        entry.delete(0, END)
        entry.insert(0, default_value)

    def browse_folder(self):
        folder_selected = filedialog.askdirectory()
        if folder_selected:
            self.folder_entry.delete(0, END)
            self.folder_entry.insert(0, folder_selected)

    def log(self, message):
        def append_message():
            self.log_text.config(state=NORMAL)
            self.log_text.insert(END, message + "\n")
            self.log_text.see(END)
            self.log_text.config(state=DISABLED)
        self.after(0, append_message)

    def update_progress(self, progress, message):
        def task():
            self.progress_var.set(progress)
            self.status_label.config(text=message)
        self.after(100, task)

    def start_download(self):
        if self.is_downloading and not self.pause_event.is_set():
            Messagebox.show_info("下载已在进行中", parent=self)
            return
        if not self.is_downloading:
            self.is_downloading = True
            self.pause_event.set()
        try:
            cookies = [cookie.strip() for cookie in self.cookies_entry.get().split("@")]
            cities = [city.strip() for city in self.cities_entry.get().split(";")]
            pages = list(map(int, self.pages_entry.get().split("-")))
            pages_range = range(pages[0], pages[1] + 1)
            attempts_threshold = int(self.attempts_threshold_entry.get())
            num_threads = int(self.num_threads_entry.get())
            folder_name = self.folder_entry.get()
            use_proxy = self.use_proxy_var.get()

            if not (cookies and cities and folder_name and pages and attempts_threshold and num_threads):
                Messagebox.show_error("错误", "请填写所有字段")
                return

            threading.Thread(target=self.download_data, args=(cookies, cities, pages_range, folder_name, attempts_threshold, num_threads, use_proxy)).start()
        except Exception as e:
            Messagebox.show_error("启动下载失败", str(e), parent=self)
            self.is_downloading = False

    def toggle_pause(self):
       if not self.is_downloading:
            Messagebox.show_info("当前没有进行中的下载任务", parent=self)
            return
       if self.pause_event.is_set():
          self.pause_event.clear()  
          self.pause_button.config(text="继续下载")
       else:
          self.pause_event.set()  
          self.pause_button.config(text="暂停下载")

    def update_pause_button(self):
        self.pause_button.config(text="继续下载", bootstyle="success-outline")  

    def on_closing(self):
        if self.is_downloading:
           response = Messagebox.okcancel("关闭确认", "下载正在进行中...确定要关闭嘛？!", parent=self)
           if response == "确定":  
              self.destroy()
        else:
            self.destroy()

    def get_proxy(self):
        try:
            response = requests.get("http://8.219.8.66:5010/get/")
            if response.status_code == 200:
                return response.json().get("proxy")
            else:
                self.log("获取代理失败，状态码：" + str(response.status_code))
        except requests.RequestException as e:
            self.log("获取代理时发生网络异常：" + str(e))
        return None

    def delete_proxy(self, proxy):
        try:
            requests.get(f"http://8.219.8.66:5010/delete/?proxy={proxy}")
        except requests.RequestException as e:
            self.log("删除代理时发生网络异常：" + str(e))

    def get_html(self, url, cookies, headers, use_proxy, max_retries=5):
        retries = 0
        proxy = self.get_proxy() if use_proxy else None
        while retries < max_retries:
            try:
                response = requests.get(url, proxies={"http": f"http://{proxy}"} if proxy else None, cookies=cookies, headers=headers)
                if response.status_code == 200:
                    return response
                elif response.status_code == 429:
                    retry_after = response.headers.get('Retry-After', 3600)  
                    self.log(f"状态码 429: 被限制，等待 {retry_after} 秒后重试或更换Cookie")
                    time.sleep(int(retry_after))  
                    retries += 1
                    continue 
                else:
                    self.log(f"请求 {url} 失败, 状态码: {response.status_code}")
            except requests.RequestException as e:
                self.log(f"请求 {url} 时出现网络错误: {str(e)}")
                self.pause_event.clear()  
                self.after(0, self.update_pause_button)  
                break  

            retries += 1
            if use_proxy:
                self.delete_proxy(proxy)
                proxy = self.get_proxy()
        self.log(f"无法获取 {url}，超过最大重试次数")
        return None

    def download_file(self, activity_id, city_name, city_folder, cookies, headers, use_proxy):
        self.pause_event.wait()
        url = f"https://www.strava.com/activities/{activity_id}/export_gpx"
        response = self.get_html(url, cookies, headers, use_proxy)
        if response and response.status_code == 200:
            filename = f"{city_name}-{activity_id}.gpx"
            file_path = os.path.join(city_folder, filename)
            with open(file_path, 'wb') as file:
                for chunk in response.iter_content(chunk_size=1024):
                    if chunk:
                        file.write(chunk)
            self.log(f"{activity_id} 下载完成，文件已保存到 {file_path}")
        else:
            self.log(f"在尝试下载{url}时出现错误")

    def download_segment(self, segment_id, city_name, city_folder, attempts_dict, segment_activity_dict, headers, cookies, attempts_threshold, use_proxy):
        url = f"https://www.strava.com/segments/{segment_id}"
        response = self.get_html(url, cookies, headers, use_proxy)
        if response is None:
            self.log(f"获取 {url} 时出现错误")
            return
        soup = BeautifulSoup(response.text, 'html.parser')

        attempts_tag = soup.find('div', class_='stat attempts')
        if attempts_tag is None:
            self.log(f"没有找到尝试次数信息 {url}")
            return
        attempts_num = int(attempts_tag.find('span', class_='stat-subtext').get_text().split(' ')[2].replace(',', ''))
        attempts_dict[segment_id] = attempts_num
        if attempts_num < attempts_threshold:
            self.log(f"{segment_id} 尝试次数{attempts_num}<{attempts_threshold}")
            return

        td_tag = soup.find('td', class_='track-click', attrs={'data-tracking-element': 'leaderboard_effort'})
        if td_tag is None:
            self.log(f"没有找到td tag {url}")
            return

        activity_id = json.loads(td_tag['data-tracking-properties']).get("activity_id")
        segment_activity_dict[segment_id] = activity_id
        self.download_file(activity_id, city_name, city_folder, cookies, headers, use_proxy)
        self.pause_event.wait()

    def location_matches(self, city, location_text):
        city_parts = [part.strip().lower() for part in city.split(',')]
        location_parts = [part.strip().lower() for part in location_text.split(',')]
        return any(re.search(r"\b" + re.escape(part) + r"\b", location_text, re.IGNORECASE) for part in city_parts)

    def download_data(self, cookies, cities, pages, folder_name, attempts_threshold, num_threads, use_proxy):
        total_pages = sum([len(pages) for _ in cities])
        current_page = 0

        headers = {
            "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36 Edg/124.0.0.0",
            "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7",
            "Referer": "https://www.strava.com/login",
            "Accept-Encoding": "gzip, deflate, br",
            "Accept-Language": "zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6",
        }

        for city in cities:
            city_name = city.split(',')[0].strip()
            city_folder_name = city.replace(',', '-').replace(' ', '')
            city_folder = os.path.join(os.path.expanduser("~/Desktop"), f"{folder_name}/{city_folder_name}")
            os.makedirs(city_folder, exist_ok=True)
            self.after(0, lambda: self.update_progress(0, f"{city}开始下载"))
            attempts_dict = {}
            segment_activity_dict = {}

            for page in pages:
                current_page += 1
                progress = (current_page / total_pages) * 100
                self.log(f"正在下载{city}第 {page} 页...")
                self.after(0, lambda p=progress, c=f"正在下载 {city} 第 {page} 页...": self.update_progress(p, c))
                segment_ids = []
                url = f"https://www.strava.com/segments/search?filter_type=Ride&keywords={city}&max-cat=5&min-cat=0&page={page}&terrain=all&utf8=%E2%9C%93"
                cookies_dict = {'cookie': cookies[page % len(cookies)]}  
                response = self.get_html(url, cookies_dict, headers, use_proxy)
                if response is None:
                    self.log(f"获取 {url} 时出现错误")
                    continue

                tree = lxml.html.fromstring(str(BeautifulSoup(response.text, 'html.parser')))
                for tr in tree.xpath("//tr"):
                    segment_id_element = tr.xpath("./td[1]/div[@class='starred starred-segment']")
                    location_element = tr.xpath("./td[4]")
                    if segment_id_element and location_element:
                        segment_id = segment_id_element[0].get('data-segment-id')
                        location_text = location_element[0].text.strip() if location_element[0].text else None
                        if location_text and self.location_matches(city, location_text):
                            self.log(f"{segment_id}的位置符合")
                            segment_ids.append(segment_id)
                        else:
                            self.log(f"{segment_id}的位置不符" if location_text else "找不到位置信息")

                with concurrent.futures.ThreadPoolExecutor(max_workers=num_threads) as executor:
                    futures = [executor.submit(self.download_segment, segment_id, city_name, city_folder, attempts_dict,
                                               segment_activity_dict, headers, cookies_dict, attempts_threshold, use_proxy) for segment_id in segment_ids]
                    concurrent.futures.wait(futures)  # 确保所有线程完成

            csv_file_path = os.path.join(city_folder, 'segments_attempts.csv')
            sorted_attempts_dict = dict(sorted(attempts_dict.items(), key=lambda item: item[1], reverse=True))
            with open(csv_file_path, 'w', newline='') as f:
                writer = csv.writer(f)
                writer.writerow(['Segment ID', 'Activity ID', 'Attempts'])
                for segment_id, attempts in sorted_attempts_dict.items():
                    writer.writerow([segment_id, segment_activity_dict.get(segment_id, ""), attempts])

            self.after(0, lambda: self.update_progress(100, "下载完成"))


if __name__ == "__main__":
    app = StravaDownloader()
    # app.geometry("750x500+500+270")
    app.mainloop()
