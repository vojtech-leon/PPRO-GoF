package cz.uhk.ppro.gof.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import cz.uhk.ppro.gof.dao.PlayerDAO;
import cz.uhk.ppro.gof.model.Player;


public class PlayerLoginService implements UserDetailsService{
	@Autowired
	 private PlayerDAO playerDao;
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Player p = playerDao.findByUsername(username);
		if(p == null)  {
			throw new UsernameNotFoundException("Uživatel se nenalezl");
		}
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(p.getRole().getName());

		return new org.springframework.security.core.userdetails.User(p.getUsername(), p.getPassword(), Collections.singleton(grantedAuthority));
    }
}
