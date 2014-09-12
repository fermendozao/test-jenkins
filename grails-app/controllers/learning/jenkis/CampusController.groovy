package learning.jenkis

import org.springframework.dao.DataIntegrityViolationException

class CampusController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [campusInstanceList: Campus.list(params), campusInstanceTotal: Campus.count()]
    }

    def create() {
        [campusInstance: new Campus(params)]
    }

    def save() {
        def campusInstance = new Campus(params)
        if (!campusInstance.save(flush: true)) {
            render(view: "create", model: [campusInstance: campusInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'campus.label', default: 'Campus'), campusInstance.id])
        redirect(action: "show", id: campusInstance.id)
    }

    def show() {
        def campusInstance = Campus.get(params.id)
        if (!campusInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'campus.label', default: 'Campus'), params.id])
            redirect(action: "list")
            return
        }

        [campusInstance: campusInstance]
    }

    def edit() {
        def campusInstance = Campus.get(params.id)
        if (!campusInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'campus.label', default: 'Campus'), params.id])
            redirect(action: "list")
            return
        }

        [campusInstance: campusInstance]
    }

    def update() {
        def campusInstance = Campus.get(params.id)
        if (!campusInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'campus.label', default: 'Campus'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (campusInstance.version > version) {
                campusInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'campus.label', default: 'Campus')] as Object[],
                        "Another user has updated this Campus while you were editing")
                render(view: "edit", model: [campusInstance: campusInstance])
                return
            }
        }

        campusInstance.properties = params

        if (!campusInstance.save(flush: true)) {
            render(view: "edit", model: [campusInstance: campusInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'campus.label', default: 'Campus'), campusInstance.id])
        redirect(action: "show", id: campusInstance.id)
    }

    def delete() {
        def campusInstance = Campus.get(params.id)
        if (!campusInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'campus.label', default: 'Campus'), params.id])
            redirect(action: "list")
            return
        }

        try {
            campusInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'campus.label', default: 'Campus'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'campus.label', default: 'Campus'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
