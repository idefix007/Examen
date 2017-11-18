<%@include file="../templates/header.jspf"%>

<div class="container">
    <main class="row justify-content-center">


        <div class="col-6">

            <h2> Nouveau club</h2>

            <!-- Formulaire - Ajouter un nouveau club -->

            <form action="/add-membre" method="post">

                <div class="form-group">
                    Nom : <input class="form-control" placeholder="Nom du club"
                           type="text" name="Nom du club">
                </div>


                <!-- Select option pour liste déroulante -->
                <div class="form-group">
                    Type : <select><option></option></select>
                </div>

                <!-- Bouton : ajouter -->

                <input type="submit" class="btn btn-default btn-block" name="Ajouter">

            </form>
        </div> <!--fin du container-->
    </main>

</div>

</body>
</html>
