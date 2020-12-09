var toppingList = [];
var nowTabNum = 0;      // 현재 선택된 탭번호
var nowItemNum = 0;    // 현재 선택된 메뉴번호

window.onload = function () {
    // 메뉴 불러오기
    getItem();     
    
    // 팝업창 제어 프로세스
    fnPopupProc();  
  
};



// 장바구니 메뉴 배열 생성
var cart = [];

// 생성자 
function Cart(name, price, img, cnt) {
    this.menuName = name;
    this.menuPrice = price;
    this.menuImg = img;
    this.menuCnt = cnt;
 //   this.toName = toName;
 //  this.toPrice = toPrice;
}

// 장바구니 메뉴영역 HTML
Cart.prototype.makeHtml_menu = function() {

     console.log(this.menuName + ' : ' + this.menuPrice +':' + this.menuImg + ':' + this.menuCnt/*+':'+ this.toName +':'+ this.toPrice*/);
    
        
        var html = '';
        html +='<td rowspan="2"><img src="'+this.menuImg+'"></td>';
        html +='<td colspan="3"><a1>'+ this.menuName+'</a1></td>';
        html +='</tr>';
        html +='<tr class="trline">';
        html +='<td><a2>'+this.menuPrice+'</a2></td>';
        html +='<td><a3>'+this.menuCnt+'</a3></td>';
        html +='<td><input type="button" class="cancel" value="삭제"></td>';
        html +='</tr>';

       return html;
     };

var cart_topping = [];

function Topping(name, price){
    this.toName = name;
    this.toPrice = price;
}

// 장바구니 토핑영역 HTML
Topping.prototype.makeHtml_topping = function(){
    
    var tohtml = '';
    
        tohtml +='<tr>';
        tohtml +='<td class="sidemenu_show" colspan="4">';
        tohtml +='<ul>';        
        tohtml +='<li>';  
        tohtml +='<a1>'+this.toName+'</a1>';
        tohtml +='<a2>'+this.toPrice+'</a2>'; 
        tohtml +='</li>';                                                                       
        tohtml +='</ul>';
        tohtml +='</td>';
        tohtml +='</tr>';
    
    return tohtml;    
}



/* 메뉴 불러오기 메서드 */
function getItem() {

    for(var i = 0; i < arrTabList.length; i++){

        var menudata = JSON.parse(itemList[i]);
        var menuHtml = "";
   
        for (var j = 0; j < menudata.length; j++) {
            menuHtml += '<div class="menu" onclick = "javascript:addmenuOpen(' + i +', ' + j + ');">';
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

    var menudata_1 = JSON.parse(itemList[tabNum]);

    // 현재 선택된 내역 저장 
    nowTabNum = tabNum;     
    nowItemNum = itemNum; 
    
    // 메뉴명, 이미지 넣기        
    $('#menu_name').text(menudata_1[itemNum].name);
    $("#view_img").attr("src", menudata_1[itemNum].src);
    // 음식 개수 1로 재셋팅
    $("input[name='pop_out']").val(1);
   
    
    // 토핑 데이터 가져오기(음료수 탭만 제외 )
    if(tabNum != 3){    
        var tabNum = 4; 
        var menudata = JSON.parse(itemList[tabNum]);

        var menuHtml = '<h2>밥 추가 변경</h2>';

        for (var i = 0; i < 6; i++) {
            if(i == 3){
                menuHtml += '<h2>토핑 추가</h2>';
            }
            menuHtml += '<div class="addmenu" id="addmenu' + i + '" onclick="javascript:fnEtcClick(' + tabNum + ', ' + i + ');"><a1>';
            menuHtml += menudata_2[i].name
            menuHtml += '</a1><br><a2>';
            menuHtml += menudata_2[i].price
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
    
    
    
     $('#addmenuSubmit').click(function() {

    //html형식으로 배열에 저장
         
     var cartInputMenu = new Cart(menudata_1[itemNum].name, menudata_1[itemNum].price, menudata_1[itemNum].src,$('#pop_out').val());
         
     var cartInputTop = new Topping(menudata[itemNum].name, menudata[itemNum].price);
         
     cartInputMenu.makeHtml_menu();
     cartInputTop.makeHtml_topping();    
    
     cart.push(cartInputMenu);
     cart_topping.push(cartInputTop);     
       
     document.querySelector('.cartform').reset();
         
     setCart(); 
            
     });
        
};


// 메뉴탭 클릭시 메뉴목록 Display
function menulist(tabNum){
    for(var i = 0; i < arrTabList.length; i++){
        if(i == tabNum){
            eval("document.querySelector('#" + arrTabList[i] + "').style.display = 'block';");
        }else {
            eval("document.querySelector('#" + arrTabList[i] + "').style.display = 'none';");
        }                
    }
};

// 추가메뉴창 닫기 >> 제이쿼리로 변경
function addmenuClose() {
    document.querySelector('#menuinfo').style.display = 'none'
    document.querySelector('#addmenu1').style.border= '0px';
    
};

// [팝업창] 추가메뉴창 열기
function addmenuOpen(tabNum, itemNum) {
    
    // 팝업창 셋팅
    getSidemenuItem(tabNum, itemNum);    
    
    // 팝업창 노출 
    document.querySelector('#menuinfo').style.display = 'block';
}


/*매장or포장*/
function takeout(takeout) {
    var takeout = takeout;
    console.log(takeout);
    document.querySelector('#takeout').style.display = 'none';
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



 /* 장바구니에 리스트업 메서드*/
  function setCart(){
      
     var addmenu_tbody = document.querySelector('#addmenu_tbody');
    

      console.log(addmenu_tbody);
      
        var tbody = '';
      
    for(var i=0;i<cart.length;i++){
    
        tbody +='<td rowspan="2"><img src="'+cart[i].menuImg+'"></td>';
        tbody +='<td colspan="3"><a1>'+cart[i].menuName+'</a1></td>';
        tbody +='</tr>';
        tbody +='<tr class="trline">';
        tbody +='<td><a2>'+cart[i].menuPrice+'</a2></td>';
        tbody +='<td><a3>'+cart[i].menuCnt+'</a3></td>';
        tbody +='<td><input type="button" class="cancel" value="삭제"></td>';
        tbody +='</tr>';
     }
      for(var j=0;j<cart_topping.length;j++){
        tbody +='<tr>';
        tbody +='<td class="sidemenu_show" colspan="4">';
        tbody +='<ul>';          
        tbody +='<li>';  
        tbody +='<a1>'+cart_topping[j].toName+'</a1>';
        tbody +='<a2>'+cart_topping[j].toPrice+'</a2>'; 
        tbody +='</li>';
        tbody +='</ul>';
        tbody +='</td>';
      }
  
        console.log(tbody);
        addmenu_tbody.innerHTML = tbody;  
          
        console.log(cart);
        console.log(cart_topping);  
    
};





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
        
    }
};


// 토핑 클릭 
function fnEtcClick(tabNum, itemNum){

    // 토핑인 경우 
    if(toppingList[itemNum] > 0){    
        // 이미 선택되어져 있는경우 선택 해제 
        $('#addmenu' + itemNum).css('border', '0px solid red');
        toppingList[itemNum] = 0;

    }else {
        // 선택 안되어 있는 경우 선택
        $('#addmenu' + itemNum).css('border', '3px solid red');
        toppingList[itemNum] = 1;
    } 
}


// 팝업창 제어 프로세스
function fnPopupProc(){

  
    // 선택완료 버튼 클릭
    $('#addmenuSubmit').click(function() {

    // 배열 초기화
    popSelect.length = 0; 
        
        // 메인 메뉴 
        popSelect.push(
            { tabNum:nowTabNum, itemNum:nowItemNum, cnt:$("input[name='pop_out']").val() }
        );
             
        // 음료수탭 제외 
        if(nowTabNum != 3){ 
           
            for (var i = 0; i < 6; i++) {
                
                // 토핑 선택한 경우에만 데이터 저장
                if(toppingList[i] == 1){
                    popSelect.push(
                        { tabNum:4, itemNum:i, cnt:1 }
                    );                  
                }
                
            }
        }
         
        console.log(popSelect)
        
        $('#menuinfo').css('display', 'none');

        for (var i = 0; i < 6; i++) {
            $('#addmenu' + i).css('border', '0px solid red');
            toppingList[i] = 0;
        }

    });   
    
    // 추가메뉴창 닫기
    $('#addmenuClose').click(function() {
        
    // 배열 초기화
    popSelect.length = 0;
        
        $('#menuinfo').css('display', 'none');

        for (var i = 0; i < 6; i++) {
            $('#addmenu' + i).css('border', '0px solid red');
            toppingList[i] = 0;
        }

    });    
}


