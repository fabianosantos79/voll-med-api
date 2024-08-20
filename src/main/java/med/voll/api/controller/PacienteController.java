package med.voll.api.controller;

import med.voll.api.entities.paciente.DadosCadastroPaciente;
import med.voll.api.entities.paciente.DadosListagemPaciente;
import med.voll.api.entities.paciente.Paciente;
import med.voll.api.entities.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

@Autowired
private PacienteRepository pacienteRepository;

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroPaciente dados){
        pacienteRepository.save(new Paciente(dados));
    }

    @GetMapping
    public Page<DadosListagemPaciente> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        return pacienteRepository
                .findAll(paginacao)
                .map(DadosListagemPaciente::new);
    }

//    @GetMapping
//    public List<DadosListagemPaciente> listar(){
//        return pacienteRepository
//                .findAll()
//                .stream()
//                .map(DadosListagemPaciente::new).toList();
//    }
}
