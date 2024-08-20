package med.voll.api.entities.paciente;

import med.voll.api.entities.endereco.DadosEndereco;

public record DadosCadastroPaciente(
        String nome,
        String email,
        String telefone,
        String cpf,
        DadosEndereco endereco)
{}
