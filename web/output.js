if (typeof kotlin === 'undefined') {
  throw new Error("Error loading module 'output'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'output'.");
}
var output = function (_, Kotlin) {
  'use strict';
  var println = Kotlin.kotlin.io.println_s8jyv4$;
  function main(args) {
    println('Hello, World!');
    println('This is kotlin script');
  }
  var package$com = _.com || (_.com = {});
  var package$park9eon = package$com.park9eon || (package$com.park9eon = {});
  var package$js = package$park9eon.js || (package$park9eon.js = {});
  package$js.main_vqirvp$ = main;
  main([]);
  Kotlin.defineModule('output', _);
  return _;
}(typeof output === 'undefined' ? {} : output, kotlin);
