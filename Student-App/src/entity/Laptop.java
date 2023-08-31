package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Laptop {
    @Id
    private long code;
    private String brand;

    @OneToOne
    @JoinColumn(unique = true)
    private Student student;

    public Laptop() {
    }

    public Laptop(long code, String brand) {
        this.code = code;
        this.brand = brand;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
