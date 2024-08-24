package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.consulta.DadosAgendamentoDTO;
import med.voll.api.infra.exception.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidadorHorarioFuncionamentoClinica implements ValidadorAgendamentoDeConsulta {
    public void validar(DadosAgendamentoDTO dados){
        var dataConsulta = dados.data();
        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var horarioAntes = dataConsulta.getHour() < 7;
        var horarioDepois = dataConsulta.getHour() > 18;

        if(domingo || horarioAntes || horarioDepois){
            throw new ValidacaoException("Consulta fora do horário de funcionamento da clínica");
        }
    }
}
