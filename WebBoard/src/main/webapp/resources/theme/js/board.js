
/** Load Event : 문서가 전체 로드되어 끝날 때 이벤트 발생 **/
window.onload = function(){
	initClickEvent();
};

function initClickEvent(){
	
	var showContentBtnList = document.querySelectorAll('.tableColumnData');
	if(showContentBtnList){
		for(var i = 0; i < showContentBtnList.length; i++){
			showContentBtnList[i].addEventListener('click', showContent);
		}
	}
	
	var doCancelBtn = document.querySelector('#cancelBtn');
	if(doCancelBtn)
		doCancelBtn.addEventListener('click', doCancel);
}

function doCancel(){
	history.back();
}

function showContent(){
	var tdList = this.querySelectorAll('td');
	var pkn = tdList[0].innerText;
	console.log("pkn : " + pkn);
	
	location.href="./list/" + pkn;
}