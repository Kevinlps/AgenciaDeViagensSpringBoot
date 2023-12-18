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

import com.agenciaDeViagens.models.Cliente;
import com.agenciaDeViagens.models.Compra;
import com.agenciaDeViagens.models.PacotePromocional;
import com.agenciaDeViagens.service.ClienteService;
import com.agenciaDeViagens.service.CompraService;
import com.agenciaDeViagens.service.PacotePromocionalService;

@Controller
@RequestMapping("/compras")
public class CompraController {

    private final CompraService compraService;
    private final PacotePromocionalService pacotePromocionalService;
    private final ClienteService clienteService;

    @Autowired
    public CompraController(CompraService compraService, PacotePromocionalService pacotePromocionalService, ClienteService clienteService) {
        this.compraService = compraService;
        this.pacotePromocionalService = pacotePromocionalService;
        this.clienteService = clienteService;
    }

    @GetMapping
    public String listarCompras(Model model) {
        List<Compra> compras = compraService.getAllCompra();
        model.addAttribute("compras", compras);
        return "compra/listar_compras"; // Nome do arquivo HTML/Thymeleaf para exibir a lista de compras
    }

    @GetMapping("/cadastro")
    public String exibirFormularioCadastro(Model model) {
        List<PacotePromocional> pacotes = pacotePromocionalService.getAllPacotePromocional();
        List<Cliente> clientes = clienteService.getAllClientes();
        model.addAttribute("pacotes", pacotes);
        model.addAttribute("clientes", clientes);
        model.addAttribute("compra", new Compra());
        return "compra/cadastro"; // Nome do arquivo HTML/Thymeleaf para o formulário de cadastro
    }

    @PostMapping("/salvar")
    public String salvarCompra(@ModelAttribute("compra") Compra compra) {
        compraService.saveCompra(compra);
        return "redirect:/compras"; // Redireciona para a lista de compras após salvar
    }

    @GetMapping("/editar/{id}")
    public String exibirFormularioEdicao(@PathVariable Long id, Model model) {
        Compra compra = compraService.getCompraById(id);
        List<PacotePromocional> pacotes = pacotePromocionalService.getAllPacotePromocional();
        List<Cliente> clientes = clienteService.getAllClientes();
        model.addAttribute("pacotes", pacotes);
        model.addAttribute("clientes", clientes);
        model.addAttribute("compra", compra);
        return "compra/editarCompra"; // Nome do arquivo HTML/Thymeleaf para o formulário de edição
    }

    @PostMapping("/atualizar/{id}")
    public String atualizarCompra(@PathVariable Long id, @ModelAttribute("compra") Compra compra) {
        compra.setId(id);
        compraService.updateCompra(id, compra);
        return "redirect:/compras"; // Redireciona para a lista de compras após atualizar
    }

    @GetMapping("/excluir/{id}")
    public String excluirCompra(@PathVariable Long id) {
        compraService.deleteCompra(id);
        return "redirect:/compras"; // Redireciona para a lista de compras após excluir
    }
}
