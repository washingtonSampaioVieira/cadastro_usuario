const HOSTTOKEN = "http://localhost:8082";
const HOSTCLIENTE = "http://localhost:8081";

$(document).ready(function(){
    
    $("#novo_cadastro").click( () =>{
        let token = getToken();
        
    });

    const getToken = () =>{
        $.get(`${HOSTTOKEN}/tokens`, (data) =>{
            setInfo(data.token);
        });
    }
    const setInfo = token =>{
        $("#link_cadastre").html("");
        $("#link_cadastre").append(`Se cadastre <a id="link_cadastrese" class="link_c"  href="cadastro.html?token=${token}" target="_blank">aqui!</a>`);
    }

});
