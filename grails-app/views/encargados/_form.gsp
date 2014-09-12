<%@ page import="learning.jenkis.Encargados" %>



<div class="fieldcontain ${hasErrors(bean: encargadosInstance, field: 'nombreComppleto', 'error')} ">
	<label for="nombreComppleto">
		<g:message code="encargados.nombreComppleto.label" default="Nombre Comppleto" />
		
	</label>
	<g:textField name="nombreComppleto" value="${encargadosInstance?.nombreComppleto}"/>
</div>

