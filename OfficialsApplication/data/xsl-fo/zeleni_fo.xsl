<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:b="www.ftn.uns.ac.rs/Izvestaj_o_imunizaciji"
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
                        
                        <fo:external-graphic src="https://upload.wikimedia.org/wikipedia/commons/thumb/0/0f/Coat_of_arms_of_Serbia_small.svg/150px-Coat_of_arms_of_Serbia_small.svg.png" width="100px" content-width="100px" content-height="100px" height="100px"/> 
                        <fo:leader leader-pattern="space" />
                        <fo:external-graphic src="data:image/png;base64, iVBORw0KGgoAAAANSUhEUgAAAGQAAABkAQAAAABYmaj5AAABNElEQVR4Xt3SMZKEIBAFUEjkCpLI1cZEr6DJCIleARK4GiaQbggJLFUyO/YUe4Eh8lld/bsVlG/nB32/OA40PRfEGjLxcPSM2TQkqX1SH0VbxmGl/pElblqbKglhFeqddxMvLZSSf3PelbMPQ3l+7XcX76mblmnaWho6LJ9jqj2BsmRpjI7VnkA+kcT2WbWk8bFj2dVKqJj1mIZ+uhKg8ukTPWx3TQbFyaGZpTUBSkXhz+iGqxIqG0kTGl1NADJKWWJ0/RJQ+3bK/oHPKwEqh9mhtbxsSPiAU7faKwFKolVvgteNoIybo7JrTYDSj9F1CyKmoWISsKm3B4rjI7BE62RQJnrZk1cllKT7A0fe1ak/JJlFE74m+5Rwm1Cu7gdkotGs/NC6HxDHotxIol9z3vU+X69f/0f3JOKplTAAAAAASUVORK5CYII=" width="100px" content-width="100px" content-height="100px" height="100px"/>
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="2em" font-weight="bold"  text-align="center" margin-bottom="1px">
                        DIGITALNI ZELENI SERTIFIKAT
                        
                        
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1.17em" font-weight="bold" color="gray" text-align="center" margin-top="1px">
                        Potvrda o izvrsenoj vakcinaciji protiv COVID-19 i rezultatima testiranja                        
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="2em" font-weight="bold"  text-align="center" margin-bottom="1px">
                        DIGITAL GREEN CERTIFICATE
                        
                        
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1.17em" font-weight="bold" color="gray" text-align="center" margin-top="1px">
                        Certificate of vaccination against COVID-19 and test results
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1em" padding="5px" margin-top="6px" margin-bottom="10px">
                        Broj sertifikata/Certificate ID: POPUNI
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1em" padding="5px" margin-top="6px">
                        Datum i vreme izdavanja sertifikata/Certificate issuing date and time: 2000-01-01T23:33:33
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1em" padding="5px" margin-top="6px">
                        Ime i prezime/Name and surname: POPUNI
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1em" padding="5px" margin-top="6px">
                        Pol/Gener: POPUNI
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1em" padding="5px" margin-top="6px">
                        Datum rodjenja/Date of birth: POPUNI
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1em" padding="5px" margin-top="6px">
                        JMBG/Personal No./EBS: POPUNI
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1em" padding="5px" margin-top="6px">
                        Broj pasosa/Passport No.: POPUNI
                    </fo:block>
                    <fo:block font-family="sans-serif" font-weight="bold" font-size="1em" text-align="center" border-top="2px solid black" padding="5px" margin-top="6px">
                        Vakcinacija/Vaccination
                        
                    </fo:block>
                    <fo:table>
                        <fo:table-column border-right="2px solid black"/>
                        <fo:table-column border-left="2px solid black"/>
              
                        <fo:table-body>
                            <fo:table-row>
                                <fo:table-cell 
                                     ><fo:block font-weight="bold" text-align="center">Doza/Dose: 1/2</fo:block></fo:table-cell>
                                <fo:table-cell 
                                      text-align="center"><fo:block font-weight="bold">Doza/Dose: 1/2</fo:block></fo:table-cell>
                            
                            </fo:table-row>
                            <fo:table-row>
                                <fo:table-cell 
                                     ><fo:block font-weight="bold" text-align="center">Tip/Type:</fo:block></fo:table-cell>
                                <fo:table-cell 
                                      text-align="center"><fo:block font-weight="bold">Tip/Type:</fo:block></fo:table-cell>
                                
                            </fo:table-row>
                            <fo:table-row>
                                <fo:table-cell margin-top="6px" margin-bottom="10px"
                                     ><fo:block text-align="center">POPUNI</fo:block></fo:table-cell>
                                <fo:table-cell 
                                      text-align="center"><fo:block>POPUNI</fo:block></fo:table-cell>
                                
                            </fo:table-row>
                            <fo:table-row>
                                <fo:table-cell 
                                     ><fo:block text-align="center"><fo:inline font-weight="bold">Datum/Date:</fo:inline>POPUNI</fo:block></fo:table-cell>
                                <fo:table-cell 
                                      text-align="center"><fo:block ><fo:inline font-weight="bold">Datum/Date:</fo:inline>POPUNI</fo:block></fo:table-cell>
                                
                            </fo:table-row>
                            <fo:table-row>
                                <fo:table-cell 
                                     ><fo:block font-weight="bold" text-align="center">Zdravstvena ustanova/Health care institution:</fo:block></fo:table-cell>
                                <fo:table-cell 
                                      text-align="center"><fo:block font-weight="bold">Zdravstvena ustanova/Health care institution:</fo:block></fo:table-cell>
                                
                            </fo:table-row>
                            <fo:table-row>
                                <fo:table-cell 
                                     ><fo:block text-align="center">POPUNI</fo:block></fo:table-cell>
                                <fo:table-cell 
                                      text-align="center"><fo:block >OUGA BOUGA121DSADAD21</fo:block></fo:table-cell>
                                
                            </fo:table-row>
                        </fo:table-body>
                        
                    </fo:table>
                    <fo:block text-align-last="justify" font-weight="bold" font-size="10px" margin-top="5px">
                        
                        
                        <fo:leader leader-pattern="space" />
                        Digitalni potpis/Digitally signed by:
                        
                        
                    </fo:block>
                    <fo:table margin-top="5px">
                        <fo:table-column column-width="20%"/>
                        <fo:table-column column-width="30%"/>
                        <fo:table-column column-width="20%"/>
                        <fo:table-column column-width="30%"/>
                        <fo:table-body >
                            <fo:table-row>
                                <fo:table-cell 
                                    padding="3px"><fo:block text-align="left"><fo:external-graphic src="https://data.gov.rs/s/avatars/2e/7864606e35474b98eb147395fecb72-100.png" width="100px" content-width="100px" content-height="100px" height="100px"/></fo:block></fo:table-cell>
                                <fo:table-cell 
                                    padding="3px" font-size="10px"><fo:block text-align="left" margin-top="8px" font-weight="bold">Sertifikat izdaje</fo:block>
                                    <fo:block text-align="left">Institut za javno zdravlje Srbije
                                    </fo:block>
                                    <fo:block text-align="left">"Dr Milan Jovanovic Batut"
                                    </fo:block>
                                    <fo:block text-align="left" font-weight="bold">Certificate issued by:
                                    </fo:block>
                                    <fo:block text-align="left">Institute of Public Health of Serbia
                                        
                                    </fo:block>
                                    <fo:block text-align="left">
                                        "Dr Milan Jovanovic Batut"
                                        
                                    </fo:block></fo:table-cell>
                                <fo:table-cell 
                                    padding="3px" text-align="right"><fo:block><fo:external-graphic src="https://upload.wikimedia.org/wikipedia/commons/thumb/0/0f/Coat_of_arms_of_Serbia_small.svg/150px-Coat_of_arms_of_Serbia_small.svg.png" width="100px" content-width="100px" content-height="100px" height="100px"/>
                                
                                    </fo:block></fo:table-cell>
                                <fo:table-cell 
                                    padding="3px" font-size="10px">
                                    <fo:block text-align="left">REPUBLIKA SRBIJA
                                    </fo:block>
                                    <fo:block text-align="left">Vlada Republike Srbije
                                    </fo:block>
                                    <fo:block text-align="left">Kancelarija za informacione
                                    </fo:block>
                                    <fo:block text-align="left">tehnologije i elektronsku upravu
                                        
                                    </fo:block>
                                    <fo:block text-align="left">
                                        Nemanjina 11, BEOGRAD
                                        
                                    </fo:block>
                                    <fo:block text-align="left">
                                        Datum: DODAJ
                                        
                                    </fo:block></fo:table-cell>
                            </fo:table-row>
                        </fo:table-body>
                    </fo:table>
                    
                    
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>