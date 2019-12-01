<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="../common.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 表格列表框 -->
<table class="layui-hide" id="demo" lay-filter="demo"></table>  
<!-- 头部button -->
<script type="text/html" id="toolbarDemo" class='toolbar'>
 	<div class="layui-btn-container">
    	<button class="layui-btn layui-btn-sm" lay-event="addData">新增</button>
   		<button class="layui-btn layui-btn-sm" lay-event="delSelected">删除选中</button>
  	</div>

 
</script>
<!--  右侧操作按钮 -->
<script type="text/html" id="barDemo">
  <button type="button" class="layui-btn layui-btn-xs layui-btn-primary" lay-event="view">查看</button>
  <button type="button" class="layui-btn layui-btn-xs" lay-event="edit">编辑</button>
  <button type="button" class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del">删除</button>
</script>


<script>

var $ = null; //定义全局jquery 符号

layui.use(['table','layer',"jquery"], function(){
  var layer = layui.layer;
  //初始化表格数据
  var table = layui.table;
 	$= layui.$;
  var tableId = table.render({
     elem: '#demo',
     url:'${contextPath}/demo/findByPage',
     id:'demoId',
     toolbar: '#toolbarDemo', //头部button
     cols: [[
     		{type: 'checkbox', fixed: 'left'},
     		{field:'id', width:100, title: 'ID', sort: true},
      		{field:'userName', width:100, title: '用户名'},
      		{field:'sex', width:100, title: '性别', sort: true,templet:function(d){
      			return d.sex==1?"<span style='color:red'>女</span>":"<span style='color:blue'>男</span>";
      		}},
      		{field:'hobby', width:100, title: '爱好',edit: 'text'},
      		{field:'remark', title: '备注', minWidth: 100},
      		{fixed: 'right', title:'操作', toolbar: '#barDemo', width:180}
    ]],
    page: true,
    even: true,
    limits: [5,10, 20, 50, 100]
  });
  
  //添加头部工具栏事件
  table.on('toolbar(demo)', function(obj){
    switch(obj.event){
      case 'addData':
    	  addOrUpdataDataLayer("");
      break;
      case 'delSelected':
    	  var data = table.checkStatus('demoId').data;
    	  var ids = [];
    	  $.each(data,function(i,item){
    		  ids.push(item.id);
    	  });
    	  var delIds = ids.join(",");
    	  
    	  layer.confirm('真的删除所有选中行?', function(index){
              layer.close(index); //关闭confirm 窗口
              delData(delIds);
          });
    	  
      break;
    };
  });
  
  
//监听行工具事件
  table.on('tool(demo)', function(obj){
	var data = obj.data;
	if(obj.event === 'view'){
		viwDataLayer(data.id);
	}else  if(obj.event === 'del'){
      layer.confirm('真的删除该行?', function(index){
          layer.close(index); //挂壁confirm 窗口
          delData(data.id);
      });
    } else if(obj.event === 'edit'){
    	addOrUpdataDataLayer(data.id);
    }
  });
  
  
  function delData(id){
	  delById(getPath()+"/demo/del",id, function(r){
		  if(r.code == 0){//删除成功，
			  layer.alert("删除成功",{icon: 1, title:'提示'},function(alertId){
				  layer.close(alertId);
				  table.reload("demoId",{});
			  });
		  }else{
			  layer.alert("删除失败",{icon: 2, title:'提示'},function(alertId){
				  layer.close(alertId);
				  table.reload("demoId",{});
			  });
		  } 
	  });
  }
  //调用新增弹出层
  function addOrUpdataDataLayer(id){
	 var index = layer.open({
		  type: 2,
		  title:'新增',
		  maxmin :true,//准许最大最小化窗口
		  area: ['800px', '400px'],
		  content : getPath()+'/demo/toAddOrUpdate?id='+id,
		  btn: ['提交', '关闭'],
		  yes: function(index, layero){
			  var form = layer.getChildFrame('#demoFrom', index);
			  $.post(getPath()+"/demo/addOrUpdate",form.serialize(),function(){
				  layer.close(index);
				  //刷新表格
				  table.reload("demoId",{});
			  });
		  },
		  cancel: function(index, layero){
			  layer.close(index);
		  }
	  });
	 //弹出层全屏展示
	 layer.full(index);
  }
  //调用详情弹出层
  function viwDataLayer(id){
	  var index = layer.open({
		  type: 2,
		  title:'查看',
		  maxmin :true,//准许最大最小化窗口
		  area: ['800px', '400px'],
		  content : getPath()+'/demo/toView?id='+id,
		  btn: ['关闭'],
		  yes:function(index, layero){
			  layer.close(index);
		  }
	  });
  }
  
});


</script>
</body>
</html>