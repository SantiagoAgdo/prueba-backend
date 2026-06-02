# Backend - Prueba Técnica Fullstack

Este repositorio contiene la implementación del Backend para la prueba técnica, construido con Spring Boot y Java 8.

## Consideraciones de Arquitectura
Para efectos de rapidez en la ejecución de la prueba, no se utilizó una capa de servicio (Service layer). La lógica de negocio y el acceso a datos se manejaron directamente en el controlador (`PersonCtrl.java`). Aunque se reconoce que esto no es una buena práctica en aplicaciones empresariales a gran escala, se aplicó el principio KISS para disminuir los tiempos de entrega tal como fue solicitado.

## Requisitos Previos
- Java 8
- Maven
- MySQL 8 o superior

## Pasos de Ejecución

### 1. Base de Datos
Es necesario tener MySQL corriendo localmente.
Se debe crear la base de datos `bd_agudelo` y su respectiva tabla. Puedes utilizar el script proporcionado (`bd/script_creacion_bd.sql`) de la raíz original del proyecto, o crearla manualmente.

### 2. Levantar la Aplicación
1. Abrir una terminal en la raíz de este proyecto (`backend`).
2. Ejecutar el proyecto con Maven:
   ```bash
   mvn spring-boot:run
   ```
3. El servidor iniciará en el puerto 8080.
4. Asegúrate de configurar correctamente tu contraseña de MySQL en el archivo `src/main/resources/application.properties` (por defecto está sin contraseña o con root).

La API REST estará disponible en `http://localhost:8080/api/persons`.
