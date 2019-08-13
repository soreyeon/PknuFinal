<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Insert title here</title>
<style>
            /* 웹 폰트 */
            @font-face {
                font-family: 'GoyangIlsan';
                src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_one@1.0/GoyangIlsan.woff") format('woff');
                font-weight: normal;
                font-style: normal;
            }

            /* default 설정 */
            * {
                padding: 0;
                margin: 0;
                box-sizing:border-box;
                text-decoration: none;
                list-style: none;
                color: #282c37;
                font-family: 'GoyangIlsan';
            }

            #wrap {width:1024px}
            /* header */
            #header {
                z-index: 10000;
                background-color: #fff;
            }
            #header::after {
                display: block;
                content: '';
                clear: both;
            }
            /* #header #mainNav:hover {height:200px;transition-duration: 2s} */
            .inwrap {
                width: 80%;
                margin: 0 auto;
            }
            .inwrap::after {
                display: block;
                content: '';
                clear: both;
            }
            .mainLogo {
                float: left;
                width: 25%;
                height: 70px;
                margin-right: 5%;
            }
            .mainLogo > a {display: block; width:100%; height:100%; line-height:70px}
            .mainLogo img {
                width: 100%;
                
            }
            #mainNav {
                width:50%;
                height: 70px;
                float: right;
                overflow: hidden;
            }
            #mainNav::after {
                display: block;
                content: '';
                clear: both;
            }
            #mainNav > ul {
                color: #ddd;
            }
            #mainNav > ul#mainMenu::after {
                display: block;
                content: '';
                clear: both;
            }
            #mainNav > ul#mainMenu > li {
                float: left;
                line-height: 70px;
                font-size: 1vw;
                margin-right: 10%
            }
            #mainNav > ul#mainMenu > li:last-child {
                margin-right: 0;
            }
            #mainNav > ul#mainMenu > li > ul.subMenu > li {
                line-height: 30px;
                font-size: 15pt;
            }
            #subNav {
                width: 100%;
                height: 40px;
                background-color: #9baec8;
            }
            #subNav::after {
                display: block;
                content: '';
                clear: both;
            }
            #subNav ul#myMenu {
                float: right;
            }
            #subNav ul#myMenu > li {
                float: left;
                margin-right: 30px;
                line-height: 40px;
                
            }
            
            #subNav ul#myMenu > li > a {color:#fff}
            #subNav ul#myMenu > li:last-child {
                
                margin-right: 0;
            }

            /* section */
            #mainSlide {
                width: 100%;
                height: 350px;
                background-color: #ddd;
                margin-bottom: 50px;
            }
            #mainSlide img {
                width : 100%;
                height : 100%
            }

            #menusBox {
                border-top:1px solid #eee;
                padding-top:50px;
                width: 100%;
                margin-bottom:100px;
                background-color:#F2F4F6;
            }
            #menusBox h2 {
                font-size: 2.5vw;
                font-weight: normal;
                text-align: center;
                margin-bottom: 50px;
            }
            #menusUl {width:100%;padding-bottom:50px;}
            #menusUl::after {
                display: block;
                content: '';
                clear: both;
            }
            #menusUl > li {box-sizing:border-box;width:33.3%;height:230px; float:left;text-align: center; font-size: 20pt}
            #menusUl > li:hover {border-bottom:3px solid #282c37}
            #menusUl > li > a {display: block; width:100%; padding-bottom:50px}
            #menusUl > li > a > span {display:block;width:120px;height:120px;margin: 0 auto;margin-bottom:30px;}
            #menusUl > li > a > span > img {width:100%;height:100%}
            

            /* footer */
            #footer {width:100%; height:200px; padding-top:50px; background-color:#282c37; color:#fff}
            #footer .inwrap {position:relative;height:100%}
            #footer #managerArea {position:absolute; bottom:50px;right:0px;font-weight: bold; }
            #man_log {color:#fff}
        </style>
</head>
<body>
<div id="wrap">
            <!-- header -->
            <header id="header">
                <div class="inwrap">
                    <h1 class="mainLogo">
                        <a href="#">
                            <img src="/img/mainLogo.svg">
                        </a>
                    </h1>

                    <nav id="mainNav">
                        <ul id="mainMenu">
                            <li>
                                <a href="#">예약하기</a>
                                <!-- <ul class="subMenu"> <li><a href="#"> 서브메뉴1 </a></li> <li><a href="#">
                                서브메뉴2 </a></li> <li><a href="#"> 서브메뉴3 </a></li> </ul> -->
                            </li>
                            <li>
                                <a href="#">지점안내
                                    <!-- <ul class="subMenu"> <li><a href="#"> 서브메뉴1 </a></li> </ul> -->
                                </a>
                            </li>
                            <li>
                                <a href="#">공지사항
                                    <!-- <ul class="subMenu"> <li><a href="#"> 서브메뉴1 </a></li> </ul> -->
                                </a>
                            </li>
                            <li>
                                <a href="#">Q&A
                                    <!-- <ul class="subMenu"> <li><a href="notice.html"> 서브메뉴1 </a></li> <li><a
                                    href="#"> 서브메뉴2 </a></li> <li><a href="#"> 서브메뉴3 </a></li> <li><a href="#">
                                    서브메뉴4 </a></li> </ul> -->
                                </a>
                            </li>
                        </ul>
                    </nav>

                </div>
                <nav id="subNav">
                    <div class="inwrap">
                        <ul id="myMenu">
                        	<c:choose>
                        		<c:when test="${loginMember == null}">
                        			<li><a href="/Members/Login">로그인</a></li>
                            		<li><a href="/Members/JoinForm">회원가입</a></li>
                        		</c:when>
                        		<c:otherwise>
                            		<li><a href="/Members/Logout">로그아웃</a></li>
                        		</c:otherwise>
                        	</c:choose>
                            
                        </ul>
                    </div>
                </nav>
            </header>

            <section>
                <div id="mainSlide">
                    <img src="/img/slide1.png">
                </div>
                <div id="menusBox">
                    <div class="inwrap">
                        <h2>고객 지원 메뉴 바로가기</h2>
                        <ul id="menusUl">
                            <li>
                                <a href="#">
                                    <span><img src="/img/slide1.png"></span>
                                    예약하기
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span><img src="/img/slide1.png"></span>
                                    예약확인
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span><img src="/img/slide1.png"></span>
                                    공지사항
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </section>

            <footer id="footer">
                <div class="inwrap">
                footer영역입니다.
                <p id="managerArea">
                    <a href="#" id="man_log">관리자 로그인</a>
                </p>
                 </div>
            </footer>
        </div>
</body>
</html>