<!doctype html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Welcome to Grails</title>
		<style type="text/css" media="screen">
			#status {
				background-color: #eee;
				border: .2em solid #fff;
				margin: 2em 2em 1em;
				padding: 1em;
				width: 12em;
				float: left;
				-moz-box-shadow: 0px 0px 1.25em #ccc;
				-webkit-box-shadow: 0px 0px 1.25em #ccc;
				box-shadow: 0px 0px 1.25em #ccc;
				-moz-border-radius: 0.6em;
				-webkit-border-radius: 0.6em;
				border-radius: 0.6em;
			}

			.ie6 #status {
				display: inline; /* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
			}

			#status ul {
				font-size: 0.9em;
				list-style-type: none;
				margin-bottom: 0.6em;
				padding: 0;
			}

			#status h1 {
				text-transform: uppercase;
				font-size: 1.1em;
				margin: 0 0 0.3em;
			}

			#page-body {
				margin: 2em 1em 1.25em 18em;
			}

			h2 {
				margin-top: 1em;
				margin-bottom: 0.3em;
				font-size: 1em;
			}

			p {
				margin: 0.25em 0;
			}

			#controller-list ul {
				list-style-position: inside;
			}

			#controller-list li {
				list-style-position: inside;
				margin: 0.25em 0;
			}

			@media screen and (max-width: 480px) {
				#status {
					display: none;
				}

				#page-body {
					margin: 0 1em 1em;
				}

				#page-body h1 {
					margin-top: 0;
				}
			}
		</style>
	</head>
	<body>
		<a href="#page-body" class="skip"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div id="status" role="complementary">
			<h1>¡Welcome!</h1>
		    <img src="http://www.brainscornerdigital.es/revista/wp-content/uploads/2014/06/libros.png"/>
			<h1>Go , go , go</h1>

				<p>Todos somos muy ignorantes. Lo que ocurre es que no todos ignoramos las mismas cosas.</p><br>
                <p>Albert Einstein</p>

		</div>
		<div id="page-body" role="main">
			<h1>Campus</h1>
			<p><img src="http://www.claro.com.ar/wps/wcm/connect/ar/19b6d388-e63a-4ebe-a544-51ecc7dd033f/de-llamadas_destacado_conferencia.png?MOD=AJPERES&CACHEID=19b6d388-e63a-4ebe-a544-51ecc7dd033f"/></p>

			<div id="controller-list" role="navigation">
				<h2>Menu:</h2>
				<ul>

						<li class="controller"><g:link controller="campus">Campus</g:link></li>
                    <li class="controller"><g:link controller="encargados">Encargados</g:link></li>
                    <li class="controller"><g:link controller="agendaCampus">Agenda</g:link></li>
                    <li class="controller"><g:link controller="inscritos">Inscribirse a algún Campus</g:link></li>
				</ul>
			</div>
		</div>
	</body>
</html>
