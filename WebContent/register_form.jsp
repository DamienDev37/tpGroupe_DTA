<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="beans.User"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Form</title>
    </head>
    <body>
        
        <jsp:useBean id="user" scope="request" class="beans.User"></jsp:useBean>
 
        <form action="RegisterController" method="post">
            <center>
                <table border="1" width="15%" cellpadding="5">
                    <thead>
                        <tr>
                            <th colspan="2">Register Form</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>    
                            <td>Name : </td>
                            <td><input type="text" name="name" value="<jsp:getProperty name="user" property="name"/>"></td>
                        </tr>
                        <tr>    
                            <td>Email : </td>
                            <td><input type="text" name="email" value="<jsp:getProperty name="user" property="email"/>"></td>
                        </tr>
                        <tr>    
                            <td>Password : </td>
                            <td><input type="password" name="password" value="<jsp:getProperty name="user" property="password"/>"></td>
                        </tr>
                        <tr>
                            <td>Role : </td>
                            <td><input type="password" name="role" value="<jsp:getProperty name="user" property="role"/>"></td>
                        </tr>
                        <tr>
                            <td><center><input type="reset" value="Reset" /></center></td>
                            <td><center><input type="submit" value="Register"></center></td>
                        </tr>
                    </tbody>             
                </table>
            </center>
        </form>
        
        <div style="position: relative">
            <div style="position: fixed ; bottom: 0 ; width:100% ; text-align:center ">
                <p><a href="https://www.youtube.com/user/TechWorld3g?sub_confirmation=1">CLICK HERE TO SUBSCRIBE</a></p>
            </div>
        </div>                  
                        
    </body>
</html>
