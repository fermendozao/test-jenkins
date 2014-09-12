package learning.jenkis

class Campus {
    String nombre
    String descripcion
    String temario
    Date fechaInicio
    Date fechaFinaliza
    String horario

    static constraints = {
        nombre blank:false,nullable:false
        descripcion blank: false,nullable:false
        temario blank:false, nullable:false
        horario blank: false,nullable: false
    }
}
