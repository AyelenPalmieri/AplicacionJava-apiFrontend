<%--
  Created by IntelliJ IDEA.
  User: patri
  Date: 09/10/2021
  Time: 20:14
  To change this template use File | Settings | File Templates.
  http://localhost:8080/swagger-ui.html
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
    <link rel="stylesheet" th:href="@{/bootstrap/css/bootstrap.min.css}"/>
    <link rel="stylesheet" th:href="@{/bootstrap/sideBar/sideBar.css}"/>
    <link href="webjars/bootstrap/5.1.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<header class="navbar navbar-expand-lg navbar-dark bg-dark">
    <nav class="container-xxl flex-wrap flex-md-nowra">
        <a class="navbar-brand p-0 me-2" href="/" aria-label="Bootstrap">
            <svg xmlns="http://www.w3.org/2000/svg" width="40" height="32" class="d-block my-1" viewBox="0 0 118 94" role="img"><title>Bootstrap</title><path fill-rule="evenodd" clip-rule="evenodd" d="M24.509 0c-6.733 0-11.715 5.893-11.492 12.284.214 6.14-.064 14.092-2.066 20.577C8.943 39.365 5.547 43.485 0 44.014v5.972c5.547.529 8.943 4.649 10.951 11.153 2.002 6.485 2.28 14.437 2.066 20.577C12.794 88.106 17.776 94 24.51 94H93.5c6.733 0 11.714-5.893 11.491-12.284-.214-6.14.064-14.092 2.066-20.577 2.009-6.504 5.396-10.624 10.943-11.153v-5.972c-5.547-.529-8.934-4.649-10.943-11.153-2.002-6.484-2.28-14.437-2.066-20.577C105.214 5.894 100.233 0 93.5 0H24.508zM80 57.863C80 66.663 73.436 72 62.543 72H44a2 2 0 01-2-2V24a2 2 0 012-2h18.437c9.083 0 15.044 4.92 15.044 12.474 0 5.302-4.01 10.049-9.119 10.88v.277C75.317 46.394 80 51.21 80 57.863zM60.521 28.34H49.948v14.934h8.905c6.884 0 10.68-2.772 10.68-7.727 0-4.643-3.264-7.207-9.012-7.207zM49.948 49.2v16.458H60.91c7.167 0 10.964-2.876 10.964-8.281 0-5.406-3.903-8.178-11.425-8.178H49.948z" fill="currentColor"></path></svg>
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="example">Example</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Pricing</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Disabled</a>
                </li>
                <li class="nav-item">
                    <a href="swagger-ui.html" class="btn btn-outline-success" type="submit">Swagger</a>
                </li>
            </ul>
            <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </nav>
</header>

<div class="container">
    <table class="table table-striped">
        <caption>Your todos are</caption>
        <thead>
        <tr>
            <th>Description</th>
            <th>Target Date</th>
            <th>Is it Done?</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>Todo 1</td>
            <td>10/12/2017</td>
            <td>No</td>
            <td><a class="btn btn-warning" href="/edit-todo">Edit Todo</a></td>
            <td><a class="btn btn-warning" href="/delete-todo">Delete Todo</a></td>
        </tr>
        </tbody>
    </table>
    <div>
        <a class="btn btn-default" href="/add-todo">Add a Todo</a>

    </div>
    <script src="webjars/jquery/3.6.0/dist/jquery.js"></script>
    <script src="webjars/bootstrap/5.1.1/js/bootstrap.min.js"></script>
</div>
</body>
</html>