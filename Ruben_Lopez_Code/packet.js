/**
 * 
 */


//JavaScript

console.log("hey, guyzzzz");
//1. Fibonacci
//Define function: fib(n) 
//Return the nth number in the fibonacci sequence.

let num1 = 10;
let num2 =  num1;
num1 = 25;
console.log(num1);
console.log(num2);


let numA  =5;

let numberA = 34;

function fib(numA) {
	
	
	if (numA <= 1){
		return 1;
	}
	
	return fib(numA-1) + fib(numA-2);
}


//2. Bubble Sort
//Define function: bubbleSort(numArray)
//Use the bubble sort algorithm to sort the array.
//Return the sorted array.


//array to sort
var array = [9, 2, 5, 6, 4, 3, 7, 10, 1, 8];


function swap(numArray, i, j) {
  let temp = numArray[i];
  numArray[i] = numArray[j];
  numArray[j] = temp;
}


function bubbleSort(numArray) {
  for(let i = 0; i < numArray.length; i++) {
    for(let j = 1; j < numArray.length; j++) {
      if(numArray[j - 1] > numArray[j]) {
        swap(numArray, j - 1, j);
      }
    }
  }
  return array;
}

console.log(bubbleSort(array)); 


//3. Reverse String
//Define function: reverseStr(someStr)
//Reverse and return the String.

function Reverse(str) {
	let reversed = "";
	for (let i = str.length - 1 ; i>= 0 ; i--) {
		reversed += str[i];
	}
	return reversed;
}

//4. Factorial
//Define function: factorial(someNum)
//Use recursion to compute and return the factorial of someNum.


function Factorial(n) {
	let fact = 1;
	for (let i = 1 ; i < n +1 ; i++){
		fact = fact * i;
	}
	return fact;
}

console.log(Reverse("hello"));
//6. Even Number
//Define function: isEven(someNum)
//Return true if even, false if odd.
//Do not use % operator.

function isEven(someNum){
	let flag = true;
	for (let i = 0 ; i < someNum ; i++){
		if (flag==true){
			flag = false;
		} else {
			flag = true;
		}
	}
	return flag;
	
}

console.log(isEven(2));


//5. Substring
//Define function substring(someStr, length, offset)
//Return the substring contained between offset and (offset + length) inclusively.
//If incorrect input is entered, use the alert function and describe why the input was incorrect.

function substring(someStr, length, offset){
	if (offset < 0){
		alert("wat are you doing ?")
	} else if ( length+offset > someStr.length){
		alert("The off set is to big")
	} else {
		return someStr.substr(offset, length);
	}
}
var someStrA = "California";
console.log(substring(someStrA, 2,2))

//7. Palindrome
//Define function isPalindrome(someStr)
//Return true if someStr is a palindrome, otherwise return false


function isPalindrome(someStr){
	
	for ( let i = 0 , j = (someStr.length -1) ; i < someStr.length ; i++ , j--){
		if (someStr[i] != someStr[j]){
			return false;
		}
	}
	return true;
}

var someStrB = "hjjh";
console.log(isPalindrome(someStrB));


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

document.write("<br>");
function printShapes(shape, height, c){
	
	switch(shape){
		case "Square":
			for (let i = 0 ; i < height ; i++) {
				for (let j = 0 ; j < height ; j++){
					document.write(c);
					console.log(c);
				}
				document.write("<br>");
				console.log("<br>");
			}
		break;
		case "Triangle" :
			for(var i =0; i<height;i++){
				for ( j = 0 ; j<=i;j++) {
					document.write(c);
					console.log(c);
				}
				document.write("<br>");
				console.log("<br>");
			}
		break;
		case "Diamond":
			for(var i=0;i<height;i+=2) {
				for(var k=0;k<=height/2-i;k++) {
					document.write("&nbsp");
					console.log(" ");
				}
				for(var j=0;j<=i;j++) {
					document.write(c);
					console.log(c);
				}
				document.write("<br>");
				console.log("<br>");
			}
			for(var i=height-2;i>=0;i-=2) {
				for(var k=0;k<=(height-i)/2;k++) {
					document.write("&nbsp");
					console.log(" ");
				}
				for(var j=0;j<i;j++) {
					document.write(c);
					console.log(c);
				}
				document.write("<br>");
				console.log("<br>");
			}
		break;
	}
	
}

console.log(printShapes("Square", 3 , '+'));
console.log(printShapes("Triangle" , 5 , '8'));
console.log(printShapes("Diamond" , 5 , '8'));



/*

 * 9. Object literal

Define function traverseObject(someObj)

Print every property and it's value.

 * */

//9. Object literal
//Define function traverseObject(someObj)
//Print every property and it's value.


let num = 5;

function transversObject(obj){

    

    for (let propName in obj ){

        propValue = obj[propName]

        console.log(propName,propValue);

    }

        

    

}

/*

var person = {

        firstName:"Giovanni",

        lastName:"Maldonado",

        age:39,

        eyeColor:"green"

};

/*

 * Delete Element

Define function deleteElement(someArr)

Print length

Delete the third element in the array.

Print length

The lengths should be the same.

 * 

 * var cars = [];

*/

let arr = [1,2,3,4,5,6];

function deleteElement(arr){

    console.log(arr.length)

    delete arr[4];

    console.log(arr.length)

}

/*

11. Splice Element

Define function spliceElement(someArr)

Print length

Splice the third element in the array.

Print length

The lengths should be one less than the original length.

*/

let myArr = [1,2,3,4,5,6,7,8,9];

function spliceDele(myArr){

    console.log(myArr.length);

    newArr = myArr.splice(2,5);

    console.log(newArr.length);

}

/*

 * 12. Defining an object using a constructor

Define a function Person(name, age)

The following line should set a Person object to the variable john:

    var john = new Person("John", 30);

 */

//class Person {

//  constructor() {

//      this.name = "John";

//      this.age = 30;

//  }

//  

//  

//}

var Person = function(name, age){

    this.name = name;

    this.age = age;

    

    this.setAge = function(age){

        this.age = age;

    };

    this.toString = function(){

        return ["Name =" ,this.name, ",Age" , this.age].john("");

    }

};

//var person1 = new Person();

//console.log(person1.name);

//console.log(person1.age);

/*

 * 13. Defining an object using an object literal

Define function getPerson(name, age)

The following line should set a Person object to the variable john:

    var john = getPerson("John", 30);

 

 */

function getPerson(name, age){

    return new Person(name,age)

}

var john = getPerson("john", 30);

//1. USA
//Define function getUSA()
//Find the html element that contains "USA".
//Print that element's contents.

function get_USA() {
	let findtext = "USA";
	let tagValue = document.body.getElementsByTagName("span");
	for (let i = 0; i < tagValue.length; i++){
		let booleanVar = tagValue[i].textContent.search(findtext);
		if(booleanVar != -1){
			alert(tagValue[i].textContent);
			break;
		}
	}
}

//2. Sales
//Define function getPeopleInSales()
//Print the names of all the people in the sales department.


function get_People_In_Sales() {
	
	//Cycle thru table and getting the first element of table
	let numRows = document.body.getElementsByTagName("tr");
	for (let i = 0; i < numRows.length; i++) {
		let cells = numRows[i].cells;
		if(cells[1].innerHTML=="Sales"){
			console.log(cells[0].innerHTML);
		}
	}
}

//3. Click Here
//Define function getAnchorChildren()
//Find all anchor elements with a <span> child.
//Print the contents of <span>

function getAnchorChildern(){
	let anchValue = document.body.getElementsByTagName("a");
	console.log(anchValue);
	for(let i=0; i< anchValue.length ; i++){
		if(anchValue[i].getElementsByTagName("span").length==1){
			console.log(anchValue[i].getElementsByTagName("span")[0].innerHTML);
		}
	}
}

//4. Hobbies
//Define function getHobbies()
//Find all checked options in the 'skills' select element.
//Print the value and the contents.  

function getHobbies(){
	let hobbi = document.getElementsByName("hobbies")[0];
	let selecthobbies = hobbi.options[hobbi.selectedIndex].value;
	let contenthobbies = hobbi.options[hobbi.selectedIndex].textContent;
	alert(contenthobbies + ";" + selecthobbies);
	
	let skills = document.getElementsByName("skills")[0];
	let selectSkills = skills.options[skills.selectedIndex].value;
	let contentSkills = skills.options[skills.selectedIndex].textContent;
	alert(contentSkills + ";" + selectSkills);
}

//5. Custom Attribute
//Define function getCustomAttribute()
//Find all elements with "data-customAttr" attribute
//Print the value of the attribute.

function getCustomAttribute(){
	let element11 = document.querySelectorAll('[data-customAttr]');
	for (let i = 0 ; i < element11.length ; i++){
		alert(element11[i].dataset.customattr);
	}
}

//6. Sum Event
//Regarding these elements:
//    <input id="num1" class="nums" type="text"/>
//    <input id="num2" class="nums" type="text"/>
//    <h3>Sum: <span id="sum"></span></h3>
//upon refresh, will calculate the function
(function sum(ele){
	//Declare variable
	let a,b,c;
	//Get first input
	a=Number(document.getElementById("num1").value);
	//Get second input
	b=Number(document.getElementById("num2").value);
	//Check condition
	if(isNaN(a) )
	{
     //Print message
     document.getElementById("sum").innerHTML='Cannot add';
	}
	//Check condition
	else if(isNaN(b))
	{
     //Print message
     document.getElementById("sum").innerHTML='Cannot add';
	}
	//Else
	else
	{
		//Find value
		c= a + b;
		//Print sum
		document.getElementById("sum").innerHTML= c;
	}

})();
//7. Skills Event
//When user selects a skill, create an alert with a message similar to:
//    "Are you sure CSS is one of your skills?"
//NOTE: no alert should appear when user deselects a skill.


document.addEventListener('DOMContentLoaded',load);
var skills5 = "";

function load() {
	skills5 = firstForm.skills;
	skills5.addEventListener('change',option_change);
}

function option_change() {
	alert("Are you sure" +skills5.options[skills5.selectedIndex].text+" is one of your skills?");
	return false;
}

//8. Favorite Color Event
//NOTE: This is regarding the favoriteColor radio buttons.
//When a user selects a color, create an alert with a message similar to:
//    "So you like green more than blue now?"
//In this example, green is the new value and blue is the old value.
//Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor
//

document.addEventListener('DOMContentLoaded',load1);

function load1() {
	
	colors1 = document.getElementsByName("colors")[0];
	colors1.addEventListener('change', changeColor);
}

var colors = document.getElementsByName("colors")[0];
var body = document.getElementsByTagName("body");
var i;
var old;


old=colors.options[colors.selectedIndex].value;


function changeColor(){



alert("So you like "+ colors.options[colors.selectedIndex].value + " more than "+ old +" now?");
old=colors.options[colors.selectedIndex].value;

body[0].style.backgroundColor=old;

}

//9. Show/Hide Event
//When user hovers over an employees name:
//    Hide the name if shown.
//    Show the name if hidden.

this.onmouseover=function(e){
	if(e.target.className=="empName"){
		if(e.target.style.fontSize==""){
			e.target.style.fontSize="0px";
		} else if (e.target.style.fontSize=="0px") {
			e.target.style.fontSize="16px";
		} else if (e.target.style.fontSize=="16px"){
			e.target.style.fontSize="0px"
		}
	}
}
//10. Current Time
//Regarding this element:
//    <h5 id="currentTime"></h5>
//Show the current time in this element in this format: 9:05:23 AM
//The time should be accurate to the second without having to reload the page.

function setTime() {

    var today = new Date();

    var hour = today.getHours();

    var minute = today.getMinutes();

    var second = today.getSeconds();

    var prepand = (hour >= 12)? " PM ":" AM ";

    document.getElementById("currentTime").innerHTML = (hour + ":" + minute + ":" + second + prepand);

}

setTime();

window.setInterval(function(){

    setTime();

}, 1000);

//11. Delay
//Regarding this element:
//    <p id="helloWorld">Hello, World!</p>
//Three seconds after a user clicks on this element, change the text to a random color.
document.getElementById("helloWorld").addEventListener("click",colorChange);

function colorChange(){
	setTimeout(function() {
		
		document.getElementById("helloWorld").style.color = '#' + 
		Math.floor(Math.random() * 16777215).toString(16);
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

walkTheDOM(document.body, function(node){
	
	if (node.nodeType===3){ //checks if it is a text node
		
		let text = node.data.trim();
		
		if(text.length > 0) { //checks if it has non-white space content
			console.log(text);
		}
	}
});

