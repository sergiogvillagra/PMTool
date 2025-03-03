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

        // Dependencias de Cucumber
        testImplementation("io.cucumber:cucumber-java:7.14.0")
        testImplementation("io.cucumber:cucumber-junit:7.14.0")
        testImplementation("io.cucumber:cucumber-junit-platform-engine:7.14.0")
        
        // Necesario para ejecutar Cucumber con JUnit 5
        testImplementation("org.junit.platform:junit-platform-suite-api:1.10.0")
        testImplementation("org.junit.platform:junit-platform-suite:1.10.0")
        testRuntimeOnly("org.junit.platform:junit-platform-suite-engine:1.10.0")
        testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    }

    tasks.withType<Test> {
        useJUnitPlatform()
        testLogging {
            events("passed", "skipped", "failed")
        }
        reports {
            html.required.set(true)
        }
    }

    tasks.register<Test>("cucumberTest") {
        useJUnitPlatform {
            includeTags("cucumber")
        }
        description = "Ejecuta solo los tests de Cucumber"
        group = "verification"

        include("**/*CucumberTest*")
    
        testLogging {
            events("passed", "skipped", "failed")
            showStandardStreams = true
        }
        
        reports {
            html.required.set(true)
        }
        
        systemProperty("cucumber.glue", "org.pmtool.steps")
        systemProperty("cucumber.plugin", "pretty,json:build/reports/cucumber/cucumber.json")
        systemProperty("cucumber.features", "src/test/resources/features/")
        systemProperty("cucumber.publish.quiet", "true")
        
        // Asegurarse de que los tests de Cucumber se ejecuten
        testClassesDirs = files(project.sourceSets.getByName("test").output.classesDirs)
        classpath = project.sourceSets.getByName("test").runtimeClasspath
    }

    // Configuración de Checkstyle
    checkstyle {
        toolVersion = "10.12.5"  // Versión de Checkstyle
        configFile = rootProject.file("config/checkstyle/checkstyle.xml")
        isIgnoreFailures = true  // No falla el build si hay errores de estilo
        isShowViolations = true  // Muestra las violaciones en la consola
    }
}
