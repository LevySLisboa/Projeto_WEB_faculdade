document.getElementById('userForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Evita o comportamento padrão de enviar o formulário

    // Verifica se as senhas são iguais
    var password = document.getElementById("password").value;
    var password_confirmation = document.getElementById("password_confirmation").value;
    if (password !== password_confirmation) {
        alert("As senhas não correspondem.");
        return;
    }

    // Coleta os dados do formulário
    const formData = new FormData(this);
    const userData = {
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
        // Limpa o formulário após o registro bem-sucedido, se desejado
        this.reset();
    }).catch(error => {
        console.error('Erro:', error);
    });
});