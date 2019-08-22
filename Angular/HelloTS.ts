/*
TypeScript - is an open source programming language
that was developed by Microsoft.
It is a strict syntactical superset of JavaScript, and
it adds optional static typing to the language.

TypeScript is designed for development of large 
applications and it transpiles into JavaScript.
(transcompiles)
*/

let message: string = "Hello World, yo";
console.log(message);

//we got classes, interfaces, objects, methods

class Greeting {
    greet(): void {
        console.log("Hey guys, again!!!")
    }
}
var obj = new Greeting();
obj.greet();

interface Human{
    name: string;
    ability: string;
    powerLevel: number;
    useAbility();
}
class MetaHuman implements Human {
    //access modifiers
    //private, protected, public
    //the default is public
    public name: string;
    public ability: string;
    public powerLevel: number;

    constructor(name: string, ability: string, powerLevel: number){
        this.name = name;
        this.ability = ability;
        this.powerLevel = powerLevel;
    }

    useAbility(): void {
        console.log(this.ability);
        //some code here
    }
}

/*
DATA TYPES
ARRAY
STRING
NUMBER
OBJECT
BOOLEAN
FUNCTION
UNDEFINED
NULL
VOID
ENUM
TUPLE - similar to arrays, where the type of a fixed number of elements
is known but need not be same
ANY
*/

let s1; //type of any
let s2: string; //type of string
let s3 = 'yo yo yo'; //type of string
let s4 : any;

/*
The ANY data type is the super type of all types in TypeScript.
It denotes a dynamic type.
Using it is the same as opting out of type checking for a variable.
*/

var variableOne: String = "Puppy"; 
var variableTwo: Number; //value is undefined
var variableThree = 5; //type is number
var variableFour; //data type is any, value is undefined
var variableFive: undefined;
var variableSix: null;

let v1: void = null;
let v2: void = undefined;
// v3 = undefined; //undeclared

//arrays
let arry1: string[];
arry1 = [ 'hi', 'bye', 'yo'];
let arry2: Array<number>;
arry2= [2,3,45];

//functions
function myFunc(first, second){
    return 'JackJack';
}

function myFuncTwo(first: string, second: any): string {
        return 'JackJack';
    }

//Type Assertion <>
var x = '2p';
var x2: number = <number><any>x;
console.log(x2);
console.log(typeof(x2));

//variable scopes
//global 
//class - known as fields, within the class but outside
//methods, can be accessed using the object
//local - within loops, methods, etc

var global_num = 12; //global variable
class Numbers{
    num_val = 13; //class variables
    static sval = 10; //class variable, static

    storeNum(): void {
        var local_num = 14; //local variable
    }
}

console.log("Global num: " + global_num);
console.log(Numbers.sval);

//other class stuff
interface A{}
interface B{}

class Pet implements A,B{
    // p_name: string;
    // p_age: number;
    type: string;

    constructor(private name: string, private _age?: number){
        this.name = name;
        this.age = _age;
    }
//naming convention for variables with getters/setters
//getters/setters remain the variable name
//variable itself has an undescore in front of the name
    get age() {
        return this._age;
    }

    set age(value: number){
        if(value<0)
            throw new Error('less than 0 age');
        this._age = value;
    }

    //question marks make the parameter optional
    //each parameter to the right of the question mark also has 
    //to have a question mark

    //by giving an acccess modifier in the constructor, it 
    //declares the field AND sets it equal to the parameters
}

