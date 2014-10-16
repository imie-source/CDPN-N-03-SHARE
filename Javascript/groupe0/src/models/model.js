function Model() {

    var
        model = this,
        money = 40;

    model.init = function () {
        model.field1 = new Field();
        model.field2 = new Field();
        model.field3 = new Field();

        return model;
    };

    model.water = function (field) {

    };

    model.sell = function (field) {

    };

    model.harvest = function (field) {

    };

    function Field() {
        var field = this;
        field.stock = 4;
        field.sellingPrice = 12;
        field.waterDays = 0;
        field.waterlessDays = 0;
        // status :
        //  empty : failed
        //  grow  : water
        //  ready : to harvest
        field.state = 'grow';

        // Rupture
        setInterval(function () {
            field.waterDays += 1;
        }, 2000);

        // failing
        setInterval(function () {
            field.waterlessDays += 1;
        }, 2000);
    }

    return model;
}




