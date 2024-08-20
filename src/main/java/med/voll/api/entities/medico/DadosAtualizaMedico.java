package med.voll.api.entities.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.entities.endereco.DadosEndereco;

public record DadosAtualizaMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
