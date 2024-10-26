const button = document.getElementsByClassName("primary-button-menu");

const role = localStorage.getItem("cargo")
if(role !== "gerente"){
    button.classList.add('disable');
}
