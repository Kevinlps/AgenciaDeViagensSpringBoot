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
import com.agenciaDeViagens.service.ClienteService;


@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public String listClientes(Model model) {
		List<Cliente> clientes = clienteService.getAllClientes();
		model.addAttribute("clientes", clientes);
		return "cliente/ListarClientes";
	}
	@GetMapping("/cadastro")
	public String showFormForAdd(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
		return "cliente/cadastro";
	}

	// Persistencia da criação
	@PostMapping("/save")
	public String saveCliente(@ModelAttribute("cliente") Cliente cliente, Model model) {
		
		clienteService.saveCliente(cliente);
		return "redirect:/clientes";
	}

	// Formulário de edição
	@GetMapping("/editar/{id}")
	public String showFormForUpdate(@PathVariable Long id, Model model) {
		Cliente cliente = clienteService.getClienteById(id);
		model.addAttribute("cliente", cliente);
		return "cliente/editarCliente";
	}

	// Persistencia da edição
	@PostMapping("/editar/{id}")
	public String updateCliente(@PathVariable Long id, @ModelAttribute("cliente") 
	Cliente cliente) {
		clienteService.updateCliente(id, cliente);
		return "redirect:/clientes";
	}
	
	// Excluir categoria
	@GetMapping("/deletar/{id}")
	public String deleteCliente(@PathVariable Long id) { 
		
		clienteService.deleteCliente(id);
		return "redirect:/clientes";
	}
}
