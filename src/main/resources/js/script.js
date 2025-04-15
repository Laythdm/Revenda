$(document).ready(function () {
    // Função para carregar as tarefas da API e exibi-las na tela 
    function carregarCarros() {
        $.ajax({
            url: 'http://localhost:8080/carro/lista',
            method: 'GET',
            success: function (data) {
              

                // Adiciona cada tarefa à tabela 
                for (let i = 0; i < data.length; i++) {
                    let carro = data[i];

                    let id = $('<td>')
                            .text(carro.id);
                    let modelo = $('<input>')
                            .attr('type', 'text')
                            .val(carro.modelo);
                    let marca = $('<input>')
                            .attr('type', 'text')
                            .val(carro.marca);
                    let ano = $('<input>')
                            .attr('type', 'text')
                            .val(carro.ano);
                    let tr = $('<tr>')
                        .attr('data-id', carro.id)
                        .append(id)
                        .append(modelo)
                        .append(marca)
                        
                        .append(ano);
                        

                    $('#tabelaCarros tbody').append(tr);
                }
            },
           
        });
    }
    function atualizarCarro(id, carro) {
        $.ajax({
            url: 'http://localhost:8080/lista/' + id,
            method: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify({
                modelo: carro.modelo,
                marca: carro.marca,
                ano: carro.ano,
                disponivel: carro.disponivel
            }),
            success: function (data) {

                alert('Carro vendido com sucesso');
                carregarTarefas();
            },
            error: function () {
                alert('Não foi possivel vender');
            }
        });
    }
    function criarCarroForm(carro) {
        $.ajax({
            url: 'http://localhost:8080/lista',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(carro),
            success: function (data) {
                
                $('#modelo').val('');
                $('#marca').val('');
                $('#ano').val('');
                $('#disponivel').val('');
                
                 alert('Carro registrodo com sucesso!');
                
            },
            error: function () {
                alert('Não foi possível limpar tabela');
            }
        });
    }
     $('#formCriarCarros').submit(function (event) {
        event.preventDefault();
       
        let modelo = $('#modelo').val();
        if (!modelo) {
            alert('Por favor, preencha o modelo.');
            return;
        }
        let marca = $('#marca').val();
        if (!marca) {
            alert('Por favor, preencha a marca.');
            return;
        }
        let ano = $('#ano').val();
        if (!ano) {
            alert('Por favor, informe o ano de lançamento');
            return;
        }
        let disponivel = $('#disponivel').val();
        if (!disponivel) {
            alert('Por favor, informe o status do veiculo');
            return;
        }
        criarCarroForm(carro);
    });

    carregarCarros();
});

