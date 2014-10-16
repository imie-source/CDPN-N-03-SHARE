function Controller(model, vue) {

    var controller = this;

    function extend(C, P) {
        var F = function () {
        };
        F = P;
        F.prototype = $.extend(P.prototype, C.prototype);
        C.prototype = new F();
        C.uber = P.prototype;
        C.prototype.constructor = C;
    }

    var ViewObserver = function () {

        var base = this;
        base.init = function () {
            controller.test();
        };

        base.notify = function (event, parameters) {
            console.log("vue notifié");
            console.log(event);
            console.log(parameters);
        };

        return base;
    };

    extend(ViewObserver, Observer);

    var ControllerObserver = function ($el) {

        var base = this;
        base.init = function () {

        };

        base.notify = function (event, parameters) {
            console.log("controller notifié");
            console.log(event);
            console.log(parameters);
        };

        return base;
    };

    extend(ControllerObserver, Observer);

    $(document).ready(function () {

        observableModel = new Observable();

        viewElement = new ViewObserver()
            .register(observableModel)
            .init()
        ;

        controllerModelElement = new ControllerObserver()
            .register(observableModel)
            .init()
        ;

    });

    controller.test = function () {
        $('#btnArroser1').bind('click', function () {
            observableModel.notifyObservers('water');
        });
    }


    return controller;
}
