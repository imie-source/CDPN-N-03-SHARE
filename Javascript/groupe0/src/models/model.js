function Model() {

    var
        model = this,
        money = 40;

    model.init = function () {
        model.field1 = new Field();
        model.field2 = new Field();
        model.field3 = new Field();
    };

    model.water = function (field) {
        model.money -= 1;

        if(field.state === 'grow') {
            field.waterDays += 1;
        } else if (field.waterDays === 10) {
            field.waterDays = 0;
            field.state = 'ready';
        }
    };

    model.harvest = function (field) {
        if(field.state === 'ready') {
            model.money += 12;
            field.state = 'grow';
        } else {
            throw "message d'erreur pour pas pret";
        }
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

        // failing
        setInterval(function () {

            field.waterlessDays += 1;

            if(field.waterlessDays === 10){
                field.state         = 'empty';
                field.waterDays     = 0;
                field.waterlessDays = 0;
            }
        }, 2000);
    }

    return model;
}




