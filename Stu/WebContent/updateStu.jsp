<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/servlet/updateStu" name="updateStu" method="post">
			
			<c:forEach var="student">
				 <p>
					<label> Sname </label> <input name="Sname" type="text"
						value='${Sname}' class="opt_input" />
				</p> 
				<p>
					<label> 性别 </label> <input name="Ssex" type="text"
						value='${Ssex}' class="opt_input" />
				</p>
				
			    <p>
					<label> 出生年月 </label> <input name="Sbirth" type="date"
						value='${Sbirth}' class=" opt_input" />
				</p>
				<p>
					<label> 班级</label> <input name="Clnum" type="text"
						value='${Clnum}' class=" opt_input" />
				</p>
				<p>
					<label> 邮箱</label> <input name="Email" type="text"
						value='${Email}' class=" opt_input" />
				</p>
				<p>
					<label>状态</label> <input name="Status" type="text"
						value='${Status}' class=" opt_input" />
				</p>
				<input type="submit" value="提交" class="opt_sub" />
				<input type="reset" value="重置" class="opt_sub" />
			</c:forEach>
		</form>
</body>
</html>