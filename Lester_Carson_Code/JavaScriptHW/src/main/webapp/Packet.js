//1. Fibonacci 
//Define function: fib(n) 
//Return the nth number in the fibonacci sequence.
function fib(n) {
  if (n <= 1) {
	  return 1;
  }
  return fib(n - 1) + fib(n - 2);
}

//2. Bubble Sort 
//Define function: bubbleSort(numArray)
//Use the bubble sort algorithm to sort the array.
//Return the sorted array.
function bubbleSort(numArray) {
	for(var i = 0; i < numArray.length; i++) {
		for(var j = i; j < numArray.length; j++) {
			if (numArray[j] < numArray[i]) {
				var temp = numArray[i];
				numArray[i] = numArray[j];
				numArray[j] = temp;
			}
		}
	}
	return numArray
}

//3. Reverse String
//Define function: reverseStr(someStr)
//Reverse and return the String.
function reverseStr(someStr) {
	
	var splitString = someStr.split("");
    var reverseArray = splitString.reverse();
    var joinArray = reverseArray.join("");
    return joinArray;
}

//4. Factorial
//Define function: factorial(someNum)
//Use recursion to compute and return the factorial of someNum.
function factorial(someNum) {
	
	if (someNum == 1 || someNum == 0) {
		return 1;
	} else {
		return(someNum * factorial(someNum - 1));
	}
}

//5. Substring
//Define function substring(someStr, length, offset)
//Return the substring contained between offset and (offset + length) inclusively.
//If incorrect input is entered, use the alert function and describe why the input was incorrect.
function substring(someStr, length, offset) {return someStr.substring(offset);}

//6. Even Number
//Define function: isEven(someNum)
//Return true if even, false if odd.
//Do not use % operator.
function isEven(someNum) {
	
	var i = 0, even = true;

	if (someNum >= 0 ) {
		while (i != someNum) {
			even = !even;
			i++;
		}
	} else {
		while (i != someNum) {
			even = !even;
			i--;
		}
	}
	return even;
}

//7. Palindrome
//Define function isPalindrome(someStr)
//Return true if someStr is a palindrome, otherwise return false
function isPalindrome(someStr) {
	
	var rev = "";
	for (var i = someStr.length - 1; i >= 0; i--) {
		rev = rev + someStr.charAt(i);
	}
	if (someStr === rev) {
		return true;
	}
	return false;
}

//8. Shapes
//Define function: printShape(shape, height, character)
//shape is a String and is either "Square", "Triangle", "Diamond".
//height is a Number and is the height of the shape. Assume the number is odd.
//character is a String that represents the contents of the shape. Assume this String contains just one character.
//Use a switch statement to determine which shape was passed in.
//Use the console.log function to print the desired shape.
//Example for printShape("Square", 3, "%");
//%%%
//%%%
//%%%
//Example for printShape("Triangle", 3, "$");
//$
//$$
//$$$
//Example for printShape("Diamond", 5, "*");
//  *
// ***
//*****
// ***
//  *
function printShape(shape, height, character) {
	
	switch(shape) {
	case "Square":
		for (var i = 0; i < height; i++) {
		    for (var j = 0; j < height; j++) {
		        console.log(character);
		    }
		    console.log("\n");
		}
		break;
	case "Triangle":
		for (var i = 0; i < height; i++) {      
            for (var j = 0; j <= i; j++) {
                console.log(character); 
            } 
            console.log("\n");
		}
		break;
	case "Diamond": //fix
		for(var i = 1; i <= height; i++) {
		    for(var j = 1; j <= i; j++) {
		        console.log(character);
		    }
		    for(j=i;j>1;j--) {
		        Console.log(character);
		    }
		    console.log("\n");
		}
		break;
	default:
		console.log("Please correct input");
	}
}

//9. Object literal
//Define function traverseObject(someObj)
//Print every property and it's value.
function traverseObject(someObj) {
	var value;
	for(var property in someObj) {
	    value = someObj[property]

	    console.log(property,value);
	}
}

//10. Delete Element
//Define function deleteElement(someArr)
//Print length
//Delete the third element in the array.
//Print length
//The lengths should be the same.
function deleteElement(someArr) {
	
	console.log(someArr.length);
	delete someArr[2]; // delete element with index 4
	console.log(someArr.length);
	
}

//11. Splice Element
//Define function spliceElement(someArr)
//Print length
//Splice the third element in the array.
//Print length
//The lengths should be one less than the original length.
function spliceElement(someArr) {
	
	console.log(someArr.length);
	someArr.splice(2)
	console.log(someArr.length);
}

//12. Defining an object using a constructor
//Define a function Person(name, age)
//The following line should set a Person object to the variable john:
//	var john = new Person("John", 30);
function Person(name, age) {
	var john = new Person(name, age);
}

//13. Defining an object using an object literal
//Define function getPerson(name, age)
//The following line should set a Person object to the variable john:
//	var john = getPerson("John", 30);
function getPerson(name, age) {
	var john = getPerson(name, age);
}