function launcher () {
  
  //--------------------------------------------------------------------------
  //  OBSERVER PATTERN DEMO
  //--------------------------------------------------------------------------

  // Legacy
  function extend(C, P) {
    var F = function () {};
    F = P;
    F.prototype = $.extend(P.prototype, C.prototype);
    C.prototype = new F();
    C.uber = P.prototype;
    C.prototype.constructor = C;
  } 
  
  //Create Cat observer
  var CatObserver = function($el) {

    var base = this;

    base.init = function() {
      $('.crier', $el).bind('click', function() {
        base.notifyObservers('chat.crier');
      });
      $('.courir', $el).bind('click', function() {
        base.notifyObservers('chat.courir');
      });
    };

    base.notify = function(event, parameters) {
      switch(event) {
        case 'chat.crier':
          $('.dialog', $el).text('Le chat vient de miauler.');
          break;
        case 'chat.courir':
          $('.dialog', $el).text('Le chat se sauve en courant.');
          break;
        case 'dog.crier':
          $('.dialog', $el).text('Le chat prend peur.');
          break;
      }
    };

    return base;
  };

  // legacy
  extend(CatObserver, Observer);

  // Create Dog observer
  var DogObserver = function($el) {

    var base = this;

    base.init = function() {
      $('.crier', $el).bind('click', function() {
        base.notifyObservers('dog.crier');
      });
    };

    base.notify = function(event, parameters) {
      switch(event) {
        case 'chat.crier':
          $('.dialog', $el).text('Le chien a entendu le chat.');
          break;
        case 'chat.courir':
          $('.dialog', $el).text('Le chien se rendort.');
          break;
        case 'dog.crier':
          $('.dialog', $el).text('Le chien aboie sur le chat.');
          break;
      }
    };

    return base;
  };

  // legacy
  extend(DogObserver, Observer);

  // object instantiation
  var observable;
  var catElement;
  var dogElement;

  $(document).ready(function() {
    
    // creation de l'observable
    observable = new Observable();

    // creation de l'observer cat
    catElement = new CatObserver($('#cat'))
      .register(observable)
      .init()
    ;

    // creation de l'observer dog
    dogElement = new DogObserver($('#dog'))
      .register(observable)
      .init()
    ;
  });

  //--------------------------------------------------------------------------
  //  END OBSERVER PATTERN DEMO
  //--------------------------------------------------------------------------

}