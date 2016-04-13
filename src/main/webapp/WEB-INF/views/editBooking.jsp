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

        <h2>Edit booking</h2>

        <%--<form:form modelAttribute="booking" class="bookingForm">--%>
        <%--<fieldset>--%>
        <%--<legend>DbBooking</legend>--%>

        <%--<form:hidden path="id"/>--%>
        <%--<div class="editor-label">--%>
        <%--<label for="BookingInformation">Booking information</label>--%>
        <%--</div>--%>
        <%--<div class="editor-field">--%>
        <%--<form:textarea path="bookingInformation" id="BookingInformation" name="BookingInformation"/>--%>
        <%--</div>--%>

        <form action="${booking.id}" method="POST" class="bookingForm">
            <%--<form:form modelAttribute="booking" class="bookingForm" action="?" method="post">--%>
            <input hidden='hidden' type='text' name='id' value='${booking.id}'>
            <p>
                <label>Choose restaurant*</label>
                <c:forEach items="${restaurants}" var="restaurant">
                    <label style="white-space:nowrap; display:inline-block;">
                        <input type="radio" name="restaurantId"
                               id="restaurantId" ${restaurant.id==booking.restaurant.id ? "checked":""} class="required"
                               style="width:70px;" value="${restaurant.id}"/>
                            ${restaurant.name}
                    </label><br/>
                </c:forEach>
                <label for="restaurantId" generated="true" class="error"></label>
            </p>

            <label for="date">Date and time*</label>
            <input type="text" name="date" id="date" value="${booking.getFormattedDate()}" data-val-required=""/><br/>

            <label for="duration">Duration*</label>
            <input type="text" class="one-digit" name="duration" id="duration" value="${booking.duration}"
                   data-val-required=""/><br/>

            <label for="count">People count*</label>
            <input type="text" class="zero-digit" name="count" id="count" value="${booking.count}"
                   data-val-required=""/><br/>

            <label for="contactName">Contact name*</label>
            <input type="text" name="contactName" id="contactName" value="${booking.contactName}" data-val-required=""/><br/>

            <label for="contactMethod">Contact method*</label>
            <%--<input type="text" name="contactMethod" id="contactMethod" value="" data-val-required=""/><br />--%>
            <select name="contactMethod" id="contactMethod" class="required">
                <option value="${booking.contactMethod}">${booking.contactMethod}</option>
                <option value="${booking.contactMethod!="email" ? "email" : ""}">${booking.contactMethod!="email" ? "email" : ""}</option>
                <option value="${booking.contactMethod!="telefon" ? "telefon" : ""}">${booking.contactMethod!="telefon" ? "telefon" : ""}</option>
                <option value="${booking.contactMethod!="muu" ? "muu" : ""}">${booking.contactMethod!="muu" ? "muu" : ""}</option>
            </select><br/>

            <label for="contactPhoneNumber">Contact phone number</label>
            <input type="text" name="contactPhoneNumber" id="contactPhoneNumber" value="${booking.contactPhoneNumber}"
                   data-val-required=""/><br/>

            <label for="comments">Booking comments</label>
            <textarea name="comments" id="comments">${booking.comments}</textarea><br/>

            <p>
                <label for="canceled" class="canceled">
                    <input ${booking.canceled==1?"checked":""} type="checkbox" name="canceled" id="canceled" value="1">
                    Canceled
                </label>
            </p>

            <input type="submit" value="Save"/>
        </form>
        <%--</fieldset>--%>
        <%--</form:form>--%>
        <div>
            <a href="/bookings">Back to List</a>
        </div>


    </section>
</div>
<jsp:include page="../fragments/footer.jsp"/>

</body>
</html>
