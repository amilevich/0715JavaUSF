/**
 * 
 */

/*
1. USA
   Define function getUSA()
   Find the html element that contains "USA".
   Print that element's contents.
 */

function getUSA(){
	let body = document.querySelectorAll('[data-customAttr="USA"]');
	
	console.log(body);
};

/*
 2. Sales
	Define function getPeopleInSales()
	Print the names of all the people in the sales department.
*/

function getPeopleInSales(){
	let tr = document.getElementsByTagName('tr');
	
	for(i=1;i<tr.length;i++) {
		let td = tr[i].getElementsByTagName('td');
		
		if(td[1].innerText == 'Sales') {
			console.log(td[0].innerText);
		}
	}
};

/*
 3. Click Here
	Define function getAnchorChildren()
	Find all anchor elements with a <span> child.
	Print the contents of <span>
*/

function getAnchorChildren(){
	let anchors = document.getElementsByTagName('a');

	for(i=0;i<anchors.length;i++){
		let spans = anchors[i].getElementsByTagName('span');

		for(j=0;j<spans.length;j++){
			console.log(spans[j].innerText);
		}
	}
};

/*
 4. Hobbies
	Define function getHobbies()
	Find all checked options in the 'skills' select element.
	Print the value and the contents.  
 */

function getHobbies(){
	let hobbiUhhSkills = document.querySelector('[name="skills"]');
	let skillsIGuess = hobbiUhhSkills.querySelectorAll('[selected="selected"]');

	for(i=0;i<skillsIGuess.length;i++){
		console.log(skillsIGuess[i].innerText);
	}
};

/*
 5. Custom Attribute
	Define function getCustomAttribute()
	Find all elements with "data-customAttr" attribute
	Print the value of the attribute.
	Print the element that has the attribute.
 */

function getCustomAttribute(){
	let customs = document.querySelectorAll('[data-customAttr]');

	for(i=0;i<customs.length;i++) {
		console.log("Element: " + customs[i]);
		console.log("Value: " + customs[i].attributes[0].value);
	}
};

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

document.getElementsByClassName('nums')[0].onchange = summation;
document.getElementsByClassName('nums')[1].onchange = summation;

function summation(){
	let num1 = document.getElementById('num1').value;
	let num2 = document.getElementById('num2').value;
	
	let sum = Number(num1) + Number(num2);
	let entry;

	if(isNaN(sum)) {
		entry = "cannot";
	} else {
		entry = sum;
	}
	
	document.getElementById('sum').innerText = entry;
};

/*
 7. Skills Event
When user selects a skill, create an alert with a message similar to:
	"Are you sure CSS is one of your skills?"
NOTE: no alert should appear when user deselects a skill.
 */

let select = document.querySelector('[name="skills"]')

select.onchange = message;

function message() {
	alert("Are you sure "+select.options[select.selectedIndex].innerText+" is one of your skills?");
};

/*
 8. Favorite Color Event
NOTE: This is regarding the favoriteColor radio buttons.
When a user selects a color, create an alert with a message similar to:
	"So you like green more than blue now?"
In this example, green is the new value and blue is the old value.
Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor
 */

let checkedPrev = "", checkedCur = "";

let favColors = document.querySelectorAll('[name="favoriteColor"]');

for(i=0;i<favColors.length;i++){
	favColors[i].onchange = message2;
};

function message2(){
	checkedPrev = checkedCur;
	
	for(i=0;i<favColors.length;i++){
		if(favColors[i].checked){
			checkedCur = favColors[i].value;
		}
	}
	
	document.body.style.backgroundColor = checkedCur;
	
	alert("Are you sure " + checkedCur + " is better than " + checkedPrev + "?");
};

/*
 9. Show/Hide Event
	When user hovers over an employees name:
		Hide the name if shown.
		Show the name if hidden.
 */

let empRows = document.getElementsByTagName('tr');


for(i=1;i<empRows.length;i++){
	let x = i;
	empRows[i].addEventListener('mouseover', function() {
		
		let emp = empRows[x].getElementsByClassName('empName');
		
		if(emp[0].style.visibility === "visible") {
			emp[0].style.visibility = "hidden"
		} else {
			emp[0].style.visibility = "visible"
		}
	});
}

/*
 10. Current Time
	 Regarding this element:
		 <h5 id="currentTime"></h5>
	 Show the current time in this element in this format: 9:05:23 AM
	 The time should be accurate to the second without having to reload the page.
 */

let timer = document.getElementById('currentTime');

function runTimer(){
	let today = new Date();
	let h = today.getHours();
	let m = today.getMinutes();
	let s = today.getSeconds();
	
	let suffix = "AM";
	
	if(h > 12){
		h = h - 12;
		suffix = "PM";
	}
	
	if(m < 10){
		m = "0" + m;
	}
	
	if(s < 10){
		s = "0" + s;
	}
	
	timer.innerText = h + ":" + m + ":" + s + " " + suffix;
	
	setTimeout(function(){
		runTimer();
	}, 500);
}
runTimer();

/*
 11. Delay
	 Regarding this element:
		 <p id="helloWorld">Hello, World!</p>
	 Three seconds after a user clicks on this element, change the text to a random color.
 */

let colors = ['blue','red','green','orange','yellow','maroon','purple','gold','lime','skyblue'];

let hellowrld = document.getElementById('helloWorld');

hellowrld.onclick = rndm;

function rndm() {
	setTimeout(function(){
		hellowrld.style.color = colors[Math.round(Math.random()*10)];
	},3000);
}

/*
 12. Walk the DOM
	 Define function walkTheDOM(node, func)
	 This function should traverse every node in the DOM. Use recursion.
	 On each node, call func(node).
 */

function func(node){
	if(node == null)
		return;

	console.log(node);
}

function walkTheDOM(node, func){
	func(node);

	node = node.firstChild;

	while(node) {
		walkTheDOM(node, func);
		node = node.nextSibling;
	}
}

function go(){
	walkTheDOM(document, func);
}

























