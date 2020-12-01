


window.onload = function(){
 //  alert('외부 스크립트 파일에서 로드');  
}

// 도서 정보 저장할 배열
var booklist = [];

//console.log(booklist);

// 생성자 함수
function Books(id, name, pub){
    this.bookid = id;
    this.bookname = name;
    this.publis = pub;
    
}

// 리스트 값을 HTML양식에 따라 만들기
Books.prototype.makeHtml = function(index){
    
  console.log(this.bookid + ' : ' + this.bookname + ' : ' + this.publis);
   
 var bookHtml = '';
 bookHtml += '<tr>';
 bookHtml += '<th>' + index + '</th>';
 bookHtml += '<th>' + this.bookid + '</th>';
 bookHtml += '<th>' + this.bookname + '</th>';
 bookHtml += '<th>' + this.publis + '</th>';
 bookHtml += '<th><a href="javascript:delbook('+index+');">수정/</a><a>삭제</a></th>'; 
 bookHtml += '</tr>';
    
 return bookHtml; 
}


function regbooks (){
    
    // 사용자가 입력한 데이터를 확인
    // 유효성 검사
    // 사용자 정보를 저장하는 객체를 생성
    
    
    //도큐먼트 객체로 불러오기
   var bookid = document.querySelector('#bookid');
   var bookname = document.querySelector('#bookname'); 
   var publis = document.querySelector('#publis'); 
    
    var check = false; //문제가 없을 때
    
    //유효성 검사
    if(bookid.value.trim().length<1){
       document.querySelector('#bookid+div.msg').style.display ='block';
        check='true';
    }
    if(bookname.value.trim().length<1){
        document.querySelector('#bookname+div.msg').style.display ='block';
         check='true';
    }
     if(publis.value.trim().length<1){
        document.querySelector('#publis+div.msg').style.display ='block';
          check='true';
    }
    
    
    //이벤트 객체 추가 : 오입력 시 입력칸을 빈칸으로 만들고 focus
    bookid.addEventListener('focus', function() {
        document.querySelector('#bookid+div.msg').style.display = 'none';
        bookid.value='';
    })
    bookname.addEventListener('focus', function() {
        document.querySelector('#bookname+div.msg').style.display = 'none';
        bookname.value='';
    })
    publis.addEventListener('focus', function() {
        document.querySelector('#publis+div.msg').style.display = 'none';
        publis.value='';
    })
    
    console.log(check);
    
    //입력 오류일 시 리턴 false
    if(check){
        return false;
    }
    //정상 입력 시 처리  -> 생성자에 받은 값을 넣어주고, makeHtml()함수를 호출하여 HTML형식으로 데이터 입력
     var bookinput = new Books(bookid.value, bookname.value, publis.value);
     bookinput.makeHtml();

    //리스트에 정보 저장
     booklist.push(bookinput);

     console.log('bookinput :', bookinput); //데이터 확인
    
   document.querySelector('.regform').reset();

    alert('등록되었습니다.');
    
    setlist();
 
    return false;
    
}


function setlist(){
    
   var b_list = document.querySelector('.b_list');
    
   var tbody = '<tr>';
       tbody += '<th>No.</th>';
       tbody += '<th>도서번호</th>';
       tbody += '<th>도서명</th>';
       tbody += '<th>출판사</th>';
       tbody += '<th>관리</th>';
       tbody += '</tr>';
    
    for(var i=0; i<booklist.length;i++){
    
 tbody += '<tr>';
 tbody += '<td>' + i + '</td>';
 tbody += '<td>' + booklist[i].bookid + '</td>';
 tbody += '<td>' + booklist[i].bookname + '</td>';
 tbody += '<td>' + booklist[i].publis + '</td>';
 tbody += '<td><a href="javascript:delbook('+i+');">수정/</a><a>삭제</a></td>';
 tbody += '</tr>';
    }
    
    b_list.innerHTML = tbody;
}


function delbook(index){
    
    var chk = confirm('정말 삭제하시겠습니까?');
    
    if(chk){
        
        booklist.splice(index,1);
    }
    alert('삭제되었습니다.');
    
    setlist();
}