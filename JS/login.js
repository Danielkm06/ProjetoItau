function login(){
    
    var user = document.getElementById("txtUsuario").value

    if (user.includes("@")){
        var mensagem={
            email : user,
            senha : document.getElementById("txtSenha").value
        };
    } else {
        var mensagem={
            racf : user,
            senha : document.getElementById("txtSenha").value
        };
    }

    var cabecalho={
        method : "POST",
        body : JSON.stringify(mensagem),
        headers : {
            "Content-Type" : "application/json"
        }
    }
    fetch("http://localhost:8080/login", cabecalho)
    .then(res => res.json())
    .then(res => {
                localStorage.setItem("user",JSON.stringify(res) );
                window.location="usuario.html";
           })
    .catch(err=>{
        alert("Erro!");
    })

}