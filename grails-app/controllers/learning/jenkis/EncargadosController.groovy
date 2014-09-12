package learning.jenkis

import org.springframework.dao.DataIntegrityViolationException

class EncargadosController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [encargadosInstanceList: Encargados.list(params), encargadosInstanceTotal: Encargados.count()]
    }

    def create() {
        [encargadosInstance: new Encargados(params)]
    }

    def save() {
        def encargadosInstance = new Encargados(params)
        if (!encargadosInstance.save(flush: true)) {
            render(view: "create", model: [encargadosInstance: encargadosInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'encargados.label', default: 'Encargados'), encargadosInstance.id])
        redirect(action: "show", id: encargadosInstance.id)
    }

    def show() {
        def encargadosInstance = Encargados.get(params.id)
        if (!encargadosInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'encargados.label', default: 'Encargados'), params.id])
            redirect(action: "list")
            return
        }

        [encargadosInstance: encargadosInstance]
    }

    def edit() {
        def encargadosInstance = Encargados.get(params.id)
        if (!encargadosInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'encargados.label', default: 'Encargados'), params.id])
            redirect(action: "list")
            return
        }

        [encargadosInstance: encargadosInstance]
    }

    def update() {
        def encargadosInstance = Encargados.get(params.id)
        if (!encargadosInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'encargados.label', default: 'Encargados'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (encargadosInstance.version > version) {
                encargadosInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'encargados.label', default: 'Encargados')] as Object[],
                        "Another user has updated this Encargados while you were editing")
                render(view: "edit", model: [encargadosInstance: encargadosInstance])
                return
            }
        }

        encargadosInstance.properties = params

        if (!encargadosInstance.save(flush: true)) {
            render(view: "edit", model: [encargadosInstance: encargadosInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'encargados.label', default: 'Encargados'), encargadosInstance.id])
        redirect(action: "show", id: encargadosInstance.id)
    }

    def delete() {
        def encargadosInstance = Encargados.get(params.id)
        if (!encargadosInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'encargados.label', default: 'Encargados'), params.id])
            redirect(action: "list")
            return
        }

        try {
            encargadosInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'encargados.label', default: 'Encargados'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'encargados.label', default: 'Encargados'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
