
/**
 * Class: Candidate
 * @author: BEN OUIRANE Hajer
 * @version: 1.0
 */
package com.application.aled.entity;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;



@Entity
@Table(name = "candidate")
@IdClass(Candidate.class)
public class Candidate  implements Serializable {


    /**
     * declaration of class attributes
     */


    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    @Id
    private Long  id;
    @Column(name = "lastname")
    @NotBlank(message = "please enter your lastname")
    @Size(min=2, message = "your lastname must be wrong enter atleast 2 characters")
    private String  lastname;
    @Column(name = "firstname")
    @NotBlank(message = "please enter your firstname")
    @Size(min=2, message = "your lastname must be wrong enter atleast 2 characters")
    private String  firstname;
    @Column(name = "e_mail")
    @NotBlank(message = "please enter an email")
    @Email(message = "please enter a valid Email")
    @Id
    private String  mail;
    @Column(name = "birth_date")
    @NotNull(message = "please enter your birth_date")
    private Date birth_date;
    @Column(name = "sexe")
    @NotBlank(message = "please choose your gender")
    private String sexe;



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
    public String getMail() {
        return mail;
    }

    /**
     * M Method that initializes the candidate's e_mail
     * @param mail
     */
    public void setMail(String mail) {
        this.mail = mail;
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
     * Constructors who take parameters, which is used to initialize attributes.
     * @param lastname
     * @param firstname
     * @param mail
     * @param birth_date
     * @param sexe

     */


    public Candidate(String lastname, String firstname, String mail, Date birth_date, String sexe) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.mail = mail;
        this.birth_date = birth_date;
        this.sexe = sexe;

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
                ", mail='" + mail + '\'' +
                ", birth_date=" + birth_date +
                ", sexe='" + sexe + '\'' +

                '}';
    }
}
