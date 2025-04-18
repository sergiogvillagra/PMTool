# PMTool - Herramienta de Gestión de Proyectos

[![Java CI with Gradle](https://github.com/sergiogvillagra/PMTool/actions/workflows/build-and-test.yml/badge.svg)](https://github.com/sergiogvillagra/PMTool/actions/workflows/build-and-test.yml)

PMTool es una aplicación Java para la gestión de proyectos que implementa la metodología EDT (Estructura de Desglose de Trabajo). Permite la creación y gestión de proyectos, actividades y subactividades con una estructura jerárquica.

## Instrucciones para Estudiantes

### Crear tu Repositorio Privado

Para trabajar en este proyecto como parte del curso, debes crear tu propio repositorio privado. Sigue estos pasos:

1. **Crear un nuevo repositorio privado en GitHub**:
   - Ve a [GitHub](https://github.com)
   - Haz clic en el botón "+" y selecciona "New repository"
   - Nombra tu repositorio (ejemplo: `PMTool-NumeroDePadron`)
   - Selecciona "Private"
   - NO inicialices el repositorio con README, .gitignore o licencia
   - Haz clic en "Create repository"

2. **Clonar el repositorio original y configurar tu repositorio privado**:
```bash
# Clonar el repositorio original en una carpeta temporal
git clone https://github.com/sergiogvillagra/PMTool.git PMTool-temp

# Entrar al directorio
cd PMTool-temp

# Eliminar la conexión con el repositorio original
git remote remove origin

# Agregar tu repositorio privado como nuevo origin
git remote add origin https://github.com/TU-USUARIO/PMTool-NumeroDePadron.git

# Subir el código a tu repositorio privado
git push -u origin main

# Opcional: Volver al directorio padre y renombrar la carpeta
cd ..
mv PMTool-temp PMTool
```

3. **Verificar la configuración**:
```bash
git remote -v
# Debería mostrar solo tu repositorio privado como origin
```

### Dar Acceso a los Docentes

Para que cada docente pueda revisar el trabajo:

1. En GitHub, ve a tu repositorio
2. Click en "Settings" → "Collaborators"
3. Click en "Add people"
4. Agrega el usuario de los docentes: `sergiogvillagra`,`gdebenedetti`,`tbruno`,`leof777`

## Requisitos Previos

### Java Development Kit (JDK) 21

#### Windows
1. Descarga OpenJDK 21 desde [Adoptium](https://adoptium.net/)
2. Ejecuta el instalador
3. Configura la variable de entorno JAVA_HOME:
   ```batch
   setx JAVA_HOME "C:\Program Files\Java\jdk-21"
   setx PATH "%PATH%;%JAVA_HOME%\bin"
   ```

#### macOS
Usando Homebrew:
```bash
brew install openjdk@21
```
Configura las variables de entorno en `~/.zshrc` o `~/.bash_profile`:
```bash
export JAVA_HOME=$(/usr/libexec/java_home -v 21)
export PATH=$JAVA_HOME/bin:$PATH
```

#### Linux
Ubuntu/Debian:
```bash
sudo apt update
sudo apt install openjdk-21-jdk
```

Fedora:
```bash
sudo dnf install java-21-openjdk-devel
```

### Gradle

#### Windows
1. Descarga Gradle desde [gradle.org](https://gradle.org/releases/)
2. Extrae el archivo ZIP
3. Configura las variables de entorno:
   ```batch
   setx GRADLE_HOME "C:\Gradle\gradle-8.12.1"
   setx PATH "%PATH%;%GRADLE_HOME%\bin"
   ```

#### macOS
```bash
brew install gradle
```

#### Linux
Ubuntu/Debian:
```bash
sudo apt install gradle
```

Fedora:
```bash
sudo dnf install gradle
```

## Compilar, correr, testear

1. Compilar el proyecto:
```bash
./gradlew clean build
```

2. Ejecutar los tests:
```bash
./gradlew test
```

3. Ejecutar la aplicación:
```bash
./gradlew run
```

## Estructura del Proyecto

```
org.pmtool
├── app
│   └── Main.java           # Punto de entrada de la aplicación
├── model
│   └── Proyecto.java       # Clase de dominio, incluye la clase Actividad
└── manager
    ├── GerentePortafolio.java  # Gestiona portafolios
    └── GerenteProyecto.java    # Gestiona proyectos
```

## Características

- Creación y gestión de proyectos
- Estructura jerárquica de actividades (EDT)
- Planificación de fechas de inicio y fin
- Gestión de presupuesto y horas estimadas
- Sistema de numeración EDT automático

## Desarrollo

### Ejecutar Tests
```bash
./gradlew test
```

### Generar Reporte de Tests
Los reportes se generan en:
- HTML: `app/build/reports/tests/test/index.html`
- XML: `app/build/test-results/test`

## Integración Continua

El proyecto utiliza GitHub Actions para ejecutar automáticamente los tests y verificar la compilación en cada push y pull request:

- Compila el proyecto
- Ejecuta todos los tests
- Genera y almacena reportes de tests
- Verifica la integración en Java 21

Puedes ver el estado de las ejecuciones en la pestaña "Actions" del repositorio o haciendo clic en el badge de estado al principio de este README.

## Solución de Problemas

### Error: JAVA_HOME no está configurado
Asegúrate de que JAVA_HOME esté configurado correctamente según tu sistema operativo.

### Error: Gradle no encuentra Java
Verifica que JDK 21 esté instalado y configurado en el PATH.

### Error: Permission denied al ejecutar gradlew
En sistemas Unix:
```bash
chmod +x gradlew
```

## Licencia

Este proyecto está licenciado bajo la Licencia MIT - ver el archivo [LICENSE](LICENSE) para más detalles.

FIUBA/Ingeniería de Software I/Métodos y Modelos en Ingeniería de Software I/Análisis de la Información
