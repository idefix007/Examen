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
                    <c:choose>
                        <c:when test="${clubs.type==value}">
                            <option selected="selected" value="${clubs.type}">${clubs.type}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${clubs.type}">${clubs.type}</option>
                        </c:otherwise>
                    </c:choose>
                    <option value="Basket-ball">Basket-ball</option>
                    <option value="Hand-ball">Hand-ball</option>
                    <option value="Rugby">Rugby</option>
                    <option value="Volley-ball">Volley-ball</option>
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