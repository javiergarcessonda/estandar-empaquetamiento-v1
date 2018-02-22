# Descripción de archivos: Estándar de Empaquetamiento de Scripts
Autor: Javier Garcés A.
Sonda S.A., Santiago, Chile. 22/02/2018

## Definiciones

+ **Script Empaquetado** - carpeta presente, que sigue estructura definida para almacenar scripts y archivos asociados. La carpeta lleva el nombre de la tarea de automatización.
+ **Ejecutor Local** - archivo **RUN** para ejecutar script desde una computadora personal.

## Carpetas en Script Empaquetado

### Carpetas Obligatorias

+ **scripts** - Scripts de automatización.

### Carpetas Opcionales

+ **backend** - Archivos backend para Ejecutor Local.
+ **images** - Imágenes de apoyo o para referenciar en documentación.
+ **output** - Destino de archivos de salida generados por Ejecutor Local.

## Archivos en Script Empaquetado

### Archivos Obligatorios

+ **files-description** - El presente documento. No editable.
+ **README** - Descripción de Automatización: objetivo, alcance, ...
+ **requirements** - Requerimientos para máquina local (versión o instalación de software, ...) + Requerimientos pre-ejecución.
+ **RUN** - Ejecutor Local, para ejecutar script desde una computadora personal.

### Archivos Opcionales

+ **GUIDE** - Versión más gráficamente amigable de README.
+ **jenkins** - Configuración de job en Jenkins.
+ **jenkins-description** - Descripción de job en Jenkins.
+ **parameters** - Lista de parámetros externos que usa el script. Pueden llevar valores por defecto. Puede ser usado por el Ejecutor Local para obtención de parámetros, junto a input de usuario.