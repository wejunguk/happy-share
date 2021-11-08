<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
  <title>개인회원</title>
	<style>
	label {
		margin-right: 5px;
		text-align: right;
		display: inline-block;
		 width: 100px;
	 }
	</style>
</head>
<body>
<h1>개인회원(MVC)</h1>
<form action='add'>
<label for='f-id'>아이디</label> 
<input id='f-id' type='text' name='id'><br>

<label for='f-password'>암호</label> 
<input id='f-password' type='password' name='password'><br>

<label for='f-name'>이름</label> 
<input id='f-name' type='text' name='name'><br>

<label for='f-tel'>전화</label> 
<input id='f-tel' type='tel' name='tel'><br>

<label for='f-email'>이메일</label>
 <input id='f-email' type='email' name='email'><br>
 
<label for='f-postNo'>우편번호</label> 
<input id='f-postNo' type='number' name='postNo'><br>

<label for='f-basicAddress'>기본주소</label> 
<input id='f-basicAddress' type='text' name='basicAddress'><br>

<label for='f-detailAddress'>상세주소</label> 
<input id='f-detailAddress' type='text' name='detailAddress'><br>

<label for='f-birthdate'>생년월일</label> 
<input id='f-birthdate' type="date" name='birthdate'><br>

<button>등록</button><button>취소</button><br>
</form>

<script type="text/javascript">
    
        function checkValue() {
            // 비밀번호와 비밀번호 확인에 입력된 값이 동일한지 확인
            if(document.userInfo.password.value != document.userInfo.passwordcheck.value) {
                alert("비밀번호를 동일하게 입력하세요.");
                return false;
            }
        }
    
        function goLoginForm() {
            location.href="../volunteer/list";
        }
    
    </script>

</body>
</html>
     