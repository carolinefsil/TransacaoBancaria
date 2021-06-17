package br.com.una.Trabalho.Repository;

import br.com.una.Trabalho.Models.ContaCorrente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Transactional
public interface ContaCorrenteRepository extends JpaRepository <ContaCorrente, Long> {

    @Modifying
    @Query("update ContaCorrente c set c.saldo = c.saldo + ?1 where c.id = ?2")
    void setFixedSaldoFor(double  quantidade, Long id);

    @Modifying
    @Query("update ContaCorrente c set c.saldo = c.saldo - ?1 where c.id = ?2")
    void setFixedSaldo(double  quant, Long id);
}
