<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:pot="www.ftn.uns.ac.rs/potvrda_o_vakcinaciji"
    xmlns:fo="http://www.w3.org/1999/XSL/Format" version="2.0">
    
    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="bookstore-page">
                    <fo:region-body margin="0.75in"/>
                </fo:simple-page-master>
            </fo:layout-master-set>
            
            <fo:page-sequence master-reference="bookstore-page">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block text-align-last="justify" font-weight="bold" font-size="10px">
                        <fo:leader leader-pattern="space" />
                        INSTITUT ZA JAVNO ZDRAVLJE DR MILAN JOVANOVIC BATUT
                    </fo:block>
                    <fo:block >
                        <fo:external-graphic src="https://data.gov.rs/s/avatars/2e/7864606e35474b98eb147395fecb72-100.png" width="100px" content-width="100px" content-height="100px" height="100px"/>
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1em" margin-top="20px">
                        Sifra potvrde vakcine: <xsl:value-of select="pot:Potvrda/pot:Sifra_potvrde"/>
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="0.66em" color="gray" margin-bottom="15px">
                        Confirmation code:
                        
                        
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="2em" font-weight="bold"  text-align="center" margin-bottom="1px">
                        POTVRDA O IZVRESNOJ VAKCINACIJI PROTIV COVID-19
                        
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1.17em" font-weight="bold" color="gray" text-align="center" margin-top="1px">
                        CONFIRMATION OF THE COVID-19 VACCINATION
                        
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1em" margin-top="20px">
                        Ime i prezime: <xsl:value-of select="pot:Potvrda/pot:pacijent[1]/pot:Ime_i_prezime"/>
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="0.66em" color="gray" margin-bottom="15px">
                        First and Last Name:
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1em">
                        Pol: <xsl:value-of select="pot:Potvrda/pot:pacijent/pot:Pol"/>
                    </fo:block>
                    <xsl:if test="pot:Potvrda/pot:pacijent/pot:Pol='Musko'">
                        <fo:block font-family="sans-serif" font-size="0.66em" color="gray" margin-bottom="15px">
                            
                            Gender: Male
                        </fo:block>
                    </xsl:if>
                    <xsl:if test="pot:Potvrda/pot:pacijent/pot:Pol='Zensko'">
                        <fo:block font-family="sans-serif" font-size="0.66em" color="gray" margin-bottom="15px">
                            
                            Gender: Female
                        </fo:block>
                    </xsl:if>
                    
                    <fo:block font-family="sans-serif" font-size="1em">
                        Datum davanja i broj serije prve doze vakcine: <xsl:value-of select="/pot:Potvrda/pot:Vakcinacija_info[1]/pot:Prva_doza[1]/pot:Datum_vakcine[1]"/>, serija: <xsl:value-of select="/pot:Potvrda/pot:Vakcinacija_info[1]/pot:Prva_doza[1]/pot:Serija_vakcine"/>

                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="0.66em" color="gray" margin-bottom="15px">
                        Vaccination Date:
                        
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1em">
                        Datum davanja i broj serije druge doze vakcine: <xsl:value-of select="/pot:Potvrda/pot:Vakcinacija_info[1]/pot:Druga_doza[1]/pot:Datum_vakcine[1]"/>, serija: <xsl:value-of select="/pot:Potvrda/pot:Vakcinacija_info[1]/pot:Druga_doza[1]/pot:Serija_vakcine"/>
                        
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="0.66em" color="gray" margin-bottom="15px">
                        Second Vaccination Date:
                        
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1em">
                        Naziv vakcine: <xsl:value-of select="/pot:Potvrda/pot:Vakcinacija_info[1]/pot:Naziv_vakcine[1]"/>
                        
                        
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="0.66em" color="gray" margin-bottom="15px">
                        Name of vaccine:
                        
                        
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1em">
                        Datum izdavanja potvrde: <xsl:value-of select="/pot:Potvrda/pot:Vakcinacija_info[1]/pot:Datum_izdavanja[1]"/>
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="0.66em" color="gray" margin-bottom="15px">
                        Confirmation Release Date:
                        
                       
                    </fo:block>

                    <fo:block text-align-last="justify" font-weight="bold" font-size="10px">
                        <fo:leader leader-pattern="space" />
                        <xsl:value-of select="/pot:Potvrda/pot:Vakcinacija_info[1]/pot:Zdravstvena_ustanova[1]"/>
                    </fo:block>
                    <fo:block text-align-last="justify" font-weight="bold" color="gray" font-size="10px">
                        <fo:leader leader-pattern="space" />
                        Medical institution
                    </fo:block>
                    <fo:block text-align-last="justify" font-weight="bold" font-size="10px">
                        <fo:leader leader-pattern="space" />
                        <fo:external-graphic src="data:image/png;base64, iVBORw0KGgoAAAANSUhEUgAAAGQAAABkAQAAAABYmaj5AAABNElEQVR4Xt3SMZKEIBAFUEjkCpLI1cZEr6DJCIleARK4GiaQbggJLFUyO/YUe4Eh8lld/bsVlG/nB32/OA40PRfEGjLxcPSM2TQkqX1SH0VbxmGl/pElblqbKglhFeqddxMvLZSSf3PelbMPQ3l+7XcX76mblmnaWho6LJ9jqj2BsmRpjI7VnkA+kcT2WbWk8bFj2dVKqJj1mIZ+uhKg8ukTPWx3TQbFyaGZpTUBSkXhz+iGqxIqG0kTGl1NADJKWWJ0/RJQ+3bK/oHPKwEqh9mhtbxsSPiAU7faKwFKolVvgteNoIybo7JrTYDSj9F1CyKmoWISsKm3B4rjI7BE62RQJnrZk1cllKT7A0fe1ak/JJlFE74m+5Rwm1Cu7gdkotGs/NC6HxDHotxIol9z3vU+X69f/0f3JOKplTAAAAAASUVORK5CYII=" width="100px" content-width="100px" content-height="100px" height="100px"/>
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1em">
                        Ova potvrda vazi bez potpisa i pecata
                        
                        
                        
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="0.66em" color="gray" margin-bottom="15px">
                        This certificate is valid without signatures and seals                        
                        
                    </fo:block>
                    
                    
              
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>