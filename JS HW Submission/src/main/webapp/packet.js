/**
 * 
 */

// 1. Fibonacci
// Define function: fib(n)
// Return the nth number in the fibonacci sequence.
function fib(num) {
	if (num <= 1)
		return 1;
	return fib(num - 1) + fib(num - 2);
}
console.log("1. 7th fibonacci number is:", fib(7));

// 2. Bubble Sort
// Define function: bubbleSort(numArray)
// Use the bubble sort algorithm to sort the array. Return the sorted array.

function bubbleSort(numArray) {
	var swapped = true;
	while (swapped) {
		swapped = false;
		for (var i = 0; i < numArray.length - 1; i++) {
			if (numArray[i] > numArray[i + 1]) {
				var tmp = numArray[i + 1];
				numArray[i + 1] = numArray[i];
				numArray[i] = tmp;
				swapped = true;
			}
		}
	}
	return numArray;
}
var array = [ 10, 32, 3, 220, 44, 911 ];
bubbleSort(array);
console.log("2. Bubble sort array [10, 32, 3, 220, 44, 911]:", array);

// 3. Reverse String
// Define function: reverseStr(someStr) Reverse and return the String.

function reverseStr(someStr) {
	var rev = "";
	for (var i = 0; i < someStr.length; i++) {
		rev = someStr[i] + rev;
	}
	return rev;
}
console.log("3. delicious reversed is:", reverseStr("delicious"));

// 4. Factorial
// Define function: factorial(someNum)
// Use recursion to compute and return the factorial of someNum.

function factorial(someNum) {
	if (someNum <= 1)
		return 1;
	return someNum * factorial(someNum - 1);
}
console.log("4. 8 factorial is:", factorial(8));

// 5. Substring
// Define function substring(someStr, length, offset)
// Return the substring contained between offset and (offset + length)
// inclusively.
// If incorrect input is entered, use the alert function and describe why the
// input was incorrect.

function substring(someStr, length, offset) {
	var sub = "";
	if (offset > someStr.length || offset + length > someStr.length) {
		alert("Cannot get substring from input string.");
	}
	for (var i = offset; i < length + offset; i++) {
		sub = sub + someStr[i];
	}
	return sub;
}
console.log("5. Pizza, length 3, offset 2:", substring("Pizza", 3, 2));

// 6. Even Number
// Define function: isEven(someNum) Return true if even, false if odd. Do not
// use % operator.

function isEven(someNum) {
	while (someNum >= 2)
		someNum -= 2;
	return (someNum == 0);
}
console.log("6. 6 is even?", isEven(6));
console.log("6. 7 is even?", isEven(7));

// 7. Palindrome
// Define function isPalindrome(someStr)
// Return true if someStr is a palindrome, otherwise return false
function isPalindrome(someStr) {
	for (var i = 0; i < someStr.length / 2 - 1; i++) {
		if (someStr[i] != someStr[someStr.length - i - 1])
			return "false";
	}
	return true;
}
console.log("7. groot is palindrome?", isPalindrome("groot"));
console.log("7. racecar is palindrome?", isPalindrome("racecar"));

// 8. Shapes
// Define function: printShape(shape, height, character)
// shape is a String and is either "Square", "Triangle", "Diamond".
// height is a Number and is the height of the shape. Assume the number is odd.
// character is a String that represents the contents of the shape. Assume this
// String contains just one character.
// Use a switch statement to determine which shape was passed in.
// Use the console.log function to print the desired shape.
// Example for printShape("Square", 3, "%");
// %%%
// %%%
// %%%
// Example for printShape("Triangle", 3, "$");
// $
// $$
// $$$
// Example for printShape("Diamond", 5, "*");
// *
// ***
// *****
// ***
// *
function printShape(shape, height, character) {
	var result = "";
	switch (shape) {
	case "Square":
		for (var i = 0; i < height; i++) {
			for (var j = 0; j < height; j++) {
				result = result + character;
			}
			result = result + "\n";
		}
		break;
	case "Triangle":
		var x = 1;
		for (var i = 0; i < height; i++) {
			for (var j = 0; j < x; j++) {
				result = result + character;
			}
			result = result + "\n";
			x++;
		}
		break;
	case "Diamond":
		for (var j = 1; j <= height; j++) {
			for (var i = 0; i < height - j; i++) {
				result = result + " ";
			}
			for (var i = 0; i < j; i++) {
				result = result + " " + character;
			}
			result = result + "\n";
		}
		for (var j = height - 1; j >= 1; j--) {
			for (var i = 0; i < height - j; i++) {
				result = result + " ";
			}
			for (var i = 0; i < j; i++) {
				result = result + " " + character;
			}
			result = result + "\n";
		}
		break;
	}
	return result;
}
console.log("8. Square 10 *: " + "\n");
console.log(printShape("Square", 10, "*"));
console.log("8. Triangle 10 #:\n");
console.log(printShape("Triangle", 10, "#"));
console.log("8. Diamond 10 $:\n");
console.log(printShape("Diamond", 10, "$"));

// 9. Object literal
// Define function traverseObject(someObj) Print every property and it's value.

var Cat = {
	name : "Steve",
	weapon : "furry",
	food : "squid ink soba"
};
function traverseObject(someObj) {
	var x = someObj.name;
	var y = someObj.weapon;
	var z = someObj.food;
	var sold = [ x, y, z ];
	return sold;
}
console.log("9. Cat properties are: ", traverseObject(Cat));

// 10. Delete Element
// Define function deleteElement(someArr) Print length
// Delete the third element in the array. Print length
// The lengths should be the same.
var toBeDel = [ 1, 2, 3, 4 ];
function deleteElement(someArr) {
	console.log(someArr.length);
	delete someArr[3];
	console.log(someArr.length);
}
console.log("10. Delete Element")
deleteElement(toBeDel);

// 11. Splice Element
// Define function spliceElement(someArr)
// Print length
// Splice the third element in the array.
// Print length
// The lengths should be one less than the original length.
var spli = [ "I", "am", "Groot" ];
function spliceElement(someArr) {
	console.log(someArr.length);
	someArr.splice(2, 1);
	console.log(someArr.length)
}
console.log("11. Splice Element")
spliceElement(spli);

// 12. Defining an object using a constructor
// Define a function Person(name, age)
// The following line should set a Person object to the variable john:
// var john = new Person("John", 30);
function Person(name, age) {
	this.name = name;
	this.age = age;
}
var john = new Person("John", 30);
// 13. Defining an object using an object literal
// Define function getPerson(name, age)
// The following line should set a Person object to the variable john:
// var john = getPerson("John", 30);
function getPerson(name, age) {
	return {
		"name" : name,
		"age" : age
	};
}
console.log("12. Object Literal")
var john2 = getPerson("John", 30);
console.log(john2);

// Part II

// 1. USA
// Define function getUSA()
// Find the html element that contains "USA". Print that element's contents.

function getUSA() {
	var ele1 = document.getElementsByTagName("*");
	for (let i = 0; i < element1.length; i++) {
		if (ele1[i].innerHTML == "USA") {
			console.log(ele1[i].innerHTML, "inside span tag found.");
			break;
		}
	}
}
console.log("2.1");
getUSA();

// 2. Sales
// Define function getPeopleInSales()
// Print the names of all the people in the sales department.

function getPeopleInSales() {
	var ele2 = document.getElementsByTagName("td");
	for (let i = 0; i < element2.length; i++) {
		if (ele2[i].innerHTML == "Sales") {
			console.log(ele2[i - 1].innerHTML,
					"is in the sales department.")
		}
	}
}
console.log("2.2");
getPeopleInSales();

// 3. Click Here
// Define function getAnchorChildren()
// Find all anchor elements with a <span> child. Print the contents of <span>
function getAnchorChildren() {
	var ele3 = document.querySelectorAll("a > span");
	for (let i = 0; i < ele3.length; i++) {
		console.log(ele3[i].innerHTML);
	}
}
console.log("2.3.");
getAnchorChildren();

// 4. Hobbies
// Define function getHobbies()
// Find all checked options in the 'skills' select element. Print the value and
// the contents.
function getHobbies() {
	var ele4 = document.getElementsByName("skills");
	for (let i = 0; i < ele4.length; i++) {
		var x = ele4[i].getElementsByTagName("option");
		for (let j = 0; j < x.length; j++) {
			if (x[j].getAttribute("selected") == "selected") {
				console.log(x[j].getAttribute("value"), x[j].innerHTML);
			}
		}
	}
}
console.log("2.4");
getHobbies();

// 5. Custom Attribute
// Define function getCustomAttribute()
// Find all elements with "data-customAttr" attribute Print the value of the
// attribute.
// Print the element that has the attribute.
function getCustomAttribute() {
	var ele5 = document.querySelectorAll("[data-customAttr]");
	for (let i = 0; i < ele5.length; i++) {
		console.log(ele5[i].getAttribute("data-customAttr"),
				ele5[i].tagName);
	}
}
console.log("2.5");
getCustomAttribute();
// 6. Sum Event
// Regarding these elements:
// <input id="num1" class="nums" type="text"/> <input id="num2" class="nums"
// type="text"/> <h3>Sum: <span id="sum"></span></h3>
// Define onchange event handler.
// Add <input> element values.
// Put the sum in the <span> element.
// If values cannot be added, put "Cannot add" in the <span> element
var n1 = document.getElementById("num1");
var n2 = document.getElementById("num2");
var sum = document.getElementById("sum");
function getSum() {
	var v1 = parseInt(n1.value);
	var v2 = parseInt(n2.value);
	if (isNaN(v1) || isNaN(v2)) {
		sum.innerHTML = "Cannot add";
		console.log("Couldn't add.");
	} else {
		sum.innerHTML = v1 + v2;
		console.log("Addition sucessful.");
	}
}
console.log("2.6")
getSum();

// 7. Skills Event
// When user selects a skill, create an alert with a message similar to:
// "Are you sure CSS is one of your skills?"
// NOTE: no alert should appear when user deselects a skill.
var skillChange = document.getElementsByName("skills")[0];
skillChange.onchange = function(){
  var sel = skillChange.options[skillChange.selectedIndex].innerHTML;
  alert("Are you sure " + sel + " is one of your skills?");
}
console.log("2.7")
console.log("Runs.")

// 8. Favorite Color Event
// NOTE: This is regarding the favoriteColor radio buttons.
// When a user selects a color, create an alert with a message similar to:
// "So you like green more than blue now?"
// In this example, green is the new value and blue is the old value.
// Make the background color (of all favoriteColor radio buttons) the newly
// selected favoriteColor

var favColor = Array.from(document.getElementsByName("favoriteColor"));
var currColor;
for(var i = 0; i < favColor.length; i++){
  favColor[i].onchange = function(){
    if(currColor == null){
      currColor = this.nextSibling.nodeValue;
      alert("So you like " + currColor + " now?");
    }
    else{
      alert("So you like " + this.nextSibling.nodeValue + " more than " + currColor + " now?");
      currColor = this.nextSibling.nodeValue;
    }
    for(var i = 0; i < favColor.length; i++){
      favColor[i].parentElement.style.backgroundColor = currColor;
    }
  };
}
console.log("2.8")
console.log("Color changes radio buttons, alerts.")

// 9. Show/Hide Event
// When user hovers over an employees name:
// Hide the name if shown. Show the name if hidden.

var emps = Array.from(document.getElementsByClassName("empName"));
emps.forEach(e => {
  e.style.opacity = 100;
  e.addEventListener("mouseenter", () =>{
    if(e.style.opacity == 0){
      e.style.opacity = 100;
    }
    else{
      e.style.opacity = 0;
    }
  });
});
console.log("2.9");
console.log("Employee names show/hide on hover.")

// 10. Current Time Regarding this element:
// <h5 id="currentTime"></h5>
// Show the current time in this element in this format: 9:05:23 AM
// The time should be accurate to the second without having to reload the page.

function getTime(){
  var d = new Date();
  var time = d.toLocaleTimeString();
  document.getElementById("currentTime").innerHTML = time;
}
var updateTime = setInterval(function(){ getTime() }, 1000);
console.log("2.10");
console.log("Clock running.");

// 11. Delay
// Regarding this element:
// <p id="helloWorld">Hello, World!</p>
// Three seconds after a user clicks on this element, change the text to a
// random color.

var wc = document.getElementById("helloWorld");
function helloColor(){
  var color = Math.floor(Math.random() * Math.pow(256, 3)).toString(16);
  while(color.length < 6) {
      color = "0" + color;
  }
  wc.style.color = "#" + color;
}
wc.onclick = () => {
  setTimeout(helloColor, 3000);
};
console.log("2.11.");
console.log("Hello world color changes on click, 3 secs.");


// 12. Walk the DOM
// Define function walkTheDOM(node, func)
//
// This function should traverse every node in the DOM. Use recursion. On each
// node, call func(node).

function walkTheDOM(node,func){
	  var child = node.children;
	  func(node);
	  for(var i = 0; i < child.length; i++){
	    walkTheDom(child[i], func);
	  }
	}
	console.log("2.12");
	console.log("walkTheDOM");

