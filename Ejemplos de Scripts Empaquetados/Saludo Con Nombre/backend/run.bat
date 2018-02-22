echo Bienvenido al ejecutor del script Saludo Con Nombre.
echo.
echo Este script requiere un nombre. Usted puede:
echo [1] Obtener nombre desde archivo "parameters.txt".
echo [2] Ingresar nombre por consola.
echo.
echo --------------------------------------------------
echo.
::
:: Se define variable "opcion"
::
set opcion=0
set /p opcion=Escoja la opcion que desee [2]: 
echo.
echo --------------------------------------------------
echo.
if %opcion%==1 (
    echo Se lee el nombre desde archivo "parameters.txt".
    for /f "delims== tokens=1,2" %%G in (parameters.txt) do set %%G=%%H
) else (
    echo Se lee el nombre desde input de usuario.
    echo.
    set /p nombre=Ingrese nombre: 
)
echo.
echo Presione una tecla para ejecutar el Script y guardar saludo en carpeta "output".
echo.
pause >nul
::
:: Se ejecuta script, el cual usará variable "nombre"
::
call scripts/saludoConNombre.bat
echo Último saludo enviado a %nombre%.>output/ultimo-saludo.txt
pause >nul