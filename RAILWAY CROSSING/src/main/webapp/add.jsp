<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Crossings</title>
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
        label {
            display: block;
            margin-bottom: 8px; /* Reduced gap */
        }
        input[type="number"],
        input[type="text"],
        input[type="radio"] {
            width: calc(100% - 16px); /* Adjusted width for border */
            padding: 8px;
            margin-bottom: 10px; /* Reduced gap */
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
        input[type="number"]:focus,
        input[type="text"]:focus,
        input[type="radio"]:focus {
            border-color: #4CAF50; /* Border color when focused */
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
        <h2>Add Crossings</h2>
        <form action="AddServlet" method="post">
            <label for="sno">Sno:</label>
            <input type="number" placeholder="Sno" name="sno"><br>
            <label for="name">Crossing Name:</label>
            <input type="text" placeholder="Crossing Name" name="name"><br>
            <label for="address">Address:</label>
            <input type="text" placeholder="Address" name="address"><br>
            <label for="landmark">LandMark:</label>
            <input type="text" placeholder="LandMark" name="landmark"><br>
            <label for="time">Time (00:00 AM/PM):</label>
            <input type="text" placeholder="Time (00:00 AM/PM)" name="time"><br>
            <label for="person">Person in charge:</label>
            <input type="text" placeholder="Person in charge" name="person"><br>
            <label>Status:</label>
            <input type="radio" name="status" value="Open"> Open
            <input type="radio" name="status" value="Closed"> Closed<br><br>
            <input type="submit" value="Submit">
        </form>
    </div>
</body>
</html>
