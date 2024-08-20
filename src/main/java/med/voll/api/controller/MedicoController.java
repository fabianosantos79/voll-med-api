package med.voll.api.controller;

import med.voll.api.entities.medico.DadosCadastroMedico;
import med.voll.api.entities.medico.Medico;
import med.voll.api.entities.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroMedico dados){
        medicoRepository.save(new Medico(dados));
    }
}
