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
			let typeReb = JSON.parse(xhtpp.responseText);			
			setValues(typeReb);		    
		}
	}	
	xhtpp.open("GET","http://localhost:8080/ERSapp/html/ErsType.do",true);	
	xhtpp.send();
}


function setValues(typeReb){	
	
	let dropDown = document.getElementById('type');
	
	for (let i = 0; i < typeReb.length; i++) {
	      let option = document.createElement('option');
	      option.text = typeReb[i].typeId + " " + typeReb[i].typeName;
	      option.value = typeReb[i].typeId;
	      dropDown.add(option);
    }	  
}