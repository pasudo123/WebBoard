
/** Load Event : 문서가 전체 로드되어 끝날 때 이벤트 발생 **/
window.onload = function(){
	initClickEvent();
	initPagePosition();
};

function initClickEvent(){
	
	var showContentBtnList = document.querySelectorAll('.tableColumnData');
	if(showContentBtnList){
		for(var i = 0; i < showContentBtnList.length; i++){
			showContentBtnList[i].addEventListener('click', showContent);
		}
	}
	
	var doDeleteBtn = document.querySelector('#deleteBtn');
	if(doDeleteBtn)
		doDeleteBtn.addEventListener('click', doDelete);
	
	var doCancelBtn = document.querySelector('#cancelBtn');
	if(doCancelBtn)
		doCancelBtn.addEventListener('click', doHistoryBack);
	
	var doShowListBtn = document.querySelector('#showListBtn');
	if(doShowListBtn)
		doShowListBtn.addEventListener('click', doHistoryBack);
}

// 현재 페이지 색깔 입히기
function initPagePosition(){
	var requestURL = window.location.href;
	var slashesArray = requestURL.split("/");
	var pagePosition = slashesArray[slashesArray.length-1];
	
	console.log(pagePosition);
	var aTag = document.querySelector("#pagePos" + pagePosition);
	if(aTag)
		aTag.style["background-color"]="#bacced";
}

function doHistoryBack(){
	history.back();
}	

function doRefererBack(){
	var refererURL = document.querySelector('#refererURL');
	
	console.log(refererURL);
	return;
	location.href = refererURL;
}

function doDelete(){
	var pkn = 0;
	var currentURL = (window.location);
	
	console.log(currentURL);
	console.log(currentURL.href.split("/"));
	
	var urlElement = currentURL.href.split("/");
	pkn = urlElement[urlElement.length-1];
	
	location.href = "../delete?pkn=" + pkn;
}

function showContent(){
	var tdList = this.querySelectorAll('td');
	var pkn = tdList[0].innerText;
	
	console.log("pkn : " + pkn);
	location.href = "../content/" + pkn;
}