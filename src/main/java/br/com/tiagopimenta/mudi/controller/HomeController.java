package br.com.tiagopimenta.mudi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.tiagopimenta.mudi.model.Pedido;
import br.com.tiagopimenta.mudi.model.StatusPedido;
import br.com.tiagopimenta.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private PedidoRepository repository;
	
	@GetMapping
	public String home(Model model) {
		
//		Pedido pedido = new Pedido();
//		
//		pedido.setNomeProduto("Xiaomi Redmi Note 8");
//		pedido.setUrlImagem("https://images-na.ssl-images-amazon.com/images/I/81UgYuadkpL._AC_SL1500_.jpg");
//		pedido.setUrlProduto("https://www.amazon.com.br/Smartphone-Xiaomi-Redmi-Note-64GB/dp/B07Y8YWTFL/ref=sr_1_6?__mk_pt_BR=%C3%85M%C3%85%C5%BD%C3%95%C3%91&dchild=1&keywords=Xiaomi+Redmi+Note+8&qid=1600346040&sr=8-6");
//		pedido.setDescricao("uma descrição qualquer para esse pedido");
//		
//		List<Pedido> pedidos = Arrays.asList(pedido);
		
		List<Pedido> pedidos = repository.findAll();
		model.addAttribute("pedidos", pedidos);
		
		return "home";
		
	}
	
//	@GetMapping("/aguardando")
//	public String aguardando(Model model) {
//		
//		List<Pedido> pedidos = repository.findByStatus(StatusPedido.AGUARDANDO);
//		model.addAttribute("pedidos", pedidos);
//		
//		return "home";
//		
//	}
	
	@GetMapping("/{status}")
	public String porStatus(@PathVariable("status") String status, Model model) {
		
		List<Pedido> pedidos = repository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
		model.addAttribute("pedidos", pedidos);
		model.addAttribute("status", status);
		
		return "home";
		
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/home";
	}
	
}
