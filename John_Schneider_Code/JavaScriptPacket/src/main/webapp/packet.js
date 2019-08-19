/**
 * 
 */

/*
 1. Fibonacci
	Define function: fib(n) 
	Return the nth number in the fibonacci sequence.
 */

function fib(n) {
	if(n == 1){
		return 0;
	}
	if(n == 2){
		return 1;
	}
	
	var prev = 0;
	var prevprev = 1;
	var cur = prev + prevprev;
	
	for(i = n; i>2; i--) {
		cur = prev + prevprev;
		prev = prevprev;
		prevprev = cur;
	}
	
	return cur;
};

function fibb(n) {
	console.log(fib(n));
};

/*
 2. Bubble Sort
	Define function: bubbleSort(numArray)
	Use the bubble sort algorithm to sort the array.
	Return the sorted array.
*/

function bubbleSort(numArray) {
	for(i = 0; i < numArray.length; i++) {
		for(j = 0; j < numArray.length - 1; j++)
		{	
			if(numArray[j] > numArray[j+1]) {
				let temp = numArray[j+1];
				numArray[j+1] = numArray[j];
				numArray[j] = temp;
			}
		}
	}
	
	return numArray;
};

/*
 3. Reverse String
	Define function: reverseStr(someStr)
	Reverse and return the String.
 */

function reverseStr(someStr) {
	let rtSemos = '';
	
	for(i=someStr.length-1;i>=0;i--){
		rtSemos += someStr.charAt(i);
	}
	
	return rtSemos;
};

/*
 4. Factorial
	Define function: factorial(someNum)
	Use recursion to compute and return the factorial of someNum.
 */

function factorial(someNum) {
	if(someNum <= 1){
		return 1;
	}
	
	return someNum * factorial(someNum-1);
};

/*
 5. Substring
	Define function substring(someStr, length, offset)
	Return the substring contained between offset and (offset + length) inclusively.
	If incorrect input is entered, use the alert function and describe why the input was incorrect.
 */

function substring(someStr, length, offset) {
	if(offset < 0 || length < 0) {
		alert("Invalid length and/or offset value.");
		return;
	}
	
	if((offset+length) > someStr.length) {
		alert("Substring length out of bounds of given string.");
		return;
	}
	
	let sub = '';
	
	for(i = offset; i < (offset + length); i++) {
		sub += someStr.charAt(i);
	}
	
	return sub;
};

/*
 6. Even Number
	Define function: isEven(someNum)
	Return true if even, false if odd.
	Do not use % operator.
 */

function isEven(someNum) {
	if(someNum == 0 || someNum == 1)
		return false;
	
	let is = (someNum/2) == Math.round(someNum/2);
	
	if(is)
		return true;
	else
		return false;
}

/*
 7. Palindrome
	Define function isPalindrome(someStr)
	Return true if someStr is a palindrome, otherwise return false
 */

function isPalindrome(someStr) {
	rtSemos = reverseStr(someStr);
	
	return rtSemos == someStr;
}

/*
 8. Shapes
Define function: printShape(shape, height, character)
shape is a String and is either "Square", "Triangle", "Diamond".
height is a Number and is the height of the shape. Assume the number is odd.
character is a String that represents the contents of the shape. Assume this String contains just one character.
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
	switch(shape)
	{
	case 'Sqaure':
		
		let shp = ``;

		for(i=0;i<height;i++) {
			let lns = "";
			for(j=0;j<height;j++) {
				lns += character;
			}
			shp += `${lns}
`;
		}

		console.log(shp);
		
		break;
	case 'Triangle':
		
		let shp2 = ``;
		
		let lnt = "";
		for(i=0;i<height;i++) {
			lnt += character;
			shp2 += `${lnt}
`;
		}

		console.log(shp2);
		
		break;
	case 'Diamond':
		let shp3 = ``;
		
		for(i=0;i<height;i++) {
			let lnd = "";
			let firstChar = Math.abs(Math.round(height/2)-1-i);
			let lastChar = (height-1) - firstChar;
			for(j=0;j<height;j++) {
				
				if(j >= firstChar && j <= lastChar)
					lnd += character;
				else
					lnd += " ";
				
			}
			shp3 += `${lnd}
`;
		}

		console.log(shp3);
		
		break;
	default:
		alert('Invalid shape entry.');
		return;
	}
};

/*
 9. Object literal
	Define function traverseObject(someObj)
	Print every property and it's value.
 */

function traverseObject(someObj) {
	let props = Object.entries(someObj);
	
	for(i=0;i<props.length;i++) {
		console.log(props[i][0] + " : " + props[i][1]);
	}
};

/*
 10. Delete Element
	 Define function deleteElement(someArr)
	 Print length
	 Delete the third element in the array.
	 Print length
	 The lengths should be the same.
 */

function deleteElement(someArr) {
	console.log(someArr.length);
	
	someArr[2] = null;
	
	console.log(someArr.length);
};

/*
 11. Splice Element
	 Define function spliceElement(someArr)
	 Print length
	 Splice the third element in the array.
	 Print length
	 The lengths should be one less than the original length.
 */

function spliceElement(someArr) {
	console.log(someArr.length);
	
	someArr.splice(3);
	
	console.log(someArr.length);
};

/*
 12. Defining an object using a constructor
	 Define a function Person(name, age)
	 The following line should set a Person object to the variable john:
	 var john = new Person("John", 30);
 */

function Person(name, age) {
	this.name = name;
	this.age = age;
};

var john = new Person('John', 30);

console.log(john);

/*
 13. Defining an object using an object literal
	 Define function getPerson(name, age)
	 The following line should set a Person object to the variable john:
	 var john = getPerson("John", 30);
 */

function getPerson(name, age) {
	return new Person(name, age);
};

var john2 = getPerson("John", 30);

console.log(john2);









