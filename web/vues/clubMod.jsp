<%@include file="../templates/header.jspf"%>
<%@ page contentType="text/html;charset=UTF-8"  %>

<div class="container">
    <main class="row justify-content-center">


        <div class="col-6">

            <h2> Modification du club</h2>

            <!-- Formulaire - Ajouter un nouveau club  -->

            <form action="/mod-club" method="post">

                <div hidden class="form-group">
                    Id :    <input class="form-control" value="${clubs.id}"
                                    type="text" name="id">
                </div>

                <div class="form-group">
                    Nom :    <input class="form-control" value="${clubs.nom}"
                                    type="text" name="nom">
                </div>


                <!-- Select option pour liste déroulante -->
                <div class="form-group">
                    Type : <select name="type">

                    <c:if test="${clubs.type ne 'type'}">
                        <option value="Basket-ball" <c:if test="${clubs.type == 'Basket-ball'}"> selected </c:if>>Basket-ball</option>
                        <option value="Hand-ball"<c:if test="${clubs.type == 'Hand-ball'}"> selected </c:if>>Hand-ball</option>
                        <option value="Rugby"<c:if test="${clubs.type == 'Rugby'}"> selected </c:if>>Rugby</option>
                        <option value="Volley-ball"<c:if test="${clubs.type == 'Volley-ball'}"> selected </c:if>>Volley-ball</option>
                    </c:if>
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
<%@include file="../templates/footer.jspf"%>
<style> .col-6 {margin:30px;}</style>