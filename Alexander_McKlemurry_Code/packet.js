/**
 * 
 */

//1. Fibonacci
//Define function: fib(n) 
//Return the nth number in the fibonacci sequence.

//function fib(n)
//{
//var n1= 0;
//var n2 = 1;
//var val;
//document.write(var1+"<br />");
//document.write(var2+"<br />");
//for(var i=3; i <= n;i++)
//{
//val = n1 + n2
//n1 = n2
//n2 = val
//document.write(val+"<br />");
//}
//}
//var no = prompt(" nth",0);
//console.log(fib(no))

//2. Bubble Sort
//Define function: bubbleSort(numArray)
//Use the bubble sort algorithm to sort the array.
//Return the sorted array.

//function swap(arr, Index1, Index2){
//var temp = arr[Index1];
//arr[Index1] = arr[Index2];
//arr[Index2] = temp;
//}
//
//function bubbleSort(arr){
//var len = arr.length,
//i, j, stop;
//for (i=0; i < len; i++){
//for (j=0, stop=len-i; j < stop; j++){
//if (arr[j] > arr[j+1]){
//swap(arr, j, j+1);
//}
//}
//}
//document.write(arr+"<br />");
//}
//bubbleSort([3, 0, 2, -2, -1, 4, 1]);

//3. Reverse String
//Define function: reverseStr(someStr)
//Reverse and return the String.

//function reverseStr(str) {
//var splitString = str.split("");
//var reverseArray = splitString.reverse();
//var joinArray = reverseArray.join("");
//document.write(joinArray+"<br />");
//}
//reverseStr("hello");

//4. Factorial
//Define function: factorial(someNum)
//Use recursion to compute and return the factorial of someNum.

//function factorial(n){
//var i, fact;
//fact=1;
//for(i=1; i<=n; i++)
//{
//fact= fact*i;
//}
//document.write(fact+"<br />");
//}
//factorial(5)

//5. Substring
//Define function substring(someStr, length, offset)
//Return the substring contained between offset and (offset + length) inclusively.
//If incorrect input is entered, use the alert function and describe why the input was incorrect.

//function substring(someStr, length, offset){
//   if(offset < 0){
//      alert("Offset is less than zero");
//    }
//   else if(offset+length > someStr.length){
//      alert("Offset is greater than length of the string");
//    }
//   else{
//      return str.substr(offset, offset+length);
//  }
//}
//console.log(str.substr);
//6. Even Number
//Define function: isEven(someNum)
//Return true if even, false if odd.
//Do not use % operator.

//function isEven(n) {
//   return /^-?\d*[02468]$/.test(n);
//}
//
//function isOdd(n) {
//   return /^-?\d*[13579]$/.test(n);
//}
//console.log(n)

//7. Palindrome
//Define function isPalindrome(someStr)
//Return true if someStr is a palindrome, otherwise return false

//function checkPalindrome(word) {    
//    var l = word.length;
//    for (var i = 0; i < l / 2; i++) {
//       if (word.charAt(i) !== word.charAt(l - 1 - i)) {
//            return false;
//        }
//    }
//    return true;
//}

//if (checkPalindrome("1122332211")) {
//  document.write("The word is a palindrome");
//} else {
//    document.write("The word is NOT a palindrome");
//}
//console.log(length)


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


//function printShape(s, n, c) {
//switch(s) {
//case "Square":
//for(let i=0;i<n;i++) {
//for(let j=0;j<n;j++) {
//document.write(c);
//console.log(c);
//}
//document.write("<br>");
//console.log("<br>");
//}
//break;
//case "Triangle":
//for(let i=0;i<n;i++) {
//for(let j=0;j<=i;j++) {
//document.write(c);
//console.log(c);
//}
//document.write("<br>");
//console.log("<br>");
//}
//break;
//case "Diamond":
//for(let i=0;i<n;i+=2) {
//for(let k=0;k<=n/2-i;k++) {
//document.write("&nbsp");
//console.log(" ");
//}
//for(let j=0;j<=i;j++) {
//document.write(c);
//console.log(c);
//}
//document.write("<br>");
//console.log("<br>");
//}
//for(var i=n-2;i>=0;i-=2) {
//for(var k=0;k<=(n-i)/2;k++) {
//document.write("&nbsp");
//console.log(" ");
//}
//for(var j=0;j<i;j++) {
//document.write(c);
//console.log(c);
//}
//document.write("<br>");
//console.log("<br>");
//}
//break;
//}
//
//}
//
//printShape("Square", 3, "%");
//printShape("Triangle", 3, "$");
//printShape("Diamond", 5, "*");



//9. Object literal
//Define function traverseObject(someObj)
//Print every property and it's value.

//function traverseObject(someObj) {
//    for(var propName in someObj) {
//        propValue = someObj[propName]
//        console.log(propName, propValue);
//    }
//}


//10. Delete Element
//Define function deleteElement(someArr)
//Print length
//Delete the third element in the array.
//Print length
//The lengths should be the same.

//var  = [1, 2, 3, 4, 5, 6];
//ar.length = 3; 
//console.log( ar );

//11. Splice Element
//Define function spliceElement(someArr)
//Print length
//Splice the third element in the array.
//Print length
//The lengths should be one less than the original length.

//var arr = [1, 2, 3, 4, 5, 6, 7, ];
//var removed = arr.splice(3);

//
//12. Defining an object using a constructor
//Define a function Person(name, age)
//The following line should set a Person object to the variable john:
//	var john = new Person("John", 30);

//let Person = function(name, job, age){
//	  this.name = name;
//	}
//const john = new Person('John');
//	john.job = 'Developer';
//	john.age = 30;
//
//	console.log(JSON.stringify(john, null, '  '));

//
//13. Defining an object using an object literal
//Define function getPerson(name, age)
//The following line should set a Person object to the variable john:
//	var john = getPerson("John", 30);



//1. USA
//Define function getUSA()
//Find the html element that contains "USA".
//Print that element's contents.
//  
//2. Sales
//Define function getPeopleInSales()
//Print the names of all the people in the sales department.
//  
//3. Click Here
//Define function getAnchorChildren()
//Find all anchor elements with a <span> child.
//Print the contents of <span>
//  
//4. Hobbies
//Define function getHobbies()
//Find all checked options in the 'skills' select element.
//Print the value and the contents.
//  
//
//5. Custom Attribute
//Define function getCustomAttribute()
//Find all elements with "data-customAttr" attribute
//Print the value of the attribute.
//Print the element that has the attribute.
//
//6. Sum Event
//Regarding these elements:
//	<input id="num1" class="nums" type="text"/>
//	<input id="num2" class="nums" type="text"/>
//	<h3>Sum: <span id="sum"></span></h3>
//
//Define onchange event handler.
//Add <input> element values.
//Put the sum in the <span> element.
//If values cannot be added, put "Cannot add" in the <span> element
//
//7. Skills Event
//When user selects a skill, create an alert with a message similar to:
//	"Are you sure CSS is one of your skills?"
//NOTE: no alert should appear when user deselects a skill.
//
//8. Favorite Color Event
//NOTE: This is regarding the favoriteColor radio buttons.
//When a user selects a color, create an alert with a message similar to:
//	"So you like green more than blue now?"
//In this example, green is the new value and blue is the old value.
//Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor
//
//9. Show/Hide Event
//When user hovers over an employees name:
//	Hide the name if shown.
//	Show the name if hidden.
//
//10. Current Time
//Regarding this element:
//	<h5 id="currentTime"></h5>
//Show the current time in this element in this format: 9:05:23 AM
//The time should be accurate to the second without having to reload the page.
//
//11. Delay
//Regarding this element:
//	<p id="helloWorld">Hello, World!</p>
//Three seconds after a user clicks on this element, change the text to a random color.
//
//12. Walk the DOM
//Define function walkTheDOM(node, func)
//This function should traverse every node in the DOM. Use recursion.
//On each node, call func(node).
//
