package cz.uhk.ppro.gof.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.uhk.ppro.gof.dao.FlagDAO;
import cz.uhk.ppro.gof.model.Flag;

@Service("flagService")
public class FlagService {
	@Autowired
	FlagDAO flagDao;
	
	@Transactional
	public List<Flag> getAllFlags() {
		return flagDao.getAllFlags();
	}

	@Transactional
	public Flag getFlag(int id) {
		return flagDao.getFlag(id);
	}

	@Transactional
	public void addFlag(Flag flag) {
		flagDao.addFlag(flag);
	}

	@Transactional
	public void updateFlag(Flag flag) {
		flagDao.updateFlag(flag);

	}

	@Transactional
	public void deleteFlag(int id) {
		flagDao.deleteFlag(id);
	}
}
