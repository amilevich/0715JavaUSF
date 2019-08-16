
// Fibonacci
function fibo(count){
	n1=0;
	n2=1;
	n3 = null;
	array =[]
	 	if(count>=1){
		array.push(n1)
	}
	
		array.push(n2)
	if(count>1){
		for(i=0; i<count-2;i++){
			n3 = n1 + n2;
			array.push(n3)
			n1 = n2
			n2 = n3
			// if(i==count-2)
			// 	return;
		}
	}
console.log("Whole sequence up to N")
console.log(array)
console.log("Fibo: Nth num in the sequence")
	console.log(array[count-1]);
}
console.log("Fibo of 10")
console.log("--------------")

fibo(10);
console.log("--------------")

// Bubble sort
array1= [1616,2,3,41,5,1,61,1]
sorted = []
// console.log(array)
function bubbleSort(array)
{
for(i =0; i<array.length; i++){
	for(j = 0; j<array.length-1; j++){
		if(array[j]>array[j+1]){
		temp = array[j];
		array[j]=array[j+1]
		array[j+1] = temp;

		}
	}
}
	console.log(array)
}
// console.log(array.pop());
// array[2]=33;
// console.log(bubbleSort(array))
console.log("Bubble Sort of this array: " )
console.log(array1)
console.log("After sorting: ")
bubbleSort(array1)