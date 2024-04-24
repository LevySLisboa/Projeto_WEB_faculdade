document.getElementById('productForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Evita o comportamento padrão de enviar o formulário

        var priceInput = document.getElementById("price");
        var price = parseFloat(priceInput.value.replace(',', '.')); // Substitui vírgula por ponto para aceitar números decimais
        if (isNaN(price) || price <= 0) {
            alert("Por favor, insira um preço válido.");
            event.preventDefault(); // Impede o envio do formulário se o preço não for válido
        }


    // Coleta os dados do formulário
    const formData = new FormData(this);
    const productData = {
        nome: formData.get('name'),
        descricao: formData.get('description'),
        preco: price
    };

    // Envia os dados para a API Spring Boot
    fetch('http://localhost:8080/products', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(productData)
    }).then(response => {
        console.log(response.text()); // Log the raw response
        if (response.ok) {
          return response.json();
        } else {
          throw new Error('Erro ao registrar o produto: ' + response.statusText);
        }
      })

    .then(data => {
        alert('Produto registrado com sucesso!');
        console.log(data);
        // Limpa o formulário após o registro bem-sucedido, se desejado
        this.reset();
    })
    .catch(error => {
        console.error('Erro:', error);
    });
});
