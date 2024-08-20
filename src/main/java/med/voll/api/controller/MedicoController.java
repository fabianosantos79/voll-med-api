package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.entities.medico.DadosCadastroMedico;
import med.voll.api.entities.medico.DadosListagemMedico;
import med.voll.api.entities.medico.Medico;
import med.voll.api.entities.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
        medicoRepository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size=10, sort = {"especialidade"}) Pageable paginacao){
        return medicoRepository
                .findAll(paginacao)
                .map(DadosListagemMedico::new);
    }

//    @GetMapping
//    public List<Medico> listar(){
//        return medicoRepository.findAll();
//    }
}
