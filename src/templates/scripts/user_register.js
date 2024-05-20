document.getElementById('register-form').addEventListener('submit', function(event) {
    event.preventDefault(); // Evita o comportamento padrão de enviar o formulário

    // Verifica se as senhas são iguais
    var password = document.getElementById("register_password").value;
    var password_confirmation = document.getElementById("password_confirmation").value;
    if(password<8 || password_confirmation<8){
        alert("Tente uma senha maior");
        return;
    }
    if (password !== password_confirmation) {
        alert("As senhas não correspondem.");
        return;
    }

    // Coleta os dados do formulário
    const formData = new FormData(this);
    const userData = {
        matricula:formData.get('matricula'),
        nome: formData.get('name'),
        email: formData.get('email'),
        senha: password // Usando a senha digitada
    };

    // Envia os dados para a API Spring Boot
    fetch('http://localhost:8080/users', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(userData)
    }).then(response => {
        console.log(response.text()); // Log the raw response
        if (response.ok) {
            return response.json();
        } else {
            throw new Error('Erro ao registrar o usuário: ' + response.statusText);
        }
    }).then(data => {
        alert('Usuário registrado com sucesso!');
        console.log(data);
    }).catch(error => {
        console.error('Erro:', error);
        this.reset();
    });
});