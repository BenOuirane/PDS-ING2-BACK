package com.application.aled.messages.history;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ObjectsHistoryInitializer {

        private final ObjectsHistoryInsertion bean;

        public ObjectsHistoryInitializer(ObjectsHistoryInsertion bean) {
            this.bean = bean;
        }

        @PostConstruct
        public void initialize() {
            bean.createObjectHistories();
        }
}
