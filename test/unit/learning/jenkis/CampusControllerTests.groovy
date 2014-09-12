package learning.jenkis



import org.junit.*
import grails.test.mixin.*

@TestFor(CampusController)
@Mock(Campus)
class CampusControllerTests {


    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/campus/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.campusInstanceList.size() == 0
        assert model.campusInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.campusInstance != null
    }

    void testSave() {
        controller.save()

        assert model.campusInstance != null
        assert view == '/campus/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/campus/show/1'
        assert controller.flash.message != null
        assert Campus.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/campus/list'


        populateValidParams(params)
        def campus = new Campus(params)

        assert campus.save() != null

        params.id = campus.id

        def model = controller.show()

        assert model.campusInstance == campus
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/campus/list'


        populateValidParams(params)
        def campus = new Campus(params)

        assert campus.save() != null

        params.id = campus.id

        def model = controller.edit()

        assert model.campusInstance == campus
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/campus/list'

        response.reset()


        populateValidParams(params)
        def campus = new Campus(params)

        assert campus.save() != null

        // test invalid parameters in update
        params.id = campus.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/campus/edit"
        assert model.campusInstance != null

        campus.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/campus/show/$campus.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        campus.clearErrors()

        populateValidParams(params)
        params.id = campus.id
        params.version = -1
        controller.update()

        assert view == "/campus/edit"
        assert model.campusInstance != null
        assert model.campusInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/campus/list'

        response.reset()

        populateValidParams(params)
        def campus = new Campus(params)

        assert campus.save() != null
        assert Campus.count() == 1

        params.id = campus.id

        controller.delete()

        assert Campus.count() == 0
        assert Campus.get(campus.id) == null
        assert response.redirectedUrl == '/campus/list'
    }
}
