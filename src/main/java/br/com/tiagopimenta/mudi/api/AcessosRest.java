package br.com.tiagopimenta.mudi.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tiagopimenta.mudi.interceptor.InterceptadorDeAcessos;
import br.com.tiagopimenta.mudi.interceptor.InterceptadorDeAcessos.Acesso;

@RequestMapping("acessos")
@RestController
public class AcessosRest {
	
	@GetMapping
	public List<Acesso> getAcessos() {
		
		return InterceptadorDeAcessos.acessos;
		
	}
	
}
