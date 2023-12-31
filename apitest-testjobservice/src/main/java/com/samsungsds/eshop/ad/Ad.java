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

    //@Column
    //private String paramKey;

    //@Column
    //@ColumnTransformer(
    //        read = "PGP_SYM_DECRYPT(paramValue, 'enc_test()')",
    //        write = "PGP_SYM_ENCRYPT (?, 'enc_test()')"        
    //)
    //private String paramValue;

    @Column
    private String testJobId;

    @Column
    private String resultDetail;

    @Column
    private String runOrder;

    @Column
    private String tenantId;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    //public String getRedirectUrl() {
    //    return this.paramKey;
    //}

    //public void setRedirectUrl(String redirectUrl) {
    //    this.paramKey = redirectUrl;
    //}

    //public String getText() {
    //    return this.paramValue;
    // }

    //public void setText(String text) {
    //    this.paramValue = text;
    // }
    
    public String getTestJobId() {
        return this.testJobId;
    }

    public void setTestJobId(String testJobId) {
        this.testJobId = testJobId;
    }

    public String getResultDetail() {
        return this.resultDetail;
    }

    public void setResultDetail(String resultDetail) {
        this.resultDetail = resultDetail;
    }

    public String getRunOrder() {
        return this.runOrder;
    }

    public void setRunOrder(String runOrder) {
        this.runOrder = runOrder;
    }

    public String getTenantId() {
        return this.tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", runOrder='" + getRunOrder() + "'" +
            ", tenant_id='" + getTenantId() + "'" +
            "}";
    }
}
