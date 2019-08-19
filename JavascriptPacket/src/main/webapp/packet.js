/**
 * 
 */

/*
 * 1. Fibonacci
Define function: fib(n) 
Return the nth number in the fibonacci sequence.
*/

function fib(n) {
  let [a, b] = [0, 1];
  while (n-- > 0) {
    [a, b] = [b, a + b];
  }
  return b;
}
console.log(fib);

//or
function fib(n) {
  let arr = [0, 1];

  if (n <= 2) return 1;

  for (let i = 2; i <= n; i++) {
    arr[i] = arr[i - 1] + arr[i - 2];
    // arr.push(arr[i-1] + arr[i-2])
  }

  return arr[n];
  // return arr...for list of all values!!!
}
console.log(fib);

/*
2. Bubble Sort
Define function: bubbleSort(numArray)
Use the bubble sort algorithm to sort the array.
Return the sorted array.
*/

function bubbleSort(numArray) {
	  var length = items.length;
	  for (var i = 0; i < length; i++) { //Number of passes
	    for (var j = 0; j < (length - i - 1); j++) { //Notice that j < (length - i)
	      //Compare the adjacent positions
	      if (items[j] > items[j + 1]) {
	        //Swap the numbers
	        var tmp = items[j]; //Temporary variable to hold the current number
	        items[j] = items[j + 1]; //Replace current number with adjacent number
	        items[j + 1] = tmp; //Replace adjacent number with current number
	      }
	    }
	  }
	}
console.log(bubbleSort);
/*
 * 3. Reverse String
 * Define function: reverseStr(someStr)
 * Reverse and return the String.
 */

function reverseString(someStr) {
    // Step 1. Use the split() method to return a new array
    var splitString = str.split(""); // var splitString = "ocean".split("");
    // ["o", "c", "e", "a", "n"]
 
    // Step 2. Use the reverse() method to reverse the new created array
    var reverseArray = splitString.reverse(); // var reverseArray = ["o", c", "e", "a", "n"].reverse();
    // ["n", "a", "e", "c", "o"]
 
    // Step 3. Use the join() method to join all elements of the array into a string
    var joinArray = reverseArray.join(""); // var joinArray = ["n", "a", "e", "c", "o"].join("");
    // "naeco"
    
    //Step 4. Return the reversed string
    return joinArray; // "naeco"
}
 
console.log(reverseString("ocean"));

//Chaining the three methods together:
function reverseString(someStr) {
    return someStr.split("").reverse().join("");
}
console.log(reverseString("ocean"));

/*4. Factorial
Define function: factorial(someNum)
Use recursion to compute and return the factorial of someNum.
*/

function factorial(x) 
{ 

  if (x === 0)
 {
    return 1;
 }
  return x * factorial(x-1);
         
}
console.log(factorial(5));

/* 5. Define function substring(someStr, length, offset)
Return the substring contained between offset and (offset + length) inclusively.
If incorrect input is entered, use the alert function and describe why the input was incorrect.
*/

function substring(someStr, length, offset){
	   if(offset < 0){
	      alert("Offset is less than zero");
	    }
	   else if(offset+length > someStr.length){
	      alert("Offset is greater than length of the string");
	    }
	   else{
	      return str.substr(offset, offset+length);
	   }
	}

/*6. Even Number
Define function: isEven(someNum)
Return true if even, false if odd.
Do not use % operator.
*/

function isEven(someNum){
	if(i & 1)
	{
	console.log(isEven ("odd"))    // ODD
	}
	else
	{
		console.log(isEven("even"))    // EVEN
	}
}

/*
7. Palindrome
Define function isPalindrome(someStr)
Return true if someStr is a palindrome, otherwise return false
*/

function fastestIsPalindrome(someStr) {
  var len = Math.floor(someStr.length / 2);
  for (var i = 0; i < len; i++)
    if (someStr[i] !== someStr[someStr.length - i - 1])
      return false;
  return true;
}
console.log(isPalindrome('racecar'));

/*
8. Shapes
Define function: printShape(shape, height, character)
shape is a String and is either "Square", "Triangle", "Diamond".
height is a Number and is the height of the shape. Assume the number is odd.
character is a String that represents the contents of the shape. Assume this String contains just 
one character.
Use a switch statement to determine which shape was passed in.
Use the console.log function to print the desired shape.
Example for printShape("Square", 3, "%");
%%%
%%%
%%%
Example for printShape("Triangle", 3, "$");
$
$$
$$$
Example for printShape("Diamond", 5, "*");
  *
 ***
*****
 ***
  *
*/

function printShape(shape, height, character) {
	switch(shape) {
	case "Square":
	for(var i=0;i<n;i++) {
	for(var j=0;j<n;j++) {
	
	console.log(character);
	}
	
	}
	break;
	case "Triangle":
	for(var i=0;i<n;i++) {
	for(var j=0;j<=i;j++) {
	
	console.log(character);
	}
	
	}
	break;
	case "Diamond":
	for(var i=0;i<n;i+=2) {
	for(var k=0;k<=n/2-i;k++) {
	
	}
	for(var j=0;j<=i;j++) {
	
	console.log(character);
	}
	
	}
	for(var i=n-2;i>=0;i-=2) {
	for(var k=0;k<=(n-i)/2;k++) {
	
	}
	for(var j=0;j<i;j++) {
	
	console.log(character);
	}
	
	}
	break;
	}

	}

	console.log.printShape("Square", 3, "%");
	console.log.printShape("Triangle", 3, "$");
	console.log.printShape("Diamond", 5, "*");

/*
9. Object literal
Define function traverseObject(someObj)
Print every property and it's value.
*/
	function traverseObject(someObj) {
	    for(var propName in someObj) {
	        propValue = someObj[propName]
	        console.log(propName, propValue);
	    }
	}
		
/*
10. Delete Element
Define function deleteElement(someArr)
Print length
Delete the third element in the array.
Print length
The lengths should be the same.
*/

	function deleteElement(someArr){
		var spices = ['basil', 'oregano', 'basil', 'paprika', 'cumin'];
		console.log(spices.length);
	
	
	delete spices[2];
	     console.log(spices.length); 
    
}

/*
11. Splice Element
Define function spliceElement(someArr)
Print length
Splice the third element in the array.
Print length
The lengths should be one less than the original length.
*/

	function spliceElement(someArr){
		var arr = [1, 2, 3, 4, 5];

		console.log(arr.length);
	}

	for( var i = 0; i < arr.length; i++){ 
	   if ( arr[i] === 3) {
	     arr.splice(i, 1); 
	     console.log(arr.length);  
	   }
	}	
	
/*
12. Defining an object using a constructor
Define a function Person(name, age)
The following line should set a Person object to the variable john:
	var john = new Person("John", 30);
*/	

	let Person = function(name, age){
		  this.name = name;
		  this.age = age;
		}

		var john = new Person("John", 30 );
	
/*
13. Defining an object using an object literal
Define function getPerson(name, age)
The following line should set a Person object to the variable john:
	var john = getPerson("John", 30);
*/ 

	function getPerson(name, age) {
		
	}

		
		var john = getPerson("John", 30); 
		name: "John";
		age: "30";

		
		console.log(getperson);
	
 