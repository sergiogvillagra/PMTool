plugins {
    // Aplica el plugin de aplicación si necesitas definir una clase principal
    application
}

application {
    // Define la clase principal para la aplicación
    mainClass.set("org.pmtool.app.Main")
}

// Dependencias específicas solo para este módulo (si las hay)
dependencies {
    // Ejemplo: dependencias específicas que solo necesita 'app'
    // implementation("alguna:dependencia:específica")
}

// Configuraciones específicas solo para este módulo (si las hay)
tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}
