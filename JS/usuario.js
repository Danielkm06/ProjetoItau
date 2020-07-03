function exibirUsuario(){

    var usuarioLogado = localStorage.getItem("user");

    if (!usuarioLogado){
        window.location="index.html";
    } else {
        var usuarioJson = JSON.parse(usuarioLogado);
        document.getElementById("perfil").innerHTML = usuarioJson.nome + "<br></br>" 
        + usuarioJson.racf
        //"<br><h4>" + usuarioJson.email +
        //"<br> Código : " + usuarioJson.id  + "</h4>";
        document.getElementById("fotoUsuario").innerHTML = 
        "<img src=images/" + usuarioJson.foto + " height=100 width=100>"
    }

    exibirParceiros()

}

function exibirParceiros(){

    var cabecalho={
        method : "GET",
        headers : {
            "Content-Type" : "application/json"
        }
    }
    fetch("http://localhost:8080/top10", cabecalho)
    .then(res => res.json())
    .then(res => popula(res))
    .catch(err=>{
        alert("Erro!");
    })

}

function popula(lista){

    var stringLista = "<thead> <tr>" +
        "<th scope=col>" +
            "Parceiro" +
        "</th>" +
        "<th scope=col>" +
            "Volume Transacional" +
        "</th>" +
    "</tr> </thead>";
    for (i = 0; i < lista.length; i++){
        stringLista += "<tr>" +
            "<td>" +
                lista[i].nomeAgente +
            "</td>" +
            "<td>" +
                lista[i].volumeTransacional +
            "</td>" +
        "</tr>";
    }

    document.getElementById("parceirosVolume").innerHTML = stringLista;

    var stringDrop = "";

    for (i = 0; i < lista.length; i++){
        stringDrop += "<a class=dropdown-item href=parceiros.html?Parceiro=" + lista[i].idAgente + ">" + 
        lista[i].nomeAgente + "</a>"
    }

    document.getElementById("dropParceiros").innerHTML = stringDrop;



}