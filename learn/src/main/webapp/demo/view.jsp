<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../common.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增</title>
</head>
<body>
	<form class="layui-form" id="demoFromView" style="padding-top: 10px;padding-right: 20px">
		 <div class="layui-form-item">
		    <label class="layui-form-label">姓名：</label>
		    <div class="layui-input-block">
		      <input type="text" id="userName" name="userName" autocomplete="off" placeholder="请输入姓名" class="layui-input" disabled="disabled" value="${demo.userName}">
		    </div>
		 </div>
	    
	    <div class="layui-form-item">
		    <label class="layui-form-label">性别：</label>
		    <div class="layui-input-block">
		      <c:if test="${demo.sex==0}">
		      		<input type="radio" id="se" name="sex" value="0" title="男" checked="checked">
		      </c:if>
		      <c:if test="${demo.sex==1}">
		      		<input type="radio" id="se" name="sex" value="1" title="女" checked="checked">
		      </c:if>
		      
		    </div>
		  </div>
	     
	      <div class="layui-form-item">
		    <label class="layui-form-label">爱好：</label>
		    <div class="layui-input-block">
		      <input type="text" name="hobby" autocomplete="off" placeholder="请输入爱好" class="layui-input" disabled="disabled" value="${demo.hobby}">
		    </div>
		 </div>
	     
	     <div class="layui-form-item layui-form-text">
		    <label class="layui-form-label">备注：</label>
		    <div class="layui-input-block">
		      <textarea placeholder="备注" name="remark" class="layui-textarea" disabled="disabled">${demo.remark}</textarea>
		    </div>
		 </div>
	</form>
	
<script>
layui.use(['form'], function(){
  var form = layui.form;
/*   
  form.val('demoFromView', {
	    "username": "${demo.userName}" ,
	    "sex": "${demo.sex}",
	    "hobby": "${demo.hobby}",
	    "remark":"${demo.remark}"
	  }) */
});
</script>
</body>
</html>