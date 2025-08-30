package com.ifms.controle_contas.controller;

import com.ifms.controle_contas.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.ifms.controle_contas.model.Conta;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContaController {

    @Autowired
    private ContaService contaService;

    @GetMapping("/")
    public String listarContas(Model model){
        model.addAttribute("contas", contaService.findAll());
        return "lista-contas";
    }

    @GetMapping("/novo")
    public String mostrarFormularioDeNovaConta(Model model){
        model.addAttribute("conta", new Conta());
        return "formulario-conta";
    }

    @PostMapping("/salvar")
    public String salvarConta(@ModelAttribute("conta") Conta conta){
        contaService.save(conta);
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEdicao(@PathVariable Long id, Model model) {
        Conta conta = contaService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID da Conta inválido:" + id));
        model.addAttribute("conta", conta);
        return "formulario-conta";
    }

    @GetMapping("/excluir/{id}")
    public String excluirConta(@PathVariable Long id) {
        contaService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/marcar-pago/{id}")
    public String marcarComoPago(@PathVariable Long id) {
        contaService.marcarComoPago(id);
        return "redirect:/";
    }
}
