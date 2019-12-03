const HOSTTOKEN = "http://localhost:8082";
const HOSTCLIENTE = "http://localhost:8081";

const getParameterUrl = descParameter =>{  
    var parameters = window.location.search.split('&'); //quebra os parametros onde possuir o divisor '&'  
    var valueParameter = "";  
    if(parameters != ""){  
         for(var i in parameters){ //percorre o(s) paramêtro(s) oriuntdo(s) da url  
              if(parameters[i].startsWith(descParameter)){ //verifica a descricao do parâmetro como os que estão na url  
                   var param = descParameter + "=";  
                   valueParameter = parameters[i].replace(param,''); //retira a descrição do parametro e o símbolo de igualdade '=' e deixa apenas seu valor  
              }  
         }  
    }  
    return valueParameter; // retorno do valor  
}  
const verificarToken = (token) =>{
    let resposta = false;
    $.ajax({
            url : `${HOSTTOKEN}/tokens`,
            type : 'post',
            headers : {"token": token},
            async:false,
        success: data => {
            resposta = data.validity;
        }

    });
    return resposta;

}
const salvar = () =>{


    let token = getParameterUrl("?token");
    if(!verificarToken(token)){
        window.parent.close();
    }

    let telefone = $("#txt_telefone").val();
    let nome = $("#txt_nome").val();
    let email = $("#txt_email").val();

    let data = {nome, email, telefone};
    $.ajax({
        url : `${HOSTCLIENTE}/clientes`,
        type : 'post',
        dataType: 'json',
        contentType: "application/json",
        dataType: 'json',
        data : JSON.stringify(data),
        success: data => {
            alert("Registro criado");  
            window.location.href="listagem.html";              
        }

    });
}

let token = getParameterUrl("?token");
if(!verificarToken(token)){
    window.parent.close();
}
