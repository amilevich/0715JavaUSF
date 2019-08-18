/**
 * 
 */

//Part1
//Create a single Javascript file called packet.js to answer these questions.
//Please put the question itself as a comment above each answer.

/*
1. Fibonacci
Define function: fib(n) 
Return the nth number in the fibonacci sequence.
*/

let j = 1;
let arr ="";
function fibonacci(numberFibo,i, k){
	if(numberFibo > 0){
		arr += " " + i;
		j = j + k;		
		fibonacci(numberFibo - 1, j, i);
	}return arr;
}

let n = 30;
arr = fibonacci(n,0,0);
console.log(arr);

//2. Bubble Sort
//Define function: bubbleSort(numArray)
//Use the bubble sort algorithm to sort the array.
//Return the sorted array.


arr = [1,0,5,6,3,2,3,7,9,8,4];

function bubbleSort(arr){
	let n  =  arr.length;
	 for(i = 0 ; i < n ; i++) {
		 for(j = i + 1 ; j < n - i; j++) {
			 if(arr[j-1] > arr[j]) {
				temp = arr[j-1];
				arr[j-1] = arr[j];
				arr[j] = temp;
			 }		 
			 
		 }
	 }
	 return arr;
}

console.log(arr.toString());
arr = bubbleSort(arr);
console.log(arr.toString());

//3. Reverse String
//Define function: reverseStr(someStr)
//Reverse and return the String.

arr = "Hello everybody how are you? I hope you are ok...";
n = arr.length;
console.log(arr);
function reverString(arr){	
	let arr1 = "";
	for(i = n - 1; i >= 0 ; i--){
		arr1 +=  arr[i];
	}
	return arr1;
}

console.log(reverString(arr));

//4. Factorial
//Define function: factorial(someNum)
//Use recursion to compute and return the factorial of someNum.


n = 7;
j = 1;

function factorialN(n) {
	if(n > 0) {
		j  *= n;//j = j*n
		factorialN(n-1);
	}
	return j;
}

console.log(factorialN(n));

//5. Substring
//Define function substring(someStr, length, offset)
//Return the substring contained between offset and (offset + length) inclusively.
//If incorrect input is entered, use the alert function and describe why the input was incorrect.


let someStr = "Hello everybody how are you? I hope you are ok...";
let length = someStr.length;
let offset = 30;
console.log(someStr);
function substring(someStr, length, offset){
	return someStr.substring(offset , length);
}

console.log(substring(someStr, length, offset))

function substring1(someStr, length, offset){
	return someStr.substr(offset , length);
}

console.log(substring1(someStr, length, offset))

//6. Even Number
//Define function: isEven(someNum)
//Return true if even, false if odd.
//Do not use % operator.

let number = 12;

function verify(number){
	if(number - (Math.floor(number/2) * 2)  == 0){
		return true;
	}else{
		return false;
	}
}

console.log(verify(number));

//7. Palindrome
//Define function isPalindrome(someStr)
//Return true if someStr is a palindrome, otherwise return false

arr = "hello";
n = arr.length - 1;
let arr1 = "";

function isPalindrome(arr, n ){
	
	if(n >= 0){
		arr1 += arr[n];
		isPalindrome(arr, n-1 )
	}
	
	if(arr1 == arr){
		return true;
	}else{
		return false;
	}
}

console.log(isPalindrome(arr,n));

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
//*
//***
//*****
//***
//*

let height = 17;
let shape = "Diamond";
let character = "*";
arr = "";

function printShape(shape, height, character){
	if((height % 2) != 0){
		switch (shape) {
			case "Square": let arr1 = Square(height, character) 
			               let printC= "";
							
						   for(j = 0; j < height; j++) {
							   printC += `${arr1}  
	`;
						   }
						   console.log(printC);
						   break;
			case "Triangle": Triangle(height, character); 
						    break;
			case "Diamond": Diamond(height, character)
							break;
			default: concole.log("It is not in the list");
				break;
		}
	}
}

function Square(height, character){
	for(i = 0; i < height; i++){
		arr += character;
	}
	return arr;
}

function Triangle(height, character) {
	let arr1 = "";
	let printC= "";
	for(i = 1 ; i < height + 1; i++) {
		for(j = 1; j <= i; j++) {
			arr1 += character;		
		}	
		printC += `${arr1}
`;
		arr1 = "";
	}
	
	console.log(printC);
	
}

function Diamond(height, character){
	let n = Math.floor(height/2) + 1;
	let m = 1;
	let printC= "";
	let arr = "";
	for(i = 1; i <= height; i++){
		if(i <= (n - 1)){
			for(j = 1; j <= height ; j++){
				if((j <= (n - i) || j >= (n + i)) ){
					arr += " ";
				}else{
					arr += character;
				}				
			}
			printC += `${arr}
`;
			
		}else if(i == n){
			for(j = 1; j <= height ; j++){
				arr += character;
			}
			printC += `${arr}
`;
		}else if(i >= (n + 1)){
			for(j = 1; j <= height ; j++){
				if(j <= m || j > (height - m) ){
					arr += " ";
				}else{
					arr += character;
				}				
			}
			printC += `${arr}
`;
			m++;	
		}
		
		arr = "";
	}
	console.log(printC);
}



printShape(shape, height, character);


//9. Object literal
//Define function traverseObject(someObj)
//Print every property and it's value.

let someObj = {		
		name : "John Lemos",
		age : 30,
		address : "1234 Newfiels St Charlotte NC, 28216",
		"phone" : '234-980-9087'
};

function traverseObject(someObj)
{
	console.log(someObj.name);
	console.log(someObj.age);
	console.log(someObj.address);
	console.log(someObj.phone);
}

traverseObject(someObj);

//10. Delete Element
//Define function deleteElement(someArr)
//Print length
//Delete the third element in the array.
//Print length
//The lengths should be the same.

let someArr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 0];

function deleteElement(someArr){
	console.log(someArr.length);
	delete someArr[3];
	console.log(someArr.length);
}

deleteElement(someArr);

//11. Splice Element
//Define function spliceElement(someArr)
//Print length
//Splice the third element in the array.
//Print length
//The lengths should be one less than the original length.

someArr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 0];

function spliceElement(someArr){
	console.log(someArr.length);
	someArr.splice(2,1);
	console.log(someArr.length);
	
}

spliceElement(someArr);

//12. Defining an object using a constructor
//Define a function Person(name, age)
//The following line should set a Person object to the variable john:
//    var john = new Person("John", 30);

function Person(name, age){
	this.name = name;
	this.age = age;
}

var john = new Person("John", 30);

console.log(john.name);
console.log(john.age);

//13. Defining an object using an object literal
//Define function getPerson(name, age)
//The following line should set a Person object to the variable john:
//    var john = getPerson("John", 30);


var object = {
		getPerson : function (name, age){
			return name + " " + age;
		}		
};

var john = object.getPerson("John", 30);

console.log(john);

//-----------------------------------------------------------------------------------
//PART II
//
//Part II will focus on Javascript's ability to manipulate the DOM.
//Use the provided index.html -> Git Repo -> Alex branch 
//Put your Javascript in the provided <script> element at the bottom of the page.
//Please put the question itself as a comment above each answer.
//-----------------------------------------------------------------------------------
//
//1. USA
//Define function getUSA()
//Find the html element that contains "USA".
//Print that element's contents.
 
function getUSA() {
    var searchText = "USA";
   var aTags = document.body.getElementsByTagName("*");
    for (i = 0; i < aTags.length; i++) {
       var n = aTags[i].textContent.search(searchText);
       if(n != -1){
          console.log(aTags[i].textContent);
          break;
       }
     
    }
  
}
getUSA();

//function getUSA(){
//	document.getElementById("USA").innerHTML = "Hello USA, nice Country to live";
//}
//
//getUSA();

//2. Sales
//Define function getPeopleInSales()
//Print the names of all the people in the sales department.


function getPeopleInSales(){
	   var table = document.getElementsByTagName("td")[0];
	   for (i = 0; i < table.rows ; i++){
	    var cells = table.rows[i].cells;
	        if(cells[1].textContent === "Sales"){
	          console.log(cells[0].textContent);
	       }
	   }
	  
	}
getPeopleInSales();
//3. Click Here
//Define function getAnchorChildren()
//Find all anchor elements with a <span> child.
//Print the contents of <span>

function getAnchorChildren(){

var anchor = [];

var searchElement = document.getElementById("children").children;

for(var i = 0; i < searchElement.length; i++) {

   if(searchElement[i].tagName == 'SELECT' || searchElement.tagName == 'INPUT') {

       if(searchElement[i].id.indexOf('q1_') == 0) {

           anchor.push(searchElement[i]);

       }

   }

}

}
getAnchorChildren();
//4. Hobbies
//Define function getHobbies()
//Find all checked options in the 'skills' select element.
//Print the value and the contents.  

var Hobbies = {
		getHobbies:function(name){
			return name;
		}
}

function myHobbies(){
	var hobby1 = Hobbies.getHobbies("Read");
	var slt = document.getElementById('hobby');
	var z = document.createElement("option");
	var t = document.createTextNode(hobby1);
	z.appendChild(t);
	slt.appendChild(z);
	hobby1 = Hobbies.getHobbies("Dance");
	z = document.createElement("option");
	t = document.createTextNode(hobby1);
	z.appendChild(t);
	slt.appendChild(z);
	hobby1 = Hobbies.getHobbies("Rice Motorcycle");
	z = document.createElement("option");
	t = document.createTextNode(hobby1);
	z.appendChild(t);
	slt.appendChild(z);
	hobby1 = Hobbies.getHobbies("Watch movies");
	z = document.createElement("option");
	t = document.createTextNode(hobby1);
	z.appendChild(t);
	slt.appendChild(z);
	hobby1 = Hobbies.getHobbies("Build networks");
	z = document.createElement("option");
	t = document.createTextNode(hobby1);
	z.appendChild(t);
	slt.appendChild(z);
}

myHobbies();

//5. Custom Attribute
//Define function getCustomAttribute()
//Find all elements with "data-customAttr" attribute
//Print the value of the attribute.
//Print the element that has the attribute.

function getCustomAttribute(){
	var elements = document.querySelectorAll('[data-customAttr]');
	for (var i = 0; i <elements.length;i++){
	   alert(elements[i].dataset.customattr);
	  }
}
getCustomAttribute();
//6. Sum Event
//Regarding these elements:
//    <input id="num1" class="nums" type="text"/>
//    <input id="num2" class="nums" type="text"/>
//    <h3>Sum: <span id="sum"></span></h3>
//
//Define onchange event handler.
//Add <input> element values.
//Put the sum in the <span> element.
//If values cannot be added, put "Cannot add" in the <span> element

//var buttonOne = document.getElementById('add');
//buttonOne.addEventListener('change',myFunction);
//click

var numbers = document.getElementsByClassName('nums');
numbers[0].addEventListener('change', myFunction1);
numbers[1].addEventListener('change', myFunction2);
var span = document.getElementById('sum');

function myFunction1(eve){		
	if(!isNaN(numbers[0].value) && !isNaN(numbers[1].value)){
		
		span.innerHTML = parseInt(numbers[0].value) + parseInt(numbers[1].value);
	}else{
		span.innerHTML = "Cannot add";
	}	
}

function myFunction2(eve){	
	let a = numbers[0].value;
	let b = numbers[1].value;
	if(!isNaN(numbers[0].value) && !isNaN(numbers[1].value)){
		span.innerHTML = parseInt(numbers[0].value) + parseInt(numbers[1].value);
	}else{
		span.innerHTML = "Cannot add";
	}	
}

//7. Skills Event
//When user selects a skill, create an alert with a message similar to:
//    "Are you sure CSS is one of your skills?"
//NOTE: no alert should appear when user deselects a skill.


var selection = document.getElementById("skills");

selection.addEventListener("change",myFunction3,false);

function myFunction3(event){
	console.log(event.type)
	alert("Are you sure CSS is one of your skills");
}

//8. Favorite Color Event
//NOTE: This is regarding the favoriteColor radio buttons.
//When a user selects a color, create an alert with a message similar to:
//    "So you like green more than blue now?"
//In this example, green is the new value and blue is the old value.
//Make the background color (of all favoriteColor radio buttons) 
//the newly selected favoriteColor

var colors = document.getElementsByName("colors");
var body = document.getElementsByTagName("body");
var i;
var old;
for(i=0;i<colors.length;i++){

old=colors[i].value;

}
function changeColor(){
var i;

for(i=0;i<colors.length;i++){
alert("So you like "+ colors[i].value + " more than "+ old +" now?");
old=colors[i].value;

body[0].style.backgroundColor=old;
}
}

changeColor();

//9. Show/Hide Event
//When user hovers over an employees name:
//    Hide the name if shown.
//    Show the name if hidden.

this.onmouseover=function(e){
	if(e.target.className=="empName"){
	if(e.target.style.fontSize==""){
	e.target.style.fontSize="0px";
	}
	else if(e.target.style.fontSize=="0px"){
	e.target.style.fontSize="16px";
	}
	else if(e.target.style.fontSize=="16px"){
	e.target.style.fontSize="0px";
	}
	}
	}


//10. Current Time
//Regarding this element:
//    <h5 id="currentTime"></h5>
//Show the current time in this element in this format: 9:05:23 AM
//The time should be accurate to the second without having to reload the page.

function showTime() {

    var today = new Date();
    var hour = today.getHours();
    var minute = today.getMinutes();
    var second = today.getSeconds();
    var prepand = (hour >= 12)? " PM ":" AM ";

    document.getElementById("currentTime").innerHTML = (hour + ":" + minute + ":" + second + prepand);

}
showTime();
window.setInterval(function(){

    showTime();

}, 1000);
//11. Delay
//Regarding this element:
//    <p id="helloWorld">Hello, World!</p>
//Three seconds after a user clicks on this element, change the text to a random color.

function colorChange() {

    setTimeout(function() {

                    document.getElementById("helloWorld").style.color = '#' + Math.floor(Math.random() * 16777215).toString(16);

    }, 3000);

}


//12. Walk the DOM
//Define function walkTheDOM(node, func)
//This function should traverse every node in the DOM. Use recursion.
//On each node, call func(node).

function walkTheDOM(node, func) {

	func(node);
	node = node.firstChild;

	    while (node) {

	    walkTheDOM(node, func);
	node = node.nextSibling;

	    }

	}

	walkTheDOM(document.body, function (node) {

	    if (node.nodeType === 3) {

	    var text = node.data.trim();

	    if (text.length > 0) { 

	    console.log(text);

	    }

	}

	});



