# -*- coding: utf-8 -*-
import logging
import logging.config
import csv

###################################
# 로그 생성
logging.config.fileConfig('logging.conf')
logger = logging.getLogger()

formatter = logging.Formatter('%(asctime)s %(levelname)s %(process)d %(message)s') 
data_log_handler = logging.FileHandler('shop_data.log')
data_log_handler.setFormatter(formatter)

logger.addHandler(data_log_handler)

logger.setLevel(logging.DEBUG)
###################################
line_counter = 0 # csv 파일의 총 행의 수
data_header = [] 
sample_list = []
insert_count = 0

insert_list = []

# 프로그램의 작업이 시작할 때 info
logger.info('Open file : {}'.format('07_24_05_p_1.csv'))

# 07_24_05_p_1.csv -> sample_list에 저장
try:
  with open('07_24_05_p_1.csv', encoding='cp949') as file:
     while True:
         data = file.readline().strip('\n')

         # 마지막 줄 -> 더이상 가져올 데이터가 없으면 None 반환 -> 반복문 탈출
         if not data:
             break

         if line_counter == 0: # header 저장
             data_header = data.split(',')
             print(data_header)
         else:
             insert_list = data.split(',')    
             #print(insert_list)
             # 1-> 영업중, 3-> 폐업, 커피숍, 서울지역       
             if insert_list[1] == '1' and insert_list[4] =='커피숍' and insert_list[2].find(u'서울특별시')!= -1:
                 sample_list.append(insert_list)
                 insert_count += 1
            
         line_counter += 1 
     print('데이터 처리 완료')

except FileNotFoundError as e:
    # 파일이 없는 경우 예외에 대한 로그 등록
    logger.error('File Not Found : {}'.format(e))

print('total-Count', line_counter)        
print('insert_count', insert_count)

for i in range(20):
    print('data-', i, ':', sample_list[i])

with open('new_shop_coffe_seoul_data.csv', 'w', encoding='utf8') as new_file:
    writer = csv.writer(new_file, delimiter='\t', quotechar="'", quoting=csv.QUOTE_ALL)

    # 헤더 쓰기
    writer.writerow(data_header)
    for row in sample_list:
        writer.writerow(row)
    print('쓰기 완료')   
    logger.info('write ok!') 

# 현재 영업중인 서울시에 위치한 커피숍에서 스타벅스만 찾아 저장
for shop in sample_list:
    if shop[3].find(u'스타벅스') != -1:
        insert_list.append(shop)


with open('new_coffee_star_data.csv', 'w', encoding='utf8') as star_file:
    for star_shop in insert_list:
        star_file.write(','.join(star_shop).strip('\n')+'\n')
    print('서울 스타벅스 리스트 파일 생성')
    logger.info('write ok!')

print('파일 작성이 완료되었습니다.')
logger.ingo('파일 작성 완료')    

for s_shop in insert_list:
    print(s_shop)    

    