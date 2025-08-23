package com.dvsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dvsuperior.dslist.dto.GameListDTO;
import com.dvsuperior.dslist.entities.GameList;
import com.dvsuperior.dslist.repositories.GameListRepository;

@Service
public class GameListService {

	@Autowired
	private GameListRepository gameListRepository;
	
		@Transactional(readOnly = true)
	public List<GameListDTO> findAll() {
		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(GameListDTO::new).toList();
	}
	
	@Transactional(readOnly = true)
	public GameListDTO findById(Long id) {
		GameList entity = gameListRepository.findById(id).get();
		return new GameListDTO(entity);
	}
}