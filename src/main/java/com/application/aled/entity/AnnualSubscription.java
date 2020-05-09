package com.application.aled.entity;

import javax.persistence.*;

@Entity
@Table(name = "Annual_Subscription")
public class AnnualSubscription {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column(name = "year")
        private int year;

        @Column(name = "turnover")
        private int turnover;

        public  AnnualSubscription () {

        }

        public  AnnualSubscription (int year, int turnover) {
            super();

            this.year = year;
            this.turnover = turnover;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }



    }
