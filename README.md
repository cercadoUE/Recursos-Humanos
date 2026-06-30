# Recursos Humanos

Sistema de escritorio para la gestión de recursos humanos desarrollado en **Java SE 23** con **Swing** y **Apache Ant** (NetBeans IDE).

## Funcionalidades

- **Autenticación** de usuarios contra SQL Server
- **Gestión de empleados**: agregar, editar, eliminar y visualizar
- **Módulos de consulta**: Licencias, Conceptos y Planilla de Remuneraciones
- **Filtros de seguridad** en campos de entrada (prevención de inyección SQL)
- **Selector de temas** FlatLaf (Claro, Oscuro, Darcula, IntelliJ)

## Requisitos

- Java 23+
- Apache Ant
- Microsoft SQL Server en `localhost:1433`
- Base de datos `RRHH` con las tablas: `Usuarios`, `Empleados`, `Cargo`, `Oficina`, `Regimen_Laboral`, `Licencias`, `Concepto`, `Planilla_Remuneraciones`

## Dependencias externas

Las siguientes librerías deben estar disponibles en el classpath:

| Librería | Propósito |
|---|---|
| `mssql-jdbc-12.10.0.jre8.jar` | Driver JDBC para SQL Server |
| `flatlaf-3.6.jar` | Temas modernos FlatLaf |
| `jcalendar-1.4.jar` | Selector de fechas |
| `jgoodies-common-1.2.0.jar` | Utilidades de layout |
| `jgoodies-looks-2.4.1.jar` | Look & Feel alternativo |

Las librerías se encuentran en la carpeta `lib/`.

## Ejecución

```bash
ant jar
java -jar dist/Recursos_Humanos.jar
```

La clase principal es `Visual.login`.

## Estructura del proyecto

```
src/
├── Visual/               # Interfaces gráficas (Swing JFrames)
│   ├── login.java
│   ├── RecursosHumanos.java
│   ├── Agregar_Empleado.java
│   ├── Eliminar.java
│   └── Temas.java
├── recursos_humanos/      # Capa de lógica y datos
│   ├── Conexion.java      # Conexión a SQL Server
│   ├── ValidarLogin.java  # Validación de credenciales
│   └── SeguridadCampos.java # Filtro de entrada
└── Imagenes/              # Recursos gráficos (PNG)
```

## Tecnologías

- Java 23
- Swing / AWT
- Apache Ant (NetBeans)
- Microsoft SQL Server (JDBC)
- FlatLaf (temas visuales)
- JCalendar
- JGoodies

## Licencia

Este proyecto fue desarrollado como parte del curso de Programación Orientada a Objetos.
