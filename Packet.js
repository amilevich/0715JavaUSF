//PART I

/*
1. Fibonacci
Define function: fib(n) 
Return the nth number in the fibonacci sequence.
*/

function fibo(n) {
    var a = 0, b = 1, f = 1;
    for(var i = 2; i <= n; i++) {
        f = a + b;
        a = b;
        b = f;
    }
    return f;
};

console.log( fibo(n) );

/*
2. Bubble Sort
Define function: bubbleSort(numArray)
Use the bubble sort algorithm to sort the array.
Return the sorted array.
*/

function swap(arr, first_Index, second_Index){
    var temp = arr[first_Index];
    arr[first_Index] = arr[second_Index];
    arr[second_Index] = temp;
    return arr;
}

function bubbleSort(numArray){
    var len = numArray.length,
        i, j, stop;
    
    for (i=0; i < len; i++){
        for (j=0, stop=len-i; j < stop; j++){
            if (numArray[j] > numArray[j+1]){
                swap(numArray, j, j+1);
            }
        }
    }
    return numArray;
}
console.log(bubbleSort([5,9,10,22,15,35,77,8,4,27,1]));

/*
3. Reverse String
Define function: reverseStr(someStr)
Reverse and return the String.
*/

function reverseStr(someStr){
    let reversed = "";    
    for (var i = someStr.length - 1; i >= 0; i--){        
      reversed += someStr[i];
    }    
    return reversed;
  }
  console.log(reverseStr("dog"));


  /*
4. Factorial
Define function: factorial(someNum)
Use recursion to compute and return the factorial of someNum.
*/
function factorial(someNum) {
    if (someNum > 1) {
        return someNum * factorial(someNum - 1)
    } else {
        return 1;
    }
}
console.log(factorial(10));

/*
5. Substring
Define function substring(someStr, length, offset)
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
       return someStr.substr(offset, offset+length);
    }
 }
 console.log(substring("waterhello",4, 3));

 console.log(substring("waterhello",2, 2));

/*
6. Even Number
Define function: isEven(someNum)
Return true if even, false if odd.
Do not use % operator.
*/

function isEven(nsomeNum) {
    if((someNum & 1) == 0){
      return true
    }
    return false;
  }
  console.log(5);

/*
7. Palindrome
Define function isPalindrome(someStr)
Return true if someStr is a palindrome, otherwise return false
*/
0

/*
8. Shapes
Define function: printShape(shape, height, character)
shape is a String and is either "Square", "Triangle", "Diamond".
height is a Number and is the height of the shape. Assume the number is odd.
character is a String that represents the contents of the shape. Assume this String contains just one character.
Use a switch statement to determine which shape was passed in.
Use the console.log function to print the desired shape.
*/
function printShape(shape, height, character) {
    switch (shape) {
        case 'Square':
            for (let i = 0; i < height; i++) {
                let printed = "";
                for (let j = 0; j < height; j++) {
                    printed += character;
                }
                console.log(printed)
            }
            break;
        case 'Triangle':    
            for (let index = 1; index <= height; index++) {
                console.log(character.repeat(index));
            }
            break;
        case 'Diamond':
            let arrayToPrint = Array(height).fill(" ");
            let center = Math.floor(height/2)
            arrayToPrint[center] = character;
            for (let index = 0; index <= center; index++) {
                arrayToPrint[center - index] = character;
                arrayToPrint[center + index] = character;
                console.log(  arrayToPrint.join("").toString() );
            }
            for (let index = 0; index < center; index++) {
                arrayToPrint[index] = " ";
                arrayToPrint[height - 1 - index] = " ";
                console.log(  arrayToPrint.join("").toString() );
            }
            break;
        default:
            break;
    }
}

printShape('Square', 5, '@');
printShape('Triangle', 5, '*');
printShape('Diamond', 5, '$');

/*
9. Object literal
Define function traverseObject(someObj)
Print every property and it's value.
*/

var developer = {Name:'luke', age: 25, height: 6.1};

function traverseObject(someObj) {
console.log(Object.keys(someObj));
}
console.log(devlodeveloperper)


/*
10. Delete Element
Define function deleteElement(someArr)
Print length
Delete the third element in the array.
Print length
The lengths should be the same.
*/

var foods = ['apple', 'organes', 'pizza', 'carrots']

function deleteElement(someArr){
console.log(foods.length)
delete foods[3]
console.log(foods.length)
};
console.log(deleteElement(foods));


/*
11. Splice Element
Define function spliceElement(someArr)
Print length
Splice the third element in the array.
Print length
The lengths should be one less than the original length.
*/

function SpliceElement(someArr){
console.log(someArr.length)
someArr.splice(3,1)
console.log(someArr.length)
};
console.log(SpliceElement(foods));


/*
12. Defining an object using a constructor
Define a function Person(name, age)
The following line should set a Person object to the variable john:
	var john = new Person("John", 30);
*/

function Person(name, age){
}
var john = new Person("John",30);


/*
13. Defining an object using an object literal
Define function getPerson(name, age)
The following line should set a Person object to the variable john:
	var john = getPerson("John", 30);
*/
function getPerson(name, age) {
    return {
        name: name,
        age: age
    }
}
john = getPerson("John",30)

--------------------------------------------------------------------------------------
PART II
--------------------------------------------------------------------------------------
/*
1. USA
Define function getUSA()
Find the html element that contains "USA".
Print that element's contents.
*/

function getUSA() {
     element = document.querySelector('[data-customAttr="USA"]');
    return element;
}
console.log( getUSA() )

/*
2. Sales
Define function getPeopleInSales()
Print the names of all the people in the sales department.
*/

function getPeopleInSales() {
    var numRows = document.body.getElementsByTagName("tr");
 for (var i = 0; i < numRows.length; i++) {
         var cells = numRows[i].cells;
 if(cells[1].innerHTML === "Sales"){
            console.log(cells[0].innerHTML);
        }
    }
 }
console.log(getPeopleInSales())

 /*
3. Click Here
Define function getAnchorChildren()
Find all anchor elements with a <span> child.
Print the contents of <span>
*/

function getAnchorChildren() {
    var anchtags = document.body.getElementsByTagName("a");
 console.log(anchtags);
    for (var i = 0; i < anchtags.length; i++) {
         if(anchtags[i].getElementsByTagName("span").length == 1){
    console.log(anchtags[i].getElementsByTagName("span")[0].innerHTML);
        }
    }
 }
 console.log(getAnchorChildren())

 /*
4. Hobbies
Define function getHobbies()
Find all checked options in the 'skills' select element.
Print the value and the contents.
 */

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


 /*
5. Custom Attribute
Define function getCustomAttribute()
Find all elements with "data-customAttr" attribute
Print the value of the attribute.
Print the element that has the attribute.
*/
function get_custom_attribute(){

    var elements11 = document.querySelectorAll('[data-customAttr]');
    
    for (var i = 0; i <elements11.length;i++){
    
         alert(elements11[i].dataset.customattr);
    
        }
    
    }
/*
6. Sum Event
Regarding these elements:
	<input id="num1" class="nums" type="text"/>
	<input id="num2" class="nums" type="text"/>
	<h3>Sum: <span id="sum"></span></h3>

Define onchange event handler.
Add <input> element values.
Put the sum in the <span> element.
If values cannot be added, put "Cannot add" in the <span> element
*/

function sum(ele){
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
}


/*
7. Skills Event
When user selects a skill, create an alert with a message similar to:
	"Are you sure CSS is one of your skills?"
NOTE: no alert should appear when user deselects a skill.
*/

var selection = document.getElementById("skills");

selection.addEventListener("change",myFunction3,false);

function myFunction3(event){
	console.log(event.type)
	alert("Are you sure CSS is one of your skills");
}
/*
8. Favorite Color Event
NOTE: This is regarding the favoriteColor radio buttons.
When a user selects a color, create an alert with a message similar to:
	"So you like green more than blue now?"
In this example, green is the new value and blue is the old value.
Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor
*/

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

/*
9. Show/Hide Event
When user hovers over an employees name:
	Hide the name if shown.
	Show the name if hidden.
*/

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

/*
10. Current Time
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


/*
11. Delay
Regarding this element:
	<p id="helloWorld">Hello, World!</p>
Three seconds after a user clicks on this element, change the text to a random color.
*/

function colorChange() {

    setTimeout(function() {

                    document.getElementById("helloWorld").style.color = '#' + Math.floor(Math.random() * 16777215).toString(16);

    }, 3000);

}

/*
12. Walk the DOM
Define function walkTheDOM(node, func)
This function should traverse every node in the DOM. Use recursion.
On each node, call func(node).
*/
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