# Documentación de API Example v1.0.0
## Descripción del proyecto

Este proyecto tiene base Example, para pruebas y uso en general, Crud al 99%

![img.png](img.png)

## Recursos
El proyecto esta creado con las siguientes tecnologías, las primeras 5 se obtienen
al momento de crear el proyecto.

| Plugin                | URL                      |
|-----------------------|--------------------------|
| Spring Web            | https://start.spring.io/ |
| Spring Data JPA       | https://start.spring.io/ |
| Spring Boot Dev tools | https://start.spring.io/ |
| Lombok                | https://start.spring.io/ |
| H2 Database           | https://start.spring.io/ |

## Estructura 📁

# Controllers
# Services (classes & interfaces)
# Repositories
# Entities

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

### POST (crear Huesped)
```sh
http://localhost:8080/api/example/create
```
Hay que insertar un JSON para esta petición.

``` json
{
    "name":"Lucc",
    "last_name":"Arias",
    "status": 1,
    "salary":1800.50
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

## Referencias 📚

- * 
