<%--
  Created by IntelliJ IDEA.
  User: etudiants
  Date: 13-11-17
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@include file="templates/header.jspf"%>
<%@ page contentType="text/html;charset=UTF-8"  %>
<div class="container">
  <main class="row justify-content-center">
    <div class="col-10">

<html>
  <head>
    <title>Gestion des clubs</title>
  </head>
  <body>
  <div class="card-deck-wrapper">
    <div class="card-deck">

      <!-- Card 1 -->
      <div class="card">
        <div class="card-header">MEMBRES</div>
        <div class="card-body">
          <p class="card-text">Gestion des membres de tous les clubs.</p>
          <a href="/membre" class="card-link">Liste des membres</a>
          <a href="/add-membre" class="card-link">Ajouter un membre</a>
        </div>
      </div>

      <!-- Card 2 -->
      <div class="card">
        <div class="card-header">CLUBS</div>
        <div class="card-body">
          <p class="card-text">Gestion des clubs et des membres par club.</p>
          <a href="/club" class="card-link">Liste des clubs</a>
          <a href="/add-club" class="card-link">Ajouter un club</a>
        </div>
      </div>

    </div>
  </div>
  </body>


</html>
      <%@include file="templates/footer.jspf"%>

      <style> .card-deck-wrapper{margin:60px;}</style>
