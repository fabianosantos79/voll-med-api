package med.voll.api.entities.medico;

import med.voll.api.entities.endereco.DadosEndereco;
import med.voll.api.entities.endereco.Endereco;

public record DadosAtualizacaoMedico(String nome, String telefone, DadosEndereco endereco) {
}
