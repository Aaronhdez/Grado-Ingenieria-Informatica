<%-- 
    Document   : closeTicket
    Created on : 12-mar-2022, 13:01:48
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="./common/head.jsp" %>
    <%@include file="./common/header.jsp" %>
    <body>
        <div class="container">
            <div class="row">
                <div class="panel panel-warning">
                    <div class="panel-heading">
                        <h2>Closing Ticket</h2>
                    </div>
                    <div class="panel-body">
                        <p>¿Are you sure?</p>
                        <form action="FrontController" method="POST">
                            <input type="hidden" name="command" value="ticket.CloseTicketCommand" />
                            <input type="hidden" name="ticketId" value="<%= request.getParameter("ticketId") %>" />
                            <input type="submit" value="Close Ticket" class="btn btn-success"/>
                        </form>
                    </div>
                    <div class="panel-footer">
                        <div class="container">
                            <div class="row align-items-center">
                                <div><button class="btn btn-primary" type="button" onclick="history.back()">Back</button></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <%@include file="./common/footer.jsp" %>
</html>
