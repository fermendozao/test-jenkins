package learning.jenkis

import org.springframework.dao.DataIntegrityViolationException

class InscritosController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [inscritosInstanceList: Inscritos.list(params), inscritosInstanceTotal: Inscritos.count()]
    }

    def create() {
        [inscritosInstance: new Inscritos(params)]
    }

    def save() {
        def inscritosInstance = new Inscritos(params)
        if (!inscritosInstance.save(flush: true)) {
            render(view: "create", model: [inscritosInstance: inscritosInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'inscritos.label', default: 'Inscritos'), inscritosInstance.id])
        redirect(action: "show", id: inscritosInstance.id)
    }

    def show() {
        def inscritosInstance = Inscritos.get(params.id)
        if (!inscritosInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'inscritos.label', default: 'Inscritos'), params.id])
            redirect(action: "list")
            return
        }

        [inscritosInstance: inscritosInstance]
    }

    def edit() {
        def inscritosInstance = Inscritos.get(params.id)
        if (!inscritosInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'inscritos.label', default: 'Inscritos'), params.id])
            redirect(action: "list")
            return
        }

        [inscritosInstance: inscritosInstance]
    }

    def update() {
        def inscritosInstance = Inscritos.get(params.id)
        if (!inscritosInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'inscritos.label', default: 'Inscritos'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (inscritosInstance.version > version) {
                inscritosInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'inscritos.label', default: 'Inscritos')] as Object[],
                        "Another user has updated this Inscritos while you were editing")
                render(view: "edit", model: [inscritosInstance: inscritosInstance])
                return
            }
        }

        inscritosInstance.properties = params

        if (!inscritosInstance.save(flush: true)) {
            render(view: "edit", model: [inscritosInstance: inscritosInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'inscritos.label', default: 'Inscritos'), inscritosInstance.id])
        redirect(action: "show", id: inscritosInstance.id)
    }

    def delete() {
        def inscritosInstance = Inscritos.get(params.id)
        if (!inscritosInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'inscritos.label', default: 'Inscritos'), params.id])
            redirect(action: "list")
            return
        }

        try {
            inscritosInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'inscritos.label', default: 'Inscritos'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'inscritos.label', default: 'Inscritos'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
