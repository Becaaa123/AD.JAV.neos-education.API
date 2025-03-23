package br.com.NEOS_Education.API.Controller;

import br.com.NEOS_Education.API.Entity.AlunoEntity;
import br.com.NEOS_Education.API.Service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/neos")
@CrossOrigin(origins = "https://becaaa123.github.io/NEOS_Education/") //URL do front
public class AlunoController {

    @Autowired //É usado para injetar o 'service' na classe
    private AlunoService alunoService;

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
    public AlunoEntity salvarAlunos(@RequestBody AlunoEntity aluno){
        return alunoService.salvarAluno(aluno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAluno(@PathVariable Long id){
        alunoService.deletarAluno(id);
        return ResponseEntity.noContent().build();
    }
}
