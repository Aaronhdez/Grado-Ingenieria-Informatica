<%-- 
    Document   : header
    Created on : 09-mar-2022, 13:53:24
    Author     : Entrar
--%>

<%@page import="entity.Client"%>
<%@page import="entity.Agent"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <header>
        <div class="container col-sm-12" >
            <div class="page-header" style="color: #337ab7">
                <%
                Object user = session.getAttribute("user");
                String name = "";
                if (user instanceof Agent) {
                    name = ((Agent) user).getName();
                    out.print("<h2>AGENT: "+ name +"</h2>"); 
                } else {
                    name = ((Client) user).getName();
                    out.print("<h2>CLIENT: "+name+"</h2>"); 
                }
                %>
                <ul class="nav nav-tabs">
                    <li class="active">
                        <form action="FrontController" method="POST">
                            <input class="btn btn-primary" type="submit" value="Log Out" />
                            <input type="hidden" name="command" value="user.LogOutCommand" />
                        </form>
                    </li>
                    <li>
                        <form action="FrontController" method="POST">
                            <input class="btn btn-primary" type="submit" value="Open Ticket" />
                            <input type="hidden" name="command" value="context.RedirectCommand" />
                            <input type="hidden" name="destination" value="/view/newTicket.jsp" />
                        </form>
                    </li>
                    <%
                    if (user instanceof Agent) {
                        String newTab = "<li>" 
                            + "<form action=\"FrontController\" method=\"POST\">"
                            + "<input class=\"btn btn-primary\" type=\"submit\" value=\"Show Opened Tickets\" />" 
                            + "<input type=\"hidden\" name=\"command\" value=\"context.RedirectCommand\" />" 
                            + "<input type=\"hidden\" name=\"destination\" value=\"/view/openedTickets.jsp\" />"
                            + "</form>"
                            + "</li>";
                        out.print(newTab);
                    }
                    %>
                    <li class="active">
                        <form action="FrontController" method="POST">
                            <input class="btn btn-primary" type="submit" value="My Tickets" />
                            <input type="hidden" name="command" value="context.RedirectCommand" />
                            <%
                            if (user instanceof Agent) {
                                out.print("<input type=\"hidden\" name=\"destination\" value=\"/view/agent.jsp\" />"); 
                            } else {
                                out.print("<input type=\"hidden\" name=\"destination\" value=\"/view/client.jsp\" />");
                            }
                            %>
                        </form>
                    </li>
                </ul>
            </div>
        </div>
    </header>
