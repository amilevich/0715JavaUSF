//PART I
//1.
let fib = (n) => {
    ///0, 1, 1, 2, 3, 5, 8, 13, 21, 34
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

console.log(fib(9)); //1

//2
let bubbleSort = (numArray) => {

    for (let i = 0; i < numArray.length - 1; i++) {
        for (let j = 0; j < numArray.length - i - 1; j++) {
            if (numArray[j] > numArray[j+1]) {
                numArray[j] += numArray[j+1]   // 2 + 1 = 3
                numArray[j+1] = numArray[j] - numArray[j+1]   // 3 - 1 = 2
                numArray[j] -= numArray[j+1] 
            }
        }
    }
    return numArray
}

console.log( bubbleSort([4,6,2,9,3,5,1]) );

//3
function reverseString(someStr) {
    let reversed = "";
    someStr.split("").reverse().forEach(element => {
        reversed += element
    });
    return reversed;
}

console.log( reverseString("ricardo") );

//4
function factorial(n) {
    if (n > 1) {
        return n * factorial(n - 1)
    } else {
        return 1;
    }
}

console.log(factorial(3));

//5
function substring(someStr, length, offset) {
    "gabe".substring(0,2);
}

//6
function isEven(someNum) {
    let lastDigit = someNum.toString().split('').pop();
    return (lastDigit / 2).toString().split('').pop() == 5 ? false : true;
}

console.log( isEven(100) );

//7
function isPalindrome(someStr) {
    return someStr === reverseString(someStr);
}

console.log(  isPalindrome("merry")  );

//8
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

//9
function traverseObject(someObj) {
    Object.keys(someObj).forEach((k) => {
        console.log( k + ": " + someObj[k] );
    })
}

let someObj = {
    firstname: 'Gabriel',
    lastname: 'Ferrer'
}

//10
traverseObject(someObj);

function deleteElement(someArr) {
    console.log('Length Before deletion:' + someArr.length);
    delete someArr[2];
    console.log('Length After deletion' + someArr.length);
}

deleteElement([1,2,3,4,5]);

function spliceElement(someArr) {
    return someArr.splice(2,1);
}

console.log(  spliceElement( ['hello','java',3,4,true,false])  );

function Person(name, age) {
    this.name = name;
    this.age = age;
  }

var michael = new Person("Michael", 23);
traverseObject(michael);

function getPerson(name, age) {
    return {
        name: name,
        age: age
    }
}

var richard = getPerson('Richard', 40)
traverseObject(richard);

//PART 2 
//1
function getUSA() {
    var usingDt = document.querySelector('[data-customAttr="USA"]');
    return usingDt;
}

console.log( getUSA() )

//2
function getPeopleInSales() {
    var table = document.getElementsByTagName('table');
    for (let i = 0; i < table.children.length; i++) {
        for (let j = 0; j < table.children[i].children[j].length; j++) {
            if (table.children[i].children[1].innerHTML === 'Sales')
                console.log ( table.children[i].children[0].innerHTML )
        }
    }    
}

// console.log( getPeopleInSales() )

// function getAnchorChildren() {

// }

// function getHobbies() {
//     var e = document.querySelectorAll('[name="colors"]');
//     var value = e.options[e.selectedIndex].value;
//     var text = e.options[e.selectedIndex].text;
//     console.log(value + ': ' + text)
// }

// getHobbies()

// function getCustomAttribute() {
//     const matches = document.querySelectorAll("[data-customAttr]");
//     [...matches].forEach( el => {
//         console.log("Attribute of Element: " + el.getAttribute());
//         console.log("Name of Element containing attribute: " + el.tagName);
//     })
// }

// getCustomAttribute();

// function sumNumbers() {
//     let num1 = parseInt(document.getElementById('num1').value);
//     let num2 = parseInt(document.getElementById('num2').value);

//     if (isNaN(num1 + num2)) {
//         document.getElementById('sum').innerHTML = 'Cannot add'
//     } else {
//         document.getElementById('sum').innerHTML = num1 + num2
//     }
// }

// document.getElementById('num1').onchange = sumNumbers;
// document.getElementById('num2').onchange = sumNumbers;


// var skills = document.querySelectorAll('[name="skills"]');
// skills.addEventListener('change', function() {
//   alert(`Are you sure ${this.value} is one of your skills?`);
// }, false);


// var employees = document.getElementsByClassName('empName');
// employees.addEventListener('mouseover', function() {
//     if (this.style.display === "none") {
//         this.style.display = "block";
//       } else {
//         this.style.display = "none";
//       }
// });


// var clock = setInterval(myTickTock, 1000);

// let myTickTock = function () {
//     let date = new Date();
//     let time = date.toLocaleTimeString();

//     document.getElementById("currentTime").innerHTML = time;
// }

// document.getElementById('helloWorld').onclick = function() {
//     setTimeout( function(){
//         let min = 0;
//         let max = 255;
//         let red = Math.floor(Math.random() * (+max - +min)) + +min;
//         let green = Math.floor(Math.random() * (+max - +min)) + +min;
//         let blue = Math.floor(Math.random() * (+max - +min)) + +min;
//         document.getElementById("helloWorld").innerHTML.style.color = rgb(red,green,blue);
//     }, 3000);
// }