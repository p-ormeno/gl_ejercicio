## Instrucciones
-Importar proyecto como "Proyecto gradle" y esperar a que se descarguen las dependencias necesarias. 
-Abrir ventana de comandos desde la ruta de los fuentes del proyecto y ejecutar el siguiente comando para desplegar la aplicación:
	./gradlew bootRun
-Aplicación se levantara por defecto en puerto 8090

#### Para utilizar los endpoints de la aplicacion, se recomienda el uso de un cliente de Api como Postman

### Agregar Usuario (método POST)
Para agregar un usuario se debe acceder con el cliente de API a la siguiente url: 
	http://localhost:8090/user/register 
y enviar JSON con el siguiente formato: 
{"name" : "Juan Rodriguez", "email" : " juan@rodriguez.com", "password" : "Hunter22", "phones" : [ {"number" : "1234567" ,"citycode" : "1" ,"contrycode" : "57"}]}



## Diagramas
Los diagramas se encuentran en la raiz del proyecto
	- Diagrama de componentes = diagrama_componente.png
	- Diagrama de secuencia = diagrama_secuencia.png
