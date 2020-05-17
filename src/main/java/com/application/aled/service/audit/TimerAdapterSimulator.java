package com.application.aled.service.audit;

import java.time.LocalDateTime;
import java.util.List;
import com.application.aled.entity.CurrentArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.application.aled.repository.CurrentAreaRepository;
import com.application.aled.service.CurrentAreaService;

@Component
public class TimerAdapterSimulator {

	@Autowired
	CurrentAreaService currentAreaService; 
	
	@Autowired
	CurrentAreaRepository currentAreaRepo;
	   public void startAdaptingSimulator(){
	        while (true) {
	            try {
	                Thread.sleep(30000);
	                //logger.info("System starting check time for all objects ");

	                //List<Message> messageList = messageService.getMessages();
	                List<CurrentArea> areas = currentAreaService.getAllAreas();
	                for (CurrentArea areasToAdd : areas) {
	                    LocalDateTime DateTime;
	                    
	                    boolean timer = false;
	                  //  timer = checkTime(areasToAdd);
	                    if (!timer) {
	                        CurrentArea currentArea = new CurrentArea();
	                        currentAreaService.addArea(currentArea);
	                       // areasToAdd.setCreatedOn(LocalDateTime);
	                        //objectService.updateObjects(objectToCheck);
	                      //  logger.warning("Object state set to off and failure registered");
	                    }
	                }


	            } catch (InterruptedException e) {
	               // logger.severe("there is an error in thread.sleep during verification " + e.getMessage());
	            }
	        }
	    }
}



