<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<header id="header">
	<div class="row">
		<div class="span4">


			<a style="width: 200px;" class="logo"
				href="<c:url value="/quan-tri"/>"> <img
				src="<c:url value="/assets/admin/img/anh/logo.png"/>"
				alt="shop sieu dep">

			</a>

		</div>
		<div class="span4">
			<div class="offerNoteWrapper">
				<h1 class="dotmark">
					<i class="icon-cut"></i> Shop chuyên bán đồ decor và nội thất giành
					cho gia đình, văn phòng . Chuyên tư vấn và lắp đặt sản phẩm decor $
				</h1>
			</div>
		</div>
	</div>
</header>


