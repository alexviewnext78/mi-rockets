---
description: Best practices and coding guidelines for Java projects. Clean 
code, proper naming conventions, and file handling practices are emphasized.
applyTo: '**/*.java' # when provided, instructions will automatically be added to the request context when the pattern matches an attached file
---

# java.instructions.md

## Propósito
Este archivo define las instrucciones específicas para el desarrollo en Java dentro de este proyecto.

## Convenciones de código
- Usar **Java 17** como versión mínima.
- Seguir el estándar de nombres:
  - Clases: `CamelCase` (ej. `MiClaseEjemplo`)
  - Métodos y variables: `camelCase` (ej. `calcularTotal`)
  - Constantes: `UPPER_CASE` (ej. `MAX_VALUE`)
- Indentación: 4 espacios, sin tabuladores.
- Métodos pequeños: Un método debe hacer una sola cosa a un único nivel de abstracción.
- Responsabilidad única: Cada método debe tener una única responsabilidad y evitar la duplicación innecesaria. 
- Debe de cumplircon los estandares de seguridad y buenas prácticas de desarrollo de software, incluyendo la validación de entradas y el manejo adecuado de excepciones.
- Debe cumplir con los principios de diseño SOLID y patrones de diseño cuando sea apropiado.
- Evitar dependencias innecesarias y código repetitivo.
- Debe cumplir con los estándares de documentación y comentarios claros para facilitar la comprensión del código.
- Debe seguir las mejores prácticas de desarrollo de software, incluyendo la modularidad, la escalabilidad y la mantenibilidad del código.
- Debe cumplir con los estándares de accesibilidad y usabilidad para garantizar que el software sea fácil de usar y accesible para todos los usuarios.
- Debe cumplir con los estándares de rendimiento y eficiencia para garantizar que el software funcione de manera óptima y rápida.
- Debe cumplir con los estándares de compatibilidad y portabilidad para garantizar que el software funcione en diferentes plataformas y entornos.
- Debe de cumplir con los estandares de https://top10.owasp.org/2025/es/


## Manejo de ficheros
- Todos los ficheros deben estar en la carpeta `src/main/java`.
- Evitar rutas absolutas; usar `Paths.get()` o `ClassLoader` para acceder a recursos.
- Cerrar siempre streams en un bloque `try-with-resources`.

## Ejemplo de lectura de fichero
```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeerFichero {
    public static void main(String[] args) {
        String ruta = "datos.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el fichero: " + e.getMessage());
        }
    }
}
