//1. Fibonacci
// Define function: fib(n)
// Return the nth number in the fibonacci sequence.
function fib(n)
{
    if (n <= 1) return 1;

    return fib(n - 1) + fib(n - 2);
}

//2. Bubble Sort
// Define function: bubbleSort(numArray)
// Use the bubble sort algorithm to sort the array.
// Return the sorted array.
function bubbleSort(numArray)
{
    for(var i = 0; i < numArray.length; i++) {
        for(var j = 1; j < numArray.length; j++) {
            if(numArray[j - 1] > numArray[j]) {
                swap(numArray, j - 1, j);
            }
        }
    }
    return numArray;
}

function swap(array, i, j) {
    var temp = array[i];
    array[i] = array[j];
    array[j] = temp;
}

//3. Reverse String
// Define function: reverseStr(someStr)
// Reverse and return the String.
function reverseStr(someStr)
{
    return someStr.split("").reverse().join("")
}

//4. Factorial
// Define function: factorial(someNum)
// Use recursion to compute and return the factorial of someNum.
function factorial(someNum)
{
    if(someNum == 0) {
        return 1
    } else {
        return someNum * factorial(someNum - 1);
    }
}

//5. Substring
// Define function substring(someStr, length, offset)
// Return the substring contained between offset and (offset + length) inclusively.
// If incorrect input is entered, use the alert function and describe why the input was incorrect.
function substring(someStr, length, offset)
{
    if(typeof someStr !== "string")
    {
        alert("The first input must be a string.")
    }
    else if(typeof length !== "number" || typeof offset !=="number")
    {
        alert("The second and third inputs must be numbers.")
    }
    else if(length + offset > someStr.length)
    {
        alert("The sum of input 2 and 3 must be less than the length of the first input")
    }
    else
    {
        return someStr.substring(offset, offset + length)
    }
}

//6. Even Number
// Define function: isEven(someNum)
// Return true if even, false if odd.
// Do not use % operator.
function isEven(someNum)
{
    if((someNum & 1) == 0){
        return true
    }
    return false;
}

//7. Palindrome
// Define function isPalindrome(someStr)
// Return true if someStr is a palindrome, otherwise return false
function isPalindrome(someStr)
{
    return someStr === someStr.split("").reverse().join("")
}

//8. Shapes
// Define function: printShape(shape, height, character)
// shape is a String and is either "Square", "Triangle", "Diamond".
// height is a Number and is the height of the shape. Assume the number is odd.
// character is a String that represents the contents of the shape. Assume this String contains just one character.
// Use a switch statement to determine which shape was passed in.
// Use the console.log function to print the desired shape.
// Example for printShape("Square", 3, "%");
// %%%
// %%%
// %%%
// Example for printShape("Triangle", 3, "$");
// $
// $$
// $$$
// Example for printShape("Diamond", 5, "*");
//   *
//  ***
// *****
//  ***
//   *
function printShape(shape, height, character)
{
    switch (shape)
    {
        case "Square" :
            for (let i = 1; i <= height; i++)
            {
                printLine(3, character, 0);
            }
            break
        case "Triangle" :
            for (let i = 1; i <= height; i++)
            {
                printLine(i, character, 0);
            }
            break
        case "Diamond" :
            for (let i = 1; i <= height; i+=2)
            {
                printLine(i,character,(height - i) / 2)
            }
            for (let i = height - 2; i >= 0; i-=2)
            {
                if(isEven(height))
                {
                    printLine(i-1,character,(height - i + 1) / 2)
                }
                else
                {
                    printLine(i,character,(height - i) / 2)
                }

            }
    }
}

function printLine(length, character, offset)
{
    let row = ""
    for (let i = 0; i < offset; i++)
    {
        row += " "
    }
    for (let i = 0; i < length; i++)
    {
        row += character
    }
    console.log(row)
}

//9. Object literal
// Define function traverseObject(someObj)
// Print every property and it's value.
function traversObject(someObj)
{
    let objValue;
    for(let objName in someObj) {
        objValue = someObj[objName]

        console.log(objName,objValue);
    }
}

//10. Delete Element
// Define function deleteElement(someArr)
// Print length
// Delete the third element in the array.
// Print length
// The lengths should be the same.
function deleteElement(someArr)
{
    console.log(someArr.length)
    delete someArr[2]
    console.log(someArr.length)
}

//11. Splice Element
// Define function spliceElement(someArr)
// Print length
// Splice the third element in the array.
// Print length
// The lengths should be one less than the original length.
function spliceElement(someArr)
{
    console.log(someArr.length)
    someArr.splice(2, 2)
    console.log(someArr.length)
}

//12. Defining an object using a constructor
// Define a function Person(name, age)
// The following line should set a Person object to the variable john:
// 	var john = new Person("John", 30);
function Person(name, age)
{
    return {name : name, age : age}
}

//13. Defining an object using an object literal
// Define function getPerson(name, age)
// The following line should set a Person object to the variable john:
// 	var john = getPerson("John", 30);
function getPerson(name, age)
{
    return {name : name, age : age}
}