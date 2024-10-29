const button = document.getElementsByClassName("primary-button-menu");

const role = localStorage.getItem("Cargo")
if(role !== "gerente"){
    button.classList.add('disable');
}
