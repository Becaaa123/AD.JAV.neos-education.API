package br.com.NEOS_Education.API.Controller;

import br.com.NEOS_Education.API.Entity.AlunoEntity;
import br.com.NEOS_Education.API.Service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/neos")
@CrossOrigin(origins = "https://becaaa123.github.io/NEOS_Education/") //URL do front
public class AlunoController {

    private final AlunoService alunoService;

    @Autowired //É usado para injetar o 'service' na classe
    public AlunoController(AlunoService alunoService){
        this.alunoService = alunoService;
    }

    @GetMapping
    public List<AlunoEntity> listarAlunos(){
        return alunoService.listarAlunos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoEntity> buscarAlunosPorId(@PathVariable Long id){
        return alunoService.buscarAlunoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AlunoEntity> salvarAlunos(@RequestBody AlunoEntity aluno){
        AlunoEntity alunoSalvo = alunoService.salvarAluno(aluno);
        return new ResponseEntity<>(alunoSalvo, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAluno(@PathVariable Long id){
        alunoService.deletarAluno(id);
        return ResponseEntity.noContent().build();
    }
}