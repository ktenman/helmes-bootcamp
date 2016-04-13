<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="../fragments/head.jsp"/>
<body>
<jsp:include page="../fragments/menu.jsp"/>
<div id="body">
    <section class="content-wrapper main-content clear-fix">

        <h2>Edit</h2>

        <form:form modelAttribute="restaurant" class="restaurantForm">
            <fieldset>
                <legend>DbBooking</legend>

                <form:hidden path="id"/>
                <div class="editor-label">
                    <label for="RestaurantName">Restaurant name</label>
                </div>
                <div class="editor-field">
                    <form:input type="text" path="name" id="RestaurantName" name="RestaurantName" data-val-required=""/>
                </div>
                <div class="editor-label">
                    <label for="RestaurantAadress">Restaurant aadress</label>
                </div>
                <div class="editor-field">
                    <form:textarea type="text" path="aadress" id="RestaurantAadress" name="RestaurantAadress"
                                   data-val-required=""/>
                </div>

                <p>
                    <input type="submit" value="Save"/>
                </p>
            </fieldset>
        </form:form>
        <div>
            <a href="/restaurant/all">Back to List</a>
        </div>


    </section>
</div>
<jsp:include page="../fragments/footer.jsp"/>

</body>
</html>
