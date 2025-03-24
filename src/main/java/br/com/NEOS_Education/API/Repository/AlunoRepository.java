package br.com.NEOS_Education.API.Repository;

import br.com.NEOS_Education.API.Entity.AlunoEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoEntity, Long> {
}