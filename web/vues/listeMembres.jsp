<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 21-10-17
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../templates/header.jspf"%>

<H4>Liste des membres</H4>
<table class="table table-striped">
    <thead>
    <tr>
        <th>Nom</th>
        <th>Prénom</th>
        <th>Date de naissance</th>
        <th>Club</th>

    </tr>
    </thead>
    <tbody>

    <c:forEach items="${membres}" var="membres">
    <tr>

        <td>${membres.nom}</td>
        <td>${membres.prenom}</td>
        <td>${membres.dateNaissance}</td>
        <td>${membres.club}</td>
    </tr>
    </c:forEach>
    </tbody>
</table>



</body>
</html>