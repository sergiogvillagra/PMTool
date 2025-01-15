plugins {
    // Define el plugin de Java para compilar proyectos en Java
    id("java")
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

    dependencies {
        // Dependencia de JUnit 5 para pruebas
        testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
    }

    tasks.withType<Test> {
        // Configura las pruebas para usar JUnit Platform
        useJUnitPlatform()
    }
}
