<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<head>
<title>Quản lý tài khoản</title>
</head>
<body>

	<div id="page-wrapper">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12">
					<ul class="breadcrumb">
						<li><a href="<c:url value="/quan-tri"/>">Trang quản trị</a> <span
							class="divider">/</span></li>
						<li class="active">Quản lý tài khoản</li>
					</ul>
					<h1 class="page-header">
						Quản Lý Tài Khoản<small class="pull-right"> Bạn có ${ accManagger.size() }
							tài khoản </small>
						${loginInfo.id}
						
        <a href="<c:url value="/dang-ky-admin"/>">Thêm nhân viên</a>
      			
										<h3>${statusNV}</h3>
					</h1>		
					<h4>${statusAdd}</h4>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-body">
							<div class="table-responsive">
								<table class="table table-bordered table-striped">
									<thead>
										<tr>
											<th></th>
											<th>Loại Tài Khoản</th>
											<th>Email</th>
											<th>Password</th>
											<th>Tên</th>
											<th>Địa Chỉ</th>
											<th>Số Điện Thoại</th>
											<th>Xóa Tài Khoản</th>
										
										</tr>
									</thead>
									<tbody>
										<c:forEach var="item" items="${ accManagger }" varStatus="i">
											<tr>
												<td>${ i.index +1 }</td>
												<c:if test="${ item.idRoles == true }">
													<td>Quản Trị</td>
												</c:if>
												<c:if test="${ item.idRoles == false }">
													<td>Người Dùng</td>
												</c:if>
												<td>${ item.user }</td>
												<td>${ item.password }</td>
												<td>${ item.name }</td>
												<td>${ item.address }</td>
												<td>${ item.phoneNumber }</td>
											
												<c:if test="${ loginInfo.user == 'admin1@gmail.com' }">
													<td><a href="<c:url value="/deleteUser/${item.id}"/>"
													class="btn btn-mini btn-danger" type="button"> <span
														class="icon-remove"></span>
												</a></td>
												</c:if>
												
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
						<br /> <a href="<c:url value="/quan-tri"/>"
							class="shopBtn btn-large"><span class="icon-arrow-left"></span>
							Quay Lại Trang Quản Trị </a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>