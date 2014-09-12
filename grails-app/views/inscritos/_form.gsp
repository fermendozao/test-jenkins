<%@ page import="learning.jenkis.Inscritos" %>



<div class="fieldcontain ${hasErrors(bean: inscritosInstance, field: 'agenda', 'error')} ">
	<label for="agenda">
		<g:message code="inscritos.agenda.label" default="Agenda" />
		
	</label>
	<g:select name="agenda" from="${learning.jenkis.AgendaCampus.list()}" multiple="multiple" optionKey="id" size="5" value="${inscritosInstance?.agenda*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: inscritosInstance, field: 'nombreCompleto', 'error')} ">
	<label for="nombreCompleto">
		<g:message code="inscritos.nombreCompleto.label" default="Nombre Completo" />
		
	</label>
	<g:textField name="nombreCompleto" value="${inscritosInstance?.nombreCompleto}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: inscritosInstance, field: 'observaciones', 'error')} ">
	<label for="observaciones">
		<g:message code="inscritos.observaciones.label" default="Observaciones" />
		
	</label>
	<g:textField name="observaciones" value="${inscritosInstance?.observaciones}"/>
</div>

