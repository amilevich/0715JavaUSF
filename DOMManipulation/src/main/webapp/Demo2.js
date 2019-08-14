/**
 * 
 */

//GET ELEMENT BY ID
let paraTwo = document.getElementById('para2');
paraTwo.innerText = 'Cats are cool, let us go to the lobby';

let paraThree = document.getElementById('para3');
paraThree.innerHTML = '<b><i> Well, how u duin </i></b>';


//GET ELEMENTS BY CLASS
let hders = document.getElementsByClassName('headers');
hders[1].textContent = "Why wont this load.... send help";

//GET ELEMENTS BY TAG NAME
//getElementsByTagName('');
//singular and plural, plural makes it an array

//Events - any action that an end user performs 
/*
 * click
 * mouseup
 * mouseover
 * mousedown
 * altkey
 * change
 * onclick
 * mouseenter
 * mouseleave
 */

let buttonOne = document.getElementById('button');
buttonOne.addEventListener('click', myFunc);

function myFunc(eve){
	console.log(eve.altKey);
}

buttonOne.addEventListener('mouseenter', myFuncTwo);

function myFuncTwo(event){
	console.log(event.type);
}



