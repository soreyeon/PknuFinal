<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>회원가입</title>
<link rel="stylesheet" href="/css/common.css" >
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>


</head>
<body>
<div id="wrap">
	<!-- header -->
    <header id="header">
        <div class="inwrap">
            <h1 class="mainLogo">
                <a href="#">
                    logo
                </a>
            </h1>
    
            <nav id="mainNav">
            <ul id="mainMenu">
                <li>
                    <a href="#">메인메뉴1</a>
                    <!-- <ul class="subMenu">
                        <li><a href="#">
                            서브메뉴1
                        </a></li>
                        <li><a href="#">
                            서브메뉴2
                        </a></li>
                        <li><a href="#">
                            서브메뉴3
                        </a></li>
                    </ul> -->
                </li>
                <li><a href="#">메인메뉴2
                    <!-- <ul class="subMenu">
                        <li><a href="#">
                            서브메뉴1
                        </a></li>
                    </ul> -->
                </a></li>
                <li><a href="#">메인메뉴3
                    <!-- <ul class="subMenu">
                        <li><a href="#">
                            서브메뉴1
                        </a></li>
                    </ul> -->
                </a></li>
                <li><a href="#">메인메뉴4
                    <!-- <ul class="subMenu">
                        <li><a href="notice.html">
                            서브메뉴1
                        </a></li>
                        <li><a href="#">
                            서브메뉴2
                        </a></li>
                        <li><a href="#">
                            서브메뉴3
                        </a></li>
                        <li><a href="#">
                            서브메뉴4
                        </a></li>
                    </ul> -->
                </a></li>
            </ul>
            </nav>
            
        </div>   
        <nav id="subNav">
            <div class="inwrap">
                <ul id="myMenu">
                    <li>로그인</li>
                    <li>회원가입</li>
                </ul>
            </div>
        </nav>     
    </header>
    
    <br><br><br><br><br><br><br><br><br><br>

    <!-- 로그인 table -->
    <form action="/Members/Join" method="POST">
	    <div class="inwrap">
	    <table id="notice">
	        <tr><th colspan="2">회원가입</th></tr>
	        <tr>
	        	<td>
	        	<div>
	        		<table>
	        			<tr>
	        				<td>아이디</td>
	        				<td><input type="text" name="m_uid" placeholder="아이디"  autofocus required />
		        				<input type="button" value="중복확인" id="idDupCheckBtn" />
		        				<span id="dupResult"></span>
	        				</td>
	        			</tr>
	        			<tr>
	        				<td>비밀번호</td>
	        				<td><input type="password" name="m_pwd" placeholder="비밀번호" required /></td>
	        			</tr>
	        			<tr>
	        				<td>이름</td>
	        				<td><input type="text" name="m_name" placeholder="이름" required /></td>
	        			</tr>
	        			<tr>
	        				<td>전화번호</td>
	        				<td><input type="tel" name="m_tel" placeholder="전화번호" required /></td>
	        			</tr>
	        			<tr>
	        				<td>e-mail</td>
	        				<td><input type="email" name="m_email" placeholder="e-mail" required /></td>
	        			</tr>
	        			<tr>
	        				<td>주소</td>
	        				<td>
	        					<input type="text" name="m_zipcode" placeholder="우편번호" id="zonecode" onclick="fn_setAddr();" required/>
								<input type="text" name="m_city" placeholder="시도" id="sido" onclick="fn_setAddr();" required/>
								<input type="text" name="m_gugun" placeholder="구군" id="sigungu" onclick="fn_setAddr();" required/>
								<input type="text" name="m_addr" placeholder="상세주소" id="addr" onclick="fn_setAddr();" required/>
								<!-- <button onclick="fn_setAddr();" >주소찾기</button> -->
									
	        				</td>
	        			</tr>
	        			<tr>
	        				<td>해당지역서비스센터</td>
	        				<td>
	        					<input type="hidden"  name="c_id" value=""/>
	        					<input type="text"  id="cname" value=""/>
	        					<input type="button" value="센터찾기" id="NearCenterBtn" />
	        				</td>
	        			</tr>
	        			<tr>
	        				<td colspan="2"><input type="submit" id="jbtn" disabled="disabled" value="회원가입" /></td>
	        			</tr>
	        		</table>
	        	</div>
	        	</td>
	        </tr>
	    </table>
	    </div>
    </form>
    </div>
</body>
</html>