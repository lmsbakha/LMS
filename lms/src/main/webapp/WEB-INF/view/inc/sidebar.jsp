<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<!--[if lt IE 8]>
		<p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
	<![endif]-->
    <!-- Start Left menu area -->
    <div class="left-sidebar-pro">
        <nav id="sidebar" class="">
            <div class="sidebar-header">
                <a href="${pageContext.request.contextPath}/loginCheck/index"><img class="main-logo" src="${pageContext.request.contextPath}/img/logo/logo.png" alt=""/></a>
                <strong><a href="index.html"><img src="${pageContext.request.contextPath}/img/logo/logosn.png" alt="" /></a></strong>
            </div>
            <div class="left-custom-menu-adp-wrap comment-scrollbar">
                <nav class="sidebar-nav left-sidebar-menu-pro">
                    <ul class="metismenu" id="menu1">
                        <li class="active">
                            <a href="${pageContext.request.contextPath}/loginCheck/index">
								   <span class="educate-icon educate-home icon-wrap"></span>
								   <span class="mini-click-non">Home</span>
								</a>
                        </li>
                         <li>
                            <a class="has-arrow" href="mailbox.html" aria-expanded="false"><span class="educate-icon educate-message icon-wrap"></span> <span class="mini-click-non">Mailbox</span></a>
                            <ul class="submenu-angle" aria-expanded="false">
                                <li><a title="Inbox" href="mailbox.html"><span class="mini-sub-pro">Inbox</span></a></li>
                                <li><a title="View Mail" href="mailbox-view.html"><span class="mini-sub-pro">View Mail</span></a></li>
                                <li><a title="Compose Mail" href="mailbox-compose.html"><span class="mini-sub-pro">Compose Mail</span></a></li>
                            </ul>
                        </li>
                         <li>
                            <a class="has-arrow" href="mailbox.html" aria-expanded="false"><span class="educate-icon educate-apps icon-wrap"></span> <span class="mini-click-non">강의</span></a>
                            <ul class="submenu-angle app-mini-nb-dp" aria-expanded="false">
                                <li><a title="Departments List" href="departments.html"><span class="mini-sub-pro">나의 강의</span></a></li>
                                <li>
                                 <a title="reportSubmitList" href="${pageContext.request.contextPath}/loginCheck/reportList"><span class="mini-sub-pro">과제</span></a>      
                                </li>
                                <li><a title="Departments List" href="departments.html"><span class="mini-sub-pro">시험</span></a></li>
                                <li><a title="Departments List" href="departments.html"><span class="mini-sub-pro">성적</span></a></li>
                                <li><a title="Departments List" href="departments.html"><span class="mini-sub-pro">출결현황</span></a></li>
                                <li><a title="Departments List" href="departments.html"><span class="mini-sub-pro">출결관리</span></a></li>
                            </ul>
                        </li>
                        <li>
                            <a class="has-arrow" href="all-courses.html" aria-expanded="false"><span class="educate-icon educate-library icon-wrap"></span> <span class="mini-click-non">교재</span></a>
                            <ul class="submenu-angle" aria-expanded="false">
                                <li><a title="All Library" href="library-assets.html"><span class="mini-sub-pro">전체 교재</span></a></li>
                                <li><a title="Add Library" href="add-library-assets.html"><span class="mini-sub-pro">나의 교재</span></a></li>
                            </ul>
                        </li>
                        <li>
                            <a class="has-arrow" href="mailbox.html" aria-expanded="false"><span class="educate-icon educate-form icon-wrap"></span> <span class="mini-click-non">공지사항</span></a>
                            <ul class="submenu-angle interface-mini-nb-dp" aria-expanded="false">
                               <li><a title="Departments List" href="departments.html"><span class="mini-sub-pro">전체 게시글</span></a></li>
                               <li><a title="Departments List" href="departments.html"><span class="mini-sub-pro">게시글 작성</span></a></li>
                            </ul>
                        </li>
                        <li>
                            <a class="has-arrow" href="mailbox.html" aria-expanded="false"><span class="educate-icon educate-form icon-wrap"></span> <span class="mini-click-non">문의사항</span></a>
                            <ul class="submenu-angle interface-mini-nb-dp" aria-expanded="false">
                           	   <li><a title="Departments List" href="departments.html"><span class="mini-sub-pro">전체 문의글</span></a></li>
                               <li><a title="Departments List" href="departments.html"><span class="mini-sub-pro">문의글 작성</span></a></li>
                            </ul>
                        </li>
                        <li>
                            <a class="has-arrow" href="mailbox.html" aria-expanded="false"><span class="educate-icon educate-charts icon-wrap"></span> <span class="mini-click-non">통계</span></a>
                            <ul class="submenu-angle chart-mini-nb-dp" aria-expanded="false">
                                <li><a title="Bar Charts" href="bar-charts.html"><span class="mini-sub-pro">Bar Charts</span></a></li>
                                <li><a title="Line Charts" href="line-charts.html"><span class="mini-sub-pro">Line Charts</span></a></li>
                                <li><a title="Area Charts" href="area-charts.html"><span class="mini-sub-pro">Area Charts</span></a></li>
                                <li><a title="Rounded Charts" href="rounded-chart.html"><span class="mini-sub-pro">Rounded Charts</span></a></li>
                                <li><a title="C3 Charts" href="c3.html"><span class="mini-sub-pro">C3 Charts</span></a></li>
                                <li><a title="Sparkline Charts" href="sparkline.html"><span class="mini-sub-pro">Sparkline Charts</span></a></li>
                                <li><a title="Peity Charts" href="peity.html"><span class="mini-sub-pro">Peity Charts</span></a></li>
                            </ul>
                        </li>
                         <li>
                            <a class="has-arrow" href="all-courses.html" aria-expanded="false"><span class="educate-icon educate-department icon-wrap"></span> <span class="mini-click-non">관리자 - 개설</span></a>
                            <ul class="submenu-angle" aria-expanded="false">
                                <li><a title="Departments List" href="departments.html"><span class="mini-sub-pro">강의개설</span></a></li>
                                <li><a title="Departments List" href="departments.html"><span class="mini-sub-pro">과목개설</span></a></li>
                                <li><a title="Departments List" href="departments.html"><span class="mini-sub-pro">강의관리</span></a></li>
                                <li><a title="Departments List" href="departments.html"><span class="mini-sub-pro">과목관리</span></a></li>
                                <li><a title="Departments List" href="departments.html"><span class="mini-sub-pro">교재관리</span></a></li>
                            </ul>
                        </li>
                        <c:if test="${sessionLevel >= 3}">
                          <li>
                            <a class="has-arrow" href="all-students.html" aria-expanded="false"><span class="educate-icon educate-student icon-wrap"></span> <span class="mini-click-non">관리</span></a>
                            <ul class="submenu-angle" aria-expanded="false">
                                <li><a title="All Students" href="all-students.html"><span class="mini-sub-pro">학생 리스트</span></a></li>
                                <li><a title="Add Students" href="add-student.html"><span class="mini-sub-pro">강사 리스트</span></a></li>
                                <li><a title="Edit Students" href="edit-student.html"><span class="mini-sub-pro">행정 리스트</span></a></li>
                                <li><a title="Students Profile" href="${pageContext.request.contextPath}/loginCheck/approveWaitMemberList"><span class="mini-sub-pro">회원가입 승인</span></a></li>
                            </ul>
                        </li>
                        </c:if>
                    </ul>
                </nav>
            </div>
        </nav>
    </div>
    <!-- End Left menu area -->