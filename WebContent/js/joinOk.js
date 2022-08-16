/*joinOk.js*/

const joinForm=document.querySelector('#joinForm');
const custNo=document.querySelector('#custNo');
const custName=document.querySelector('#custName');
const phone=document.querySelector('#phone');
const address=document.querySelector('#address');
const joinDate=document.querySelector('#joinDate');
const grade=document.querySelector('#grade');
const city=document.querySelector('#city');
const joinOkBtn=document.querySelector('#joinOkBtn');


joinOkBtn.addEventListener('click', ()=>{
	if(custNo==null || custNo.value=="" || custNo.value<=0) {
		alert("회원번호가 입력되지 않았습니다.");
		custNo.focus();
		return false;
	}
	if(custName==null || custName.value=="" || custName.value<=0) {
		alert("회원성명이 입력되지 않았습니다.");
		custName.focus();
		return false;
	}
	if(phone==null || phone.value=="" || phone.value<=0) {
		alert("전화번호가 입력되지 않았습니다.");
		phone.focus();
		return false;
	}
	if(address==null || address.value=="" || address.value<=0) {
		alert("주소가 입력되지 않았습니다.");
		address.focus();
		return false;
	}
	if(joinDate==null || joinDate.value=="" || joinDate.value<=0) {
		alert("가입일자가 입력되지 않았습니다.");
		joinDate.focus();
		return false;
	}
	if(grade==null || grade.value=="" || grade.value<=0) {
		alert("등급이 입력되지 않았습니다.");
		grade.focus();
		return false;
	}
	if(city==null || city.value=="" || city.value<=0) {
		alert("도시코드가 입력되지 않았습니다.");
		city.focus();
		return false;
	}
	alert("회원등록이 완료 되었습니다.")
	joinForm.submit();
});




















