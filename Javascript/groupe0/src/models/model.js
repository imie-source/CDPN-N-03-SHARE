function Model() {

    var model = this;
    this.money = 5;

    model.init = function () {
        model.field1 = new Field();
        model.field2 = new Field();
        model.field3 = new Field();
    };

    model.water = function (field) {
        try {
            if (model.money == 0){
                throw "Vous n'avez plus d'argent !";
            }
            model.money -= 1;
            field.waterDays += 1;

            if (field.waterDays >= 10) {
                field.waterDays = 0;
                field.state = 'ready';
            }
        
            if(field.state != 'ready') {
                field.waterlessDays = 0;
                field.state = 'grow';
            } else if (field.state === 'ready') {
                throw "Le champs est prêt, vous pouvez le recolter";
            }
        } catch (e) {
            return e;
        }
       
    };

    model.harvest = function (field) {
        try {
            if(field.state == 'ready') {
            model.money += 12;
            field.state = 'grow';
            } else {
                throw "Le champs n'est pas prêt à être récolté ";
            }    
        } catch (e) {
            return e;
        }
        
    };

    function Field() {

        var field = this;
        field.sellingPrice = 12;
        field.waterDays = 8;
        field.waterlessDays = 0;
        // status :
        //  empty    : failed
        //  grow     : water
        //  waiting  : wait
        //  ready    : to harvest
        field.state = 'grow';

        model.interval = setInterval(function () {
            if (field.state != 'empty' && field.state != 'ready') {
                if (field.state === 'waiting') {
                    field.waterlessDays += 1;
                }
                
                field.state          = 'waiting';
                if(field.waterlessDays == 10){
                    field.state         = 'empty';
                    field.waterDays     = 0;
                    field.waterlessDays = 0;
                }
            }

            if (model.money == 0) {
                clearInterval(model.interval);
            }
        }, 2000);
    }

    return model;
}




