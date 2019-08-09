<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>InsertMenu</title>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script>
$(function(){
	$('#selectMenu').click(function(){
		var mn_gbn_name = "";
			
		if($('#mn_gbn').val() == '관리자'){
			 mn_gbn_name = 'GBN01'	
		} else{
			if($('#mn_gbn').val() == '기사'){
				 mn_gbn_name = 'GBN02'
			}else{
				if($('#mn_gbn').val() == '고객'){
					mn_gbn_name = 'GBN03'
				}
			}
		}
		
		$('[name=mn_gbn]').val($('#mn_gbn').val()); 
		
		$.ajax({
            url  : '/selectMenuButton',
            type : 'POST',
            data : {
            	mn_gbn : mn_gbn_name
            	},
            dataType : 'json',
            success : function(data) {
            	$('#menubar').html('');
            	var data_len = Object.keys(data).length;
         		for(i = 0; i < data_len ; i++ ){
         			$('#menubar').append('<div class="menuClass" id="menu'  + i + '"><div>'); 
         			$('#menu'+i).append('<input type="checkbox" name="RowCheck" value="'+data[i].mn_id+'" />'); 
        			$('#menu'+i).append('메뉴이름 : <input type="text" value="'+data[i].mn_name+'"/><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>');
        			$('#menu'+i).append('url : <input type="text" name="MNUrl" value="'+data[i].mn_url+'" />'); 
         		}
        		$('#deleteSpace').html('<input type="button" id="btnDelete" value="메뉴 삭제하기" />')
            },
            error  : function(xhr){
               alert(xhr.status + ':' + xhr.statusText)
               }
            });// AJAX END
	});	// btnInsert END
});


	$(function(){
		$('#btnInsert').click(function(){
			var mn_gbn_name = "";
			
			if($('#mn_gbn').val() == '관리자'){
				 mn_gbn_name = 'GBN01'	
			} else{
				if($('#mn_gbn').val() == '기사'){
					 mn_gbn_name = 'GBN02'
				}else{
					if($('#mn_gbn').val() == '고객'){
						mn_gbn_name = 'GBN03'
					}
				}
			}
			$.ajax({
	            url  : '/insertMenuButton',
	            type : 'POST',
	            data : {
	            	mn_name : $('[name=mn_name]').val()
	            	,mn_gbn : mn_gbn_name
	            	,mn_url : $('[name=mn_url]').val()	     
	            	},
	            dataType : 'json',
	            success : function(data) {
	            	$('#menubar').html('');
	         		var data_len = Object.keys(data).length;
	         		for(i = 0; i < data_len ; i++ ){
	         			$('#menubar').append('<div class="menuClass" id="menu' + i + '"><div>'); 
	         			$('#menu'+i).append('<input type="checkbox" name="RowCheck" value="'+data[i].mn_id+'" />'); 
	        			$('#menu'+i).append('메뉴이름 : <input type="text" value="'+data[i].mn_name+'"/><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>');
	        			$('#menu'+i).append('url : <input type="text" name="MNUrl" value="'+data[i].mn_url+'" />'); 
	         		}
	        		$('#deleteSpace').html('<input type="button" id="btnDelete" value="메뉴 삭제하기" />')
	            },
	            error  : function(xhr){
	               alert(xhr.status + ':' + xhr.statusText)
	               }
	            });// AJAX END
		});	// btnInsert END
	});
$(function(){
	$(document).on('click','#btnDelete',function(){
		var mn_gbn_name = "";
		
		if($('#mn_gbn').val() == '관리자'){
			 mn_gbn_name = 'GBN01'	
		} else{
			if($('#mn_gbn').val() == '기사'){
				 mn_gbn_name = 'GBN02'
			}else{
				if($('#mn_gbn').val() == '고객'){
					mn_gbn_name = 'GBN03'
				}
			}
		}
		var chk_count = 0;
		var chk_box = new Array(); 
		$("input:checkbox[name=RowCheck]:checked").each(function() {
			chk_count = chk_count + 1;
			chk_box.push($(this).val());
			
		})
		$.ajax({
            url  : '/deleteMenuButton',
            type : 'POST',
            data : {
            	mn_id   : JSON.stringify(chk_box)
            	,mn_gbn : mn_gbn_name
            	,check_count : chk_count
            	},
            dataType : 'json',
            success : function(data) {
            	$('#menubar').html('');
         		var data_len = Object.keys(data).length;
         		for(i = 0; i < data_len ; i++ ){
         			$('#menubar').append('<div class="menuClass" id="menu' + i + '"><div>'); 
         			$('#menu'+i).append('<input type="checkbox" name="RowCheck" value="'+data[i].mn_id+'" />'); 
        			$('#menu'+i).append('메뉴이름 : <input type="text" value="'+data[i].mn_name+'"/><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>');
        			$('#menu'+i).append('url : <input type="text" name="MNUrl" value="'+data[i].mn_url+'" />'); 
         		}
        		$('#deleteSpace').html('<input type="button" id="btnDelete" value="메뉴 삭제하기" />')
            },
            error  : function(xhr){
               alert(xhr.status + ':' + xhr.statusText)
               }
            });// AJAX END
		
	})// Delete Button
		
})

$(function(){
	$(document).on('click','#btnUpdate',function(){
		var mn_gbn_name = "";
		
		if($('#mn_gbn').val() == '관리자'){
			 mn_gbn_name = 'GBN01'	
		} else{
			if($('#mn_gbn').val() == '기사'){
				 mn_gbn_name = 'GBN02'
			}else{
				if($('#mn_gbn').val() == '고객'){
					mn_gbn_name = 'GBN03'
				}
			} // else 1
		}// else 2
		
		var chk_count = 0;
		var mnid_box = new Array(); 
		var name_box = new Array(); 
		var url_box = new Array(); 
		$("input:checkbox[name=RowCheck]:checked").each(function(i,elements) {
			chk_count = chk_count + 1;
			 var index =  $(elements).index("input:checkbox[name=RowCheck]");
			 mnid_box.push(
					$('div.menuClass input').eq(3*index + 0).val()	
					);	
			name_box.push(
					$('div.menuClass input').eq(3*index + 1).val()	
					);	
			url_box.push(
					$('div.menuClass input').eq(3*index + 2).val()	
		    		);
			
		})
		
		$.ajax({
            url  : '/updateMenuButton',
            type : 'POST',
            data : {
            	mn_name : JSON.stringify(name_box)
            	,mn_id  : JSON.stringify(mnid_box)
            	,mn_url : JSON.stringify(url_box)
            	,mn_gbn : mn_gbn_name
            	,check_count : chk_count
            	},
            dataType : 'json',
            success : function(data) {
            	$('#menubar').html('');
            	name_box   = [];
            	url_box   = [];
         		var data_len = Object.keys(data).length;
         		for(i = 0; i < data_len ; i++ ){
         			$('#menubar').append('<div class="menuClass" id="menu' + i + '"><div>'); 
         			$('#menu'+i).append('<input type="checkbox" name="RowCheck" value="'+data[i].mn_id+'" />'); 
        			$('#menu'+i).append('메뉴 이름 : <input type="text" value="'+data[i].mn_name+'"/><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>');
        			$('#menu'+i).append('url : <input type="text" name="MNUrl" value="'+data[i].mn_url+'" />'); 
         		}
        		$('#deleteSpace').html('<input type="button" id="btnDelete" value="메뉴 삭제하기" />')
            },
            error  : function(xhr){
               alert(xhr.status + ':' + xhr.statusText)
               }
            });// AJAX END
		
	})// Delete Button
		
})

</script>
<style>
	#deleteSpace{float:left;}  
</style>
</head>
<body>
<div id = "entireDiv">
<input type="text" id ="mn_gbn"><button id = "selectMenu">메뉴 검색하기</button>
<br/><br/>
메뉴 이름 : <input type ="text" name ="mn_name" />
메뉴 사용자 : <input type ="text" name ="mn_gbn"  readonly/>
메뉴 url : <input type ="text" name ="mn_url" />	<br /><br />
<input type="button" id="btnInsert" value="메뉴 추가하기" />
<input type="button" id="btnUpdate" value="메뉴 수정하기" />
<div id = "deleteSpace"></div>


</div>
<div id ="menubar">
</div>
</body>
</html>