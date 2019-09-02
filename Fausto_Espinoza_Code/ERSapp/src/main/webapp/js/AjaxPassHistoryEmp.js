/**
 * 
 */

window.onload = function(){
	getInfo();	
}

//window.onunload = function(){
//	getData();
//}

//let ticket = document.getElementById('ticket');
//ticket.addEventListener('change',getData,false);



function getInfo(){	
	
	let xhtpp = new XMLHttpRequest();
	
	xhtpp.onreadystatechange  = function(){
		if(xhtpp.readyState == 4 && xhtpp.status == 200){
			let pendtk = JSON.parse(xhtpp.responseText);
			setValues(pendtk);		    
		}
	}	
	xhtpp.open("GET","http://localhost:8080/ERSapp/html/TickectEmpl.do",true);	
	xhtpp.send();
}

//function getData(){	
//	let inputText = document.getElementById('jsonText');
//	let valueText = ticket.value;
//	inputText.value = valueText ;
////	this.form.submit();
//	getInfo();
//}

function setValues(pendtk){	
	let mytbody = document.getElementById("mytbody");
	let txt = "";
    for (x in pendtk) {	      
    	txt += "<tr><td>";
    	txt += " <input type='text' id='id' name='idTicket' " +
		"value='"+ pendtk[x].reimbId+"' disabled='disabled'>"
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
//    	txt += "<td>";
//    	txt += "<select id='type' name='type' disabled='disabled'><option value='1'>" +
//				"Pending</option> <option value='2'>Approve</option> <option value='3'>" +
//				"Deny</option></select> ";
//    	txt += "</td>";	    	
    }	        
    mytbody.innerHTML = txt;
}