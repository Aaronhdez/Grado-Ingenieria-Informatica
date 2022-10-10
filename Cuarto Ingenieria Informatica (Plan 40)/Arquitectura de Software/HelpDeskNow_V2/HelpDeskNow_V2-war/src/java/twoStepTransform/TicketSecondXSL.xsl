<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : TicketStatusXSL.xsl
    Created on : 8 de marzo de 2022, 16:43
    Author     : Entrar
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="ticket">
        <html>
            <head>       
                <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"/>
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
                <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
                <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet"/>
                <link rel="stylesheet" href="./styles/styles.css"/>
                <title><xsl:value-of select="ticketId"/></title>
            </head>
            <body>
                <div class="container">
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <h1>Ticket: <xsl:value-of select="ticketId"/></h1>
                        </div>
                        <div class="panel-body">
                            <div class="form-group">
                                <b>Status:</b><xsl:value-of select="ticketStatus"/>
                            </div>
                            <form action="FrontController" method="POST">
                                <div class="form-group">
                                    <label for="sel1">Select list:</label>
                                    <select name="statuses" class="form-control" id="sel1">
                                        <option value="ASSIGNED">ASSIGNED</option>
                                        <option value="UNASSIGNED">UNASSIGNED</option>
                                        <option value="IN_PROCESS">IN_PROCESS</option>
                                        <option value="CLOSED">CLOSED</option>
                                    </select>
                                </div>
                                <div class="container-row padding-10">
                                    <input type="hidden" name="command" value="ticket.ChangeStatusCommand" />
                                    <input type="hidden" name="ticketId" value="{ticketId}"/>
                                    <input class="btn btn-success" type="submit" value="Update" />
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
