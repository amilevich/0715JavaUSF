/**
 * 
 */

window.onload = function() {
	getPetInfo();
}

function getPetInfo() {

	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			let pet = JSON.parse(xhttp.responseText);
			setValues(pet);
		}
	}

	xhttp.open("GET", 'http://localhost:8080/PetsFrontController/html/Home.do',
			true);
	xhttp.send();
	
}

function setValues(pet){
	document.getElementById("name").innerHTML = "Pet's name is " + pet.name;
	document.getElementById("type").innerHTML = "Pet's type is " + pet.type;
}