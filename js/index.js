const HOST = "http://localhost:8080"

$(document).ready(function(){
    
    $.get(`${HOST}/cadastro`, (dados) =>{
        window.location.href = `cadastro.html?${dados.token}`;
    })


});
