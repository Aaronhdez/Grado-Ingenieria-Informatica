<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : TicketFsXSL.xsl
    Created on : 8 de marzo de 2022, 17:56
    Author     : Entrar
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="xml"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
        <xsl:template match="schema">
            <ticket><xsl:apply-templates/></ticket>
        </xsl:template>
        <xsl:template match="schema/tid">
            <ticketId><xsl:apply-templates/></ticketId>
        </xsl:template>
        <xsl:template match="schema/tstatus">
            <ticketStatus><xsl:apply-templates/></ticketStatus>
        </xsl:template>
</xsl:stylesheet>
