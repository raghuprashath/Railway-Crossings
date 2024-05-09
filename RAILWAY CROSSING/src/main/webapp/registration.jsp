<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Registration Page</title>
    <style>
        body, html {
            height: 100%;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .form-container {
            text-align: center;
        }
        form {
            width: 300px;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 10px;
            background-color: #f9f9f9;
        }
        h2, h3 {
            margin-bottom: 10px;
        }
        label {
            display: block;
            margin-bottom: 5px;
        }
        input[type="text"],
        input[type="email"],
        input[type="password"] {
            width: calc(100% - 16px);
            padding: 8px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
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
        
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Railway Crossing</h2>
        <h3>User Registration</h3>
        <form action="RegistrationServlet" method="post">
            <label>Enter Name:</label><br>
            <input type="text" name="name" required placeholder="Raghu Prashath "><br>
            <label>Enter Email:</label><br>
            <input type="email" name="email" required placeholder="raghu@gmail.com"><br>
            <label>Enter Password:</label><br>
            <input type="password" name="password" required placeholder="Enter the Password"><br><br>
            <input type="submit" value="Register">
        </form>
        <p>Already have an account? <a href="login.jsp">Sign In Instead</a></p>
    </div>
</body>
</html>
