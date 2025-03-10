# ☕ 💠 Documentación de API Example v1.0.0 - 2024
## Descripción del proyecto

Este proyecto tiene base Example, para pruebas y uso en general, Crud al 99%.
 * ✔ Try catcht, handleError messageError, H2. application.yml (revisar)

 * ✔ Logs - Logger, configuracion en application.properties

 * ✔ Spring validation para DTO Crear - libreria Agregar dependencia desde vscode - en pom.xml ctrl+entr en link

 * ✔ Error Handle "ErrorMessage.java"- Formato JsonFormat Fecha con "jackson"

 * ✔ ExampleControllerTest - Junit, Mockito

![img.png](img.png)

## Recursos
El proyecto esta creado con las siguientes tecnologías, las primeras 5 se obtienen
al momento de crear el proyecto.

|  N° | Plugin                | URL                      |
|-----|-----------------------|--------------------------|
|  1  | Spring Web            | https://start.spring.io/ |
|  2  | Spring Data JPA       | https://start.spring.io/ |
|  3  | Spring Boot Dev tools | https://start.spring.io/ |
|  4  | Spring validation     | https://start.spring.io/ |
|  5  | Lombok                | https://start.spring.io/ |
|  6  | H2 Database           | https://start.spring.io/ |

## Estructura 📁
```sh
├─── Controllers
├─── Services (classes & interfaces)
├─── Repositories
├─── Dtos (ExampleCreateDto, ExampleUpdateDto, ExampleFindNameDto)
├─── Entities
└─── Exceptions
```
## Config vsCode 🔧
User Settings.json  ctrl + shif + p
```sh
    "workbench.editor.customLabels.patterns": {
        "**/Entities/**": "${filename}.${extname} 💎",
        "**/entities/**": "${filename}.${extname} 💎",
        "**/Models/**": "${filename}.${extname} 💎",
        "**/models/**": "${filename}.${extname} 💎",
        "**/Dtos/**": "${filename}.${extname} 🔮",
        "**/dtos/**": "${filename}.${extname} 🔮",
        "**/dto/**": "${filename}.${extname} 🔮",
        "**/Controllers/**": "${filename}.${extname} 💊",
        "**/controllers/**": "${filename}.${extname} 💊",
        "**/Exceptions/**": "${filename}.${extname} 🔋",
        "**/exceptions/**": "${filename}.${extname} 🔋",
        "**/Repositories/**": "${filename}.${extname} 💿",
        "**/Repository/**": "${filename}.${extname} 💿",
        "**/Services/**": "${filename}.${extname} 📀",
        "**/Service/**": "${filename}.${extname} 📀",
        "**/service/**": "${filename}.${extname} 📀",
        "**/test/**": "${filename}.${extname} 🔬",
        "**/main/java/**/**Application.java": "${filename}.${extname} - ☕ "
        // "**/src/**/index.html": "${dirname}/${filename}"
        // 🔮 🔰 💠 🏆 🎫 🔥 💧 🌐 🌍 🍚 🎲 🥌 🌄 🌋 🌅 🕋 💳 📮
    },
```
Activar el Linked Editing(para etiquetas HTML)
```
 Ir a preferencias usuario y busca: Linked Editing y activar.
 Activar: Bracket Pair Colorization: Enabled (color a las { } )
 Activar: Bracket Pairs (Colo linea del bloque del cursor)
 Desactivar: breadcrumbs (Opcional)
 Activar: sticky scroll (queda el bloque el nombre actual)
```
En application.properties
```
server.servlet.context-path=/api (funciono)
#spring.data.rest.basePath=/api (no F)
```

## Accesos

Acceso a la base de datos H2 mediante URL:

```sh
url: http://localhost:8080/h2-console/
user: sa
password:123
```
![main.jpg](main.jpg)

## Uso en Postman

### GET
```sh
http://localhost:8080/api/example/all

http://localhost:8080/api/example/find/1

http://localhost:8080/api/example/findbyname?nombre=Lucc
```

### POST (crear Example)
```sh
http://localhost:8080/api/example/create
```
Hay que insertar un JSON para esta petición.

``` json
{
    "name":"Lucc",
    "last_name":"Arias",
    "email": "lucca@tes.com",
    "status": 1,
    "salary":1800.50,
    "published": true
}
```

### POST (editar Example)
```sh
http://localhost:8080/api/example/update/2
```

Hay que insertar un JSON para esta petición.

``` json
{
    "name":"Lola",
    "last_name":"Arias Torres",
    "status": 1,
    "salary":2400.50
}
```

### DELETE
```sh
http://localhost:8080/api/example/delete/2
```
### TEST - Logger
```sh
http://localhost:8080/api/example/test/1

- Ingresar json
{
    "id": 450,
    "name": "Raikod",
    "last_name": "Gamer"
}
```

## Referencias 📚

- * (Handle Excep) https://github.com/bezkoder/spring-boot-one-to-many
- * https://github.com/jaaxteam/resfulapi/
- * https://github.com/jorgemezapaz/AdvancedLevelException
- * (valida & Handle Excep) https://github.com/UnProgramadorNaceOfficial/spring-boot-validations
--*
- * 📹
- * YT - Spring Boot Avanzado - Manejo de excepciones nivel Pro
- * YT - Java :How to set base url for rest in spring boot?(5solution)
- * YT - https://www.youtube.com/watch?v=lGrcZsw-hKQ
- * YT - Spring Boot: Validación de Formularios - Parte 1
- * YT - Manejo de excepciones y validación de solicitudes en Spring Boot API REST Exception Hander y @Valid
- * 
--*
- * 🗃️
- * https://docs.spring.io/spring-framework/reference/web/webmvc/mvc-controller/ann-methods/jackson.html
- * https://anotherdayanotherbug.wordpress.com/2015/01/07/spring-boot-series-autoconfiguracion-de-jackson/
- * https://code.visualstudio.com/docs/getstarted/userinterface
- * https://html-css-js.com/html/character-codes/
- * https://www.indiabix.com/online-test/java-programming-test/ (test java online questions)
- * https://docs.spring.io/spring-boot/docs/2.1.13.RELEASE/reference/html/boot-features-logging.html
- * https://docs.spring.io/spring-boot/reference/features/logging.html
- * https://stackoverflow.com/questions/39158191/default-logging-file-for-spring-boot-application
- * https://armel.soro.io/handling-yaml-in-spring-rest-apis/
- * (Handle Excep) https://reflectoring.io/spring-boot-exception-handling/
- * (Handle Excep) https://www.toptal.com/java/spring-boot-rest-api-error-handling
- * (Handle Excep) https://salithachathuranga94.medium.com/validation-and-exception-handling-in-spring-boot-51597b580ffd

- * (validations) https://www.baeldung.com/spring-boot-bean-validation
- * (validations) https://gustavopeiretti.com/spring-boot-rest-ejemplo-restcontroller-requestbody-valid/
- * (validations) https://reflectoring.io/bean-validation-with-spring-boot/
- * (validations) https://www.baeldung.com/java-bean-validation-not-null-empty-blank
- * (jackson) https://www.baeldung.com/jackson-jsonformat
- * https://www.baeldung.com/jackson-jsonformat
---
