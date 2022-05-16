/**
 * 
 */
function getStudentRequest(){
	removeRow();
	var div = document.getElementById("right");
	var table = document.getElementById("view");
	table.style.width="100%";
	table.style.height="100%";
	table.style.overflow="scroll";
	if(table===null){
		var form = document.getElementsByTagName("form");
		div.removeChild(form[0]);
		var table = document.createElement("table");
		table.setAttribute("id","view");
	}else{
		arr = new Map([["添加学生","addStudent()"],["查询删除学生","createQueryTable('student')"]]);
		for(var[key,value] of arr){
			tr = document.createElement("tr");
			td = document.createElement("td");
			tx = document.createTextNode(key);
			btn = document.createElement("button");
			btn.style.border="1px solid";
			btn.style.width="100px";
			btn.style.height="30px";
			btn.style.borderRidus="10px";
			btn.appendChild(tx);
			btn.setAttribute("onclick",value);
			btn.style.marginLeft="45%";
			td.appendChild(btn);
			tr.appendChild(td);
			table.appendChild(tr);
		}
		
		
	}
}


function addStudent(){
	var map = new Map([["studentId","学号"],["studentName","姓名"],
							["studentSex","性别"],["politicalStatus","政治面貌"],["studentIdCard","身份证"],
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
		input.setAttribute("name",key);
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
	action.setAttribute("value","add");
	action.setAttribute("type","hidden");
	sub.setAttribute("type","submit");
	sub.setAttribute("value","提交");
	sub.style.width="270px";
	form.appendChild(action);
	form.appendChild(sub);
	div.appendChild(form);
}

function addTeacher(){
	var map = new Map([["teacherId","职工号"],["teacherName","姓名"],
							["teacherSex","性别"],["politicalStatus","政治面貌"],["teacherIdCard","身份证"],
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
		input.setAttribute("name",key);
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
	action.setAttribute("value","add");
	action.setAttribute("type","hidden");
	sub.setAttribute("type","submit");
	sub.setAttribute("value","提交");
	sub.style.width="270px";
	form.appendChild(action);
	form.appendChild(sub);
	div.appendChild(form);
}

function queStudent(){
	var select = document.getElementById("sel");
	action = select.options[select.selectedIndex].value;
	var name = document.getElementById("query").getAttribute("name");
	var tag = document.getElementById("query").value;
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "../StudentServlet?action="+action+"&"+name+"="+tag, true);
    xhr.send();
    xhr.onreadystatechange = function(){
    	if (xhr.readyState === 4 && xhr.status === 200) {
			var obj = JSON.parse(xhr.responseText);
			table = document.getElementById("view");
			map = new Map([["studentId","学号"],["studentName","姓名"],
			["studentIDCard","身份证"],["studentAddress","家庭住址"]]);
			tr = document.createElement("tr");
			for(var [key,value] of map){
				td = document.createElement("td");
				tx = document.createTextNode(value);
				td.appendChild(tx);
				tr.appendChild(td);
			}
			table.appendChild(tr);
			table.style.tableLayout="fixed";
			if(obj.length>=1){
				for(var i=0;i<obj.length;i++){
					var tr = document.createElement("tr");
					tr.style.border="1px solid";
					var studentId;
					for(var [key,value] of map){
						td = document.createElement("td");
						if(key==="studentId"){
							studentId = obj[i][key];
						}
						t_value = document.createTextNode(obj[i][key]);
						td.appendChild(t_value);
						td.style.width="auto";
						tr.appendChild(td);
						tr.setAttribute("display","inline-block");
						table.appendChild(tr);
					}
					var td2 = document.createElement("td");
					button = document.createElement("button");
					button.appendChild(document.createTextNode("删除"));
					button.style.width="80px";
					button.style.height="32px";
					button.setAttribute("onclick","delStudent('"+studentId+"')");
					td2.appendChild(button);
					tr.appendChild(td2);
				}
			}else{
				var tr = document.createElement("tr");
				tr.style.border="1px solid #fff";
				var studentId;
				for(var [key,value] of map){
						if(key==="studentId"){
								studentId = obj[key];
							}
						td = document.createElement("td");
						t_value = document.createTextNode(obj[key]);
						td.appendChild(t_value);
						td.style.width="auto";
						tr.appendChild(td);
						tr.setAttribute("display","inline-block");
						table.appendChild(tr);
				}
				var button = document.createElement("button");
				var td2 = document.createElement("td");
				button.appendChild(document.createTextNode("删除"));
				button.style.width="80px";
				button.style.height="32px";
				button.setAttribute("onclick","delStudent('"+studentId+"')");
				td2.appendChild(button);
				tr.appendChild(td2);
			}
			
			
		}
	}
	
}

function queTeacher(){
	var select = document.getElementById("sel");
	action = select.options[select.selectedIndex].value;
	var name = document.getElementById("query").getAttribute("name");
	var tag = document.getElementById("query").value;
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "../TeacherServlet?action="+action+"&"+name+"="+tag, true);
    xhr.send();
    xhr.onreadystatechange = function(){
    	if (xhr.readyState === 4 && xhr.status === 200) {
			var obj = JSON.parse(xhr.responseText);
			table = document.getElementById("view");
			map = new Map([["teacherId","职工号"],["teacherName","姓名"],
			["teacherIDCard","身份证"],["teacherAddress","家庭住址"]]);
			var tr = document.createElement("tr");
			for(var [key,value] of map){
				td = document.createElement("td");
				tx = document.createTextNode(value);
				td.appendChild(tx);
				tr.appendChild(td);
			}
			table.appendChild(tr);
			table.style.tableLayout="fixed";
			if(obj.length>=1){
				for(var i=0;i<obj.length;i++){
					var tr = document.createElement("tr");
					tr.style.border="1px solid";
					var teacherId;
					for(var [key,value] of map){
						td = document.createElement("td");
						if(key==="teacherId"){
							teacherId = obj[i][key];
						}
						t_value = document.createTextNode(obj[i][key]);
						td.appendChild(t_value);
						td.style.width="auto";
						tr.appendChild(td);
						tr.setAttribute("display","inline-block");
						table.appendChild(tr);
					}
					var td2 = document.createElement("td");
					button = document.createElement("button");
					button.appendChild(document.createTextNode("删除"));
					button.style.width="80px";
					button.style.height="32px";
					button.setAttribute("onclick","delTeacher('"+teacherId+"')");
					td2.appendChild(button);
					tr.appendChild(td2);
				}
			}else{
				var tr = document.createElement("tr");
				tr.style.border="1px solid #fff";
				var teacherId;
				for(var [key,value] of map){
						if(key==="teacherId"){
								teacherId = obj[key];
							}
						td = document.createElement("td");
						t_value = document.createTextNode(obj[key]);
						td.appendChild(t_value);
						td.style.width="auto";
						tr.appendChild(td);
						tr.setAttribute("display","inline-block");
						table.appendChild(tr);
				}
				var button = document.createElement("button");
				var td2 = document.createElement("td");
				button.appendChild(document.createTextNode("删除"));
				button.style.width="80px";
				button.style.height="32px";
				button.setAttribute("onclick","delTeacher('"+teacherId+"')");
				td2.appendChild(button);
				tr.appendChild(td2);
			}	
		}
	}
}

function queCourse(){
	var select = document.getElementById("sel");
	action = select.options[select.selectedIndex].value;
	var name = document.getElementById("query").getAttribute("name");
	var tag = document.getElementById("query").value;
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "../CourseServlet?action="+action+"&"+name+"="+tag, true);
    xhr.send();
    xhr.onreadystatechange = function(){
    	if (xhr.readyState === 4 && xhr.status === 200) {
			var obj = JSON.parse(xhr.responseText);
			table = document.getElementById("view");
			var map = new Map([["id","编号"],["c_name","课程名称"],["c_crs","学分"],
						["c_number","课时"],["c_exam","考试类型"],["c_type","类型"],
						["c_week","单双周"],["c_time","时间"],["c_address","地点"]]);
			var tr = document.createElement("tr");
			for(var [key,value] of map){
				var td = document.createElement("td");
				var tx = document.createTextNode(value);
				td.style.width="100";
				td.appendChild(tx);
				tr.appendChild(td);
			}
			table.appendChild(tr);
			table.style.tableLayout="fixed";
			if(obj.length>=1){
				for(var i=0;i<obj.length;i++){
					var tr = document.createElement("tr");
					tr.style.border="1px solid";
					var Id;
					for(var [key,value] of map){
						td = document.createElement("td");
						if(key==="id"){
							Id = obj[i][key];
						}
						t_value = document.createTextNode(obj[i][key]);
						td.appendChild(t_value);
						td.style.width="auto";
						td.setAttribute("display","inline-block");
						tr.appendChild(td);
						tr.setAttribute("display","inline-block");
						table.appendChild(tr);
					}
					var td2 = document.createElement("td");
					button = document.createElement("button");
					button.appendChild(document.createTextNode("删除"));
					button.setAttribute("onclick","delCourse('"+Id+"')");
					button.style.width="80px";
					button.style.height="32px";
					td2.appendChild(button);
					tr.appendChild(td2);
				}
			}else{
				var tr = document.createElement("tr");
				tr.style.border="1px solid #fff";
				var Id;
				for(var [key,value] of map){
						if(key==="id"){
								Id = obj[key];
							}
						td = document.createElement("td");
						t_value = document.createTextNode(obj[key]);
						td.appendChild(t_value);
						td.style.width="auto";
						td.setAttribute("display","inline-block");
						tr.appendChild(td);
						tr.setAttribute("display","inline-block");
						table.appendChild(tr);
				}
				var button = document.createElement("button");
				var td2 = document.createElement("td");
				button.appendChild(document.createTextNode("删除"));
				button.setAttribute("onclick","delCourse('"+Id+"')");
				button.style.width="80px";
				button.style.height="32px";
				td2.appendChild(button);
				tr.appendChild(td2);
			}	
		}
	}
}

function createQueryTable(tag) {
	removeRow();
    var div = document.getElementById("right");
    var table = document.getElementById("view");
    table.style.width = "100%";
    table.style.height = "100%";
    table.style.position = "static";
    table.style.top = "0px";
    table.style.left = "0px";
    table.style.backgroundColor = "#aaa";
	var tr = document.createElement("tr");
	var td1 = document.createElement("td");
	var td2 = document.createElement("td");
	var td3 = document.createElement("td");
    var select = document.createElement("select");
    select.setAttribute("name", "action");
	if(tag==="teacher"){
		var op = [{ t: '全部', v: 'queryAll' }, { t: '职工号', v: 'queryById' }, { t: '姓名', v: 'queryByName' }];
	}else if(tag==="student"){
		var op = [{ t: '全部', v: 'queryAll' }, { t: '学号', v: 'queryById' }, { t: '姓名', v: 'queryByName' }];
	}else if(tag==="course"){
		var op = [{ t: '全部', v: 'queryAll' }, { t: '教师名', v: 'queryByTeacherName' }, { t: '课名', v: 'queryByName' },{t:'上课班级名',v:'queryByClass'}];
	}
    for (var i in op) {
        var option = new Option(op[i].t, op[i].v);
        select.options.add(option);
    }
    select.style.width = "70px";
    select.style.height="40px";
	select.style.float="left";
    select.setAttribute("id", "sel");
    select.setAttribute("onchange", "changeOption('"+tag+"')");
    var input = document.createElement("input");
    input.setAttribute("id", "query");
	input.setAttribute("name","queryAll");
    input.setAttribute("type", "text");
    input.style.width = "150px";
    input.style.height="40px";
	input.style.float="left";
    var submit = document.createElement("input");
    submit.setAttribute("type", "submit");
    submit.setAttribute("value", "提交");
    submit.style.width = "80px";
    submit.style.height="40px";
	submit.style.float="left";
	if(tag==="teacher"){
		submit.setAttribute("onclick", "queTeacher()");
	}else if(tag==="student"){
		submit.setAttribute("onclick", "queStudent()");
	}else if(tag==="course"){
		submit.setAttribute("onclick", "queCourse()");
	}
	tr.style.width = "100%";
	td1.appendChild(select);
	td2.appendChild(input);
	td3.appendChild(submit);
    tr.appendChild(td1);
    tr.appendChild(td2);
    tr.appendChild(td3);
	table.appendChild(tr);
    div.appendChild(table);
}

function delStudent(studentId){
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "../StudentServlet?action=delete&studentId="+studentId, true);
    xhr.send();
    xhr.onreadystatechange = function(){
    	if (xhr.readyState === 4 && xhr.status === 200) {
			document.getElementById("view").innerHTML=xhr.responseText;
		}
	}
}
function delTeacher(teacherId){
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "../TeacherServlet?action=delete&teacherId="+teacherId, true);
    xhr.send();
    xhr.onreadystatechange = function(){
    	if (xhr.readyState === 4 && xhr.status === 200) {
			document.getElementById("view").innerHTML=xhr.responseText;
		}
	}
}

function changeOption(tag){
	if(tag==="student"){
		var select = document.getElementById("sel");
		var index = select.selectedIndex;
		if(index===1){
			input = document.getElementById("query");
			input.setAttribute("name","studentId");
		}else if(index===2){
			input = document.getElementById("query");
			input.setAttribute("name","studentName");
		}else if(index===0){
			input = document.getElementById("query");
			input.setAttribute("action","queryAll");
		}
	}else if(tag==="teacher"){
		var select = document.getElementById("sel");
		var index = select.selectedIndex;
		if(index===1){
			input = document.getElementById("query");
			input.setAttribute("name","teacherId");
		}else if(index===2){
			input = document.getElementById("query");
			input.setAttribute("name","teacherName");
		}else if(index===0){
			input = document.getElementById("query");
			input.setAttribute("action","queryAll");
		}
	}else if(tag==="course"){
		var select = document.getElementById("sel");
		var index = select.selectedIndex;
		if(index===1){
			input = document.getElementById("query");
			input.setAttribute("name","queryByTeacherName");
		}else if(index===2){
			input = document.getElementById("query");
			input.setAttribute("name","queryByName");
		}else if(index===3){
			input = document.getElementById("query");
			input.setAttribute("name","queryByClass");
		}else if(index===0){
			input = document.getElementById("query");
			input.setAttribute("action","queryAll");
		}
	}
	
}

function putMessage(){
	var div = document.getElementById("right");
	var table = document.getElementById("view");
	div.removeChild(table);
	var form = document.createElement("form");
	form.setAttribute("action","../AdminServlet");
	form.setAttribute("method","POST");
	form.style.width="100%";
	form.style.height="85%";
	form.style.position="static";
	form.style.top="0px";
	form.style.left="0px";
	form.style.backgroundColor="#aaa";
	var name = document.createElement("span");
	text = document.createTextNode("信息");
	name.appendChild(text);
	var input = document.createElement("input");
	input.setAttribute("name","me");
	input.setAttribute("type","text");
	input.style.width="150px";
	var submit = document.createElement("input");
	submit.setAttribute("type","submit");
	submit.setAttribute("value","提交");
	submit.style.width="80px";
	form.appendChild(name);
	form.appendChild(input);
	form.appendChild(submit);
	div.appendChild(form);
}
function getTeacherRequest(){
	removeRow();
	var div = document.getElementById("right");
	var table = document.getElementById("view");
	table.style.width="100%";
	table.style.height="100%";
	table.style.overflow="scroll";
	if(table===null){
		var form = document.getElementsByTagName("form");
		div.removeChild(form[0]);
		var table = document.createElement("table");
		table.setAttribute("id","view");
	}else{
		arr = new Map([["添加教师","addTeacher()"],["查询删除教师","createQueryTable('teacher')"]]);
		for(var[key,value] of arr){
			tr = document.createElement("tr");
			td = document.createElement("td");
			tx = document.createTextNode(key);
			btn = document.createElement("button");
			btn.style.border="1px solid";
			btn.style.width="100px";
			btn.style.height="30px";
			btn.style.borderRidus="10px";
			btn.appendChild(tx);
			btn.setAttribute("onclick",value);
			btn.style.marginLeft="45%";
			td.appendChild(btn);
			tr.appendChild(td);
			table.appendChild(tr);
		}
		
		
	}
}


function getLog(){
	removeRow();
	var div = document.getElementById("right");
	var table = document.getElementById("view");
	if(table===null){
		var form = document.getElementsByTagName("form");
		div.removeChild(form[0]);
		var table = document.createElement("table");
		table.setAttribute("id","view");
		table.style.width="100%";
		table.style.height="100%";
		table.style.overflow="scroll";
		div.appendChild(table);
	}
	
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "../AdminServlet?action=queryRequests", true);
    xhr.send();
    xhr.onreadystatechange = function(){
    	if (xhr.readyState === 4 && xhr.status === 200) {
			var obj = JSON.parse(xhr.responseText);
			var table = document.getElementById("view");
			table.style.width="100%";
			table.style.height="auto";
			var map = new Map([["id","编号:"],["account","账户名:"],["url","请求路径:"],["time","时间:"]]);
			for(var i=0;i<obj.length;i++){
				var tr = document.createElement("tr");
				for(var [key,value] of map){
					var td1 = document.createElement("td");
					var td2 = document.createElement("td");
					console.log(key);
					var text1 = document.createTextNode(map.get(key));
					var text2 = document.createTextNode(obj[i][key]);
					td1.appendChild(text1);
					td2.appendChild(text2);
					td2.style.border="1px solid";
					tr.appendChild(td1);
					tr.appendChild(td2);
					table.appendChild(tr);
				}
			}
			
		}
	}
}
function getCourseRequest(){
	removeRow();
	var div = document.getElementById("right");
	var table = document.getElementById("view");
	table.style.width="100%";
	table.style.height="100%";
	table.style.overflow="scroll";
	if(table===null){
		var form = document.getElementsByTagName("form");
		div.removeChild(form[0]);
		var table = document.createElement("table");
		table.setAttribute("id","view");
	}else{
		arr = new Map([["添加课表","addCourse()"],["查询删除课表","createQueryTable('course')"]]);
		for(var[key,value] of arr){
			tr = document.createElement("tr");
			td = document.createElement("td");
			tx = document.createTextNode(key);
			btn = document.createElement("button");
			btn.style.border="1px solid";
			btn.style.width="100px";
			btn.style.height="30px";
			btn.style.borderRidus="10px";
			btn.appendChild(tx);
			btn.setAttribute("onclick",value);
			btn.style.marginLeft="45%";
			td.appendChild(btn);
			tr.appendChild(td);
			table.appendChild(tr);
		}
		
		
	}
}
function addCourse(){
	var map = new Map([["c_name","课程名"],
							["c_crs","学分"],["c_number","课时"],["c_exam","考试类型"],
							["c_type","选修类型"],["c_week","单双周"],["c_time","时间"],["c_address","上课地址"],["c_class","班级名"],["c_teacher","教师名"]]);
	var div = document.getElementById("right");
	var table = document.getElementById("view");
	div.removeChild(table);
	var form = document.createElement("form");
	form.setAttribute("action","../CourseServlet");
	form.setAttribute("method","POST");
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
		input.setAttribute("name",key);
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
	action.setAttribute("value","addCourse");
	action.setAttribute("type","hidden");
	sub.setAttribute("type","submit");
	sub.setAttribute("value","提交");
	sub.style.width="270px";
	form.appendChild(action);
	form.appendChild(sub);
	div.appendChild(form);
}
function delCourse(id){
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "../CourseServlet?action=deleteById&id="+id, true);
    xhr.send();
    xhr.onreadystatechange = function(){
    	if (xhr.readyState === 4 && xhr.status === 200) {
			document.getElementById("view").innerHTML=xhr.responseText;
		}
	}
}