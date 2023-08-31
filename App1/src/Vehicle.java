import javax.persistence.*;

@Entity(name = "vehicle")
public class Vehicle {
    @Id
    private long vehicleId;
    @Column(name = "brand",length = 45)
    private String brand;

    /*======================*/
    @OneToOne
    @JoinColumn(name = "customer", unique = true)
    private Customer customer;
    /*======================*/

    public Vehicle() {
    }

    public Vehicle(long vehicleId, String brand) {
        this.vehicleId = vehicleId;
        this.brand = brand;
    }

    public long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
