<%@include file="../templates/header.jspf"%>
<%@ page contentType="text/html;charset=UTF-8"  %>


<div class="container">
    <main class="row justify-content-center">


        <div class="col-6">

            <h2> Nouveau membre</h2>

            <!-- Formulaire - Ajouter un nouveau membre -->

            <form action="/add-membre" method="post">

                <div class="form-group">
                    Nom :    <input class="form-control" placeholder="Nom du membre"
                           type="text" name="nom">
                </div>

                <div class="form-group">
                    Prénom :  <input class="form-control" placeholder="Prénom du membre"
                           type="text" name="prenom">
                </div>

                <div class="form-group">
                    Date de naissance :  <input class="form-control" placeholder="Date de Naissance"
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

                <input type="submit" class="btn btn-default btn-block" name="Ajouter">

            </form>
        </div> <!--fin du container-->
    </main>

</div>

</body>
</html>