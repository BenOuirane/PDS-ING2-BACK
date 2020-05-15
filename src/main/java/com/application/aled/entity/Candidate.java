
package com.application.aled.entity;

/**
 * Class: Candidate
 * @author: BEN OUIRANE Hajer
 */
import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.ArrayList;


@Entity
@Table(name = "candidate")
@IdClass(Candidate.class)
public class Candidate  implements Serializable {



    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    @Id
    private Long  id;
    @Column(name = "lastname")
    @NotBlank(message = "Entrez votre nom s'il vous plait")
    @Size(min=2, message = "votre nom de famille  incorrect entrez au moins 2 caractères")
    private String  lastname;
    @Column(name = "firstname")
    @NotBlank(message = "Entrez votre prénom s'il vous plait")
    @Size(min=2, message = "votre prénom  incorrect entrez au moins 2 caractères")
    private String  firstname;
    @Column(name = "e_mail")
    @NotBlank(message = "Veuillez saisir un e-mail")
    @Email(message = "Veuillez saisir un e-mail valide")
    @Id
    private String  mail;
    @Column(name = "age")
    @NotNull(message = "Veuillez entrer votre âge")
    @Pattern(regexp = "[\\d]{2}")
    private String  age;
    @Column(name = "genre")
    @NotBlank(message = "Veuillez choisir votre genre")
    private String genre;
    /* Profil */

    @Column(name = "autonomy")
    @NotBlank(message = "Veuillez sélectionner votre réponse")
    private String autonomy;

    @Column(name = "sport")
    @NotBlank(message = "Veuillez sélectionner votre réponse")
    private String sport;

    @Column(name = "social_activity")
    @NotBlank(message = "Veuillez sélectionner votre réponse")
    private String social_activity;

    @Column(name = "habit")
    @NotBlank(message = "Veuillez sélectionner votre réponse")
    private String habit;

    @Column(name = "finance")
    @NotBlank(message = "Veuillez sélectionner votre réponse")
    private String finance;
    /* tree */

    @Column(name = "etat_sociale")
    @NotBlank(message = "Veuillez sélectionner votre réponse")
    private String etat_sociale;



    public double getScore() {
        return score;
    }

    public double setScore(double score) {
        this.score = score;
        return score;
    }

    @Column(name = "type_de_maladie")
    @NotBlank(message = "Veuillez sélectionner votre réponse")
    private String type_de_maladie;

    @Column(name = "score")
    private double score;

    /* end tree */

    /* End Profil */

    public String getEtat_sociale() {
        return etat_sociale;
    }

    public void setEtat_sociale(String etat_sociale) {
        this.etat_sociale = etat_sociale;
    }

    public String getType_de_maladie() {
        return type_de_maladie;
    }

    public void setType_de_maladie(String type_de_maladie) {
        this.type_de_maladie = type_de_maladie;
    }

    public String getAutonomy() {
        return autonomy;
    }

    public void setAutonomy(String autonomy) {
        this.autonomy = autonomy;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getSocial_activity() {
        return social_activity;
    }

    public void setSocial_activity(String social_activity) {
        this.social_activity = social_activity;
    }

    public String getHabit() {
        return habit;
    }

    public void setHabit(String habit) {
        this.habit = habit;
    }

    public String getFinance() {
        return finance;
    }

    public void setFinance(String finance) {
        this.finance = finance;
    }

    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }


    public String getLastname() {
        return lastname;
    }



    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    public String getFirstname() {
        return firstname;
    }


    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }


    public String getMail() {
        return mail;
    }


    public void setMail(String mail) {
        this.mail = mail;
    }


    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Candidate() {
    }


    public Candidate(@NotBlank(message = "Please enter your lastname")
                     @Size(min = 2, message = "your lastname must be wrong enter atleast 2 characters") String lastname,double score )
        {
        this.lastname = lastname;
        this.score = score;
    }



    public Candidate(@NotBlank(message = "Please enter your lastname") @Size(min = 2, message = "your lastname must be wrong enter atleast 2 characters") String lastname, @NotBlank(message = "Please enter your firstname") @Size(min = 2, message = "your lastname must be wrong enter atleast 2 characters") String firstname, @NotBlank(message = "Please enter an email") @Email(message = "Please enter a valid Email") String mail, @NotNull(message = "Please enter your age") @Pattern(regexp = "[\\d]{2}") String age, @NotBlank(message = "Please choose your gender") String genre, @NotBlank(message = "Please select your answer") String autonomy, @NotBlank(message = "Please select your answer") String sport, @NotBlank(message = "Please select your answer") String social_activity, @NotBlank(message = "Please select your answer") String habit, @NotBlank(message = "Please select your answer") String finance, @NotBlank(message = "Please choose your answer") String etat_sociale, @NotBlank(message = "Please choose your answer") String type_de_maladie, double score) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.mail = mail;
        this.age = age;
        this.genre = genre;
        this.autonomy = autonomy;
        this.sport = sport;
        this.social_activity = social_activity;
        this.habit = habit;
        this.finance = finance;
        this.etat_sociale = etat_sociale;
        this.type_de_maladie = type_de_maladie;
        this.score = score;
    }


    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", mail='" + mail + '\'' +
                ", age='" + age + '\'' +
                ", genre='" + genre + '\'' +
                ", autonomy='" + autonomy + '\'' +
                ", sport='" + sport + '\'' +
                ", social_activity='" + social_activity + '\'' +
                ", habit='" + habit + '\'' +
                ", finance='" + finance + '\'' +
                ", etat_sociale='" + etat_sociale + '\'' +
                ", type_de_maladie='" + type_de_maladie + '\'' +
                ", score=" + score +
                '}';
    }
}
