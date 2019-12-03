const HOSTCLIENTE = "http://localhost:8081"

$(document).ready(function(){


    const listarTodos = lista =>{
        lista.map(e => {
            $("#corpo_tabela").append(`
                <tr>
                    <th scope="row">${e.id}</th>
                    <td>${e.nome}</td>
                    <td>${e.telefone}</td>
                    <td>${e.email}</td>
                </tr>`);
        });
    }

    const buscarTodos = () =>{
        $.get(`${HOSTCLIENTE}/clientes`, (data) =>{
            listarTodos(data);
        });
    }
    buscarTodos();

});