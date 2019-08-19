/**
 * 
 */

/*
 * 1. Fibonacci Define function: fib(n) Return the nth number in the fibonacci
 * sequence.
 */

var fib = function(n) {
	if (n === 1) {
		return [ 0, 1 ];
	} else {
		var s = fib(n - 1);
		s.push(s[s.length - 1] + s[s.length - 2]);
		return s;
	}
};

console.log(fib(8));

/*
 * 2. Bubble Sort Define function: bubbleSort(numArray) Use the bubble sort
 * algorithm to sort the array. Return the sorted array.
 */

let numarray = [ 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 ];
function bubbleSort(arr) {
	let n = arr.length;
	for (i = 0; i < n; i++) {
		for (j = i + 1; j < n - i; j++) {
			if (arr[j - 1] > arr[j]) {
				temp = arr[j - 1];
				arr[j - 1] = arr[j];
				arr[j] = temp;
			}

		}
	}
	return numarray;
}
console.log(numarray.toString());
numarray = bubbleSort(numarray);
console.log(numarray.toString());

/*
 * 3. Reverse String Define function: reverseStr(someStr) Reverse and return the
 * String.
 */

let somestr = "We are studying JavaScript";
let n = somestr.length;
console.log(somestr);
function reverstr(somestr) {
	let str1 = "";
	for (i = n - 1; i >= 0; i--) {
		str1 += somestr[i];
	}
	return str1;
}
console.log(reverstr(somestr));

/*
 * 4. Factorial Define function: factorial(someNum) Use recursion to compute and
 * return the factorial of someNum.
 */

let someNum = 4;
let a = 1
console.log(someNum);
function factorial(someNum) {
	if (someNum === 1) {
		return 1;
	} else {

		return (someNum * (factorial(someNum - 1)));
	}

}
console.log(factorial(someNum));

/*
 * 5. Substring Define function substring(someStr, length, offset) Return the
 * substring contained between offset and (offset + length) inclusively. If
 * incorrect input is entered, use the alert function and describe why the input
 * was incorrect.
 */

function substring(someStr, start, end) {
	var result = someStr.substring(start, end);
	console.log(someStr);
	return result;

}
console.log(substring("hello", 1, 3));

/*
 * 6. Even Number Define function: isEven(someNum) Return true if even, false if
 * odd. Do not use % operator.
 */

function evenNumber(number) {
	console.log("The Number " + number);
	var newNum = number / 2;
	var newNum1 = Math.floor(newNum)
	if (newNum1 * 2 === number) {
		return true;
		console.log(newNum);
	} else {
		console.log(newNum);
		return false;
	}

}
console.log(evenNumber(20));

/*
 * 7. Palindrome Define function isPalindrome(someStr) Return true if someStr is
 * a palindrome, otherwise return false
 */
let reverse = "";
function isPalindrome(someStr) {
	console.log("The original word is :", someStr)
	for (var i = someStr.length - 1; i >= 0; i--) {
		reverse = reverse + someStr.charAt(i);

	}
	console.log("The reversed woed is :", reverse);
	if (reverse === someStr) {
		console.log("True");
	} else {
		console.log("False")
	}
}
isPalindrome("madam");

/*
 * 8. Shapes Define function: printShape(shape, height, character) shape is a
 * String and is either "Square", "Triangle", "Diamond". height is a Number and
 * is the height of the shape. Assume the number is odd. character is a String
 * that represents the contents of the shape. Assume this String contains just
 * one character. Use a switch statement to determine which shape was passed in.
 * Use the console.log function to print the desired shape. Example for
 * printShape("Square", 3, "%"); %%% %%% %%% Example for printShape("Triangle",
 * 3, "$"); $ $$ $$$ Example for printShape("Diamond", 5, "*"); ** **** **
 * 
 */

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

/*
 * 9. Object literal Define function traverseObject(someObj) Print every
 * property and it's value.
 */
var someObj = {
	fname : "Andrew",
	lname : "Henry",
	age : 45
};
function traverseObject(someObj) {
	var txt = "";
	var x;
	for (x in someObj) {
		txt = someObj[x] + " ";
		console.log(txt);

	}

}
traverseObject(someObj);

/*
 * 10. Delete Element Define function deleteElement(someArr) Print length Delete
 * the third element in the array. Print length The lengths should be the same.
 */

var foods = [ 'pizza', 'burger', 'sandwich', 'Rice', 'bread' ];
function deleteElement(foods) {
	console.log(foods);
	console.log(foods.length);
	delete foods[3];
	console.log(foods);
	console.log(foods.length);
}

deleteElement(foods);

/*
 * 11. Splice Element Define function spliceElement(someArr) Print length Splice
 * the third element in the array. Print length The lengths should be one less
 * than the original length.
 */
var dinner = [ 'pizza', 'burger', 'sandwich', 'Rice', 'bread' ];
function spliceElement(dinner) {
	console.log(dinner);
	console.log(dinner.length);
	dinner.splice(2, 1);
	console.log(dinner);
	console.log(dinner.length);
}
spliceElement(dinner);

/*
 * 12. Defining an object using a constructor Define a function Person(name,
 * age) The following line should set a Person object to the variable john: var
 * john = new Person("John", 30);
 */
function person(name, age) {
	this.name = name;
	this.age = age;

}
var john = new person("john", 30);
console.log("Name is", john.name, "age is", john.age);

/*
 * 13. Defining an object using an object literal Define function
 * getPerson(name, age) The following line should set a Person object to the
 * variable john: var john = getPerson("John", 30);
 */

/*
 * var john={getPerson(name,age){ this.name=name; this.age=age; }
 */

// PART 2
/*
 * 1. USA Define function getUSA() Find the html element that contains "USA".
 * Print that element's contents
 */
function get_USA() {
	let findtext = "USA";
	let tagValue = document.body.getElementsByTagName("span");
	for (let i = 0; i < tagValue.length; i++) {
		let booleanVar = tagValue[i].textContent.search(findtext);
		if (booleanVar != -1) {
			alert(tagValue[i].textContent);
			break;
		}
	}
}
get_USA();

/*
 * 2. Sales Define function getPeopleInSales() Print the names of all the people
 * in the sales department
 */

function getPeopleInSales() {

	// Cycle thru table and getting the first element of table
	let a = document.body.getElementsByTagName("tr");
	for (let i = 0; i < a.length; i++) {
		let cells = a[i].cells;
		if (cells[1].innerHTML == "Sales") {
			console.log(cells[0].innerHTML);
		}
	}
}
getPeopleInSales();
/*
 * 3. Click Here Define function getAnchorChildren() Find all anchor elements
 * with a <span> child. Print the contents of <span>
 */

function getAnchorChildren() {
	var x = document.body.getElementsByTagName("a");
	console.log(x);
	for (let i = 0; i < x.length; i++) {
		if (x[i].getElementsByTagName("span").length == 1) {
			console.log(x[i].getElementsByTagName("span")[0].innerHTML);
		}
	}
}
getAnchorChildren();

/*
 * 4. Hobbies Define function getHobbies() Find all checked options in the
 * 'skills' select element. Print the value and the contents.
 */

function getHobbies() {
	let skill = document.getElementsByName("skills")[0];
	let selectSkills = skill.options[skill.selectedIndex].value;
	let Skillstray = skill.options[skill.selectedIndex].textContent;

	console.log(Skillstray + ":" + selectSkills);
}
getHobbies();

/*
 * 5. Custom Attribute Define function getCustomAttribute() Find all elements
 * with "data-customAttr" attribute Print the value of the attribute. Print the
 * element that has the attribute.
 */

function getCustomAttribute() {
	let findelement = document.querySelectorAll('[data-customAttr]');
	for (let i = 0; i < findelement.length; i++) {
		console.log(findelement[i].dataset.customattr);
	}
}
getCustomAttribute();

/*
 * 6. Sum Event Regarding these elements: <input id="num1" class="nums"
 * type="text"/> <input id="num2" class="nums" type="text"/> <h3>Sum: <span
 * id="sum"></span></h3>
 * 
 * Define onchange event handler. Add <input> element values. Put the sum in the
 * <span> element. If values cannot be added, put "Cannot add" in the <span>
 * element
 */

function sum(ele) {
	// Declare variable
	let a, b, c;
	// Get first input
	a = Number(document.getElementById("num1").value);
	// Get second input
	b = Number(document.getElementById("num2").value);
	// Check condition
	if (isNaN(a)) {
		// Print message
		document.getElementById("sum").innerHTML = 'Cannot add';
	}
	// Check condition
	else if (isNaN(b)) {
		// Print message
		document.getElementById("sum").innerHTML = 'Cannot add';
	}
	// Else
	else {
		// Find value
		c = a + b;
		// Print sum
		document.getElementById("sum").innerHTML = c;
	}

}

sum();

/*
 * 7. Skills Event When user selects a skill, create an alert with a message
 * similar to: "Are you sure CSS is one of your skills?" NOTE: no alert should
 * appear when user deselects a skill.
 */

document.addEventListener('DOMContentLoaded',load);
var skills5 = "";

function load() {
	skills5 = firstForm.skills;
	skills5.addEventListener('change',option_change);
}

function option_change() {
	alert("Are you sure " +skills5.options[skills5.selectedIndex].text+" is one of your skills?");
	return false;
}

/*8. Favorite Color Event
NOTE: This is regarding the favoriteColor radio buttons.
When a user selects a color, create an alert with a message similar to:
	"So you like green more than blue now?"
In this example, green is the new value and blue is the old value.
Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor
*/

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

/*9. Show/Hide Event
When user hovers over an employees name:
	Hide the name if shown.
	Show the name if hidden.*/
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

/*10. Current Time
Regarding this element:
	<h5 id="currentTime"></h5>
Show the current time in this element in this format: 9:05:23 AM
The time should be accurate to the second without having to reload the page.
*/
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


/*11. Delay
Regarding this element:
	<p id="helloWorld">Hello, World!</p>
Three seconds after a user clicks on this element, change the text to a random color.*/

document.getElementById('helloWorld').addEventListener("click",changecolor);

function changecolor(){
	setTimeout(function(){
		document.getElementById('helloWorld').style.color='#' + Math.floor(Math.random() * 16777215).toString(16);
	},3000);
}

/*12. Walk the DOM
Define function walkTheDOM(node, func)
This function should traverse every node in the DOM. Use recursion.
On each node, call func(node).*/

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


