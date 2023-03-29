<%@page import="com.kce.dao.RegisterDao"%>
<%@page import="com.kce.model.Register"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registered Users</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script> 
    
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
 <link rel="stylesheet" href="css/styles.css">
</head>
<body>
	<div class="demo">
        <div class="container">
            <div class="row text-center">
                <h1 class="white">Registered Users</h1>
            </div>
            <div class="row">
                <div class="col-md-offset-1 col-md-10">
                    <div class="panel">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col col-sm-3 col-xs-12">
                                    <h4 class="title">Data <span>List</span></h4>
                                </div>
                                <div class="col-sm-9 col-xs-12 text-right">
                                	 <button onclick="registerPage()" type="button" class="btn btn-primary">Add users</button>
                                </div>
                            </div>
                        </div>
                        <div class="panel-body table-responsive">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>FirstName</th>
                                        <th>LastName</th>
                                        <th>Email</th>
                                        <th>BirthDay</th>
                                        <th>Gender</th>
                                        <th>PhoneNumber</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                	<%
                                	ArrayList<Register> users = new RegisterDao().getRegisterationDetailsList();
                                    for(int i=0; i<users.size();i++){%>
                                        <tr>
                                            <td><%= users.get(i).getFirstName()%></td>
                                            <td><%= users.get(i).getLastName() %></td>
                                            <td><%= users.get(i).getEmail()%></td>
                                            <td><%= users.get(i).getBirthDay()%></td>
                                            <td><%= users.get(i).getGender()%></td>
                                            <td><%= users.get(i).getPhoneNumber()%></td>
                                            <td>
                                            	<ul class="action-list">
                                                	<li><a  data-tip="edit"><i class="fa fa-edit"></i></a></li>
                                                	<li><a  data-tip="delete"><i class="fa fa-trash"></i></a></li>
                                            	</ul>
                                        	</td>
                                        </tr>
                                      <%}%>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
   <script src="js/register.js"></script>
</body>
</body>
</html>