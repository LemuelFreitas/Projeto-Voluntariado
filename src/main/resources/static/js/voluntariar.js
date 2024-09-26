document.getElementById('photo-input').addEventListener('change', function(event) {
    const file = event.target.files[0];
    const reader = new FileReader();

    reader.onload = function(e) {
        const previewImage = document.getElementById('photo-preview');
        previewImage.src = e.target.result;
    };

    if (file) {
        reader.readAsDataURL(file);
    }
});

$(document).ready(function() {
    $('#guestContent').hide(); // Oculta a tabela de voluntários

    // Ao enviar o formulário
    $('#guestForm').submit(function(event) {
        event.preventDefault();
        addGuest(); // Função para adicionar voluntário
    });
});

// Função para adicionar o voluntário
function addGuest() {
    const guest = {
        nome: $('#guestnome').val(),
        datanascimento: $('#guestdatanascimento').val(),
        telefone: $('#guesttelefone').val(),
        tiposanguineo: $('#guesttiposanguineo').val()
    };

    $.ajax({
        url: '/voluntario/', // Endpoint da API para salvar voluntário
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(guest),
        success: function() {
            $('#guestForm')[0].reset(); // Limpa o formulário
            $('#successMessage').text('Voluntário cadastrado com sucesso!').fadeIn().delay(3000).fadeOut(); // Exibe mensagem de sucesso
            $('#guestContent').show(); // Mostra a tabela ou conteúdo se necessário
        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.error('Erro ao adicionar voluntário:', textStatus, errorThrown);
            alert('Erro ao adicionar o voluntário: ' + errorThrown);
        }
    });
}
