/**
 * 
 */
window.onload = function() {
	getUserInfo();
	//getJsonInfo();
	
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

function getReimbursementInfo1() {
	
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			var reimbursements = JSON.parse(xhttp.responseText);
			
			
			
			
			var table = document.getElementById("myTable");
			table.innerHTML = '';
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
			cell1.innerHTML = "ReimbID"
    		cell2.innerHTML = "ReimbAmount"
    		cell3.innerHTML = "Submitted time stamp"
    		cell4.innerHTML = "Resolved time stamp"
    		cell5.innerHTML = "Description"
    		cell6.innerHTML = "Author ID"
    		cell7.innerHTML = "Resolver ID"
    		cell8.innerHTML = "StatusID"
    		cell9.innerHTML = "Type"
			for (let i = 0; i < reimbursements.length ; i++){
				
				
				let status1 = reimbursements[i].reimbStatusID;
				
				if ( status1 == 2){
					continue;
				}
				if ( status1 == 3){
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
					  //cell9.innerHTML = reimbursements[i].reimbTypeId;
					
			}
		}
	}

	xhttp.open("GET", 'http://localhost:8080/PROJECT1/html/Update.do',
			true);
	xhttp.send();
	
}

function getReimbursementInfo2() {
	
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			var reimbursements = JSON.parse(xhttp.responseText);
			
			
			
			var table = document.getElementById("myTable");
			table.innerHTML = '';
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
			cell1.innerHTML = "ReimbID"
    		cell2.innerHTML = "ReimbAmount"
    		cell3.innerHTML = "Submitted time stamp"
    		cell4.innerHTML = "Resolved time stamp"
    		cell5.innerHTML = "Description"
    		cell6.innerHTML = "Author ID"
    		cell7.innerHTML = "Resolver ID"
    		cell8.innerHTML = "StatusID"
    		cell9.innerHTML = "Type"
			for (let i = 0; i < reimbursements.length ; i++){
				
				
				let status1 = reimbursements[i].reimbStatusID;
				
				if ( status1 == 1){
					continue;
				}
				if ( status1 == 3){
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
					  //cell9.innerHTML = reimbursements[i].reimbTypeId;
					
			}
		}
	}

	xhttp.open("GET", 'http://localhost:8080/PROJECT1/html/Update.do',
			true);
	xhttp.send();
	
}


function getReimbursementInfo3() {
	
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			var reimbursements = JSON.parse(xhttp.responseText);
			
			
			
			
			var table = document.getElementById("myTable");
			table.innerHTML = '';
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
			cell1.innerHTML = "ReimbID"
    		cell2.innerHTML = "ReimbAmount"
    		cell3.innerHTML = "Submitted time stamp"
    		cell4.innerHTML = "Resolved time stamp"
    		cell5.innerHTML = "Description"
    		cell6.innerHTML = "Author ID"
    		cell7.innerHTML = "Resolver ID"
    		cell8.innerHTML = "StatusID"
    		cell9.innerHTML = "Type"
			for (let i = 0; i < reimbursements.length ; i++){
				
				
				let status1 = reimbursements[i].reimbStatusID;
				
				if ( status1 == 2){
					continue;
				}
				if ( status1 == 1){
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
					  //cell9.innerHTML = reimbursements[i].reimbTypeId;
					
			}
		}
	}

	xhttp.open("GET", 'http://localhost:8080/PROJECT1/html/Update.do',
			true);
	xhttp.send();
	
}


function getReimbursementInfo4() {
	
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			var reimbursements = JSON.parse(xhttp.responseText);
			
			
			
			
			var table = document.getElementById("myTable");
			table.innerHTML = '';
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
			cell1.innerHTML = "ReimbID"
    		cell2.innerHTML = "ReimbAmount"
    		cell3.innerHTML = "Submitted time stamp"
    		cell4.innerHTML = "Resolved time stamp"
    		cell5.innerHTML = "Description"
    		cell6.innerHTML = "Author ID"
    		cell7.innerHTML = "Resolver ID"
    		cell8.innerHTML = "StatusID"
    		cell9.innerHTML = "Type"
			for (let i = 0; i < reimbursements.length ; i++){
				
				
				
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
					  //cell9.innerHTML = reimbursements[i].reimbTypeId;
					
			}
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
