<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<head>
<title>Chi tiết đơn hàng</title>
</head>
<body>
	<!-- 
Body Section 
-->
	<div class="row">
		<div class="span12">
			<ul class="breadcrumb">
							<li><a href="<c:url value="/trang-chu"/>">Trang chủ</a> <span
								class="divider">/</span></li>
								<li><a href="#">Lịch sử mua hàng</a> <span
								class="divider">/</span></li>
							<li class="active">Chi tiết hóa đơn</li>
			</ul>
			<div class="well well-small">
				<h1>
					Chi Tiết Đơn Hàng<small class="pull-right"> Bạn có ${ historyBillDetails.size() }
						sản phẩm trong đơn hàng này </small>
				</h1>
				<hr class="soften" />

				<table class="table table-bordered table-condensed">
					<thead>
						<tr>
							<th></th>
							<th>Hình ảnh</th>
							<th>Tên sản phẩm</th>
							<th>Mô tả</th>
							<th>Giá bán</th>
							<th>Số lượng</th>
							<th>Tổng tiền</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${ historyBillDetails }" varStatus="i">
							<tr>
								<td>${ i.index + 1 }</td>
								<td><img width="100"
									src="<c:url value="/assets/admin/img/anh/${ item.products.image }"/>"
									alt=""></td>
								<td>${ item.products.tenSP }</td>
								<td>${ item.products.gioiThieu }</td>
								<td><fmt:formatNumber type="number" groupingUsed="true"
										value="${ item.products.giaBan }" /> ₫</td>
								<td>${ item.quantity }</td>
								<td><fmt:formatNumber type="number" groupingUsed="true"
										value="${ item.total }" /> ₫</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<br /> <a href="#"
					class="shopBtn btn-large"><span class="icon-arrow-left"></span>
					Quay Lại </a>
			</div>
		</div>
	</div>

	<content tag="script"> <script>
		$(".edit-cart").on("click", function() {
			var id = $(this).data("id");
			var quanty = $("#quantity-cart-" + id).val();

			window.location = "EditCart/" + id + "/" + quanty;
		});
	</script> </content>


</body>