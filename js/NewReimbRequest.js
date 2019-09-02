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

	xhttp.open("GET", 'http://localhost:8080/E.R.S_Project1/html/Home.do',
			true);
	xhttp.send();
	
}

function getReimbursementInfo() {
	
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			let reimbursements = JSON.parse(xhttp.responseText);

			let ticketArea = document.getElementById("tickets");
			
			let today = Date(+(JSON.stringify(reimbursements[0].reimb_Submitted)));
			let arr = [];
			
			for (let i = 0; i < reimbursements.length ; i++){
				let today = Date(+(JSON.stringify(reimbursements[0].reimb_Submitted)));
				arr[i] = today;
			}
			ticketArea.append(arr);
			
			console.log(reimbursements);
		}
	}

	xhttp.open("GET", 'http://localhost:8080/E.R.S_Project1/html/Update.do',
			true);
	xhttp.send();
	
}

function setValues(user1){
	document.getElementById("userId").innerHTML = "User ID " + user1.usersID;
	document.getElementById("userName").innerHTML = "User Name " + user1.username;
	document.getElementById("userPassword").innerHTML = "Password " + user1.password;
	document.getElementById("userFirstName").innerHTML = "First Name " + user1.firstName;
	document.getElementById("userLastName").innerHTML = "Last Name " + user1.lastname;
	document.getElementById("userEmail").innerHTML = "Email " + user1.email;
	document.getElementById("userRoleId").innerHTML = "userRoleId " + user1.usersRoleId;
}