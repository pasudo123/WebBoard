
/** Load Event : 문서가 전체 로드되어 끝날 때 이벤트 발생 **/
window.onload = function(){
	initClickEvent();
};

function initClickEvent(){
	var doCancelBtn = document.querySelector('#cancelBtn');
	if(doCancelBtn)
		doCancelBtn.addEventListener('click', doCancel);
}

function doCancel(){
	history.back();
}