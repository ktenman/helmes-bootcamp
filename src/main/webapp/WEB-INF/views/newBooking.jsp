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

        <h2>Create</h2>

        <%--<form:form commandName="booking" class="bookingForm">--%>
        <%--<fieldset>--%>
        <%--<legend>DbBooking</legend>--%>
        <%--<div class="editor-label">--%>
        <%--<label for="BookingInformation">Booking information</label>--%>
        <%--</div>--%>
        <%--<form:radiobuttons path="restaurant" items="${restaurants}" />--%>
        <%--<div class="editor-field">--%>
        <%--<form:textarea path="bookingInformation" id="BookingInformation" name="BookingInformation" data-val-required=""/>--%>
        <%--</div>--%>
        <%--<p>--%>
        <%--<input type="submit" value="Create"/>--%>
        <%--</p>--%>
        <%--</fieldset>--%>
        <%--</form:form>--%>


        <div>
            <form action="create/" method="POST" class="bookingForm">
                <p>
                    <label>Choose restaurant*</label>
                    <c:forEach items="${restaurants}" var="restaurant">
                        <label style="white-space:nowrap; display:inline-block;">
                            <input type="radio" name="restaurantId" id="restaurantId" class="required"
                                   style="width:70px;" value="${restaurant.id}"/>
                                ${restaurant.name}
                        </label><br/>
                    </c:forEach>
                    <label for="restaurantId" generated="true" class="error"></label>
                </p>

                <label for="date">Date and time*</label>
                <input type="text" name="date" id="date" value="" data-val-required=""/><br/>

                <label for="duration">Duration (hours)*</label>
                <input type="text" class="one-digit" name="duration" id="duration" value="" data-val-required=""/><br/>

                <label for="count">People count*</label>
                <input type="number" min="1" step="1" max="50" class="zero-digit" name="count" id="count" value=""
                       data-val-required=""/><br/>

                <label for="contactName">Contact name*</label>
                <input type="text" name="contactName" id="contactName" value="" data-val-required=""/><br/>

                <label for="contactMethod">Contact method*</label>
                <%--<input type="text" name="contactMethod" id="contactMethod" value="" data-val-required=""/><br />--%>
                <select name="contactMethod" id="contactMethod" class="required">
                    <option value=""></option>
                    <option value="email">email</option>
                    <option value="telefon">telefon</option>
                    <option value="muu">muu</option>
                </select><br/>

                <label for="contactPhoneNumber">Contact phone number</label>
                <input type="text" name="contactPhoneNumber" id="contactPhoneNumber" value=""
                       data-val-required=""/><br/>

                <label for="comments">Booking comments</label>
                <textarea name="comments" id="comments"></textarea><br/>
                <input type="submit" value="Submit"/>
            </form>
        </div>

        <div>
            <a href="/bookings">Back to List</a>
        </div>
    </section>
</div>

<jsp:include page="../fragments/footer.jsp"/>
</body>
</html>
