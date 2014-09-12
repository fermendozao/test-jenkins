
<%@ page import="learning.jenkis.Campus" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'campus.label', default: 'Campus')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-campus" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-campus" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list campus">
			
				<g:if test="${campusInstance?.nombre}">
				<li class="fieldcontain">
					<span id="nombre-label" class="property-label"><g:message code="campus.nombre.label" default="Nombre" /></span>
					
						<span class="property-value" aria-labelledby="nombre-label"><g:fieldValue bean="${campusInstance}" field="nombre"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${campusInstance?.descripcion}">
				<li class="fieldcontain">
					<span id="descripcion-label" class="property-label"><g:message code="campus.descripcion.label" default="Descripcion" /></span>
					
						<span class="property-value" aria-labelledby="descripcion-label"><g:fieldValue bean="${campusInstance}" field="descripcion"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${campusInstance?.temario}">
				<li class="fieldcontain">
					<span id="temario-label" class="property-label"><g:message code="campus.temario.label" default="Temario" /></span>
					
						<span class="property-value" aria-labelledby="temario-label"><g:fieldValue bean="${campusInstance}" field="temario"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${campusInstance?.horario}">
				<li class="fieldcontain">
					<span id="horario-label" class="property-label"><g:message code="campus.horario.label" default="Horario" /></span>
					
						<span class="property-value" aria-labelledby="horario-label"><g:fieldValue bean="${campusInstance}" field="horario"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${campusInstance?.fechaFinaliza}">
				<li class="fieldcontain">
					<span id="fechaFinaliza-label" class="property-label"><g:message code="campus.fechaFinaliza.label" default="Fecha Finaliza" /></span>
					
						<span class="property-value" aria-labelledby="fechaFinaliza-label"><g:formatDate date="${campusInstance?.fechaFinaliza}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${campusInstance?.fechaInicio}">
				<li class="fieldcontain">
					<span id="fechaInicio-label" class="property-label"><g:message code="campus.fechaInicio.label" default="Fecha Inicio" /></span>
					
						<span class="property-value" aria-labelledby="fechaInicio-label"><g:formatDate date="${campusInstance?.fechaInicio}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${campusInstance?.id}" />
					<g:link class="edit" action="edit" id="${campusInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
