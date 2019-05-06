<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template" %>


<spring:htmlEscape defaultHtmlEscape="true" />

<template:page>

<div class="runners-post">
    <ul class="post__list">
        <li class="post__headline">
            <span class="post__date">
               Date
            </span>
            <span class="post__title">
                Title
            </span>
        </li>
        <c:forEach items="${pageablePostData.posts}" var="post">
            <li class="post__item">
                <span class="post__date">
                    <fmt:formatDate pattern="yyyy-MM-dd" value="${post.date}" /></span>
                <a href="/posts/${post.id}">
                    <span class="post__title">
                        <c:out value="${post.title}" escapeXml="false" /></span>
                </a>
            </li>
        </c:forEach>
    </ul>

    <ul class="pagination">
        <c:forEach begin="1" end="${pageablePostData.totalPages }" var="p">
            <c:choose>
                <c:when test="${postData.page == p}">
                    <li><a href="?page=${p}" class="active">${p}</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="?page=${p}">${p}</a></li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </ul>
</div>
</template:page>