console.log("varVar : " + varVar); // varVar : undefined
console.log("letVar : " + letVar); //ReferenceError: Cannot access 'letVar' before initialization
console.log("add(1,2) : " + add(1,2)); // 3
console.log("minus(1,2) : " + minus(1,2)); //TypeError: minus is not a function

var varVar = 3;
let letVar = 3;

function add(c, d) {
    var result = c + d;
    return result;
}

var minus = function minus(c, d) {
    var result = c - d;
    return result;
}
