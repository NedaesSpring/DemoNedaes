<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.1"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
                xmlns:fo="http://www.w3.org/1999/XSL/Format"
                exclude-result-prefixes="fo">
    
    <xsl:template match="informe">
        
        <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
            <fo:layout-master-set>
                <fo:simple-page-master master-name="simpleA4" page-height="29.7cm" page-width="21cm" margin-top="2cm" margin-bottom="2cm" margin-left="1.5cm" margin-right="1.5cm">
                    <fo:region-body/>
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-reference="simpleA4">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block> 
                      <fo:table table-layout="fixed" width="100%" border-style="none">    
                   		<fo:table-column column-width="9cm" border-width="1px" border-style="none"/>
                   		<fo:table-column column-width="9cm" border-width="1px" border-style="none"/>
                  		<fo:table-body font-size="8pt" font-family="sans-serif">
                          <fo:table-cell>
                          <fo:block>
                			<fo:external-graphic height="auto" width="auto" content-height="auto"
								content-width="auto" src="url(src/main/resources/static/img/logoInformes.jpg)">
              				</fo:external-graphic>
              				</fo:block>
                    	  </fo:table-cell>   
            			  <fo:table-cell text-align="right">
            				<fo:block>
            				 <fo:external-graphic height="auto" width="auto" content-height="auto"
								content-width="auto" src="url(src/main/resources/static/img/logoInformes2.jpg)">								
              				</fo:external-graphic>
              				</fo:block>        					            
				          </fo:table-cell>
				        </fo:table-body>                               
        			  </fo:table>
                    </fo:block>
                     
                    <fo:block font-size="16pt" font-weight="bold" space-after="5mm"><xsl:value-of select="titulo1"/>
                    </fo:block>

					<fo:block font-size="12pt">
                        <fo:table table-layout="fixed" width="100%" border-style="solid">    
                    		<fo:table-column column-width="9cm" border-width="1px" border-style="solid"/>
                            <fo:table-column column-width="9cm" border-width="1px" border-style="solid"/>
                            <fo:table-header font-weight="bold" font-size="6pt">
                                <xsl:apply-templates select="headcuadro1"/>
                            </fo:table-header>
                            <fo:table-body font-size="8pt" font-family="sans-serif">
                                <xsl:apply-templates select="cuadro1"/>
                            </fo:table-body>           
                        </fo:table>
                    </fo:block>
                    
                    <fo:block font-size="12pt">
                        <fo:table table-layout="fixed" width="100%" border-style="solid">    
                            <fo:table-column column-width="9cm" border-width="1px" border-style="solid"/>
                            <fo:table-column column-width="4.5cm" border-width="1px" border-style="solid"/>
                            <fo:table-column column-width="4.5cm" border-width="1px" border-style="solid"/>
                            <fo:table-header font-weight="bold" font-size="6pt">
                                <xsl:apply-templates select="headcuadro2"/>
                            </fo:table-header>
                            <fo:table-body  font-size="8pt" font-family="sans-serif">
                                <xsl:apply-templates select="cuadro2"/>
                            </fo:table-body>
                        </fo:table>
                    </fo:block>
                    
                    <fo:block font-size="12pt">
                        <fo:table table-layout="fixed" width="100%" border-style="solid">    
                            <fo:table-column column-width="9cm" border-width="1px" border-style="solid"/>
                            <fo:table-column column-width="4.5cm" border-width="1px" border-style="solid"/>
                            <fo:table-column column-width="4.5cm" border-width="1px" border-style="solid"/>
                            <fo:table-header font-weight="bold" font-size="6pt">
                                <xsl:apply-templates select="headcuadro3"/>
                            </fo:table-header>
                            <fo:table-body  font-size="8pt" font-family="sans-serif">
                                <xsl:apply-templates select="cuadro3"/>
                            </fo:table-body>
                        </fo:table>
                    </fo:block>

                    <fo:block font-size="12pt">
                        <fo:table table-layout="fixed" width="100%" border-style="solid">    
                            <fo:table-column column-width="6cm" border-width="1px" border-style="solid"/>
                            <fo:table-column column-width="6cm" border-width="1px" border-style="solid"/>
                            <fo:table-column column-width="6cm" border-width="1px" border-style="solid"/>
                            <fo:table-header font-weight="bold" font-size="6pt">
                                <xsl:apply-templates select="headcuadro4"/>
                            </fo:table-header>
                            <fo:table-body  font-size="8pt" font-family="sans-serif">
                                <xsl:apply-templates select="cuadro4"/>
                            </fo:table-body>
                        </fo:table>
                    </fo:block>
						
                    <fo:block font-size="15pt" font-weight="bold" space-after="15mm"><br/><br/>               </fo:block>
                    
                    <fo:block font-size="16pt" font-weight="bold" space-after="3mm" text-align="center"><xsl:value-of select="titulo2"/>
                    </fo:block>
                    <fo:block font-size="6pt" space-after="1mm" >1. Que el trabajador que a continuación se indica, ha prestado servicios en esta Empresa.
                    </fo:block>
                    <fo:block font-size="12pt">
                        <fo:table table-layout="fixed" width="100%" border-style="solid">    
                            <fo:table-column column-width="9cm" border-width="1px" border-style="solid"/>
                            <fo:table-column column-width="4.5cm" border-width="1px" border-style="solid"/>
                            <fo:table-column column-width="4.5cm" border-width="1px" border-style="solid"/>
                            <fo:table-header font-weight="bold" font-size="6pt">
                                <xsl:apply-templates select="headcuadro5"/>
                            </fo:table-header>
                            <fo:table-body  font-size="8pt" font-family="sans-serif">
                                <xsl:apply-templates select="cuadro5"/>
                            </fo:table-body>
                        </fo:table>
                    </fo:block>
                    
                    <fo:block font-size="12pt">
                        <fo:table table-layout="fixed" width="100%" border-style="solid">    
                            <fo:table-column column-width="9cm" border-width="1px" border-style="solid"/>
                            <fo:table-column column-width="4.5cm" border-width="1px" border-style="solid"/>
                            <fo:table-column column-width="4.5cm" border-width="1px" border-style="solid"/>
                             <fo:table-header font-weight="bold" font-size="6pt">
                                <xsl:apply-templates select="headcuadro6"/>
                            </fo:table-header>
                            <fo:table-body  font-size="8pt" font-family="sans-serif">
                                <xsl:apply-templates select="cuadro6"/>
                            </fo:table-body>
                        </fo:table>
                    </fo:block>
                    
                    <fo:block font-size="12pt">
                        <fo:table table-layout="fixed" width="100%" border-style="solid">    
                            <fo:table-column column-width="9cm" border-width="1px" border-style="solid"/>
                            <fo:table-column column-width="2.25cm" border-width="1px" border-style="solid"/>
                            <fo:table-column column-width="2.25cm" border-width="1px" border-style="solid"/>
                            <fo:table-column column-width="4.5cm" border-width="1px" border-style="solid"/>
                            <fo:table-header font-weight="bold" font-size="6pt">
                                <xsl:apply-templates select="headcuadro7"/>
                            </fo:table-header>
                            <fo:table-body  font-size="8pt" font-family="sans-serif">
                                <xsl:apply-templates select="cuadro7"/>
                            </fo:table-body>
                        </fo:table>
                    </fo:block>
                    <fo:block font-size="12pt">
                        <fo:table table-layout="fixed" width="100%" border-style="solid">    
                            <fo:table-column column-width="6cm" border-width="1px" border-style="solid"/>
                            <fo:table-column column-width="12cm" border-width="1px" border-style="solid"/>
                            <fo:table-header font-weight="bold" font-size="6pt">
                                <xsl:apply-templates select="headcuadro8"/>
                            </fo:table-header>
                            <fo:table-body  font-size="8pt" font-family="sans-serif">
                                <xsl:apply-templates select="cuadro8"/>
                            </fo:table-body>
                        </fo:table>
                    </fo:block>
                    <fo:block font-size="5pt" font-weight="bold" space-after="5mm"><br/><br/>               </fo:block>
                    
                    <fo:block font-size="6pt" space-after="1mm" >2. Que actualmente se encuentra en la siguiente situación:
                    </fo:block>
                    
                    <fo:block font-size="12pt">
                        <fo:table table-layout="fixed" width="100%" border-style="solid">    
                            <fo:table-column column-width="4cm" border-width="1px" border-style="none"/>
                            <fo:table-column column-width="0.5cm" border-width="1px" border-style="none"/>
                            <fo:table-column column-width="0.5cm" border-width="1px" border-style="none"/>
                            <fo:table-column column-width="0.5cm" border-width="1px" border-style="none"/>
                            <fo:table-column column-width="0.5cm" border-width="1px" border-style="none"/>
                            <fo:table-column column-width="6cm" border-width="1px" border-style="solid"/>
                            <fo:table-column column-width="6cm" border-width="1px" border-style="solid"/>
                            <fo:table-header font-weight="bold" font-size="6pt">
                                <xsl:apply-templates select="headcuadro9"/>
                            </fo:table-header>
                            <fo:table-body  font-size="8pt" font-family="sans-serif">
                                <xsl:apply-templates select="cuadro9"/>
                            </fo:table-body>
                        </fo:table>
                    </fo:block>
                    
                    <fo:block font-size="3pt" font-weight="bold" space-after="3mm"><br/><br/>               </fo:block>
                    
                    <fo:block font-size="6pt" space-after="1mm" >3. Que los servicios han sido prestados en los siguientes períodos:
                    </fo:block>
                    
                    <!-- ************************* Fechas dinamicas -->
                      
                    <fo:block font-size="12pt">
                        <fo:table table-layout="fixed" width="100%" border-style="solid">    
                            <fo:table-column column-width="9cm" border-width="1px" border-style="solid"/>
                            <fo:table-column column-width="9cm" border-width="1px" border-style="solid"/>
                            <fo:table-body  font-size="8pt" font-family="sans-serif">
                            <fo:table-cell>
                      			<fo:block font-size="12pt">

                        			<fo:table table-layout="fixed" width="100%" border-style="solid">    
                            			<fo:table-column column-width="1.4cm" border-width="1px" border-style="none"/>
                      	     			<fo:table-column column-width="0.3cm" border-width="1px" border-style="none"/>
                        			    <fo:table-column column-width="0.7cm" border-width="1px" border-style="none"/>
                            			<fo:table-column column-width="0.3cm" border-width="1px" border-style="none"/>
                            			<fo:table-column column-width="0.7cm" border-width="1px" border-style="none"/>
                            			<fo:table-column column-width="0.8cm" border-width="1px" border-style="none"/>
                            			<fo:table-column column-width="2.1cm" border-width="1px" border-style="none"/>
                            			<fo:table-column column-width="0.3cm" border-width="1px" border-style="none"/>
                            			<fo:table-column column-width="0.7cm" border-width="1px" border-style="none"/>
                            			<fo:table-column column-width="0.3cm" border-width="1px" border-style="none"/>
                            			<fo:table-column column-width="0.7cm" border-width="1px" border-style="none"/>
                           			 	<fo:table-column column-width="0.7cm" border-width="1px" border-style="none"/> 
                            			<fo:table-body  font-size="8pt" font-family="sans-serif">
                                			<xsl:apply-templates select="cuadro10"/>
                            			</fo:table-body>
                       			</fo:table>
                       		
                    		</fo:block>
                     	</fo:table-cell>
            		 	<fo:table-cell>
                      			<fo:block font-size="12pt">
                        			<fo:table table-layout="fixed" width="100%" border-style="solid">    
                             			<fo:table-column column-width="1.4cm" border-width="1px" border-style="none"/>
                      	     			<fo:table-column column-width="0.3cm" border-width="1px" border-style="none"/>
                        			    <fo:table-column column-width="0.7cm" border-width="1px" border-style="none"/>
                            			<fo:table-column column-width="0.3cm" border-width="1px" border-style="none"/>
                            			<fo:table-column column-width="0.7cm" border-width="1px" border-style="none"/>
                            			<fo:table-column column-width="0.8cm" border-width="1px" border-style="none"/>
                            			<fo:table-column column-width="2.1cm" border-width="1px" border-style="none"/>
                            			<fo:table-column column-width="0.3cm" border-width="1px" border-style="none"/>
                            			<fo:table-column column-width="0.7cm" border-width="1px" border-style="none"/>
                            			<fo:table-column column-width="0.3cm" border-width="1px" border-style="none"/>
                            			<fo:table-column column-width="0.7cm" border-width="1px" border-style="none"/>
                           			 	<fo:table-column column-width="0.7cm" border-width="1px" border-style="none"/> 
                            			<fo:table-body  font-size="8pt" font-family="sans-serif">
                                			<xsl:apply-templates select="cuadro11"/>
                            			</fo:table-body>
                       			</fo:table>
                    		</fo:block>
                     	</fo:table-cell>
                    </fo:table-body>
                        </fo:table>
                    </fo:block>
                    
                        
                    <fo:block font-size="3pt" font-weight="bold" space-after="3mm"><br/><br/>               </fo:block>
                    
                    <fo:block font-size="6pt" space-after="1mm" >4. Que en el período que a continuación se detalla cotizó a la Seguridad Social, por las bases que se señalan(*)
                    </fo:block>
                     
                    <fo:block font-size="12pt">
                       <fo:table table-layout="fixed" width="100%" border-style="solid">    
                   		<fo:table-column column-width="8.95cm" border-width="1px" border-style="none"/>
                   		<fo:table-column column-width="0.1cm" border-width="3px" border-style="none"/>
                   		<fo:table-column column-width="8.95cm" border-width="1px" border-style="none"/>
                  		<fo:table-body font-size="8pt" font-family="sans-serif">
                          <fo:table-cell>
                        	<fo:block font-size="12pt">
                        		<fo:table table-layout="fixed" width="100%" border-style="solid">    
                            		<fo:table-column column-width="1.95cm" border-width="1px" border-style="solid"/>
                            		<fo:table-column column-width="1cm" border-width="1px" border-style="solid"/>
                            		<fo:table-column column-width="1cm" border-width="1px" border-style="solid"/>
                            		<fo:table-column column-width="5cm" border-width="1px" border-style="solid"/>
                            		<fo:table-header font-weight="bold" font-size="6pt" border-style="solid">
                                		<xsl:apply-templates select="headcuadro12"/>
                            		</fo:table-header>
                            		<fo:table-body  font-size="8pt" font-family="sans-serif">
                                		<xsl:apply-templates select="cuadro12"/>
                            		</fo:table-body>
                        		</fo:table>
                    		</fo:block>
                    	  </fo:table-cell>
                    	  <fo:table-cell>
                        	<fo:block font-size="2pt"></fo:block>
                    	  </fo:table-cell>   
            			  <fo:table-cell text-align="left">
            				<fo:block font-size="12pt">
                        		<fo:table table-layout="fixed" width="100%" border-style="solid">    
                            		<fo:table-column column-width="1.95cm" border-width="1px" border-style="solid"/>
                            		<fo:table-column column-width="1cm" border-width="1px" border-style="solid"/>
                            		<fo:table-column column-width="1cm" border-width="1px" border-style="solid"/>
                            		<fo:table-column column-width="5cm" border-width="1px" border-style="solid"/>
                            		<fo:table-header font-weight="bold" font-size="6pt" border-style="solid">
                                		<xsl:apply-templates select="headcuadro13"/>
                            		</fo:table-header>
                            		<fo:table-body  font-size="8pt" font-family="sans-serif">
                                		<xsl:apply-templates select="cuadro13"/>
                            		</fo:table-body>
                        		</fo:table>
                    		</fo:block>        					            
				          </fo:table-cell>
				        </fo:table-body>                               
        			  </fo:table>
                    </fo:block>
                    
                    <fo:block font-size="3pt" font-weight="bold" space-after="3mm"><br/><br/>               </fo:block>
                    
                    <fo:block font-size="6pt" space-after="1mm" >5. Que existen los períodos de vacaciones anuales retribuidas y no disfrutadas que a continuación se indican
                    </fo:block>
                    <fo:block font-size="12pt">
                        <fo:table table-layout="fixed" width="100%" border-style="solid">    
                            <fo:table-column column-width="9cm" border-width="1px" border-style="solid"/>
                            <fo:table-column column-width="9cm" border-width="1px" border-style="solid"/>
                            <fo:table-body  font-size="8pt" font-family="sans-serif">
                            <fo:table-cell>
                      			<fo:block font-size="12pt">
                        			<fo:table table-layout="fixed" width="100%" border-style="solid">    
                            			<fo:table-column column-width="1.4cm" border-width="1px" border-style="none"/>
                      	     			<fo:table-column column-width="0.3cm" border-width="1px" border-style="none"/>
                        			    <fo:table-column column-width="0.7cm" border-width="1px" border-style="none"/>
                            			<fo:table-column column-width="0.3cm" border-width="1px" border-style="none"/>
                            			<fo:table-column column-width="0.7cm" border-width="1px" border-style="none"/>
                            			<fo:table-column column-width="0.8cm" border-width="1px" border-style="none"/>
                            			<fo:table-column column-width="2.1cm" border-width="1px" border-style="none"/>
                            			<fo:table-column column-width="0.3cm" border-width="1px" border-style="none"/>
                            			<fo:table-column column-width="0.7cm" border-width="1px" border-style="none"/>
                            			<fo:table-column column-width="0.3cm" border-width="1px" border-style="none"/>
                            			<fo:table-column column-width="0.7cm" border-width="1px" border-style="none"/>
                           			 	<fo:table-column column-width="0.7cm" border-width="1px" border-style="none"/> 
                            			<fo:table-body  font-size="8pt" font-family="sans-serif">
                                			<xsl:apply-templates select="cuadro14"/>
                            			</fo:table-body>
                       			</fo:table>
                    		</fo:block>
                     	</fo:table-cell>
            		 	<fo:table-cell>
                      			<fo:block font-size="12pt">
                        			<fo:table table-layout="fixed" width="100%" border-style="solid">    
                            <fo:table-column column-width="3cm" border-width="1px" border-style="none"/>
                            <fo:table-column column-width="6cm" border-width="1px" border-style="none"/>
                            <fo:table-body  font-size="8pt" font-family="sans-serif">
                                <xsl:apply-templates select="cuadro15"/>
                            </fo:table-body>
                        </fo:table>
                    		</fo:block>
                     	</fo:table-cell>
                    </fo:table-body>
                        </fo:table>
                    </fo:block>
                      
                     
                    <fo:block font-size="3pt" font-weight="bold" space-after="3mm"><br/><br/>               </fo:block>
                    
                     <fo:block font-size="6pt" space-after="1mm" > Y para que conste ante la Dirección Provincial del Instituto Nacional de la Seguridad Social, firma la presente certificación, en
                    </fo:block>
                    
                    <fo:block font-size="12pt">
                        <fo:table table-layout="fixed" width="100%" border-style="none">    
                            <fo:table-column column-width="5cm" border-width="1px" border-style="none"/>
                            <fo:table-column column-width="1cm" border-width="1px" border-style="none"/>
                            <fo:table-column column-width="4cm" border-width="1px" border-style="none"/>
                            <fo:table-column column-width="1cm" border-width="1px" border-style="none"/>
                            <fo:table-column column-width="3cm" border-width="1px" border-style="none"/>
                            <fo:table-column column-width="1cm" border-width="1px" border-style="none"/>
                            <fo:table-column column-width="2cm" border-width="1px" border-style="none"/>
                            <fo:table-body  font-size="8pt" font-family="sans-serif">
                                <xsl:apply-templates select="cuadro16"/>
                            </fo:table-body>
                        </fo:table>
                    </fo:block>
                    
                    <fo:block font-size="4pt" space-after="1mm" text-align="center" >(Firma y sello de la Empresa)</fo:block>
 					<fo:block font-size="20pt" font-weight="bold" space-after="20mm"><br/><br/>               </fo:block>
                    <fo:block font-size="4pt" space-after="0mm" >La certificación deberá expedirse:</fo:block>
 					<fo:block font-size="4pt" space-after="0mm" >- A petición de una Entidad Gestora o Servicio Común de la Seguridad Social.</fo:block>
 					<fo:block font-size="4pt" space-after="0mm" >- A petición de un trabajador que preste o haya prestado servicios en la Empresa o a solicitud de sus derecho habientes.</fo:block>
 					<fo:block font-size="4pt" space-after="0mm" >(*) Las bases de cotización que han de certificarse serán, como máximo, de 6 mensualidades sucesivas que deberán coincidir siempre con las que figuren en la relaciones nominales (modelo TC-2) referidas a iguales meses.</fo:block>
 					<fo:block font-size="4pt" space-after="0mm" >Las empresas que tramiten la cotización por vías telemáticas mediante el sistema RED desde hace más de 6 meses, no necesitan certificar las bases anteriores a los 3 últimos meses.</fo:block>
 					<fo:block font-size="4pt" space-after="0mm" >NEDAES</fo:block>
                    
                    
                    
                </fo:flow>

            </fo:page-sequence>
        </fo:root>
    </xsl:template>
    
   <xsl:template match="headcuadro1">
        <fo:table-row keep-together.within-page="always" border-style="none" >   
            <fo:table-cell padding="2pt 3pt 2pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo1"/>
                </fo:block>
            </fo:table-cell>   
            <fo:table-cell padding="2pt 3pt 2pt 3pt">
                <fo:block >
                    <xsl:value-of select="campo2"/>
                </fo:block>
            </fo:table-cell>   
        </fo:table-row>
    </xsl:template>
    
     <xsl:template match="cuadro1">
        <fo:table-row keep-together.within-page="always" border-style="none">
<!--                 For showing row lines -->
<!--    <fo:table-row keep-together.within-page="always" border-style="solid"> -->
            <fo:table-cell padding="3pt 3pt 0pt 3pt">
                <fo:block>
                   <xsl:value-of select="campo1"></xsl:value-of>
                </fo:block>
            </fo:table-cell>
            <fo:table-cell padding="3pt 3pt 0pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo2"/>
                </fo:block>
            </fo:table-cell>   
        </fo:table-row>
    </xsl:template>
 
    
    <xsl:template match="headcuadro2">
        <fo:table-row  border-style="none">   
            <xsl:if test="puesto = 'Gerente'">
                <xsl:attribute name="font-weight">bold</xsl:attribute>
            </xsl:if>
            <fo:table-cell padding="2pt 3pt 2pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo1"/>
                </fo:block>
            </fo:table-cell>     
            <fo:table-cell padding="2pt 3pt 2pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo2"/>
                </fo:block>
            </fo:table-cell>   
            <fo:table-cell padding="2pt 3pt 2pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo3"/>
                </fo:block>
            </fo:table-cell>
        </fo:table-row>
    </xsl:template>
    
   <xsl:template match="headcuadro3">
        <fo:table-row border-style="none">   
            <fo:table-cell padding="2pt 3pt 2pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo1"/>
                </fo:block>
            </fo:table-cell>     
            <fo:table-cell padding="2pt 3pt 2pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo2"/>
                </fo:block>
            </fo:table-cell>   
            <fo:table-cell padding="2pt 3pt 2pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo3"/>
                </fo:block>
            </fo:table-cell>
        </fo:table-row>
    </xsl:template>

    <xsl:template match="headcuadro4">
        <fo:table-row border-style="none">   
            <fo:table-cell padding="2pt 3pt 2pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo1"/>
                </fo:block>
            </fo:table-cell>  
            <fo:table-cell padding="2pt 3pt 2pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo2"/>
                </fo:block>
            </fo:table-cell>   
            <fo:table-cell padding="2pt 3pt 2pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo3"/>
                </fo:block>
            </fo:table-cell>
        </fo:table-row>
    </xsl:template>
    
      <xsl:template match="headcuadro5">
        <fo:table-row border-style="none">   
            <fo:table-cell padding="2pt 3pt 2pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo1"/>
                </fo:block>
            </fo:table-cell>     
            <fo:table-cell padding="2pt 3pt 2pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo2"/>
                </fo:block>
            </fo:table-cell>   
            <fo:table-cell padding="2pt 3pt 2pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo3"/>
                </fo:block>
            </fo:table-cell>
        </fo:table-row>
    </xsl:template>

    <xsl:template match="headcuadro6">
        <fo:table-row border-style="none">   
            <fo:table-cell padding="2pt 3pt 2pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo1"/>
                </fo:block>
            </fo:table-cell>     
            <fo:table-cell padding="2pt 3pt 2pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo2"/>
                </fo:block>
            </fo:table-cell>   
            <fo:table-cell padding="2pt 3pt 2pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo3"/>
                </fo:block>
            </fo:table-cell>
        </fo:table-row>
    </xsl:template>
    
    <xsl:template match="headcuadro7">
        <fo:table-row border-style="none">   
            <fo:table-cell padding="2pt 3pt 2pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo1"/>
                </fo:block>
            </fo:table-cell>  
            <fo:table-cell padding="2pt 3pt 2pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo2"/>
                </fo:block>
            </fo:table-cell>   
            <fo:table-cell padding="2pt 3pt 2pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo3"/>
                </fo:block>
            </fo:table-cell>
            <fo:table-cell padding="2pt 3pt 2pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo4"/>
                </fo:block>
            </fo:table-cell>
        </fo:table-row>
    </xsl:template>
    
    <xsl:template match="headcuadro8">
        <fo:table-row border-style="none">   
            <fo:table-cell padding="2pt 3pt 2pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo1"/>
                </fo:block>
            </fo:table-cell>   
            <fo:table-cell padding="2pt 3pt 2pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo2"/>
                </fo:block>
            </fo:table-cell>   
        </fo:table-row>
    </xsl:template>
    
  
    <xsl:template match="cuadro2">
        <fo:table-row border-style="none">   
            <fo:table-cell padding="3pt 3pt 0pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo1"/>
                </fo:block>
            </fo:table-cell>     
            <fo:table-cell padding="3pt 3pt 0pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo2"/>
                </fo:block>
            </fo:table-cell>   
            <fo:table-cell padding="3pt 3pt 0pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo3"/>
                </fo:block>
            </fo:table-cell>
        </fo:table-row>
    </xsl:template>
    <xsl:template match="cuadro3">
        <fo:table-row border-style="none">   
            <fo:table-cell padding="3pt 3pt 0pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo1"/>
                </fo:block>
            </fo:table-cell>     
            <fo:table-cell padding="3pt 3pt 0pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo2"/>
                </fo:block>
            </fo:table-cell>   
            <fo:table-cell padding="3pt 3pt 0pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo3"/>
                </fo:block>
            </fo:table-cell>
        </fo:table-row>
    </xsl:template>
    <xsl:template match="cuadro4">
        <fo:table-row border-style="none">   
            <fo:table-cell padding="3pt 3pt 0pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo1"/>
                </fo:block>
            </fo:table-cell>  
            <fo:table-cell padding="3pt 3pt 0pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo2"/>
                </fo:block>
            </fo:table-cell>   
            <fo:table-cell padding="3pt 3pt 0pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo3"/>
                </fo:block>
            </fo:table-cell>
        </fo:table-row>
    </xsl:template>

    <xsl:template match="cuadro5">
        <fo:table-row border-style="none">   
            <fo:table-cell padding="3pt 3pt 0pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo1"/>
                </fo:block>
            </fo:table-cell>     
            <fo:table-cell padding="3pt 3pt 0pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo2"/>
                </fo:block>
            </fo:table-cell>   
            <fo:table-cell padding="3pt 3pt 0pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo3"/>
                </fo:block>
            </fo:table-cell>
        </fo:table-row>
    </xsl:template>
    
    <xsl:template match="cuadro6">
        <fo:table-row border-style="none">   
            <fo:table-cell padding="3pt 3pt 0pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo1"/>
                </fo:block>
            </fo:table-cell>     
            <fo:table-cell padding="3pt 3pt 0pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo2"/>
                </fo:block>
            </fo:table-cell>   
            <fo:table-cell padding="3pt 3pt 0pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo3"/>
                </fo:block>
            </fo:table-cell>
        </fo:table-row>
    </xsl:template>
 
   <xsl:template match="cuadro7">
        <fo:table-row border-style="none">   
            <fo:table-cell padding="3pt 3pt 0pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo1"/>
                </fo:block>
            </fo:table-cell>  
            <fo:table-cell padding="3pt 3pt 0pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo2"/>
                </fo:block>
            </fo:table-cell>   
            <fo:table-cell padding="3pt 3pt 0pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo3"/>
                </fo:block>
            </fo:table-cell>
            <fo:table-cell padding="3pt 3pt 0pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo4"/>
                </fo:block>
            </fo:table-cell>
        </fo:table-row>
    </xsl:template>
    
    <xsl:template match="cuadro8">
        <fo:table-row border-style="none">   
            <fo:table-cell padding="3pt 3pt 0pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo1"/>
                </fo:block>
            </fo:table-cell>   
            <fo:table-cell padding="3pt 3pt 0pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo2"/>
                </fo:block>
            </fo:table-cell>   
        </fo:table-row>
    </xsl:template>
    
    <xsl:template match="headcuadro9">
        <fo:table-row border-style="none">   
            <fo:table-cell padding="2pt 3pt 2pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo1"/>
                </fo:block>
            </fo:table-cell>     
            <fo:table-cell padding="2pt 0pt 2pt 0pt">
                <fo:block>
                    <xsl:value-of select="campo2"/>
                </fo:block>
           </fo:table-cell>     
           <fo:table-cell padding="2pt 0pt 2pt 0pt">
                <fo:block>
                    <xsl:value-of select="campo3"/>
                </fo:block>
            </fo:table-cell>   
            <fo:table-cell padding="2pt 0pt 2pt 0pt">
                <fo:block>
                    <xsl:value-of select="campo4"/>
                </fo:block>
            </fo:table-cell>
            <fo:table-cell padding="2pt 0pt 2pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo5"/>
                </fo:block>
            </fo:table-cell>     
            <fo:table-cell padding="2pt 3pt 2pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo6"/>
                </fo:block>
            </fo:table-cell>     
            <fo:table-cell padding="2pt 3pt 2pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo7"/>
                </fo:block>
            </fo:table-cell>     
            
        </fo:table-row>
    </xsl:template>
    
    <xsl:template match="cuadro9">
    
    
	    <fo:table-row border-style="none">   
            <fo:table-cell padding="3pt 3pt 0pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo1"/>
                </fo:block>
            </fo:table-cell>     
            <fo:table-cell padding="3pt 3pt 0pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo2"/>
                </fo:block>
            </fo:table-cell>
            <fo:table-cell padding="0pt 3pt 2pt 3pt">
            	<fo:block font-size="10pt" border-style="solid" color="#ffffff">
                    <xsl:value-of select="campo3"/>
                </fo:block>
            </fo:table-cell>
            
            <fo:table-cell padding="3pt 0pt 0pt 0pt">
                <fo:block>
                    <xsl:value-of select="campo4"/>
                </fo:block>
            </fo:table-cell>
            
            <fo:table-cell padding="0pt 3pt 2pt 3pt">
            	<fo:block font-size="10pt" border-style="solid">
                    <xsl:value-of select="campo5"/>
                 </fo:block>
            </fo:table-cell>   
               
            <fo:table-cell padding="3pt 3pt 0pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo6"/>
                </fo:block>
            </fo:table-cell>
            <fo:table-cell padding="3pt 3pt 0pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo7"/>
                </fo:block>
            </fo:table-cell>
        </fo:table-row>
    </xsl:template>
      
    <xsl:template match="cuadro10">
	    <fo:table-row border-style="none">   
	        <fo:table-cell padding="3pt 1pt 0pt 3pt" text-align="center"><fo:block>Del dia ...</fo:block></fo:table-cell>     
	        <fo:table-cell padding="3pt 1pt 0pt 1pt" text-align="center">
                <fo:block>
                    <xsl:value-of select="campo1"/>
                </fo:block>
            </fo:table-cell> 
            <fo:table-cell padding="3pt 1pt 0pt 1pt" text-align="center"><fo:block>..de..</fo:block></fo:table-cell>    
            <fo:table-cell padding="3pt 1pt 0pt 1pt" text-align="center">
                <fo:block>
                    <xsl:value-of select="campo2"/>
                </fo:block>
            </fo:table-cell>    
            <fo:table-cell padding="3pt 1pt 0pt 1pt" text-align="center"><fo:block>..de..</fo:block></fo:table-cell>    
            <fo:table-cell padding="3pt 1pt 0pt 1pt" text-align="center">
                <fo:block>
                    <xsl:value-of select="campo3"/>
                </fo:block>
            </fo:table-cell>    
            <fo:table-cell padding="3pt 1pt 0pt 1pt" text-align="center"><fo:block>.......al dia.......</fo:block></fo:table-cell>    
            <fo:table-cell padding="3pt 1pt 0pt 1pt" text-align="center">
                <fo:block>
                    <xsl:value-of select="campo4"/>
                </fo:block>
            </fo:table-cell>    
            <fo:table-cell padding="3pt 1pt 0pt 1pt" text-align="center"><fo:block>..de..</fo:block></fo:table-cell>    
            <fo:table-cell padding="3pt 1pt 0pt 1pt" text-align="center">
                <fo:block>
                    <xsl:value-of select="campo5"/>
                </fo:block>
            </fo:table-cell>    
            <fo:table-cell padding="3pt 1pt 0pt 1pt" text-align="center"><fo:block>..de..</fo:block></fo:table-cell>    
            <fo:table-cell padding="3pt 3pt 0pt 1pt" text-align="center">
                <fo:block>
                    <xsl:value-of select="campo6"/>
                </fo:block>
            </fo:table-cell>      
        </fo:table-row>
    </xsl:template>
    
  
   <xsl:template match="cuadro11">
	    <fo:table-row border-style="none">   
	        <fo:table-cell padding="3pt 1pt 0pt 3pt" text-align="center"><fo:block>Del dia ...</fo:block></fo:table-cell>     
	        <fo:table-cell padding="3pt 1pt 0pt 1pt" text-align="center">
                <fo:block>
                    <xsl:value-of select="campo1"/>
                </fo:block>
            </fo:table-cell> 
            <fo:table-cell padding="3pt 1pt 0pt 1pt" text-align="center"><fo:block>..de..</fo:block></fo:table-cell>    
            <fo:table-cell padding="3pt 1pt 0pt 1pt" text-align="center">
                <fo:block>
                    <xsl:value-of select="campo2"/>
                </fo:block>
            </fo:table-cell>    
            <fo:table-cell padding="3pt 1pt 0pt 1pt" text-align="center"><fo:block>..de..</fo:block></fo:table-cell>    
            <fo:table-cell padding="3pt 1pt 0pt 1pt" text-align="center">
                <fo:block>
                    <xsl:value-of select="campo3"/>
                </fo:block>
            </fo:table-cell>    
            <fo:table-cell padding="3pt 1pt 0pt 1pt" text-align="center"><fo:block>.......al dia.......</fo:block></fo:table-cell>    
            <fo:table-cell padding="3pt 1pt 0pt 1pt" text-align="center">
                <fo:block>
                    <xsl:value-of select="campo4"/>
                </fo:block>
            </fo:table-cell>    
            <fo:table-cell padding="3pt 1pt 0pt 1pt" text-align="center"><fo:block>..de..</fo:block></fo:table-cell>    
            <fo:table-cell padding="3pt 1pt 0pt 1pt" text-align="center">
                <fo:block>
                    <xsl:value-of select="campo5"/>
                </fo:block>
            </fo:table-cell>    
            <fo:table-cell padding="3pt 1pt 0pt 1pt" text-align="center"><fo:block>..de..</fo:block></fo:table-cell>    
            <fo:table-cell padding="3pt 3pt 0pt 1pt" text-align="center">
                <fo:block>
                    <xsl:value-of select="campo6"/>
                </fo:block>
            </fo:table-cell>      
        </fo:table-row>
    </xsl:template>
    
    <xsl:template match="headcuadro12">
        <fo:table-row border-style="none">   
            <fo:table-cell padding="2pt 3pt 2pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo1"/>
                </fo:block>
            </fo:table-cell>     
            <fo:table-cell padding="2pt 3pt 2pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo2"/>
                </fo:block>
            </fo:table-cell>   
            <fo:table-cell padding="2pt 3pt 2pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo3"/>
                </fo:block>
            </fo:table-cell>
            <fo:table-cell padding="2pt 3pt 2pt 3pt" text-align="center">
                <fo:block>
                    <xsl:value-of select="campo4"/>
                </fo:block>
            </fo:table-cell>
        </fo:table-row>
    </xsl:template>

    <xsl:template match="cuadro12">
	    <fo:table-row border-style="none">   
            <fo:table-cell padding="3pt 3pt 0pt 3pt" border-style="dotted">
                <fo:block>
                    <xsl:value-of select="campo1"/>
                </fo:block>
            </fo:table-cell>     
            <fo:table-cell padding="3pt 3pt 0pt 3pt" border-style="dotted">
                <fo:block>
                    <xsl:value-of select="campo2"/>
                </fo:block>
            </fo:table-cell>   
            <fo:table-cell padding="3pt 3pt 0pt 3pt" border-style="dotted">
                <fo:block>
                    <xsl:value-of select="campo3"/>
                </fo:block>
            </fo:table-cell>
            <fo:table-cell padding="3pt 3pt 0pt 10pt" border-style="dotted">
                <fo:block>
                    <xsl:value-of select="campo4"/>
                </fo:block>
            </fo:table-cell>
        </fo:table-row>
    </xsl:template>

    <xsl:template match="headcuadro13">
        <fo:table-row border-style="none">   
            <fo:table-cell padding="2pt 3pt 2pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo1"/>
                </fo:block>
            </fo:table-cell>     
            <fo:table-cell padding="2pt 3pt 2pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo2"/>
                </fo:block>
            </fo:table-cell>   
            <fo:table-cell padding="2pt 3pt 2pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo3"/>
                </fo:block>
            </fo:table-cell>
            <fo:table-cell padding="2pt 3pt 2pt 3pt" text-align="center">
                <fo:block>
                    <xsl:value-of select="campo4"/>
                </fo:block>
            </fo:table-cell>
        </fo:table-row>
    </xsl:template>

    <xsl:template match="cuadro13">
	    <fo:table-row border-style="none">   
            <fo:table-cell padding="3pt 3pt 0pt 3pt" border-style="dotted">
                <fo:block>
                    <xsl:value-of select="campo1"/>
                </fo:block>
            </fo:table-cell>     
            <fo:table-cell padding="3pt 3pt 0pt 3pt" border-style="dotted">
                <fo:block>
                    <xsl:value-of select="campo2"/>
                </fo:block>
            </fo:table-cell>   
            <fo:table-cell padding="3pt 3pt 0pt 3pt" border-style="dotted">
                <fo:block>
                    <xsl:value-of select="campo3"/>
                </fo:block>
            </fo:table-cell>
            <fo:table-cell padding="3pt 3pt 0pt 10pt" border-style="dotted">
                <fo:block>
                    <xsl:value-of select="campo4"/>
                </fo:block>
            </fo:table-cell>
        </fo:table-row>
    </xsl:template>
    
       <xsl:template match="cuadro14">
	    <fo:table-row border-style="none">   
	        <fo:table-cell padding="3pt 1pt 0pt 3pt" text-align="center"><fo:block>Del dia ...</fo:block></fo:table-cell>     
	        <fo:table-cell padding="3pt 1pt 0pt 1pt" text-align="center">
                <fo:block>
                    <xsl:value-of select="campo1"/>
                </fo:block>
            </fo:table-cell> 
            <fo:table-cell padding="3pt 1pt 0pt 1pt" text-align="center"><fo:block>..de..</fo:block></fo:table-cell>    
            <fo:table-cell padding="3pt 1pt 0pt 1pt" text-align="center">
                <fo:block>
                    <xsl:value-of select="campo2"/>
                </fo:block>
            </fo:table-cell>    
            <fo:table-cell padding="3pt 1pt 0pt 1pt" text-align="center"><fo:block>..de..</fo:block></fo:table-cell>    
            <fo:table-cell padding="3pt 1pt 0pt 1pt" text-align="center">
                <fo:block>
                    <xsl:value-of select="campo3"/>
                </fo:block>
            </fo:table-cell>    
            <fo:table-cell padding="3pt 1pt 0pt 1pt" text-align="center"><fo:block>.......al dia.......</fo:block></fo:table-cell>    
            <fo:table-cell padding="3pt 1pt 0pt 1pt" text-align="center">
                <fo:block>
                    <xsl:value-of select="campo4"/>
                </fo:block>
            </fo:table-cell>    
            <fo:table-cell padding="3pt 1pt 0pt 1pt" text-align="center"><fo:block>..de..</fo:block></fo:table-cell>    
            <fo:table-cell padding="3pt 1pt 0pt 1pt" text-align="center">
                <fo:block>
                    <xsl:value-of select="campo5"/>
                </fo:block>
            </fo:table-cell>    
            <fo:table-cell padding="3pt 1pt 0pt 1pt" text-align="center"><fo:block>..de..</fo:block></fo:table-cell>    
            <fo:table-cell padding="3pt 3pt 0pt 1pt" text-align="center">
                <fo:block>
                    <xsl:value-of select="campo6"/>
                </fo:block>
            </fo:table-cell>      
        </fo:table-row>
    </xsl:template>
     
    <xsl:template match="cuadro15">
	    <fo:table-row border-style="none">   
            <fo:table-cell padding="3pt 3pt 0pt 3pt">
                <fo:block>
                    Bases de cotización
                </fo:block>
            </fo:table-cell>     
            <fo:table-cell padding="3pt 3pt 0pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo1"/>
                </fo:block>
            </fo:table-cell>   
        </fo:table-row>
    </xsl:template>


   <xsl:template match="cuadro16">
	    <fo:table-row border-style="none">   
            <fo:table-cell padding="3pt 3pt 0pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo1"/>
                </fo:block>
            </fo:table-cell>     
            <fo:table-cell padding="3pt 3pt 0pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo2"/>
                </fo:block>
            </fo:table-cell>  
                        <fo:table-cell padding="3pt 3pt 0pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo3"/>
                </fo:block>
            </fo:table-cell>     
            <fo:table-cell padding="3pt 3pt 0pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo4"/>
                </fo:block>
            </fo:table-cell>  
                        <fo:table-cell padding="3pt 3pt 0pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo5"/>
                </fo:block>
            </fo:table-cell>     
            <fo:table-cell padding="3pt 3pt 0pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo6"/>
                </fo:block>
            </fo:table-cell>   
                       <fo:table-cell padding="3pt 3pt 0pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo7"/>
                </fo:block>
            </fo:table-cell>   
        </fo:table-row>
    </xsl:template>

</xsl:stylesheet>