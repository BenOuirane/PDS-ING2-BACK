
/**
 * Class: Candidate
 * @author: BEN OUIRANE Hajer
 * @version: 1.0
 */
package com.application.aled.entity;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "candidate")
public class Candidate {


    /**
     * declaration of class attributes
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long  id;
    @Column(name = "lastname")
    private String  lastname;
    @Column(name = "firstname")
    private String  firstname;
    @Column(name = "e_mail")
    private String  e_mail;
    @Column(name = "birth_date")
    private Date birth_date;
    @Column(name = "sexe")
    private String sexe;
    @Column(name = "profil")
    @Enumerated(EnumType.STRING)
    private TypeProfil profils;


    /**
     *  Method that recovers the candidate's id
     * @return id
     */
    public Long getId() {
        return id;
    }


    /**
     * M Method that initializes the candidate's id
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *  Method that recovers the candidate's lastname
     * @return lastename
     */
    public String getLastname() {
        return lastname;
    }


    /**
     * M Method that initializes the candidate's lastname
     * @param lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     *  Method that recovers the candidate's firstname
     * @return firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * M Method that initializes the candidate's fistname
     * @param firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     *  Method that recovers the candidate's e_mail
     * @return e_mail
     */
    public String getE_mail() {
        return e_mail;
    }

    /**
     * M Method that initializes the candidate's e_mail
     * @param e_mail
     */
    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    /**
     *  Method that recovers the candidate's birth_date
     * @return birth_date
     */

    public Date getBirth_date() {
        return birth_date;
    }

    /**
     * M Method that initializes the candidate's birth date
     * @param birth_date
     */
    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    /**
     *  Method that recovers the candidate's sexe
     * @return sexe
     */
    public String getSexe() {
        return sexe;
    }

    /**
     * M Method that initializes the candidate's sexe
     * @param sexe
     */
    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    /**
     *  Method that recovers the candidate's profil
     * @return profil
     */
    public TypeProfil getProfil() {
        return profils;
    }

    /**
     * M Method that initializes the candidate's profil
     * @param profil
     */
    public void setProfil(TypeProfil profil) {
        this.profils = profil;
    }

    /**
     * Constructors who take parameters, which is used to initialize attributes.
     * @param lastname
     * @param firstname
     * @param e_mail
     * @param birth_date
     * @param sexe
     * @param profil
     */


    public Candidate(String lastname, String firstname, String e_mail, Date birth_date, String sexe, TypeProfil profil) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.e_mail = e_mail;
        this.birth_date = birth_date;
        this.sexe = sexe;
        this.profils = profil;
    }

    /**
     *Constructors with no fields who can create an instance of a class
     * without needing to specify anything.
     */
    public Candidate() {
    }

    /**
     * The toString () is used to create a String representation of an object using the contents of the object.
      * @return
     */

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", e_mail='" + e_mail + '\'' +
                ", birth_date=" + birth_date +
                ", sexe='" + sexe + '\'' +
                ", profil=" + profils +
                '}';
    }
}
