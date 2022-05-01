/**
 * 
 */

 var isValid = {id:false,pass1:false};
 const ButtonID1 = "#exeBTN";

$(function(){
	jQuery.validator.addMethod("a_Z_0_9", function(value, element) {
				return this.optional(element) || /^([a-zA-Z0-9]+)$/.test(value);
			},
		 "半角英数字を入力してください");
	
	$("#exeBTN").prop("disabled",true);
	
	
	
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
				}
			},
			messages:{
				
				id:{
					required:"IDを入力してください",
					minlength:"短すぎます",
					maxlength:"長すぎます"
				},
				pass1:{
					required:"パスワードを入力してください。",
					minlength:"短すぎます",
					maxlength:"長すぎます"
				}
			},
			errorPlacement:function(error,element){
				var name = element.attr("name");			
				
				$("#error-" + name).text(error.text());
				$("#error-" + name).show();
			},
			success:function(error,element){
				var name = element.name;
				$("#error-" + name).hide();
				
				isValid[name] = true;
				isClear();
				
			},
			highlight:function(element, errorClass, validClass){
				var name = element.name;
				isValid[name] = false;
				isClear();
			}	
		});
	});
});
 