package cz.uhk.ppro.gof.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cz.uhk.ppro.gof.model.Player;

@Repository
public class PlayerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public Player findByUsername(String username) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(Player.class);
		c.add(Restrictions.eq("username", username));
		return (Player)c.uniqueResult();
	}
	
	
	public List<Player> getAllPlayers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Player> playerList = session.createQuery("from Player order by score Desc").list();
		return playerList;
	}

	public Player getPlayer(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Player player = (Player) session.get(Player.class, new Integer(id));
		return player;
	}

	public Player addPlayer(Player player) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(player);
		return player;
	}

	public void updatePlayer(Player player) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(player);
	}

	public void deletePlayer(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Player p = (Player) session.load(Player.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
	}	
}
