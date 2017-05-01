<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Kindergarten Manage System</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script src="/KMS/JS/jquery-1.10.2.min.js"></script>
<script src="/KMS/JS/CommonJS.js"></script>
<script src="/KMS/JS/dynamic/index.js"></script>
<link href="/KMS/CSS/dynamic/index.css" rel="stylesheet" />

</head>

<body>
	<%@ include file="../header.jsp"%>
	<div id="main">
		<div id="left"></div>
		<div id="top">
			<div id="top-txt">
				<textarea placeholder="发表动态"></textarea>
				<div id="center-top-camera">
					<a data-id="" href="javascript:;"></a>
				</div>
			</div>
			<div class="center-item-btn">
				<a href="javascript:;">发表</a>
			</div>
		</div>
		<div id="center">
			<div id="center-top">
				<span>全部动态</span> <a href="javascript:;"></a>
			</div>
			<div class="center-itemlist">
				<c:forEach items="${view.getDynamicModelslist()}" var="item">
					<div class="center-item">
						<div class="center-item-userinfo">
							<div class="center-item-userinfo-img">
								<img src="${item.getUserinfo().getImage()}" />
							</div>
							<div class="center-item-userinfo-detail">
								<p class="center-item-userinfo-name">${item.getUserinfo().getUserName()}</p>
								<p class="center-item-userinfo-time">${item.getDynamicinfo().getPublishTime()}</p>
							</div>
						</div>
						<div class="center-item-description">${item.getDynamicinfo().getContent()}</div>

						<div class="center-item-ico">
							<div class="center-item-ico-likenum">
								已被点赞<span>${item.getZambialist().size()}</span>次
							</div>
							<ul>
								<li class="center-item-ico-comment"><a
									href="javascript:;"> <img src="/KMS/resources/comment.png" />
								</a></li>
								<li class="center-item-ico-like"><a href="javascript:;">
										<img src="/KMS/resources/like.png" />
								</a></li>
							</ul>
						</div>
						<hr />
						<c:forEach items="${item.getCommentmapMap()}" var="commentmap">
							<div class="center-item-commentlist">
								<div class="center-item-commentitem">
									<div class="center-item-commentitem-main">
										<div class="center-item-commentitem-main-userinfo-img">
											<img src="${commentmap.key.getUserinfoByUserRecId().getImage()}" />
										</div>

										<div class="center-item-commentitem-main-userinfo-detail">
											<!--这里的评论我要限定字数 不大于60字-->
											<div
												class="center-item-commentitem-main-userinfo-detail-message">
												<span
													class="center-item-commentitem-main-userinfo-detail-message-name center-item-commentitem-main-userinfo-messsage-me">${commentmap.key.getUserinfoByUserRecId().getUserName()}</span><span>：</span>${commentmap.key.getContent()}
											</div>
											<p class="center-item-commentitem-main-userinfo-detail-time">
												<span>${commentmap.key.getCommentDetailTime()}</span><a
													class="center-item-commentitem-comment" 
													data-id="${commentmap.key.getPublishcomment().getPublishCommentId()}">
													<img src="/KMS/resources/comment.png" /></a>
											</p>
										</div>
									</div>
<%-- 									<c:if test="commentmap.value.size()>0"> --%>
										<c:forEach items="${commentmap.value}" var="comment">
											<div class="center-item-commentitem-nomain">
												<div class="center-item-commentitem-main-userinfo-img">
													<img src="${comment.getUserinfoByUserRecId().getImage()}" />
												</div>
												<div class="center-item-commentitem-main-userinfo-detail">
													<div
														class="center-item-commentitem-main-userinfo-detail-message">
														<span
															class="center-item-commentitem-main-userinfo-detail-message-name center-item-commentitem-main-userinfo-messsage-me">${comment.getUserinfoByUserRecId().getUserName()}</span>对<span
															class="center-item-commentitem-main-userinfo-detail-message-name center-item-commentitem-main-userinfo-messsage-you">${comment.getUserinfoByYouUserRecId().getUserName()}</span><span>说：</span>${comment.getContent()}
													</div>

													<p
														class="center-item-commentitem-main-userinfo-detail-time">
														<span>${comment.getCommentDetailTime()}</span><a
															data-id="${commentmap.key.getPublishcomment().getPublishCommentId()}"
															class="center-item-commentitem-comment"><img
															src="/KMS/resources/comment.png" /></a>
													</p>
												</div>
											</div>
										</c:forEach>
<%-- 									</c:if> --%>
								</div>
							</div>
						</c:forEach>

						<div class="center-item-txt">
							<textarea placeholder="评论"></textarea>
						</div>
						<div class="center-item-btn">
							<a href="javascript:;" data-dynamicid="${item.getDynamicinfo().getDynamicId()}"> 评论</a>
						</div>
					</div>

					<div class="center-stop"></div>
				</c:forEach>
			</div>
		</div>
		<div id="right"></div>
	</div>
	<%@ include file="../footer.jsp"%>
</body>
</html>
