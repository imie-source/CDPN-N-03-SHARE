function launcher() {

    var model = new Model();
    model.init();
    var view = new View(model);
    var controller = new Controller(model, view);

}