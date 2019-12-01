<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="common.jsp" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>layout 后台大布局 - Layui</title>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">知了管理平台</div>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:void('0');">
          <img src="http://t.cn/RCzsdCq" class="layui-nav-img">admin
        </a>
        <dl class="layui-nav-child">
          <dd><a href="">基本资料</a></dd>
          <dd><a href="">密码修改</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item"><a href="">退出</a></li>
    </ul>
  </div>
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
        <li class="layui-nav-item"><a data-id="0" data-title="DEMO示例" data-url="/demo/index">DEMO示例</a></li>
        <li class="layui-nav-item"><a data-id="0" data-title="微课管理" data-url="/user.jsp">微课管理</a></li>
        <li class="layui-nav-item"><a data-id="1" data-title="用户信息" data-url="/user.jsp">用户信息</a></li>
        <li class="layui-nav-item"><a data-id="2" data-title="订单信息" data-url="/user.jsp">订单信息</a></li>
        <li class="layui-nav-item"><a data-id="3" data-title="学币优惠管理" data-url="/user.jsp">学币优惠管理</a></li>
        <li class="layui-nav-item"><a data-id="4" data-title="统计分析" data-url="/user.jsp">统计分析</a></li>
        <li class="layui-nav-item">
          <a href="javascript:void('0')">设置</a>
          <dl class="layui-nav-child">
            <dd><a data-id="5" data-title="资料修改" data-url="/from.jsp">资料修改</a></dd>
            <dd><a data-id="6" data-title="管理员管理" data-url="/from.jsp">管理员管理</a></dd>
          </dl>
        </li>
      </ul>
    </div>
  </div>
  <!--  使用Iframe 的方式弹出右侧页面 -->
  <div class="layui-body" style="bottom: 0px;">
 	<iframe id="iframe" scrolling="auto" frameborder="0" src="${contextPath}/demo/index" style="width:100%;height:100%;"></iframe>
  </div>
</div>
<script>
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
});


layui.use(['element', 'layer', 'jquery'], function () {
    var element = layui.element;
    var $ = layui.$;
    $(".layui-nav-tree li a").click(function(){
    	$("#info").hide();
    	var dataUrl = $(this).attr("data-url");
    	var dataId = $(this).attr("data-id");
    	var dataTitle = $(this).attr("data-title");
    	if(dataUrl !=null && dataUrl !=''){
    		var isOpened = true; 
             $(".layui-tab-title  li").each(function(i,item){
            	  var layId = $(item).attr("lay-id");
            	  if(layId==dataId){
            		  isOpened = false; 
            	  }
              });
            if(isOpened==true){
            	$("#iframe").attr("src", getPath() + dataUrl);
            }
    	}
    });

});
</script>
</body>
</html>
