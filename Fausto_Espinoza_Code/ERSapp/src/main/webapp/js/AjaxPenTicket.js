/**
 * 
 */

window.onload = function(){
	getInfo();	
}

//window.onunload = function(){
//	getData();
//}

let button1 = document.getElementById('button1');

button1.addEventListener('click',getData);

function getInfo(){
	
	let xhtpp = new XMLHttpRequest();
	
	xhtpp.onreadystatechange  = function(){
		if(xhtpp.readyState == 4 && xhtpp.status == 200){
			let pendtk = JSON.parse(xhtpp.responseText);			
			setValues(pendtk);		    
		}
	}	
	xhtpp.open("GET","http://localhost:8080/ERSapp/html/PendingTickets.do",true);	
	xhtpp.send();
}


function setValues(pendtk){	
	let mytbody = document.getElementById("mytbody");
	let txt = "";
    for (x in pendtk) {	      
    	txt += "<tr><td>";
    	txt += " <input type='text' id='id' name='idTicket' " +
		"value='"+ pendtk[x].reimbId+"' disabled='disabled'>"
		txt += "</td>";
    	
    	
    	txt += "<td>";    	
    	txt += " <input type='text' id='author' name='author' " +
		"value='"+ pendtk[x].firstName + " " + pendtk[x].lastName +"' disabled='disabled'>"
		txt += "</td>";
    	
    	
    	txt += "<td>";    	
    	txt += "<input type='number' id='amount' name='amount' " +
    		"value='"+ pendtk[x].reimbAmount+"' disabled='disabled'>";
    	txt += "</td>"; 
    	
    	txt += "<td>";	    	
    	txt += "<input type='datetime-localtime' id='date' name='date' " +
				"value='"+ pendtk[x].reimbSubmitted+"' disabled='disabled' >";
    	txt += "</td>"; 
    	
    	txt += "<td>";
    	txt += "<input type='text' id='descrp' name='descrp' " +
				"value='"+ pendtk[x].reimbDescription+"' disabled='disabled'>";	    	
    	txt += "</td>"; 
    	
    	txt += "<td>";
    	txt += "<select id='type' name='type'><option value='1' selected>" +
				"Pending</option> <option value='2'>Approve</option> <option value='3'>" +
				"Deny</option></select> ";
    	txt += "</td>";	    	
    }	        
    mytbody.innerHTML = txt;
}


function getData(){
	let myTable = document.getElementById("myTable");
	let p = document.getElementById("textP");
	let txt = "[";
	console.log(myTable.rows.length);
	for(let x = 1 ; x < myTable.rows.length; x++){		
		let cell = myTable.rows[x].getElementsByTagName("td");		
		let input = myTable.rows[x].getElementsByTagName("input");
		let select = cell[5].getElementsByTagName("select");
		
		if(x < myTable.rows.length - 1 ){
			txt += '{"reimbId":' + input[0].value + ',' + '"reimbstatusId":' + select[0].value + '},';
		}else{
			txt += '{"reimbId":' + input[0].value + ',' + '"reimbstatusId":' + select[0].value + '}';
		}
	}
	
	txt += "]"	
	
	let inputText = document.getElementById('jsonText');
	inputText.value = txt;
	//p.innerHTML = txt;
	
}