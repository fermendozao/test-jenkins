package learning.jenkis



import org.junit.*
import grails.test.mixin.*

@TestFor(EncargadosController)
@Mock(Encargados)
class EncargadosControllerTests {


    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/encargados/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.encargadosInstanceList.size() == 0
        assert model.encargadosInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.encargadosInstance != null
    }

    void testSave() {
        controller.save()

        assert model.encargadosInstance != null
        assert view == '/encargados/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/encargados/show/1'
        assert controller.flash.message != null
        assert Encargados.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/encargados/list'


        populateValidParams(params)
        def encargados = new Encargados(params)

        assert encargados.save() != null

        params.id = encargados.id

        def model = controller.show()

        assert model.encargadosInstance == encargados
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/encargados/list'


        populateValidParams(params)
        def encargados = new Encargados(params)

        assert encargados.save() != null

        params.id = encargados.id

        def model = controller.edit()

        assert model.encargadosInstance == encargados
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/encargados/list'

        response.reset()


        populateValidParams(params)
        def encargados = new Encargados(params)

        assert encargados.save() != null

        // test invalid parameters in update
        params.id = encargados.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/encargados/edit"
        assert model.encargadosInstance != null

        encargados.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/encargados/show/$encargados.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        encargados.clearErrors()

        populateValidParams(params)
        params.id = encargados.id
        params.version = -1
        controller.update()

        assert view == "/encargados/edit"
        assert model.encargadosInstance != null
        assert model.encargadosInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/encargados/list'

        response.reset()

        populateValidParams(params)
        def encargados = new Encargados(params)

        assert encargados.save() != null
        assert Encargados.count() == 1

        params.id = encargados.id

        controller.delete()

        assert Encargados.count() == 0
        assert Encargados.get(encargados.id) == null
        assert response.redirectedUrl == '/encargados/list'
    }
}
