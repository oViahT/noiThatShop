<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- 
Clients 
-->
<section class="our_client">
	<hr class="soften" />
	<h4 class="title cntr"></h4>
	<!-- <hr class="soften" />
	<div class="row">
		<div class="span2">
			<a href="#"><img alt="" src="assets/img/1.png"></a>
		</div>
		<div class="span2">
			<a href="#"><img alt="" src="assets/img/2.png"></a>
		</div>
		<div class="span2">
			<a href="#"><img alt="" src="assets/img/3.png"></a>
		</div>
		<div class="span2">
			<a href="#"><img alt="" src="assets/img/4.png"></a>
		</div>
		<div class="span2">
			<a href="#"><img alt="" src="assets/img/5.png"></a>
		</div>
		<div class="span2">
			<a href="#"><img alt="" src="assets/img/6.png"></a>
		</div>
	</div> -->
</section>

<!--
Footer
-->
<footer class="footer">
	<div class="row-fluid">
		<div class="span2">
			<h5>Tài Khoản Của Bạn</h5>
			<c:if test="${ not empty loginInfo }">
				<a href="<c:url value="/thong-tin-tai-khoan/${loginInfo.id}"/>">TÀI
					KHOẢN CỦA BẠN</a>
				<br>
			</c:if>
			<c:if test="${ empty loginInfo }">
				<a href="<c:url value="/thong-tin-tai-khoan"/>">TÀI KHOẢN CỦA
					BẠN</a>
				<br>
			</c:if>
			<c:if test="${ not empty loginInfo }">
				<a href="<c:url value="/thong-tin-tai-khoan/${loginInfo.id}"/>">THÔNG
					TIN CÁ NHÂN</a>
				<br>
			</c:if>
			<c:if test="${ empty loginInfo }">
				<a href="<c:url value="/thong-tin-tai-khoan"/>">THÔNG TIN CÁ
					NHÂN</a>
				<br>
			</c:if>
			<a href="<c:url value="/lien-he"/>">ĐỊA CHỈ</a><br> <a href="#">GIẢM
				GIÁ</a><br> <a href="<c:url value="/lich-su-mua-hang/${loginInfo.user}"/>">LỊCH SỬ MUA HÀNG</a><br>
		</div>
		<div class="span2">
			<h5>Thông Tin</h5>
			<a href="<c:url value="/lien-he"/>">LIÊN LẠC</a><br> <a
				href="<c:url value="/lien-he"/>">BẢN ĐỒ</a><br> <a href="#">THÔNG
				TIN PHÁP LÝ</a><br> <a href="#">ĐIỀU KHOẢN</a><br> <a
				href="<c:url value="/gioi-thieu"/>">GIỚI THIỆU</a><br>
		</div>
		<div class="span2">
			<h5>Ưu Đãi</h5>
			<a href="<c:url value="/san-pham-moi"/>">SẢN PHẨM MỚI</a> <br> <a
				href="<c:url value="/san-pham-noi-bat"/>">BÁN CHẠY NHẤT</a><br>
			<a href="#">ĐẶC BIỆT</a><br> <a href="#">NHÀ SẢN XUẤT</a><br>
			<a href="#">NHÀ CUNG CẤP</a> <br />
		</div>
		<div class="span6">
			<h5>Mô tả Website</h5>
			Website được là ra bởi nhu cầu thị trường với mục đích số hóa mua-
			bán hàng một cách dễ dàng và thuận tiện trong thời điểm dịch bệnh
			hiện nay. “Website bán thức ăn vặt” để khách hàng có thể chọn mua
			trực tiếp trên bất kỳ thiết bị nào có thể truy cập vào mạng. Và được
			phát triển bởi nhóm 5AE...
		</div>
	</div>

	<script src="assets/user/js/jquery.js"></script>
	<script src="assets/user/js/bootstrap.min.js"></script>
	<script src="assets/user/js/jquery.easing-1.3.min.js"></script>
	<script src="assets/user/js/jquery.scrollTo-1.4.3.1-min.js"></script>
	<script src="assets/user/js/shop.js"></script>
</footer>

