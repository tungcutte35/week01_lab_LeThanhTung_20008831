var promise = new Promise(function (resolve, reject) {
  resolve("hello!!");
  // reject(Error);
});
promise.then(function (result) {
  console.log("Result: ", result);
});
