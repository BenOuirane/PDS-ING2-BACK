package com.application.aled.service.audit;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.aled.entity.CurrentArea;
import com.application.aled.repository.CurrentAreaRepository;

@Service
public class CurrentAreaAuditServiceImpl implements CurrentAreaAuditService {

	@Autowired
	CurrentAreaRepository currentareaRepository;

	//TODO deactivate this method for the final user
	@Override
	public void emptyTable() {
		currentareaRepository.deleteAll();
		
	}

	@Override
	public List<CurrentArea> getCurrentAreaAuditByUser(String name) {
		List<CurrentArea> currentAreaAudit = new ArrayList<CurrentArea>();
		currentareaRepository.findByArea(name).forEach(currentAreaAudit::add);	
		return currentAreaAudit;
	}

	@Override
	public CurrentArea addCurrentArea(CurrentArea currentAreaAudit) {
		CurrentArea currentAreaSave = currentareaRepository.save(currentAreaAudit);
		return currentAreaSave;
	}
	
}
