from urllib.parse import quote_plus    # 한글 텍스트를 퍼센트 인코딩으로 변환
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait   # 해당 태그를 기다림
from selenium.webdriver.support import expected_conditions as EC
from selenium.common.exceptions import TimeoutException    # 태그가 없는 예외 처리
import time
import pandas as pd


loc_key=[ '이태원', '가로수길', '연남동', '잠실', '청담', '압구정', '합정', '건대', '성수동', '을지로', '한남동', '여의도', '논현동' ,'영등포', 
'왕십리', '대학로', '인사동', '삼청동', '광화문', '명동', '강남역', '신도림', '사당', '동대문', '노원역', '성신여대', '연신내','천호']


results=[]


for j in loc_key:
    url = f'https://search.naver.com/search.naver?sm=tab_hty.top&where=nexearch&query={j}+놀거리'
    chromedriver ='/Users/Lenovo/AppData/Local/Programs/Python/Python37/chromedriver'

    options = webdriver.ChromeOptions()
    options.add_argument('headless')    # 웹 브라우저를 띄우지 않는 headlss chrome 옵션 적용
    options.add_argument('disable-gpu')    # GPU 사용 안함
    options.add_argument('lang=ko_KR')    # 언어 설정
    driver = webdriver.Chrome(chromedriver, options=options)

    driver.get(url)

    try:    # 정상 처리
        element = WebDriverWait(driver, 3).until(
            EC.presence_of_element_located((By.CLASS_NAME, '_2pag2'))
        )    # 해당 태그 존재 여부를 확인하기까지 3초 정지
      
        for i in range(0,5):
            activity_name = driver.find_elements_by_class_name('_2pag2')[i].text
            activity_feature=driver.find_elements_by_class_name('_3lc1U')[i].text
            aa=[activity_name,activity_feature,j]
            results.append(aa)

   
    
     

        

    except TimeoutException:    # 예외 처리
        print('해당 페이지에 정보가 존재하지 않습니다.')

    finally:    # 정상, 예외 둘 중 하나여도 반드시 실행
        driver.quit()

        

df = pd.DataFrame(results)
df.columns = ['activity_name', 'location_feature','hotplace']
df.to_csv("activity_data.csv", header=True, index=None, encoding="utf-8-sig")



print('웹 크롤링이 완료되었습니다.')
