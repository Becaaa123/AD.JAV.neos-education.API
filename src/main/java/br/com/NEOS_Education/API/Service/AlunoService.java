package br.com.NEOS_Education.API.Service;

import br.com.NEOS_Education.API.Entity.AlunoEntity;
import br.com.NEOS_Education.API.Repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired //É usado para injetar o 'repository' na classe
    private AlunoRepository alunoRepository;

    public List<AlunoEntity> listarAlunos(){
        return alunoRepository.findAll();
    }

    public Optional<AlunoEntity> buscarAlunoPorId(Long id){
        return alunoRepository.findById(id);
    }

    public AlunoEntity salvarAluno(AlunoEntity aluno){
        return alunoRepository.save(aluno);
    }

    public void deletarAluno(Long id){
        alunoRepository.deleteById(id);
    }
}
