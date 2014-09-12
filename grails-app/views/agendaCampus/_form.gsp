<%@ page import="learning.jenkis.AgendaCampus" %>



<div class="fieldcontain ${hasErrors(bean: agendaCampusInstance, field: 'campus', 'error')} ">
	<label for="campus">
		<g:message code="agendaCampus.campus.label" default="Campus" />
		
	</label>
	<g:select name="campus" from="${learning.jenkis.Campus.list()}" multiple="multiple" optionKey="id" size="5" value="${agendaCampusInstance?.campus*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: agendaCampusInstance, field: 'contacto', 'error')} ">
	<label for="contacto">
		<g:message code="agendaCampus.contacto.label" default="Contacto" />
		
	</label>
	<g:textField name="contacto" value="${agendaCampusInstance?.contacto}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: agendaCampusInstance, field: 'encargados', 'error')} ">
	<label for="encargados">
		<g:message code="agendaCampus.encargados.label" default="Encargados" />
		
	</label>
	<g:select name="encargados" from="${learning.jenkis.Encargados.list()}" multiple="multiple" optionKey="id" size="5" value="${agendaCampusInstance?.encargados*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: agendaCampusInstance, field: 'ubicacion', 'error')} ">
	<label for="ubicacion">
		<g:message code="agendaCampus.ubicacion.label" default="Ubicacion" />
		
	</label>
	<g:textField name="ubicacion" value="${agendaCampusInstance?.ubicacion}"/>
</div>

