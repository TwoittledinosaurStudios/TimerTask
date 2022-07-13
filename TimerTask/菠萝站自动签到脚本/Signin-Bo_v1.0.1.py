# 判断 库
import torch
# requests 请求库
import requests
# html 转换解析库
from lxml import etree
# json 转换库
import json
# 时间库
import time
# 打印 表格
from tabulate import tabulate
import prettytable

# 地址 请求头 编码
requests.encoding = 'utf-8'
url = "https://wngamebox.cn"
headers = {
    "Origin": "https://wngamebox.cn",
    "Referer": "https://wngamebox.cn/",
    "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.77 Safari/537.36",
}

table = []


# 账号解析
def get_data_list():
    zhi = {}
    data = []

    username = ["2028744995@qq.com", "840284965@qq.com", "2747352272@qq.com"]
    password = ["zhang2004", "zhang2004", "zhang2004"]

    # username = ["2747352272@qq.com"]
    # password = ["zhang2004"]

    # username = ["2028744995@qq.com"]
    # password = ["zhang2004"]

    for i in range(len(username)):
        zhi['username'] = username[i]
        zhi['password'] = password[i]
        data.append(zhi.copy())
    return data


# 登录成功 并 [1]签到
def login():
    # 进行登录 拿到token的值
    for i in get_data_list():
        user = requests.post(url=url + '/wp-json/jwt-auth/v1/token', data=i, headers=headers)

        # 获取 用户 的 token
        userjson = json.loads(user.text)
        token = 'Bearer ' + (userjson["token"])

        # 设置请求头
        headers1 = {
            "Origin": "https://wngamebox.cn",
            "Referer": "https://wngamebox.cn/",
            "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) "
                          "Chrome/91.0.4472.77 Safari/537.36",
            'authorization': token,
        }

        # 执行 [1]签到
        whether1 = requests.post(url + '/wp-json/b2/v1/userMission', headers=headers1)

        # 获取 信息
        whether2 = requests.post(url + '/wp-json/b2/v1/getUserInfo', headers=headers1)
        whether3 = requests.post(url + '/wp-json/b2/v1/getUserMission', headers=headers1)

        # 判断 是否 [1]签到 (如果签到了直接输出签到信息) (如果没有签到了直接签到在输出签到信息)
        if torch.is_tensor(json.loads(whether1.text)):
            json_resolve(json.loads(whether1.text), i, json.loads(whether3.text))
        else:
            json_resolve(json.loads(whether2.text), i, json.loads(whether3.text))


# json 解析
def json_resolve(json1, username, json2):
    table.append(
        [
            str(json1['user_data']['id']),
            str(username['username']),
            str(json1['user_data']['name']),
            str(json2['mission']['date']),
            str(json2['mission']['credit']),
            str(json2['mission']['my_credit']),
            str(json2['mission']['always']),
        ],
    )


if __name__ == "__main__":
    login()
    head = [
        '用户ID',
        '账号',
        '用户名称',
        '今日签到时间',
        '今日得到的积分',
        '账号所有积分',
        '签到天数',
    ]
    print(tabulate(tabular_data=table, headers=head, tablefmt="grid"))
