function post(){
    let xhttp = new XMLHttpRequest();

    xhttp.open("POST", "http://localhost:8091/cliente", true);
    xhttp.setRequestHeader("Accept", "application/json");
    xhttp.setRequestHeader("Content-Type", "application/http");

    let cliente = {
        "nome": document.getElementById("nome").value,
        "sobrenome": document.getElementById("sobrenome").value,
        "documento": document.getElementById("documento").value
    };

    console.log(cliente);
    
    xhttp.onreadystatechange = function(){
        if (xhttp.readyState == 4 && xhttp.status == "200"){
            console.log(xhttp.responseText);
            alert("Cliente cadastrado com sucesso!");
        }
    }
    xhttp.send(JSON.stringify(cliente));
}