package com.ifms.controle_contas.repository;

import com.ifms.controle_contas.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {
    //por enquanto não precisa escrever nada.
}
