# Proyecto CRUD para transacciones

Aplicación Java que puede ejecutarse desde la línea de comandos. 
Esta aplicación toma varios parámetros de entrada y almacena datos sobre transacciones. 
La aplicación almacena las transacciones en el sistema de archivos debajo de la carpeta donde se encuentra la aplicación. 

## Comenzando 

Colocar la aplicacion(jar) en la carpeta deseada.
Si se desea obtener el codigo de la aplicacion, decargar desde https://github.com/DafneOrtiz/transaction-java-springboot.git 

### Pre-requisitos 

* java 8

### Instalación y puesta en marcha 

*Construyendo el proyecto desde la fuente 

Una vez que el proyecto fue descargado , ejecutar el siguiente comando en cmd, desde la carpeta donde se localiza el proyecto con la finalidad de generar el empaquetado de la aplicación.

```
$ ./mvn clean package

```

*Utilizar el empaquetado adjunto

La aplicación fue empaquetada previamente y se encuentra adjunta en la raíz del proyecto, colocar la aplicación en la carpeta deseada.

*Ejecución de comandos:

Ejecutar los comandos en cmd desde la carpeta donde se localiza la aplicación.

Estructura de los comandos 

```
java -jar transactions-1.0.jar <userid> <command> <transaction> 
```

Comando add

```
java -jar <nombre_aplicacion>.jar <userid> <command> <transaction>

ejemplo :

java -jar transactions-1.0.jar 3 add "{\"amount\":2.4,\"description\":\"primer dato\",\"date\":\"2018-11-28\",\"userId\":3}"

```

Comando list

```
java -jar <nombre_aplicacion>.jar <userid> <command> <transaction>

ejemplo :

java -jar transactions-1.0.jar 3 list

```

Comando show

```
java -jar <nombre_aplicacion>.jar <userid> <command> <transaction>

ejemplo :

java -jar transactions-1.0.jar 3 show "f5c3dd2c-94cb-4669-97e9-bb293823f80f"

```

Comando sum

```
java -jar <nombre_aplicacion>.jar <userid> <command> 

ejemplo :

java -jar transactions-1.0.jar 3 sum

```


## Construido con 

* [Spring boot](https://start.spring.io/) - El framework usado
* [Maven](https://maven.apache.org/) - Manejador de dependencias
* [Jackson](https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core/2.9.9) - Usado para manipulacion de json
* [java 8](https://www.java.com/es/download/) - Lenguaje



## Trabajo a futuro 

Base de datos  SQL 

Propuesta de diagrama entidad relación 


Base de datos  NOTSQL

Propuestas de coleccion 

---
⌨️  por [Dafne Ortiz](www.linkedin.com/in/dafneBaalOrtizAvila) 😊


