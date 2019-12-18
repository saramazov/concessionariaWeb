let bt1 = document.getElementById("btn1");
bt1.value="XXX";
console.log(bt1);
bt1.addEventListener('click',clickOnButton);
function clickOnButton(event){
    document.getElementById("text.placeholder").innerText="Hello World!";
    //alert("click su"+event);
}
function clicca(){
    console.log(event);
    console.log(this.id);
    document.getElementById("text.placeholder").innerText="sdfsdfsdfdfds!";
}