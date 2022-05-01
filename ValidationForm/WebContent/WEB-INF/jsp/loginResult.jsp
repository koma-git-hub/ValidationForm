<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file = "/common.jsp" %>
<!DOCTYPE html>
<html lang="ja" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title></title>
  </head>
  <body>
    <h1>ようこそ</h1>
    	<p>ようこそ${ account.name }さん</p>
    	<p><a href= ${ JspUrl.INDEX_SERVLET } >TOPへ戻る</a></p>
  </body>
  
</html>