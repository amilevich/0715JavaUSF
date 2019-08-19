//-----1. Fibonacci-----
function fib(n) {
  let x = 0, y = 1, z;
  do {
    z = x + y;
    x = y;
    y = z;
    console.log(z);
    n--;
  } while (n > 0);
}
let n = 10;
console.log(fib(n));
//--------------------

//-----2. Bubble Sort-----
function swap(arr, left, right) { //Create function swap for swapping elements of array
  let tmp = arr[left];
  arr[left] = arr[right];
  arr[right] = tmp;
}

function bubbleSort(numArray) { // create function with parameter 
  for (let i = 0; i < numArray.length; i++) { // external loop count our sequences through array
    for (let j = 0; j < numArray.length - i; j++) { // internal loop do swapping
      if (numArray[j] > numArray[j + 1]) {
        swap(numArray, j, j + 1);
      }
    }
  }
  return numArray;
}

console.log(bubbleSort([3, 12, 2, 25, -1, -4, 1, -2, 7, 3]));
//--------------------

//-----3. Reverse String-----
function reverseStr(someStr) { // create function
  return someStr.split("").reverse().join(""); // 1 - split our string to array of chars
}                                              // 2 - do reversing 3 - join all element of array to string
let someStr = 'How looks like Elephant shoes';
console.log(reverseStr(someStr));
//--------------------

//-----4. Factorial-----
function factorial(someNum) { // create function
  let n = someNum;  // assign to n parameter of function
  return (n != 1) ? n * factorial(n - 1) : 1; // use a ternary operator - (conditon) ? 1st result : 2nd result;
}                                             // if "n" not equal "1" then do multiplication until "n" will be equal "1"
let someNum = 5;
console.log(factorial(someNum));
//--------------------

//-----5. Substring-----
function substring(someStr, length, offset) { // create a function
  let l = length;                             // assign to variable our parameters
  let o = offset;                             // checking if someStr is string then do substr method otherwise getting message
  return (typeof "someStr" === "string") ? someStr.substr(o, l + o) : alert("It's not a string");
}
console.log(substring("How looks like Elephant shoes", 3, 15));
//--------------------

//-----6. Even Number-----
function isEven(someNum) { // create a function
  return (someNum & 1) ? false : true; // bitwise operator over ternary operator
}

let someNum = 6;
console.log(isEven(someNum));
//--------------------

//-----7. Palindrome-----
function isPalindrome(someStr) { // create a function
  let n = someStr.split("").reverse().join(""); // please look to point #3 
  return (someStr == n) ? true : false;
}

let someStr = "madam";
console.log(isPalindrome(someStr));
//--------------------

//-----8. Shapes-----
function printShape(shape, height, character) {
  let num = prompt("Please input from 1 to 3 to draw a shape");
  do {
    switch (num) {
      case 1:
        square(3);
        break;
      case 2:
        triangle(5);
        break;
      case 3:
        diamond(5);
        break;
      default:
        console.log("You have to chose from 1 to 3 for contiue\n");
    }
  } while (num != 3);
}

function square(height) {
  let drawElement = ''; // assign empty string to variable
  for (let i = 0; i < height; i++) {
    let len = height - i;
    drawElement += '%'.repeat(len) + '%'.repeat(i) + '\n'; // repeat '%' len & i times & go to next line (on the principle of a typewriter)
  }                                     // draw two triangle & concatenating together
  return console.log(drawElement); //print out 
}
square(3);

function triangle(height) {
  let drawElement = ''; // assign empty string to variable
  for (let i = 0; i <= height; i++) {
    drawElement += '$'.repeat(i) + '\n'; // repeat '$' len times & go to next line (on the principle of a typewriter)
  }
  return console.log(drawElement); //print out
}
triangle(5);

function diamond(height) {
  let drawElement = ''; // assign empty string to variable
  let len;
  if (height & 1 == false) { // check if input parameter is even
    len = height / 2;
  } else {
    len = (height + 1) / 2;
  }
  for (let i = len - 1; i > -len; i--) { // count of rows
    for (let j = len - Math.abs(i); j < len; j++) { // fill out with empty string (2, 1, 0, 1, 2)
      drawElement += ' ';
    }
    for (let j = 0; j < 2 * (len - Math.abs(i)) - 1; j++) { // fill out with "*" (1, 3, 5, 3, 1)
      drawElement += "*";
    }
    drawElement += "\n"; // go to the next line
  }
  console.log(drawElement);
}
diamond(5);

//--------------------

//-----9. Object literal-----
function traverseObject(someObj) { //create function
  return console.log(someObj);
}
let someObj = { //create object literal
  size: 30,
  color: "magenta",
  right: true,
  text: "cool",
  smth: function () {
    console.log("Done");
  }
}
traverseObject(someObj); // print out information inside object
//--------------------

//-----10. Delete Element-----
function deleteElement(someArr) {//create function
  let l = someArr.length; // assign to variable lenth of array
  delete someArr[3]; // delete 3rd element of array
  let thdEl = someArr.length; // assign to variable new lenth of array
  return console.log("Length of original array: " + l + "; After deleting 3rd element: " + thdEl); // print out result
}
let someArr = [2, 4, "It has to be deleted", 3, 6, 7];
deleteElement(someArr);
//--------------------

//-----11. Splice Element-----
function spliceElement(someArr) { //create function
  let l = someArr.length; // assign to variable lenth of array
  someArr.splice(3, 1); // do splice method of 3rd element
  let thdEl = someArr.length; // assign to variable new lenth of array
  return console.log("Length of original array: " + l + "; After deleting 3rd element: " + thdEl); // print out result
}
let someArr = [2, 4, "It has to be deleted", 3, 6, 7];
spliceElement(someArr);
//--------------------

//-----12. Defining an object using a constructor-----
function Person(name, age) { //create function
  this.name = name; // parameters assign to variable 
  this.age = age;
}
let john = new Person("John", 30); // assign to variale new object
console.log(john); // print out result
//--------------------

//-----13. Defining an object using an object literal-----
function getPerson(name, age) { //create function
  return myObj;
}

let myObj = { //create methid by object literal syntax
  name: "John",
  age: 30
}

let john = getPerson("John", 30);
console.log(john); // print out result
//--------------------