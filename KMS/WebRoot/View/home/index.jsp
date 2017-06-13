<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="icon" href="favicon.ico" />

</head>
<body>
	<%@ include file="../template/header.jsp"%>
	<div class="container-fluid all">
		<%@ include file="../template/left.jsp"%>
		<div class="maincontent row">
			<!--我是主要内容 start-->
			<ul class="breadcrumb">
				<li class="active">首页</li>
			</ul>
			<div class="col-sm-12">
				<div id="myCarousel"
					class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2 carousel slide  ">
					<!-- 轮播（Carousel）指标 -->
					<ol class="carousel-indicators">
						<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
						<li data-target="#myCarousel" data-slide-to="1"></li>
						<li data-target="#myCarousel" data-slide-to="2"></li>
						<li data-target="#myCarousel" data-slide-to="3"></li>
					</ol>

					<!-- 轮播（Carousel）项目 -->
					<div class="carousel-inner">
						<div class="item active img-responsive">
							<img src="/KMS/resources/1.png" alt="First slide">
						</div>
						<div class="item img-responsive">
							<img src="/KMS/resources/2.png" alt="Second slide">
						</div>
						<div class="item img-responsive">
							<img src="/KMS/resources/3.png" alt="Third slide">
						</div>
						<div class="item img-responsive">
							<img src="/KMS/resources/4.png" alt="Fourth slide">
						</div>
					</div>
					<!-- 轮播（Carousel）导航 -->
					<!--<a class="left carousel-control" href="#myCarousel" role="button"
						data-slide="prev"> <span class="fa fa-angle-left"
						aria-hidden="true"></span> <span class="sr-only">Previous</span>
					</a> <a class="right carousel-control" href="#myCarousel"
						role="button" data-slide="next"> <span
						class="fa fa-angle-right" aria-hidden="true"></span> <span
						class="sr-only">Next</span>
					</a>-->
				</div>
				<hr>


				<%@ include file="../template/footer.jsp"%>
			</div>
			<!--我是主要内容 end-->
		</div>
	</div>
	<%@ include file="../template/account.jsp"%>
	<script type="text/javascript">
		$(function() {
			// 初始化轮播
			$("#myCarousel").carousel('cycle');
	
		});
	</script>
</body>
</html>

