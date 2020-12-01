/*
function load(){
    alert('외부 스크립트 파일에서 로드');   
}
*/




// ※local storage에 저장해야 할 대상 (object-> JSON을 사용하여 자바스크립트 형태의 문자열로 변환)
// 배열도 객체다!
// 프로그램이 시작할 때 read -> 저장 (바뀐 데이터 save) -> 수정 (바뀐 데이터 save) -> 삭제 (바뀐 데이터 save)  즉, 변경이 일어난 배열만 저장해주면 됨.

//회원 정보 멤버 객체들을 저장하는 배열
var members = [];



// 생성자 함수 Member
function Member(id, pw, name) {
    this.userid = id;
    this.userpw = pw;
    this.username = name;
}

Member.prototype.makeHtml = function (index) {
   console.log(this.userid + ' : ' + this.userpw + ' : ' + this.username);

 
    
//테이블 양식에 맞춰 배열의 요소를 넣어줌
var memberHtml ='';
memberHtml += '<tr>';
memberHtml += '<td>'+index+'</td>';
memberHtml += '<td>'+this.userid+'</td>';
memberHtml += '<td>'+this.userpw+'</td>';
memberHtml += '<td>'+this.username+'</td>';
memberHtml +=  '<td><a href="javascript:editmember('+index+')">수정</a><a href="javascript:delmember('+index+')">삭제</a></td>';
memberHtml += '</tr>';
return memberHtml;
    
}



window.onload = function () {

    // localstorage에 저장하는 키는 -> members
    // 저장 값이 없으면 null을 반환
    if(localStorage.getItem('members')==null){
        // 배열 초기값을 저장 (최초 저장) : 배열을 문자열로 변경하여 저장.
        localStorage.setItem('members', JSON.stringify(members));
    } else{
        members = JSON.parse(localStorage.getItem('members'));
        setlist();
    }
    
    
}




function regmember() {
    // 사용자가 입력한 데이터를 확인
    // 유효성 검사
    // 사용자 정보를 저장하는 객체를 생성

    //아이디
    var userid = document.querySelector('#userid');
    //비밀번호
    var pw = document.getElementById('pw');
    //비밀번호 확인
    var repw = document.getElementById('repw');
    //이름
    var username = document.querySelector('#username');

    var check = false; //문제가 없다면


    //공백문자를 검사
    if (userid.value.trim().length < 1) {
        document.querySelector('#userid+div.msg').style.display = 'block';
        check = true;
    }
    if (pw.value.trim().length < 1) {
        document.querySelector('#pw+div.msg').style.display = 'block';
        check = true;
    }
    if (repw.value.trim().length < 1 || pw.value != repw.value) {
        document.querySelector('#repw+div.msg').style.display = 'block';
        check = true;
    }
    if (username.value.trim().length < 1) {
        document.querySelector('#username+div.msg').style.display = 'block';
        check = true;
    }

    /*      userid.onfocus = function(){
 document.querySelector('#userid+div.msg').style.display='none'; } */





    userid.addEventListener('focus', function () {
        document.querySelector('#userid+div.msg').style.display = 'none';
        userid.value = '';

    });


    pw.addEventListener('focus', function () {
        document.querySelector('#pw+div.msg').style.display = 'none';
        pw.value = '';

    });

    repw.addEventListener('focus', function () {
        document.querySelector('#repw+div.msg').style.display = 'none';
        repw.value = '';

    });

    username.addEventListener('focus', function () {
        document.querySelector('#username+div.msg').style.display = 'none';
        username.value = '';

    });

    console.log(check);

    if (check) {
        return false;
    }
    /* else {
       var member = {
           memberid : userid.value,
           pw: pw.value,
           membername : username.value
       };
     }*/

    var member = new Member(userid.value, pw.value, username.value);
    member.makeHtml();

    //배열에 회원 정보를 저장(추가)
    members.push(member);
    
    console.log('members :', members);
    //  console.log('member',member);
    
    document.querySelector('#regform').reset();
    
    alert('등록되었습니다.');

    
    // localstorage에 저장
    localStorage.setItem('members', JSON.stringify(members));
    
    //리스트 갱신
    setlist();

    return false;
}


function setlist(){
    //table tbody 캐스팅
    var listrow = document.querySelector('#listrow');
    
    var tbody = '<tr>';
        tbody += '<th>순번(index)</th>';
        tbody +=  '<th>아이디</th>';
        tbody +=  '<th>비밀번호</th>';
        tbody += '<th>이름</th>';
        tbody +=  '<th>관리</th>';
        tbody +=  '</tr>' ;
   
    for(var i=0;i<members.length;i++){
    //   tbody += members[i].makeHtml(i);
        
        tbody += '<tr>';
        tbody += '<th>'+i+'</th>';
        tbody += '<th>'+members[i].userid+'</th>';
        tbody += '<th>'+members[i].userpw+'</th>';
        tbody += '<th>'+members[i].username+'</th>';
        tbody += '<th><a href="javascript:editmember('+i+')">수정</a><a href="javascript:delmember('+i+')">삭제</a></th>';
        tbody +=  '</tr>' ;
        
    }
    
    listrow.innerHTML = tbody;
}


//배열의 데이터를 삭제
function delmember(index){
    
    var delChk = confirm('삭제하시겠습니까?');
    
    if(delChk){
        //삭제 -> 배열에서 요소를 삭제
     members.splice(index,1)
          
         // localstorage에 저장
         localStorage.setItem('members', JSON.stringify(members));
        
           alert('삭제되었습니다.');

         //배열의 변경된 내용으로 리스트 출력
         setlist();
    }
}



//배열의 데이터를 수정
function editmember(index){    
    console.log(members[index]);
    
    //수정 화면 casting
    var edit_div = document.querySelector('#edit_div');
    // 화면에서 감추기 (css에서도 처리)
    edit_div.style.display='block';
    
    //form안에 있는 input들을 캐스팅
    //id 
    var eid = document.querySelector('#editid');
    //name
    var ename = document.querySelector('#editname');
    //pw
    var epw = document.querySelector('#editpw');
    //repw
     var erepw = document.querySelector('#editrepw');
    //index
    var idx = document.querySelector('#index');
    
    idx.value = index;
    eid.value = members[index].userid;
    ename.value = members[index].username;
    epw.value = members[index].userpw;
    erepw.value = members[index].userpw;
    
    
}


function editMemberClose(){
     var edit_div = document.querySelector('#edit_div');
    edit_div.style.display='none';
}


function editMemberData(){
    //index -> 바꾸고자 하는 데이터의 위치
    var eidx = document.querySelector('#index').value;
    //id
    //var eid = document.querySelector('#editid');
    //pw
    var epw = document.querySelector('#editpw');     
    //repw
    var erepw = document.querySelector('#editrepw');
    //name
    var ename = document.querySelector('#editname');
    
    
    //editpw -> msg 캐스팅
    
    var pw_msg = document.querySelector('#editpw+div.msg');
    var repw_msg = document.querySelector('#editrepw+div.msg');
    var ename_msg = document.querySelector('#editname+div.msg');
    
   var check = false; //문제가 없다면


    //공백문자를 검사
    if (epw.value.trim().length < 1) {
        pw_msg.style.display = 'block';
        check = true;
    }
    if (erepw.value.trim().length < 1 || pw.value != repw.value) {
        repw_msg.style.display = 'block';
        check = true;
    }
    if (ename.value.trim().length < 1) {
        ename_msg.style.display = 'block';
        check = true;
    }

    epw.addEventListener('focus', function () {
        pw_msg.style.display = 'none';
        epw.value = '';
        
    });

    erepw.addEventListener('focus', function () {
        repw_msg.style.display = 'none';
        erepw.value = '';

    });

   ename.addEventListener('focus', function () {
        ename_msg.style.display = 'none';
        ename.value = '';

    });

    console.log(check);

    if (check) {
        return false;
    }
    
    //members[index] -> pw,name만 변경
    members[eidx].username = ename.value.trim();
    members[eidx].userpw = epw.value;
 
    // localstorage에 저장
         localStorage.setItem('members', JSON.stringify(members));
    
    alert('수정되었습니다.');
    
    
    //회원 리스트 갱신
    setlist();
    
     // 폼 캐스팅
    document.querySelector('#editform').reset();
    document.querySelector('#edit_div').style.display='none';
    
    return false;
}

