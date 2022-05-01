<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file = "/common.jsp" %>
<%
String errorMsg = request.getAttribute("msg")==null?
		"":(String)request.getAttribute("msg");
%>
<!DOCTYPE html>
<html lang="ja" dir="ltr">
  <head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="./CSS/regAccount.css" >
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.0.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.2/dist/jquery.validate.js"></script>
    <title></title>
  </head>
  <body>
    <h1>アカウント新規作成</h1>
    <form class="regAccountInput" action= ${ JspUrl.REG_ACCOUNT_SERVLET } method="post">
      	<div class="text">
      		ニックネーム：
      	</div>
      	<div class="inputArea">
      		<input type="text" name="name"  id="name">
            <br><label id="error-name" for=""></label>
            <label id="DBValid-name"></label>
        </div>
        <div class="text">
        	ID：
        </div>
        <div class="inputArea">
        	<input type="text" name="id" id="id">
            <br><label id="error-id" for=""></label>
            <label id="DBValid-id"></label>
        </div>
        <div class="text">
        	パスワード：
        </div>
        <div class="inputArea">
        	<input type="password" name="pass1" id="pass1">
            <br><label id="error-pass1" for=""></label>
        </div>
        <div class="text">パスワード(再入力)：</div>
        <div class="inputArea">
        	<input type="password" name="pass2" id="pass2">
            <br><label id="error-pass2" for=""></label>
        </div>
        <div class="inputArea">
        	<button type="submit" name="button" id="exeBTN">登録</button> 
        </div>
    </form>
  </body>
  <script type="text/javascript" src="./js/regAccountValidation.js"></script>
  <footer>
    <a href= ${ JspUrl.INDEX_SERVLET } >TOPへ戻る</a>
  </footer>
</html>
