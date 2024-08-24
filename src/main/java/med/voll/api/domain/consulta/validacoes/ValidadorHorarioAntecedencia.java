package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.consulta.DadosAgendamentoDTO;
import med.voll.api.infra.exception.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoDeConsulta {

    public void validar(DadosAgendamentoDTO dados){
        var dataConsulta = dados.data();
        var horarioAgendamento = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(horarioAgendamento, dataConsulta).toMinutes();

        if(diferencaEmMinutos < 30){
            throw new ValidacaoException("Necessário agendar consulta com no mínimo 30 minutos de antecedência.");
        }
    }
}
