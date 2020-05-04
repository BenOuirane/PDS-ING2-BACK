package com.application.aled.entity;

import javax.persistence.*;

    @Entity
    @Table(name = "Mensual_Subscription")
    public class MensualSubscription {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column(name = "year")
        private int year;
        @Column(name = "month")
        private String month;
        @Column(name = "turnover")
        private int turnover;

        public MensualSubscription() {

        }

        public MensualSubscription(int year, String month, int turnover) {
            super();

            this.year = year;
            this.month = month;
            this.turnover = turnover;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }


        @Override
        public String toString() {
            return "Mensual_Subscription [id=" + id + ", month=" + month + ", year=" + year + ", turnover=" + turnover
                    + "]";
        }

    }
