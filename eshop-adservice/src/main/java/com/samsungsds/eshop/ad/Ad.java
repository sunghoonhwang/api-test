package com.samsungsds.eshop.ad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.ColumnTransformer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Entity
public class Ad {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String redirectUrl;

    @Column(nullable = false)
    @ColumnTransformer(
            read = "PGP_SYM_DECRYPT(text, 'enc_test()')",
            write = "PGP_SYM_ENCRYPT (?, 'enc_test()')"        
    )
    private String text;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRedirectUrl() {
        return this.redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", category='" + getCategory() + "'" +
            ", redirectUrl='" + getRedirectUrl() + "'" +
            ", text='" + getText() + "'" +
            "}";
    }
}
