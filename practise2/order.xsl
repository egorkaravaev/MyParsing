<?xml version = "1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <!--<xsl:output doctype-public="-//W3C//DTD XHTML 1.0 Strict//EN" doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"/>-->

    <xsl:template match="/">
        <html>
            <body>
                <table border="1">
                    <caption>ORDER</caption>
                    <tr bgcolor="#CCCCCC">
                        <td align="center"><strong>Country</strong></td>
                        <td align="center"><strong>First name</strong></td>
                        <td align="center"><strong>Last name</strong></td>
                        <td align="center"><strong>Street</strong></td>
                        <td align="center"><strong>City</strong></td>
                    <td align="center"><strong>ZIP</strong></td>
                    </tr>
                    <xsl:for-each select="order/shipping">
                        <tr bgcolor="#F5F5F5">
                            <td><strong>Shipping to </strong><xsl:value-of select="@country"/></td>
                            <td><xsl:value-of select="firstname"/></td>
                            <td><xsl:value-of select="lastname"/></td>
                            <td><xsl:value-of select="street"/></td>
                            <td><xsl:value-of select="city"/></td>
                        <td><xsl:value-of select="zip"/></td>
                        </tr>
                    </xsl:for-each>
                    <xsl:for-each select="order/bill">
                        <tr bgcolor="#F5F5F5">
                            <td><strong>Bill to </strong><xsl:value-of select="@country"/></td>
                            <td><xsl:value-of select="firstname"/></td>
                            <td><xsl:value-of select="lastname"/></td>
                            <td><xsl:value-of select="street"/></td>
                            <td><xsl:value-of select="city"/></td>
                            <td><xsl:value-of select="zip"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
                <p></p>
                <table border="1">
                    <caption>Product's list</caption>
                    <tr bgcolor="#CCCCCC">
                        <td align="center"><strong>ID</strong></td>
                        <td align="center"><strong>Product name</strong></td>
                        <td align="center"><strong>Quantity</strong></td>
                        <td align="center"><strong>Price</strong></td>
                        <td align="center"><strong>Order date</strong></td>
                    </tr>
                    <xsl:for-each select="order/itemslist/item">
                        <tr bgcolor="#F5F5F5">
                            <td><xsl:value-of select="@id"/></td>
                            <td><xsl:value-of select="prodname"/></td>
                            <td><xsl:value-of select="quantity"/></td>
                            <td><xsl:value-of select="price"/></td>
                            <td><xsl:value-of select="orderdate"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>