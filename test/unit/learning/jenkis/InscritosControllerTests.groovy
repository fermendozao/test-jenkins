package learning.jenkis



import org.junit.*
import grails.test.mixin.*

@TestFor(InscritosController)
@Mock(Inscritos)
class InscritosControllerTests {


    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/inscritos/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.inscritosInstanceList.size() == 0
        assert model.inscritosInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.inscritosInstance != null
    }

    void testSave() {
        controller.save()

        assert model.inscritosInstance != null
        assert view == '/inscritos/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/inscritos/show/1'
        assert controller.flash.message != null
        assert Inscritos.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/inscritos/list'


        populateValidParams(params)
        def inscritos = new Inscritos(params)

        assert inscritos.save() != null

        params.id = inscritos.id

        def model = controller.show()

        assert model.inscritosInstance == inscritos
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/inscritos/list'


        populateValidParams(params)
        def inscritos = new Inscritos(params)

        assert inscritos.save() != null

        params.id = inscritos.id

        def model = controller.edit()

        assert model.inscritosInstance == inscritos
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/inscritos/list'

        response.reset()


        populateValidParams(params)
        def inscritos = new Inscritos(params)

        assert inscritos.save() != null

        // test invalid parameters in update
        params.id = inscritos.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/inscritos/edit"
        assert model.inscritosInstance != null

        inscritos.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/inscritos/show/$inscritos.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        inscritos.clearErrors()

        populateValidParams(params)
        params.id = inscritos.id
        params.version = -1
        controller.update()

        assert view == "/inscritos/edit"
        assert model.inscritosInstance != null
        assert model.inscritosInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/inscritos/list'

        response.reset()

        populateValidParams(params)
        def inscritos = new Inscritos(params)

        assert inscritos.save() != null
        assert Inscritos.count() == 1

        params.id = inscritos.id

        controller.delete()

        assert Inscritos.count() == 0
        assert Inscritos.get(inscritos.id) == null
        assert response.redirectedUrl == '/inscritos/list'
    }
}
