
<%@ page import="learning.jenkis.AgendaCampus" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'agendaCampus.label', default: 'AgendaCampus')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-agendaCampus" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-agendaCampus" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list agendaCampus">
			
				<g:if test="${agendaCampusInstance?.campus}">
				<li class="fieldcontain">
					<span id="campus-label" class="property-label"><g:message code="agendaCampus.campus.label" default="Campus" /></span>
					
						<g:each in="${agendaCampusInstance.campus}" var="c">
						<span class="property-value" aria-labelledby="campus-label"><g:link controller="campus" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${agendaCampusInstance?.contacto}">
				<li class="fieldcontain">
					<span id="contacto-label" class="property-label"><g:message code="agendaCampus.contacto.label" default="Contacto" /></span>
					
						<span class="property-value" aria-labelledby="contacto-label"><g:fieldValue bean="${agendaCampusInstance}" field="contacto"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${agendaCampusInstance?.encargados}">
				<li class="fieldcontain">
					<span id="encargados-label" class="property-label"><g:message code="agendaCampus.encargados.label" default="Encargados" /></span>
					
						<g:each in="${agendaCampusInstance.encargados}" var="e">
						<span class="property-value" aria-labelledby="encargados-label"><g:link controller="encargados" action="show" id="${e.id}">${e?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${agendaCampusInstance?.ubicacion}">
				<li class="fieldcontain">
					<span id="ubicacion-label" class="property-label"><g:message code="agendaCampus.ubicacion.label" default="Ubicacion" /></span>
					
						<span class="property-value" aria-labelledby="ubicacion-label"><g:fieldValue bean="${agendaCampusInstance}" field="ubicacion"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${agendaCampusInstance?.id}" />
					<g:link class="edit" action="edit" id="${agendaCampusInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
