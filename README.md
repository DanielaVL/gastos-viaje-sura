# 📊 Prueba Analista de Desarrollo de Tecnología en Formación

**Objetivo**: 
Este proyecto es una API REST desarrollada en Java con Spring Boot que permite gestionar los gastos de viaje de una lista de empleados. Entre sus funcionalidades se incluyen el cálculo del gasto total acumulado entre todos los empleados, la visualización de los gastos individuales por mes, y el cálculo de los totales mensuales por empleado con IVA incluido. Además, la API determina si dichos gastos mensuales son asumidos por el empleado o por **SURA**, según la siguiente lógica:

> Si el total mensual de gastos (incluyendo IVA del 19%) por empleado supera $1.000.000 COP, los gastos son asumidos por el **empleado**. De lo contrario, son asumidos por **SURA**.

</br>

## 🛠️ Tecnologías utilizadas

- Java 17.0.12
- Apache Maven 3.9.10
- Spring Boot (Spring Initializr)
- Junit 5 (para pruebas unitarias)
- Patrón de diseño Modelo - Controlador - Servicio (MCS)
- Postman para pruebas de endpoints

</br>

## 🚀 Cómo ejecutar el proyecto

#### 1. Clonar el repositorio

```bash
git clone https://github.com/DanielaVL/gastos-viaje-sura.git
cd gastos-viaje-sura
``` 

#### 2. Ejecutar el proyecto con Maven

```bash
mvn spring-boot:run
```

Esto levantará la API en `http://localhost:8080`.

</br>

## 🔌 Endpoints disponibles

### `POST /api/gastos/resumen`

**Descripción:**  
Recibe una lista de empleados con sus gastos y devuelve un resumen con el total de gastos por todos los empleados, total general y por mes de cada empleado, gastos con IVA y quién asume cada uno.


### Ejemplo de solicitud (Postman)

```json
POST http://localhost:8080/api/gastos/resumen

[
  {
    "id": 1,
    "nombre": "Adam",
    "gastos": [
      { "fecha": "2021-01-01", "monto": 2000000 },
      { "fecha": "2021-01-02", "monto": 1000000 },
      { "fecha": "2021-02-03", "monto": 500000 }
    ]
  }
]
```
### Ejemplo de respuesta

```json
{
  "totalGeneral": 3500000,
  "empleados": [
    {
        "nombre": "Adam",
        "totalEmpleado": 3500000,
        "resumenMensual": [
            {
                "mes": "01/2021",
                "gastos": [
                    2000000,
                    1000000
                ],
                "totalMes": 3000000,
                "totalConIVA": 3570000.00,
                "quienAsume": "EMPLEADO"
            },
            {
                "mes": "02/2021",
                "gastos": [
                     500000
                ],
                "totalMes": 500000,
                "totalConIVA": 595000.00,
                "quienAsume": "SURA"
            }
        ]
    }
  ]
}
```
</br>

## ✅ Pruebas unitarias
Este proyecto incluye pruebas unitarias para validar la lógica de negocio en diferentes escenarios clave.

#### Casos cubiertos:
✔️ Empleado con varios gastos distribuidos en meses distintos: se valida el cálculo correcto del IVA y la asignación de quién asume el gasto según las reglas del negocio.

✔️ Empleado sin gastos: se verifica que la API no falle cuando un empleado no tiene registros.

✔️ Lista vacía de empleados: se garantiza el manejo correcto cuando no se recibe información.

#### ¿Cómo ejecutar los tests?
```bash
mvn test
```

Deberías ver una salida como:

```yaml
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

</br>

## 📁 Estructura del proyecto

```lua
src/
├── main/
│   ├── java/com/prueba/analista/
│   │   ├── controller/         --> API REST
│   │   ├── service/            --> Lógica de negocio
│   │   ├── model/              --> Modelos de dominio
│   │   └── dto/                --> Objetos de respuesta
│   └── resources/              
├── test/
│   └── java/com/prueba/analista/
│       └── service/            --> Pruebas unitarias
```

</br>

> [!IMPORTANT]
> **Nota 1:** Asegúrate de tener Java 8 o superior y Maven instalados en tu máquina para ejecutar el proyecto correctamente. Puedes verificar la versión de Java con `java -version` y la de Maven con `mvn -v`.
>
> **Nota 2:** Muchas gracias por la oportunidad de presentar esta prueba técnica. Fue una experiencia valiosa.

## 👩🏽‍💻 Autora

**Daniela Vásquez Londoño**  
📧 Correo: [dvasquezl@sura.com.co](mailto:dvasquezl@sura.com.co)  
🔗 GitHub: [https://github.com/DanielaVL](https://github.com/DanielaVL)
