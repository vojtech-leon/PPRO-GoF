package cz.uhk.ppro.gof.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.uhk.ppro.gof.dao.RoleDAO;
import cz.uhk.ppro.gof.model.Role;

@Service("roleService")
public class RoleService {
	@Autowired
	RoleDAO roleDao;
	
	@Transactional
	public List<Role> getAllRoles() {
		return roleDao.getAllRoles();
	}

	@Transactional
	public Role getRole(int id) {
		return roleDao.getRole(id);
	}

	@Transactional
	public void addRole(Role role) {
		roleDao.addRole(role);
	}

	@Transactional
	public void updateRole(Role role) {
		roleDao.updateRole(role);

	}

	@Transactional
	public void deleteRole(int id) {
		roleDao.deleteRole(id);
	}
}
