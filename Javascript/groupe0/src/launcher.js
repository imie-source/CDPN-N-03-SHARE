function launcher () {
  
  // Legacy
  function extend(C, P) {
    var F = function () {};
    F = P;
    F.prototype = $.extend(P.prototype, C.prototype);
    C.prototype = new F();
    C.uber = P.prototype;
    C.prototype.constructor = C;
  }

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