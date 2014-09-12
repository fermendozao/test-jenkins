package learning.jenkis



import org.junit.*
import grails.test.mixin.*

@TestFor(AgendaCampusController)
@Mock(AgendaCampus)
class AgendaCampusControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/agendaCampus/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.agendaCampusInstanceList.size() == 0
        assert model.agendaCampusInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.agendaCampusInstance != null
    }

    void testSave() {
        controller.save()

        assert model.agendaCampusInstance != null
        assert view == '/agendaCampus/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/agendaCampus/show/1'
        assert controller.flash.message != null
        assert AgendaCampus.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/agendaCampus/list'


        populateValidParams(params)
        def agendaCampus = new AgendaCampus(params)

        assert agendaCampus.save() != null

        params.id = agendaCampus.id

        def model = controller.show()

        assert model.agendaCampusInstance == agendaCampus
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/agendaCampus/list'


        populateValidParams(params)
        def agendaCampus = new AgendaCampus(params)

        assert agendaCampus.save() != null

        params.id = agendaCampus.id

        def model = controller.edit()

        assert model.agendaCampusInstance == agendaCampus
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/agendaCampus/list'

        response.reset()


        populateValidParams(params)
        def agendaCampus = new AgendaCampus(params)

        assert agendaCampus.save() != null

        // test invalid parameters in update
        params.id = agendaCampus.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/agendaCampus/edit"
        assert model.agendaCampusInstance != null

        agendaCampus.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/agendaCampus/show/$agendaCampus.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        agendaCampus.clearErrors()

        populateValidParams(params)
        params.id = agendaCampus.id
        params.version = -1
        controller.update()

        assert view == "/agendaCampus/edit"
        assert model.agendaCampusInstance != null
        assert model.agendaCampusInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/agendaCampus/list'

        response.reset()

        populateValidParams(params)
        def agendaCampus = new AgendaCampus(params)

        assert agendaCampus.save() != null
        assert AgendaCampus.count() == 1

        params.id = agendaCampus.id

        controller.delete()

        assert AgendaCampus.count() == 0
        assert AgendaCampus.get(agendaCampus.id) == null
        assert response.redirectedUrl == '/agendaCampus/list'
    }
}
