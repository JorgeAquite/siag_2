<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>New Menu</title>
            <link rel="stylesheet" type="text/css" href="/SIAG_2/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>New Menu</h1>
            <h:form>
                <h:inputHidden id="validateCreateField" validator="#{menu.validateCreate}" value="value"/>
                <h:panelGrid columns="2">
                    <h:outputText value="Codigo:"/>
                    <h:inputText id="codigo" value="#{menu.menu.codigo}" title="Codigo" required="true" requiredMessage="The codigo field is required." />
                    <h:outputText value="Nombre:"/>
                    <h:inputText id="nombre" value="#{menu.menu.nombre}" title="Nombre" required="true" requiredMessage="The nombre field is required." />
                    <h:outputText value="Estado:"/>
                    <h:inputText id="estado" value="#{menu.menu.estado}" title="Estado" required="true" requiredMessage="The estado field is required." />
                    <h:outputText value="Tipo:"/>
                    <h:inputText id="tipo" value="#{menu.menu.tipo}" title="Tipo" required="true" requiredMessage="The tipo field is required." />
                    <h:outputText value="MenuCollection:"/>
                    <h:selectManyListbox id="menuCollection" value="#{menu.menu.jsfcrud_transform[jsfcrud_class['entidades.util.JsfUtil'].jsfcrud_method.collectionToArray][jsfcrud_class['entidades.util.JsfUtil'].jsfcrud_method.arrayToList].menuCollection}" title="MenuCollection" size="6" converter="#{menu.converter}" >
                        <f:selectItems value="#{menu.menuItemsAvailableSelectMany}"/>
                    </h:selectManyListbox>
                    <h:outputText value="Codsubmenu:"/>
                    <h:selectOneMenu id="codsubmenu" value="#{menu.menu.codsubmenu}" title="Codsubmenu" >
                        <f:selectItems value="#{menu.menuItemsAvailableSelectOne}"/>
                    </h:selectOneMenu>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{menu.create}" value="Create"/>
                <br />
                <br />
                <h:commandLink action="#{menu.listSetup}" value="Show All Menu Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
