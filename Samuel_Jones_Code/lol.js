function get_USA() {
 	var seartext = "USA";
	var tagval = document.body.getElementsByTagName("*");
 	for (var i = 0; i < tagval.length; i++) {
    	var n1 = tagval[i].textContent.search(seartext);
    	if(n1 != -1){
       	alert(tagval[i].textContent);
       	break;
    	}
     
 	}
  
}
get_USA()
// function get_People_In_Sales(){
// 	var table11 = document.getElementsByTagName("table")[0];
// 	for (var i = 0; i <table11.rows.length;i++){
//  	var cells11 = table11.rows[i].cells11;
//      	if(cells11[1].textContent === "Sales"){
//        	alert(cells11[0].textContent);
//     	}
// 	}
  
// }
// get_People_In_Sales()
function get_Anchor_Children(){
var anchor = [];
var searchElement = document.getElementById("myDiv").children;
for(var i = 0; i < searchElement.length; i++) {
	if(searchElement[i].tagName == 'SELECT' || searchElement.tagName == 'INPUT') {
    	if(searchElement[i].id.indexOf('q1_') == 0) {
        	anchor.push(searchElement[i]);
    	}
	}
}
}
get_Anchor_Children()
function Hobies(){
var hobbi = document.getElementsByName("hobbies")[0];
var selecthobbies = hobbi.options[hobbies.selectedIndex].value;
var contenthobbies = hobbi.options[hobbies.selectedIndex].textContent;
alert(contenthobbies + ":" + selecthobbies);
var skills = document.getElementsByName("skills")[0];
var selectedSkills = skills.options[skills.selectedIndex].value;
var contentSkills = skills.options[skills.selectedIndex].textContent;
alert(contentSkills + ":" + selectedSkills);
}
Hobies()
function get_custom_attribute(){
var elements11 = document.querySelectorAll('[data-customAttr]');
for (var i = 0; i <elements11.length;i++){
 	alert(elements11[i].dataset.customattr);
	}
}
get_custom_attribute()

let elements = document.querySelectorAll("[data-customAttr]")
console.log(elements)
