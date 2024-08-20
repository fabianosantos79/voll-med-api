package med.voll.api.entities.paciente;

import jakarta.validation.constraints.NotNull;
import med.voll.api.entities.endereco.DadosEndereco;

public record DadosAtualizaPaciente(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
