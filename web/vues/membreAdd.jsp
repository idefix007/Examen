<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gestion des membres de clubs</title>
</head>
<body>


<div class="container">
    <main class="row justify-content-center">


        <div class="col-6">

            <h2> Nouveau membre</h2>

            <!-- Formulaire - Ajouter un nouveau membre -->

            <form action="/add-membre" method="post">

                <div class="form-group">
                    Nom :    <input class="form-control" placeholder="Nom du membre"
                           type="text" name="Nom du membre">
                </div>

                <div class="form-group">
                    Prénom :  <input class="form-control" placeholder="Prénom du membre"
                           type="text" name="Prénom du membre">
                </div>

                <div class="form-group">
                    Date de naissance :  <input class="form-control" placeholder="Date de Naissance"
                           type="date" name="Date de Naissance">
                </div>

                <!-- Select option pour liste déroulante -->
                <div class="form-group">
                    Club :  <select><option></option></select>
                </div>

                <!-- Bouton : ajouter -->

                <input type="submit" class="btn btn-default btn-block" name="Ajouter">

            </form>
        </div> <!--fin du container-->
    </main>

</div>

</body>
</html>