<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>delete event</title>
</head>
<body>
    <h1>delete event</h1>
    <form action="event/delete" method="post">
        <input type="number" name="eventid">
        <input type="hidden" name="action" value="delete" hidden>
        <button type="submit">delete</button>
    </form>
</body>
</html>
