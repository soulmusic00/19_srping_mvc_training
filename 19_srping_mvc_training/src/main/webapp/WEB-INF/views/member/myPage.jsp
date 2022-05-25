<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="${contextPath}/resources/ckeditor/ckeditor.js"></script>  
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
	<h2>마이 페이지 : ${memberDto.memberId }님의 페이지 입니다.</h2>
	<form action="${contextPath}/member/update" method="post">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td>
		            <input type="text" name="memberId" id="memberId" maxlength="15" value="${memberDto.memberId }" readonly/>&emsp;
		        </td>
		    </tr>
	        <tr>
		        <td>비밀번호</td>
		        <td><input type="password" name="memberPw" placeholder="비밀번호를 입력하세요." /></td>
	        </tr>
	        <tr>
		        <td>이름</td>
		        <td><input type="text" name="memberName" value="${memberDto.memberName }" maxlength="15" placeholder="이름을 입력하세요." /></td>
	        </tr>                
		    <tr>
		        <td>성별</td>
		        <td>
		        	<c:choose>
		        		<c:when test="${memberDto.memberGender eq 'man'}">
				        	<input type="radio" name="memberGender" value="man" checked /> 남성&emsp;&emsp;&emsp;
							<input type="radio" name="memberGender" value="women" />여성
						</c:when>
						<c:otherwise>
							<input type="radio" name="memberGender" value="man" /> 남성&emsp;&emsp;&emsp;
							<input type="radio" name="memberGender" value="women" checked />여성
						</c:otherwise> 
		        	</c:choose>
		        </td>
	        </tr>                              
	        <tr>
		        <td>생년월일</td>
		        <td>
	                <select name="memberBirthY" >
						<c:forEach var="year" begin="1" end="100">
							<option value="${1921+year}" <c:if test="${memberDto.memberBirthY eq 1921+year}"> selected </c:if>>${ 1921+year}</option>
						</c:forEach>
					</select> 년 
					<select name="memberBirthM">
					  	<c:forEach var="month" begin="1" end="12">
						   <option value="${month}" <c:if test="${memberDto.memberBirthM eq month}">selected </c:if>>${month }</option>
					  	</c:forEach>
					</select> 월  
					<select name="memberBirthD">
						<c:forEach var="day" begin="1" end="31">
							<option value="${day}" <c:if test="${memberDto.memberBirthD eq day}">selected </c:if>>${day}</option>
						</c:forEach>
					</select> 일 &emsp;
					<c:choose>
						<c:when test="${memberDto.memberBirthGn eq '2'}">
							<input type="radio" name="memberBirthGn" value="2" checked /> 양력
							<input type="radio" name="memberBirthGn" value="1" />음력
						</c:when>
						<c:otherwise>
							<input type="radio" name="memberBirthGn" value="2" /> 양력
							<input type="radio" name="memberBirthGn" value="1" checked/>음력
						</c:otherwise>
					</c:choose>
		        </td>
	        </tr>                        
	        <tr>
		        <td>핸드폰 번호</td>
		        <td>
		        	<select name="hp1" >
						<option>없음</option>
						<option <c:if test="${memberDto.hp1 eq '010' }"> selected </c:if> value="010">010</option>
						<option <c:if test="${memberDto.hp1 eq '011' }"> selected </c:if> value="011">011</option>
						<option <c:if test="${memberDto.hp1 eq '019' }"> selected </c:if> value="019">019</option>
					</select> - 
					<input size="10px" type="text" name="hp2" value="${memberDto.hp2}"> - 
					<input size="10px" type="text" name="hp3" value="${memberDto.hp3}">
					<input id="smsstsYn" type="checkbox" name="smsstsYn" <c:if test="${memberDto.smsstsYn == 'y'}"> checked</c:if>/>
	                스프링에서 발송하는 SMS 소식을 수신합니다.
		        </td>
	        </tr>                         
	        <tr>
		        <td>이메일</td>
		        <td>
		        	<input type="email" name="email" value="${memberDto.email}">  
	                <input id="emailstsYn" type="checkbox" name="emailstsYn" <c:if test="${memberDto.emailstsYn == 'y'}"> checked</c:if>/>
	                스프링에서 발송하는 E-mail을 수신합니다.
		        </td>
	        </tr>                              
	        <tr>
		        <td>주소</td>
		        <td>
		        	<input type="text" placeholder="우편번호 입력" name="zipcode" value="${memberDto.zipcode }" >
	                <input type="button" onclick="javascript:execDaumPostcode()" value="검색">
	                <br><br><br>
	                도로명 주소 : <input type="text" name="roadAddress" id="roadAddress" value="${memberDto.roadAddress }"> <br>
					지번 주소 : <input type="text"  name="jibunAddress" id="jibunAddress" value="${memberDto.jibunAddress }"> <br>
					나머지 주소: <input type="text" name="namujiAddress" id="namujiAddress" value="${memberDto.namujiAddress }"/>
		        </td>
	        </tr>
	        <tr>
		        <td>기타</td>
		        <td>
		        	<textarea rows="10" cols="10" name="etc">${memberDto.etc }</textarea>
		        	<script>CKEDITOR.replace('etc');</script>
		        </td>
	        </tr>                                     
	        <tr>
		        <td colspan="2" align="center">
		        	<input type="submit" value="수정하기"  >
		        </td>
		    </tr>
	     </table>
     </form>
	 <a href="${contextPath }/member/main">메인으로 이동하기</a>
</body>
</html>