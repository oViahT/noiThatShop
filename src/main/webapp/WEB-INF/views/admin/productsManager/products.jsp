<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<head>
<title>Quản lý sản phẩm</title>
</head>
<body>

	<div id="wrapper">
		<div id="page-wrapper">
			<div class="container-fluid">
				<div class="row">
					<ul class="breadcrumb">
						<li><a href="<c:url value="/quan-tri"/>">Trang quản trị</a> <span
							class="divider">/</span></li>
						<li class="active">Quản lý sản phẩm</li>
					</ul>
					<div class="col-lg-12">
						<h1 class="page-header">
							<small class="pull-right"> Bạn có ${ productsManager.size() }
								sản phẩm </small> Quản Lý Sản Phẩm
							<div style="text-align: right;">
								<a href="<c:url value="/them-san-pham"/>"
									class="shopBtn btn-large"> <!-- <span
								class="icon-arrow-plus"></span> -->Thêm sản phẩm
								</a>
							</div>
						</h1>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-body">
								<div class="table-responsive">
									<table class="table table-striped table-bordered table-hover"
										id="dataTables-example">
										<thead>
											<tr>
												<th></th>
												<th>Tên Sản Phẩm</th>
												<th>Hình ảnh</th>
												<th>Ngày Đăng</th>
												<th>Ngày Cập Nhật</th>
												<th>Giá Bán</th>
												<th>ĐVT</th>
												<th>Giảm Giá</th>
												<th>Giới Thiệu</th>
												<th>Sản Phẩm Nổi Bật</th>
												<th>Sản Phẩm Mới</th>
												<th>Sửa</th>
												<th>Xóa</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="item" items="${ productsManager }"
												varStatus="i">
												<tr>
													<td>${ i.index + 1 }</td>
													<td>${ item.tenSP }</td>
													<td><img width="100"
														src="<c:url value="/assets/admin/img/anh/${ item.image }" />"
														alt=""></td>
													<td>${ item.ngayTao }</td>
													<td>${ item.ngayCapNhat }</td>
													<td><fmt:formatNumber type="number"
															groupingUsed="true" value="${ item.giaBan }" /> ₫</td>
													<td>${ item.dvt }</td>
													<td><fmt:formatNumber type="number"
															groupingUsed="true" value="${ item.giamGia }" /> ₫</td>
													<td>${ item.gioiThieu }</td>
													<c:if test="${ item.noiBat == true }">
														<td>Nổi bật</td>
													</c:if>
													<c:if test="${ item.noiBat == false }">
														<td></td>
													</c:if>
													<c:if test="${ item.sanPhamMoi == true }">
														<td>Mới</td>
													</c:if>
													<c:if test="${ item.sanPhamMoi == false }">
														<td></td>
													</c:if>
													<td><a
														href="<c:url value="/sua-san-pham/${item.maSP}"/>"
														<%-- <td><a href="<c:url value="/sua-san-pham"/>" --%>
														" class="btn btn-mini btn-danger"
														type="button"> <span class="icon-edit"></span>
													</a></td>
													<td><a
														href="<c:url value="/deleteProduct/${item.maSP}"/>"
														" class="btn btn-mini btn-danger" type="button"> <span
															class="icon-remove"></span>
													</a></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
				<br /> <a href="<c:url value="/quan-tri"/>"
					class="shopBtn btn-large"><span class="icon-arrow-left"></span>
					Quay Lại Trang Quản Trị </a>
			</div>
		</div>
	</div>

</body>