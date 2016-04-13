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


        <h2>List of restaurants</h2>

        <p>
            <a href="/restaurant/create">Create New</a>
        </p>

        <input type="text" id="search" placeholder="Type to search"/>


        <table class="table restaurants">
            <tr>
                <th>Name</th>
                <th>Aadress</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${restaurants}" var="restaurant">
                <tr>
                        <%--<td>${restaurant.id}</td>--%>
                    <td>${restaurant.name}</td>
                    <td>${restaurant.aadress}</td>
                    <td>
                        <a href="/restaurant/edit/${restaurant.id}">Edit</a> |
                        <a href="/restaurant/table/add/${restaurant.id}">Add table</a>
                            <%--|<a href="/restaurant/details/${restaurant.id}">Details</a> |--%>
                            <%--<a href="/restaurant/delete/${restaurant.id}">Delete</a>--%>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </section>
</div>
<jsp:include page="../fragments/footer.jsp"/>

</body>
</html>
