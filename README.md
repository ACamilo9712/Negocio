# Negocio

Negocio es un proyecto backend con framework java SpringBoot creado a partir una arquitetcura por capas que es un 
modelo de desarrollo software en el que el objetivo primordial es la separación (desacoplamiento) de las partes
que componen un sistema software o también una arquitectura cliente-servidor: lógica de negocios, capa de presentación 
y capa de datos. 
Así mismo es importante recalcar que se utilizaron adaptadores para la corrección de la serialización.
Capa repositorio: Capa encargada de la conexión directa a la base de datos.
Capa servicio o negocio: Capa encargada del transporte de información entre el repositorio y el controlador,
así mismo es la capa donde se ejecutan todas las restricciones que posee el negocio. 
Capa Controlador: Es la capa encargada de exponer los servicios REST que se van a ejecutar en la aplicación. 

Así mismo el código cuenta con cada una de las pruebas unitarias en los objetos del dominio, pruebas de integración para cada uno
de los métodos del controlador y pruebas de sistema en el controlador con el fin de evaluar el correcto funcionamiento de 
todo el sistema. 
