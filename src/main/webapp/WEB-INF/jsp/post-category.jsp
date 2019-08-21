<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>


<spring:htmlEscape defaultHtmlEscape="true" />

<template:page>

	<div class="main-dyaco-news">
		<ul class="news__list">
			<c:forEach items="${posts}" var="post">
				<li class="news__item">
					<article class="card card--small">

						<div class="card-img"><img src="${post.featuredMediaUrl}" /></div>
						<a href="/posts/${post.id}">
							<div class="card-body">
								<div class="card-meta">
									<span class="card-category">${category.name}</span> <span
										class="card-date"><fmt:formatDate pattern="yyyy-MM-dd"
											value="${post.date}" /></span>
								</div>
								<h3 class="card-title">
									<c:out value="${post.title.rendered}" escapeXml="false" />
									</span>
								</h3>
								<p class="card-text">
									<c:out value="${post.excerpt.rendered}" escapeXml="false" />
								</p>
							</div>
						</a>

					</article>
				</li>
			</c:forEach>
		</ul>
	</div>
</template:page>