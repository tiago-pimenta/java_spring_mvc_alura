package br.com.tiagopimenta.mudi.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tiagopimenta.mudi.dto.RequisicaoNovaOferta;
import br.com.tiagopimenta.mudi.model.Oferta;
import br.com.tiagopimenta.mudi.model.Pedido;
import br.com.tiagopimenta.mudi.repository.PedidoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/ofertas")
public class OfertasRest {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@PostMapping
	public Oferta criaOferta(@Valid @RequestBody RequisicaoNovaOferta requisicao) {
		Optional<Pedido> pedidoBuscado = pedidoRepository.findById(requisicao.getPedidoId());
		if(!pedidoBuscado.isPresent()) {
			return null;
		}
		
		Pedido pedido = pedidoBuscado.get();
		
		Oferta nova = requisicao.toOferta();
		nova.setPedido(pedido);
		pedido.getOfertas().add(nova);
		pedidoRepository.save(pedido);
		
		return nova;
	}
}
