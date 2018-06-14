
/** Load Event : 문서가 전체 로드되어 끝날 때 이벤트 발생 **/
window.onload = function(){
	initClickEvent();
};

function initClickEvent(){
	var doWriteBtn = document.querySelector('#doWriteBtn');
	if(doWriteBtn)
		doWriteBtn.addEventListener('click', doWrite);
}

function doWrite(){
	location.href = "./write";
}