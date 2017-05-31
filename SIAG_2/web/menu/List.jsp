<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Listing Menu Items</title>
            <link rel="stylesheet" type="text/css" href="/SIAG_2/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Listing Menu Items</h1>
            <h:form styleClass="jsfcrud_list_form">
                <h:outputText escape="false" value="(No Menu Items Found)<br />" rendered="#{menu.pagingInfo.itemCount == 0}" />
                <h:panelGroup rendered="#{menu.pagingInfo.itemCount > 0}">
                    <h:outputText value="Item #{menu.pagingInfo.firstItem + 1}..#{menu.pagingInfo.lastItem} of #{menu.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{menu.prev}" value="Previous #{menu.pagingInfo.batchSize}" rendered="#{menu.pagingInfo.firstItem >= menu.pagingInfo.batchSize}"/>&nbsp;
                    <h:commandLink action="#{menu.next}" value="Next #{menu.pagingInfo.batchSize}" rendered="#{menu.pagingInfo.lastItem + menu.pagingInfo.batchSize <= menu.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{menu.next}" value="Remaining #{menu.pagingInfo.itemCount - menu.pagingInfo.lastItem}"
                                   rendered="#{menu.pagingInfo.lastItem < menu.pagingInfo.itemCount && menu.pagingInfo.lastItem + menu.pagingInfo.batchSize > menu.pagingInfo.itemCount}"/>
                    <h:dataTable value="#{menu.menuItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
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
                                <f:param name="jsfcrud.currentMenu" value="#{jsfcrud_class['entidades.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][menu.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{menu.editSetup}">
                                <f:param name="jsfcrud.currentMenu" value="#{jsfcrud_class['entidades.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][menu.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{menu.remove}">
                                <f:param name="jsfcrud.currentMenu" value="#{jsfcrud_class['entidades.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][menu.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                        </h:column>

                    </h:dataTable>
                </h:panelGroup>
                <br />
                <h:commandLink action="#{menu.createSetup}" value="New Menu"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />


            </h:form>
        </body>
    </html>
</f:view>
