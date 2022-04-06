<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<head>
<title>Thanh toán</title>
</head>
<body>
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
				<li class="active">Thanh toán</li>
			</ul>
			<div class="well">
				<form:form action="checkout" method="post" modelAttribute="bill"
					class="form-horizontal">
					<h3>Thanh toán đơn hàng</h3>
					<h6 style="text-align: left; color: red;">
						Những ô có dấu (<sup>*</sup>) không được để trống!!!
					</h6>
					<div class="control-group">
						<label class="control-label">Họ và tên <sup>*</sup></label>
						<div class="controls">
							<form:input type="text" placeholder="Trần Văn A" path="name" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">Email <sup>*</sup></label>
						<div class="controls">
							<form:input type="text" class="span3" placeholder="abc@gmail.com"
								path="email" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">Số điện thoại <sup>*</sup></label>
						<div class="controls">
							<form:input type="text" class="span3" placeholder="0123456789"
								path="phoneNumber" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">Địa chỉ <sup>*</sup></label>
						<div class="controls">
							<form:textarea path="address" rows="6" cols="30"  placeholder="TP. HCM"/>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">Ghi chú</label>
						<div class="controls">
							<form:textarea path="note" rows="6" cols="30"  placeholder="Có thể để trống"/>
						</div>
					</div>
					<div class="control-group">
						<div class="controls">
					<h6 class="status" style="color: red;">${ statusCheckout }</h6>
							<input type="submit" name="submitAccount" value="Thanh toán"
								class="shopBtn exclusive">
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>