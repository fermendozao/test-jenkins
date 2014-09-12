package learning.jenkis

class Inscritos {
    String nombreCompleto
    String Observaciones
    static hasMany = [agenda:AgendaCampus]
    static constraints = {
    }
}
