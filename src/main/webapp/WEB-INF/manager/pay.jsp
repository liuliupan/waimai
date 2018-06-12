<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <title>跳转到支付宝页面</title>
    <meta charset="UTF-8">
    <script type="text/javascript">
	  window.onload = function(){
	  		document.getElementById("aform").submit();
	  };
	</script>
</head>
<body>
	<a>正在跳转支付宝。。。</a>
	<form action="${requestUrl}" method="post" id="aform">
		<c:forEach items="${params}" var="entry">
			<input   type="hidden" name="${entry.key}" value="${entry.value}"/> <!-- -->
		</c:forEach>
	</form>
</body>
</html>
