package com.raven.ecommerce.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.raven.ecommerce.model.Address;
import com.raven.ecommerce.model.PaymentInformation;
import com.raven.ecommerce.model.Ratings;
import com.raven.ecommerce.model.Review;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users", schema = "user_details")
public class UserEntity  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String email;

    private String role;

    private String mobile;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List <Address> address = new ArrayList <>( );
    @Embedded
    @ElementCollection
    @CollectionTable(name = "payment_information", joinColumns = @JoinColumn(name = "user_id"))
    private List <PaymentInformation> paymentInformation = new ArrayList <>( );

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List <Ratings> ratings = new ArrayList <>( );

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List <Review> reviews = new ArrayList <>( );

    private LocalDateTime createdAt;


    public List <Address> getAddress() {
        return address;
    }

    public void setAddress( List <Address> address ) {
        this.address = address;
    }

    public List <PaymentInformation> getPaymentInformation() {
        return paymentInformation;
    }

    public void setPaymentInformation( List <PaymentInformation> paymentInformation ) {
        this.paymentInformation = paymentInformation;
    }

    public List <Ratings> getRatings() {
        return ratings;
    }

    public void setRatings( List <Ratings> ratings ) {
        this.ratings = ratings;
    }

    public List <Review> getReviews() {
        return reviews;
    }

    public void setReviews( List <Review> reviews ) {
        this.reviews = reviews;
    }

    public void setFirstName( String firstName ) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername( String username ) {
        this.username = username;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt( LocalDateTime createdAt ) {
        this.createdAt = createdAt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName( String lastName ) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole( String role ) {
        this.role = role;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile( String mobile ) {
        this.mobile = mobile;
    }
}