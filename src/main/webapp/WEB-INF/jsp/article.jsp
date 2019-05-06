<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template" %>


<spring:htmlEscape defaultHtmlEscape="true" />

<template:page>
	<div class="d-container">
		<article class="article">
			<section class="headline">
				<div class="meta">
					<h1 class="title"><c:out value="${postData.title}" escapeXml="false" /></h1>
					<time><fmt:formatDate pattern="yyyy-MM-dd" value="${postData.date}" /></time>
				</div>
			</section>
			<hr>
			<section class="content">
				<div class="feature-media">
					<c:out value="${postData.media.description}" escapeXml="false" />
				</div>
				<c:out value="${postData.content}" escapeXml="false" />
			</section>
		</article>
	</div>
</template:page>
