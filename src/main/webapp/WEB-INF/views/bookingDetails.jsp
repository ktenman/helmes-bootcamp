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


        <h2>Booking's details</h2>

        <p>
            <a href="/booking/create">Create New</a>
        </p>

        <jsp:include page="../fragments/bookingDetails.jsp"/>

        <%--<fieldset>--%>
        <%--<legend>DbBooking</legend>--%>

        <%--<div class="display-label">--%>
        <%--Booking information--%>
        <%--</div>--%>
        <%--<div class="display-field">--%>
        <%--${booking}--%>
        <%--</div>--%>
        <%--</fieldset>--%>
        <p>
            <a href="/booking/edit/${booking.id}">Edit</a> |
            <a href="/bookings">Back to List</a>
        </p>

    </section>
</div>
<jsp:include page="../fragments/footer.jsp"/>

</body>
</html>
