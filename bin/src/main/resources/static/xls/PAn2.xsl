<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.1" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" exclude-result-prefixes="fo">
    
    <xsl:template match="informePan2">
        
        <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
            <fo:layout-master-set>
                <fo:simple-page-master master-name="simpleA4" page-height="29.7cm" page-width="21cm" margin-top="2cm" margin-bottom="2cm" margin-left="1.5cm" margin-right="1.5cm">
            	    <fo:region-body region-name="body0" margin="0cm 0cm 0cm 0cm" space-before="170pt" />
   			    	<fo:region-before region-name="header0" extent="100pt" margin="0cm 0cm 0cm 0cm"/>     
                	<fo:region-after region-name="footer0" extent="12mm" display-align="after"/>
   				</fo:simple-page-master>                
            </fo:layout-master-set>
            
            <fo:page-sequence master-reference="simpleA4">
            <!--EMPIEZO DEL AREA DE CABECERA DE PAGINA-->
            	<fo:static-content flow-name="header0">
                    <fo:table table-layout="fixed" width="100%" border-style="none">    
                   		<fo:table-column column-width="3cm" border-width="1px" border-style="none"/>
                   		<fo:table-column column-width="12cm" border-width="1px" border-style="none"/>
                  		<fo:table-column column-width="3.4cm" border-width="1px" border-style="none"/>
                  		<fo:table-body font-size="6pt" font-family="sans-serif">
                          <fo:table-cell>
                          <fo:block>
                			<fo:external-graphic height="auto" width="2cm" content-height="2cm"
								content-width="auto" src="url(src/main/resources/static/img/logoInformes3.jpg)">
              				</fo:external-graphic>
              				</fo:block>
                    	  </fo:table-cell>   

            			  <fo:table-cell text-align="right">
             				<fo:block>
            				 	<fo:table table-layout="fixed" width="100%" border-style="none">    
                    				<fo:table-column column-width="3.8cm" border-width="1px" border-style="none"/>
                    				<fo:table-column column-width="0.2cm" border-width="1px" border-style="none"/>
                            		<fo:table-column column-width="5cm" border-width="1px" border-style="none"/>
                            		<fo:table-body font-size="6pt" font-family="sans-serif">
                                		<xsl:apply-templates select="cabecera"/>
                            		</fo:table-body>           
                        		</fo:table>
              				</fo:block>
				          </fo:table-cell>
<!-- paddin=Arriba derecha Abajo Izda -->
				          <fo:table-cell text-align="right">				             
				            <fo:block><!-- primer bloque de la celda -->
				             	<fo:table table-layout="fixed" width="100%" border-style="none">    
                    				<fo:table-column column-width="2.5cm" border-width="1px" border-style="none"/>
                    				<fo:table-column column-width="0.2cm" border-width="1px" border-style="none"/>
                            		<fo:table-column column-width="0.7cm" border-width="1px" border-style="none"/>
                            		<fo:table-body font-size="6pt" font-family="sans-serif">
                            			<fo:table-cell padding="3pt 1pt 3pt 3pt" text-align="right">
                          					<fo:block>Pag</fo:block>
                                		</fo:table-cell>   
										<fo:table-cell padding="3pt 0pt 3pt 0pt">
                          					<fo:block>:</fo:block>
                                		</fo:table-cell>   
										<fo:table-cell padding="3pt 0pt 3pt 1pt" text-align="left">
                          					<fo:block><fo:page-number/></fo:block>
                                		</fo:table-cell>   										
                            		</fo:table-body>           
                        		</fo:table> 
				            </fo:block>
              				<fo:block><!-- segundo bloque de la celda -->
            				 	<fo:table table-layout="fixed" width="100%" border-style="none">    
                    				<fo:table-column column-width="2.5cm" border-width="1px" border-style="none"/>
                    				<fo:table-column column-width="0.2cm" border-width="1px" border-style="none"/>
                            		<fo:table-column column-width="0.7cm" border-width="1px" border-style="none"/>
                            		<fo:table-body font-size="6pt" font-family="sans-serif">
                                		<xsl:apply-templates select="cabeceraDer"/>
                            		</fo:table-body>           
                        		</fo:table>
              				</fo:block>
              				        					            
				          </fo:table-cell>
				    	</fo:table-body>                               
        			</fo:table>
        			
        			<fo:block font-size="15pt" font-weight="bold" space-after="15mm"  border-style="none"><br/><br/>               </fo:block>
        			
        			<fo:table table-layout="fixed" width="100%" border-style="none">    
                   		<fo:table-column column-width="8cm" border-width="1px" border-style="none"/>
                   		<fo:table-column column-width="10cm" border-width="1px" border-style="none"/>
                  		<fo:table-body font-size="12pt" font-family="sans-serif">
                          <fo:table-cell>
                          	<fo:block font-size="16pt" font-weight="bold" space-after="3mm" text-align="center">N2-RECIBO DE NOMINA</fo:block>
                    	  </fo:table-cell>   

            			  <fo:table-cell text-align="left">
             				<fo:block>
            				 	<fo:table table-layout="fixed" width="100%" border-style="solid">    
                    				<fo:table-column column-width="7cm" border-width="1px" border-style="none"/>
                    				<fo:table-column column-width="2cm" border-width="1px" border-style="none"/>
                            		<fo:table-body font-size="6pt" font-family="sans-serif">
                                		<xsl:apply-templates select="titular"/>
                            		</fo:table-body>           
                        		</fo:table>
              				</fo:block>
				          </fo:table-cell>
				    	</fo:table-body>                               
        			</fo:table>        			        			
            	</fo:static-content>
            	<!--FIN DEL AREA DE CABECERA DE PAGINA-->
            	<!--EMPIEZO DEL AREA DE PIE DE PAGINA-->
             	<fo:static-content flow-name="footer0"> 
            		<fo:table width="20cm">
            			<fo:table-column column-width="20cm"/> 
            			<fo:table-body> 
            				<fo:table-row height="0.22cm">  
            					<fo:table-cell number-columns-spanned="1" text-align="end">    
            						<fo:block font-size="5pt">   <!--  Página:<fo:page-number/> de <fo:page-number-citation ref-id="last-page" />  -->  </fo:block>   
            					</fo:table-cell>  
            				</fo:table-row>  
            			</fo:table-body> 
            		</fo:table>
            	</fo:static-content>
            	
            	<!--FIN DEL AREA DE PIE DE PAGINA-->
            	
            	<!--EMPIEZO DE CUERPO DE PAGINA-->
                <fo:flow flow-name="body0"  border-style="none">
                    <fo:block font-size="6pt" space-after="0mm"  border-style="none" text-decoration="underline">1. DATOS GENERALES </fo:block>

				    <fo:block font-size="6pt">
                        <fo:table table-layout="fixed" width="100%" border-style="none">    
                    		<fo:table-column column-width="4cm" border-width="1px" border-style="none"/>
                    		<fo:table-column column-width="0.2cm" border-width="1px" border-style="none"/>                            		
                    		<fo:table-column column-width="8.8cm" border-width="1px" border-style="none"/>
                            <fo:table-column column-width="1.5cm" border-width="1px" border-style="none"/>
                    		<fo:table-column column-width="2.5cm" border-width="1px" border-style="none"/>
                            <fo:table-body font-size="6pt" font-family="sans-serif">
                                <xsl:apply-templates select="dgenerales"/>
                            </fo:table-body>           
                        </fo:table>
                     </fo:block>
                     
                     <fo:block font-size="6pt" space-after="3mm"  space-before="4mm" border-style="none" text-decoration="underline">2. IMPORTES EN NOMINA</fo:block>
                     
                     <fo:table table-layout="fixed" width="100%" border-style="none">    
                   		<fo:table-column column-width="11.25cm" border-width="1px" border-style="none"/>
                   		<fo:table-column column-width="6.1cm" border-width="1px" border-style="none"/>
                  		<fo:table-body>
                          <fo:table-cell padding ="2pt 2mm 0pt 2pt">
                          <fo:block border-width="1.5px" border-left-style="solid" border-right-style="solid" border-top-style="solid" border-bottom-style="none"
                          border-start-color="black" >
                           <fo:block>
            				 	<fo:table table-layout="fixed" width="100%" border-style="solid">    
                    				<fo:table-column column-width="1cm" border-width="1px" border-style="solid"/>
                    				<fo:table-column column-width="4cm" border-width="1px" border-style="solid"/>
                            		<fo:table-column column-width="1.5cm" border-width="1px" border-style="solid"/>
                            		<fo:table-column column-width="1.5cm" border-width="1px" border-style="solid"/>
                            		<fo:table-column column-width="1.5cm" border-width="1px" border-style="solid"/>
                            		<fo:table-column column-width="1.5cm" border-width="1px" border-style="solid"/>
                            		<fo:table-body text-align="center">
                          				<fo:table-cell padding="2pt 0pt 2pt 0pt"><fo:block font-size="3pt">CODIGO</fo:block></fo:table-cell>
                          				<fo:table-cell padding="2pt 0pt 2pt 0pt"><fo:block font-size="5pt">C O N C E P T O</fo:block></fo:table-cell>                                		
                          				<fo:table-cell padding="2pt 0pt 2pt 0pt"><fo:block font-size="5pt">MENSUAL</fo:block></fo:table-cell>                                		
                          				<fo:table-cell padding="2pt 0pt 2pt 0pt"><fo:block font-size="5pt">ATRASOS</fo:block></fo:table-cell>                                		
                          				<fo:table-cell padding="2pt 0pt 2pt 0pt"><fo:block font-size="5pt">REINTEGROS</fo:block></fo:table-cell>                                		
                          				<fo:table-cell padding="2pt 0pt 2pt 0pt"><fo:block font-size="5pt">TOTAL</fo:block></fo:table-cell>                                		                                		
                            		</fo:table-body>           
                        		</fo:table>
              				</fo:block>
              				<fo:block>
            				 	<fo:table table-layout="fixed" width="100%" border-style="solid">    
                    				<fo:table-column column-width="9cm" border-width="1px" border-style="none"/>
                    				<fo:table-column column-width="2cm" border-width="1px" border-style="none"/>
                            		<fo:table-body>
                            			<fo:table-cell padding="3pt 0pt 3pt 3pt">
                                		 <fo:block text-shadow="0 0 0.2em #8F7" font-size="8pt" font-weight="bold" space-after="5mm" text-align="center">RETRIBUCIONES</fo:block>
                    					</fo:table-cell>
                          				<fo:table-cell border-style="solid" padding="5pt 0pt 3pt 3pt" text-align="center">
                                		 <fo:block font-size="6pt" space-after="5mm"><xsl:value-of select="retribucion"/>
                    					</fo:block>
                    					</fo:table-cell>                                		
                            		</fo:table-body>           
                        		</fo:table>
              				</fo:block>
              				<fo:block>
            				 	<fo:table table-layout="fixed" width="100%" border-style="none">    
                    				<fo:table-column column-width="1cm" border-width="1px" border-style="none"/>
                    				<fo:table-column column-width="4cm" border-width="1px" border-left-style="solid"/>
                            		<fo:table-column column-width="1.5cm" border-width="1px" border-left-style="solid"/>
                            		<fo:table-column column-width="1.5cm" border-width="1px" border-left-style="solid"/>
                            		<fo:table-column column-width="1.5cm" border-width="1px" border-left-style="solid"/>
                            		<fo:table-column column-width="1.5cm" border-width="1px" border-left-style="solid"/>
                            		<fo:table-body font-size="6pt" font-family="sans-serif">
                                		<xsl:apply-templates select="retribuciones"/>
                            		</fo:table-body>           
                        		</fo:table>
              				</fo:block>
              				</fo:block>				                        								          
				          </fo:table-cell>
<!-- paddin=Arriba derecha Abajo Izda -->
				          <fo:table-cell text-align="left">				             
				            <fo:block border-style="solid" border-width="1.5px" margin="2pt 0pt 6pt 0pt">
				            	<fo:table table-layout="fixed" width="100%" border-style="none">    
                    				<fo:table-column column-width="6cm" border-width="1px" border-style="solid"/>
                    				<fo:table-body> 
            							<fo:table-row height="0.22cm">  
            								<fo:table-cell font-weight="bold" number-columns-spanned="1" text-align="center" font-size="12pt">    
            									<fo:block>DATOS DEL I.R.P.F.</fo:block> 
            								</fo:table-cell>  
            							</fo:table-row>  
            						</fo:table-body> 
            					</fo:table>
                          	    <fo:table table-layout="fixed" width="100%" border-style="none" margin="0pt 0pt 0pt 0pt" padding="0pt 0pt 0pt 0pt">    
                    				<fo:table-column column-width="2cm" border-width="1px" border-style="solid"/>
                    				<fo:table-column column-width="1.5cm" border-width="1px" border-style="solid"/>
                            		<fo:table-column column-width="1cm" border-width="1px" border-style="solid"/>
                            		<fo:table-column column-width="1.5cm" border-width="1px" border-style="solid"/>
                            		<fo:table-header font-size="3pt">
                               			<xsl:apply-templates select="headirpf" text-align="center"/>
                            		</fo:table-header>
                            		<fo:table-body font-size="6pt" font-family="sans-serif">
                               			<xsl:apply-templates select="irpf" text-align="center"/>
                            		</fo:table-body>           
                        		</fo:table>
              				</fo:block>
                          					
                            <fo:block border-style="solid" border-width="1.5px" margin="6pt 0pt 6pt 0pt">
                                <fo:table table-layout="fixed" width="100%" border-style="none">    
                    				<fo:table-column column-width="6cm" border-width="1px" border-style="solid"/>
                    				<fo:table-body> 
            							<fo:table-row height="0.22cm">  
            								<fo:table-cell font-weight="bold" number-columns-spanned="1" text-align="center" font-size="12pt">    
            									<fo:block>DATOS DEL R.G.S.S.</fo:block> 
            								</fo:table-cell>  
            							</fo:table-row>  
            						</fo:table-body> 
            					</fo:table>
                          		<fo:table table-layout="fixed" width="100%" border-style="solid">    
                    				<fo:table-column column-width="2cm" border-width="1px" border-style="solid"/>
                    				<fo:table-column column-width="2cm" border-width="1px" border-style="solid"/>
                            		<fo:table-column column-width="0.5cm" border-width="1px" border-style="solid"/>
                            		<fo:table-column column-width="1cm" border-width="1px" border-style="solid"/>
                            		<fo:table-column column-width="0.5cm" border-width="1px" border-style="solid"/>
                            		<fo:table-header font-size="3pt">
                               			<xsl:apply-templates select="headrgss"/>
                            		</fo:table-header>
                            		<fo:table-body font-size="6pt" font-family="sans-serif">
                               			<xsl:apply-templates select="rgss"/>
                            		</fo:table-body>           
                        		</fo:table>
              				</fo:block>				            
				          </fo:table-cell>
				    	</fo:table-body>                               
        			</fo:table>
        			
        			
           <!-- ******************  DEDUCCIONES -->
                    <fo:table table-layout="fixed" width="100%" border-style="none">    
                   		<fo:table-column column-width="11.25cm" border-width="1px" border-style="none"/>
                   		<fo:table-column column-width="6.1cm" border-width="1px" border-style="none"/>
                  		<fo:table-body>
                          <fo:table-cell padding ="0pt 2mm 0pt 2pt">
                          <fo:block border-width="1.5px" border-left-style="solid" border-right-style="solid" border-bottom-style="none" border-top-style="none" >
                           
              				<fo:block>
            				 	<fo:table table-layout="fixed" width="100%" border-style="solid">    
                    				<fo:table-column column-width="9cm" border-width="1px" border-style="none"/>
                    				<fo:table-column column-width="2cm" border-width="1px" border-style="none"/>
                            		<fo:table-body>
                            			<fo:table-cell padding="3pt 0pt 3pt 3pt">
                                		 <fo:block text-shadow="0 0 0.2em #8F7" font-size="8pt" font-weight="bold" space-after="5mm" text-align="center">DEDUCCIONES</fo:block>
                    					</fo:table-cell>
                          				<fo:table-cell border-style="solid" padding="5pt 0pt 3pt 3pt" text-align="center">
                                		 <fo:block font-size="6pt" space-after="5mm"><xsl:value-of select="deduccion"/>
                    					</fo:block>
                    					</fo:table-cell>                                		
                            		</fo:table-body>           
                        		</fo:table>
              				</fo:block>
              				<fo:block>
            				 	<fo:table table-layout="fixed" width="100%" border-style="none">    
                    				<fo:table-column column-width="1cm" border-width="1px" border-style="none"/>
                    				<fo:table-column column-width="4cm" border-width="1px" border-left-style="solid"/>
                            		<fo:table-column column-width="1.5cm" border-width="1px" border-left-style="solid"/>
                            		<fo:table-column column-width="1.5cm" border-width="1px" border-left-style="solid"/>
                            		<fo:table-column column-width="1.5cm" border-width="1px" border-left-style="solid"/>
                            		<fo:table-column column-width="1.5cm" border-width="1px" border-left-style="solid"/>
                            		<fo:table-body font-size="6pt" font-family="sans-serif">
                                		<xsl:apply-templates select="deducciones"/>
                            		</fo:table-body>           
                        		</fo:table>
              				</fo:block>
              				</fo:block>				                        								          
				          </fo:table-cell>
<!-- paddin=Arriba derecha Abajo Izda -->
				          <fo:table-cell text-align="left">				             
				            <fo:block border-style="solid" border-width="1.5px" margin="2pt 0pt 6pt 0pt">
				            	<fo:table table-layout="fixed" width="100%" border-style="none" margin="0pt 0pt 0pt 0pt" padding="0pt 0pt 0pt 0pt">    
                    				<fo:table-column column-width="2cm" border-width="1px" border-style="solid"/>
                    				<fo:table-column column-width="2cm" border-width="1px" border-style="solid"/>
                            		<fo:table-column column-width="2cm" border-width="1px" border-style="solid"/>
                            		<fo:table-header font-size="3pt">
                               			<xsl:apply-templates select="headafil" text-align="center"/>
                            		</fo:table-header>
                            		<fo:table-body font-size="6pt" font-family="sans-serif">
                               			<xsl:apply-templates select="afil" text-align="center"/>
                            		</fo:table-body>           
                        		</fo:table>
              				</fo:block>
				          </fo:table-cell>
				    	</fo:table-body>                               
        			</fo:table>
           
           <!-- ******************  LIQUIDACIONES     -->
                    <fo:table table-layout="fixed" width="100%" border-style="none">    
                   		<fo:table-column column-width="11.25cm" border-width="1px" border-style="none"/>
                   		<fo:table-body>
                          <fo:table-cell padding ="0pt 2mm 0pt 2pt">
                          <fo:block border-style="solid" border-width="1.5px" border-right-style="solid" border-left-style="solid" border-bottom-style="solid" border-top-style="none">
                           		<fo:table table-layout="fixed" width="100%" border-style="solid">    
                    				<fo:table-column column-width="9cm" border-width="1px" border-style="none"/>
                    				<fo:table-column column-width="2cm" border-width="1px" border-style="none"/>
                            		<fo:table-body>
                            			<fo:table-cell padding="3pt 0pt 3pt 3pt">
                                		 <fo:block text-shadow="0 0 0.2em #8F7" font-size="8pt" font-weight="bold" space-after="5mm" text-align="center">LIQUIDO A PERCIBIR</fo:block>
                    					</fo:table-cell>
                          				<fo:table-cell border-style="solid" padding="5pt 0pt 3pt 3pt" text-align="center">
                                		 <fo:block font-size="6pt" space-after="5mm"><xsl:value-of select="liquidacion"/>
                    					</fo:block>
                    					</fo:table-cell>                                		
                            		</fo:table-body>           
                        		</fo:table>
              				</fo:block>				                        								          
				          </fo:table-cell>
				    	</fo:table-body>                               
        			</fo:table>
           
           <!-- *************** -->   
           
            <fo:block font-size="6pt" space-after="3mm"  space-before="4mm" border-style="none" text-decoration="underline">3. FORMA DE PAGO</fo:block>        
           
           <!-- ********** FORMA DE PAGO -->
           
            <fo:table table-layout="fixed" width="100%" border-style="none">    
                   		<fo:table-column column-width="10cm" border-width="1px" border-style="none"/>
                   		<fo:table-column column-width="8cm" border-width="1px" border-style="none"/>
                  		<fo:table-body>
                          <fo:table-cell>
                          	<fo:block border-style="none">
                           
              					<fo:table table-layout="fixed" width="100%" border-style="none">    
                    				<fo:table-column column-width="5.5cm" border-width="1px" border-style="none"/>
                    				<fo:table-column column-width="1cm" border-width="1px" border-style="none"/>
                    				<fo:table-column column-width="4.5cm" border-width="1px" border-style="none"/>
                            		<fo:table-body>
                            			<fo:table-cell padding="0pt 0pt 0pt 0pt">
                                		 <fo:block font-size="6pt" >TRANSFERENCIA DEL LIQUIDO A PERCIBIR:</fo:block>
                    					</fo:table-cell>
                          				<fo:table-cell border-style="none" padding="0pt 0pt 0pt 0pt">
                                		 <fo:block font-size="6pt" ><xsl:value-of select="pago"/>
                    					</fo:block>
                    					</fo:table-cell>
                    					<fo:table-cell padding="0pt 0pt 0pt 0pt">
                                		 <fo:block font-size="6pt" text-align="left">EUROS</fo:block>
                    					</fo:table-cell>
                            		</fo:table-body>           
                        		</fo:table>
              				</fo:block>	
              				 <fo:block font-size="6pt" text-align="left"><xsl:value-of select="bancopago"/></fo:block>
                    								                        								          
				          </fo:table-cell>
<!-- paddin=Arriba derecha Abajo Izda -->
				          <fo:table-cell text-align="left">				             
				            <fo:block border-style="none">
				            	<fo:table table-layout="fixed" width="100%" border-style="none" margin="0pt 0pt 0pt 0pt" padding="0pt 0pt 0pt 0pt">    
                    				<fo:table-column column-width="3cm" border-width="1px" border-style="none"/>
                    				<fo:table-column column-width="5cm" border-width="1px" border-style="none"/>
                            		<fo:table-body font-size="6pt" font-family="sans-serif">
                            		 <fo:table-row>
                            			<fo:table-cell padding="0pt 0pt 0pt 0pt" text-align="right">
                                			 <fo:block font-size="6pt" >A LA CUENTA: IBAN:</fo:block>
                    					</fo:table-cell>
                          				<fo:table-cell border-style="none" padding="0pt 0pt 0pt 0pt">
                                		 	<fo:block font-size="6pt" ><xsl:value-of select="iban"/></fo:block>
                    					</fo:table-cell>
                    				 </fo:table-row>
                    				 <fo:table-row>
                            			<fo:table-cell padding="0pt 0pt 0pt 0pt" text-align="right">
                                			 <fo:block font-size="6pt" >BIC:</fo:block>
                    					</fo:table-cell>
                          				<fo:table-cell border-style="none" padding="0pt 0pt 0pt 0pt">
                                		 	<fo:block font-size="6pt" ><xsl:value-of select="formapago"/></fo:block>
                    					</fo:table-cell>
                    				 </fo:table-row>
                            		</fo:table-body>           
                        		</fo:table>
              				</fo:block>
				          </fo:table-cell>
				    	</fo:table-body>                               
        			</fo:table>
           
           <!-- **************************  COTIZACIONES -->
  					<fo:table table-layout="fixed" width="100%" border-style="none" margin="3pt 0pt 0pt 0pt" padding="6pt 0pt 0pt 0pt">    
                     	<fo:table-column column-width="18cm" border-width="1px" border-style="none"/>
              			<fo:table-body font-size="6pt" font-family="sans-serif">                        
            		        <fo:table-row keep-together.within-page="always" border-style="none"> <!-- Hace q la tabla no pueda partirse -->
    						<fo:table-cell padding="0pt 0pt 0pt 0pt">
             					<fo:block font-size="6pt" space-after="3mm"  space-before="4mm" border-style="none" text-decoration="underline">4. DETERMINACION DE LAS BASES DE COTIZACION A LA SEGURIDAD SOCIAL Y CONCEPTOS DE RECAUDACION CONJUNTA Y DE LA BASE SUJETA A RETENCION DEL IRPF Y APORTACION DE LA EMPRESA</fo:block> 
             
             					<fo:block font-size="4pt" space-after="3mm"  space-before="4mm" border-style="none">(Las aportaciones empresariales a la S.S. consignadas pueden estar sujetas a cambios en el momento de efectuar la liquidacion de las mismas por parte de la empresa)</fo:block> 
                
             					<fo:block border-style="solid" border-width="1.5px" margin="2pt 0pt 6pt 0pt">
				            		<fo:table table-layout="fixed" width="100%" border-style="none" margin="0pt 0pt 0pt 0pt" padding="0pt 0pt 0pt 0pt">    
                    					<fo:table-column column-width="10cm" border-width="1px" border-left-style="none"/>
                    					<fo:table-column column-width="2cm" border-width="1px" border-left-style="solid"/>
                            			<fo:table-column column-width="2cm" border-width="1px" border-left-style="solid"/>
                            			<fo:table-column column-width="2cm" border-width="1px" border-left-style="solid"/>
                            			<fo:table-column column-width="1.9cm" border-width="1px" border-left-style="solid"/>
                            			<fo:table-header font-size="6pt">
                               				<xsl:apply-templates select="headcotiz" text-align="center" font-weight="bold" space-after="3mm" border-style="solid"/>
                            			</fo:table-header>
                            			<fo:table-body font-size="6pt" font-family="sans-serif">
                               				<xsl:apply-templates select="cotiz" text-align="center"/>
                            			</fo:table-body>           
                        			</fo:table>
                        			<fo:block font-size="15pt" font-weight="bold" space-after="3mm"  border-style="none"><br/><br/>               </fo:block>
                        			
                        			<fo:table table-layout="fixed" width="100%" border-style="none" margin="0pt 0pt 0pt 0pt" padding="0pt 0pt 0pt 0pt">    
                    					<fo:table-column column-width="11cm" border-width="1px" border-style="none"/>
                    					<fo:table-column column-width="1cm" border-width="1px" border-style="solid"/>
                    					<fo:table-column column-width="6.9cm" border-width="1px" border-style="none"/>
                            			<fo:table-body font-size="6pt" font-family="sans-serif">
      									<fo:table-row keep-together.within-page="always" border-style="none">
							            <fo:table-cell text-align="left" padding="2pt 4pt 2pt 2pt"  margin="0pt 0pt 0pt 10pt">
            								<fo:block>DIAS DE RETRIBUCION MENSUAL A LOS QUE CORRESPONDEN LOS IMPORTES</fo:block>
         								</fo:table-cell>
         								<fo:table-cell text-align="left" padding="2pt 4pt 2pt 2pt"  margin="0pt 0pt 0pt 10pt">
             								<fo:block>
                   								<xsl:value-of select="cotizpie"/>
             								</fo:block>
         								</fo:table-cell>   
        								<fo:table-cell text-align="left" padding="2pt 4pt 2pt 2pt"  margin="0pt 0pt 0pt 10pt">
             								<fo:block></fo:block>
         								</fo:table-cell>   
        								</fo:table-row>
                            			</fo:table-body>           
                        			</fo:table>
                        			<fo:block font-size="15pt" font-weight="bold" space-after="15mm"  border-style="none"><br/><br/>               </fo:block>
              					</fo:block>
                   			</fo:table-cell>
            				</fo:table-row> 
						</fo:table-body>                        
            			</fo:table>
                 </fo:flow>                 
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
    
    <xsl:template match="cabecera">
       <fo:table-row keep-together.within-page="always" border-style="none" text-align="left">
           <fo:table-cell padding="3pt 1pt 0pt 3pt">
                <fo:block>
                   <xsl:value-of select="campo1"></xsl:value-of>
                </fo:block>
            </fo:table-cell>
            <fo:table-cell padding="3pt 0pt 0pt 0pt">
                <fo:block>:</fo:block>
            </fo:table-cell>   
            <fo:table-cell padding="3pt 0pt 0pt 1pt">
                <fo:block>
                    <xsl:value-of select="campo2"/>
                </fo:block>
            </fo:table-cell>   
            
        </fo:table-row>
    </xsl:template>
  
    <xsl:template match="cabeceraDer">
       <fo:table-row keep-together.within-page="always" border-style="none">
           <fo:table-cell padding="3pt 1pt 3pt 3pt" text-align="right">
                <fo:block>
                   <xsl:value-of select="campo1"></xsl:value-of>
                </fo:block>
            </fo:table-cell>
            <fo:table-cell padding="3pt 0pt 3pt 0pt">
                <fo:block>:</fo:block>
            </fo:table-cell>   
            <fo:table-cell padding="3pt 0pt 3pt 1pt"   text-align="left">
                <fo:block>
                    <xsl:value-of select="campo2"/>
                </fo:block>
            </fo:table-cell>   
        </fo:table-row>
    </xsl:template>

    <xsl:template match="titular">
       <fo:table-row keep-together.within-page="always" border-style="none">
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

    <xsl:template match="dgenerales">
       <fo:table-row keep-together.within-page="always" border-style="none">
    <!--         <xsl:if test="campo3 = 'PROVINCIA'">
                <xsl:attribute name="value">bold</xsl:attribute>
            </xsl:if>
       -->
           <fo:table-cell padding="3pt 3pt 0pt 3pt">
                <fo:block>
                   <xsl:value-of select="campo1"></xsl:value-of>
                </fo:block>
            </fo:table-cell>
            <fo:table-cell padding="3pt 0pt 0pt 0pt">
                <fo:block>:</fo:block>
            </fo:table-cell>   
            <fo:table-cell padding="3pt 3pt 0pt 1t">
                <fo:block>
                    <xsl:value-of select="campo2"/>
                </fo:block>
            </fo:table-cell>   
            <fo:table-cell padding="3pt 1pt 0pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo3"/>
                </fo:block>
            </fo:table-cell>   
            <fo:table-cell padding="3pt 3pt 0pt 1pt">
                <fo:block>
                    <xsl:value-of select="campo4"/>
                </fo:block>
            </fo:table-cell>
            
        </fo:table-row>
    </xsl:template>
    
    <xsl:template match="headirpf">
       <fo:table-row keep-together.within-page="always" border-style="solid" >
           <fo:table-cell padding="0.2pt 0.2pt 0.2pt 0.2pt" text-align="center">
                <fo:block>
                   <xsl:value-of select="campo1"/>
                </fo:block>
            </fo:table-cell>
            <fo:table-cell padding="0.2pt 0pt 0.2pt 0pt" text-align="center">
                <fo:block>
                    <xsl:value-of select="campo2"/>
                </fo:block>
            </fo:table-cell>   
            <fo:table-cell padding="0.2pt 0pt 0.2pt 0pt" text-align="center">
                <fo:block>
                    <xsl:value-of select="campo3"/>
                </fo:block>
            </fo:table-cell>   
            <fo:table-cell padding="0.2pt 0pt 0.2pt 0pt" text-align="center">
                <fo:block>
                    <xsl:value-of select="campo4"/>
                </fo:block>
            </fo:table-cell>               
        </fo:table-row>
    </xsl:template>
    <xsl:template match="irpf">
       <fo:table-row keep-together.within-page="always" border-style="solid">
           <fo:table-cell padding="0.2pt 0pt 0.2pt 0pt" text-align="center">
                <fo:block>
                   <xsl:value-of select="campo1"/>
                </fo:block>
            </fo:table-cell>
            <fo:table-cell padding="0.2pt 0pt 0.2pt 0pt" text-align="center">
                <fo:block>
                    <xsl:value-of select="campo2"/>
                </fo:block>
            </fo:table-cell>   
            <fo:table-cell padding="0.2pt 0pt 0.2pt 0pt" text-align="center">
                <fo:block>
                    <xsl:value-of select="campo3"/>
                </fo:block>
            </fo:table-cell>   
            <fo:table-cell padding="0.2pt 0pt 0.2pt 0pt" text-align="center">
                <fo:block>
                    <xsl:value-of select="campo4"/>
                </fo:block>
            </fo:table-cell>               
        </fo:table-row>
    </xsl:template>
        <xsl:template match="headrgss">
       <fo:table-row border-style="solid">
           <fo:table-cell text-align="center">
                <fo:block>
                   <xsl:value-of select="campo1"/>
                </fo:block>
            </fo:table-cell>
            <fo:table-cell text-align="center">
                <fo:block>
                    <xsl:value-of select="campo2"/>
                </fo:block>
            </fo:table-cell>   
            <fo:table-cell text-align="center">
                <fo:block>
                    <xsl:value-of select="campo3"/>
                </fo:block>
            </fo:table-cell>   
            <fo:table-cell text-align="center">
                <fo:block>
                    <xsl:value-of select="campo4"/>
                </fo:block>
            </fo:table-cell>               
            <fo:table-cell text-align="center">
                <fo:block>
                    <xsl:value-of select="campo5"/>
                </fo:block>
            </fo:table-cell>               
        </fo:table-row>
    </xsl:template>
    <xsl:template match="rgss">
       <fo:table-row border-style="none">
           <fo:table-cell text-align="center">
                <fo:block>
                   <xsl:value-of select="campo1"/>
                </fo:block>
            </fo:table-cell>
            <fo:table-cell text-align="center">
                <fo:block>
                    <xsl:value-of select="campo2"/>
                </fo:block>
            </fo:table-cell>   
            <fo:table-cell text-align="center">
                <fo:block>
                    <xsl:value-of select="campo3"/>
                </fo:block>
            </fo:table-cell>   
            <fo:table-cell text-align="center">
                <fo:block>
                    <xsl:value-of select="campo4"/>
                </fo:block>
            </fo:table-cell>               
            <fo:table-cell text-align="center">
                <fo:block>
                    <xsl:value-of select="campo5"/>
                </fo:block>
            </fo:table-cell>               
        </fo:table-row>
    </xsl:template>
    
       <xsl:template match="headafil">
       <fo:table-row keep-together.within-page="always" border-style="solid" >
           <fo:table-cell padding="0.2pt 0.2pt 0.2pt 0.2pt" text-align="center">
                <fo:block>
                   <xsl:value-of select="campo1"/>
                </fo:block>
            </fo:table-cell>
            <fo:table-cell padding="0.2pt 0pt 0.2pt 0pt" text-align="center">
                <fo:block>
                    <xsl:value-of select="campo2"/>
                </fo:block>
            </fo:table-cell>   
            <fo:table-cell padding="0.2pt 0pt 0.2pt 0pt" text-align="center">
                <fo:block>
                    <xsl:value-of select="campo3"/>
                </fo:block>
            </fo:table-cell>                 
        </fo:table-row>
    </xsl:template>
    <xsl:template match="afil">
       <fo:table-row keep-together.within-page="always" border-style="solid">
           <fo:table-cell padding="0.2pt 0pt 0.2pt 0pt" text-align="center">
                <fo:block>
                   <xsl:value-of select="campo1"/>
                </fo:block>
            </fo:table-cell>
            <fo:table-cell padding="0.2pt 0pt 0.2pt 0pt" text-align="center">
                <fo:block>
                    <xsl:value-of select="campo2"/>
                </fo:block>
            </fo:table-cell>   
            <fo:table-cell padding="0.2pt 0pt 0.2pt 0pt" text-align="center">
                <fo:block>
                    <xsl:value-of select="campo3"/>
                </fo:block>
            </fo:table-cell>              
        </fo:table-row>
    </xsl:template>
    <xsl:template match="retribuciones">
       <fo:table-row border-style="none">
           <fo:table-cell text-align="left" padding="2pt 2pt 2pt 3pt">
                <fo:block>
                   <xsl:value-of select="campo1"/>
                </fo:block>
            </fo:table-cell>
            <fo:table-cell text-align="left" padding="2pt 2pt 2pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo2"/>
                </fo:block>
            </fo:table-cell>   
            <fo:table-cell text-align="right" padding="2pt 2pt 2pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo3"/>
                </fo:block>
            </fo:table-cell>   
            <fo:table-cell text-align="right" padding="2pt 2pt 2pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo4"/>
                </fo:block>
            </fo:table-cell>               
            <fo:table-cell text-align="right" padding="2pt 2pt 2pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo5"/>
                </fo:block>
            </fo:table-cell>               
            <fo:table-cell text-align="right" padding="2pt 2pt 2pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo6"/>
                </fo:block>
            </fo:table-cell>               
        </fo:table-row>
    </xsl:template>
    
    <xsl:template match="deducciones">
       <fo:table-row border-style="none">
           <fo:table-cell text-align="left" padding="2pt 2pt 2pt 3pt">
                <fo:block>
                   <xsl:value-of select="campo1"/>
                </fo:block>
            </fo:table-cell>
            <fo:table-cell text-align="left" padding="2pt 2pt 2pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo2"/>
                </fo:block>
            </fo:table-cell>   
            <fo:table-cell text-align="right" padding="2pt 2pt 2pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo3"/>
                </fo:block>
            </fo:table-cell>   
            <fo:table-cell text-align="right" padding="2pt 2pt 2pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo4"/>
                </fo:block>
            </fo:table-cell>               
            <fo:table-cell text-align="right" padding="2pt 2pt 2pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo5"/>
                </fo:block>
            </fo:table-cell>               
            <fo:table-cell text-align="right" padding="2pt 2pt 2pt 3pt">
                <fo:block>
                    <xsl:value-of select="campo6"/>
                </fo:block>
            </fo:table-cell>               
        </fo:table-row>
    </xsl:template>
    
    <xsl:template match="headcotiz">
       <fo:table-row border-style="none">
           <fo:table-cell padding="3pt 2pt 3pt 2pt" text-align="center">
                <fo:block>
                   <xsl:value-of select="campo1"/>
                </fo:block>
            </fo:table-cell>
            <fo:table-cell padding="3pt 2pt 3pt 2pt" text-align="center">
                <fo:block>
                    <xsl:value-of select="campo2"/>
                </fo:block>
            </fo:table-cell>   
            <fo:table-cell padding="3pt 2pt 3pt 2pt" text-align="center">
                <fo:block>
                    <xsl:value-of select="campo3"/>
                </fo:block>
            </fo:table-cell>   
            <fo:table-cell padding="3pt 2pt 3pt 2pt" text-align="center">
                <fo:block>
                    <xsl:value-of select="campo4"/>
                </fo:block>
            </fo:table-cell>               
            <fo:table-cell padding="3pt 2pt 3pt 2pt" text-align="center">
                <fo:block>
                    <xsl:value-of select="campo5"/>
                </fo:block>
            </fo:table-cell>                             
        </fo:table-row>
    </xsl:template>
    
    <xsl:template match="cotiz">
       <fo:table-row keep-together.within-page="always" border-style="none">
         <fo:table-cell text-align="left" padding="2pt 4pt 2pt 2pt"  margin="0pt 0pt 0pt 10pt">
            <xsl:if test="campo1 = '1. CONTINGENCIAS COMUNES'">
          		<xsl:attribute name="font-weight">bold</xsl:attribute>
                <xsl:attribute name="margin">2pt 4pt 2pt 2pt</xsl:attribute>
            </xsl:if>
         	<xsl:if test="campo1 = '2. CONTINGENCIAS PROF. Y CPTOS DE RECAUDACION CONJUNTA'">
          		<xsl:attribute name="font-weight">bold</xsl:attribute>
                <xsl:attribute name="margin">2pt 4pt 2pt 2pt</xsl:attribute>
         	</xsl:if>
         	<xsl:if test="campo1 = '3. COTIZACION ADICIONAL HORAS EXTRAORDINARIAS'">
          		<xsl:attribute name="font-weight">bold</xsl:attribute>
                <xsl:attribute name="margin">2pt 4pt 2pt 2pt</xsl:attribute>
         	</xsl:if>
         	<xsl:if test="campo1 = '4. BASE SUJETA A RETENCION DEL IRPF'">
          		<xsl:attribute name="font-weight">bold</xsl:attribute>
                <xsl:attribute name="margin">2pt 4pt 2pt 2pt</xsl:attribute>
         	</xsl:if>        	         
            <fo:block>
                   <xsl:value-of select="campo1"/>
            </fo:block>
         </fo:table-cell>
         <fo:table-cell text-align="right" padding="2pt 4pt 2pt 3pt">
             <fo:block>
                 <xsl:value-of select="campo2"/>
             </fo:block>
         </fo:table-cell>   
         <fo:table-cell text-align="right" padding="2pt 4pt 2pt 3pt">
             <fo:block>
                 <xsl:value-of select="campo3"/>
             </fo:block>
         </fo:table-cell>   
         <fo:table-cell text-align="right" padding="2pt 4pt 2pt 3pt">
             <fo:block>
                 <xsl:value-of select="campo4"/>
             </fo:block>
         </fo:table-cell>               
         <fo:table-cell text-align="right" padding="2pt 4pt 2pt 3pt">
             <fo:block>
                 <xsl:value-of select="campo5"/>
             </fo:block>
         </fo:table-cell>                             
        </fo:table-row>
    </xsl:template>    
    
</xsl:stylesheet>