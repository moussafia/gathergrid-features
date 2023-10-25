<%--
  Created by IntelliJ IDEA.
  User: YouCode
  Date: 18/10/2023
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link href="https://unpkg.com/tailwindcss@1.0.4/dist/tailwind.min.css" rel="stylesheet">
    <title>Title</title>
</head>
<body>
<h1>Welcome to your Account ${user.getFirstName()} ${user.getId()} ${user.getLastName()}</h1>
<a href="<c:url value='/auth/ShowEvent'/>" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded"> show Event </a>
</body>
</html>
