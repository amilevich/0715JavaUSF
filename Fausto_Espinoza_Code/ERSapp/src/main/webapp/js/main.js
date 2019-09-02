/**
 * 
 */

let insert = document.getElementById("insert"); 
insert.addEventListener('click', myFunction);
function myFunction(event){
	let myTable = document.getElementById("myTable");
	let row = myTable.insertRow(-1);
	let cell1 = row.insertCell(0);
	let cell2 = row.insertCell(1);
	let cell3 = row.insertCell(2);
	let cell4 = row.insertCell(3);
	cell1.innerHTML = " <input type='number' id='amount' name='amount' >";
	cell2.innerHTML = " <input type='file' id='file' name='file' > ";
	cell3.innerHTML = " <input type='text' id='name' name='name' > ";
	cell4.innerHTML = " <select id='type' name='type'></select> ";
	row.appendChild(cell1);
	row.appendChild(cell2);
	row.appendChild(cell3);
	row.appendChild(cell4);
//	myTable.appedChild(row);
}