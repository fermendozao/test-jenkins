package learning.jenkis

import org.springframework.dao.DataIntegrityViolationException

class AgendaCampusController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [agendaCampusInstanceList: AgendaCampus.list(params), agendaCampusInstanceTotal: AgendaCampus.count()]
    }

    def create() {
        [agendaCampusInstance: new AgendaCampus(params)]
    }

    def save() {
        def agendaCampusInstance = new AgendaCampus(params)
        if (!agendaCampusInstance.save(flush: true)) {
            render(view: "create", model: [agendaCampusInstance: agendaCampusInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'agendaCampus.label', default: 'AgendaCampus'), agendaCampusInstance.id])
        redirect(action: "show", id: agendaCampusInstance.id)
    }

    def show() {
        def agendaCampusInstance = AgendaCampus.get(params.id)
        if (!agendaCampusInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'agendaCampus.label', default: 'AgendaCampus'), params.id])
            redirect(action: "list")
            return
        }

        [agendaCampusInstance: agendaCampusInstance]
    }

    def edit() {
        def agendaCampusInstance = AgendaCampus.get(params.id)
        if (!agendaCampusInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'agendaCampus.label', default: 'AgendaCampus'), params.id])
            redirect(action: "list")
            return
        }

        [agendaCampusInstance: agendaCampusInstance]
    }

    def update() {
        def agendaCampusInstance = AgendaCampus.get(params.id)
        if (!agendaCampusInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'agendaCampus.label', default: 'AgendaCampus'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (agendaCampusInstance.version > version) {
                agendaCampusInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'agendaCampus.label', default: 'AgendaCampus')] as Object[],
                          "Another user has updated this AgendaCampus while you were editing")
                render(view: "edit", model: [agendaCampusInstance: agendaCampusInstance])
                return
            }
        }

        agendaCampusInstance.properties = params

        if (!agendaCampusInstance.save(flush: true)) {
            render(view: "edit", model: [agendaCampusInstance: agendaCampusInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'agendaCampus.label', default: 'AgendaCampus'), agendaCampusInstance.id])
        redirect(action: "show", id: agendaCampusInstance.id)
    }

    def delete() {
        def agendaCampusInstance = AgendaCampus.get(params.id)
        if (!agendaCampusInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'agendaCampus.label', default: 'AgendaCampus'), params.id])
            redirect(action: "list")
            return
        }

        try {
            agendaCampusInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'agendaCampus.label', default: 'AgendaCampus'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'agendaCampus.label', default: 'AgendaCampus'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
