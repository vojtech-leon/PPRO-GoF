package cz.uhk.ppro.gof.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.uhk.ppro.gof.dao.ScanDAO;
import cz.uhk.ppro.gof.model.Scan;

@Service("scanService")
public class ScanService {
	@Autowired
	ScanDAO scanDao;
	
	@Transactional
	public List<Scan> getAllScans() {
		return scanDao.getAllScans();
	}

	@Transactional
	public Scan getScan(int id) {
		return scanDao.getScan(id);
	}

	@Transactional
	public void addScan(Scan scan) {
		scanDao.addScan(scan);
	}

	@Transactional
	public void updateScan(Scan scan) {
		scanDao.updateScan(scan);

	}

	@Transactional
	public void deleteScan(int id) {
		scanDao.deleteScan(id);
	}
}
