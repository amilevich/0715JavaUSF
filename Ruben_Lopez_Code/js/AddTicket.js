/**
 * 
 */

window.onload = function() {
	getUserInfo();
	//getJsonInfo();
	
	getReimbursementInfo();
}

function getUserInfo() {

	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			let user1 = JSON.parse(xhttp.responseText);
			setValues(user1);
		}
	}

	xhttp.open("GET", 'http://localhost:8080/PROJECT1/html/Home.do',
			true);
	xhttp.send();
	
}

function getReimbursementInfo() {
	
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			let reimbursements = JSON.parse(xhttp.responseText);
//			setValues(user);
			let ticketArea = document.getElementById("tickets");
			
			let today = Date(+(JSON.stringify(reimbursements[0].reimbSubmitted)));
			let arr = [];
			//ticketArea.append(JSON.stringify(reimbursements[0].reimbSubmitted));
			for (let i = 0; i < reimbursements.length ; i++){
				let today = Date(+(JSON.stringify(reimbursements[0].reimbSubmitted)));
				arr[i] = today;
			}
			ticketArea.append(arr);
			//ticketArea.append(today);
			//ticketArea.append(JSON.stringify(reimbursements[0].reimbSubmitted));
			console.log(reimbursements);
		}
	}

	xhttp.open("GET", 'http://localhost:8080/PROJECT1/html/Update.do',
			true);
	xhttp.send();
	
}

function setValues(user1){
	document.getElementById("userId").innerHTML = "User ID " + user1.ersUserId;
	document.getElementById("userName").innerHTML = "User Name " + user1.ersUserName;
	
	document.getElementById("userFirstName").innerHTML = "First Name " + user1.userFirstName;
	document.getElementById("userLastName").innerHTML = "Last Name " + user1.userLastName;
	document.getElementById("userEmail").innerHTML = "Email " + user1.userEmail;
	
}