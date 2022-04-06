<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<head>
<title>Sản phẩm bán chạy</title>
<style>
.pagination {
	display: flex;
	justify-content: center;
}

.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
	transition: background-color .3s;
	border: 1px solid #ddd;
}

.pagination a.active {
	background-color: #4CAF50;
	color: white;
	border-radius: 5px;
}

.pagination a:hover:not(.active) {
	background-color: #ddd;
}
</style>
</head>
<body>

	<div class="well well-small">
		<h3>Sản phẩm bán chạy</h3>
		<div class="row-fluid">
			<ul class="thumbnails">
				<c:if test="${ allHighlithsProductsPaginate.size() <=0 }">
					<h3 style="text-align: center; color: red;">Hiện tại chưa có
						sản phẩm này!!!</h3>
				</c:if>
				<c:if test="${ allHighlithsProductsPaginate.size() >0 }">
					<ul class="thumbnails">
						<c:forEach var="item" items="${ allHighlithsProductsPaginate }"
							varStatus="loop">
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
											<a class="defaultBtn"
												href="san-pham/chi-tiet-san-pham/${item.maSP}"
												title="Nhấn để xem"><span class="icon-zoom-in"></span></a> <a
												class="shopBtn"
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
								test="${ (loop.index+1)  %3 ==0 || (loop.index+1) == allHighlithsProductsPaginate.size()}">
					</ul>
					<c:if
						test="${ (loop.index+1) < allHighlithsProductsPaginate.size()}">
						<ul class="thumbnails">
					</c:if>
				</c:if>
				</c:forEach>
				</c:if>
			</ul>
		</div>
	</div>
	<div class="pagination">
		<c:forEach var="item" begin="1"
			end="${ paginateInfoAllHighlithsProdcts.totalPage }" varStatus="loop">
			<c:if
				test="${ (loop.index) == paginateInfoAllHighlithsProdcts.currentPage }">
				<a href="<c:url value="/san-pham-noi-bat/${ loop.index }"/>"
					class="active">${ loop.index }</a>
			</c:if>
			<c:if
				test="${ (loop.index) != paginateInfoAllHighlithsProdcts.currentPage }">
				<a href="<c:url value="/san-pham-noi-bat/${ loop.index }"/>">${ loop.index }</a>
			</c:if>
		</c:forEach>
	</div>
	<!-- </div>
	</div> -->



</body>
