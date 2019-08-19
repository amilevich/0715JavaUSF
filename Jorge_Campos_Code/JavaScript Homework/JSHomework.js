/**
 * 
 */

/*1. Fibonacci
Define function: fib(n) 
Return the nth number in the fibonacci sequence.*/

function fib(n){
	if(n===1)
		return 0;
	else if(n===2)
		return 1;
	else
		return fib(n-1)+fib(n-2);
};

console.log(fib(4));

/*2. Bubble Sort
Define function: bubbleSort(numArray)
Use the bubble sort algorithm to sort the array.
Return the sorted array.
*/

function bubbleSort(numArray){
	for(let x = 0; x < (numArray.length-1); x++) {
		for(let y = 0; y < (numArray.length-1-x); y++) {
			if(numArray[y]>numArray[y+1]) {
				let temp = numArray[y];
				numArray[y] = numArray[y+1];
				numArray[y+1] = temp;
			}
		}
	}
	return numArray;
};

let test = [[5],[2],[1],[7]];
console.log(bubbleSort(test));


/*3. Reverse String
Define function: reverseStr(someStr)
Reverse and return the String.
*/

function reverseStr(someStr){
	
	return someStr.split('').reverse().join('');
};

console.log(reverseStr("Testing"));


/*4. Factorial
Define function: factorial(someNum)
Use recursion to compute and return the factorial of someNum.
*/
function factorial(someNum){
	if(someNum==1) {
		return 1;
	}
	else
		return (someNum * factorial(someNum-1));
};
console.log(factorial(5));


/*5. Substring
Define function substring(someStr, length, offset)
Return the substring contained between offset and (offset + length) inclusively.
If incorrect input is entered, use the alert function and describe why the input was incorrect.
*/
function substring(someStr, length, offset){
	let subStr;
	let maxlength = someStr.length;
	
  if(typeof(someStr) === "string" && typeof(length)==="number" && typeof(offset)==="number"){
	if(length > maxlength)
		alert("Error, length entered is beyond length of entered string");
	else if(offset >= maxlength)
		alert("Error, offset entered is beyond length of entered string");
	else if(length+offset > maxlength)
		alert("Error, substring length entered is beyond length of entered string");
	else
		subStr= someStr.substring(offset,offset+length);
	}
	else if(typeof(someStr) !== "string")
		alert("Input string(parameter 1) is not of type string");
	else if(typeof(length) !== "number")
		alert("Input length(parameter 2) is not of type number");
	else if(typeof(offset) !== "number")
		alert("Input offset(parameter 3) is not of type number");
	return subStr;
};
let tests = "testing";
console.log(substring( tests,4,3));

/*6. Even Number
Define function: isEven(someNum)
Return true if even, false if odd.
Do not use % operator.
*/

function isEven(someNum){
	if((someNum&1)===0)
		return true;
	else 
		return false;
	
};
console.log(isEven(85));

/*7. Palindrome
Define function isPalindrome(someStr)
Return true if someStr is a palindrome, otherwise return false
*/
function isPalindrome(someStr){
	
	for(let i = 0; i < someStr.length/2; i++) {
		if(someStr.charAt(i) != someStr.charAt(someStr.length-i-1)) {
			return false;
			break;
		}
	}
	return true;
}
console.log("Palindrome: "+isPalindrome("racecar"));


/*8. Shapes
Define function: printShape(shape, height, character)
shape is a String and is either "Square", "Triangle", "Diamond".
*/


function printShape(shape, height, character){
	
	let temp = character;
	
	switch(shape){
	case("Square"):
		for(let i = 0; i<height; i++) {		//nested for loop to manage row and digits separately
			for(let j = 0; j<height-1; j++) {			
				temp +=character;			
			}
			console.log(temp);
			temp = character;
		}
		break;
	case("Triangle"):
		for(let i = 1; i<=height; i++) {		//nested for loop to manage row and digits separately
			for(let j = 0; j<i; j++) {			
				if(j!==0)
					temp +=character;			
			}
			console.log(temp);
			temp = character;
		}
		break;
	case("Diamond"):
		temp = "";
		for(let i = 0; i<(height/2); i++) {		//nested for loop to manage row and digits separately
			for(let j = 0; j<height; j++) {			
				if(j<((height/2)-i-1) || j>((height/2)+i))
					temp += " ";
				else
					temp +=character;			
			}
			console.log(temp);
			temp = "";
		}
		for(let i = height/2-1; i>=0; i--) {		//nested for loop to manage row and digits separately
			for(let j = 0; j<height; j++) {			
				if(j<((height/2)-i) || j>((height/2)+i-1))
					temp += " ";
				else
					temp +=character;			
			}
			console.log(temp);
			temp = "";
		}
		break;
	}	
};
printShape("Diamond",5,"@");

/*9. Object literal
Define function traverseObject(someObj)
Print every property and it's value.
*/
function traverseObject(someObj){
	for(let key in someObj){
		console.log(key+" : " +someObj[key])
	}
}
let obj ={
		name:"Testing",
		id: 7
};
traverseObject(obj);


/*10. Delete Element
Define function deleteElement(someArr)
Print length
Delete the third element in the array.
Print length
The lengths should be the same.*/
function deleteElement(someArr){
	console.log(someArr.length);
	someArr[2] = null;
	console.log(someArr.length);
}
let a=[2,2,3,4,5];
console.log(a);
deleteElement(a)
console.log(a)


/*11. Splice Element
Define function spliceElement(someArr)
Print length
Splice the third element in the array.
Print length
The lengths should be one less than the original length.*/

function spliceElement(someArr){
	someArr.splice(2,1);
}

let b=[1,2,3,4,5,6]
console.log(b)
spliceElement(b);
console.log(b);


/*12. Defining an object using a constructor
Define a function Person(name, age)
The following line should set a Person object to the variable john:
	var john = new Person("John", 30);
*/
function Person(name, age){
	this.name = name;
	this.age = age;
}
var john = new Person("John", 30);
console.log(john)

/*13. Defining an object using an object literal
Define function getPerson(name, age)
The following line should set a Person object to the variable john:
	var john = getPerson("John", 30);
*/

function getPerson(name, age){
	return obj = {name: name,age: age}
}
var john2 = getPerson("John2", 30);
console.log(john2)



/*-----------------------------------------------------------------------------------
PART II

Part II will focus on Javascript's ability to manipulate the DOM.
Use the provided index.html -> Git Repo -> Alex branch 
Put your Javascript in the provided <script> element at the bottom of the page.
Please put the question itself as a comment above each answer.
-----------------------------------------------------------------------------------
*/


/*1. USA
Define function getUSA()
Find the html element that contains "USA".
Print that element's contents.
*/

function getUSA(){
	let result = document.getElementsByTagName("h1");
	console.log(result[0]);
}
getUSA();


/*2. Sales
Define function getPeopleInSales()
Print the names of all the people in the sales department.
*/  
function getPeopleInSales(){
	let people = document.getElementsByTagName("tr");
	for(let i=0;i<people.length;i++){
		if(people[i].cells[1].innerHTML === "Sales")
			console.log(people[i].cells[0].innerHTML)
	}	
}
getPeopleInSales();

/*3. Click Here
Define function getAnchorChildren()
Find all anchor elements with a <span> child.
Print the contents of <span>
*/  
function getAnchorChildren(){
	let anchors = document.getElementsByTagName("a");	
	//console.log(anchors[0].innerHTML.indexOf("<span%>"))	 
	for(let i=0;i<anchors.length;i++){
		let temp = anchors[i].innerHTML;		
		if(temp.indexOf("<span") > 0){
			let start = temp.indexOf(">")+1;
			let end = temp.indexOf("</span>");
			console.log(temp.substring(start,end));
		}
		//console.log(anchors[i])
	}
}
getAnchorChildren();

/*4. Hobbies
Define function getHobbies()
Find all checked options in the 'skills' select element.
Print the value and the contents.
*/  
function getHobbies(){
	
}



/*5. Custom Attribute
Define function getCustomAttribute()
Find all elements with "data-customAttr" attribute
Print the value of the attribute.
Print the element that has the attribute.
*/
function getCustomAttribute(root){
	let results = [];
	attr = "data-customAttr"
	root = root || document.body;
    if(root.hasAttribute(attr)) {
    	console.log(root)
    	console.log(" : "+root.getAttribute(attr));
    	results += root;
        //return root;        
    }
    var children = root.children, element;
    for(var i = children.length; i--; ) {
       element = getCustomAttribute(children[i]);
       if(element)
    	   console.log(element+"has element")
    }	
}
getCustomAttribute();

/*6. Sum Event
Regarding these elements:
	<input id="num1" class="nums" type="text"/>
	<input id="num2" class="nums" type="text"/>
	<h3>Sum: <span id="sum"></span></h3>

Define onchange event handler.
Add <input> element values.
Put the sum in the <span> element.
If values cannot be added, put "Cannot add" in the <span> element
*/
function sum(){
	//console.log(document.getElementById("num1").innerHTML)
	let x = parseFloat(document.getElementById("num1").value);
	let y = parseFloat(document.getElementById("num2").value);
	let result = x + y;
	if((!isNaN(x)) && (!isNaN(y)) && (!isNaN(result)))
	  document.getElementById("sum").innerHTML =  result;
	else
		document.getElementById("sum").innerHTML =  "Cannot add";
}

/*7. Skills Event
When user selects a skill, create an alert with a message similar to:
	"Are you sure CSS is one of your skills?"
NOTE: no alert should appear when user deselects a skill.
*/
function alertSkills(){
	let skill = document.getElementsByName("skills")[0].value;
	alert(`Please confirm that ${skill} is one of your skills`);
}


/*8. Favorite Color Event
NOTE: This is regarding the favoriteColor radio buttons.
When a user selects a color, create an alert with a message similar to:
	"So you like green more than blue now?"
In this example, green is the new value and blue is the old value.
Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor
*/
function setRadioColor(color){
	
	let rbutton = document.getElementsByName("favoriteColor");
	console.log(rbutton)
	let prev = rbutton[0].style.backgroundColor;
	rbutton[0].style.backgroundColor = color;
	alert("So you like "+color+" more than "+prev+" now?");
	
}


/*9. Show/Hide Event
When user hovers over an employees name:
	Hide the name if shown.
	Show the name if hidden.
*/

let temp = document.getElementsByClassName("empName");
for(let i=0; i<temp.length; i++){
	document.getElementsByClassName("empName")[i].addEventListener("mouseenter",changeVisible());
}
function changeVisible(event){
	console.log("int change func")
	
	for(let i=0; i<temp.length; i++){
		temp[i].onmouseleave = function(){changeW(i)}
	}
	function changeW(num){
		console.log("int change change")
		if(temp[num].style.color == 'white')
			temp[num].style.color = 'black';
		else
			temp[num].style.color = 'white';
	}
};
changeVisible();



/*10. Current Time
Regarding this element:
	<h5 id="currentTime"></h5>
Show the current time in this element in this format: 9:05:23 AM
The time should be accurate to the second without having to reload the page.
*/
function setTime(){
	console.log(new Date().toLocaleTimeString());
	let time = document.getElementById("currentTime")
	time.innerText = new Date().toLocaleTimeString()
	setTimeout(function(){ setTime(); }, 1000);
}
setTime();


/*11. Delay
Regarding this element:
	<p id="helloWorld">Hello, World!</p>
Three seconds after a user clicks on this element, change the text to a random color.
*/
document.getElementById("helloWorld").outerHTML = `<p id="helloWorld" onclick="timeFunction()">Hello, World!</p>`
function setRandomColor(){
	//console.log("in Random color");
	let message = document.getElementById("helloWorld");
	//console.log(message.outerHTML)
	message.style.color = '#' + (Math.random().toString(16) + "000000").substring(2,8)
}


/*12. Walk the DOM
Define function walkTheDOM(node, func)
This function should traverse every node in the DOM. Use recursion.
On each node, call func(node).
*/
function walkTheDOM(node,func){
	
	attr = "data-customAttr"
	root = node || document.body;
    if(root) {
    	//console.log(root);    	
        //return root;        
    }
    var children = root.children, element;
    for(var i = children.length; i--; ) {
       element = walkTheDOM(children[i],walkTheDOM);
       
    }	
}
walkTheDOM();
