"use strict";

var x = 100;
let y = "hello";
console.log(y);
if(x>50){
    y = 200;
}

console.log(y);

let dt = new Date();
console.log(JSON.stringify(dt));

let myArray=new Array(0,1,"hello",4,5);
for (let index=0; index<myArray.length; index++){
    console.log(index,myArray[index]);
}

for(let i in myArray){
    console.log(i,myArray[i]);
}

for(let el of myArray){
    console.log(el);
}

function quadrato(x){
    return x**2;
}

console.log("quadrato di 12: ",quadrato(12));

function MyObject(a,b){
    this.a=a;
    this.b=b;
}

let obj = new MyObject("Hello",1321321321321);

for(let elm in obj){
    console.log(elm,obj[elm]);
}

console.log(obj.a+obj.b);

function attuatore(y,func){
    return func(y);
}

console.log(attuatore(12,quadrato));

function apple(type,color){
    this._type=type, //private
    this.color=color,
    this.getInfo=function(){
        return "Apple: "+this._type+", "+this.color;
    };
}

let mela = new apple("Golden", "Giallo aranciato");
//mela.getInfo = quadrato(x);
console.log(mela);
//mela._type="a";
//console.log(mela._type);

