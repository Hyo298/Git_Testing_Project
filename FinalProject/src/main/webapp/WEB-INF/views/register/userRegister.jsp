<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1"/>
<title>Another Class</title>
<link href="<%=request.getContextPath()%>/css/login.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath()%>/css/common.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath()%>/css/register/register.css" rel="stylesheet" type="text/css"/>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.js"></script>

<script type="text/javascript">
		$(()=>{
			var url = 'register/check';
			var checkEng = /[a-z|A-Z|0-9]/;
			$('#member_id').keyup(function(){
				var id = $('#member_id').val();
				var data = {"id":id};
				// 아이디 조회
				$.ajax({
					url: url
					, type: 'POST'
					, data: data
					, success:function(result){
						if(id.length< 5 || id.length > 15){
							console.log(id.length);
							document.getElementById('register_id_text').innerHTML="아이디는 5~ 15자의 영문과 숫자로만 사용가능합니다.";
							$('.register_id_check').val('N');
						}else{
							if(!checkEng.test(id)){
								document.getElementById('register_id_text').innerHTML="아이디는 5~ 15자의 영문과 숫자로만 사용가능합니다.";
								$('.register_id_check').val('N');
							}else{
								if(result=='YES'){
									document.getElementById('register_id_text').innerHTML="사용가능한 아이디입니다";
									$('.register_id_check').val('Y');
								}else{
									document.getElementById('register_id_text').innerHTML="사용중이거나 삭제된 아이디 입니다.";
									$('.register_id_check').val('N');
								}
							}
						}
					}
					, error:function(error){
						console.log(error)
					}
				});
				
			});
			
			$('#member_pw_check, #member_pw').keyup(function passWordCheck(){
				var checkPwd = $('#member_pw').val();
				if(checkPwd.length < 8 || checkPwd.length > 20){
					$('#register_pwd_text').html("비밀번호는 8자 이상 생성 가능합니다.");
					$('.register_pwd_check').val('N');
				}else{
					$('#register_pwd_text').html("사용가능한 비밀번호");
					$('.register_pwd_check').val('Y');
				}
			});
			
			$('#member_pw_check').keyup(function passWordChecking(){
				var check1 = $('#member_pw').val();
				var check2 = $('#member_pw_check').val();
				if(check1 != "" || check2 != ""){
					$('#register_pwdCh_text').html("비밀번호가 일치하지 않습니다.");
					$('.register_pwd_check').val('N');
					if(check1 == check2){
						$('#register_pwdCh_text').html("비밀번호가 일치합니다.");
						$('.register_pwd_check').val('Y');
					}
				}
			});
			
			$('#member_email_addr').keyup(function emailSeting(){
				var eID = $('#member_email_id').val();
				var addrEmail =$('#member_email_addr').val();
				
				if(!checkEng.test(eID) && !checkEng.test(addrEmail) ){
					document.getElementById('#register_emailCh_text').innerHTML="아이디는 5~ 15자의 영문과 숫자로만 사용가능합니다.";
					$('.register_email_check').val('N');
				}else{
					var emailVal = eID+addrEmail;
					var testing = eID+'@'+addrEmail;
					$('#member_email').attr('value',emailVal);
					$('.register_email_check').val('Y');
				}
			});
			
			$('.register_button').click(function(){
				//최종 전송
				var chk1 = $('.register_id_check').val();
				var chk2 = $('.register_pwd_check').val();
				
				if(chk1 != 'Y' || chk2 != 'Y'){
					return false;
				}
				$('.register_form').submit();
			});
		});
</script>
</head>	
	<body>
	
	<div id="wrap">
	<header id="header">
		<div class="inner-header">
			<h1 class="logo ir-text"><a href="<%=request.getContextPath()%>/">어나더클래스</a></h1>
		</div>
	</header>
	
	<article id="container">
			<div class="contents">
				<div class="login-wrap">
					<div class="input-login-wrap">
						<div class="id-pw-wrap">
							<form class="register_form" method="post" action="<%=request.getContextPath()%>/userJoin" autocomplete="off" >
								<div id="register_id" class="register_input-group">
									<span class="register_input-outline">
										<span class="register_input-box">
											<input type="text" id="member_id" name="member_id" class="register_input" placeholder="아이디" autocomplete=”off” maxlength="15" />
										</span>
											<label id="register_id_text"></label>	
									</span>
								</div>
								<div id="register_pwd" class="register_input-group">
									<span class="register_input-outline">
										<span class="register_input-box">
											<input type="password" id="member_pw" name="member_pw" class="register_input" placeholder="비밀번호" autocomplete=”off” maxlength="16" autocomplete="new-password"/>
										</span>
											<label id="register_pwd_text"></label>
									</span>
								</div>
								<div id="register_pwd" class="register_input-group">
									<span class="register_input-outline">
										<span class="register_input-box">
											<input type="password" id="member_pw_check" name="member_pw_check" class="register_input" placeholder="비밀번호확인" autocomplete=”off” maxlength="16"/>
										</span>
											<label id="register_pwdCh_text"></label>
									</span>
								</div>
								<div id="register_name" class="register_input-group">
									<span class="register_input-outline">
										<span class="register_input-box">
											<input type="text" id="member_name" name="member_name" class="register_input" placeholder="이름" autocomplete=”off” maxlength="7"/>				
										</span>
									</span>
								</div>
								<div id="register_tel" class="register_input-group">
									<span class="register_input-outline">
										<span class="register_input-box">
											<input type="text" id="member_tel" name="member_tel" class="register_input" placeholder="휴대폰번호" autocomplete=”off” maxlength="13"/>				
										</span>
									</span>
								</div>
								<div id="register_email" class="register_input-group">
									<span class="register_input-outline" id="register_input_email">
										<span class="register_input-box">
											<input type="hidden" id="member_email" name="member_email" class="register_input_email" autocomplete=”off”/>
											<input type="text" id="member_email_id" name="member_email_id" class="register_input_email" placeholder="이메일" autocomplete=”off” maxlength="15"/>
										</span>
											<label id="register_emailCh_text"></label>
									</span>
									<span class="register_input-outline" id="register_input_email_addr">
										<span class="register_input-box">	
											<input type="text" id="member_email_addr" name="member_email_addr" class="register_input_email" placeholder="이메일" autocomplete=”off” maxlength="15"/>
										</span>
									</span>
								</div>
								<input type="hidden" class="register_id_check" value="N">
								<input type="hidden" class="register_pwd_check" value="N">
								<input type="hidden" class="register_email_check" value="N">
								<button type="button" class="register_button">회원가입</button>
						</form>
				</div>
			</div>
		</div>
	</div>
</article>
</div>
</body>
</html>