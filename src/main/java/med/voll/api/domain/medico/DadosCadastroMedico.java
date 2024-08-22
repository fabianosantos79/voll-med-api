package med.voll.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.endereco.DadosEndereco;

public record DadosCadastroMedico(
        @NotBlank(message = "O nome é obrigatório")
        String nome,

        @NotBlank(message = "O número do telefone é obrigatório")
        String telefone,

        @NotBlank(message = "Você deve inserir o endereço de e-mail")
        @Email(message = "o formato de email deve seguir texto@texto")
        String email,

        @NotBlank(message = "Obrigatório inserir o número do CRM")
        @Pattern(regexp = "\\d{4,6}", message = "o CRM deve ter de 4 a 6 números")
        String crm,

        @NotNull(message = "Precisa inserir a Especialidade")
        Especialidade especialidade,

        @NotNull
        @Valid
        DadosEndereco endereco) {
}
