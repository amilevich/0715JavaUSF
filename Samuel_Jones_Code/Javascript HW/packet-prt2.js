

// Question 1 
console.log("Q1-------------------")
console.log(document.getElementById("usaspan").textContent)

// Q2
function getSales(){

	const rowElements = $("tr")
	let nameElements = $("td.empName")
	let deptElements = $("td.deptName")

		for(i=0;i<nameElements.length;i++){
			if(deptElements[i].outerText=="Sales"){
			alert("Sales employees: " + nameElements[i].outerText)

			}
		}
	}



  

console.log("Q2-------------------")
console.log("Refer to the alerts that fire on window load")
getSales()

// Q3
// anchor tag spans
let anchors = document.getElementsByTagName('a')
let spans1 = document.getElementsByTagName('span')
function getAnchorChildren(){
	[...anchors].forEach(elem => {
	[...spans1].forEach(elems =>{
		if(elem.contains(elems)){
			console.log("span inside of an anchor contains " + elems.innerHTML)
		}
	})
})
}
console.log("Q3-------------------")
console.log("Text from all spans inside spans")
getAnchorChildren()
// spanText()

//------------------- Q3
console.log("Q4------------------")
function getSelectedHobbies(){
	let hobbies = $("select[name='skills'] option:selected")[0].value
	return hobbies;
}

	// let hobbies = $("select[name='skills'")
	console.log("Selected Hobbies: ")
	console.log(getSelectedHobbies())

	console.log("----------Q5----------")
function getCustAttr(){
	let attributes = $("[data-customAttr")
let elements1= document.querySelectorAll("[data-customAttr]")

for(i =0;i<attributes.length-1;i++){
	let attribute = $("[data-customAttr]")[i].attributes[1]

	if(attribute==undefined){
	console.log("Custom attribute val: " + elements1[i].attributes[0].value)
		// console.log("Custom attribute val: " + $("span[data-customAttr]")[i].attributes[0].value)
	// console.log($("[data-customAttr]")[i])

		continue;
	}


	else {
		console.log("Custom attribute val: " + attribute.value)


	}
}
	console.log($("[data-customAttr]")[4])
}
getCustAttr()
console.log("--------Q6---------")
console.log("Refer to le DOM, s'il vous plait")

$(document).ready(function(){
let input1 = $("#num1")[0]
let input2 = $("#num2")[0]

})
// 6 Sum event
var val1 = 0;
$("#num1").on("change",function(){
	$("#sum").empty()

	// if(typeof(this.value)!= "number"){
	// 	alert("Cannot add, type of value is " + typeof(this.value))
	// }
	// alert(typeof(this.value))
	val1 = this.value;
})
$("#num2").on("change", function(){
	let sum = parseInt(this.value) + parseInt(val1)
	$("#sum").append(parseInt(this.value)+parseInt(val1))

})


/// 7 Skills option 

$("#skills").change(function(){
	alert("Are you sure " + $("#skills").val() + " is one of your skills?")
})
// 8 Color event
let colorBtns1 = $(".color-btn").click(function(){
	alert("So, " + this.value + " is your favorite color?")
	let colors = $("#colorsDiv")
	colors.css("background-color",this.value)
})

// Q9 show hide
	let nameElements = $("td.empName")
function toggleHide(elements){
		elements.hover(function(){
			elements.hide()
		})
		$("body,div,p").hover(function(){
			elements.show()
		})
		// !elements.hover(function(){
		// 	elements.show()
		// })
}
toggleHide(nameElements)
// console.log($(".empName"))
// let arr=$(".empName")
// arr[0]on("click", ()=>alert("hi"))
// console.log(arr[0])
// for(i=0;i<arr.length;i++){
// 	arr[i].mouseenter(function(){
// 		arr[i].hide()
// 	})
// }
// $(".empName").mouseenter(function(){
// 	$(".empName").hide()
// });
	
// $(".empName").mouseleave(function(){
// 	$(".empName").show()
// });
	

function startTime() {
  var today = new Date();
  var h = today.getHours();
  var m = today.getMinutes();
  var s = today.getSeconds();
  m = checkTime(m);
  s = checkTime(s);
  if(h>12){
  $("#currentTime").text((h-12) + ":" + m + ":" + s + " PM") 

  }
  else {
  $("#currentTime").text((h) + ":" + m + ":" + s + " AM") 

  }
  var t = setTimeout(startTime, 500);
}
function checkTime(i) {
  if (i < 10) {i = "0" + i};  // add zero in front of numbers < 10
  return i;
}
startTime()

// 7 Skills event

//11 Delay
// $("#helloWorld").click(function(){colorChange})	
// function colorChange(){
// 	setTimeout($("#helloWorld").css("color","red"), 3000)
	
// }
let hellWorl = document.getElementById("helloWorld");
hellWorl.addEventListener("click",delayColorChange);

function delayColorChange(){
	setTimeout('hellWorl.style.color = "red"',3000)
}