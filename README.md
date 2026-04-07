# 🏍️ MotoAmigo

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![NetBeans](https://img.shields.io/badge/NetBeans-1B6AC6?style=for-the-badge&logo=apache-netbeans-ide&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white)
![MapBox](https://img.shields.io/badge/Mapbox-000000?style=for-the-badge&logo=mapbox&logoColor=white)

> Plataforma que conecta emprendedores locales con repartidores independientes, facilitando el registro, seguimiento y cierre de entregas a domicilio. Una alternativa accesible a servicios como Uber Eats, pensada para quienes inician su negocio.

---

## 🧩 Contexto del proyecto

Muchos emprendedores y repartidores se organizan hoy en día a través de grupos de WhatsApp y redes sociales, lo que genera desorganización, falta de trazabilidad y desconfianza. **MotoAmigo** nace para resolver eso con un sistema estructurado de gestión de entregas.

---

## 🚀 Funcionalidades principales

| Módulo | Descripción |
|---|---|
| 📦 Registrar Solicitud | El emprendedor registra una solicitud de entrega con origen, destino y tipo de paquete |
| 🗺️ Consultar Ruta | Integración con Mapbox para calcular ruta, distancia y tiempo estimado |
| 📡 Publicar a Repartidores | Identifica repartidores disponibles en el radio y publica la solicitud |
| 📍 Seguimiento en Tiempo Real | Rastreo en vivo del repartidor desde que acepta hasta la entrega |
| ✅ Cerrar Pedido | El repartidor marca la entrega como completada y el sistema cierra el pedido |

---

## 🏗️ Arquitectura

El proyecto sigue un **modelo arquitectónico en capas**, donde cada funcionalidad del caso de uso es un subsistema (proyecto Maven) independiente:

```
MotoAmigo/
├── RegistrarSolicitud/
├── ConsultarRuta/
├── PublicarRepartidores/
├── SeguimientoTiempoReal/
└── CerrarPedido/
```

Cada subsistema contiene:

```
src/
└── mx/itson/motoamigo/
    ├── presentacion/     → JFrame / JDialog (Swing)
    ├── casouso/          → Coordinación del flujo
    ├── negocio/          → Interfaz + implementación (mock)
    ├── persistencia/     → Interfaz DAO + implementación (mock)
    └── dto/              → Objetos de transferencia de datos
```

---

## 👥 Equipo

| Nombre | ID ITSON |
|---|---|
| José Joaquín Tristá Rosales | 00000262715 |
| Carmen Andrea Lara Osuna | 00000262726 |
| Jesus Omar Lopez Cosío | 00000268367 |
| Xiomara Alejandra Hernández Arzola | 00000225585 |
| Roberto Meza | — |

---

## 🛠️ Tecnologías

- **Java** con **Apache Maven**
- **Swing** para interfaces gráficas
- **NetBeans IDE**
- **Mapbox API** para cálculo de rutas y seguimiento
- Objetos **mock/dummy** para simulación de negocio y persistencia

---

## 📥 Cómo clonar el proyecto

```bash
git clone https://github.com/Xiomiau/MotoAmigo.git
cd MotoAmigo
```

Abre cada carpeta como proyecto Maven independiente en NetBeans:
**File → Open Project** → selecciona la carpeta del módulo que quieras.

---

## 📋 Información académica

| | |
|---|---|
| **Materia** | Diseño de Software |
| **Profesor** | Christian Gibrán Durán Solano |
| **Institución** | Instituto Tecnológico de Sonora (ITSON) |
| **Asignación** | Avance Proyecto 4 — Asignación 13 |

---

<p align="center">Hecho con 💙 en Ciudad Obregón, Sonora</p>
