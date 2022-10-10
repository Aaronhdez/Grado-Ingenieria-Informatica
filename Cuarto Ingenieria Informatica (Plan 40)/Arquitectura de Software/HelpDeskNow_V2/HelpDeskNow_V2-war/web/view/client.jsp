<%-- 
    Document   : client
    Created on : 02-mar-2022, 19:21:15
    Author     : Usuario
--%>

<%@page import="entity.Ticket"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="./common/head.jsp" %>
    <%@include file="./common/header.jsp" %>
    <body>
        <div class="container">
            <div class="row">
                <div class="panel panel-info">
                    <div class="panel-heading">
                        <h2>My Tickets</h2>
                    </div>
                    <div class="panel-body">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Title</th>
                                    <th>Status</th>
                                    <th>Asignee</th>
                                    <th>Date</th>
                                    <th colspan="2">Options</th>
                                </tr>
                            </thead>
                            <tbody>
                                <% 
                                List<Ticket> ticketsList = (List<Ticket>) session.getAttribute("ticketsCreatedByClient");
                                if(ticketsList != null){
                                    for (Ticket ticket : ticketsList) {
                                        if(!ticket.getTicketStatus().equals("CLOSED")){
                                            out.print("<tr>");
                                            out.print("<td>"+ticket.getTicketId()+"</td>");  
                                            out.print("<td>"+ticket.getTitle()+"</td>");   
                                            out.print("<td>"+ticket.getTicketStatus().getName()+"</td>"); 
                                            if(ticket.getAgent() != null){
                                                out.print("<td>"+ticket.getAgent().getName()+"</td>");
                                            } else {
                                                out.print("<td>-</td>");
                                            }
                                            out.print("<td>"+ticket.getDate()+"</td>");
                                    %>
                                            <td>
                                                <form action="FrontController" method="POST">
                                                    <input type="hidden" name="command" value="ticket.ViewTicketCommand" />
                                                    <input type="hidden" name="ticketId" value="<%= ticket.getTicketId() %>" />
                                                    <input type="submit" value="View Ticket" class="btn btn-default"/>
                                                </form>
                                            </td>
                                            <td>
                                                <form action="FrontController" method="POST">
                                                    <input type="hidden" name="command" value="context.RedirectCommand" />
                                                    <input type="hidden" name="destination" value="/view/closeTicket.jsp" />
                                                    <input type="hidden" name="ticketId" value="<%= ticket.getTicketId() %>" />
                                                    <input type="submit" value="Close Ticket" class="btn btn-success"/>
                                                </form>
                                            </td>
                                    <%      out.print("</tr>");   
                                        }
                                    }
                                }
                                %>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <%@include file="./common/footer.jsp" %>
</html>
