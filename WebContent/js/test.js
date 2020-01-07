let titolo = document.getElementById("titolo");
console.log(titolo.innerText);
let titleArray = [document.getElementById("titolo"), document.getElementById("titolo")];
console.log(titleArray);
let button = document.getElementById("bt01");
//button.value = "My button";
let bottone = document.getElementById("bt02");
//bottone.innerText = "Il mio bottone";
button.addEventListener("click", cambiaNome);
let link = document.getElementById("wiki");
link.addEventListener("click", clickLink);

function cambiaNome(){
    button.value = "My button";
}

bottone.addEventListener("click", cambiaNome2);

function cambiaNome2(){
    bottone.innerText = "Il mio bottone";
}

function clickButton(){
    document.getElementById("bt03").innerText = "Peppe";
}

function clickButton2(event){
    alert("Ultimo bottone attivato!");
    console.log(event.target);
    event.target.innerText = "click gestito";
}
function clickLink(){
    link.class="clickedLink";
}