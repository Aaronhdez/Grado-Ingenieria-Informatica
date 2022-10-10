<%-- 
    Document   : newTicket
    Created on : 07-mar-2022, 11:02:24
    Author     : Entrar
--%>

<%@page import="entity.TicketClass"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="./common/head.jsp" %>
    <%@include file="./common/header.jsp" %>
    <body>
        <div class="container">
            <div class="panel panel-info">
                <div class="panel-heading">
                <h1>New Ticket</h1>
                </div>
                <form action="FrontController" method="POST">
                <div class="panel-body">
                    <div class="form-group">
                        <label for="user">User:</label>
                        <% if (user instanceof Agent) { 
                            out.println("<input type=\"text\" class=\"form-control\" id=\"user\" value=\""+ ((Agent) user).getName() +"\" readonly>");  
                        } else { 
                            out.println("<input type=\"text\" class=\"form-control\" id=\"user\" value=\""+ ((Client) user).getName() +"\" readonly>");  
                        } %>
                    </div>
                    <div class="form-group">
                        <label for="title">Issue:</label>
                        <input type="text" name="title" class="form-control" id="title" value="">
                    </div>
                    <div class="form-group">
                        <label for="message">Comment:</label>
                        <textarea name="message" class="form-control" rows="5" id="message"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="role">Position:</label>
                        <select class="form-control" id="role" name="ticketClass">
                            <%
                                for(TicketClass tClass : (List<TicketClass>) session.getAttribute("ticketClassList")){
                                    out.print("<option>"+tClass.getName()+"</option>");
                                }
                            %>
                        </select>
                    </div> 
                    <div>
                        <input type="hidden" name="command" value="ticket.AddNewTicketCommand" />
                        <input class="btn btn-success" type="submit" value="Open" />
                    </div>
                </div>
                </form>
                <div class="panel-footer">
                    <button class="btn btn-primary" type="button" onclick="history.back()">Back</button>
                </div>
            </div>
        </div>
    </body>
    <%@include file="./common/footer.jsp" %>
</html>
