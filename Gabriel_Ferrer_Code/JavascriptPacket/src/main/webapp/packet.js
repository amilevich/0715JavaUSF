//PART I
//1.
function fib (n) {
    // /0, 1, 1, 2, 3, 5, 8, 13, 21, 34
    let start = 0;
    let next = 1;
    let temp;
    let i = 0;
    while (i < n) {
        temp = start + next;
        start = next;
        next = temp;
        i++
    }
    return start;
}
console.log("part 1, q 1")
console.log(fib(9)); // 1

// 2
function bubbleSort (numArray) {

    for (let i = 0; i < numArray.length - 1; i++) {
        for (let j = 0; j < numArray.length - i - 1; j++) {
            if (numArray[j] > numArray[j + 1]) {
                numArray[j] += numArray[j + 1]   // 2 + 1 = 3
                numArray[j + 1] = numArray[j] - numArray[j + 1]   // 3 - 1 = 2
                numArray[j] -= numArray[j + 1]
            }
        }
    }
    return numArray
}

console.log("part 1, q 2")
console.log(bubbleSort([4, 6, 2, 9, 3, 5, 1]));

// 3
function reverseString(someStr) {
    let reversed = "";
    someStr.split("").reverse().forEach(element => {
        reversed += element
    });
    return reversed;
}

console.log("part 1, q 3")
console.log(reverseString("ricardo"));

// 4
function factorial(n) {
    if (n > 1) {
        return n * factorial(n - 1)
    } else {
        return 1;
    }
}

console.log("part 1, q 4")
console.log(factorial(3));

// 5
function keepAsking() {
    let ask = [true,""]; 
    let sstr = "";
    let length = 0;
    let offset = 0;

    do { 
        sstr = prompt("Please enter string to get substring");
        length = prompt("Please enter length to get substring");
        offset = prompt("Please enter offset to get substring");
        ask = substr(sstr, length, offset);
        
    } while( ask[0] );

    function substr(someStr, length, offset) {
        let stringLength = someStr.length;
        let str = "";
        if ( length > stringLength || offset >= length ) {
            alert("Please give correct string, length and offset");
            alert("Offset must be less than length but not less than zero");
            return [true,""];
        } else {
            for(var i = 0; i < length; i++) {
                if (i >= offset) {
                    str += someStr[i];
                } 
            }
            return [false, str]
        }
    }
    alert("Substring of "+ sstr +" is:" + ask[1]);
    return ask[1];
}

console.log("part 1, q 5")
console.log( "Substring: " + keepAsking() );

// 6
function isEven(someNum) {
    let lastDigit = someNum.toString().split('').pop();
    return (lastDigit / 2).toString().split('').pop() == 5 ? false : true;
}

console.log("part 1, q 6")
console.log(isEven(100));

// 7
function isPalindrome(someStr) {
    return someStr === reverseString(someStr);
}
console.log("part 1, q 7")
console.log(isPalindrome("merry"));

// 8
function printShape(shape, height, character) {
    switch (shape) {
        case 'Square':
            let printed = "";
            for (let i = 0; i < height; i++) {
                
                for (let j = 0; j < height; j++) {
                    printed += character;
                }
                printed += '\n'
            }
            console.log(printed);
            break;
        case 'Triangle':
            for (let index = 1; index <= height; index++) {
                console.log(character.repeat(index));
            }
            break;
        case 'Diamond':
            let arrayToPrint = Array(height).fill(" ");
            let center = Math.floor(height / 2)
            arrayToPrint[center] = character;
            for (let index = 0; index <= center; index++) {
                arrayToPrint[center - index] = character;
                arrayToPrint[center + index] = character;
                console.log(arrayToPrint.join("").toString());
            }
            for (let index = 0; index < center; index++) {
                arrayToPrint[index] = " ";
                arrayToPrint[height - 1 - index] = " ";
                console.log(arrayToPrint.join("").toString());
            }
            break;
        default:
            break;
    }
}

console.log("part 1, q 8")
printShape('Square', 5, '@');
printShape('Triangle', 5, '*');
printShape('Diamond', 5, '$');

// 9
function traverseObject(someObj) {
    Object.keys(someObj).forEach((k) => {
        console.log(k + ": " + someObj[k]);
    })
}

let someObj = {
    firstname: 'Gabriel',
    lastname: 'Ferrer'
}
console.log("part 1, q9");
traverseObject(someObj);

// 10
function deleteElement(someArr) {
    console.log('Length Before deletion:' + someArr.length);
    delete someArr[2];
    console.log('Length After deletion' + someArr.length);
}

console.log("part 1, q 10");
deleteElement([1, 2, 3, 4, 5]);

// 11
function spliceElement(someArr) {
    return someArr.splice(2, 1);
}

console.log("part 1, q 11");
console.log(spliceElement(['hello', 'java', 3, 4, true, false]));

// 12
function Person(name, age) {
    this.name = name;
    this.age = age;
}

console.log("part 1, q 12")
var michael = new Person("Michael", 23);
traverseObject(michael);

// 13
function getPerson(name, age) {
    return {
        name: name,
        age: age
    }
}

console.log("part 1, q 13")
var richard = getPerson('Richard', 40)
traverseObject(richard);

// PART 2
// 1

function getUSA() {
    var span = document.getElementsByTagName('span');
    return span[2].innerHTML;
}
console.log("part 2, q1")
console.log( getUSA() )

// 2
function getPeopleInSales() {
    var table = document.getElementsByTagName('table');
    rows = document.getElementsByTagName("tr");
    console.log(rows.length);
    for (let i = 1; i < rows.length; i++) {
        console.log(rows[i].cells[0].innerHTML);
    }
}
console.log("part 2, q 2");
getPeopleInSales();

// 3
let a = document.getElementsByTagName('a');
let span = document.getElementsByTagName('span');

function getAnchorChildren() {
    [...a].forEach(ela => {
        [...span].forEach(els => {
            if (ela.contains(els)) {
                console.log("<span> tag of <a> tag contains " + els.innerHTML);
            }  
        })
    })
}
getAnchorChildren();
console.log("part 2, q 3")
// 4
function getHobbies() {
    var selectedNodes = document.querySelectorAll('select[name="hobbies"] > option[selected="selected"]')// [0];
    for (var i = 0; i < selectedNodes.length; i++) {
        console.log(selectedNodes[i].value)
    }
}
console.log("part 2, q 4")
getHobbies();

// 5
function getCustomAttribute() {
    const matches = document.querySelectorAll("[data-customAttr]");
    console.log(matches);
    matches.forEach(el => {
        console.log("Value of Attribute, data-customAttr: " + el.getAttribute("data-customAttr"));
        console.log("Name of Element containing Attribute, data-customAttr: " + el.tagName);
    })
}

console.log("part 2, q 5")
getCustomAttribute();

// 6
function sumNumbers() {
    let num1 = document.getElementById('num1').value;
    let num2 = document.getElementById('num2').value;

    if (num1 !== '' && num2 !== '') {
    	if (isNaN(parseInt(num1) + parseInt(num2))) {
            document.getElementById('sum').innerHTML = 'Cannot add'
        } else {
            document.getElementById('sum').innerHTML = parseInt(num1) + parseInt(num2)
        }
    }
    
}

console.log("part 2, q 6")
document.getElementById('num1').onchange = sumNumbers;
document.getElementById('num2').onchange = sumNumbers;

// 7
var skills = document.querySelectorAll('[name="skills"]');
skills[0].addEventListener('change', function () {
    var selectIndex = skills[0].selectedIndex;
    var selectedValue = skills[0].options[selectIndex].innerText;
    alert(`Are you sure ${selectedValue} is one of your skills?`);
}, false);


// 8

let colorSelected = "" ; // old
let colorBtns = document.querySelectorAll("input[name='favoriteColor']");

colorBtns.forEach(el => {
    el.onclick = function () {
        if(colorSelected) {
            message = `So you like ${ this.value } more than ${ colorSelected } now?`
            colorSelected = this.value;
            alert(message);
        } else {
            colorSelected = this.value;
        }
        changeColor(this.value);
    }
})

function changeColor(color) {
    let colorBtns = document.getElementsByClassName('faveCol');
	[...colorBtns].forEach(el => {
        el.style.backgroundColor = color;
    });
}


// 9
var employees = document.getElementsByClassName('empName');

[...employees].forEach(el => {
    el.addEventListener('mouseover', function () {
    	if (this.style.opacity == 0) {
    		this.style.opacity = 1
    	} else {
    		this.style.opacity = 0
    	}
    });
});


// 10
function myTickTock() {
    let date = new Date();
    let time = date.toLocaleTimeString();

    document.getElementById("currentTime").innerHTML = time;
}
setInterval(myTickTock, 1000);

// 11
window.addEventListener('load', function () {
    document.getElementById('helloWorld').onclick = function () {
        setTimeout(function () {
            let min = 0;
            let max = 255;
            let red = Math.floor(Math.random() * (+max - +min)) + +min;
            let green = Math.floor(Math.random() * (+max - +min)) + +min;
            let blue = Math.floor(Math.random() * (+max - +min)) + +min;
            let hw = document.getElementById("helloWorld"); // .style.color =
															// `rgb(${red},${green},${blue})`;
            hw.style.color = `rgb(${red},${green},${blue})`;
        }, 3000);
    }
});

// 12
var html = document.getElementsByTagName('html')[0]

walkTheDOM(html, func);

function walkTheDOM(node, func) {
    
    func(node);
    
}

function func(node) {
    if (node !== 'undefined') {
        for(var i = 0; i < node.childNodes.length; i++) {
            console.log("Immediate Parent Tagname is: " + node.tagName);
            let childNode = node.childNodes[i];

            if ( childNode.childNodes.length > 0) {
                console.log("   My Child Tagname is: " + childNode.tagName);
                func(childNode);
            }
        }
    }
}