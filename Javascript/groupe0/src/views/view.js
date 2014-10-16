function View(model) {

    var view = this;

    function extend(C, P) {
        var F = function () {
        };
        F = P;
        F.prototype = $.extend(P.prototype, C.prototype);
        C.prototype = new F();
        C.uber = P.prototype;
        C.prototype.constructor = C;
    }

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

        observableView = new Observable();

        controllerViewElement = new ControllerObserver()
            .register(observableView)
            .init()
        ;

    });

    view.test = function () {
        $('#btnArroser1').bind('click', function () {
            observableView.notifyObservers('water');
        });
    };


   return view;

}