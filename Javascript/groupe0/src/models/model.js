function Model() {

  var 
    model = this,
    money = 40,

  model.Land = function () {
    var 
      land           = this, 
      stock          = 4,
      sellingPrice   = 12,
      waterDays      = 0,
      waterlessDays  = 0,
      // status : 
      //  empty : failed 
      //  grow  : water
      //  ready : to harvest
      state = 'grow';  

    // Rupture 
    setInterval(function () {
      land.waterDays += 1;
    }, 2000);

    // failing
    setInterval(function () {
      land.waterlessDays += 1
    }, 2000);
  }

  model.init = function () {
    var
     land1 = new Land(),
     land2 = new Land(),
     land3 = new Land();
  }

  model.water = function (land) {

  }

  model.sell = function (land) {

  }

  model.harvest = function (land) {

  }



