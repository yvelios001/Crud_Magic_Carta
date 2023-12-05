package com.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.cartas.entidade.Carta;
import com.crud.repository.CardRepository;

@Service
public class CartaService {
	
	@Autowired
	private CardRepository cardRepository;
	
	public List<Carta> getAllCarta() {
        return cardRepository.findAll();
    }

    public Carta createCard(Carta card) {
        return cardRepository.save(card);
    }

    public Optional<Carta> getCartaById(Long id) {
        return cardRepository.findById(id);
    }

    public Carta updateCard(Long id, Carta updatedCard) {
    	Optional<Carta> optionalCarta = cardRepository.findById(id);
    	
    	if(optionalCarta.isPresent()) {
    		
    		Carta existingCard = optionalCarta.get();
    		 existingCard.setName(updatedCard.getName());
    	     existingCard.setPrice(updatedCard.getPrice());
    	     existingCard.setQuantity(updatedCard.getQuantity());
    	     Carta cartaAtualizada=cardRepository.save(existingCard);
    	     return cartaAtualizada;
    	   	
    	}else {
    	
    	return null;
    	}
    	
    	
    }
    	
  
    public void deleteCard(Long id) {
    	
    	Optional<Carta> optionalCarta=cardRepository.findById(id);
    	
    	if(optionalCarta.isPresent()) {
    		Carta cartaParaExcluir=optionalCarta.get();
    		cardRepository.delete(cartaParaExcluir);
    		}
    	

    }
}
	
	


