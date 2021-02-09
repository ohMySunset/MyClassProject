from flask import Flask

# 웹서버 생성
app = Flask(__name__) # main
print(__name__)

# URL Mapping
@app.route('/')
def index():
    return 'Hello~ Python'
    
@app.route("/hello")
def hello():
    return '<h1>/hello 요청의 응답입니다.</h1>'    

if __name__ == '__main__':
    app.run(debug=True, port=8000)