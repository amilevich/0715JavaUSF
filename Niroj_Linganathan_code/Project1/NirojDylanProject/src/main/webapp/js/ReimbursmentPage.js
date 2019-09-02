/**
 * 
 */



window.onload = function() {
	getEmpInfo();
	getTicketInfo()
	getpendingTicketInfoById()
	
	
}


function getEmpInfo() {

	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {	
		if (xhttp.readyState == 4 & xhttp.status == 200) {
			let emp = JSON.parse(xhttp.responseText);
			setValues(emp);
		}
	}
	
	xhttp.open("GET", 'http://localhost:8081/NirojDylanProject/html/Dashboard.do',
			true);
	
	xhttp.send();
	
}

function setValues(emp){
	
	document.getElementById("name1").innerHTML = "Welcome " + emp.firstName+" "+ emp.lastName;
	document.getElementById("TEid").value = emp.empId;
	
	var Edate=new Date();
	y = Edate.getFullYear();
	m = Edate.getMonth() +1;
	d = Edate.getDate();
	var date=m+"-"+d+"-"+y;
	document.getElementById("DateOfRequest").value = date;
}

function getFormInfo() {            // for populating forms into Manager dashboard

	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			let form = JSON.parse(xhttp.responseText);
			//console.log(xhttp);
			setValues(emp);
		}
	}

	xhttp.open("GET", 'http://localhost:8081/NirojDylanProject/html/Dashboard.html',
			true);
	xhttp.send();
	
}

//-------------------------------------------------------------------------------------For Adding in a table.
function getTicketInfo() {       // for populating forms into  dashboard table
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            let claimTickets = JSON.parse(xhttp.responseText);  //need to check if we are populating jason variables/lists correctly

           
        
            
            var table = document.getElementById("myTable");
            for (let i = 0; i < claimTickets.length ; i++){
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
                      var cell10 = row.insertCell(9);
                      var cell11 = row.insertCell(10);
                      
                      cell1.innerHTML = claimTickets[i].claimId;
                      cell2.innerHTML = claimTickets[i].empId;
                      cell3.innerHTML = claimTickets[i].adminId;
                      cell4.innerHTML = claimTickets[i].travelAmount;
                      cell5.innerHTML = claimTickets[i].lodgeingAmount;
                      cell6.innerHTML = claimTickets[i].foodAmount;
                      cell7.innerHTML = claimTickets[i].otherAmount;
                      cell8.innerHTML = claimTickets[i].claimTotal;
                      cell9.innerHTML = claimTickets[i].dateOfRequest;
                      cell10.innerHTML = claimTickets[i].claimStatus;
                      cell11.innerHTML = claimTickets[i].comments;


            }
            
           
        }
    }
    xhttp.open("GET", 'http://localhost:8081/NirojDylanProject/html/getTicket.do', //LoadingPending.do?
            true);
    xhttp.send();
    
}

//################################################################################all pending tickets by employee ID

function getpendingTicketInfoById() {       // for populating forms into  dashboard table
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            let claimTickets = JSON.parse(xhttp.responseText);  //need to check if we are populating jason variables/lists correctly
            console.log("pending tickets by ID"+claimTickets)
           
        
            
            var table = document.getElementById("myTablePending");
            for (let i = 0; i < claimTickets.length ; i++){
                      var table = document.getElementById("myTablePending");
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
                      var cell10 = row.insertCell(9);
                      var cell11 = row.insertCell(10);
                      
                      cell1.innerHTML = claimTickets[i].claimId;
                      cell2.innerHTML = claimTickets[i].empId;
                      cell3.innerHTML = claimTickets[i].adminId;
                      cell4.innerHTML = claimTickets[i].travelAmount;
                      cell5.innerHTML = claimTickets[i].lodgeingAmount;
                      cell6.innerHTML = claimTickets[i].foodAmount;
                      cell7.innerHTML = claimTickets[i].otherAmount;
                      cell8.innerHTML = claimTickets[i].claimTotal;
                      cell9.innerHTML = claimTickets[i].dateOfRequest;
                      cell10.innerHTML = claimTickets[i].claimStatus;
                      cell11.innerHTML = claimTickets[i].comments;


            }
            
           
        }
    }
    xhttp.open("GET", 'http://localhost:8081/NirojDylanProject/html/PendingById.do', //LoadingPending.do?
            true);
    xhttp.send();
    
}

