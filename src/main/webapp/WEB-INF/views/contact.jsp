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


        <hgroup class="title">
            <h1>MõnusPitsa OÜ</h1>
            <%--<h2>Bootcamp contacts</h2>--%>
        </hgroup>

        <section class="contact">
            <header>
                <h3>Email</h3>
            </header>
            <p>
                <span class="label">Support:</span>
                <span><a href="mailto:bootcamp@helmes.ee">bootcamp@helmes.ee</a></span>
            </p>
        </section>

        <section class="contact">
            <header>
                <h3>Address</h3>
            </header>
            <p>
                Lõõtsa 6B, Tallinn, 11415, Estonia
            </p>
        </section>
    </section>
</div>
<jsp:include page="../fragments/footer.jsp"/>

</body>
</html>
