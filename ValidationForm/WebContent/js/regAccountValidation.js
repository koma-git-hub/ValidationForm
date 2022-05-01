/**
 * 
 */
 
 var isValid = {name:false,id:false,pass1:false,pass2:false};
 const ButtonID1 = "#exeBTN";
 
 $(function(){
	jQuery.validator.addMethod("a_Z_0_9", function(value, element) {
				return this.optional(element) || /^([a-zA-Z0-9]+)$/.test(value);
			},
		 "半角英数字を入力してください");
	
	$("#exeBTN").prop("disabled",true);
	
	function ajax(name){
		var text = { 
						inputValue: $("#" + name).val(),
						columnsName: name
					};	
		$.ajax({
			type: "POST",
			url: "ajax",
			data: text,
			success : function(result){
				if(result==""){
					isValid[name] = true;
					isClear();
					$("#DBValid-" + name).text("使用可能です");
					$("#DBValid-" + name).css("color","green");
				}else{
					isValid[name] = false;
					isClear();
					$("#DBValid-" + name).text(result);
					$("#DBValid-" + name).css("color","red");
				}
			}
		});	
	}
	
	function isClear(){
		if(Object.values(isValid).some(val => val==false)){
			$(ButtonID1).prop("disabled",true);
		}else{
			$(ButtonID1).prop("disabled",false);
		}
	}
	
	
	$(".regAccountInput").change(function(){
		$(".regAccountInput").validate({
			rules:{
				name:{
					required:true,
					minlength:4,
					maxlength:8
				},
				id:{
					required:true,
					minlength:4,
					maxlength:8
				},
				pass1:{
					required:true,
					a_Z_0_9:true,
					minlength:6,
					maxlength:12
				},
				pass2:{
					equalTo:"#pass1"
				}
			},
			messages:{
				name:{
					required:"名前を入力してください",
					minlength:"短すぎます",
					maxlength:"長すぎます"
				},
				id:{
					required:"IDを入力してください",
					minlength:"短すぎます",
					maxlength:"長すぎます"
				},
				pass1:{
					required:"パスワードを入力してください。",
					minlength:"短すぎます",
					maxlength:"長すぎます"
				},
				pass2:{
					required:"確認のため、パスワードを入力してください。",
					equalTo:"パスワードが一致しません"
				}
			},
			errorPlacement:function(error,element){
				var name = element.attr("name");			
				$("#DBValid-" + name).hide();
				$("#error-" + name).text(error.text());
				$("#error-" + name).show();
			},
			success:function(error,element){
				var name = element.name;
				$("#error-" + name).hide();
				$("#DBValid-" + name).show();
				if(name == "name" | name == "id"){
					ajax(name);
				}else{
					isValid[name] = true;
					isClear();
				}
			},
			highlight:function(element, errorClass, validClass){
				var name = element.name;
				isValid[name] = false;
				isClear();
			}	
		});
	});
});
 