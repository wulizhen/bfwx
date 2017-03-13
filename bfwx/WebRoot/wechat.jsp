<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <title>领取红包</title>
    <script src="<%=basePath%>js/jquery-1.8.3.min.js"></script>
    <link rel="stylesheet" href="<%=basePath%>main.css">
</head>
<body>
<header>
    <picture>
        <source srcset="<%=basePath%>img/icon_banner@3X.jpg" media="(min-width:1000px)" />
        <source srcset="<%=basePath%>img/icon_banner@2X.jpg" media="(min-width:640px)" />
        <img srcset="<%=basePath%>img/icon_banner@1X.jpg" alt="banner" />
    </picture>
</header>
<main>
    <div class="content">
        <h1>领取红包</h1>
        <input type="text" placeholder="请输入您的手机号码" id="mobile">
        <span class="get-btn" id="get-btn">我要领取</span>
    </div>
    <div class="get-tips" id="tips"></div>
</main>
<script>
    $(function () {
        var reg = /^1[34578]\d{9}$/;
        $("#get-btn").click(function () {
            var mobile=$("#mobile").val();
            if(mobile =="" || mobile==null)
            {
                $("#tips").html("请输入手机号码");
            }
            else if (!reg.test(mobile))
            {
                $("#tips").html("请输入正确的手机号码");
            }
            else
            {
                $("#tips").html("");
                $.ajax({
                    type:"post",
                    date:{
                        "mobile":mobile,
                    },
                    dateType:"json",
                    url:"url",
                    success:function (result) {
                        if(result.tip==0)
                        {
                            $("#tips").html("您输入的账号目前还未成功邀请好友，请查询后再次输入哦！");
                        }
                        else if(result.tip==1)
                        {
                            $("#tips").html("感谢您的分享，您有新成功邀请人数"+result.person+"人，获取"+(result.person)*40+"元红包奖励。红包稍后会发送至您的微信，请注意查收！");
                        }
                        else if(result.tip==2)
                        {
                            $("#tips").html("您已经领取过红包，且目前没有您的新成功邀请记录哦！");
                        }
                    }
                })
            }
        })
    })
</script>
</body>
</html>
