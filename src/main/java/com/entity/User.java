package com.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * Created by pc9 on 21.03.16.
 */
@Entity
@Table(name = "users")
public class User implements Serializable {
    public User() {
    }

    public User(String password, String firstName,
                String lastName, String email,
                Boolean superuser, Integer status) {
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.superuser = superuser;
        this.status = status;
        this.setRegistrationDate(Calendar.getInstance().getTime());
    }

    private Integer userId;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private Boolean superuser;
    private Integer status;
    private String phoneNumber;
    private Date registrationDate;
    private Date lastVisit;

    //private Set<UserBookJoin> userBookJoins = new HashSet<UserBookJoin>();
    private Set<JoinUserBook> joinUserBooks = new HashSet<JoinUserBook>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", unique = true, nullable = false)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "second_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "email", nullable = false, unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "superuser")
    public Boolean getSuperuser() {
        return superuser;
    }

    public void setSuperuser(Boolean superuser) {
        this.superuser = superuser;
    }

    @Column(name = "status", nullable = false)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Column(name = "phone_num")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Column(name = "registeration_date", nullable = false)
    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Column(name = "last_visit")
    public Date getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(Date lastVisit) {
        this.lastVisit = lastVisit;
    }

    public JoinUserBook getJoin(Integer bookId) {
        Iterator<JoinUserBook> iterator = this.getJoinUserBooks().iterator();

        while (iterator.hasNext()) {
            JoinUserBook join = iterator.next();

            if (join.getBook().getBookId().equals(bookId)) {
                return join;
            }

        }
        return null;
    }


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.REMOVE)
    public Set<JoinUserBook> getJoinUserBooks() {
        return joinUserBooks;
    }

    public void setJoinUserBooks(Set<JoinUserBook> joinUserBooks) {
        this.joinUserBooks = joinUserBooks;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", superuser=" + superuser +
                ", status=" + status +
                '}';
    }
}
