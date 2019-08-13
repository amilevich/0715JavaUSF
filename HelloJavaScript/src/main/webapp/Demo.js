/**
 * 
 */
printStuff();

//JavaScript
/*
 * is cross-platform, object-oriented scripting language used to make
 * webpages interactive and/or functional. 
 * - dynamic language
 * - loosely typed
 */

/*
 * DATA TYPES
 * STRING
 * NUMBER
 * ARRAY
 * OBJECT
 * BOOLEAN
 * FUNCTION
 * NULL
 * UNDEFINED
 * SYMBOL - ECMAScript 6, ES6, is a unique and immutable primitive value,
 * it may be used as the key for an Object
 */

console.log("Hey, guyzzz");

//var or let or const

var x=5;
//console.log(x);
let y = 10;
const z = "hello";

//const - immutable, "final" in Java

//SCOPES
//GLOBAL - outside of any declarations
//LOCAL - functions/objects
//BLOCK - within conditionals

/*
 * var - global or local
 * let - all scopes including block
 * 
 * let and const were introduced with ES6 so was block scope
 */

var name = 'Any name';
let bool = false;
let whyVariable = undefined;
let go = null;


let hwhy; //undefined variable
//those that are not initialized nor given a type nor value but are declared
//what happens if you try to reference an undefined variable?
//return "undefined"

//variableTwo; //undeclared variable
//these are the ones that do not exist in the program and are not declared
//what happens if you try to reference an undeclared variable?
//runtime error

let numFive = 5;
// == > checks only for value
// === > checks for both value AND type (aka strictly equals)

var obj = {};//object

let superHero = {
		name : 'Hector',
		ability : 'VERY fast, not really but kinda fast i guess',
		'Gabe' : 'wait, is Gabe a thing?'
}

//console.log(superHero.name);
//console.log(superHero.ability);
//console.log(superHero.Gabe);

superHero.secretIdentity = 'Ehhhh Ricardo';
//console.log(superHero.secretIdentity);

delete superHero.Gabe;
console.log(superHero);

//JavaScript is a DYNAMIC language because you can add/delete new
//fields into objects at runtime
//JavaScript is loosely typed because you can switch data types at
//runtime
//Interpretive language - code is not precompiled, it runs line by line


let num1 = 10;
let num2 =  num1;
num1 = 25;
//console.log(num1);
//console.log(num2);
// variables are passed by value
//so num1 is 25 and num2 is 10

let obj1 = {
		value : 10
};
let num3 = obj1.value;
obj1.value = 50;
//console.log(obj1);
//console.log(num3);
//objects are still passed by value

let arrayOfRawChaos = [
	['JavaScript', 3],
	['Floating Clocks in Twilight Zone', 'Awesome']
];
//console.log(arrayOfRawChaos[1]);
//console.log(arrayOfRawChaos[1][1]);
arrayOfRawChaos[10] = 'Alex can no spell';
//console.log(arrayOfRawChaos);

//backticks aka Template Literals introduced in ES6 ``
let tempNum = 500;

//let longString = 'Printing longString' + tempNum + ' and now we  have more stuff';

//let longString = `Print longString with variable: ${tempNum}
//
//and now i want to write some more stuff
//
//${arrayOfRawChaos[10]}
//
//
//and some more
//
//
//
//and maybe a smiley face :)
//
//0_0
//
//
//some more stuff and 							we are over here
//
//
//and Gabe
//
//yes`;

function printStuff(){
	console.log("stuff");
}

//HOISTING 
//all declarations get moved to the top of their scope
//variables, objects, functions, arrays....


//Falsy Values
/*
 * numbers are inherently true, 0 is false
 * strings are inherently true, empty string is false
 * false is false, true is true
 * null is false
 * undefined is false
 * NaN is false
 * 
 * you can use any value in a boolean context and it is assigned
 * either a true or a false
 */

function checkTruthy(input) {
	console.log(`input = ${input}, and is typeof: ${typeof(input)} and
	input is ${!!input}`)
};

//checkTruthy(42);
//checkTruthy('Yes');
//checkTruthy(0);
//checkTruthy(null);
//checkTruthy(-1);
//checkTruthy(NaN);
//checkTruthy(false);
//checkTruthy('_');
//checkTruthy('');
//checkTruthy([]);
//checkTruthy({});

//What is NaN?
//Not a keyword nor a data type
//it is a property of the global object
//isNaN - function returns true if variable is not a type number

/*
 * 1) Division of zero by zero
 * 2) Division of infinity by infinity
 * 3) Multiplicaiton of infinity by zero
 * 4) Converting a non-numeric string or undefined into a number
 */


//loops
games = ['darts', 'ping pong', 'table tennis thank you very much', 'uno', 'chess'];

/*for(let g in games){
	console.log(games[g]);
}*/

//in ES6, arrow notation

//ES5
/*var func = function(x,y){
	return x*y;
};*/

//ES6
/*let func = (x,y) => x*y;*/


//Anonymous Functions
// - a function without a name

let funcTwo = function() {
	console.log('in myFunc')
};

funcTwo();

//Callback Functions
//simply put: we are able to pass in a function as a parameter to another
//function
//function that is to be executed after another function has 
//finished executing
//guarantees execution order

function doHomework(subject, callbackFunc){
	alert(`Starting my ${subject} homework.`);
	callbackFunc();
};

let alertFinished = function(){
	alert('Finished my homework.');
};

/*doHomework('math and JavaScript', alertFinished);*/

//Self Invoking Functions
//these functions call themselves
//they will execute automatically if the expression is followed by ()
// IIFE - Immediately Invokable Function Expression

let funcThree = function() {
	let someVariable = "inside of the self invoking function";
	console.log(someVariable);
}()

//closure
/* implementation of encapsulation
 * 
 * a closure is an inner function that has access to its outer
 * function's variables
 * The closure has 3 scope chains:
 * 1) it has access to its own scope
 * 2) it has access to the outer function's variables
 * 3) it has access to global variables
 * 
 */
let foo =(function() {
	let bar = 0;
	return function() {
		return bar += 1
	};
});
/*
console.log(foo());
console.log(bar);*/
//bar is not global, cannot directly call on it

//Inheritance
//Prototypical Inheritance
/*
 * In JavaScript, when it comes to inheritance, it only has one
 * construct: objects.
 * Each object has a private property which holds a link to another
 * object called its prototype.
 * The prototype has a prototype of its own and so on
 * until an object is reached with null as its prototype.
 * 
 * Let us create an object "o"
 * 
 * o.[[Prototype]] properties b and c
 * o.[[Prototype]].[[Prototype]] - Object.prototype
 * o.[[Prototype]].[[Prototype]].[[Prototype]] - null
 */

let f = function (){
	this.a = 1;
	this.b = 2;
}
let o = new f(); //making an object o of type f
//add properties
f.prototype.b = 3; //p.b = 3;
f.prototype.c = 4;
let p = f.prototype;
console.log(p.b); //3
console.log(o.b);



