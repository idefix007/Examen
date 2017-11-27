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
            <H4>Liste des clubs
                <a class="col-2" href="/add-club">

                    <i class="fa fa-plus" aria-hidden="true" style="color:green"></i>
                </a>
            </H4>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Nom</th>
                    <th>Type</th>
                    <th>Action</th>

                </tr>
                </thead>
                <tbody>

                <c:forEach items="${clubs}" var="clubs">
                    <tr>

                        <td>${clubs.id}</td>
                        <td>${clubs.nom}</td>
                        <td>${clubs.type}</td>
                        <td><a class="col-2" href="/supp-club?clubs=${clubs.id}">
                            <i class="fa fa-trash-o"aria-hidden="true" onclick="return confirm('etes vous sur de vouloir supprimer ce club?')"></i>
                        </a>
                            <a class="col-2" href="/mod-club?clubsid=${clubs.id}&clubsnom=${clubs.nom}&membresprenom=${mclubs.type}">
                                <i class="fa fa-pencil"aria-hidden="true"></i>
                            </a> </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </main>
</div>

</body>
</html>
<%@include file="../templates/footer.jspf"%>