/**
 * 
 */

window.onload = function(){
	getInfo();
}

function getInfo(){
	
	let xhtpp = new XMLHttpRequest();
	
	xhtpp.onreadystatechange  = function(){
		if(xhtpp.readyState == 4 && xhtpp.status == 200){
			let role = JSON.parse(xhtpp.responseText);			
			setValues(role);		    
		}
	}	
	xhtpp.open("GET","http://localhost:8080/ERSapp/html/EnrollUser.do",true);	
	xhtpp.send();
}


function setValues(role){
	
	let dropDown = document.getElementById('userRole');
	
	for (let i = 0; i < role.length; i++) {
	      let option = document.createElement('option');
	      option.text = role[i].roleId + " " + role[i].roleName;
	      option.value = role[i].roleId;
	      dropDown.add(option);
    }	  
}