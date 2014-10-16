function launcher() {

    var model = new Model();
    model.init();
    var view = new View(model);
    var controller = new Controller(model, view);

    // model = new Model();
    // model.init();
    // setInterval(function () {
    //     console.log(model);
    //     console.log(model.water(model.field1));
    // }, 3000);


}