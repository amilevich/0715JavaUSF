
// Fibonacci
function fibo(count){
	n1=0;
	n2=1;
	n3 = null;
	array =[]
	 	if(count>=1){
		array.push(n1)
	}
	
		array.push(n2)
	if(count>1){
		for(i=0; i<count-2;i++){
			n3 = n1 + n2;
			array.push(n3)
			n1 = n2
			n2 = n3
			// if(i==count-2)
			// 	return;
		}
	}
	console.log("N is " + count)
console.log("Whole Fibonacci sequence up to N")
console.log(array)
console.log("Fibo: Nth num in the sequence")
	console.log(array[count-1]);
}
console.log("------Q1-------")

fibo(10);
console.log("------Q2-------")

// Bubble sort
array1= [1616,2,3,41,5,1,61,1]
sorted = []
// console.log(array)
function bubbleSort(array)
{
for(i =0; i<array.length; i++){
	for(j = 0; j<array.length-1; j++){
		if(array[j]>array[j+1]){
		temp = array[j];
		array[j]=array[j+1]
		array[j+1] = temp;

		}
	}
}
	console.log(array)
}
// console.log(array.pop());
// array[2]=33;
// console.log(bubbleSort(array))
console.log("Bubble Sort of this array: " )
console.log(array1)
console.log("After sorting: ")
bubbleSort(array1)
console.log("------Q3-------")

function reverseStr(string){
	let reversed = ""
	for(i=string.length-1;i>=0;i--){
		reversed+=string[i]
	}
	return reversed
}
// let rev = reverseStr("broccoli")
console.log("Broccoli reversed is: ")
console.log(reverseStr("broccoli"))
console.log("------Q4 Factorial-------")
function factorial(n){
	if(n==0){
		return 1;
	}

	// return(n*factorial(n-1));
	return n * factorial(n-1)
	// console.log(n*factorial(n-1))
}

console.log(factorial(5))

console.log("------ Q5 Substring -------")
function subString(str,length,offset){
	if(length>str.length){
		console.log("Length argument is larger than the length of the str")
		return;
	}
	if(length<0){
		console.log("Length can't be negative.")
		return;
	}
	subStr = ""
	for(i=offset;i<length;i++){
		subStr+=str[i]
	}

	return subStr;
}

console.log(subString("Francais",6,4))
console.log(subString("burrito",-1,2))
console.log(subString("chick'n tacos", 30, 1))

console.log("----------- Q6 Even Number -------")
function isEven(n){
	flag=false;
	for(i=0;i<n;i++){
		flag=!flag
	}
	if(n<0){
		console.log("Please enter a positive integer.")
	}
	if(flag==false){
		console.log( n + " is even")
	}
	else {
		console.log(n + " is odd")
	}
}

isEven(15)
isEven(20)

console.log("------------Q7 Palindrome ----------")
function isPal(string){
	if(string == reverseStr(string)){
		console.log(string + " is Palindrome")
	}
	else {
		console.log( string + " is not Palindrome")
	}
}

isPal("madam")
isPal("racecar")
isPal("honcho")
console.log("-------- Q8 RETURN TO THIS --------- ")
function printShape(shape, height, char){
	switch(shape){
		case "Square":
			console.log(makeSquare(height,char))
			break;
		case "Triangle":
				console.log(makeTri(height,char))
					break;
		case "Diamond":
				console.log(makeDiamond(height,char))
				break;
	}
}
function makeDiamond(height,char){
	line=""
	line2 = ""
	for(i=0;i<height;i++){
				line+=char
	}
			console.log(line)

	for(i=0;i<height/2;i++){
		line2+=char
	}
			console.log(line2)
}
function makeSquare(height,char){
	var line = ""
	for(let i=0; i<=height; i++){
		line+=char;
	}
	for(let i=0; i<=height; i++){
			console.log(line);
	}		
}
function makeTri(height,char){
	var line = ""
	for(let i=1; i<=height; i++){
			for(let j=1; j<=i;j++){
				line+=char;
			}
			line+="\n";
	}
	return line + "\n";

}
printShape("Square",4,"*")
printShape("Triangle",4,"$")
console.log("--------Q9--------")
obj = {
	food: ": veggies and derivatives",
	hobbies: ": working out, eating, playing guitar and games",
	love: ": Coffee, good weather and a bike ride"
}
function workThatObj(obj){

	for(let prop in obj){
	value= obj[prop]

	console.log(prop,value)

	}
}
workThatObj(obj)

console.log("----------Q10-----------")
function deleteThird(array){
	console.log("Length before: " + array.length)
	delete array[2]
	console.log("Length after: " + array.length)
}

deleteThird(["hockey","soccer","baseball"])

console.log("----------Q11-------------")
function splice(arr){
	console.log("Length before: " + arr.length)
	arr.splice(-1)
	console.log("Length after: " + arr.length)


}
splice([76,73,71])

console.log("-----------Q12--------------");
function Person(firstname,age){
	this.firstname = firstname;
	this.age = age;
}

let ruben = new Person("Ruben", 26)
console.log(ruben)

console.log('---------------Q13--------------');
function getPerson(name,age){
	return new Person(name,age);
}
var john = getPerson("John",30)
console.log(john);