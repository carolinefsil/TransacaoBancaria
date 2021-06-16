package br.com.una.Trabalho.Repository;

import br.com.una.Trabalho.Models.ContaCorrente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ContaCorrenteRepository extends JpaRepository <ContaCorrente, Long> {
}
