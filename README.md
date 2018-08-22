# problemaMLJava
problema de los planetas

Se ha utilizado spring boot para la generacion de los servicios. El servidor corre por defecto en el puerto 8080

La base de datos utilizada es H2 (configurada para uso en memoria). La misma se popula mediante un tarea programada, la cual es ejecutada cada 10 segundos (aunque la insercion solo se realiza si los datos no se encuentran ya insertados).

Los endpoints disponibles son los siguientes:

GET api/clima?dia=1
GET api/climaFromDb?dia=1
GET api/clima/extended?dia=1
GET api/clima/simulacionDiezAnios
GET api/clima/vulcano/{dia}
GET api/clima/betasoide/{dia}
GET api/clima/ferengi/{dia}

El unico endpoint que extrae datos de la DB es climaFromDb, el resto lo calcula en el instante.

Nota: Hay un caso en el que se informa que el clima es indeterminado. Este caso se da cuando los tres planetas forman un triangulo que no contiene al sol en su interior. En el problema no se establece cual es el estado del clima en este caso, por lo que se lo denomino "indeterminado".
Nota 2: La mayoria de las cuentas se han realizado utilizando redondeo a numeros enteros
