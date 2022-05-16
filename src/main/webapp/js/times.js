
window.onload=function getTime(){
	var now = new Date();
	var year = now.getFullYear(); //得到年份
	var month = now.getMonth()+1;//得到月份
	var date = now.getDate();//得到日期
	var hour= now.getHours();//得到小时数
	var minute= now.getMinutes();//得到分钟数
	var second= now.getSeconds();//得到秒数
	var result = year+"-"+month+"-"+date+" "+hour+":"+minute+":"+second;
	document.getElementById("gtime").innerHTML=result;
	setTimeout(getTime,1000);
}
function exit(){
	sessionStorage.clear();
	localStorage.clear();
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "../LoginServlet?action=exit", true);
    xhr.send();
    xhr.onreadystatechange = function(){
    	if (xhr.readyState === 4 && xhr.status === 200) {
    		window.location.href="../index.jsp";
    	}
    }
}