package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.consulta.DadosAgendamentoDTO;

public interface ValidadorAgendamentoDeConsulta {
    void validar(DadosAgendamentoDTO dados);
}
