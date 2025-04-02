# Actualizar repositorio

## Guía para actualizar tu repositorio personal privado con los cambios del repositorio original

En el ejercicio 1 crearon un repositorio privado en su cuenta de GitHub con una copia del contenido del repositorio original (`https://github.com/sergiogvillagra/PMTool/`).

Cuando se actualiza el código en el repositorio original, se pueden traer esos cambios a su propio repositorio siguiendo estos pasos:

### Pasos a seguir

1. **Abrir la terminal y ubicarse en el directorio de tu repositorio local**  
   Asegúrate de estar en la carpeta donde iniciaste tu repositorio local. Usa este comando:

   ```bash
   cd /ruta/a/mi/PMTool-padron
   ```

2. **Verificar el estado de tu repositorio**  
   Antes de traer los cambios, revisa que no tengas modificaciones sin guardar. Usa:

   ```bash
   git status
   ```

   Si hay cambios locales (archivos modificados), guárdalos con un *commit*:

   ```bash
   git add .
   git commit -m "Guardando mis cambios locales"
   ```

3. **Vincular el repositorio original como un remote**  
   Para poder acceder a los cambios del repositorio original, agrégalo como un *remote* llamado `upstream`. Este paso solo lo haces **una vez**:

   ```bash
   git remote add upstream https://github.com/sergiogvillagra/PMTool.git
   ```

   Verifica que se agregó correctamente con:

   ```bash
   git remote -v
   ```

   Deberías ver tanto `origin` (tu repositorio privado) como `upstream` (el original).

4. **Traer los cambios del repositorio original**  
   Descarga las actualizaciones del repositorio original con:

   ```bash
   git fetch upstream
   ```

5. **Integrar los cambios en tu rama local**  
   Fusiona los cambios de la rama principal del repositorio original (`main`) en tu rama local:

   ```bash
   git merge upstream/main
   ```

   - Si no hay conflictos, los cambios se aplicarán automáticamente.  
   - Si hay conflictos (por ejemplo, si modificaste los mismos archivos que se actualizaron), Git te lo indicará. Resuelve los conflictos editando los archivos manualmente, luego confirma los cambios con:

   ```bash
   git add <archivos-resueltos>
   git commit
   ```

6. **Subir los cambios a tu repositorio privado en GitHub**  
   Una vez integrados los cambios, actualiza tu repositorio remoto en GitHub (`origin`) con:

   ```bash
   git push origin main
   ```

### Resumen de comandos (después del paso 3)
Si ya vinculaste el repositorio original como `upstream`, en el futuro solo necesitas estos comandos para actualizar:

```bash
git fetch upstream
git merge upstream/main
git push origin main
```

### Notas importantes
- **Conflictos**: Si modificaste archivos que también se actualizaron en el repositorio original, puede haber conflictos. Resuélvelos con cuidado y, si necesitas ayuda, consulta en slack.
- **Frecuencia**: Repite los pasos 4 a 6 cada vez que haya nuevas actualizaciones en el repositorio original.
