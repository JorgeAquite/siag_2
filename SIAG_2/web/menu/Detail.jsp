<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Menu Detail</title>
            <link rel="stylesheet" type="text/css" href="/SIAG_2/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Menu Detail</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="Codigo:"/>
                    <h:outputText value="#{menu.menu.codigo}" title="Codigo" />
                    <h:outputText value="Nombre:"/>
                    <h:outputText value="#{menu.menu.nombre}" title="Nombre" />
                    <h:outputText value="Estado:"/>
                    <h:outputText value="#{menu.menu.estado}" title="Estado" />
                    <h:outputText value="Tipo:"/>
                    <h:outputText value="#{menu.menu.tipo}" title="Tipo" />
                    <h:outputText value="Codsubmenu:"/>
                    <h:panelGroup>
                        <h:outputText value="#{menu.menu.codsubmenu}"/>
                        <h:panelGroup rendered="#{menu.menu.codsubmenu != null}">
                            <h:outputText value=" ("/>
                            <h:commandLink value="Show" action="#{menu.detailSetup}">
                                <f:param name="jsfcrud.currentMenu" value="#{jsfcrud_class['entidades.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][menu.menu][menu.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentMenu" value="#{jsfcrud_class['entidades.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][menu.menu.codsubmenu][menu.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="menu"/>
                                <f:param name="jsfcrud.relatedControllerType" value="entidades.MenuController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{menu.editSetup}">
                                <f:param name="jsfcrud.currentMenu" value="#{jsfcrud_class['entidades.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][menu.menu][menu.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentMenu" value="#{jsfcrud_class['entidades.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][menu.menu.codsubmenu][menu.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="menu"/>
                                <f:param name="jsfcrud.relatedControllerType" value="entidades.MenuController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{menu.destroy}">
                                <f:param name="jsfcrud.currentMenu" value="#{jsfcrud_class['entidades.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][menu.menu][menu.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentMenu" value="#{jsfcrud_class['entidades.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][menu.menu.codsubmenu][menu.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="menu"/>
                                <f:param name="jsfcrud.relatedControllerType" value="entidades.MenuController"/>
                            </h:commandLink>
                            <h:outputText value=" )"/>
                        </h:panelGroup>
                    </h:panelGroup>

                    <h:outputText value="MenuCollection:" />
                    <h:panelGroup>
                        <h:outputText rendered="#{empty menu.menu.menuCollection}" value="(No Items)"/>
                        <h:dataTable value="#{menu.menu.menuCollection}" var="item" 
                                     border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px" 
                                     rendered="#{not empty menu.menu.menuCollection}">
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Codigo"/>
                                </f:facet>
                                <h:outputText value="#{item.codigo}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Nombre"/>
                                </f:facet>
                                <h:outputText value="#{item.nombre}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Estado"/>
                                </f:facet>
                                <h:outputText value="#{item.estado}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Tipo"/>
                                </f:facet>
                                <h:outputText value="#{item.tipo}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Codsubmenu"/>
                                </f:facet>
                                <h:outputText value="#{item.codsubmenu}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText escape="false" value="&nbsp;"/>
                                </f:facet>
                                <h:commandLink value="Show" action="#{menu.detailSetup}">
                                    <f:param name="jsfcrud.currentMenu" value="#{jsfcrud_class['entidades.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][menu.menu][menu.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentMenu" value="#{jsfcrud_class['entidades.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][menu.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="menu" />
                                    <f:param name="jsfcrud.relatedControllerType" value="entidades.MenuController" />
                                </h:commandLink>
                                <h:outputText value=" "/>
                                <h:commandLink value="Edit" action="#{menu.editSetup}">
                                    <f:param name="jsfcrud.currentMenu" value="#{jsfcrud_class['entidades.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][menu.menu][menu.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentMenu" value="#{jsfcrud_class['entidades.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][menu.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="menu" />
                                    <f:param name="jsfcrud.relatedControllerType" value="entidades.MenuController" />
                                </h:commandLink>
                                <h:outputText value=" "/>
                                <h:commandLink value="Destroy" action="#{menu.destroy}">
                                    <f:param name="jsfcrud.currentMenu" value="#{jsfcrud_class['entidades.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][menu.menu][menu.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentMenu" value="#{jsfcrud_class['entidades.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][menu.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="menu" />
                                    <f:param name="jsfcrud.relatedControllerType" value="entidades.MenuController" />
                                </h:commandLink>
                            </h:column>
                        </h:dataTable>
                    </h:panelGroup>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{menu.remove}" value="Destroy">
                    <f:param name="jsfcrud.currentMenu" value="#{jsfcrud_class['entidades.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][menu.menu][menu.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{menu.editSetup}" value="Edit">
                    <f:param name="jsfcrud.currentMenu" value="#{jsfcrud_class['entidades.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][menu.menu][menu.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <h:commandLink action="#{menu.createSetup}" value="New Menu" />
                <br />
                <h:commandLink action="#{menu.listSetup}" value="Show All Menu Items"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
