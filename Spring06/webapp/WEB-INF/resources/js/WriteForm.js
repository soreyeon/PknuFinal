/**
 * 
 */

function inputCheck() {
	var writer = document.getElementById('writer');
	if(writer.value.trim().length == 0) {
		alert('작성자를 입력하세요');
		return false;
	}
	var title = document.getElementById('title');
	if(title.value == '') {
		alert('제목을 입력하세요');
		return false;
	}
	var cont = document.getElementById('cont');
	if(cont.value == '') {
		alert('내용을 입력하세요');
		return false;
	}
	return true;
	
}

window.onload = function() {
	alert('first');

	var frm = document.querySelector('#frmWrite');
	
	var btn4 = document.getElementById('btn4');
	
	btn4.onclick = function() {
		//frm.action = 'a.jsp';
		var result = inputCheck();
		if(result == true){
			frm.submit(); //submit이벤트를 발생시키지 않고 바로 무조건 submit 된다.			
		}
	}
	
	/*frm.onsubmit = function() {
		alert('submit');
		var result = inputCheck();
		if(result == false) {
			e.preventDefault();
			e.stopPropagation();
		}
		return result;
	}*/
	
	frm.addEventListener('submit', function() {
		alert('submit');
		var result = inputCheck();
		if(result == false) {
			e.preventDefault();
			e.stopPropagation();
		}
		return result;
	})
}