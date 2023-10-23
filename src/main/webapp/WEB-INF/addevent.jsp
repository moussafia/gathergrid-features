<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Event</title>
  <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 min-h-screen flex items-center justify-center">
    <div class="w-75 bg-white p-8 rounded-lg shadow-md">
        <h1 class="text-2xl font-bold mb-4">Create Event</h1>
        <form id="eventForm" action="" method="post">
            <div class="mb-4">
                <label for="name" class="block text-gray-700 font-semibold">Name:</label>
                <input type="text" id="name" name="name" required class="border rounded-md p-2 w-full">
                <c:if test="${not empty errors.name}">
                    <span class="text-red-500"><c:out value="${errors.name}"/></span>
                </c:if>
            </div>

            <div class="mb-4">
                <label for="address" class="block text-gray-700 font-semibold">Address:</label>
                <input type="text" id="address" name="address" required class="border rounded-md p-2 w-full">
                <c:if test="${not empty errors.address}">
                    <span class="text-red-500"><c:out value="${errors.address}"/></span>
                </c:if>
            </div>

            <div class="mb-4">
                <label for "date" class="block text-gray-700 font-semibold">Date:</label>
                <input type="datetime-local" id="date" name="date" required class="border rounded-md p-2 w-full">
                <c:if test="${not empty errors.datetime}">
                    <span class="text-red-500"><c:out value="${errors.datetime}"/></span>
                </c:if>
            </div>

            <div class="mb-4">
                <label for="category" class="block text-gray-700 font-semibold">Category:</label>
                <select id="category" name="category" required class="border rounded-md p-2 w-full">
                    <c:forEach items="${categories}" var="category">
                        <option value="${category.id}">${category.name}</option>
                    </c:forEach>
                </select>
                <c:if test="${not empty errors.category}">
                    <span class="text-red-500"><c:out value="${errors.category}"/></span>
                </c:if>
            </div>

            <div class="mb-4">
                <label for="description" class="block text-gray-700 font-semibold">Description:</label>
                <textarea id="description" name="description" required class="border rounded-md p-2 w-full"></textarea>
                <c:if test="${not empty errors.description}">
                    <span class="text-red-500"><c:out value="${errors.description}"/></span>
                </c:if>
            </div>

            <h2 class="text-xl font-bold mt-4 mb-2">Tickets</h2>
            <c:if test="${not empty errors.tickets}">
                <span class="text-red-500"><c:out value="${errors.tickets}"/></span>
            </c:if>

            <div class="mb-4">
                <label class="text-gray-700 font-semibold">VIP:</label>
                <input type="checkbox" name="vip" class="ms-5">
                <input type="number" id="vipticketsnumber" name="vipticketsnumber" placeholder="Number of Tickets" class="border rounded-md p-2 w-full">
                <input type="number" id="vipticketsprice" name="vipticketsprice" placeholder="Price" class="border rounded-md p-2 w-full">
                <c:if test="${not empty errors.vip}">
                    <span class="text-red-500"><c:out value="${errors.vip}"/></span>
                </c:if>
            </div>

            <div class="mb-4">
                <label class="text-gray-700 font-semibold">STUDENT:</label>
                <input type="checkbox" name="student" class="ms-5">
                <input type="number" id="studentticketsnumber" name="studentticketsnumber" placeholder="Number of Tickets" class="border rounded-md p-2 w-full">
                <input type="number" id="studentticketsprice" name="studentticketsprice" placeholder="Price" class="border rounded-md p-2 w-full">
                <c:if test="${not empty errors.student}">
                    <span class="text-red-500"><c:out value="${errors.student}"/></span>
                </c:if>
            </div>

            <div class="mb-4">
                <label class="text-gray-700 font-semibold">SENIOR CITIZEN:</label>
                <input type="checkbox" name="senior_citizen" class="ms-5">
                <input type="number" id="senior_citizenticketsnumber" name="senior_citizenticketsnumber" placeholder="Number of Tickets" class="border rounded-md p-2 w-full">
                <input type="number" id="senior_citizenticketsprice" name="senior_citizenticketsprice" placeholder="Price" class="border rounded-md p-2 w-full">
                <c:if test="${not empty errors.senior_citizen}">
                    <span class="text-red-500"><c:out value="${errors.senior_citizen}"/></span>
                </c:if>
            </div>

            <div class="mb-4">
                <label class="text-gray-700 font-semibold">CHILD:</label>
                <input type="checkbox" name="child" class="ms-5">
                <input type="number" id="childticketsnumber" name="childticketsnumber" placeholder="Number of Tickets" class="border rounded-md p-2 w-full">
                <input type="number" id="childticketsprice" name="childticketsprice" placeholder="Price" class="border rounded-md p-2 w-full">
                <c:if test="${not empty errors.child}">
                    <span class="text-red-500"><c:out value="${errors.child}"/></span>
                </c:if>
            </div>
            <input type="hidden" hidden name="action" value="create">

            <button type="submit" class="bg-blue-500 text-white font-semibold py-2 px-4 rounded-lg hover:bg-blue-600 focus:outline-none focus:ring focus:border-blue-300 mt-4 w-full">Submit</button>
        </form>
    </div>
</body>
</html>
