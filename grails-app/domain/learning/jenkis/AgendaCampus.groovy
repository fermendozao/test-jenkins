package learning.jenkis

class AgendaCampus {
    String ubicacion
    String contacto
    static hasMany = [encargados:Encargados,campus:Campus]
    static constraints = {
    }
}
