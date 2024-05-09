<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin</title>
    <style>
        body, html {
            height: 100%;
            margin: 0;
        }
        .form-container {
            position: absolute;
            top: calc(10% + 20px); /* 10% below the top + additional 20px for padding */
            left: 50%;
            transform: translateX(-50%);
            text-align: center;
        }
        form {
            width: 250px;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 10px;
            background-color: #f9f9f9;
        }
        label {
            display: block;
            margin-bottom: 5px;
        }
        input[type="text"],
        input[type="password"] {
            width: calc(100% - 16px);
            padding: 8px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
        input[type="text"]:focus,
        input[type="password"]:focus {
            border-color: #4CAF50; 
        }
        input[type="submit"] {
            width: 100%;
            padding: 10px;
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
    <div class="form-container">
        <h2>Admin</h2>
        <form action="AdminLogin" method="post"> <!-- Changed method to "post" -->
            <label for="username">Enter the User Name:</label><br>
            <input type="text" placeholder="Enter the User Name" name="username"><br><br>
            <label for="password">Enter the Password:</label><br>
            <input type="password" placeholder="Enter the Password" name="password"><br><br>
            <input type="submit" value="Login">
        </form>
    </div>
</body>
</html>
