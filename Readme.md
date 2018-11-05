# Este proyecto se compone de dos módulos:

## Plugin de maven
+ Se configura como plugin con la URL de envio de información
+ Extrae las dependencias (con filtro) de pom.xml
+ Envia las dependencias (y sus versiones) al servicio REST

## Servicio REST
+ recibe info de dependencias
	artifact (groupId, artifactId, version, ¿environment like branch?, ...)
		dependencies
			(groupId, artifactId, version)
+ Procesa las dependencias y crea las relaciones ¿en BBDD?
+ Muestra las dependencias en formato JSON
+ Muestra las dependencias en formato HTML
