<%-- 
    Document   : fullTicketsList
    Created on : 11-mar-2022, 13:43:06
    Author     : Entrar
--%>

<%@page import="java.util.List"%>
<%@page import="entity.Ticket"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="container">
    <div class="row">
        <%
            List<Ticket> pagedTicketList = (List<Ticket>) session.getAttribute("pagedTicketList");
            Integer lastResult = ((Integer) session.getAttribute("lastResult"));
            Integer currentPage = (Integer) session.getAttribute("currentPage");
            Integer pages = (Integer) session.getAttribute("pages");
        %>
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h2>Opened Tickets</h2>
            </div>
            <div class="panel-body">
                <div class="table-responsive col-lg-12">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Title</th>
                                <th>Status</th>
                                <th>Team</th>
                                <th>Agent</th>
                                <th>Client</th>
                                <th>Date</th>
                                <th colspan="3">Options</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% 
                            if(pagedTicketList != null){
                                for (Ticket ticket : pagedTicketList) {
                                        out.print("<tr>");
                                        out.print("<td>"+ticket.getTicketId()+"</td>");    
                                        out.print("<td>"+ticket.getTitle()+"</td>");    
                                        out.print("<td>"+ticket.getTicketStatus().getName()+"</td>");
                                        if(ticket.getAgent() == null){
                                            out.print("<td>-</td>"); 
                                            out.print("<td>-</td>");  
                                        } else {
                                            out.print("<td>"+ticket.getAgent().getTeam().getName()+"</td>");  
                                            out.print("<td>"+ticket.getAgent().getName()+"</td>");  
                                        }
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
                                            <input type="submit" value="Update Status" class="btn btn-primary"/>
                                        </form>
                                    </td>
                                    <td>
                                        <form action="FrontController" method="POST">
                                            <input type="hidden" name="command" value="ticket.AssignToTechnicianCommand" />
                                            <input type="hidden" name="ticketId" value="<%= ticket.getTicketId() %>" />
                                            <input type="submit" value="Assign" class="btn btn-info"/>
                                        </form>
                                    </td>
                                <%      out.print("</tr>");
                                }
                            }
                            %>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="panel-footer">
                <%
                    if(currentPage == 0){
                        out.print("<form method=\"POST\" action=\"FrontController\">");
                        out.print("<input type=\"hidden\" name=\"lastResult\" value=\""+(lastResult)+"\" />");
                        out.print("<input type=\"hidden\" name=\"command\" value=\"pagination.SwitchPageCommandForward\" />");
                        out.print("<input type=\"submit\" value=\"Next 10 Results\" class=\"btn btn-primary\"/>");
                        out.print("</form>");
                    } else if(currentPage == pages) {
                        out.print("<form method=\"POST\" action=\"FrontController\">");
                        out.print("<input type=\"hidden\" name=\"lastResult\" value=\""+(lastResult)+"\" />");
                        out.print("<input type=\"hidden\" name=\"command\" value=\"pagination.SwitchPageCommandBackwards\" />");
                        out.print("<input type=\"submit\" value=\"Previous 10 Results\" class=\"btn btn-primary\"/>");
                        out.print("</form>");
                    } else {
                        out.print("<form method=\"POST\" action=\"FrontController\">");
                        out.print("<input type=\"hidden\" name=\"lastResult\" value=\""+(lastResult)+"\" />");
                        out.print("<input type=\"hidden\" name=\"command\" value=\"pagination.SwitchPageCommandBackwards\" />");
                        out.print("<input type=\"submit\" value=\"Previous 10 Results\" class=\"btn btn-primary\"/>");
                        out.print("</form>");
                        out.print("<form method=\"POST\" action=\"FrontController\">");
                        out.print("<input type=\"hidden\" name=\"lastResult\" value=\""+(lastResult)+"\" />");
                        out.print("<input type=\"hidden\" name=\"command\" value=\"pagination.SwitchPageCommandForward\" />");
                        out.print("<input type=\"submit\" value=\"Next 10 Results\" class=\"btn btn-primary\"/>");
                        out.print("</form>");
                    }
                %>
            </div>
        </div>
    </div>
</div>
