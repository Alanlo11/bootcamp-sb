console.log("Hello World!");

function sum(){
  return 1 + 2;
}
// System.out.printf("Num =%d", num);
console.log(`Num = ${sum}`);
// JS世界係Weak Type
let num = 1; //呢到佢係一個int in java
num = "String"; // 呢下佢就會係string in java,會根據比咩佢而改變

// Constants 
// sonst JS 既final

// Bigint = long
let age = "1";
console.log(111,sum);

console.log(age ?? "unknown");
// 上下寫法意思一樣
if(age === null || age === undefined){
  console.log("unknown");
} else {
  console.log(age);
}

function sum(num1, num2 = 2){
  console.log(num1 + num2);
}
function sum2(num1, num2 = 2){
  return num1 + num2;
}

sum(1);// 3
sum(3);// 5

sum(1,10,3); // 11,第3個唔會食

console.log(sum2(10));// 寫法唔同，call佢要print野都唔同

function sum3 (sum, num3){
  console.log(sum(1,5) + num3);
}

sum3(sum,0);// NaN

let um = [1,'gfdg']; // 入面擺咩都得，唔係fix length

let child = {
  name : "alan",
  age : 10,
  "programming language": ["java","js","tss"]
} //呢個已經係obj

console.log(child["programming language"][0]); // java

for(let key in child){
  console.log(key)
} // name,age,pargramming language

// call back function , 姐係method call method

let nums = [1,2,3,4,5,6,7,8,9];

nums.forEach((value, index,array) => {
  console.log(value, index, array);
})
// value = 1, index = 0, array = [1,2,3,4,5,6,7,8,9]
// value = 2, index = 1, array = [1,2,3,4,5,6,7,8,9]
// ...

let result = 0;
nums.forEach((value) => {
 result += value;
})
console.log(result);// 45

let result2 = nums.map((value) => {
return value * value
});

console.log(result2); //[ 1,  4,  9, 16, 25, 36, 49, 64, 81]

let filter_result = nums.filter((value) => {
  if(value >= 5){
    return true;
    } else {
      return false;
    }
})
console.log(filter_result);// [5,6,7,8,9]

class student {
  constructor(name){
    this.name = name;
  }
}

