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
        };

        base.notify = function (event, parameters) {

        };

        return base;
    };

    extend(ViewObserver, Observer);

    var ControllerObserver = function ($el) {

        var base = this;
        base.init = function () {

        };

        base.notify = function (event, parameters) {
            switch(event) {
                case "waterField1":
                    console.log("Ajout d'eau dans le champs 1");
                    break;
                case "waterField2":
                    console.log("Ajout d'eau dans le champs 2");
                    break;
                case "waterField3":
                    console.log("Ajout d'eau dans le champs 3");
                    break;
                case "info1":
                    console.log("Information champs 1");
                    break;
                case "info2":
                    console.log("Information champs 2");
                    break;
                case "info3":
                    console.log("Information champs 3");
                    break;
                default:
                    break;
            }
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

    return controller;
}
