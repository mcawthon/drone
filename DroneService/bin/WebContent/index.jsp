<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log In Form</title>
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <div class="container">
            <form name="login_form" method="post" action="login" id="logform">
                <label>User Name :</label><br><input name = "username"/>
                <br>
                <label>Password  :</label><br><input name = "password"/>
                <br><br>
                <input type="submit" name="submit" value="Log In"/>     
            </form> 
        </div>
</body>
</html>