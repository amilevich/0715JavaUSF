/**
 * 
 */

/**
 * 
 */



window.onload = function() {
	//getEmpInfo();
	getManagerPendingTickets()
	//getpendingTicketInfoById()
	getManagerDecision()

	var click=document.getElementById("Bticket");
	click.onclick=getpendingTicketInfoById();
}

//var click=document.getElementById("Bticket");//.addEventListener("onclick", getpendingTicketInfoById())
//click.onclick=getpendingTicketInfoById();

function test(){console.log("testing button")}

function getEmpInfo() {

	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {	
		if (xhttp.readyState == 4 & xhttp.status == 200) {
			let emp = JSON.parse(xhttp.responseText);
			
		}
	}
	
	xhttp.open("GET", 'http://localhost:8081/NirojDylanProject/html/Dashboard.do',
			true);
	
	xhttp.send();
	
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
function getManagerPendingTickets() {       // for populating forms into  dashboard table
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            let claimTickets = JSON.parse(xhttp.responseText);  //need to check if we are populating jason variables/lists correctly
            
            var table = document.getElementById("ManagerTablePending");
            for (let i = 0; i < claimTickets.length ; i++){
                      var table = document.getElementById("ManagerTablePending");
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
    xhttp.open("GET", 'http://localhost:8081/NirojDylanProject/html/ManagerPendingTickets.do', //LoadingPending.do?
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
           
        
            
            var table = document.getElementById("ManagerTable");
            for (let i = 0; i < claimTickets.length ; i++){
                      var table = document.getElementById("ManagerTable");
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
    xhttp.open("GET", 'http://localhost:8081/NirojDylanProject/html/ManagerPastTickets.do', //LoadingPending.do?
            true);
    xhttp.send();
    
}

function getManagerDecision() {       // for populating forms into  dashboard table
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            let claimTickets = JSON.parse(xhttp.responseText);  //need to check if we are populating jason variables/lists correctly
            	
          if(0>claimTickets.length){
        	  console.log("No Pending Requests For Approval..")
          }else{
        	  
        	  var a=0;
          	
          	document.getElementById("LCID").innerHTML = claimTickets[a].claimId;
          	document.getElementById("LEid").innerHTML = claimTickets[a].empId;
          	document.getElementById("LDOR").innerHTML = claimTickets[a].dateOfRequest;
          	document.getElementById("LDOE").innerHTML = claimTickets[a].dateOfExpense;
          	document.getElementById("Ltravel").innerHTML = claimTickets[a].travelAmount;
          	document.getElementById("Llodging").innerHTML = claimTickets[a].lodgeingAmount;
          	document.getElementById("Lfood").innerHTML = claimTickets[a].foodAmount;
          	document.getElementById("Lother").innerHTML = claimTickets[a].otherAmount;
          	document.getElementById("Lcomments").innerHTML = claimTickets[a].comments;
          	document.getElementById("Ltotal").innerHTML = claimTickets[a].claimTotal;
          	
          	document.getElementById("TCidapprove").value = claimTickets[a].claimId;
          	document.getElementById("TCiddenied").value = claimTickets[a].claimId;
          
            	
                
           }
                      
            
           
        }
    }
    xhttp.open("GET", 'http://localhost:8081/NirojDylanProject/html/ManagerPendingTickets.do', //LoadingPending.do?
            true);
    xhttp.send();
    
}

