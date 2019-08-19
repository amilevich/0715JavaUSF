//1. USA
// Define function getUSA()
// Find the html element that contains "USA".
// Print that element's contents.
function getUSA()
{
    let usa = document.getElementById("usaHeader")
    console.log(usa.innerText)
}

//2. Sales
// Define function getPeopleInSales()
// Print the names of all the people in the sales department.
function getPeopleInSales()
{
    let table = document.getElementById("employees")
    for (let i = 0; i < table.rows.length; i++)
    {
        let row = table.rows[i]
        if (row.cells[1].innerText == "Sales")
        {
            console.log(row.cells[0].innerText)
        }
    }
}

//3. Click Here
// Define function getAnchorChildren()
// Find all anchor elements with a <span> child.
// Print the contents of <span>
function getAnchorChildren()
{
    let anchors = document.getElementsByTagName("a")
    for (let i = 0; i < anchors.length; i++)
    {
       for (let j = 0; j < anchors[i].children.length; i++)
       {
           let span = anchors[i].getElementsByTagName("span")
           console.log(span[j].innerText)
       }
    }
}

//4. Hobbies
// Define function getHobbies()
// Find all checked options in the 'skills' select element.
// Print the value and the contents.
function getHobbies()
{
    let hobbies = document.getElementsByName("hobbies")
    for (let i = 0; i < hobbies.length; i++)
    {
        if (hobbies[0][i].selected)
        {
            console.log(hobbies[0][i].value)
        }
    }
}

//5. Custom Attribute
// Define function getCustomAttribute()
// Find all elements with "data-customAttr" attribute
// Print the value of the attribute.
// Print the element that has the attribute.
function getCustomAttribute()
{
    let element = document.querySelectorAll('[data-customAttr]')
    for (let i = 0; i < element.length; i++)
    {
        console.log(element[i].getAttribute("data-customattr"))
        console.log(element[i])
    }
}

//6. Sum Event
// Regarding these elements:
// 	<input id="num1" class="nums" type="text"/>
// 	<input id="num2" class="nums" type="text"/>
// 	<h3>Sum: <span id="sum"></span></h3>
//
// Define onchange event handler.
// Add <input> element values.
// Put the sum in the <span> element.
// If values cannot be added, put "Cannot add" in the <span> element
let num1 = document.getElementById("num1")
let num2 = document.getElementById("num2")
let sumField = document.getElementById("sum")
num1.addEventListener("change", addNums)
num2.addEventListener("change", addNums)

function addNums()
{
    let string1 = num1.value
    let string2 = num2.value
    if(isNaN(+string1 + +string2))
    {
        sumField.innerText = "Cannot add"
    }
    else
    {
        sumField.innerText = +string1 + +string2
    }

}

//7. Skills Event
// When user selects a skill, create an alert with a message similar to:
// 	"Are you sure CSS is one of your skills?"
// NOTE: no alert should appear when user deselects a skill.
let selectedSkill = document.getElementById("skills")
selectedSkill.addEventListener("change", skillAlert)
function skillAlert()
{
    alert(`Are you sure ${selectedSkill.value} is one of your skills?`)
}





