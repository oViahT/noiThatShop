<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<title>Trang chủ</title>
<body>
	<%-- <h1>${ allProducts.size() }</h1> --%>
	<div class="row">
		<div id="sidebar" class="span3">
			<div class="well well-small">
				<ul class="nav nav-list">
					<c:forEach var="item" items="${catogorys }">
						<li><a href='<c:url value="/san-pham/${ item.maLoai }"/>'><span
								class="icon-circle-blank"></span> ${ item.tenLoai }</a></li>
						<li>
					</c:forEach>
					<li><a class="totalInCart" href="<c:url value="/gio-hang"/>"><strong>Tổng
								tiền mua <span class="badge badge-warning pull-right"
								style="line-height: 18px;"><fmt:formatNumber
										type="number" groupingUsed="true" value="${TotalPriceCart}" />₫</span>
						</strong></a></li>
				</ul>
			</div>

			<a class="shopBtn btn-block">Sản Phẩm Mới Ra Mắt <br></a> <br>
			<br>
			<!--<ul class="nav nav-list promowrapper">
				<c:forEach var="item" items="${ viewProductsNew }" varStatus="loop">
					<li>
						<div class="thumbnail">
							<a class="zoomTool"
								href="san-pham/chi-tiet-san-pham/${item.maSP}"
								title="Thêm vào giỏ"><span class="icon-search"></span> Xem
								chi tiết</a> <img
								src="<c:url value="/assets/user/img/anh/${ item.image }"/>"
								alt="bootstrap ecommerce templates">
							<div class="caption">
								<h4>
									<a class="defaultBtn"
										href="san-pham/chi-tiet-san-pham/${item.maSP}">XEM</a> <span
										class="pull-right"><fmt:formatNumber type="number"
											groupingUsed="true" value="${item.giaBan}" /> ₫</span>
								</h4>
							</div>
						</div>
					</li>
					<li style="border: 0">&nbsp;</li>
				</c:forEach>
			</ul>  -->
		</div>
		<div class="span9">
			<div class="well np">
				<div id="myCarousel" class="carousel slide homCar">

					<div class="carousel-inner">
						<c:forEach var="item" items="${slides }" varStatus="index">
							<c:if test="${index.first }">
								<div class="item active">
							</c:if>
							<c:if test="${not index.first }">
								<div class="item ">
							</c:if>
							<img style="width: 100%"
								src="<c:url value="/assets/user/img/slides/${item.image }"/>"
								alt="bootstrap ecommerce templates">
							<div class="carousel-caption">
								<h4>${item.name }</h4>
								<p>
									<span>${item.content }</span>
								</p>
							</div>
					</div>
					</c:forEach>
				</div>
				<a class="left carousel-control" href="#myCarousel"
					data-slide="prev">&lsaquo;</a> <a class="right carousel-control"
					href="#myCarousel" data-slide="next">&rsaquo;</a>
			</div>
		</div>
		<!-- 
Sản Phẩm Mới
-->
		<div class="well well-small">
			<h3>Sản Phẩm Mới</h3>
			<hr class="soften" />
			<div class="row-fluid">
				<div id="newProductCar" class="carousel slide">
					<div class="carousel-inner">
						<c:if test="${ products.size() > 0 }">
							<div class="item active">
								<ul class="thumbnails">
									<c:forEach var="item" items="${ products }" varStatus="loop">
										<li class="span3">
											<div class="thumbnail">
												<a class="zoomTool"
													href="san-pham/chi-tiet-san-pham/${item.maSP}"
													title="Thêm vào giỏ"><span class="icon-search"></span>
													Xem thêm</a> <a href="san-pham/chi-tiet-san-pham/${item.maSP}"><img
													src="<c:url value="/assets/user/img/anh/${ item.image }"/>"
													alt=""></a>
											</div>
										</li>
										<c:if
											test="${ (loop.index + 1) % 4 == 0 || (loop.index + 1)  == products.size() }">
								</ul>
							</div>
							<c:if test="${ (loop.index + 1) < products.size() }">
								<div class="item">
									<ul class="thumbnails">
							</c:if>
						</c:if>
						</c:forEach>
						</c:if>
					</div>
					<a class="left carousel-control" href="#newProductCar"
						data-slide="prev">&lsaquo;</a> <a class="right carousel-control"
						href="#newProductCar" data-slide="next">&rsaquo;</a>
				</div>
			</div>
		</div>
		<!--
Featured Products
-->
		<div class="well well-small">
			<h3>Sản Phẩm Nổi Bật</h3>
			<hr class="soften" />
			<div class="row-fluid">
				<ul class="thumbnails">
					<c:if test="${ products.size() >0 }">
						<ul class="thumbnails">
							<c:forEach var="item" items="${ products }" varStatus="loop">
								<li class="span4">
									<div class="thumbnail">
										<a class="zoomTool"
											href="san-pham/chi-tiet-san-pham/${item.maSP}"
											title="Xem thêm"><span class="icon-search"></span> Xem
											thêm</a> <a href="san-pham/chi-tiet-san-pham/${item.maSP}"><img
											src="<c:url value="/assets/user/img/anh/${ item.image }" />"
											alt=""></a>
										<div class="caption">
											<h5>${ item.tenSP }</h5>
											<h4>
												<%-- <a class="defaultBtn"
													href="san-pham/chi-tiet-san-pham/${item.maSP}"
													title="Nhấn để xem"><span class="icon-zoom-in"></span></a> --%>
												<a class="shopBtn"
													href="<c:url value="/AddCart/${ item.maSP }"/>"
													title="Thêm vào giỏ"><span class="icon-plus"></span></a> <span
													class="pull-right"> <fmt:formatNumber type="number"
														groupingUsed="true" value="${item.giaBan}" /> ₫/ ${ item.dvt }
												</span>
											</h4>
										</div>
									</div>
								</li>
								<c:if
									test="${ (loop.index+1)  %3 ==0 || (loop.index+1) == products.size()}">
						</ul>
						<c:if test="${ (loop.index+1) < products.size()}">
							<ul class="thumbnails">
						</c:if>
					</c:if>
					</c:forEach>
					</c:if>
			</div>
		</div>
	</div>
	</div>
</body>
