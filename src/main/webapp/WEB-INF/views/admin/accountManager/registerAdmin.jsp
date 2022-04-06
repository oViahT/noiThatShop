<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="row">
		<div class="span4">
			<div class="well">
				<h5>ĐĂNG KÝ TÀI KHOẢN</h5>
				<h6 class="status">${ status }</h6>
				<form:form action="dang-ky-admin" method="POST"
					modelAttribute="usersRegister">
					<div class="control-group">
						<label class="control-label" for="inputEmail">Địa chỉ
							E-mail<sup>*</sup>
						</label>
						<div class="controls">
							<form:input type="email" class="span3" placeholder="Email"
								id="email" path="user" />
						</div>
						<h6 class="status">${ statusEmail }</h6>
					</div>
					<div class="control-group">
						<label class="control-label" for="inputEmail">Mật khẩu<sup>*</sup></label>
						<div class="controls">
							<form:input type="password" class="span3" placeholder="********"
								path="password" />
						</div>
						<h6 class="status">${ statusPassword }</h6>
					</div>
					<div class="control-group">
						<label class="control-label" for="inputEmail">Họ và tên<sup>*</sup></label>
						<div class="controls">
							<form:input type="text" class="span3" placeholder="Trần Văn A"
								path="name" />
						</div>
						<h6 class="status">${ statusName }</h6>
					</div>


					<div class="controls">
						<button type="submit" class="btn block">Tạo tài khoản</button>
					</div>
				</form:form>
			</div>
		</div>
		<div class="span1">&nbsp;</div>
	</div>
	</div>
</body>
</html>