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

        <h2>List of bookings</h2>

        <p>
            <a href="/booking/create">Create New</a>
        </p>

        <p>
            <input type="text" id="search" placeholder="Type to search"/>
        </p>
        <p>
            <label>Filter by restaurant(s)</label>
            <c:forEach items="${restaurants}" var="restaurant">
                <label id="restaurantId">
                    <input type="checkbox" checked name="restaurantId" id="restaurantId" value="${restaurant.name}"/>
                        ${restaurant.name}
                </label><br/>
            </c:forEach>
        </p>
        <p>
            <label>Filter by date</label>
            From<input type="text" name="startDate" id="startDate" value=""/>
            Before<input type="text" name="endDate" id="endDate" value=""/>
        </p>
        <%-- <div id="results"></div> --%>
        <table class="table bookingDetails">
            <tr class="bookingTableHead">
                <th>Restaurant</th>
                <th>Date and time</th>
                <th>Duration</th>
                <th>Count</th>
                <th>Name</th>
                <th>Method</th>
                <th>Phone number</th>
                <th>Comments</th>
                <th>Created</th>
                <th>Actions</th>
            </tr>
            <c:forEach items="${bookings}" var="booking">
                <tr class="booking ${booking.canceled==1?" strikeOut":" "} ${booking.creationTime.compareTo(booking.modificationTime)!=0?" revised":" "}">
                    <td>${booking.restaurant}</td>
                    <td>${booking.getFormattedDate()}</td>
                    <td>${booking.duration}</td>
                    <td>${booking.count}</td>
                    <td>${booking.contactName}</td>
                    <td>${booking.contactMethod}</td>
                    <td>${booking.contactPhoneNumber}</td>
                    <td>${booking.comments}</td>
                    <td>${booking.getFormattedCreationTime()}</td>
                    <td>
                        <a href="/booking/edit/${booking.id}">Edit</a><br/>
                        <a href="/booking/details/${booking.id}">Details</a><br/>
                        <a href="/booking/cancel/${booking.id}">Cancel</a>
                            <%--<a href="/booking/delete/${booking.id}">Delete</a>--%>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </section>
</div>
<jsp:include page="../fragments/footer.jsp"/>

</body>
</html>
