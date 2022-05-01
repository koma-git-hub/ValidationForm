<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file = "/common.jsp" %>
<!DOCTYPE html>
<html lang="ja" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>DB登録、ログイン、入力値チェック</title>
  </head>
  <body>
    <h1>サンプルページへようこそ</h1>
    <ul>
      <li><a href= ${ JspUrl.LOGIN_SERVLET } >既存のアカウントでログイン</a></li>
      <li><a href= ${ JspUrl.REG_ACCOUNT_SERVLET } >アカウント新規登録</a></li>
    </ul>
  </body>
</html>
