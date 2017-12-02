<%@include file="../templates/header.jspf"%>
<%@ page contentType="text/html;charset=UTF-8"  %>

<div class="container">
    <main class="row justify-content-center">


        <div class="col-6">

            <h2> Nouveau club</h2>

            <!-- Formulaire - Ajouter un nouveau club  -->

            <form action="/add-club" method="post">

                <div class="form-group">
                    Nom : <input class="form-control" placeholder="Nom du club"
                           type="text" name="nom">
                </div>


                <!-- Select option pour liste déroulante -->
                <div class="form-group">
                    Type : <select name="type">
                        <option value="Basket-ball">Basket-ball</option>
                        <option value="Hand-ball">Hand-ball</option>
                        <option value="Rugby">Rugby</option>
                        <option value="Volley-ball">Volley-ball</option>
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
<%@include file="../templates/footer.jspf"%>
<style> .col-6 {margin:30px;}</style>
