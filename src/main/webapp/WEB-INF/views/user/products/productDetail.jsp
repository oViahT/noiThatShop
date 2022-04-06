<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>Chi tiết sản phẩm</title>
<style>
.product-content {
	overflow-x: hidden;
}
</style>
</head>
<body>
	<!-- 
Body Section 
-->

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
		</div>
		<div class="span9">
			<ul class="breadcrumb">
				<li><a href="index.html">Trang chủ</a> <span class="divider">/</span></li>
				<li><a href="products.html">Sản phẩm</a> <span class="divider">/</span></li>
				<li class="active">Chi tiết sản phẩm</li>
			</ul>
			<div class="well well-small">
				<div class="row-fluid">
					<div class="span5">
						<div id="myCarousel" class="carousel slide cntr">
							<div class="carousel-inner">
								<div class="item active">
									<a href="#"> <img
										src="<c:url value="/assets/user/img/anh/${ productDetail.image }"/>"
										alt="" style="width: 100%"></a>
								</div>
							</div>
							<a class="left carousel-control" href="#myCarousel"
								data-slide="prev">‹</a> <a class="right carousel-control"
								href="#myCarousel" data-slide="next">›</a>
						</div>
					</div>
					<div class="span7">
						<h3>${ productDetail.tenSP }</h3>
						<hr class="soft" />

						<form class="form-horizontal qtyFrm" method="get"
							action="<c:url value="/AddCart/${ productDetail.maSP }"/>">
							<div class="control-group">
								<label class="control-label"><span><fmt:formatNumber
											type="number" groupingUsed="true"
											value="${productDetail.giaBan}" /> ₫/ ${ productDetail.dvt }</span></label>
								<!-- <div class="controls">
									<input type="number" min="0" value="0" class="span6">
								</div> -->
							</div>

							<h4></h4>
							<p>${productDetail.gioiThieu}
							<p>
								<button type="submit" class="shopBtn">
									<span class=" icon-shopping-cart"></span> Thêm vào giỏ
								</button>
						</form>
					</div>
				</div>
				<hr class="softn clr" />


				<ul id="productDetail" class="nav nav-tabs">
					<li class="active"><a href="#home" data-toggle="tab">Mô Tả
							Sản Phẩm</a></li>
					<li class=""><a href="#profile" data-toggle="tab">Sản Phẩm
							Liên Quan</a></li>
				</ul>
				<div id="myTabContent" class="tab-content tabWrapper">
					<div class="tab-pane fade active in" id="home">
						${productDetail.gioiThieu}</div>
					<div class="tab-pane fade" id="profile">
						<c:set var="countList" value="${productDetailByIDType.size()}" />
						<c:if test="${productDetailByIDType.size() > 5 }">
							<c:set var="countList" value="5" />
						</c:if>
						<c:forEach var="item" items="${ productDetailByIDType }" begin="1"
							end="${ countList }" varStatus="loop">
							<div class="row-fluid">
								<div class="span2">
									<img
										src="<c:url value="/assets/user/img/anh/${ item.image }"/>"
										alt="">
								</div>
								<div class="span6">
									<h5>${ item.tenSP }</h5>
									<p>${ item.gioiThieu }</p>
								</div>
								<div class="span4 alignR">
									<form class="form-horizontal qtyFrm">
										<h3>
											<fmt:formatNumber type="number" groupingUsed="true"
												value="${item.giaBan}" />
											₫
										</h3>
										<div class="btn-group">
											<a href="<c:url value="/AddCart/${ item.maSP }"/>" class="defaultBtn"><span
												class=" icon-shopping-cart"></span> Thêm vào giỏ</a> <a
												href="${item.maSP}" class="shopBtn">Xem</a>
										</div>
									</form>
								</div>
							</div>
							<hr class="soft" />
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>