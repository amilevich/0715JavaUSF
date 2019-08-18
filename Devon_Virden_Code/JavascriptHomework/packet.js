/**
 * Devon Virden's homework
 * 
 * PART I:
 */

// 1) fibonacci
function fib(n) {
	let a = 1;
	let b = 0;
	let c;
	let i = 2;
	while (i <= n) {
		c = a;
		a += b;
		b = c;
		i++;
	}
	return a;
}

// 2) bubble sort
function bubbleSort(numArray) {
	let len = numArray.length;
	for(let x=0;x<len-1;x++){
		for(let y=0;y<len-1-x;y++){
			if(numArray[y]>numArray[y+1]){
				let a = numArray[y];
				numArray[y]=numArray[y+1];
				numArray[y+1]=a;
			}
		}
	}
	return numArray;
}

// 3) reverse string
function reverseString(someStr) {
	let len= someStr.length;
	let reversed="";
	for(let i = 0;i<len;i++){
		reversed+=someStr.charAt(len-i-1);
	}
	return reversed;
}

// 4) factorial
function factorial(someNum) {
	if (someNum > 1) {
		return someNum * factorial(someNum - 1);
	} else {
		return 1;
	}
}

// 5) substring
function substring(someStr, length, offset){
	let sub = "";
	if(someStr.length>=(length+offset)){
		for(let i = length; i<(length+offset); i++){
			sub += someStr.charAt(i);
		}
		return sub;
	}else{
		window.alert("Invalid Entry");
		return "Invalid Entry";
	}
}

// 6) even or odd
function isEven(someNum){
	// if theres a .5, it won't be the same
	if (Math.round(someNum/2)===someNum/2){
		return true;
	}else{
		return false;
	}
}

// 7) palindrome
function isPalindrome(someStr){
	// using an earlier function to my advantage
	if(someStr===reverseString(someStr)){
		return true;
	}
	else{
		return false;
	}
}

// 8) print shapes
function printShape(shape,height,character){
	// minor human proofing
	if(!((shape==="Triangle"||shape==="Square"||shape==="Diamond")&&character.length==1)){
		console.log("Invalid entry")
	}
	else{
		// crating something to "fill" with the shape
		let line="";
		switch(shape){
		// fill the triangle
		case "Triangle":
			for(let i = 0;i<height;i++){
				for(j=0;j<=i;j++){
					line+=character;
				}
				line+="\n";
			}
			break;
			// fill the square
		case "Square":
			for(let i = 0;i<height;i++){
				for(j=0;j<height;j++){
					line+=character;
				}
				line+="\n";
			}
			break;
			// fill the diamond
		case "Diamond":
			for(let i = 0;i<height;i++){
				// fill the first falf
				if(i<Math.round(height/2)){
					for(let j=0;j<=(Math.round(height/2)+i);j++){
						if(j<Math.round(height/2)-i){
							line+=" ";
						}else{
							line+=character;
						}
					}
				}
				// fill the second half
				else{
					for(let j=0;j<(Math.round(height/2)+(height-i));j++){
						if(j<=Math.round(height/2)-(height-i)){
							line+=" ";
						}else{
							line+=character;
						}
					}
				}
				line+="\n";
			}
			break;
		}
		// print the shape
		console.log(line);
	}
}

// 9) object literal
function traverseObject(someObj){
	let str="";
	for(let [x,y] of Object.entries(someObj)){
		str+=x+" "+y+"\n";
	}
	console.log(str);
}

// 10) delete element
function deleteElement(someArray){
	let len = someArray.length;
	let str= "length before:\t"+len;
	// deletes the element at index 2, third element
	delete someArray[2];
	len = someArray.length;
	str+="\nLength after:\t"+len;
	console.log(str);
	return someArray;
}

// 11) splice element
function spliceElement(someArray){
	let len = someArray.length;
	let arr=[];
	let str= "length before:\t"+len;
	// fill the array, and skip index 2, the third element
	for(let i=0; i<len ;i++){
		if(i!=2){
			arr.push(someArray[i]);
		}
	}
	someArray=arr;
	len = someArray.length;
	str+="\nLength after:\t"+len;
	console.log(str);
	return someArray;
}

// 12) define object using constructor
function Person(name, age){
		this.name=name;
		this.age=age;
}

// 13) define object with object literal
function getPerson(name, age){
	return{
		"Name":name,
		"Age":age
	};
}

/**
 * PART II:
 */

// 1) USA! USA! USA!
function getUSA(){
	console.log(document.getElementById("USA").innerHTML);
}

// 2) find who's in the sales department
function getPeopleInSales(){
	let people = document.getElementsByClassName("empName");
	let departments = document.getElementsByClassName("dep");
	// do a for loop through one of the lists
	for(let i = 0;i<departments.length;i++){
		// if the department is sales, print the person
		if(departments[i].innerHTML==="Sales"){
			console.log(people[i].innerHTML);
		}
	}
}

// 3) click here
function getAnchorChildren(){
	let arr= document.getElementsByClassName("click");
	for(let i of arr){
		// find if the element includes a span
		if(i.innerHTML.includes("span")){
			let str= i.innerHTML;
			let st = str.indexOf(">")+1;
			let end = str.lastIndexOf("<");
			// using my substring from earlier to lop off the values I need
			str = substring(str,st,(end-st));
			console.log(str);
		}
	}
}

// 4) hobbies
function getHobbies(){
	let hob = document.getElementById("skills").options;
	for(let i of hob){
		if(String(i.getAttribute("selected"))=="selected"){
			console.log("Value: "+i.getAttribute("value"));
		}
	}
}

// 5) custom attribute
function getCustomAttribute(){
	// gets anything with specified attribute
	att=document.querySelectorAll("[data-customAttr]")
	for(let i of att){
		// print the value of the attribute
		console.log("Attribute: "+i.getAttribute("data-customAttr"));
		// print the value inside the element
		console.log("Value: "+i.innerHTML);
	}
}


// create the event listeners for the following problems
window.onload=function(){
	document.getElementById("num1").addEventListener("change",sumTheNums);
	document.getElementById("num2").addEventListener("change",sumTheNums);
	document.getElementById("skills").addEventListener("change",sure);
	let colors =document.getElementsByClassName("favColor");
	for(i of colors){
		i.addEventListener("click", newColor);
	}
	let emps=document.getElementsByClassName("empName");
	for(i of emps){
		i.addEventListener("mouseenter",quickTheBossIsComing);
	}
	document.getElementById("helloWorld").addEventListener("click",click);
}

// 6) sum
	// define the function
function sumTheNums(){
	let num1 = document.getElementById("num1").value;
	let num2 = document.getElementById("num2").value;
	if(isNaN(Number(num1)) || isNaN(Number(num2))){
		document.getElementById("sum").innerHTML="Cannot Add";
	}else{
		document.getElementById("sum").innerHTML=Number(num1)+Number(num2);
	}
}

// 7) select new skill
function sure(){
	// gets the index thats selected
	let hob = document.getElementById("skills").options.selectedIndex;
	// gets the value at a specified index, in this case, whatever's selected
	let gob = document.getElementById("skills").item(hob).innerHTML;
	alert("Are you sure "+gob+" is one of your skills?");
}

// 8) new favorite color
	// declare a global variable to change by the element
var favColor="Black";
function newColor(){
	let colors =document.getElementsByClassName("favColor");
	for(i of colors){
		// check if it's checked, and if so, store the new color, print the
		// message, and replace the favorite color
		if(i.checked==true){
			let newCol=i.getAttribute("value");
			alert("I guess "+newCol+" is the new "+favColor+" now?");
			favColor=newCol;
		}
	}
	// change the background color
	for(i of colors){
		i.style.backgroundColor=String(favColor);
		console.log(i);
	}
}



// 9) hide the employee names
	// turns out when you call a function with a parameter in an event listener,
	// but don't specify the argument, it makes the argument the event
function quickTheBossIsComing(i){
	// because .visibility didn't allow me to un-hide the element when you
	// mouse back over, I set the text to the background color, in essence
	// hiding it.
	if(i.target.style.color==="white"){
		i.target.style.color="black";
	}else{
		i.target.style.color="white";
	}
}

// 10) print out the time
	// create a self invoking function to kick everything off
let tickTock=function(){
	// set interval repeats the same action every so many milliseconds
	setInterval(writer,1000);
}();

	// create the called function
function writer(){
	let clock = document.getElementById("currentTime")
	let now= new Date();
	clock.innerHTML=now.toLocaleTimeString();
}

// 11) change the color of the text
	// a middleman function to set the timer
function click(){
	setTimeout(waitForIt,3000);
}
	
	// what actually changes the color
function waitForIt(){
	let colors =document.getElementById("colors").options;
	let ran = Math.floor(Math.random()*5);
	document.getElementById("helloWorld").style.color=colors[ran].getAttribute("value");
}

// 12) walk the dom
function walkTheDom(){
	// document.documentElement returns the html element, so it contains
	// everything
	func(document.documentElement)
}

function func(node){
	console.log(node);
	// get a list of all children of the node
	let nodes=node.childNodes;
	for(i of nodes){
		console.log(i);
		// checks if there are children of this node, and if there are passes
		// the node back into the function
		if(i.childNodes != "null"){
			func(i);
		}
	}
}