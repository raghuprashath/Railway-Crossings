<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RailwayCrossing</title>
<style>
    body {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
        background-color: #f4f4f4;
        font-family: Arial, sans-serif;
    }
    .container {
        text-align: center;
        background-color: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    h2, h5 {
        color: #333;
    }
    form {
        margin-top: 20px;
    }
    input[type="submit"] {
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        background-color: #4CAF50;
        color: white;
        cursor: pointer;
        transition: background-color 0.3s;
    }
    input[type="submit"]:hover {
        background-color: #45a049;
    }
</style>
</head>
<body>
<div class="container">
    <h2>Welcome to Railway Crossing Application</h2><br><br>
    <h5>Developed by Raghu prashath M A</h5><br><br>
    <form action="adminlogin.jsp">
        <input type="submit" value="Admin"><br><br>
    </form>
    <form action="registration.jsp">
        <input type="submit" value="Public"><br><br>
    </form>
</div>
</body>
</html>
