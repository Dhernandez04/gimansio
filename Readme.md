# Gimnasio app
_Este es un proyecto personal que se encuentra en fase de desarrollo, esta enfocado en el manejo y la gestion de clientes y servicios proporsionados por gimnasios, actualmente cuenta con las siguiente caracteristicas:._
_-Registro de usuarios_
_-Envio de credenciales via email_
_-Subida de imagenes_
_-Registro de servicios_
_-Autenticacion de usuarios_ 

_Si deseas ver el repositorio de front end accede a este enlace https://github.com/Dhernandez04/gimnasio-angular._

## Comenzando 

_Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos de desarrollo y pruebas._

Ejecuta el siguiente comado en una terminal del sistema operativo

```
git clone https://github.com/Dhernandez04/gimansio.git
```



### Pre-requisitos 

```
- Java jdk 17 o version superior
- Liquibase
- Mysql
- Git
- tener una base de datos creada en mysql.
```
### Instalación ??

_Deberas modificar el siguiente archivo de propiedades para realizar la configuracion de la base de datos, dejar la propiedad spring.datasource.password vacia si su usuario de base de datos no tiene asignada una contraseña._

_aplication-dev.properties_

```
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/gimnasio_db
spring.datasource.username=root
spring.datasource.password=CAMBIAME
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
#spring.jpa.show-sql: true
server.port=${PORT:8003}
```

_Ejecutar el siguiente comando para realizar la compilacion del proyecto._
_Ubicarse en la direccion raiz y ejecutar el siguient comando._

```
gradle build
```
## Despliegue ??

_Acede a la siguiente ruta del proyecto y ejecuar el siguiente comando._

```
cd C:\Users\tu_usuario\ruta_ubicacion\gimnasio\build\libs

java -jar build/libs/gimnasio-1.0.jar --spring.profiles.active=prod
```

## Construido con ???

_Herramientas utilizadas_

* [Spring boot](https://spring.io/) - El framework web usado
* [Gradle](https://gradle.org/) - Manejador de dependencias
* [Liquibase](https://rometools.github.io/rome/) - Usado para generar migrasiones de base de datos

## Autores ??

_Menciona a todos aquellos que ayudaron a levantar el proyecto desde sus inicios_

* **Deimer Hernandez** - *Trabajo Inicial* - [Dhernandez04](https://github.com/Dhernandez04/gimansio)


---
Relizado con dedicación por [Dhernandez04](https://github.com/Dhernandez04/gimansio) 