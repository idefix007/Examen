<%@include file="../templates/header.jspf"%>
<%@ page contentType="text/html;charset=UTF-8"  %>


<div class="container">
    <main class="row justify-content-center">


        <div class="col-6" >

            <h2> Modification du membre ${membres.id} </h2>

            <!-- Formulaire - Modification membre -->

            <form action="/mod-membre" method="post">

                <div class="form-group">
                    Nom :    <input class="form-control" placeholder="${membres.nom}"
                                    type="text" name="nom">
                </div>

                <div class="form-group">
                    Prénom :  <input class="form-control" placeholder="${membres.prenom}"
                                     type="text" name="prenom">
                </div>

                <div class="form-group">
                    Date de naissance :  <input class="form-control" placeholder="${membres.dateN}"
                                                type="date" name="dateN">
                </div>

                <!-- Select option pour liste déroulante -->
                <div class="form-group">
                    Club :  <select name="club">
                    <c:forEach items="${clubs}" var="clubs">
                        <option value="${clubs.id}">${clubs.nom}</option>
                    </c:forEach>
                </select>
                </div>

                <!-- Bouton : ajouter -->

                <input type="submit" class="btn btn-default btn-block" name="Modifier">

            </form>
        </div> <!--fin du container-->
    </main>

</div>

</body>
</html>