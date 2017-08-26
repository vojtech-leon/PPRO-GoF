package cz.uhk.ppro.gof.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.uhk.ppro.gof.dao.PlayerDAO;
import cz.uhk.ppro.gof.model.Player;

@Service("playerService")
public class PlayerService {
	@Autowired
	private PlayerDAO playerDao;

	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Transactional
	public List<Player> getAllPlayers() {
		return playerDao.getAllPlayers();
	}

	@Transactional
	public Player getPlayer(int id) {
		return playerDao.getPlayer(id);
	}

	@Transactional
	public void addPlayer(Player player) {
		player.setPassword(bCryptPasswordEncoder.encode(player.getPassword()));
		playerDao.addPlayer(player);
	}

	@Transactional
	public void updatePlayer(Player player) {
		player.setPassword(bCryptPasswordEncoder.encode(player.getPassword()));
		playerDao.updatePlayer(player);

	}

	@Transactional
	public void deletePlayer(int id) {
		playerDao.deletePlayer(id);
	}
}
