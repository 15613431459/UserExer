$(function() {
	$("#userName").on(
			'blur',
			function() {
				var userName = $("#userName").val();
				$.ajax({
					type : "get",
					url : "/user/ajaxCheckUserName",
					data : {
						"userName" : userName
					},
					dataType : "json",
					async : true,
					success : function(data) {
						if(data=="false"){
							$('#uNameMessage').html('用户名可用');
							$('#uNameMessage').css("color","blue");
							$("input[type='submit']").attr('disabled',false);
						}
						if(data=="true"){
							$("input[type='submit']").attr('disabled',true);
							$('#uNameMessage').html('用户名已存在');
							$('#uNameMessage').css("color","red");
						}
					}

				});
			})

})
