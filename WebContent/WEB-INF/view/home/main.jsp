<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="top.jsp"/>
<style>
#left {
    grid-column-start: 1;
    grid-column-end: 4;
}
#right {
    grid-column-start: 4;
    grid-column-end: 7;
}
</style>
    <div class="grid-item" id="left" style="border: 1px solid black;height:400px">
    	<h1 style="margin-bottom: 100px;">고객 전용</h1>
    	<a href="#" id="cust_join" >회원가입</a><br />
    	<a href="#" id="cust_login" >로 그 인</a>
    </div>
    <div class="grid-item" id="right" style="border: 1px solid black">
    	<h1 style="margin-bottom: 100px;">직원 전용</h1>
    	<a href="#" id="emp_register" >사원등록</a><br />
    	<a href="#" id="emp_access">접속승인</a>
    </div>
    <div class="grid-item" id="right" style="border: 1px solid black">
    	<h1 style="margin-bottom: 100px;">객체지향</h1>
    	<a href="#" id="oop_access">접속하기</a>
    </div>
     <div class="grid-item" id="left" style="border: 1px solid black;height:400px">
    	<h1 style="margin-bottom: 100px;">알고리즘</h1>
    	<a href="#" id="algo_access" >접속하기</a>
    </div>
    
<jsp:include page="bottom.jsp"/>  
<script src="${js}/oop.js"></script>
<script>
$('#emp_register').click(function(){
	location.assign('employee.do?cmd=move&page=register');
});
$('#emp_access').click(function(){
	location.assign('employee.do?cmd=move&page=access');
});
$('#cust_join').click(function(){
	location.assign('customer.do?cmd=move&page=signup');
});
$('#cust_login').click(function(){
	location.assign('customer.do?cmd=move&page=signin');
});
$('#oop_access').click(function(){
	// encap.main();
	test.main();
});
</script>






