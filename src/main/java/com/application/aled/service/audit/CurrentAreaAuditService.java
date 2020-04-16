package com.application.aled.service.audit;

import java.util.List;

import com.application.aled.entity.CurrentArea;

public interface CurrentAreaAuditService {
	
	public CurrentArea addCurrentArea(CurrentArea currentArea);
	public void emptyTable();
	
	public List<CurrentArea> getCurrentAreaAuditByUser(String name);

}
