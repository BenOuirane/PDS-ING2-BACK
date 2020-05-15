package com.application.aled.entity;

/**
 * Class: Score
 * @author: BEN OUIRANE Hajer
 */
import javax.persistence.*;

@Entity
@Table(name = "score")
public class Score {



    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private  int note_no_athletic;
    @Column
    private  int note_athletic;
    @Column
    private  int note_good_financial_condition;
    @Column
    private  int note_bad_financial_condition;
    @Column
    private  int note_self_ruling;
    @Column
    private  int note_no_self_ruling;
    @Column
    private  int note_good_social_condition;
    @Column
    private  int note_bad_social_condition;
    @Column
    private  int note_sociable;
    @Column
    private  int note_no_sociable;
    @Column
    private  int note_like_cooking;
    @Column
    private  int note_like_rest;
    @Column
    private  int note_like_game;
    @Column
    private  int note_not_sick;
    @Column
    private  int note_hypertension;
    @Column
    private  int note_diabetes;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNote_no_athletic() {
        return note_no_athletic;
    }

    public void setNote_no_athletic(int note_no_athletic) {
        this.note_no_athletic = note_no_athletic;
    }

    public int getNote_athletic() {
        return note_athletic;
    }

    public void setNote_athletic(int note_athletic) {
        this.note_athletic = note_athletic;
    }

    public int getNote_good_financial_condition() {
        return note_good_financial_condition;
    }

    public void setNote_good_financial_condition(int note_good_financial_condition) {
        this.note_good_financial_condition = note_good_financial_condition;
    }

    public int getNote_bad_financial_condition() {
        return note_bad_financial_condition;
    }

    public void setNote_bad_financial_condition(int note_bad_financial_condition) {
        this.note_bad_financial_condition = note_bad_financial_condition;
    }

    public int getNote_self_ruling() {
        return note_self_ruling;
    }

    public void setNote_self_ruling(int note_self_ruling) {
        this.note_self_ruling = note_self_ruling;
    }

    public int getNote_no_self_ruling() {
        return note_no_self_ruling;
    }

    public void setNote_no_self_ruling(int note_no_self_ruling) {
        this.note_no_self_ruling = note_no_self_ruling;
    }

    public int getNote_good_social_condition() {
        return note_good_social_condition;
    }

    public void setNote_good_social_condition(int note_good_social_condition) {
        this.note_good_social_condition = note_good_social_condition;
    }

    public int getNote_bad_social_condition() {
        return note_bad_social_condition;
    }

    public void setNote_bad_social_condition(int note_bad_social_condition) {
        this.note_bad_social_condition = note_bad_social_condition;
    }

    public int getNote_sociable() {
        return note_sociable;
    }

    public void setNote_sociable(int note_sociable) {
        this.note_sociable = note_sociable;
    }

    public int getNote_no_sociable() {
        return note_no_sociable;
    }

    public void setNote_no_sociable(int note_no_sociable) {
        this.note_no_sociable = note_no_sociable;
    }

    public int getNote_like_cooking() {
        return note_like_cooking;
    }

    public void setNote_like_cooking(int note_like_cooking) {
        this.note_like_cooking = note_like_cooking;
    }

    public int getNote_like_rest() {
        return note_like_rest;
    }

    public void setNote_like_rest(int note_like_rest) {
        this.note_like_rest = note_like_rest;
    }

    public int getNote_like_game() {
        return note_like_game;
    }

    public void setNote_like_game(int note_like_game) {
        this.note_like_game = note_like_game;
    }

    public int getNote_not_sick() {
        return note_not_sick;
    }

    public void setNote_not_sick(int note_not_sick) {
        this.note_not_sick = note_not_sick;
    }

    public int getNote_hypertension() {
        return note_hypertension;
    }

    public void setNote_hypertension(int note_hypertension) {
        this.note_hypertension = note_hypertension;
    }

    public int getNote_diabetes() {
        return note_diabetes;
    }

    public void setNote_diabetes(int note_diabetes) {
        this.note_diabetes = note_diabetes;
    }

    public Score() {
    }

    public Score(int note_no_athletic, int note_athletic, int note_good_financial_condition, int note_bad_financial_condition, int note_self_ruling, int note_no_self_ruling, int note_good_social_condition, int note_bad_social_condition, int note_sociable, int note_no_sociable, int note_like_cooking, int note_like_rest, int note_like_game, int note_not_sick, int note_hypertension, int note_diabetes) {
        this.note_no_athletic = note_no_athletic;
        this.note_athletic = note_athletic;
        this.note_good_financial_condition = note_good_financial_condition;
        this.note_bad_financial_condition = note_bad_financial_condition;
        this.note_self_ruling = note_self_ruling;
        this.note_no_self_ruling = note_no_self_ruling;
        this.note_good_social_condition = note_good_social_condition;
        this.note_bad_social_condition = note_bad_social_condition;
        this.note_sociable = note_sociable;
        this.note_no_sociable = note_no_sociable;
        this.note_like_cooking = note_like_cooking;
        this.note_like_rest = note_like_rest;
        this.note_like_game = note_like_game;
        this.note_not_sick = note_not_sick;
        this.note_hypertension = note_hypertension;
        this.note_diabetes = note_diabetes;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", note_no_athletic=" + note_no_athletic +
                ", note_athletic=" + note_athletic +
                ", note_good_financial_condition=" + note_good_financial_condition +
                ", note_bad_financial_condition=" + note_bad_financial_condition +
                ", note_self_ruling=" + note_self_ruling +
                ", note_no_self_ruling=" + note_no_self_ruling +
                ", note_good_social_condition=" + note_good_social_condition +
                ", note_bad_social_condition=" + note_bad_social_condition +
                ", note_sociable=" + note_sociable +
                ", note_no_sociable=" + note_no_sociable +
                ", note_like_cooking=" + note_like_cooking +
                ", note_like_rest=" + note_like_rest +
                ", note_like_game=" + note_like_game +
                ", note_not_sick=" + note_not_sick +
                ", note_hypertension=" + note_hypertension +
                ", note_diabetes=" + note_diabetes +
                '}';
    }
}
