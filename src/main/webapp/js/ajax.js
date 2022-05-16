/**
 * 
 */

window.onload=function loadinfo(){
	removeRow();
	var stu = sessionStorage.getItem("student");
	if(stu===null){
		var cou = sessionStorage.getItem("course");
		console.log(cou);
		if(cou===null){
			var te = sessionStorage.getItem("teacher");
			console.log(te);
			obj = JSON.parse(te);
			createTeacher(obj);
		}else{
			obj = JSON.parse(cou);
			var arr = getCourseEle(obj);
			createCourseTable(arr);
		}
	}else{
		obj=JSON.parse(stu);
		createStudent(obj);
	}
	
}
//获取个人的信息
function getselfinfo(ser,Id){
	removeRow();
	removeItem();
	if(ser==="student"){
		var xhr = new XMLHttpRequest();
        xhr.open("GET", "../StudentServlet?action=queryById&studentId="+Id, true);
        xhr.send();
        xhr.onreadystatechange = function(){
            if (xhr.readyState === 4 && xhr.status === 200) {
			  var obj = JSON.parse(xhr.responseText);
			  createStudent(obj);
			  window.sessionStorage.setItem("student",JSON.stringify(obj));
			  localStorage.setItem("student",JSON.stringify(obj));
      	  }
	   }
	
	}else if("teacher"===ser){
		var xhr = new XMLHttpRequest();
		xhr.open("GET", "../TeacherServlet?action=queryById&teacherId="+Id, true);
		xhr.send();
		xhr.onreadystatechange = function(){
            if (xhr.readyState === 4 && xhr.status === 200) {
			  var obj = JSON.parse(xhr.responseText);
			  createTeacher(obj);
			  window.sessionStorage.setItem("teacher",JSON.stringify(obj));
			  localStorage.setItem("teacher",JSON.stringify(obj));
      	  }
		}
	}else if("admin"===ser){
		
	}
}
//获取课表
function getcourseinfo(ser){
	removeRow();
	removeItem();
	if("teacher"===ser){
		var Id = localStorage.getItem("account");
		var xhr = new XMLHttpRequest();
	    xhr.open("GET", "../CourseServlet?action=queryByTeacherName&c_teacher="+Id, true);
	    xhr.send();
	    xhr.onreadystatechange = function(){
	        if (xhr.readyState === 4 && xhr.status === 200) {
				var obj = JSON.parse(xhr.responseText);
				var arr = getCourseEle(obj);
				createCourseTable(ser,arr);
				window.sessionStorage.setItem("course",JSON.stringify(obj));
	        }                
	    }
	}else if("student"===ser){
		Id = localStorage.getItem("班级");
		var xhr = new XMLHttpRequest();
	    xhr.open("GET", "../CourseServlet?action=queryByClass&c_class="+Id, true);
	    xhr.send();
	    xhr.onreadystatechange = function(){
	        if (xhr.readyState === 4 && xhr.status === 200) {
				var obj = JSON.parse(xhr.responseText);
				var arr = getCourseEle(obj);
				createCourseTable(ser,arr);
				window.sessionStorage.setItem("course",JSON.stringify(obj));
	        }                
	    }
	}else if("admin"===ser){
		
	}
    
}
//获得学生查看的个人信息
function getteacherinfo(){
	removeRow();
	removeItem();
	className = localStorage.getItem("班级");
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "../TeacherServlet?action=queryByClassName&className="+className, true);
    xhr.send();
    xhr.onreadystatechange = function(){
    	if (xhr.readyState === 4 && xhr.status === 200) {
			var obj = JSON.parse(xhr.responseText);
			createTeachers(obj);
			window.sessionStorage.setItem("teacher",JSON.stringify(obj));
		}
	}
}
//创建学生查看的个人信息
function createStudent(obj) {
	var map = new Map([["studentId","学号"],["studentName","姓名"],
						["studentSex","性别"],["politicalStatus","政治面貌"],["studentIDCard","身份证"],
						["studentAddress","家庭地址"],["className","班级"],["schoolName","学校"],["studentBirthday","出生年月"]]);
	var table = document.getElementById("view");
	table.style.width = "300px";
    table.style.height = "300px";
    table.style.marginTop = "130px";
    table.style.marginLeft = "400px";
    for (var [key,value] of map) {
        var tr = document.createElement("tr");
        var td1 = document.createElement("td");
        var td2 = document.createElement("td");
        var text_name = document.createTextNode(value+":");
        var text = document.createTextNode(obj[key]);
		if(value==="班级"){
			localStorage.setItem("班级",obj[key]);
		}
        td1.appendChild(text_name);
        td1.style.width="80px";
        td1.style.textAlign="justify";
        td1.style.textAlignLast="justify";
        td1.style.textAlign = "center";
        td2.appendChild(text);
		td2.style.width="auto";
        td2.style.border = "1px solid";
        td2.style.textAlign = "center";
        tr.appendChild(td1);
        tr.appendChild(td2);
		/*tr.style.width="180px";
		tr.style.height="60px";*/
        table.appendChild(tr);
    }
    
}
//创建教师查看的个人信息
function createTeacher(obj) {
	var map = new Map([["teacherId","教师编号"],["teacherName","姓名"],
						["teacherSex","性别"],["politicalStatus","政治面貌"],["teacherIDCard","身份证"],
						["teacherAddress","家庭地址"],["className","班级"],["schoolName","学校"],["teacherBirthday","出生年月"]]);
	var table = document.getElementById("view");
	table.style.width = "300px";
    table.style.height = "300px";
    table.style.marginTop = "130px";
    table.style.marginLeft = "400px";
	for (var key in obj) {
        var tr = document.createElement("tr");
        var td1 = document.createElement("td");
        var td2 = document.createElement("td");
        var text_name = document.createTextNode(map.get(key));
        var text = document.createTextNode(obj[key]);
        if(key==="teacherId"){
        	localStorage.setItem("account",obj[key]);
        }
        td1.appendChild(text_name);
        td1.style.border = "1px solid";
        td1.style.width = "75px";
        td1.style.textAlign = "center";
        td2.appendChild(text);
        td2.style.border = "1px solid";
        td2.style.textAlign = "center";
        tr.appendChild(td1);
        tr.appendChild(td2);
        table.appendChild(tr);
    }
}
//创建学生查看的教师信息
function createTeachers(obj) {
	var table = document.getElementById("view");
    table.style.width = "300px";
    table.style.height = "300px";
    table.style.marginTop = "130px";
    table.style.marginLeft = "400px";
    var map = new Map([["teacherName", "教师姓名"], ["teacherSex", "性别"], ["className", "授课班级"]]);
    for (var i = 0; i < obj.length; i++) {
        for (var [key, value] of map) {
	        var tr = document.createElement("tr");
	        tr.style.width = "100%";
			tr.style.height="10px";
            var td1 = document.createElement("td");
            var td2 = document.createElement("td");
            var te_name = document.createTextNode(value+":");
            var text = document.createTextNode(obj[i][key]);
            td1.style.width = "70px";
            td1.style.height="10px";
            td1.appendChild(te_name);
            td2.style.width = "auto";
            td2.style.height = "10px";
            td1.style.textAlign = "center";
            td2.style.textAlign = "center";
            td1.style.textAlign="justify";
            td1.style.textAlignLast="justify";
            td2.style.border="1px";
            td2.appendChild(text);
            tr.appendChild(td1);
            tr.appendChild(td2);
            table.appendChild(tr);
        }
    }
}
//创建课表
function createCourseTable(ser,arr) {
	var map = new Map([["1","周一"],["2","周二"],["3","周三"],["4","周四"],["5","周五"],["6","周六"],["7","周日"]]);
  	var table = document.getElementById("view");
	table.style.width="100%";
	/*table.style.height="100%";*/
	table.style.margin="0px";
    var tr = document.createElement("tr");
    for (var [key, value] of map) {
        var td = document.createElement("td");
        var num = document.createTextNode(value);
		td.appendChild(num);
        td.style.border = "1px solid";
        td.style.textAlign = "center";
        td.style.height = "30px";
        tr.appendChild(td);
        table.appendChild(tr);
    }
    for (var i = 0; i < 4; i++) {
        var tr = document.createElement("tr");
        for (var j = 0; j < 7; j++) {
            var td = document.createElement("td");
            var text = document.createTextNode(arr[i][j]);
            var button = document.createElement("button");
	        button.appendChild(text);
	        button.style.width="auto";
	        if(ser==="teacher"){
	        	button.setAttribute("onclick","updatecourse('"+text.textContent.substring(0, text.textContent.length - 6)+"')");
	        }
	        button.style.marginLeft="0px";
	        td.appendChild(button);
            td.style.border = "1px solid";
            td.style.textAlign = "center";
            tr.appendChild(td);
        }
        table.appendChild(tr);
    }
}
function getClasses(){
	var xhr = new XMLHttpRequest();
		xhr.open("GET", "../AdminServlet?action=queryClasses", true);
		xhr.send();
		xhr.onreadystatechange = function(){
			if (xhr.readyState === 4 && xhr.status === 200) {
			sessionStorage.setItem("classes",xhr.responseText.toString());
			}
		}
}
//修改信息
function updateinfo(ser){
	getClasses();
	var classes = JSON.parse(sessionStorage.getItem("classes"));
	if(ser==="student"){
		var map = new Map([["studentId","学号"],["studentName","姓名"],
							["studentSex","性别"],["politicalStatus","政治面貌"],["studentIDCard","身份证"],
							["studentAddress","家庭地址"],["className","班级"],["schoolName","学校"],["studentBirthday","出生年月"]]);
		var div = document.getElementById("right");
		var table = document.getElementById("view");
		div.removeChild(table);
		var form = document.createElement("form");
		form.setAttribute("action","../StudentServlet");
		form.setAttribute("method","POST");
		form.style.width="58.8%";
		form.style.height="85%";
		form.style.paddingLeft="450px";
		form.style.paddingTop="80px";
		form.style.backgroundColor="#aaa";
		form.style.position="static";
		form.style.top="5px";
		form.style.left="5px";
		var str = localStorage.getItem("student");
		var obj = JSON.parse(str);
		for(var key in obj){
			if(key==="className"){
				var span = document.createElement("span");
				var text = document.createTextNode("班级:");
				span.appendChild(text);
				span.style.display="inline-block";
				span.style.textAlign="justify";
				span.style.textAlignLast="justify";
				span.style.width="70px";
				span.style.height="25px;"
				var select = document.createElement("select");
				select.setAttribute("name","className");
				select.style.width="200px";
				select.style.textAlign="center";
				select.style.margin="2px auto";
				select.style.borderRadius="0px";
				for(var i=0;i<classes.length;i++){
				　　for(var cla in classes[i]){
					var op = document.createElement("option");
					op.setAttribute("value",classes[i][cla]);
					op.appendChild(document.createTextNode(classes[i][cla]));
					select.appendChild(op);
				　　}
				}
				form.appendChild(span);
				form.appendChild(select);
				var br = document.createElement("br");
				form.appendChild(br);
				continue;
			}
			var span = document.createElement("span");
			var text = document.createTextNode(map.get(key)+":");
			span.appendChild(text);
			span.style.display="inline-block";
			span.style.textAlign="justify";
			span.style.textAlignLast="justify";
			span.style.width="70px";
			span.style.height="25px;"
			var input = document.createElement("input");
			if(key==="studentId"){
				input.setAttribute("readonly","readonly");
			}
			
			input.setAttribute("name",key);
			input.setAttribute("value",obj[key]);
			input.setAttribute("type","text");
			input.style.width="200px";
			input.style.textAlign="center";
			input.style.margin="2px auto";
			input.style.borderRadius="0px";
			var br = document.createElement("br");
			form.appendChild(span);
			form.appendChild(input);
			form.appendChild(br);
		}
		var sub = document.createElement("input");
		var action = document.createElement("input");
		action.setAttribute("name","action");
		action.setAttribute("value","update")
		action.setAttribute("type","hidden");
		sub.setAttribute("type","submit");
		sub.setAttribute("value","提交");
		sub.style.width="270px";
		form.appendChild(action);
		form.appendChild(sub);
		div.appendChild(form);
	}else if(ser==="teacher"){
		var map = new Map([["teacherId","教师编号"],["teacherName","姓名"],
						["teacherSex","性别"],["politicalStatus","政治面貌"],["teacherIDCard","身份证"],
						["teacherAddress","家庭地址"],["className","班级"],["schoolName","学校"],["teacherBirthday","出生年月"]]);
		var div = document.getElementById("right");
		var table = document.getElementById("view");
		div.removeChild(table);
		var form = document.createElement("form");
		form.setAttribute("action","../TeacherServlet");
		form.setAttribute("method","POST");
		form.style.width="58.8%";
		form.style.height="85%";
		form.style.paddingLeft="450px";
		form.style.paddingTop="80px";
		form.style.backgroundColor="#aaa";
		form.style.position="static";
		form.style.top="5px";
		form.style.left="5px";
		var str = localStorage.getItem("teacher");
		var obj = JSON.parse(str);
		for(var key in obj){
			var span = document.createElement("span");
			var text = document.createTextNode(map.get(key)+":");
			span.appendChild(text);
			span.style.display="inline-block";
			span.style.textAlign="justify";
			span.style.textAlignLast="justify";
			span.style.width="70px";
			span.style.height="25px;"
			var input = document.createElement("input");
			if(key==="studentId"){
				input.setAttribute("readonly","readonly");
			}
			input.setAttribute("name",key);
			input.setAttribute("value",obj[key]);
			input.setAttribute("type","text");
			input.style.width="200px";
			input.style.textAlign="center";
			input.style.margin="2px auto";
			input.style.borderRadius="0px";
			var br = document.createElement("br");
			form.appendChild(span);
			form.appendChild(input);
			form.appendChild(br);
		}
		var sub = document.createElement("input");
		var action = document.createElement("input");
		action.setAttribute("name","action");
		action.setAttribute("value","update")
		action.setAttribute("type","hidden");
		sub.setAttribute("type","submit");
		sub.setAttribute("value","提交");
		sub.style.width="270px";
		form.appendChild(action);
		form.appendChild(sub);
		div.appendChild(form);
	}
}


function updatecourse(cname){
		var map = new Map([["id","编号"],["c_name","课程名称"],["c_crs","学分"],
						["c_number","课时"],["c_exam","考试类型"],["c_type","类型"],
						["c_week","单双周"],["c_time","时间"],["c_address","地点"]]);
		var xhr = new XMLHttpRequest();
        xhr.open("GET", "../CourseServlet?action=queryByName&c_name="+cname, true);
        xhr.send();
        xhr.onreadystatechange = function(){
            if (xhr.readyState === 4 && xhr.status === 200) {
			  var obj = JSON.parse(xhr.responseText);
			  for(var i=0;i<obj.length;i++){
			  		var div = document.getElementById("right");
					var table = document.getElementById("view");
					div.removeChild(table);
					var form = document.createElement("form");
					form.setAttribute("action","../CourseServlet");
					form.setAttribute("method","GET");
					form.style.width="58.8%";
					form.style.height="85%";
					form.style.paddingLeft="450px";
					form.style.paddingTop="80px";
					form.style.backgroundColor="#aaa";
					form.style.position="static";
					form.style.top="5px";
					form.style.left="5px";
			  	for(var [key,value] of map){
					var span = document.createElement("span");
					var text = document.createTextNode(value+":");
					span.appendChild(text);
					span.style.display="inline-block";
					span.style.textAlign="justify";
					span.style.textAlignLast="justify";
					span.style.width="70px";
					span.style.height="25px;"
					var input = document.createElement("input");
					if(key==="id"){
						input.setAttribute("readonly","readonly");
					}
					input.setAttribute("name",key);
					input.setAttribute("value",obj[i][key]);
					input.setAttribute("type","text");
					input.style.width="200px";
					input.style.textAlign="center";
					input.style.margin="2px auto";
					input.style.borderRadius="0px";
					var br = document.createElement("br");
					form.appendChild(span);
					form.appendChild(input);
					form.appendChild(br);
				}
				var sub = document.createElement("input");
				var action = document.createElement("input");
				action.setAttribute("name","action");
				action.setAttribute("value","updateCourse")
				action.setAttribute("type","hidden");
				sub.setAttribute("type","submit");
				sub.setAttribute("value","提交");
				sub.style.width="270px";
				form.appendChild(action);
				form.appendChild(sub);
				div.appendChild(form);
			  }
      	  }
	   }
}

//删除表格的所有行
function removeRow() {
	var div = document.getElementById("right");
    var table = document.getElementById("view");
    if(table===null){
    	div.removeChild(document.getElementsByTagName("form")[0]);
    	table = document.createElement("table");
    	table.setAttribute("id","view");
    	div.appendChild(table);
    }
	if(table.rows===null){
		return;
	}
    var rowNum = table.rows.length;
    for (i = 0; i < rowNum; i++) {
        table.deleteRow(i);
        rowNum = rowNum - 1;
        i = i - 1;
    }
}
//删除session存储的信息
function removeItem(){
	var sessionkeys = Object.keys(window.sessionStorage);
	for(var i=0;i<sessionkeys.length;i++){
		window.sessionStorage.removeItem(sessionkeys[i]);
	}
}
//创建存储课表的数组
function createArr() {
    var arr = new Array();
    for (var i = 0; i < 4; i++) {
        arr[i] = new Array();
        for (var j = 0; j < 7; j++) {
            arr[i][j] ="";
        }
    }
return arr;
}
//对数组进行填充
function getCourseEle(obj){
	var myarr = createArr();
	for(var key=0;key<obj.length;key++){
		var ctime=obj[key].c_time;
		var cweek=obj[key].c_week;
		if(ctime.indexOf("1-2节")!=-1){
			if(cweek.indexOf("周一")!=-1){
				myarr[0][0]=obj[key].c_name+obj[key].c_address;
			}else if(cweek.indexOf("周二")!=-1){
				myarr[0][1]=obj[key].c_name+obj[key].c_address;
			}else if(cweek.indexOf("周三")!=-1){
				myarr[0][2]=obj[key].c_name+obj[key].c_address;
			}else if(cweek.indexOf("周四")!=-1){
				myarr[0][3]=obj[key].c_name+obj[key].c_address;
			}else if(cweek.indexOf("周五")!=-1){
				myarr[0][4]=obj[key].c_name+obj[key].c_address;
			}else if(cweek.indexOf("周六")!=-1){
				myarr[0][5]=obj[key].c_name+obj[key].c_address;
			}else if(cweek.indexOf("周日")!=-1){
				myarr[0][6]=obj[key].c_name+obj[key].c_address;
			}
		}else if(ctime.indexOf("3-4节")!=-1){
			if(cweek.indexOf("周一")!=-1){
				myarr[1][0]=obj[key].c_name+obj[key].c_address;
			}else if(cweek.indexOf("周二")!=-1){
				myarr[1][1]=obj[key].c_name+obj[key].c_address;
			}else if(cweek.indexOf("周三")!=-1){
				myarr[1][2]=obj[key].c_name+obj[key].c_address;
			}else if(cweek.indexOf("周四")!=-1){
				myarr[1][3]=obj[key].c_name+obj[key].c_address;
			}else if(cweek.indexOf("周五")!=-1){
				myarr[1][4]=obj[key].c_name+obj[key].c_address;
			}else if(cweek.indexOf("周六")!=-1){
				myarr[1][5]=obj[key].c_name+obj[key].c_address;
			}else if(cweek.indexOf("周日")!=-1){
				myarr[1][6]=obj[key].c_name+obj[key].c_address;
			}
		}else if(ctime.indexOf("5-6节")!=-1){
			if(cweek.indexOf("周一")!=-1){
				myarr[2][0]=obj[key].c_name+obj[key].c_address;
			}else if(cweek.indexOf("周二")!=-1){
				myarr[2][1]=obj[key].c_name+obj.c_address;
			}else if(cweek.indexOf("周三")!=-1){
				myarr[2][2]=obj[key].c_name+obj[key].c_address;
			}else if(cweek.indexOf("周四")!=-1){
				myarr[2][3]=obj[key].c_name+obj[key].c_address;
			}else if(cweek.indexOf("周五")!=-1){
				myarr[2][4]=obj[key].c_name+obj[key].c_address;
			}else if(cweek.indexOf("周六")!=-1){
				myarr[2][5]=obj[key].c_name+obj[key].c_address;
			}else if(cweek.indexOf("周日")!=-1){
				myarr[2][6]=obj[key].c_name+obj[key].c_address;
			}
		}else if(ctime.indexOf("7-8节")!=-1){
			if(cweek.indexOf("周一")!=-1){
				myarr[3][0]=obj[key].c_name+obj[key].c_address;
			}else if(cweek.indexOf("周二")!=-1){
				myarr[3][1]=obj[key].c_name+obj[key].c_address;
			}else if(cweek.indexOf("周三")!=-1){
				myarr[3][2]=obj[key].c_name+obj[key].c_address;
			}else if(cweek.indexOf("周四")!=-1){
				myarr[3][3]=obj[key].c_name+obj[key].c_address;
			}else if(cweek.indexOf("周五")!=-1){
				myarr[3][4]=obj[key].c_name+obj[key].c_address;
			}else if(cweek.indexOf("周六")!=-1){
				myarr[3][5]=obj[key].c_name+obj[key].c_address;
			}else if(cweek.indexOf("周日")!=-1){
				myarr[3][6]=obj[key].c_name+obj[key].c_address;
			}
		}
	}
	
	return myarr;
}