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
