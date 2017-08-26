package cz.uhk.ppro.gof.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.uhk.ppro.gof.dao.FractionDAO;
import cz.uhk.ppro.gof.model.Fraction;

@Service("fractionService")
public class FractionService {
	@Autowired
	FractionDAO fractionDao;
	
	@Transactional
	public List<Fraction> getAllFractions() {
		return fractionDao.getAllFractions();
	}

	@Transactional
	public Fraction getFraction(int id) {
		return fractionDao.getFraction(id);
	}

	@Transactional
	public void addFraction(Fraction fraction) {
		fractionDao.addFraction(fraction);
	}

	@Transactional
	public void updateFraction(Fraction fraction) {
		fractionDao.updateFraction(fraction);

	}

	@Transactional
	public void deleteFraction(int id) {
		fractionDao.deleteFraction(id);
	}
}
