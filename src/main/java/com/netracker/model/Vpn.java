package com.netracker.model;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;


@Entity
@Table(name = "vpn", schema = "public")
public class Vpn {

    private UUID vpnServiceId;
    private String title;
    private Timestamp expirationDate;
    private String password;

    @Id
    @Column(name = "vpn_id", nullable = false)
    @GeneratedValue
    public UUID getVpnServiceId() {
        return vpnServiceId;
    }

    public void setVpnServiceId(UUID vpnServiceId) {
        this.vpnServiceId = vpnServiceId;
    }

    @Basic
    @Column(name = "title", nullable = false, length = 30)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "expiration_date", nullable = false)
    public Timestamp getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Timestamp expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 20)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

