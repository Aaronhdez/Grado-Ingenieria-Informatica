<%-- 
    Document   : ticket
    Created on : 03-mar-2022, 12:41:57
    Author     : Usuario
--%>

<%@page import="java.util.List"%>
<%@page import="entity.Comment"%>
<%@page import="entity.Ticket"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="./common/head.jsp" %>
    <body class="">
        <%@include file="./common/header.jsp" %>
        <div class="container">
            <div class="row">
                <div class="panel panel-primary">
                    <% 
                    Ticket currentTicket = (Ticket) session.getAttribute("currentTicket");
                    if(currentTicket != null){
                        out.println("<div class=\"panel-heading\">"
                                + "<h1>Ticket: "+currentTicket.getTicketId()+"</h1>"
                                + "</div>");
                        out.print("<div class=\"panel-body\">");
                        for (Comment comment : (List<Comment>) session.getAttribute("commentsAssociated")) {
                            out.print("<div class=\"panel panel-primary\">");
                                out.print("<div class=\"panel-heading\">");
                                    out.print("<div class=\"\">"); 
                                    if(comment.getAgent() == null){
                                        out.print("<h4>Asunto: "+comment.getTitle()+" ("
                                            + comment.getClient().getName()
                                            + ")</h4>"); 
                                    } else {
                                        out.print("<h4>Asunto: "+comment.getTitle()+" ("
                                            + comment.getAgent().getName()
                                            + ")</h4>"); 
                                    }
                                    out.print("</div>");
                                out.print("</div>");
                                out.print("<div class=\"panel-body\">");
                                out.print("<p>"+comment.getDescription()+"</p>");    
                                out.print("</div>");
                                out.print("<div class=\"panel-footer\">"); 
                                out.print("<p>Publicado el: "+comment.getDate()+"</p>");
                                out.print("</div>");
                            out.print("</div>");
                        } 
                        out.print("</div>");
                    }
                    %>
                    <div class="panel-footer">
                        <div class="container">
                            <div class="row align-items-center">
                                <div class="col-sm-8"></div>
                                <div class="col-sm-2">
                                    <form action="FrontController" method="POST">
                                        <input type="hidden" name="command" value="context.RedirectCommand" />
                                        <input type="hidden" name="destination" value="/view/comment.jsp" />
                                        <input type="hidden" name="ticketId" value="<%= currentTicket.getTicketId() %>" />
                                        <input type="submit" value="Add New Comment" class="btn btn-default"/>
                                    </form>
                                </div>
                                <div class="col-sm-2">
                                    <form action="FrontController" method="POST">
                                        <input type="hidden" name="command" value="context.RedirectCommand" />
                                        <input type="hidden" name="destination" value="/view/closeTicket.jsp" />
                                        <input type="hidden" name="ticketId" value="<%= currentTicket.getTicketId() %>" />
                                        <input type="submit" value="Close Ticket" class="btn btn-success"/>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="panel-footer">
                        <div class="container">
                            <div class="row align-items-center">
                                <div class="col-sm-2"><button class="btn btn-primary" type="button" onclick="history.back()">Back</button></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
                
    </body>
</html>
