//-----------------------------------------------------------//
// DEFINICION DE JOB COMO CÓDIGO PARA JENKINS                //
// Jenkins Plugin: Job DSL                                   //
//-----------------------------------------------------------//

// Este es el archivo groovy que permite definir tareas en Jenkins
// Se separa en dos secciones:
//    1. Variables y Funciones Predefinidas
//      Funciones con el objetivo de definir variables basadas en nombres de carpetas.
//      Así, las tareas en Jenkins llevan el mismo nombre que la carpeta del Script Empaquetado.
//    2. Definicion de Tarea
//      Se define la tarea Jenkins usando código.

//-----------------------------------------------------------//

    // VARIABLES Y FUNCIONES PREDEFINIDAS

import java.nio.file.Paths

def scriptDir = Paths.get(__FILE__).parent

def read = {str -> readFileFromWorkspace(Paths.get(WORKSPACE).relativize(scriptDir).resolve(str).toString())}
def clean = {str -> str.replaceAll("[^A-Za-z0-9 ]", "").replaceAll(" ","-").toLowerCase()}

def job_name = scriptDir.getName(scriptDir.getNameCount()-1).toString()
def job_location = clean(job_name)

println "Ejecutando Job DSL: " + Paths.get(WORKSPACE).relativize(Paths.get(__FILE__))

def description_form = read("jenkins-description.txt")

//-----------------------------------------------------------//

    // DEFINICION DE TAREA (referencia: https://jenkinsci.github.io/job-dsl-plugin/)

job(job_location){
    displayName(job_name)
    description(description_form)
    parameters {
        stringParam('nombre',null,"Ingrese aqui un nombre")
    }
    steps {
        batchFile(read("scripts/saludoConNombre.bat"))
    }
}
