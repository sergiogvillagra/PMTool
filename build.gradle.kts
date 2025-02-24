plugins {
    // Define el plugin de Java para compilar proyectos en Java
    id("java")
    // Plugin para verificar estándares de código Java
    id("checkstyle")
}

repositories {
    // Usa Maven Central para las dependencias
    mavenCentral()
}

allprojects {
    repositories {
        // Todas las dependencias se resuelven usando Maven Central
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "checkstyle")

    dependencies {
        // Dependencia de JUnit 5 para pruebas
        testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
    }

    tasks.withType<Test> {
        // Configura las pruebas para usar JUnit Platform
        useJUnitPlatform()
    }

    // Configuración de Checkstyle
    checkstyle {
        toolVersion = "10.12.5"  // Versión de Checkstyle
        configFile = rootProject.file("config/checkstyle/checkstyle.xml")
        isIgnoreFailures = true  // No falla el build si hay errores de estilo
        isShowViolations = true  // Muestra las violaciones en la consola
    }
}
