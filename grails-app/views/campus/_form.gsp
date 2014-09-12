<%@ page import="learning.jenkis.Campus" %>



<div class="fieldcontain ${hasErrors(bean: campusInstance, field: 'nombre', 'error')} required">
	<label for="nombre">
		<g:message code="campus.nombre.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" required="" value="${campusInstance?.nombre}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: campusInstance, field: 'descripcion', 'error')} required">
	<label for="descripcion">
		<g:message code="campus.descripcion.label" default="Descripcion" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="descripcion" required="" value="${campusInstance?.descripcion}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: campusInstance, field: 'temario', 'error')} required">
	<label for="temario">
		<g:message code="campus.temario.label" default="Temario" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="temario" required="" value="${campusInstance?.temario}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: campusInstance, field: 'horario', 'error')} required">
	<label for="horario">
		<g:message code="campus.horario.label" default="Horario" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="horario" required="" value="${campusInstance?.horario}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: campusInstance, field: 'fechaFinaliza', 'error')} required">
	<label for="fechaFinaliza">
		<g:message code="campus.fechaFinaliza.label" default="Fecha Finaliza" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="fechaFinaliza" precision="day"  value="${campusInstance?.fechaFinaliza}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: campusInstance, field: 'fechaInicio', 'error')} required">
	<label for="fechaInicio">
		<g:message code="campus.fechaInicio.label" default="Fecha Inicio" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="fechaInicio" precision="day"  value="${campusInstance?.fechaInicio}"  />
</div>

