<%@ page import="java.util.List" %>
<%@ page import="com.gathergrid.gathergridfeatures.domain.Category" %>
<%@ page import="jakarta.persistence.EntityManager" %>
<%@ page import="com.gathergrid.gathergridfeatures.utils.EntityManagerUtil" %>
<%@ page import="com.gathergrid.gathergridfeatures.service.CategoryService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Event</title>
</head>
<body>
    <h1>Create Event</h1>
<%--    <a href="${pageContext.request.contextPath}/Dashboard">--%>

<%--    <form id="eventForm" action="${pageContext.request.contextPath}/addevent" method="post">--%>
    <form id="eventForm" action="addevent" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br><br>

        <label for="address">Address:</label>
        <input type="text" id="address" name="address" required><br><br>

        <label for="date">Date:</label>
        <input type="datetime-local" id="date" name="date" required><br><br>

        <label for="category">Date:</label>
        <select id="category" name="category" required><br><br>
            <%
                CategoryService categoryService = new CategoryService();
                List<Category> categories = categoryService.getAllCategories();
                for (Category category: categories) {
            %>
            <option value="<%= category.getId()%>"><%= category.getName() %></option>
            <%
                }
            %>

        </select>

        <label for="description">Description:</label>
        <textarea id="description" name="description" required></textarea><br><br>

        <h2>Tickets</h2>
        VIP:
        <input type="number" id="vipticketsnumber" name="vipticketsnumber" placeholder="Number of Tickets">
        <input type="number" id="vipticketsprice" name="vipticketsprice" placeholder="Price" >
        <input type="checkbox" name="vip"><br><br>

        STUDENT:
        <input type="number" id="studentticketsnumber" name="studentticketsnumber" placeholder="Number of Tickets">
        <input type="number" id="studentticketsprice" name="studentticketsprice" placeholder="Price" >
        <input type="checkbox" name="student"><br><br>

        SENIOR CITIZEN:
        <input type="number" id="senior_citizenticketsnumber" name="senior_citizenticketsnumber" placeholder="Number of Tickets">
        <input type="number" id="senior_citizenticketsprice" name="senior_citizenticketsprice" placeholder="Price" >
        <input type="checkbox" name="senior_citizen"><br><br>

        CHILD:
        <input type="number" id="childticketsnumber" name="childticketsnumber" placeholder="Number of Tickets">
        <input type="number" id="childticketsprice" name="childticketsprice" placeholder="Price" >
        <input type="checkbox" name="child"><br><br>

        <button type="submit">Submit</button>
    </form>
</body>
</html>