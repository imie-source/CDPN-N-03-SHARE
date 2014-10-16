function launcher () {

  /*
   * Object instantiation for application initialisation
   *
   */
  var model       = new Model();
  var view        = new View(model);
  var controller  = new Controller(model, view);

  view.attach(controller);
  model.attach(view);

}