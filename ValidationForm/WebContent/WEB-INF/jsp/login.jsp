<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file = "/common.jsp" %>
<!DOCTYPE html>
<html lang="ja" dir="ltr">
  <head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="./CSS/login.css" >
    <script src="https://code.jquery.com/jquery-3.0.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.2/dist/jquery.validate.js"></script>
    <title></title>
  </head>
  <body>
    <h1>既存のアカウントでログイン</h1>
    <p class="isLogin"> ${ isLogin } </p>
    <form class="regAccountInput" action= ${ JspUrl.LOGIN_SERVLET } method="post">
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
        <div class="inputArea">
        	<button type="submit" name="button" id="exeBTN">ログイン</button> 
        </div>

    </form>
  </body>
  <script type="text/javascript" src="./js/loginValidation.js"></script>
  <footer>
    <ul>
      <li><a href= ${ JspUrl.REG_ACCOUNT_SERVLET } >アカウント新規作成</a></li>
      <li><a href= ${ JspUrl.INDEX_SERVLET } >TOPへ戻る</a></li>
    </ul>
  </footer>
</html>
