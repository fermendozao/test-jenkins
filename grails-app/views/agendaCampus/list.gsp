
<%@ page import="learning.jenkis.AgendaCampus" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'agendaCampus.label', default: 'AgendaCampus')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-agendaCampus" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-agendaCampus" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="contacto" title="${message(code: 'agendaCampus.contacto.label', default: 'Contacto')}" />
					
						<g:sortableColumn property="ubicacion" title="${message(code: 'agendaCampus.ubicacion.label', default: 'Ubicacion')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${agendaCampusInstanceList}" status="i" var="agendaCampusInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${agendaCampusInstance.id}">${fieldValue(bean: agendaCampusInstance, field: "contacto")}</g:link></td>
					
						<td>${fieldValue(bean: agendaCampusInstance, field: "ubicacion")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${agendaCampusInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
