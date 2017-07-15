if (typeof kotlin === 'undefined') {
  throw new Error("Error loading module 'output'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'output'.");
}
var output = function (_, Kotlin) {
  'use strict';
  var println = Kotlin.kotlin.io.println_s8jyv4$;
  function main(args) {
    println('Hello, World!');
  }
  var package$com = _.com || (_.com = {});
  var package$park9eon = package$com.park9eon || (package$com.park9eon = {});
  var package$newtab = package$park9eon.newtab || (package$park9eon.newtab = {});
  package$newtab.main_kand9s$ = main;
  main([]);
  Kotlin.defineModule('output', _);
  return _;
}(typeof output === 'undefined' ? {} : output, kotlin);
