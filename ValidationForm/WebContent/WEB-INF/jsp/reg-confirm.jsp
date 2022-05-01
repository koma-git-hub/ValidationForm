<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file = "/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./CSS/reg-confirm.css" >
<title>Insert title here</title>
</head>
	<body>
	    <h1>登録内容の確認</h1>
	    <ul type="none">
      		<li>
		        <div class="columns">
		          ニックネーム：
		        </div>
		        <div class="value" id="regName">
		          ${account.name}
		        </div>
			</li>
			<li>
				<div class="columns">
				  ID：
				</div>
				<div class="value" id="regId">
				  ${account.id}
				</div>
			</li>
			<li>
				<div class="columns">
				  Pass：
				</div>
				<div class="value" id="pass">
				  ${account.pass}
				</div>
			</li>
    	</ul>
	    <div class="">
	      登録内容に間違いがなければ登録ボタンを押してください。
	    </div>
	    

	    
	    <button type="button" name="button" onclick="location.href='/ValidationForm/regConfirm'">登録</button>
	    <button type="button" name="button" onclick="location.href='/ValidationForm/regAccount'">入力しなおす</button>
	</body>
	
</html>