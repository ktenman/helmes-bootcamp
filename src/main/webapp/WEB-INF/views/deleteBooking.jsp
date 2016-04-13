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


        <h2>Delete</h2>

        <h3>Are you sure you want to delete this?</h3>
        <fieldset>
            <legend>DbBooking</legend>

            <div class="display-label">
                Booking information
            </div>
            <div class="display-field">
                ${booking}
            </div>
        </fieldset>
        <form:form>
            <p>
                <input type="submit" value="Delete"/> |
                <a href="/bookings">Back to List</a>
            </p>
        </form:form>
    </section>
</div>
<jsp:include page="../fragments/footer.jsp"/>

</body>
</html>
