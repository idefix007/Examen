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
  <H1>GESTION DES CLUBS</H1>
  <H2>Membres</H2>
  <a href="/membre" class="btn btn-info btn-block">
    <i> Consulter la liste des membres</i>
  </a>

  <a href="/add-membre" class="btn btn-info btn-block">
    <i class="fa fa-plus"> Ajouter un membre</i>
  </a>
  <br>
  <H2>Clubs</H2>
  <a href="/club" class="btn btn-info btn-block">
  <i> Consulter la liste des clubs</i>
  </a>
  <a href="/add-club" class="btn btn-info btn-block">
    <i class="fa fa-plus"> Ajouter un club</i>
  </a>
  </body>
</html>
