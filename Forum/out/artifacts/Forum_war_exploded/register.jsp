<%@ page import="bg.swift.ip.forum.entity.Gender" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Registration</h3>
<div>Please enter your details below:</div>
<br>



<form method="post" action="register.servlet">
        <table>

        <tr><td><label for="name">Name</label></td><td><input type="text" name="name" id="name"></td></tr>
        <tr><td><label for="email">Email</label></td><td><input name="email" id="email"></td></tr>
        <tr><td><label for="password">Password</label></td><td><input type="password" name="password" id="password"></td></tr>
        <tr><td><label for="confirm_password">Confirm Password</label></td><td><input type="password" name="confirm_pass" id="confirm_password"></td></tr>
        <tr><td><label for="age">Age</label></td><td><input type="text" name="age" id="age"></td></tr>
        <tr><td>Gender:</td><td>

            <select name="gender">

                <%
                    Gender[] genders = Gender.values();
                    for (Gender gender: genders) {
                %>
                <option value="<%=gender.name()%>"><%=gender.name()%></option>
                <%
                    }
                %>
            </select>



        </td></tr>
        <tr><td></td><td><input type="submit" value="Register"></td></tr>
        <tr><td></td><td><input type="reset" name="reset" value="Reset"></td></tr>

</table>


    </form>


</body>
</html>
