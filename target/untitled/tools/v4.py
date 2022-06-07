from selenium.webdriver.common.desired_capabilities import DesiredCapabilities
from selenium import webdriver
from bs4 import BeautifulSoup
import time


def is_Chinese(word):
    for ch in word:
        if '\u4e00' <= ch <= '\u9fff':
            return True
    return False


def findChineseTitle(s):

    cnt = 0
    s = s.text
    for i in range(0, len(s)):
        if is_Chinese(s[i]):
            cnt += 1
            if cnt > 5:
                return True
    return False


def strClean(s):

    s = s.replace('\n', '')
    s = s.replace(' ', '')

    return s


def getLesson2(i):
    lesson = {}
    lesson['title'] = None
    lesson['href'] = None
    try:
        #lesson['href'] = i.find('a')['href'].lstrip('//')
        #lesson['href'] = i.get('href')
        tempHref = i.get('href')
        if tempHref == None:
            lesson['href'] = i.find('a')['href'].lstrip('//')
        else:
            lesson['href'] = tempHref

        try:
            lesson['title'] = i.find('a')['title']
        except:
            lesson['title'] = strClean(
                str(i.find_all(findChineseTitle)[0].text))
    except:
        if lesson['title'] == None and lesson['href'] == None:
            lesson = getLesson2(i.parent)
        print('try again!')
    return lesson


#######################urls###############################
#url = 'https://jw.nju.edu.cn/ggtz/list.htm'
#url = 'https://xsxy.nju.edu.cn/sylm/ynxw/index.html'
#url=  'https://chin.nju.edu.cn//xyxw/index.html'
#url = 'https://es.nju.edu.cn/22448/list.htm'
#url = 'https://history.nju.edu.cn/28497/list.htm'
# url = 'https://philo.nju.edu.cn/4691/list.htm' #不行 number
#url = 'https://jc.nju.edu.cn/8596/list.htm'
url = 'https://law.nju.edu.cn/sy/tzgg/index.html'  # 不行 //丑陋通过
# url='https://nubs.nju.edu.cn/8876/list.htm'
# url='https://sfs.nju.edu.cn/10720/list.htm'
# url="https://cs.nju.edu.cn/1654/list.htm" #number
url = 'https://public.nju.edu.cn/sy/xyxw/index.html'  # 不行
url = 'https://sis.nju.edu.cn/46084/list.htm'
url = 'https://im.nju.edu.cn/xgxw/list.htm'
url = 'https://sociology.nju.edu.cn/17644/list.htm'
url = 'https://math.nju.edu.cn/fzlm/yxxw1/index.html'
url = 'https://physics.nju.edu.cn/xwgg/gg/index.html'
#url = 'https://astronomy.nju.edu.cn/twdt/tzgg/index.html'
###########################################################
driver = webdriver.PhantomJS(
    executable_path=r'D:/Programs/phantomjs-2.1.1-windows/bin/phantomjs.exe')
driver.set_window_size(2560, 1440)


dcap = dict(DesiredCapabilities.PHANTOMJS)  # 设置useragent
dcap["phantomjs.page.settings.userAgent"] = (
    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.9; rv:25.0) Gecko/20100101 Firefox/25.0 ")  # 根据需要设置具体的浏览器信息
driver = webdriver.PhantomJS(desired_capabilities=dcap)  # 封装浏览器信息

years = list(['2022', '2021', '2020'])
parentUrl = url[0:url.rfind('/')+1]
# print(parentUrl)
driver.get(url)  # Get方式获取网页数据
time.sleep(2)
try:
    driver.switch_to_default_content()
    frame = driver.find_elements_by_tag_name('iframe')[0]
    driver.switch_to_frame(frame)
except:
    print('error in #document')
# time.sleep(1)

#driver.page_source.encoding = driver.page_source.apparent_encoding

content = driver.page_source
print("\n\n\n\ncontent:\n", content)
soup = BeautifulSoup(content, 'html.parser')


def startWith(s, t):
    # 一个字符串s以t开头
    s = s.strip()
    if(len(s) >= len(t)):
        if s[0:len(t)] == t:
            for i in range(0, len(s)):
                if is_Chinese(s[i]):
                    return False
            return True
    return False
    # return s.find(t) != -1


for year in years:
    def findTimeTag(tag):
        return startWith(tag.text, year)
    tags = soup.find_all(findTimeTag)

    for i in tags:
        i = i.parent
        l = getLesson2(i)
        tag = i.find_all(findTimeTag)
        l['date'] = tag[0].text
        ###################使用数据时在这里添加代码##################

        ###########################################################
        print(l)

driver.quit()
