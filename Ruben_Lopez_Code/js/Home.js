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
			
			
			
			let role = user1.userRoleId;
			 if( role == 1){
				 document.getElementById('myDIV').style.display = 'block';
			 }else{
				 document.getElementById('empDiv').style.display = 'block';
			 }
			
			
		}
	}
	
	
	

	xhttp.open("GET", 'http://localhost:8080/PROJECT1/html/Home.do',
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




//function getJsonInfo(){
//	var myClass = Java.type("com.revature.dao.ErsReimbursementDaoImpls");
//	document.getElementById("reallylongstring").innerHTML = myClass.selectAllReimbursement();
//	
//}

//<div id="userId"></div>
//<div id="userName"></div>
//<div id="userPassword"></div>
//<div id="userFirstName"></div>
//<div id="userLastName"></div>
//<div id="userEmail"></div>
//<div id="userRoleId"></div>