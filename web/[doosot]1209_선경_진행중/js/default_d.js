// 카트 배열 이차원 배열로 만들었음, 작동은 하나 강사님한테 까임...ㅠㅜ


var toppingList = [];
var nowTabNum = 0; // 현재 선택된 탭번호
var nowItemNum = 0; // 현재 선택된 메뉴번호
var cartList = [];
var chooseCnt = 0; // 선택완료를 누른 횟수

window.onload = function () {
    // 메뉴 불러오기
    getItem();

    // 팝업창 제어 프로세스
    fnPopupProc();


    // 다른 부분 클릭 안되게 하기
    noClick();
};


/* 메뉴 불러오기 메서드 */
function getItem() {

    for (var i = 0; i < arrTabList.length; i++) {

        var menudata = JSON.parse(itemList[i]);
        var menuHtml = "";

        for (var j = 0; j < menudata.length; j++) {
            menuHtml += '<div class="menu" onclick = "javascript:addmenuOpen(' + i + ', ' + j + ');">';
            menuHtml += '<table>';
            menuHtml += '<tr>';
            menuHtml += '<td><img src="'
            menuHtml += menudata[j].src;
            menuHtml += '" width=200px height=200px></td></tr>'
            menuHtml += '<tr><td><a1>'
            menuHtml += menudata[j].name;
            menuHtml += '</a1></td></tr>'
            menuHtml += '<tr><td><a2>'
            menuHtml += menudata[j].price;
            menuHtml += '</a2></td></tr></table></div>'

            var div_sq = document.getElementById(arrTabList[i]);
            console.log(div_sq);
            div_sq.innerHTML = menuHtml;
        };
    };

};

/* [팝업창] 사이드 메뉴 불러오기 메서드 */
function getSidemenuItem(tabNum, itemNum) {


    var menudata = JSON.parse(itemList[tabNum]);

    // 현재 선택된 내역 저장 
    nowTabNum = tabNum;
    nowItemNum = itemNum;

    // 메뉴명, 이미지 넣기        
    $('#menu_name').text(menudata[itemNum].name);
    $("#view_img").attr("src", menudata[itemNum].src);
    // 음식 개수 1로 재셋팅
    $("input[name='pop_out']").val(1);

    // 토핑 데이터 가져오기(음료수 탭만 제외 )
    if (tabNum != 3) {
        var tabNum = 4;
        var menudata = JSON.parse(itemList[tabNum]);

        var menuHtml = '<h2>밥 추가 변경</h2>';

        for (var i = 0; i < 6; i++) {
            if (i == 3) {
                menuHtml += '<h2>토핑 추가</h2>';
            }
            menuHtml += '<div class="addmenu" id="addmenu' + i + '" onclick="javascript:fnEtcClick(' + tabNum + ', ' + i + ');"><a1>';
            menuHtml += menudata[i].name
            menuHtml += '</a1><br><a2>';
            menuHtml += menudata[i].price
            menuHtml += '</a2></div>'
        }

        console.log(menuHtml);


        var div_side = document.querySelector("#div_addmenu");
        div_side.innerHTML = menuHtml;
        $('#menuinfo').height("500px");

        // 음료수 탭인 경우     
    } else {
        var div_side = document.querySelector("#div_addmenu");
        div_side.innerHTML = '';
        $('#menuinfo').height("300px");
    }
    
};


// 메뉴탭 클릭시 메뉴목록 Display
function menulist(tabNum) {
    for (var i = 0; i < arrTabList.length; i++) {
        if (i == tabNum) {
            eval("document.querySelector('#" + arrTabList[i] + "').style.display = 'block';");
        } else {
            eval("document.querySelector('#" + arrTabList[i] + "').style.display = 'none';");
        }
    }
};

// 추가메뉴창 닫기 >> 제이쿼리로 변경
function addmenuClose() {
    document.querySelector('#menuinfo').style.display = 'none'
    document.querySelector('#addmenu1').style.border = '0px';

    // 클릭되게 하기
    okClick();

};

// [팝업창] 추가메뉴창 열기
function addmenuOpen(tabNum, itemNum) {

    // 팝업창 셋팅
    getSidemenuItem(tabNum, itemNum);

    // 팝업창 노출 
    document.querySelector('#menuinfo').style.display = 'block';


    // 다른 부분 클릭 안되게 하기
    noClick();
}


/*매장or포장*/
function takeout(takeout) {
    var takeout = takeout;
    console.log(takeout);
    document.querySelector('#takeout').style.display = 'none';

    // 클릭되게 하기
    okClick();
}

/*고른 음식 수량 선택*/
function fnCalCount(type, ths) {
    var $input = $(ths).parents("td").find("input[name='pop_out']");
    var tCount = Number($input.val());

    if (type == 'p') {
        $input.val(Number(tCount) + 1);

    } else {
        if (tCount > 1) $input.val(Number(tCount) - 1);
    }
}




/*카트에 담아둔 음식 삭제*/
// 나중에 데이터 삭제 추가해줘야함

function removeCart() {
    var chk = confirm('모두 삭제하시겠습니까?');

    if (chk) {
        removeHtml = '';
        var removecart = document.getElementById("addmenu_tbody");
        removecart.innerHTML = removeHtml;
        var removecart = document.getElementById("sum");
        removecart.innerHTML = removeHtml;
        
        cartList.splice(0,cartList.length);
        console.log(cartList);      
    }
};


// 장바구니 배열의 데이터 삭제
function delData(index) {

    var delChk = confirm('삭제하시겠습니까?');

    if (delChk) {
        cartList[index].splice(index, 1);
    }

    /*setCart();*/
    console.log('삭제 -->' + cartList);
};






// 토핑 클릭 
function fnEtcClick(tabNum, itemNum) {

    // 토핑인 경우 
    if (toppingList[itemNum] > 0) {
        // 이미 선택되어져 있는경우 선택 해제 
        $('#addmenu' + itemNum).css('border', '0px solid red');
        toppingList[itemNum] = 0;

    } else {
        // 선택 안되어 있는 경우 선택
        $('#addmenu' + itemNum).css('border', '3px solid red');
        toppingList[itemNum] = 1;
    }
}



// 팝업창 제어 프로세스
function fnPopupProc() {

    // 배열 초기화
    popSelect.length = 0;

    // 선택완료 버튼 클릭
    $('#addmenuSubmit').click(function () {



        // 클릭되게 하기
        okClick();

        // 메인 메뉴 
        popSelect.push({
            tabNum: nowTabNum,
            itemNum: nowItemNum,
            cnt: $("input[name='pop_out']").val()
        });

        // 음료수탭 제외 


        for (var i = 0; i < 6; i++) {

            // 토핑 선택한 경우에만 데이터 저장
            if (toppingList[i] == 1) {
                popSelect.push({
                    tabNum: 4,
                    itemNum: i,
                    cnt: 1
                });
            } else {
                popSelect.push({
                    tabNum: 4,
                    itemNum: i,
                    cnt: 0
                });
            }

        }


        console.log(popSelect);

        // cartList에 지금 선택한 메뉴를 넣어줌
        cartList[chooseCnt] = popSelect;
        // 선택횟수 ++;
        chooseCnt++;
        // 배열비워줌
        popSelect = [];


        // !!-------확인용 나중에 지울 것-----!!
        show_cart();

        $('#menuinfo').css('display', 'none');

        for (var i = 0; i < 6; i++) {
            $('#addmenu' + i).css('border', '0px solid red');
            toppingList[i] = 0;
        }

        setCart();
        
    });



    // 추가메뉴창 닫기
    $('#addmenuClose').click(function () {
        $('#menuinfo').css('display', 'none');

        for (var i = 0; i < 6; i++) {
            $('#addmenu' + i).css('border', '0px solid red');
            toppingList[i] = 0;
        }


        // 클릭되게 하기
        okClick();

    });

}


// 팝업뜨면 바탕에 다른 메뉴 클릭 못하게하기
function noClick() {
    $('#bowl').addClass('clicknone');
    $('#square').addClass('clicknone');
    $('#side').addClass('clicknone');
    $('#beverage').addClass('clicknone');
    $('.menuselect >button').addClass('clicknone');
    $('.cart').addClass('clicknone');
}

// 팝업창 닫으면 클릭되게 하기
function okClick() {
    $('#bowl').removeClass('clicknone');
    $('#square').removeClass('clicknone');
    $('#side').removeClass('clicknone');
    $('#beverage').removeClass('clicknone');
    $('.menuselect >button').removeClass('clicknone');
    $('.cart').removeClass('clicknone');

}



/* 장바구니에 리스트업 메서드*/
function setCart (popselect){
    
     var addmenu_tbody = document.querySelector('#addmenu_tbody');
   
      console.log(addmenu_tbody);
      
        var tbody = '';
      
    for(var i=0;i<cartList.length;i++){
        
        var menudata = JSON.parse(itemList[cartList[i][0].tabNum]); 
        
        //토핑이 아니고 메뉴일 때만 출력
    // if(popSelect[i].tabNum !=4){  s
        
        tbody +='<td rowspan="2"><img src="'+menudata[cartList[i][0].itemNum].src+'"></td>';
        tbody +='<td colspan="3"><a1>'+menudata[cartList[i][0].itemNum].name+'</a1></td>';
        tbody +='</tr>';
        tbody +='<tr class="trline">';
        tbody +='<td><a2>'+menudata[cartList[i][0].itemNum].price+'</a2></td>';
        tbody +='<td>';
        tbody +='<input type="button" value="◀" onclick="cartCount("m", this);">';
        tbody +='<input type="text" value="'+cartList[i][0].cnt+'" name="cartCnt" class="cartText" style="width:20px;">';
         console.log(cartList[i][0].cnt);
        tbody +='<input type="button" value="▶" onclick="cartCount("p", this);">';
        tbody +='</td>';
        tbody +='<td><input type="button" class="cancel" value="삭제" onclick="javascript:delData('+i+');"></td>';
        tbody +='</tr>';
     
        var sidedata = JSON.parse(itemList[4]);
        
      for(var j=1; j<7; j++){
       if (cartList[i][j].cnt != 0) {
        tbody +='<tr>';
        tbody +='<td class="sidemenu_show" colspan="4">';
        tbody +='<ul>';         
        tbody +='<li>';  
        tbody +='<a1>'+sidedata[cartList[i][j].itemNum].name+'</a1>';
        tbody +='<a1>'+sidedata[cartList[i][j].itemNum].price+'</a1>';
        tbody +='</li>';
        tbody +='</ul>';
        tbody +='</td>';
        tbody +='</tr>';  
            }
      }
        
    }
        console.log(tbody);
        addmenu_tbody.innerHTML = tbody;
    
    console.log(cartList);
       
};







function show_cart(popSelect) {
    console.log('배열은');
    console.log(cartList);
    console.log(cartList[0][0].tabNum); // 메뉴의 종류
    console.log(cartList[0][0].itemNum); // 메뉴찾기
    console.log(cartList[0][0].cnt); // 메뉴 갯수

    // 메뉴의 종류 : itemList[cartList[0][0].tabNum
    // var menudata = JSON.parse(itemList[cartList[0][0].tabNum]);
    var sidedata = JSON.parse(itemList[4]);

    // 메뉴의 이름 : menudata[cartList[0][0].itemNum].name
    // console.log(menudata[cartList[0][0].itemNum].name);
    // 메뉴의 가격 : menudata[cartList[0][0].itemNum].price
    // console.log(menudata[cartList[0][0].itemNum].price);
    // 메뉴 갯수 :
    // console.log(cartList[0][0].cnt);
    // 메뉴 사진 :
    // console.log(menudata[cartList[0][0].itemNum].src);


    for (var i = 0; i < cartList.length; i++) {

        var menudata = JSON.parse(itemList[cartList[i][0].tabNum]);

        console.log('-------' + i + '번째 메뉴시작---------');
        console.log(menudata[cartList[i][0].itemNum].name);
        console.log(menudata[cartList[i][0].itemNum].src);
        console.log(menudata[cartList[i][0].itemNum].price);
        console.log(cartList[i][0].cnt);


        for (var j = 1; j < 7; j++) {
            if (cartList[i][j].cnt != 0) {
                console.log(sidedata[cartList[i][j].itemNum].name);
                console.log(sidedata[cartList[i][j].itemNum].price);

            }
        }


        console.log('----------메뉴하나끝----------');
    }

}




//장바구니 창 음식 수량 선택
/*$('.warp').on('click' ,'#m', function(){
    console.log('버튼 작동');
    
    var minus = $(this).parents("td").find('input[name="cartCnt"]');

    
})*/


function cartCount(type,ths){
    var $input = $(ths).parents("td").find('input[name="cartCnt"]');
    var tCount = Number($input.val());
    if (type == 'p') {
        $input.val(Number(tCount) + 1);

    } else {
        if (tCount > 1) $input.val(Number(tCount) - 1);
    }
}


/*
function fnCalCount(type, ths) {
    var $input = $(ths).parents("td").find("input[name='pop_out']");
    var tCount = Number($input.val());

    if (type == 'p') {
        $input.val(Number(tCount) + 1);

    } else {
        if (tCount > 1) $input.val(Number(tCount) - 1);
    }
}*/