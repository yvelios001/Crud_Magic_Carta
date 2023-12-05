package com.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.cartas.entidade.Carta;
import com.crud.service.CartaService;

@RestController
@RequestMapping
public class Controller {
	
	@Autowired
	private CartaService cartaService;
	
	@GetMapping
	public List<Carta> getAllCartas(){
		return cartaService.getAllCarta();
		
	}
 	
	@GetMapping
	public Carta createCarta(@RequestBody Carta carta) {
		return cartaService.createCard(carta);
	}
	
	@GetMapping("/{id}")
    public Optional<Carta> getCardById(@PathVariable Long id) {
        return cartaService.getCartaById(id);
    }
	
	@PutMapping("/{id}")
    public Carta updateCard(@PathVariable Long id, @RequestBody Carta updatedCard) {
        return cartaService.updateCard(id, updatedCard);
    }
	
	@DeleteMapping("/{id}")
    public void deleteCard(@PathVariable Long id) {
        cartaService.deleteCard(id);
    }
}
