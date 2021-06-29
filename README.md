# Desafio
Trabajo Desafio Intercorp


El reto consta de hacer una API Rest documentada en Swagger con tres Microservicio desarrollados en JAVA con Spring-boot los cual ofrecen la funcionalidad de:
_Crear e insertar un cliente en la base de datos (/creacliente).
_Listar todos los clientes con todos los datos y adicionalmente con su fecha probable de muerte (/listclientes).
_Calcular promedio de edad y desviación estándar entre las edades de todos los clientes (/kpideclientes).

## Tecnologias

_SpringBoot	
_Maven 3
_JAVA 11
_Spring MVC architecture
_RestController
_H2 Database y JPARepository 
_Swagger
_ModelMapper
_Heroku

## Detalle de los Endpoints

La aplicacion se encuentra deployada en www.heroku.com

### Como utilizar los Endpoints

El alta de cliente se hace mediante el Endpoint https://desafio-intercorp.herokuapp.com/client/creacliente con el siguiente formato de Body:
```js
{
    "firstName":"nombre",
    "lastName":"apellido",
    "age": 20,
    "birthDate":"2011-12-28"
}
```

El listado de todos los clientes con su fecha probable de muerte se hace mediante el Endpoint https://desafio-intercorp.herokuapp.com/client/listclientes.

La informacion de promedio de edad y desviación estándar de los clientes se obtiene mediante el Endpoint https://desafio-intercorp.herokuapp.com/client/kpideclientes.

**Para consumir los difrentes Endpoints sera necesario utilizar Postman o alguna tecnologia similar de testeo de APIRest.**

## Aclaraciones

_La Api se realizo respetando al maximo lo solicitados en el documento. Se utilizo los nombres solicitados tanto para los endpoints como para los dados a guardar en la base de datos (tabla y columnas), internamente, los nombres estan en Ingles.

_La version de springboot no es la ultima por cuestiones de compatibilidad con el resto de las tecnologias.

_La constante utlizada para guardar el dato de espectativa de vida (LIFE_EXPECTANCY) se realizo de ese modo a fines practico, lo ideal seria externalizarla o guardarla 
en la base de datos para poder actualizar si en el futuro se produce algun cambio.

## Observaciones

_Es redundante y poco eficiente utilizar una columna "EDAD" ya que con la fecha de nacimientos se puede obtener esta informacion y ademas seria necesario actualizarla diariamente. Igualmente fui incluida como se solicita en el documento.

_El ClientService no lo hice orientado a interfaces ya que la practica/listclientes me ha llevado a prescindir de esta practica por el hecho de que una actualizacion de la misma hace necesario la actualizacion de todas las clase que la implementan.
