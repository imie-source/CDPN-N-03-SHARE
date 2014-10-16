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
            view.addWaterField1();
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

    view.addWaterField1 = function () {
        /**
         * Add water to a field
         */
        $('#btnArroser1').bind('click', function () {
            observableView.notifyObservers('waterField1');
        });
        $('#btnArroser2').bind('click', function () {
            observableView.notifyObservers('waterField2');
        });
        $('#btnArroser3').bind('click', function () {
            observableView.notifyObservers('waterField3');
        });

        /**
         * Information of a field
         */
        $('#btnInfo1').bind('click', function () {
            observableView.notifyObservers('info1');
        });
        $('#btnInfo2').bind('click', function () {
            observableView.notifyObservers('info2');
        });
        $('#btnInfo3').bind('click', function () {
            observableView.notifyObservers('info3');
        });

    };


   return view;

}