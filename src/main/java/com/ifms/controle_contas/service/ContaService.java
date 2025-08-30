package com.ifms.controle_contas.service;

import com.ifms.controle_contas.model.Conta;
import com.ifms.controle_contas.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    //metodo que busca as contas
    public List<Conta> findAll(){
        return contaRepository.findAll();
    }

    //metodo para criar conta ou atualiza
    public Conta save(Conta conta){
        return contaRepository.save(conta);
    }

    //metodo que vai buscar uma conta por ID
    public Optional<Conta> findById(Long id){
        return contaRepository.findById(id);
    }

    //metodo que deleta a conta
    public void deleteById(Long id){
        contaRepository.deleteById(id);
    }

    public void marcarComoPago (Long id){
        Conta conta = contaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID da Conta inválido:" + id));
        conta.setPago(true);
        contaRepository.save(conta);
    }
}
