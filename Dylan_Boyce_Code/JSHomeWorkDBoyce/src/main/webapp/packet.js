/**
 * 
 */


//1. Fibonacci
//Define function: fib(n) 
//Return the nth number in the fibonacci sequence.

function fib(n){
	let a = 1;
	let b = 0;
	let temp;
	
	while (n >=0){
		temp = a;
		a = a + b;
		b= temp;
		n--;
		console.log(b);
	}
}


//2. Bubble Sort
//Define function: bubbleSort(numArray)
//Use the bubble sort algorithm to sort the array.
//Return the sorted array.
let tempArray = [5,3,77,85,44,5,2,1];

function bubbleSort(numArray){
	
	let arr = numArray;
	for(let i = 0; i<arr.length - 1; i++){
		for(let j =0; j<arr.length-i-1;j++){
			if(arr[j] > arr[j+1]){
				let temp = arr[j];
				arr[j]=arr[j+1];
				arr[j+1] = temp;
			}
		}
		
	}
	console.log(arr);
	return arr;
}
 
//3. Reverse String
//Define function: reverseStr(someStr)
//Reverse and return the String.
 function reverseStr(someStr){
	 let strArr = someStr.split("");
	 let reverseArr = strArr.reverse();
	 let joinArr = reverseArr.join("");
	 console.log(joinArr);
	 return joinArr;
 }

//4. Factorial
//Define function: factorial(someNum)
//Use recursion to compute and return the factorial of someNum.

function factorial(someNum){
	if(someNum == 0){
		return 1;
	}else{
		return someNum * factorial(someNum - 1);
	}
}

//5. Substring
//Define function substring(someStr, length, offset)
//Return the substring contained between offset and (offset + length) inclusively.
//If incorrect input is entered, use the alert function and describe why the input was incorrect.
function substring(someStr, length, offset){
	if(length > someStr.length | length+offset > someStr.length){
		alert("Your length or offset numbers are outside of the length of your String")
	}else{
	let sub = someStr.substring(offset,(length+offset));
	return sub;
	}
}


//6. Even Number
//Define function: isEven(someNum)
//Return true if even, false if odd.
//Do not use % operator.

function isEven(someNum){
	let sum = someNum/2;
	if(sum == Math.floor(sum)){
		return true;
	}else{
		return false;
	}
}

//7. Palindrome
//Define function isPalindrome(someStr)
//Return true if someStr is a palindrome, otherwise return false

function isPalindrome(someStr){
	 let strArr = someStr.split("");
	 let reverseArr = strArr.reverse();
	 let joinArr = reverseArr.join("");
	 if(someStr == joinArr){
		 return true;
	 }else{
		 return false;
	 }
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

function printShape(shape,height,character){
	switch(shape){
	
	case 'Square':
		for (let i = 0 ; i < height ; i++) {
            for (let j = 0 ; j < height ; j++){
                console.log(character);
	}
            console.log("<br>");
}
		break;
		case "Triangle":
		for(var i =0; i<height;i++){
            for ( j = 0 ; j<=i;j++) {
            	document.write(character);
                console.log(character);
	}
            console.log("<br>")
            document.write("<br>");
	}
		break;
		case 'Diamond':
			for(var i=0;i<height;i+=2) {
                for(var k=0;k<=height/2-i;k++) {
                    document.write(" ");
                    console.log(" ");
                }
                for(var j=0;j<=i;j++) {
                    document.write(character);
                    console.log(character);
                }
                document.write("<br>");
                console.log("<br>");
            }
            for(var i=height-2;i>=0;i-=2) {
                for(var k=0;k<=(height-i)/2;k++) {
                    document.write(" ");
                    console.log(" ");
                }
                for(var j=0;j<i;j++) {
                    document.write(character);
                    console.log(character);
                }
                document.write("<br>");
                console.log("<br>");
            }
        break;
    }
    
}


//9. Object literal
//Define function traverseObject(someObj)
//Print every property and it's value.

let person2 = {
	name:'Dylan',
	age: 27,
	job: 'developer'
};
console.log(person);

//10. Delete Element
//Define function deleteElement(someArr)
//Print length
//Delete the third element in the array.
//Print length
//The lengths should be the same.
let anotherArr = [1,2,3,4,5,6,7,8,9]

function deleteElement(someArr){
	let length = someArr.length;
	console.log(length);
	let missing = delete someArr[2];
	console.log(someArr);
	console.log(someArr.length);
}


//11. Splice Element
//Define function spliceElement(someArr)
//Print length
//Splice the third element in the array.
//Print length
//The lengths should be one less than the original length.
function spliceElement(someArr){
	let length = someArr.length;
	console.log(length);
	let missing = delete someArr[2];
	
	console.log(someArr);
}


//12. Defining an object using a constructor
//Define a function Person(name, age)
//The following line should set a Person object to the variable john:
//	var john = new Person("John", 30);

function Person(name,age){
	this.name = name;
	this.age = age;
}

//13. Defining an object using an object literal
//Define function getPerson(name, age)
//The following line should set a Person object to the variable john:
//	var john = getPerson("John", 30);

 let person = {};
  function getPerson(name, age){
	  this.name = name;
	  this. age = age;
  }
 
 
 
//-----------------------------------------------------------------------------------
//PART II


//Part II will focus on Javascript's ability to manipulate the DOM.
//Use the provided index.html -> Git Repo -> Alex branch 
//Put your Javascript in the provided <script> element at the bottom of the page.
//Please put the question itself as a comment above each answer.
//-----------------------------------------------------------------------------------

//1. USA
//Define function getUSA()
//Find the html element that contains "USA".
//Print that element's contents.

function getUSA(){
	let usa =document.getElementsByTagName('span')[2];
	console.log(usa);
}

//2. Sales
//Define function getPeopleInSales()
//Print the names of all the people in the sales department.

function getPeopleInSales(){
	let tdLength = document.getElementsByTagName('td').length;
	for(let i = 0;i<tdLength;i++){
		if ((document.getElementsByTagName('td')[i].innerText) == "Sales" & (document.getElementsByTagName('td')[i].innerText) != undefined){
			let result = document.getElementsByTagName('td')[i-1].innerText;  
			console.log(result);
		}
	}
}


//3. Click Here
//Define function getAnchorChildren()
//Find all anchor elements with a <span> child.
//Print the contents of <span>

function getAnchorChildren(){
	let aLength = document.getElementsByTagName('a').length;
	for(let i = 0;i<aLength;i++){
		if(document.getElementsByTagName('a')[i].children[0] != undefined){
			let result =document.getElementsByTagName('a')[i].children[0].textContent
			console.log(result);
		}
	}
}

//4. Hobbies
//Define function getHobbies()
//Find all checked options in the 'skills' select element.
//Print the value and the contents.
  
function getHobbies(){                                           //returns undefined, figure out why
	let SelectID = document.getElementsByTagName('select').length;
	let optionIndex=document.getElementsByTagName('option').length;
	for(let i=0;i<SelectID.length;i++){
			if(document.getElementsByTagName('select')[i].getAttribute('name')=="skills"
				& document.getElementsByTagName('select')[i].getAttribute('name')!=undefined){
				for(let j=0;j<optionIndex;j++){
					if(document.getElementsByTagName('option')[j].getAttribute('select')=="selected"
						& document.getElementsByTagName('option')[j].getAttribute('select')!=undefined){
						console.log(document.getElementsByTagName('option')[j].getAttribute('value'));
						console.log(document.getElementByTagName('option')[j].innerText);
					}
			}
		}
	}
}

//5. Custom Attribute
//Define function getCustomAttribute()
//Find all elements with "data-customAttr" attribute
//Print the value of the attribute.
//Print the element that has the attribute.

function getCustomAttribute(){
	let index = document.getElementsByTagName('*').length;
	for(let i =0;i<index;i++ ){
		if(document.getElementsByTagName('*')[i].getAttribute('data-customAttr')!= null 
				| document.getElementsByTagName('*')[i].getAttribute('data-customAttr')!= undefined){
			console.log(document.getElementsByTagName('*')[i]
					+ " " + document.getElementsByTagName('*')[i].getAttribute('data-customAttr'));
		}
	}
}

//6. Sum Event
//Regarding these elements:
//	<input id="num1" class="nums" type="text"/>
//	<input id="num2" class="nums" type="text"/>
//	<h3>Sum: <span id="sum"></span></h3>

//Define onchange event handler.
//Add <input> element values.
//Put the sum in the <span> element.
//If values cannot be added, put "Cannot add" in the <span> element

let num1 = document.getElementById('num1');
let num2 = document.getElementById('num2');
num1.addEventListener('change', addNum(num1,num2));
num2.addEventListener('change', addNum(num1,num2));

function addNum(num1,num2){
	let sum=num1+num2;
	if(typeof sum != typeof 1){
		document.getElementById('sum').innerText = "Cannot Add";
	}else{
	document.getElementById('sum').innerText = sum;
	}
}

//7. Skills Event
//When user selects a skill, create an alert with a message similar to:
//	"Are you sure CSS is one of your skills?"
//NOTE: no alert should appear when user deselects a skill.


let skills = "";
(function(){
	skills = firstForm.skills;
	skills.addEventListener('change',skillAlert);
})();
function skillAlert(){
	alert("Are you sure " + skills.options[skills.selectedIndex].text + " is one of your skills?");
	return false;
}


//8. Favorite Color Event
//NOTE: This is regarding the favoriteColor radio buttons.
//When a user selects a color, create an alert with a message similar to:
//	"So you like green more than blue now?"
//In this example, green is the new value and blue is the old value.
//Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor
let colors = document.getElementsByName("favoriteColor")[0];
(function(){
	
	colors = document.getElementsByName('favoriteColor')[0];
	colors.addEventListener('change', changeColor);
})();

	colors = document.getElementsByName("favoriteColor")[0];
let body = document.getElementsByTagName("body");
let i;
let preColor = 'white'  //colors.inputs[colors.selectedIndex].value;
function changeColor(){
alert("So you like "+ colors.inputs[colors.selectedIndex].value + " more than "+ preColor +" now?");
preColor =colors.inputs[colors.selectedIndex].value;
body[0].style.backgroundColor = preColor;
}


//9. Show/Hide Event
//When user hovers over an employees name:
//	Hide the name if shown.
//	Show the name if hidden.

let empName = document.getElementByClassName


//10. Current Time
//Regarding this element:
//	<h5 id="currentTime"></h5>
//Show the current time in this element in this format: 9:05:23 AM
//The time should be accurate to the second without having to reload the page.

(function startTime() {
	  let today = new Date();
	  let h = today.getHours();
	  let m = today.getMinutes();
	  let s = today.getSeconds();
	  m = checkTime(m);
	  s = checkTime(s);
	  document.getElementById('currentTime').innerHTML =
	  h + ":" + m + ":" + s;
	  var t = setTimeout(startTime, 500);
	})();
	function checkTime(i) {
	  if (i < 10) {i = "0" + i};  // add zero in front of numbers < 10
	  return i;
	}
	
	
//11. Delay
//Regarding this element:
//	<p id="helloWorld">Hello, World!</p>
//Three seconds after a user clicks on this element, change the text to a random color.
	document.getElementById('helloWorld').addEventListener("click",colorClick);

	function colorClick(){
		setTimeout(function(){
			document.getElementById('helloWorld').style.color='#' + Math.floor(Math.random() * 16777215).toString(16);
		},3000);
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

