function Model() {

    var
        model = this,
        money = 40;

    model.init = function () {
        model.land1 = new Land();
        model.land2 = new Land();
        model.land3 = new Land();

        return model;
    };

    model.water = function (land) {

    };

    model.sell = function (land) {

    };

    model.harvest = function (land) {

    };

    function Land() {
        var land = this;
        land.stock = 4;
        land.sellingPrice = 12;
        land.waterDays = 0;
        land.waterlessDays = 0;
        // status :
        //  empty : failed
        //  grow  : water
        //  ready : to harvest
        land.state = 'grow';

        // Rupture
        setInterval(function () {
            land.waterDays += 1;
        }, 2000);

        // failing
        setInterval(function () {
            land.waterlessDays += 1;
        }, 2000);
    }

    return model;
}




