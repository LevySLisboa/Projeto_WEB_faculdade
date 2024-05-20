document.getElementById('login-form').addEventListener('submit', function(event) {
    event.preventDefault();

    var password = document.getElementById("login_password").value;
    if(password.length < 8){
        alert("Tente uma senha maior");
        return;
    }

    const formData = new FormData(this);
    const userData = {
        email: formData.get('login_email'),
        senha: password
    };

    // Envia os dados para a API Spring Boot
    fetch('http://localhost:8080/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(userData)
    }).then(response => {
        if (response.ok) {
            // Redireciona para a página de sucesso
            window.location.href = 'insert_products.html'; // Substitua 'insert_products.html' pela URL da página de destino
        } else {
            throw new Error('Email/senha inválidos: ' + response.statusText);
        }
    }).catch(error => {
        console.error('Erro:', error);
        this.reset();
    });
});
