/**
 * 
 */
 $(function() {
	console.log("func")
  //検索ボタンがクリックされたら処理が走ります。
  $('#search_button').click(function() {
	console.log("ajax");
                //HTMLから受け取るデータです。
                var data = {request : $('#request').val()};
                //ここからajaxの処理です。          
                $.ajax({
                        //POST通信
                        type: "POST",
                        //ここでデータの送信先URLを指定します。
                        url: "test",
                        data: data,
                        //処理が成功したら
                        success : function(result) {
                            //HTMLファイル内の該当箇所にレスポンスデータを追加します。
                            console.log("success");
                            $("#validName").text(result);
                        },
                        //処理がエラーであれば
                        error : function() {
                            alert('通信エラー');
                        }
                 });
                 //submitによる画面リロードを防いでいます。
                 return false;
    });
  });