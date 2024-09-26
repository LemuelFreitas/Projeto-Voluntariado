$(document).ready(function() {
    loadGuests();
});

function loadGuests() {
    $.getJSON('/voluntario/', function(data) {
        $('#guestTableBody').empty(); // Limpa a tabela antes de inserir novos dados

        data.forEach(guest => {
            $('#guestTableBody').append(
                `<tr>
                    <td>${guest.id}</td>
                    <td>${guest.nome}</td>
                    <td>${guest.datanascimento}</td>
                    <td>${guest.telefone}</td>
                    <td>${guest.tiposanguineo}</td>
                    <td>
                        <button class="btn btn-sm btn-warning" onclick="showEditGuestForm(${guest.id}, '${guest.nome}', '${guest.datanascimento}', '${guest.telefone}', '${guest.tiposanguineo}')">Editar</button>
                        <button class="btn btn-sm btn-danger" onclick="deleteGuest(${guest.id})">Deletar</button>
                    </td>
                </tr>`
            );
        });
    });
}

function showEditGuestForm(id, nome, datanascimento, telefone, tiposanguineo) {
    // Abre o formulário de edição com os dados do voluntário selecionado
    const updatedData = {
        nome: prompt("Nome:", nome),
        datanascimento: prompt("Data de Nascimento:", datanascimento),
        telefone: prompt("Telefone:", telefone),
        tiposanguineo: prompt("Tipo Sanguíneo:", tiposanguineo)
    };

    if (updatedData.nome && updatedData.datanascimento && updatedData.telefone && updatedData.tiposanguineo) {
        $.ajax({
            url: '/voluntario/' + id,
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(updatedData),
            success: function() {
                alert('Voluntário atualizado com sucesso!');
                loadGuests();
            },
            error: function() {
                alert('Erro ao atualizar voluntário.');
            }
        });
    }
}

function deleteGuest(id) {
    if (confirm("Tem certeza que deseja deletar este voluntário?")) {
        $.ajax({
            url: '/voluntario/' + id,
            type: 'DELETE',
            success: function() {
                alert('Voluntário deletado com sucesso!');
                loadGuests();
            },
            error: function() {
                alert('Erro ao deletar voluntário.');
            }
        });
    }
}
