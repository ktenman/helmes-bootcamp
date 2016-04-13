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

        <h2>Booking Statistics</h2>

        <h3>Week from
            ${statistics.dateToString(statistics.getWeekStart(statistics.weekId))} till
            ${statistics.dateToString(statistics.getWeekEnd(statistics.weekId))}
        </h3>
        <p>
            <a href="./${back}"><input type="button" value="Back"/></a>
            <a href="./${forward}"><input type="button" value="Forward"/></a>
            <b>
                <table class="table bookingStatistics">
                    <tr class="statisticsTableHead">
                        <th></th>
                        <th>Monday</th>
                        <th>Tuesday</th>
                        <th>Wednesday</th>
                        <th>Thursday</th>
                        <th>Friday</th>
                        <th>Saturday</th>
                        <th>Sunday</th>
                    </tr>
                    <c:forEach items="${restaurants}" var="restaurant">
                        <tr>
                            <td>${restaurant.aadress}</td>
                            <td>${statistics.getBookingCountByWeekDay("Monday", restaurant)}</td>
                            <td>${statistics.getBookingCountByWeekDay("Tuesday", restaurant)}</td>
                            <td>${statistics.getBookingCountByWeekDay("Wednesday", restaurant)}</td>
                            <td>${statistics.getBookingCountByWeekDay("Thursday", restaurant)}</td>
                            <td>${statistics.getBookingCountByWeekDay("Friday", restaurant)}</td>
                            <td>${statistics.getBookingCountByWeekDay("Saturday", restaurant)}</td>
                            <td>${statistics.getBookingCountByWeekDay("Sunday", restaurant)}</td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td>Totals</td>
                        <td><span id="weekDay0"></span></td>
                        <td><span id="weekDay1"></span></td>
                        <td><span id="weekDay2"></span></td>
                        <td><span id="weekDay3"></span></td>
                        <td><span id="weekDay4"></span></td>
                        <td><span id="weekDay5"></span></td>
                        <td><span id="weekDay6"></span></td>
                    </tr>
                </table>
        <p>
            <a href="./${back}">Back</a>
            <a href="./${forward}">Forward</a>
        </p>
    </section>
</div>
<jsp:include page="../fragments/footer.jsp"/>

</body>
</html>
