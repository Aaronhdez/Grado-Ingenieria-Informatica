<%-- 
    Document   : info
    Created on : 11-mar-2022, 13:08:57
    Author     : Entrar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="./common/head.jsp" %>
    <body>
        <div class="container col-lg-12">
            <div class="jumbotron">
                <h2><%= request.getAttribute("headerMsg") %></h2>
                <% request.removeAttribute("headerMsg"); %>
                <a href="/HelpDeskNow_V2-war/">Go Back to Index</a>
            </div>
        </div>
        
    </body>
    <%@include file="./common/footer.jsp" %>
</html>
