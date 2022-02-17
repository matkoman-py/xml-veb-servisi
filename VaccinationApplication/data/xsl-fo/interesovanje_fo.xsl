<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:i="http://www.ftn.uns.ac.rs/interesovanje"
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
                    <fo:block font-family="sans-serif" font-size="2em" font-weight="bold" padding="7px" text-align="center">
                        Iskazivanje interesovanja za vakcinisanje protiv COVID-19
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1em" padding="7px">
                        Odaberite opciju:
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1em" padding="7px" text-indent="24mm">
                        <xsl:value-of select="i:interesovanje/i:Podaci_o_primaocu/i:Drzavljanstvo"/>
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1em" padding="7px">
                        <fo:inline>
                            JMBG:
                        </fo:inline> 
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1em" padding="7px">
                        <fo:inline border-bottom-style="dotted">
                            <xsl:value-of select="i:interesovanje/i:Podaci_o_primaocu/i:JMBG"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1em" padding="7px">
                        <fo:inline>
                            Ime:
                        </fo:inline> 
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1em" padding="7px">
                        <fo:inline border-bottom-style="dotted">
                            <xsl:value-of select="i:interesovanje/i:Podaci_o_primaocu/i:Ime"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1em" padding="7px">
                        <fo:inline>
                            Prezime:
                        </fo:inline> 
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1em" padding="7px">
                        <fo:inline border-bottom-style="dotted">
                            <xsl:value-of select="i:interesovanje/i:Podaci_o_primaocu/i:Prezime"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1em" padding="7px">
                        <fo:inline>
                            Adresa elektronske poste:
                        </fo:inline> 
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1em" padding="7px">
                        <fo:inline border-bottom-style="dotted">
                            <xsl:value-of select="i:interesovanje/i:Podaci_o_primaocu/i:Kontakt/i:Adresa_elektronske_poste"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1em" padding="7px">
                        <fo:inline>
                            Broj mobilnog telefona (navesti broj u formatu 06X... bez razmaka i crtica):
                            
                            
                        </fo:inline> 
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1em" padding="7px">
                        <fo:inline border-bottom-style="dotted">
                            <xsl:value-of select="i:interesovanje/i:Podaci_o_primaocu/i:Kontakt/i:Broj_mobilnog_telefona"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1em" padding="7px">
                        <fo:inline>
                            Broj fiksnog telefona (navesti broj u formatu npr. 011... bez razmaka i crtica):
                        </fo:inline> 
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1em" padding="7px">
                        <fo:inline border-bottom-style="dotted">
                            <xsl:value-of select="i:interesovanje/i:Podaci_o_primaocu/i:Kontakt/i:Broj_fiksnog_telefona"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1em" padding="7px">
                        <fo:inline>
                            Odaberite lokaciju gde zelite da primite vakcinu (unesite opstinu):
                        </fo:inline> 
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1em" padding="7px">
                        <fo:inline border-bottom-style="dotted">
                            OVDE FALI!
                        </fo:inline>
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1em" padding="7px">
                        Iskazujem interesovanje da primim iskljucivo vakcinu sledecih proizvodjaca za koji Agencija za lekove i medicinska sredstva potvrdi bezbednost, efikasnost i kvalitet i izda dozvolu za upotrebu leka:
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1em" padding="7px" text-indent="24mm">
                        <xsl:value-of select="i:interesovanje/i:Odabir_vakcine"/>
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1em" padding="7px">
                        Da li ste dobrovoljni davalac krvi?
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="1em" padding="7px" text-indent="24mm">
                        <xsl:value-of select="i:interesovanje/i:Podaci_o_primaocu/i:Davalac_krvi"/>
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>