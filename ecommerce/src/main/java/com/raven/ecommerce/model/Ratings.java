package com.raven.ecommerce.model;

import com.raven.ecommerce.Entity.UserEntity;
import jakarta.persistence.*;

@Entity
public class Ratings {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "rating")
    private double rating;

    public Ratings(Long id, UserEntity user, Product product, double rating) {
        this.user = user;
        this.id = id;
        this.product = product;
        this.rating = rating;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser( UserEntity user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
