<%-- 
    Document   : assignedToSelf
    Created on : 11-mar-2022, 13:42:53
    Author     : Entrar
--%>

<%@page import="java.util.List"%>
<%@page import="entity.Agent"%>
<%@page import="entity.Ticket"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="container">
    <div class="row">
        <%
            Agent currentAgent = ((Agent) session.getAttribute("user"));
            List<Ticket> ticketsList = (List<Ticket>) session.getAttribute("ticketsAssignedToAgent");
        %>
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h2>Tickets Assigned to: <%=currentAgent.getName()%></h2>
            </div>
            <div class="panel-body">
                <div class="table-responsive col-lg-12">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Title</th>
                                <th>Status</th>
                                <th>Client</th>
                                <th>Date</th>
                                <th colspan="2">Opciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% 
                            if(ticketsList != null){
                                for (Ticket ticket : ticketsList) {
                                    if(!ticket.getTicketStatus().getName().equals("CLOSED")){
                                    out.print("<tr>");
                                    out.print("<td>"+ticket.getTicketId()+"</td>");  
                                    out.print("<td>"+ticket.getTitle()+"</td>");   
                                    out.print("<td>"+ticket.getTicketStatus().getName()+"</td>");    
                                    out.print("<td>"+ticket.getClient().getName()+"</td>");    
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
                                            <input type="hidden" name="command" value="ticket.ChangeStatusView" />
                                            <input type="hidden" name="ticketId" value="<%= ticket.getTicketId() %>" />
                                            <input type="submit" value="Set Status" class="btn btn-primary"/>
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
</div>
