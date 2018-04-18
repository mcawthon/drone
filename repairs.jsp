<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
    
<%
    String repairTable = (String) request.getAttribute("repairsTable");
%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Repairs</title>
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <div class="container">
        <div class="buttons">

            <a class="btn" href="add">Add Repair</a><a class="btn" href="delete">Delete Repair</a>

        </div>
        <div style="margin-top: 45px;">
            <%= repairTable%>
        </div>
        
</div>
</body>
</html>