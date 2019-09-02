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
			
			//let today = Date(+(JSON.stringify(reimbursements[0].reimbSubmitted)));
		
			//ticketArea.append(JSON.stringify(reimbursements[0].reimbID));
			
			
			let select = document.getElementById("selectBar2");
			var table = document.getElementById("myTable");
			for (let i = 0; i < reimbursements.length ; i++){
				
				

					let status1 = reimbursements[i].reimbStatusID;
					
					if (status1 == 2){
						continue;
					}
					if (status1 == 3){
						continue;
					}
					
					
					
					  var table = document.getElementById("myTable");
					  var row = table.insertRow(table.rows.length);
					  var cell1 = row.insertCell(0);
					  var cell2 = row.insertCell(1);
					  var cell3 = row.insertCell(2);
					  var cell4 = row.insertCell(3);
					  var cell5 = row.insertCell(4);
					  var cell6 = row.insertCell(5);
					  var cell7 = row.insertCell(6);
					  var cell8 = row.insertCell(7);
					  var cell9 = row.insertCell(8);
					  cell1.innerHTML = reimbursements[i].reimbID;
					  cell2.innerHTML = reimbursements[i].reimbAmount;
					  
					  let today = new Date(+(JSON.stringify(reimbursements[i].reimbSubmitted)))
					  cell3.innerHTML = today ;
					  
			
					  let solved = new Date(+(JSON.stringify(reimbursements[i].reimbResolved)))
				
						  cell4.innerHTML = solved;
					  
					 
					  
					  cell5.innerHTML = reimbursements[i].reimbDescription;
					  cell6.innerHTML = reimbursements[i].reimbAuthor;
					  cell7.innerHTML = reimbursements[i].reimbResolver;
					  
					  let status = reimbursements[i].reimbStatusID;
					  
					  if ( status == 1){
						  cell8.innerHTML = "Pending";
						  
					  } else if ( status == 2){
						  cell8.innerHTML = "Approved";
					  } else if (status == 3) {
						  cell8.innerHTML = "Declined";
					  }
					  
					  let k = reimbursements[i].reimbTypeId;
					  if ( k == 1 ){
						  cell9.innerHTML = "Lodging";
						  
					  } else if ( k == 2 ) {
						  
						  cell9.innerHTML = "Travel";
					  } else if ( k == 3) {
						  
						  cell9.innerHTML = "Food";
					  } else if ( k== 4) {
						  
						  cell9.innerHTML = "Other"
					  }
					  
					  
					  select.options[select.options.length] = new Option('Rembursement ID' + reimbursements[i].reimbID,  reimbursements[i].reimbID);
					  //cell9.innerHTML = reimbursements[i].reimbTypeId;
					
			}
			
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



function addToSelect() {

	var select = document.getElementById("selectBar");
	select.options[select.options.length] = new Option('Text 1', 'Value1');
}



