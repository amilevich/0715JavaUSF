//PART 1

// Question 1
function fibo(n) {
    let a = 0, b = 1, c = 1;
    for(let i = 2; i <= n; i++) {
        c = a + b;
        a = b;
        b = c;
    }
    return c;
};
console.log(fibo(10));

// Question 2
function swap(arr, first_Index, second_Index){
    let temp = arr[first_Index];
    arr[first_Index] = arr[second_Index];
    arr[second_Index] = temp;
    return arr;
}
function bubbleSort(numArray){
    let len = numArray.length,
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

// Question 3
function reverseStr(str){
    let reversedStr = "";
    for (let i = str.length - 1; i >= 0; i--){
        reversedStr += str[i];
    }
    return reversedStr;
}
console.log(reverseStr("dog"));

// Question 4
function factorial(num) {
    if (num > 1) {
        return num * factorial(num - 1)
    } else {
        return 1;
    }
}
console.log(factorial(10));

// Question 5
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

// Question 6
function isEven(num) {
    if((num & 1) == 0){
        return true
    }
    return false;
}
console.log(5);

// Question 8
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

// Question 9
let dev = {Name:'T', age: 25, height: 5.6};
function traverseObject(obj) {
    console.log(Object.keys(obj));
}
console.log(dev)

// Question 12
function Person(name, age){
}
let tam = new Person("Tam",32);

// Question 13
function getPerson(name, age) {
    return {
        name: name,
        age: age
    }
}
tam = getPerson("Tam",32)



// PART 2

//  Question 1
function getUSA() {
    return document.querySelector('[data-customAttr="USA"]');
}
console.log( getUSA() )

// Question 2
function getPeopleInSales() {
    let numRows = document.body.getElementsByTagName("tr");
    for (let i = 0; i < numRows.length; i++) {
        let cells = numRows[i].cells;
        if(cells[1].innerHTML === "Sales"){
            console.log(cells[0].innerHTML);
        }
    }
}
console.log(getPeopleInSales())

// Question 3
function getAnchorChildren() {
    let aTags = document.body.getElementsByTagName("a");
    console.log(aTags);
    for (let i = 0; i < aTags.length; i++) {
        if(aTags[i].getElementsByTagName("span").length == 1){
            console.log(aTags[i].getElementsByTagName("span")[0].innerHTML);
        }
    }
}
console.log(getAnchorChildren());

// Question 4
function getHobbies(){
    let hobbie = document.getElementsByName("hobbies")[0];
    let selectHobbies = hobbie.options[hobbie.selectedIndex].value;
    let contentHobbies = hobbie.options[hobbie.selectedIndex].textContent;
    alert(contentHobbies + ";" + selectHobbies);

    let skills = document.getElementsByName("skills")[0];
    let selectSkills = skills.options[skills.selectedIndex].value;
    let contentSkills = skills.options[skills.selectedIndex].textContent;
    alert(contentSkills + ";" + selectSkills);
}

// Question 5
function get_custom_attribute(){
    let elements11 = document.querySelectorAll('[data-customAttr]');
    for (let i = 0; i <elements11.length;i++){
        alert(elements11[i].dataset.customattr);
    }
}

// Question 6
function sum(ele){
    //Declare variable
    let a,b,c;
    a=Number(document.getElementById("num1").value);
    b=Number(document.getElementById("num2").value);
    if(isNaN(a) )
    {
        document.getElementById("sum").innerHTML='Cannot add';
    }
    else if(isNaN(b))
    {
        document.getElementById("sum").innerHTML='Cannot add';
    }
    else
    {
        c= a + b;
        document.getElementById("sum").innerHTML= c;
    }
}

// Question 8
let colors = document.getElementsByName("colors");
let body = document.getElementsByTagName("body");
let i;
let old;
for(i=0;i<colors.length;i++){
    old=colors[i].value;
}
function changeColor(){
    let i;
    for(i=0;i<colors.length;i++){
        alert("So you like "+ colors[i].value + " more than "+ old +" now?");
        old=colors[i].value;
        body[0].style.backgroundColor=old;
    }
}
changeColor();

// Question 9
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

// Question 10
function setTime() {
    let today = new Date();
    let hour = today.getHours();
    let minute = today.getMinutes();
    let second = today.getSeconds();
    let prepand = (hour >= 12)? " PM ":" AM ";
    document.getElementById("currentTime").innerHTML = (hour + ":" + minute + ":" + second + prepand);
}
setTime();
window.setInterval(function(){
    setTime();
}, 1000);

// Question 11
function colorChange() {
    setTimeout(function() {
        document.getElementById("helloWorld").style.color = '#' + Math.floor(Math.random() * 16777215).toString(16);
    }, 3000);
}

// Question 12
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
        let text = node.data.trim();
        if (text.length > 0) {
            console.log(text);
        }
    }
});