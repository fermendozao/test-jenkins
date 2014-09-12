
<%@ page import="learning.jenkis.Campus" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'campus.label', default: 'Campus')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-campus" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-campus" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="nombre" title="${message(code: 'campus.nombre.label', default: 'Nombre')}" />
					
						<g:sortableColumn property="descripcion" title="${message(code: 'campus.descripcion.label', default: 'Descripcion')}" />
					
						<g:sortableColumn property="temario" title="${message(code: 'campus.temario.label', default: 'Temario')}" />
					
						<g:sortableColumn property="horario" title="${message(code: 'campus.horario.label', default: 'Horario')}" />
					
						<g:sortableColumn property="fechaFinaliza" title="${message(code: 'campus.fechaFinaliza.label', default: 'Fecha Finaliza')}" />
					
						<g:sortableColumn property="fechaInicio" title="${message(code: 'campus.fechaInicio.label', default: 'Fecha Inicio')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${campusInstanceList}" status="i" var="campusInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${campusInstance.id}">${fieldValue(bean: campusInstance, field: "nombre")}</g:link></td>
					
						<td>${fieldValue(bean: campusInstance, field: "descripcion")}</td>
					
						<td>${fieldValue(bean: campusInstance, field: "temario")}</td>
					
						<td>${fieldValue(bean: campusInstance, field: "horario")}</td>
					
						<td><g:formatDate date="${campusInstance.fechaFinaliza}" /></td>
					
						<td><g:formatDate date="${campusInstance.fechaInicio}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${campusInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
