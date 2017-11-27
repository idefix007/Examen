<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 21-10-17
  Time: 10:20

--%>
<%@include file="../templates/header.jspf"%>
<%@ page contentType="text/html;charset=UTF-8"  %>
<div class="container">
    <main class="row justify-content-center">
        <div class="col-10">
<H4>Liste des membres
    <a class="col-2" href="/add-membre">

        <i class="fa fa-plus" aria-hidden="true"></i>
    </a>
</H4>
<table class="table table-striped">
    <thead>
    <tr>
        <th>Id</th>
        <th>Nom</th>
        <th>Prénom</th>
        <th>Date de naissance</th>
        <th>Club</th>
        <th>Action</th>

    </tr>
    </thead>
    <tbody>

    <c:forEach items="${membres}" var="membres">
    <tr>

        <td>${membres.id}</td>
        <td>${membres.nom}</td>
        <td>${membres.prenom}</td>
        <td>${membres.dateNaissance}</td>
        <td>${membres.club}</td>
        <td><a class="col-2" href="/supp-membre?membres=${membres.id}">
            <i class="fa fa-trash-o"aria-hidden="true"></i>
        </a>
            <a class="col-2" href="/mod-membre?membres=${membres.id}">
                <i class="fa fa-pencil"aria-hidden="true"></i>
            </a> </td>
    </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/add-membre" class="btn btn-info btn-block">
    <i class="fa fa-plus"> Ajouter un membre</i>
</a>

        </div>
    </main>
</div>

</body>
</html>