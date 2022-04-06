<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<head>
<meta charset="UTF-8">
<title>Lịch sử mua hàng</title>
</head>
<body>
	<div id="wrapper">
		<div id="page-wrapper">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<ul class="breadcrumb">
							<li><a href="<c:url value="/trang-chu"/>">Trang chủ</a> <span
								class="divider">/</span></li>
							<li class="active">Lịch sử mua hàng</li>
						</ul>
						<h1 class="page-header">
							Lịch sử mua hàng<small class="pull-right"> Bạn có ${ historyBill.size() }
								hóa đơn </small>
						</h1>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">

							<!-- /.panel-heading -->
							<div class="panel-body">
								<div class="table-responsive">
									<table class="table table-striped table-bordered table-hover"
										id="dataTables-example">
										<thead>
											<tr>
												<th></th>
												<th>Ngày</th>
												<!-- <th>Tên Người Mua</th>
												<th>Email</th>
												<th>Số Điện Thoại</th>
												<th>Địa Chỉ</th>
												<th>Ghi Chú</th> -->
												<th>Số Lượng</th>
												<th>Tổng Giá</th>
												<th>Xem Chi Tiết</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="item" items="${ historyBill }" varStatus="i">
												<tr>
													<td>${ i.index + 1 }</td>
													<td>${ item.buyDate }</td>
													<%-- <td>${ item.name }</td>
													<td>${ item.email }</td>
													<td>${ item.phoneNumber }</td>
													<td>${ item.address }</td>
													<td>${ item.note }</td> --%>
													<td>${ item.quantity }</td>
													<td><fmt:formatNumber type="number"
															groupingUsed="true" value="${ item.total }" /> ₫</td>
													<td><a
														href="<c:url value="/lich-su-mua-hang/${item.email}/${ item.id }"/>"
														class="btn btn-mini btn-danger" type="button"> <span
															class="icon-search"></span>
													</a></td>
													<%-- <td><a
														href="<c:url value="/deleteBill/${ item.id }"/>"
														class="btn btn-mini btn-danger" type="button"> <span
															class="icon-remove"></span>
													</a></td> --%>
												</tr>
											</c:forEach>
										</tbody>
									</table>
									<br /> <a href="<c:url value="/trang-chu"/>"
										class="shopBtn btn-large"><span class="icon-arrow-left"></span>
										Tiếp Tục Mua Sắm </a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

</body>