package com.agenciaDeViagens.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.agenciaDeViagens.models.Destino;
import com.agenciaDeViagens.models.PacotePromocional;
import com.agenciaDeViagens.service.DestinoService;
import com.agenciaDeViagens.service.PacotePromocionalService;

@Controller
@RequestMapping("/pacotes")
public class PacotePromocionalController {

    private final PacotePromocionalService pacotePromocionalService;
    private final DestinoService destinoService;

    @Autowired
    public PacotePromocionalController(PacotePromocionalService pacotePromocionalService, DestinoService destinoService) {
        this.pacotePromocionalService = pacotePromocionalService;
        this.destinoService = destinoService;
    }

    @GetMapping
    public String listarPacotes(Model model) {
        List<PacotePromocional> pacotes = pacotePromocionalService.getAllPacotePromocional();
        model.addAttribute("pacotes", pacotes);
        return "pacotePromocional/listar_pacotes"; // Nome do arquivo HTML/Thymeleaf para exibir a lista de pacotes
    }

    @GetMapping("/cadastro")
    public String exibirFormularioCadastro(Model model) {
        List<Destino> destinos = destinoService.getAllDestino();
        model.addAttribute("destinos", destinos);
        model.addAttribute("pacote", new PacotePromocional());
        return "pacotePromocional/cadastro"; // Nome do arquivo HTML/Thymeleaf para o formulário de cadastro
    }

    @PostMapping("/salvar")
    public String salvarPacote(@ModelAttribute("pacote") PacotePromocional pacote) {
        pacotePromocionalService.savePacotePromocional(pacote);
        return "redirect:/pacotes"; // Redireciona para a lista de pacotes após salvar
    }

    @GetMapping("/editar/{id}")
    public String exibirFormularioEdicao(@PathVariable Long id, Model model) {
        PacotePromocional pacote = pacotePromocionalService.getPacotePromocionalById(id);
        List<Destino> destinos = destinoService.getAllDestino();
        model.addAttribute("destinos", destinos);
        model.addAttribute("pacote", pacote);
        return "pacotePromocional/editarPacote"; // Nome do arquivo HTML/Thymeleaf para o formulário de edição
    }

    @PostMapping("/atualizar/{id}")
    public String atualizarPacote(@PathVariable Long id, @ModelAttribute("pacote") PacotePromocional pacote) {
        pacote.setId(id);
        pacotePromocionalService.updatePacotePromocional(id, pacote);
        return "redirect:/pacotes"; // Redireciona para a lista de pacotes após atualizar
    }

    @GetMapping("/excluir/{id}")
    public String excluirPacote(@PathVariable Long id) {
        pacotePromocionalService.deletePacotePromocional(id);
        return "redirect:/pacotes"; // Redireciona para a lista de pacotes após excluir
    }
}