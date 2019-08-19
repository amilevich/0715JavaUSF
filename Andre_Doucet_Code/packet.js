/**
 * 
 */

 
 /*1. Fibonacci
*Define function: fib(n) 
*Return the nth number in the fibonacci sequence.
*/

console.log('Make sure to finish 5 - 13 in Part 1 eventually.');
/*
var output = "0 1";
var n = 10, f=0, s=1, sum=0;

for(var i=2; i<=n; i++) {
  sum = f + s;
  output += ' ' + sum;
  f = s;
  s = sum;
}

console.log(output);
*/

/*2. Bubble Sort
Define function: bubbleSort(numArray)
Use the bubble sort algorithm to sort the array.
Return the sorted array.

*
*/

/*
function bubble_Sort(a)
{
    var swapp;
    var n = a.length-1;
    var x=a;
    do {
        swapp = false;
        for (var i=0; i < n; i++)
        {
            if (x[i] < x[i+1])
            {
               var temp = x[i];
               x[i] = x[i+1];
               x[i+1] = temp;
               swapp = true;
            }
        }
        n--;
    } while (swapp);
 return x; 
}

console.log(bubble_Sort([12, 345, 4, 546, 122, 84, 98, 64, 9, 1, 3223, 455, 23, 234, 213]));

*/

//3. Reverse String
//Define function: reverseStr(someStr)
//Reverse and return the String.

//const str = "hello";

//console.log(str.split('').reverse().join(''));

// 4. Factorial
// Define: function: factorial(someNum)
//     	use recursion to compute and return the factorial of someNum


/*
var factorial = function pf(n) {
    if (n <= 1) {
        return 1;
    } else {
        return n * pf(n - 1);
    }
};

var fac = factorial;
factorial = null;
console.log(fac(5));
*/

/*5. Substring
Define function substring(someStr, length, offset)
Return the substring contained between offset and (offset + length) inclusively.
If incorrect input is entered, use the alert function and describe why the input was incorrect.
*/

//function thing() {
	//var someStr = "Hello there!";
	//var res = someStr.substring(0, 4);
	//console.log(res);
	
	//if(res > (12, 12)) {
		//alert('That aint gonna work chief.');
	//}
//};

// 6. Even Number
// 		Define function: isEven(someNum)
//		Return true if even, false if odd.
//		Do not use % operator.

//function findOddEven(num){
	//if ((num / 2) * 2 == num) {
		//console.log('Even Number');
//} else{
	//	console.log('Odd Number');
//}
//}

/*7. Palindrome
Define function isPalindrome(someStr)
Return true if someStr is a palindrome, otherwise return false
*
*/

/*
function isPalindrome() {
	var someStr = "otto";
	var revStr = "";
	var i = someStr.length;
	for(var j = i; j>=0; j--) {
		revStr = revStr+someStr.charAt(j);
	};
	
	if(someStr == revStr) {
		alert("True.");
	} else{
		alert("False");
	}
};

*/

/*
*
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


/*
function printShape(s, n, c) {
switch(s) {
case "Square":
for(var i=0;i<n;i++) {
for(var j=0;j<n;j++) {
document.write(c);
console.log(c);
}
document.write("<br>");
console.log("<br>");
}
break;
case "Triangle":
for(var i=0;i<n;i++) {
for(var j=0;j<=i;j++) {
document.write(c);
console.log(c);
}
document.write("<br>");
console.log("<br>");
}
break;
case "Diamond":
for(var i=0;i<n;i+=2) {
for(var k=0;k<=n/2-i;k++) {
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
for(var i=n-2;i>=0;i-=2) {
for(var k=0;k<=(n-i)/2;k++) {
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
printShape("Square", 3, "%");
printShape("Triangle", 3, "$");
printShape("Diamond", 5, "*");

*/

//9. Object literal
//Define function traverseObject(someObj)
//Print every property and it's value.

/*
function traverseObject(someObj) {
    for(var propName in someObj) {
        propValue = someObj[propName]
        console.log(propName, propValue);
    }
}
*/

//10. Delete Element
//Define function deleteElement(someArr)
//Print length
//Delete the third element in the array.
//Print length
//The lengths should be the same.


/*
function deleteElement(arr) {
	let arr = ['Slime', 'Dracky', 'HealSlime', 'Golem', 'Pillowrat']
	console.log(arr.length)
	delete arr[4];
	console.log(arr.length)
}
*/

/*
11. Splice Element
Define function spliceElement(someArr)
Print length
Splice the third element in the array.
Print length
The lengths should be one less than the original length.
*/

/*
let someArr = [1, 2, 3, 4, 5, 6, 7, 8, 9];

function spliceElement(someArr){
	console.log(someArr.length);
	newArr = someArr.splice(2,5);
	console.log(newArr.length);
};

*/

//12. Defining an object using a constructor
//Define a function Person(name, age)
//The following line should set a Person object to the variable john:
	//var john = new Person("John", 30);
	
	/*
	
	var Person = function(name, age){
		this.name = name;
		this.age = age;
		
		this.setAge = function(age){
			this.age = age
		};
		
		this.toString = function(){
			return["Name =" , this.name, ",Age" , this.age].john("");
		}
	};
	*/
	
//13. Defining an object using an object literal
//Define function getPerson(name, age)
//The following line should set a Person object to the variable john:
	//var john = getPerson("John", 30);
	
/*
	
	var Person = function(name, age){
		this.name = name;
		this.age = age;
		
		this.setAge = function(age){
			this.age = age
		};
		
		this.toString = function(){
			return["Name =" , this.name, ",Age" , this.age].john("");
		}
	};
	
	function getPerson(name, age){



    return new Person(name,age)



}



var john = getPerson("john", 30);

*/
	

//PART II

/*
1. USA
Define function getUSA()
Find the html element that contains "USA".
Print that element's contents.

function getUSA() {
	var USA = document.getElementsByTagName("H1");
	console.log(USA);
};

*/

/*2. Sales
Define function getPeopleInSales()
Print the names of all the people in the sales department.
*
*/

//function getPeopleInSales(){
	//console.log("John");
	//console.log("Austin");
	//console.log("Courtney");
	//console.log("Scout");
//};


//3. Click Here
//Define function getAnchorChildren()
//Find all anchor elements with a <span> child.
//Print the contents of <span>
/*
   function getAnchorChildren() {
        var lst = [];
        var spans = document.getElementsByTagName('span');
        for (var i = 0; i < spans.length; i++) {
            lst.push(spans[i].innerHTML);
        }
        return lst;
    }

    console.log(getAnchorChildren());

*/

/*
4. Hobbies
Define function getHobbies()
Find all checked options in the 'skills' select element.
Print the value and the contents.
*/


/*
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

*/

//5. Custom Attribute

//Define function getCustomAttribute()

//Find all elements with "data-customAttr" attribute

//Print the value of the attribute.


/*
function getCustomAttribute(){

	let element11 = document.querySelectorAll('[data-customAttr]');

	for (let i = 0 ; i < element11.length ; i++){

		alert(element11[i].dataset.customattr);

	}

}

*/

//6. Sum Event

//Regarding these elements:

//    <input id="num1" class="nums" type="text"/>

//    <input id="num2" class="nums" type="text"/>

//    <h3>Sum: <span id="sum"></span></h3>

//upon refresh, will calculate the function

/*

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

*/

//7. Skills Event

//When user selects a skill, create an alert with a message similar to:

//    "Are you sure CSS is one of your skills?"

//NOTE: no alert should appear when user deselects a skill.




/*
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

*/

//8. Favorite Color Event

//NOTE: This is regarding the favoriteColor radio buttons.

//When a user selects a color, create an alert with a message similar to:

//    "So you like green more than blue now?"

//In this example, green is the new value and blue is the old value.

//Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor

//

/*

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

*/

//9. Show/Hide Event

//When user hovers over an employees name:

//    Hide the name if shown.

//    Show the name if hidden.


/*
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

*/

//10. Current Time

//Regarding this element:

//    <h5 id="currentTime"></h5>

//Show the current time in this element in this format: 9:05:23 AM

//The time should be accurate to the second without having to reload the page.


/*
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


*/

//11. Delay

//Regarding this element:

//    <p id="helloWorld">Hello, World!</p>

//Three seconds after a user clicks on this element, change the text to a random color.

/*

document.getElementById("helloWorld").addEventListener("click",colorChange);



function colorChange(){

	setTimeout(function() {

		

		document.getElementById("helloWorld").style.color = '#' + 

		Math.floor(Math.random() * 16777215).toString(16);

		}, 3000);

	

	

}


*/


//12. Walk the DOM

//Define function walkTheDOM(node, func)

//This function should traverse every node in the DOM. Use recursion.

//On each node, call func(node).

/*

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


*/










