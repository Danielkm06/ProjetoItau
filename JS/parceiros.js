function exibirVolumes(){

    var url_string = window.location.href;
    var url = new URL(url_string);
    var agente = url.searchParams.get("Parceiro");

    var cabecalho={
        method : "GET",
        headers : {
            "Content-Type" : "application/json"
        }
    }

    var urlGet = "http://localhost:8080/dashboard/" + agente

    fetch(urlGet, cabecalho)
    .then(res => res.json())
    .then(res => populaTransacoes(res))
    .catch(err=>{
        alert("Erro!");
    })
    
    var urlAgente = "http://localhost:8080/agentefinanceiro/" + agente

    fetch(urlAgente, cabecalho)
    .then(res => res.json())
    .then(res => populaAgente(res))
    .catch(err=>{
        alert("Erro!");
    })

}

function populaTransacoes(lista) {

    var sucesso = "<b><p class=card-text>" + lista[0] + "</p></b>";
    document.getElementById("parceiroSucesso").innerHTML = sucesso;
    
    var falha = "<b><p class=card-text>" + lista[1] + "</p></b>";
    document.getElementById("parceiroFalha").innerHTML = falha;

    var fraude = "<b><p  class=card-text>" + lista[2] + "</p></b>";
    document.getElementById("parceiroFraude").innerHTML = fraude;

}

function populaAgente(lista){

    var strAgente = "<b><p'  class=card-text>" + 
    lista.nomeAgente + "/" + lista.volumeTransacional
    + "</p></b>";
    document.getElementById("agente").innerHTML = strAgente;

    var nome = "<p id=agenteSuperior class=col-12>" + lista.nomeAgente + "</p>"

    document.getElementById("nomeAgente").innerHTML = nome;

}