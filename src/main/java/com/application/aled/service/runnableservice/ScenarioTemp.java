package com.application.aled.service.runnableservice;

import com.application.aled.entity.Oven;
import com.application.aled.repository.OvenRepository;

import java.util.concurrent.TimeUnit;

public class ScenarioTemp implements Runnable {


    private Oven oven;
    private OvenRepository ovenRepository;
    private String param;
    private Thread thread;
    private boolean exit;

    public ScenarioTemp (Oven oven, String param, OvenRepository ovenRepository){
        this.oven = oven;
        this.ovenRepository = ovenRepository;
        this.param = param;
        thread = new Thread(this, "ChangeTemp");
        exit = false;
        thread.start();

    }

    @Override
    public void run() {
        Thread.currentThread().setName("ChangeTemp");
        if (param.equals("ON")) {
            if (oven.getEffectiveTemp() < oven.getProgramTemp()) {
                while (oven.getEffectiveTemp() < oven.getProgramTemp() && !exit) {
                    oven.setEffectiveTemp(oven.getEffectiveTemp() + 1);
                    ovenRepository.save(oven);
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        return;
                    }
                }
            } else if (oven.getEffectiveTemp() > oven.getProgramTemp()) {
                while (oven.getEffectiveTemp() > oven.getProgramTemp() && !exit) {
                    oven.setEffectiveTemp((oven.getEffectiveTemp() - 1));
                    ovenRepository.save(oven);
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        return;
                    }
                }
            }
        } else if (param.equals("OFF")) {
            while (oven.getEffectiveTemp() != 0 && !exit) {
                oven.setEffectiveTemp((oven.getEffectiveTemp() - 1));
                ovenRepository.save(oven);
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }

        System.out.println("FIN SCENARIO TEMP");
    }

    public void stop(){
        exit = true;
    }
}
