<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>Chat</title>

<!-- Set render engine for 360 browser -->
<meta name="renderer" content="webkit">

<!-- No Baidu Siteapp-->
<meta http-equiv="Cache-Control" content="no-siteapp" />

<link rel="alternate icon" href="assets/i/favicon.ico">
<link rel="stylesheet" href="assets/css/amazeui.min.css">
<link rel="stylesheet" href="assets/css/app.css">

<!-- umeditor css -->
<link href="umeditor/themes/default/css/umeditor.css" rel="stylesheet">

<style>
.title {
	text-align: center;
}

.chat-content-container {
	height: 29rem;
	overflow-y: scroll;
	border: 1px solid silver;
}
</style>
</head>
<body>
	<!-- title start -->
	<div class="title">
		<div class="am-g am-g-fixed">
			<div class="am-u-sm-12">
				<h1 class="am-text-primary">Chat with world</h1>
			</div>
		</div>
	</div>
	<!-- title end -->

	<!-- chat content start -->
	<div class="chat-content">
		<div class="am-g am-g-fixed chat-content-container">
			<div class="am-u-sm-12">
				<ul id="message-list" class="am-comments-list am-comments-list-flip"></ul>
			</div>
		</div>
	</div>
	<!-- chat content start -->

	<!-- message input start -->
	<div class="message-input am-margin-top">
		<div class="am-g am-g-fixed">
			<div class="am-u-sm-12">
				<form class="am-form">
					<div class="am-form-group">
						<script type="text/plain" id="myEditor" style="width: 100%;height: 8rem;"></script>
					</div>
				</form>
			</div>
		</div>
		<div class="am-g am-g-fixed am-margin-top">
			<div class="am-u-sm-6">
				<div id="message-input-nickname" class="am-input-group am-input-group-primary">
					<span class="am-input-group-label"><i class="am-icon-user"></i></span>
					<input id="nickname" type="text" class="am-form-field" placeholder="Please enter nickname"/>
				</div>
			</div>
			<div class="am-u-sm-6">
				<button id="send" type="button" class="am-btn am-btn-primary">
					<i class="am-icon-send"></i> Send
				</button>
			</div>
		</div>
	</div>
	<!-- message input end -->

	<!--[if (gte IE 9)|!(IE)]><!-->
	<script src="assets/js/jquery.min.js"></script>
	<!--<![endif]-->
	<!--[if lte IE 8 ]>
	<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
	<![endif]-->
	
	<!-- umeditor js -->
	<script charset="utf-8" src="umeditor/umeditor.config.js"></script>
	<script charset="utf-8" src="umeditor/umeditor.min.js"></script>
	<script src="umeditor/lang/zh-cn/zh-cn.js"></script>
	
	
	   <script>
        $(function() {
            // 初始化消息输入框
            var um = UM.getEditor('myEditor');
            // 使昵称框获取焦点
            $('#nickname')[0].focus();
        });
    </script>
</body>
</html>
	