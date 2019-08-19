//-----Part_2_DOM-----
//-----1. USA-----
function getUSA() { //create function
    let y = "USA"; // assign to variable desired value
    let x = document.getElementsByTagName("span"); // select elements by tag name
    for (let i of x) { // do iteration over array of elements from previous line
        if (i.textContent == y) console.log(i.textContent); // print out result
    }
}
getUSA();
//--------------------

//-----2. Sales-----
function getPeopleInSales() { //create function
    let x = document.getElementsByTagName("td"); // select elements by tag name
    let point = "Sales"; // assign to variable desired value
    for (let i = 0; i < x.length; i++) { // doing loop over array of elements
        if (x[i].textContent == point) console.log(x[i - 1].textContent); // print out result         

    }
}
getPeopleInSales();
//--------------------

//-----3. Click Here-----
function getAnchorChildren() { //create funciton
    let anchChild = document.getElementsByTagName('span'); //assign to variable
    for (let i of anchChild) { // go through collection of element 
        console.log(i.textContent); // print out content
    }
}
getAnchorChildren();
//--------------------

//-----4. Hobbies-----
function getHobbies() { //create funciton
    let x = document.getElementsByTagName("select"); // select elements by tag name
    for (let j of x) { // go through array of elements
        if (j.getAttribute("name") == 'skills') { // check if we have attribute with desired value
            let y = j.getElementsByTagName('option'); // select elements by tag name
            for (let i of y) { // go through array of elements with new requirements
                if (i.getAttribute("selected") === 'selected') { // check if we have attribute with desired value
                    console.log(i.textContent); // print out content
                }
            }
        }
    }
}
getHobbies();
//--------------------

//-----5. Custom Attribute -----
function getCustomAttribute() { //create funciton
    let dataAttr = "data-customAttr";
    let x = document.getCustomAttribute(dataAttr);
    console.log(x);
}
getCustomAttribute();
//--------------------

//-----6. Sum Event-----
function sumEvent() { //create funciton
    let sum = document.querySelector('#sum'); //assign to variable picked field
    let num1 = document.querySelector('#num1'); //assign to variable picked field
    let num2 = document.querySelector('#num2'); //assign to variable picked field

    num1.oninput = function () { // check if something was input
        let x = parseInt(num1.value); // assign to new variable
        num2.oninput = function () { // check if something was input
            let y = parseInt(num2.value); // assign to new variable
            if (!isNaN(x) && !isNaN(y)) { // check if our inputs is number
                sum.innerHTML = x + y; // return result
            } else {
                sum.innerHTML = 'Cannot add'; // anyway return another one
            }
        };
    };
}
sumEvent();
//--------------------

//-----7. Skills Event-----


//--------------------

//-----8. Favorite Color Event-----

function changeRadioColor() {
    let x = document.querySelectorAll('#favoriteColor');
    for (let i = 0; i < x.length; i++) {
        x[i].addEventListener('onclick', function() {
            alert('So you like green more than blue now?');            
        });
    }
}
changeRadioColor();
//--------------------

//-----9. Show/Hide Event-----
function showHide() {
    let x = document.querySelectorAll('.empName');
    for (let i = 0; i < x.length; i++) {

        x[i].addEventListener('mouseover', function() {
            this.style.color = 'white';
        });

        x[i].addEventListener('mouseout', function() {
            this.style.color = 'Black';
        });
    }
}
showHide();
//--------------------

//-----10. Current Time-----
function currentTime() {
    let x = document.querySelector('#currentTime');
    x.innerHTML = new Date().toLocaleTimeString();
    setTimeout(function () { currentTime() }, 1000);
}
currentTime();
//--------------------

//-----11. Delay-----
function changeColor() { //create funciton    
    let x = document.querySelector("#helloWorld"); //assign to variable picked field
    x.addEventListener('click', letGo); // add listener to our field

    function letGo() {  // does delay of event listener
        setTimeout(clickColor, 3000); // call function with delay 3s
    }

    function clickColor() { // change color of picked field
        var y = '#' + (Math.random() * 0xFFFFFF << 0).toString(16);
        x.style.color = y;
    }
}
changeColor();
//--------------------

//-----12. Walk the DOM-----

//--------------------