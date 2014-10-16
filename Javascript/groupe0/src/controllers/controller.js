/**
 * OBSERVER CLASS
 * observer declaration
 */
var Observer = function() {
  this.observers = new Array();
};

/**
 * observer functions
 */
Observer.prototype = {
  register: function(observable) {
    this.observable = observable;
    this.notifyMe();

    return this;
  },

  notifyMe: function() {
    this.observable.register(this);
  },

  notifyObservers: function(event, parameters) {
    this.observable.notifyObservers(event, parameters);
  },

  notify: function(event, parameters) {
    return this;
  }
};
