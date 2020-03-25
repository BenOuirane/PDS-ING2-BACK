package com.application.aled.service.tracking.audit;

import java.util.List;

import com.application.aled.entity.CurrentArea;

public interface CurrentAreaAuditService {
	
	public List<CurrentArea> getCurrentAreaAuditByUser(String name);

}
