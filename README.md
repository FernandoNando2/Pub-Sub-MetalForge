## Proyecto Pub-Sub con Spring Boot

Este proyecto implementa un patrón de comunicación **Publish-Subscribe (Pub-Sub)** utilizando Spring Boot, con endpoints REST para el publicador y el suscriptor. No se utiliza JMS, sino que se basa en llamadas HTTP para la comunicación entre componentes.

### Estructura del Proyecto

#### Suscriber
- **dto**:
  - `Ack.java`
  - `PurchaseRequest.java`
- **service**:
  - `Suscriber.java`

#### Publisher
- **async**:
  - `ResponseThread.java`
  - `Task.java`
- **dto**:
  - `Ack.java`
  - `Hub.java`
  - `PurchaseRequest.java`
- **service**:
  - `Publisher.java`

### Clases Principales

- **Suscriber.java**: Expone un endpoint para recibir respuestas desde el publicador.
- **Publisher.java**: Proporciona endpoints para registrar suscriptores y recibir solicitudes de compra.
- **Task.java**: Responsable de enviar respuestas a todos los suscriptores registrados.
- **ResponseThread.java**: Maneja la ejecución asíncrona de las tareas de envío de respuestas.

### Endpoints REST

#### Publisher

- **POST** `/publisher/hub`
  - Registra un suscriptor. Recibe un objeto `Hub` con `callback` (URL de respuesta) y `query` (consulta opcional).
  - **Respuesta**: Objeto `Ack` con un código y una descripción.

- **POST** `/publisher/PurchaseRequest`
  - Recibe una solicitud de compra y la procesa.
  - **Respuesta**: Objeto `Ack` indicando que la solicitud ha sido recibida.

#### Suscriber

- **POST** `/listener/responsePurchase`
  - Recibe respuestas de solicitudes procesadas desde el publicador.
  - **Respuesta**: Objeto `Ack` confirmando la recepción de la respuesta.

### Ejemplo de Solicitudes

#### Registro de un Suscriptor
```bash
POST /publisher/hub
Content-Type: application/json

{
  "callback": "http://localhost:8081/listener/responsePurchase",
  "query": "some query"
}
```

#### Envío de una Solicitud de Compra
```bash
POST /publisher/PurchaseRequest
Content-Type: application/json

{
  "provider": "Steel Supplier",
  "steelQuality": "A36",
  "tons": 50,
  "price": 5000.0,
  "isUrgent": false
}
```

#### Recepción de Respuesta en el Suscriptor
- La respuesta se envía automáticamente al endpoint `callback` registrado.

### Notas

- El publicador almacena los `callbacks` de los suscriptores en memoria. Esta funcionalidad se puede ampliar para persistencia en base de datos.
- `ResponseThread` simula el procesamiento asíncrono de tareas.
