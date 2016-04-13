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

        <h2>Add tables into ${restaurant.name}</h2>

        <p>
            <form action="" method="POST" class="bookingForm">

                <input hidden='hidden' type='text' name='restaurantId' value='${restaurant.id}'>

                <div class="editor-label">
                    <label for="RestaurantTableNumber">Table number*</label>
                </div>
                <div class="editor-field">
                    <input type="number" min="1" max="30" step="1" pattern="\d{2}" required id="RestaurantTableNumber"
                           name="RestaurantTableNumber" data-val-required=""/>
                </div>

                <div class="editor-label">
                    <label for="RestaurantTableCount">People count*</label>
                </div>
                <div class="editor-field">
                    <input type="number" min="1" max="50" step="1" pattern="\d{2}" required id="RestaurantTableCount"
                           name="RestaurantTableCount" data-val-required=""/>
                </div>

        <p>
            <input type="submit" value="Add"/>
        </p>
        </form>
        </p>

        ${message}

        <table class="table restaurants">
            <tr>
                <th>Table number</th>
                <th>People count</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${restaurantTables}" var="table">
                <tr>
                    <td>${table.number}</td>
                    <td>${table.count}</td>
                    <td>
                        <a href="/restaurant/table/delete/${table.id}/${restaurant.id}/">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <div>
            <a href="/restaurant/all">Back to List</a>
        </div>

    </section>
</div>
<jsp:include page="../fragments/footer.jsp"/>

</body>
</html>
