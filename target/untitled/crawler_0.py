import requests  # 导入requests包
from bs4 import BeautifulSoup


def getLesson(lessonList):
    for i in lessonList:
        lesson = {}
        try:
            lesson['herf'] = i.find('a')['href'].lstrip('//')
            lesson['title'] = i.find('a')['title']
        except:
            print('error')
    return lesson


url = 'https://jw.nju.edu.cn/ggtz/list.htm'
parentUrl = url[0:url.rfind('/')+1]
print(parentUrl)
strhtml = requests.get(url)  # Get方式获取网页数据
# print(strhtml.text)
soup = BeautifulSoup(strhtml.text, 'html.parser')

for n in range(1, 14):
    data = soup.select('#wp_news_w6 > ul > li.news.n' +
                       str(n)+'.clearfix > span.news_title')
    date = soup.select(
        '#wp_news_w6 > ul > li.news.n'+str(n)+'.clearfix > span.news_meta')
    l = getLesson(data)
    l["herf"] = parentUrl+l["herf"]
    l['date'] = date[0].text
    print(l)
