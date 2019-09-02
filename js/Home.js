/**
 * 
 */

window.onload = function() {
	getUserInfo();
	
	
	getReimbursementInfo();
}
//
var x = 5;
function getUserInfo() {

	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			let user = JSON.parse(xhttp.responseText);
			setValues(user);
			
			
			console.log(user);
			let role = user.usersRoleID;
			console.log(role);
			 if( role == 1){
				 document.getElementById('managerDiv').style.display = 'none';
			 }else{
				 document.getElementById('employeeDiv').style.display = 'none';
			 }
			
			
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






