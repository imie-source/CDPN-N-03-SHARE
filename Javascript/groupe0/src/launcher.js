function launcher() {

    // Legacy
    function extend(C, P) {
        var F = function () {
        };
        F = P;
        F.prototype = $.extend(P.prototype, C.prototype);
        C.prototype = new F();
        C.uber = P.prototype;
        C.prototype.constructor = C;
    }

    //Create Cat observer
    var ModelObserver = function($el) {

        var base = this;

        base.notify = function(event, parameters) {
            console.log("notifié");
            console.log(event);
            console.log(parameters);
        };

        return base;
    };

    // legacy
    extend(ModelObserver, Observer);

    var observable;
    var modelElement;

    $(document).ready(function() {

        // // creation de l'observable
        observable = new Observable();

        // creation de l'observer cat
        modelElement = new ModelObserver($('#model'))
            .register(observable)
            .init()
        ;

        // model = new Model();
        // model.init();
        // setInterval(function () {
        //     console.log(model);
        //     console.log(model.water(model.field1));
        // }, 3000);

    });

}