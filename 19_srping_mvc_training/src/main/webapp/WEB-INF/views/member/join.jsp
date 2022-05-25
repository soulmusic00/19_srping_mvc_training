<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"  />
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8">
<script src="${contextPath}/resources/jquery/jquery-3.5.1.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="${contextPath}/resources/ckeditor/ckeditor.js"></script>  
<script>

	var validateMemberId = false;

	$().ready(function() {
		
		$("#btnOverlapped").click(function(){
			
		    var memberId = $("#memberId").val();
		    if (memberId == ''){
		   		alert("ID를 입력하세요");
		   		return;
		    }
		   
		    $.ajax({
		       type : "post",
		       url : "${contextPath}/member/overlapped",
		       data : {"id" : memberId},
		       success : function(isOverLapped){
		          if (isOverLapped == "false"){
		          	alert("사용할 수 있는 ID입니다.");
		          	validateMemberId = true;
		          }
		          else {
		          	alert("사용할 수 없는 ID입니다.");
		          	validateMemberId = false;
		          }
		       }
		    });
		});	
		
	});
	
	function checkValidationField() {
		if (!validateMemberId) {
			alert("아이디를 확인해주세요.");
			return false;
		}
		
	}
	
	
</script>
<script>
	function execDaumPostcode() {
	    new daum.Postcode({
	        oncomplete: function(data) {
	            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
	
	            // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
	            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	            var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
	            var extraRoadAddr = ''; // 도로명 조합형 주소 변수
	
	            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	            if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                extraRoadAddr += data.bname;
	            }
	            // 건물명이 있고, 공동주택일 경우 추가한다.
	            if (data.buildingName !== '' && data.apartment === 'Y'){
	               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	            }
	            // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	            if (extraRoadAddr !== ''){
	                extraRoadAddr = ' (' + extraRoadAddr + ')';
	            }
	            // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
	            if (fullRoadAddr !== ''){
	                fullRoadAddr += extraRoadAddr;
	            }
	
	            // 우편번호와 주소 정보를 해당 필드에 넣는다.
	            document.getElementById('zipcode').value = data.zonecode; //5자리 새우편번호 사용
	            document.getElementById('roadAddress').value = fullRoadAddr;
	            document.getElementById('jibunAddress').value = data.jibunAddress;
	
	        }
	    }).open();
	}
</script>

</head>
<body>
	<form action="${contextPath}/member/join" method="post" onsubmit="return checkValidationField()">
		<h3>회원가입</h3>
		<table border="1">
			<tr>
				<td>아이디</td>
				<td>
		            <input type="text" name="memberId" id="memberId" maxlength="15" placeholder="아이디를 입력하세요." />&emsp;
		            <input type="button" id="btnOverlapped" value="중복확인" />
		        </td>
		    </tr>
	        <tr>
		        <td>비밀번호</td>
		        <td><input type="password" name="memberPw" placeholder="비밀번호를 입력하세요." /></td>
	        </tr>
	        <tr>
		        <td>이름</td>
		        <td><input type="text" name="memberName" maxlength="15" placeholder="이름을 입력하세요." /></td>
	        </tr>                
		    <tr>
		        <td>성별</td>
		        <td>
		        	<input type="radio" name="memberGender" value="man" checked /> 남성&emsp;&emsp;&emsp;
					<input type="radio" name="memberGender" value="women" />여성
		        </td>
	        </tr>                              
	        <tr>
		        <td>생년월일</td>
		        <td>
	                <select name="memberBirthY" >
						<c:forEach var="year" begin="1" end="100">
							<option value="${1921 + year}" selected>${1921 + year}</option>
						</c:forEach>
					</select> 년 
					<select name="memberBirthM">
					  	<c:forEach var="month" begin="1" end="12">
						   <option value="${month}">${month }</option>
					  	</c:forEach>
					</select> 월  
					<select name="memberBirthD">
						<c:forEach var="day" begin="1" end="31">
							<option value="${day}" selected>${day}</option>
						</c:forEach>
					</select> 일 &emsp;
					<input type="radio" name="memberBirthGn" value="2" checked /> 양력
					<input type="radio" name="memberBirthGn" value="1" />음력
		        </td>
	        </tr>                        
	        <tr>
		        <td>핸드폰 번호</td>
		        <td>
		        	<select name="hp1" >
						<option>없음</option>
						<option selected value="010">010</option>
						<option value="011">011</option>
						<option value="019">019</option>
					</select> - 
					<input size="10px" type="text" name="hp2"> - 
					<input size="10px" type="text" name="hp3">
					<input id="smsstsYn" type="checkbox" name="smsstsYn"  value="Y" checked/>
	                스프링에서 발송하는 SMS 소식을 수신합니다.
		        </td>
	        </tr>                         
	        <tr>
		        <td>이메일</td>
		        <td>
		        	<input type="email" name="email" >  
	                <input id="emailstsYn" type="checkbox" name="emailstsYn" value="Y" checked/>
	                스프링에서 발송하는 E-mail을 수신합니다.
		        </td>
	        </tr>                              
	        <tr>
		        <td>주소</td>
		        <td>
		        	<input type="text" placeholder="우편번호 입력" id="zipcode" name="zipcode" >
	                <input type="button" onclick="javascript:execDaumPostcode()" value="검색">
	                <br> <br>
	                도로명 주소 : <input type="text" name="roadAddress" id="roadAddress"> <br>
					지번 주소 : <input type="text"  name="jibunAddress" id="jibunAddress"> <br>
					나머지 주소: <input type="text" name="namujiAddress" id="namujiAddress"/>
		        </td>
	        </tr>
	        <tr>
		        <td>기타</td>
		        <td>
		        	<textarea rows="10" cols="10" name="etc"></textarea>
		        	<script>CKEDITOR.replace('etc');</script>
		        </td>
	        </tr>                                     
	        <tr>
		        <td colspan="2" align="center">
		        	<input type="submit" value="회원가입하기"  >
		        </td>
		    </tr>
		    <tr>
		        <td colspan="2" align="center">
		        	이미 회원가입이 되어있다면 ? <a href="${contextPath}/member/login"><strong>로그인하기</strong></a>
		        </td>
	        </tr>                            
	     </table>
     </form>
</body>
</html>