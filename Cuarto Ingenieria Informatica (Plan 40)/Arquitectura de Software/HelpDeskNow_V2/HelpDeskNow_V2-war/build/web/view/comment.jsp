<%-- 
    Document   : comment
    Created on : 12-mar-2022, 10:38:43
    Author     : Usuario
--%>

<%@page import="entity.Ticket"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="./common/head.jsp" %>
    <%@include file="./common/header.jsp" %>
    <body>
        <% 
            Ticket currentTicket = (Ticket) session.getAttribute("currentTicket");
        %>
        <div class="container">
            <div class="row">
                <div class="panel panel-info">
                    <div class="panel-heading">
                        <h2>New Comment for: <%= currentTicket.getTicketId() %></h2>
                    </div>
                    <form action="FrontController" method="POST">
                        <div class="panel-body">
                                <div class="form-group">
                                    <label for="title">Title</label>
                                    <input type="text" name="title" class="form-control" id="title" value="">
                                </div>
                                <div class="form-group">
                                    <label for="message">Content:</label>
                                    <textarea name="message" class="form-control" rows="5" id="message"></textarea>
                                </div>
                        </div>
                        <div class="panel-footer">
                            <div class="container">
                                <div class="row align-items-center">
                                    <div>
                                        <input type="hidden" name="command" value="comment.AddCommentCommand" />
                                        <input type="hidden" name="ticketId" value="<%= currentTicket.getTicketId() %>"/>
                                        <input class="btn btn-success" type="submit" value="Add" />
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
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
