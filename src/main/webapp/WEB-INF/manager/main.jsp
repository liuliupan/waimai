<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link rel="stylesheet" type="text/css" href="/waimai/chajian/bootstrap/css/bootstrap.css">
<script type="text/javascript" src="/waimai/chajian/jquery/jquery-2.2.3.min.js"></script>
<script type="text/javascript" src="/waimai/chajian/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript">

//填充快递员的表格
$(function () {  
    $('#btSearch').click(function () {  
        var tbody=window.document.getElementById("tbody-result");  
  		//debugger;
        $.ajax({  
            type: "post",  
            dataType: "json",  
            url : "/waimai/kuaidi/weichuli", // 请求URL
            success: function (data) {  
                if (data) {
                	var str="";
                    for (i in data) { 
                    	/*
                    	 <th>订单描述</th>
			                <th>购买窗口</th>
			                <th>订单状态</th>
			                <th>购买或已经收货</th>
			                <th>买家名字</th> 
			                <th>买家电话</th>  
			                <th>送货地址</th>    
                    	*/
                    
                        str += "<tr>" +
                        "<td>" + data[i].order_des + "</td>" +
                        "<td>" + data[i].order_chuangkou + "</td>" +  
                        "<td>" + data[i].order_status + "</td>" +  
                        "<td>" + "<button id='"+ data[i].order_id+"'   name='"+ data[i].order_status+"'  gkname='"+ data[i].gk_dlname+"' onclick='goumai(this)'>&nbsp 快递员购买或顾客收货 &nbsp</button>"+ "</td>" + 
                        "<td>" + data[i].order_mjname + "</td>" +  
                        "<td>" + data[i].order_mjphone + "</td>" +  
                        "<td>" + data[i].order_mjdz + "</td>" + 
                        "<td>" + data[i].order_mjliuyan + "</td>" + 
                        "</tr>";  
                    }  
                    tbody.innerHTML=str;  
                }  
            },  
            error: function () {  
                alert("查询失败")  
            }  
        });  
    });  
}); 

//在上面渲染完成后，我可以把你的2变成顾客已经付款，快递员没有购买




	$(function(){
		//下面这里要写的是怎么去定位用户的当前位置
		$("#ee").val("hehehehe");
		//标签页是怎么切换的
		$('#myTab a').click(function (e) {
			  e.preventDefault()
			  $(this).tab('show')
			});
		//查询所有区县
		$("#quxian").click(function(){
			/** 异步加载部门数据，填充下拉列表 */
			$.ajax({
				url : "/waimai/weizhi/quxian", // 请求URL
				type : "post", // 请求方式
				dataType : "json", // 服务器响应回来的数据类型 
				async : true, // 异步
				success : function(data){ // 请求成功
					// data: [{id: 1, name : '技术部'},{id: 1, name : '技术部'},...]
					// 获取当前查询的部门id
					console.log(data);
					$("#quxianselect").empty(); //追加前，一定要清空
					$.each(data, function(){
						// this : {id: 1, name : '技术部'}
						$("<option/>").val(this.district_code)
									  .text(this.district_name)
									  .appendTo("#quxianselect");
					});
					
				},
				error : function(){ // 请求失败
					alert("数据加载失败！");
				}
			});
		});
		//查询所有街道
		$("#jiedaoclick").click(function(){
			/** 异步加载部门数据，填充下拉列表 */
			$.ajax({
				url : "/waimai/weizhi/jiedao", // 请求URL
				data:{quid:$("#qucode").val()},
				type : "post", // 请求方式
				dataType : "json", // 服务器响应回来的数据类型 
				async : true, // 异步
				success : function(data){ // 请求成功
					// data: [{id: 1, name : '技术部'},{id: 1, name : '技术部'},...]
					// 获取当前查询的部门id
					console.log(data);
					$("#jiedaoselect").empty(); //追加前，一定要清空
					$.each(data, function(){
						// this : {id: 1, name : '技术部'}
						$("<option/>").val(this.zhenjie_code)
									  .text(this.zhenjie_name)
									  .appendTo("#jiedaoselect");
					});
					
				},
				error : function(){ // 请求失败
					alert("数据加载失败！");
				}
			});
		});
			//查询所有大致定位点
			$("#dazhidianclick").click(function(){
				/** 异步加载部门数据，填充下拉列表 */
				$.ajax({
					url : "/waimai/weizhi/dazhidian", // 请求URL
					data:{jiedaocode:$("#jiedaocode").val()},
					type : "post", // 请求方式
					dataType : "json", // 服务器响应回来的数据类型 
					async : true, // 异步
					success : function(data){ // 请求成功
						// data: [{id: 1, name : '技术部'},{id: 1, name : '技术部'},...]
						// 获取当前查询的部门id
						console.log(data);
						$("#dazhidianselect").empty(); //追加前，一定要清空
						$.each(data, function(){
							// this : {id: 1, name : '技术部'}
							$("<option/>").val(this.point_code)
										  .text(this.point_name)
										  .appendTo("#dazhidianselect");
						});
						
					},
					error : function(){ // 请求失败
						alert("数据加载失败！");
					}
				});
		});
		
	});//文档加载完毕的按钮
	//定义下拉钮选中
	function selectOnchang(obj){  
	 var value = obj.options[obj.selectedIndex].value;
	 var text = obj.options[obj.selectedIndex].text;
	 $("#qu").val(text);
	 $("#qucode").val(value);
	}
	function selectjiedao(obj){  
		 var value = obj.options[obj.selectedIndex].value;
		 var text = obj.options[obj.selectedIndex].text;
		 //debugger;
		 $("#jiedao").val(text);
		 $("#jiedaocode").val(value);
	}
	function selectdazhidian(obj){  
		 var value = obj.options[obj.selectedIndex].value;//code
		 var text = obj.options[obj.selectedIndex].text;//name
		 $("#dazhidian").val(text);
		 //一旦顾客选了大致点之后，就可以把大致点数据，插入用户表中去
		 debugger;
		
			$.ajax({
				url : "/waimai/weizhi/gukedazhiweizhi", // 请求URL
				type : "post", // 请求方式
				data:{gk_wzcode:value,
					gk_wzname:text
				},//登陆名字
				dataType : "json", // 服务器响应回来的数据类型 
				async : true, // 异步
				success : function(data){ // 请求成功
					// data: [{id: 1, name : '技术部'},{id: 1, name : '技术部'},...]
					// 获取当前查询的部门id
					//debugger;
					if("1"==data){
						$("#tishiyu").val("大致位置更新成功");				
					}
				},
				error : function(){ // 请求失败
					alert("数据加载失败！");
				}
			});
		
		 
		 
		 $("#jdazhidiancode").val(value);
		 chaxunfj(value);
		 
	}
	//查询快递员未处理的订单，快递员要去拿货
	var weichuli;
	function chaxunweichuli(){
		$.ajax({
			url : "/waimai/kuaidi/weichuli", // 请求URL
			type : "post", // 请求方式
			data:{dlname:"liupan"},//登陆名字
			dataType : "json", // 服务器响应回来的数据类型 
			async : true, // 异步
			success : function(data){ // 请求成功
				// data: [{id: 1, name : '技术部'},{id: 1, name : '技术部'},...]
				// 获取当前查询的部门id
				console.log(data);
				weichuli=data;
			},
			error : function(){ // 请求失败
				alert("数据加载失败！");
			}
		});
	}

	//用户登陆，如果是快递员，则他的状态是3
	function denglu(){
		var username = $("#username").val();
		var pwd = $("#pwd").val();
		if (username== ""){
			msg = "用户不能为空!";
			$("#tishiyu").val(msg);
		}else if (!/^\w{5,15}$/.test(pwd)){
			msg = "密码不能为空!";
			$("#tishiyu").val(msg);
		} 
		$.ajax({
			url : "/waimai/system/denglu", // 请求URL
			type : "post", // 请求方式
			data:{username:username,
				pwd:pwd
			},//登陆名字
			dataType : "json", // 服务器响应回来的数据类型 
			async : true, // 异步
			success : function(data){ // 请求成功
				// data: [{id: 1, name : '技术部'},{id: 1, name : '技术部'},...]
				// 获取当前查询的部门id
				console.log(data);
				$("#tishiyu").val("登陆成功");				
			},
			error : function(){ // 请求失败
				alert("数据加载失败！");
			}
		});
	}
	//用户登陆，和快递员登陆
	function zhuce(){
		//debugger;
		var username = $("#username").val();
		var pwd = $("#pwd").val();
		if (username== ""){
			msg = "用户不能为空!";
			$("#tishiyu").val(msg);
		}else if (!/^\w{5,15}$/.test(pwd)){
			msg = "密码不能为空!";
			$("#tishiyu").val(msg);
		} 
		$.ajax({
			url : "/waimai/system/zhuce", // 请求URL
			type : "post", // 请求方式
			data:{username:username,
				pwd:pwd
			},//登陆名字
			dataType : "json", // 服务器响应回来的数据类型 
			async : true, // 异步
			success : function(data){ // 请求成功
				// data: [{id: 1, name : '技术部'},{id: 1, name : '技术部'},...]
				// 获取当前查询的部门id
				//debugger;
				if("1"==data){
					$("#tishiyu").val("注册成功");				
				}else{
					$("#tishiyu").val("登陆名重复，请更换登陆名");
				}
			},
			error : function(){ // 请求失败
				alert("数据加载失败！");
			}
		});
	}
	
	
	//加载购物车信息
	function chaxungouwuche(){
		$.ajax({
			url : "/waimai/dingdan/findGouwucheByName", // 请求URL
			type : "post", // 请求方式
			//data:{dlname:"liupan"},//登陆名字
			dataType : "json", // 服务器响应回来的数据类型 
			async : true, // 异步
			success : function(data){ // 请求成功
				// data: [{id: 1, name : '技术部'},{id: 1, name : '技术部'},...]
				// 获取当前查询的部门id
				if(data.ck_code==1){
					$("#tishiyu").val("请在同一商家购买并付款");
				}
				
				console.log(data);
				$("#gouwuche").empty(); //追加前，一定要清空
				$.each(data, function(){
					// this : {id: 1, name : '技术部'}
					$("<div/>").html("<button id='"+this.wp_code+"'  name='"+this.wp_name+"' value='"+this.wp_num+"' onclick='jianshaowupin(this)'>&nbsp-&nbsp</button>"   /*"<button id='444'>&nbsp-&nbsp</button>"  */
							+this.wp_name+"，共"+this.wp_num+"个"
							+"&nbsp&nbsp"
							+"<button id='"+this.wp_code+"'  name='"+this.wp_name+"'  value='"+this.wp_num+"'  onclick='zengjiawupin(this)'>&nbsp+&nbsp</button>"
							+"&nbsp&nbsp&nbsp&nbsp")
							.appendTo("#gouwuche");
				});
				
			},
			error : function(){ // 请求失败
				alert("数据加载失败！");
			}
		});
	}
	//下单，填写收货信息，把下单的信息写进表单中，等会一起写入订单表中，订单表还是要有的，没有订单表，怎么去配送
	function xiadan(){
		$("#xiadanxinxi").show();
	}
	//为什么我点击支付后会出现不跳页面的情况呢？因为你这里发的是异步请求。我估计还是只能像例子中的那个样子，要用表单来接收数据的。
	function fukuan(){
		
		
		
		$.ajax({
			url : "/waimai/dingdan/fukuan", // 请求URL
			type : "post", // 请求方式
			data:{
				dizhi:$("dizhi").val(),
				tel:$("tel").val(),
				xingming:$("xingming").val(),
				liuyan:$("liuyan").val(),
				},//登陆名字,根据名字把购物车（提交订单）状态全部的拿出来，配送费3.0元，餐盒0.5，//req.getsession.getUser().get
			//dataType : "json", // 服务器响应回来的数据类型 
			async : true, // 异步
			success : function(data){ // 请求成功
				// data: [{id: 1, name : '技术部'},{id: 1, name : '技术部'},...]
				// 获取当前查询的部门id
				console.log(data);
				if("1"==data){
					//再次去查询购物车的按钮,刷新当前的页面
					chaxungouwuche();
				}				
			},
			error : function(){ // 请求失败
				alert("数据加载失败！");
			}
		});
	}
	//改变购物车中物品的数量
	function jianshaowupin(obj){
		//点击按钮，插入到购物车中
		 $.ajax({
				url : "/waimai/dingdan/jianshaowupin", // 请求URL
				data:{wp_code:obj.id,wp_num:obj.value},
				type : "post", // 请求方式
				dataType : "json", // 服务器响应回来的数据类型 
				async : true, // 异步
				success : function(data){ // 请求成功
					//得到了一个1.
					//debugger;
					if("1"==data){
						//再次去查询购物车的按钮,刷新当前的页面
						chaxungouwuche();
					}
					
				},
				error : function(){ // 请求失败
					alert("数据加载失败！");
				}
			});
	}
	//改变购物车中物品的数量
	function zengjiawupin(obj){
		//点击按钮，插入到购物车中
		 $.ajax({
				url : "/waimai/dingdan/zengjiawupin", // 请求URL
				data:{wp_code:obj.id,wp_num:obj.value},
				type : "post", // 请求方式
				dataType : "json", // 服务器响应回来的数据类型 
				async : true, // 异步
				success : function(data){ // 请求成功
					//得到了一个1.
					//debugger;
					if("1"==data){
						//再次去查询购物车的按钮,刷新当前的页面
						chaxungouwuche();
					}
					
				},
				error : function(){ // 请求失败
					alert("数据加载失败！");
				}
			});
	}
	//查询附近的卖家
	function chaxunfj(value){ 
		//var jingwei =chaxundingwei(value);
			/** 异步加载所有的商家    可以用经纬去拆分，我知道你的大致的经纬度了，我正负两公里范围内的商家都帮你找来，那么我就要把经纬分开存了 */
			//debugger;
			$.ajax({
				url : "/waimai/weizhi/fujinsj", // 请求URL
				data:{pointcode:value},//我带过来的是大致点的坐标
				type : "post", // 请求方式
				dataType : "json", // 服务器响应回来的数据类型 
				async : true, // 异步
				success : function(data){ // 请求成功
					// data: [{id: 1, name : '技术部'},{id: 1, name : '技术部'},...]
					// 这里直接得到了窗口的信息了
					console.log(data);
					//alert(data);
					$("#shangjialist").empty(); //追加前，一定要清空
					$.each(data, function(){
						// this : {id: 1, name : '技术部'}     ////attr("onclick","clickshangjia(this)")
						$("<li class='list-group-item'/>").attr("id",this.ck_bianma)
									  .text(this.ck_ckname).click(this,clickshangjia) 
									  .appendTo("#shangjialist");
					});
					
				},
				error : function(){ // 请求失败
					alert("数据加载失败！");
				}
			});
	}
	//根据窗口去查询菜单
	function clickshangjia(obj){
		//debugger;
		 //alert(obj.data.ck_bianma);
		 //拿到了窗口的编码，我就去找窗口下面的菜
		 $.ajax({
				url : "/waimai/weizhi/caidan", // 请求URL
				data:{ckcode:obj.data.ck_bianma},
				type : "post", // 请求方式
				dataType : "json", // 服务器响应回来的数据类型 
				async : true, // 异步
				success : function(data){ // 请求成功
					// data: [{id: 1, name : '技术部'},{id: 1, name : '技术部'},...]
					// 获取当前查询的部门id
					console.log(data);
					$("#caidan").empty(); //追加前，一定要清空 wp_code name price
					$.each(data, function(){
						// this : {id: 1, name : '技术部'}  .appendTo("<div class='col-xs-4 col-sm-2'></div>")
						
						$("<button style='margin: 1%' onclick='jiaruGWC(this)'/>").html(this.wp_name+":"+this.wp_price).val(this.wp_code).attr("name",this.wp_name+":"+this.wp_price+"元")
									  .appendTo("#caidan");
						
					}); 
					$("#caidan").show();//把隐藏的菜单展示出来,等会怎么来隐藏哦，等会怎么来隐藏这个哦
				},
				error : function(){ // 请求失败
					alert("数据加载失败！");
				}
			});
	}
	function jiaruGWC(obj){ 
		//debugger;
		console.log(obj.value);
		console.log(obj.innerHTML);
		//点击按钮，插入到购物车中
		 $.ajax({
				url : "/waimai/dingdan/addgouwuche", // 请求URL
				data:{wp_code:obj.value,wp_name:obj.name},
				type : "post", // 请求方式
				dataType : "json", // 服务器响应回来的数据类型 
				async : true, // 异步
				success : function(data){ // 请求成功
					//得到了一个1.
					//debugger;
					if("1"==data){
						$("#gouwuchetishi").show();
					}else if("-1"==data){
						$("#tishiyu").val("请在同一商家购买并付款，方便为您配送");	
					}
					
				},
				error : function(){ // 请求失败
					alert("数据加载失败！");
				}
			});
		
		
	}
	//提交信息并付款
	function jiaruGWC(obj){
		//debugger;
		console.log(obj.value);
		console.log(obj.innerHTML);
		//点击按钮，插入到购物车中
		 $.ajax({
				url : "/waimai/dingdan/addgouwuche", // 请求URL
				data:{wp_code:obj.value,wp_name:obj.innerHTML},
				type : "post", // 请求方式
				dataType : "json", // 服务器响应回来的数据类型 
				async : true, // 异步
				success : function(data){ // 请求成功
					//得到了一个1.
					//debugger;
					if("1"==data){
						$("#gouwuchetishi").show();
					}else if("-1"==data){
						$("#tishiyu").val("请在同一商家购买并付款，方便为您配送");	
					}
					
				},
				error : function(){ // 请求失败
					alert("数据加载失败！");
				}
			});
		
		
	}
	
	
	function goumai(obj){
//		console.log(obj.value);
		//debugger;
		//点击按钮，插入到购物车中
		 $.ajax({
				url : "/waimai/kuaidi/goumai", // 请求URL
				data:{order_status:obj.name,order_id:obj.id},
				type : "post", // 请求方式
				dataType : "json", // 服务器响应回来的数据类型 
				async : true, // 异步
				success : function(data){ // 请求成功
					//得到了一个1.
					//debugger;
					if("1"==data){
						$('#btSearch').click();//如果我的点击事件成功了，那么我就可以去再次的查询
					}
					
				},
				error : function(){ // 请求失败
					alert("数据加载失败！");
				}
			});
	}
	
	
</script>
<!-- <title>Insert title here</title>   这个title是不是可以不写的呢 -->
</head> 
<body>
<!-- 这里要可是得到搜索的结果了，我这里要拿到用户的定位 ，用很多的下拉框子，呵呵  -->
	<div class="container">
	 <div class="row" id="dazhiweizhi" >请大致定位你的位置，方便我们为您查找附近的美食。。。您在：武汉市武昌区徐家棚街道水岸国际附近</div>
	   <div class="row" >
			<form role="form">
			<div class="form-group">
				<div id="quxian" class="col-xs-4 col-sm-2"  >
					<label for="name">选择区(县)</label>
					<select id="quxianselect"  class="form-control" onchange="selectOnchang(this)">
						<option>请选择</option>
						<option>11111</option>
						<option>22222</option>
					</select>
				</div>
				<div  id="jiedaoclick" class="col-xs-4 col-sm-2"  >
					<label for="name">选择街道（镇）</label>
					<select id="jiedaoselect" class="form-control" onchange="selectjiedao(this)">
						<option>请选择</option>
						<option>11111</option>
						<option>22222</option>
					</select>
				</div>
				<div class="col-xs-4 col-sm-2" id="dazhidianclick" >
					<label for="name">选择附近建筑</label>
					<select id="dazhidianselect" class="form-control" onchange="selectdazhidian(this)">
						<option>水岸国际</option>
						<option>2</option>
					</select>
				</div>
				</div>
			</form>
		</div>	
		<!--选择之后的结果  -->
		<div class="row" >
	 	<label>大致位置如下：</label>
		<form role="form">
			<div class="form-group">
				<div class="col-xs-3 col-sm-3"  ><input type="text" class="form-control" id="qu" readonly> </div>
				<input type="text" id="qucode" hidden>
				<div class="col-xs-3 col-sm-3"  ><input type="text" class="form-control" id="jiedao" readonly> </div>
				<input type="text" id="jiedaocode" hidden>
				<div class="col-xs-3 col-sm-3"  ><input type="text" class="form-control" id="dazhidian" readonly> </div>
				<input type="text" id="dazhidiancode" hidden>
			</div>
		</form>
		</div>
		<div>
		 &nbsp;
		        	 &nbsp;<font color="red">${tip}</font>
		</div>
		<!--大致的  -->
		<div style="margin-top: 1%">
		<ul id="myTab" class="nav nav-tabs">
			<li class="active">
				<a href="#home" data-toggle="tab">
					为您推荐
				</a>
			</li>
			<li><a href="#ynxg" data-toggle="tab">与你相关</a></li>
			<!-- <li><a href="#kpzs" data-toggle="tab">科普知识</a></li>
			<li><a href="#mrjj" data-toggle="tab">每日金句</a></li> -->
			<li class="dropdown">
				<a href="#" id="myTabDrop1" class="dropdown-toggle" 
				   data-toggle="dropdown">关于我们
					<b class="caret"></b>
				</a>
				<ul class="dropdown-menu" role="menu" aria-labelledby="myTabDrop1">
					<li><a href="#woshikuaidiyuan" tabindex="-1" data-toggle="tab">我是快递员</a></li>
					<li><a href="#jianyi" tabindex="-1" data-toggle="tab">建议</a></li>
					<li><a href="#jianjie" tabindex="-1" data-toggle="tab">公司简介</a></li>
				</ul>
			</li>
		</ul>
		</div>
		<div id="myTabContent" class="tab-content" style="margin-top: 1%">
				<div class="tab-pane fade in active" id="home">
					<div hidden id="caidan">
					
 					</div>
					<div class="alert alert-success" id="gouwuchetishi" hidden>
					    <a href="#" class="alert-link">添加购物车成功！请在'与我相关'中提交订单</a>
					</div>
					 <ul class="list-group" id="shangjialist">
						<li class="list-group-item" id="xxxx" value="xxxx">商家1</li>
						<li class="list-group-item" id="yyyy" value="yyyy">商家2</li>
					</ul>
					
				</div>
			</div>
			<div class="tab-pane fade" id="ynxg">
				<div class="row" >
				<form role="form"  id="dengluzhuce">
  					<div class="form-group">
  						<div>登陆注册</div>
						<div class="col-xs-4 col-sm-4"  ><label>登陆名</label><input type="text" class="form-control" id="username"  > </div>
						<div class="col-xs-4 col-sm-4"  ><label>密码</label><input type="password" class="form-control" id="pwd"> </div>
						<div class="col-xs-4 col-sm-4"  ><input type="text" class="form-control" id="tishiyu" placeholder="用户名和密码非空"> </div>
						<button type="button" class="btn btn-default btn-sm-4" onclick="zhaohui();">找回密码</button>
						<button type="button" class="btn btn-default btn-sm-4" onclick="zhuce();">注册</button>
						<button type="button" class="btn btn-default btn-sm-4" onclick="denglu();">登陆</button>
					</div>
					<div class="form-group" >
						<div  class="col-xs-12 col-sm-12"  >购物车</div>
							<button type="button" class="btn btn-default btn-sm" onclick="chaxungouwuche();">查询我的购物车</button>
							<button type="button" class="btn btn-default btn-sm" onclick="xiadan();">购物车下单</button>
	  						<div id="gouwuche">    <!-- 购物车要有增加和删除的功能 ，我查询当前的登陆人员的购物车，按照窗口来分类，一个窗口就是一个订单-->
							</div>	
						
					</div>
					</form>
					<form role="form" action="/waimai/dingdan/fukuan" method="post" >
					<div class="form-group" >
  						<div  class="col-xs-12 col-sm-12"  >订单</div><!-- 订单只要有查询的功能就可以了，后台运维人员有个查看支付宝的交易状态的，就可以了  -->
  						<!-- 顾客填写订单信息的表单  -->
  							<div id="xiadanxinxi" hidden>
								 <label class="col-sm-1 control-label" for="dizhi">收货地址</label>
		                          <div class="col-sm-11">
		                             <input class="form-control" id="dizhi" name="dizhi" type="text" />
		                          </div>
		                          <label class="col-sm-1 control-label" for="tel">电话</label>
		                          <div class="col-sm-4">
		                             <input class="form-control" id="tel" name="tel" type="text" />
		                          </div>
		                          <label class="col-sm-1 control-label" for="xingming">收货人姓名</label>
		                          <div class="col-sm-4">
		                             <input class="form-control" id="xingming" name="xingming" type="text" />
		                          </div>
		                          <label class="col-sm-1 control-label" for="liuyan">收货人留言</label>
		                          <div class="col-sm-4">
		                             <input class="form-control" id="liuyan" name="liuyan" type="text" />
		                          </div>
								<button type="submit" class="btn btn-primary" type="button">提交信息并支付</button>
		             			&nbsp;&nbsp;<font color="red">${tip}</font>
							</div>				
					</div>
				</form>
				</div>
			</div>
			<div class="tab-pane fade" id="woshikuaidiyuan">
				<button type="button" class="btn btn-default btn-sm" id="btSearch">查询我的配送任务</button>
				 <div class="table-container">  
			        <table class="ui nine column table celled table-result" id="table-result">  
			            <thead>  
			            <tr> 
			                <th>订单描述</th>
			                <th>窗口信息</th>
			                <th>订单状态</th>
			                <th>购买或已经收货</th>
			                <th>买家名字</th>
			                <th>买家留言</th> 
			                <th>买家电话</th>  
			                <th>送货地址</th>    
			            </tr>  
			            </thead>  
			            <tbody id="tbody-result">  
			            </tbody>  
			        </table>  
			    </div>  
			</div>
			<div class="tab-pane fade" id="jianyi">
				<p>良心企业，我希望你们公司越办越好，很开心，呵呵
				</p>
			</div>
		</div>
	</div>
</body>
</html>