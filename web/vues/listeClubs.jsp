<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 21-10-17
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste des clubs</title>
</head>
<body>
<H4>Liste des clubs</H4>

<ol>

    <c:forEach items="${clubs}" var="club">

    <li>${club.nom}</li>

</ol>

</body>
</html>