import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {
    @Id
    private long id;
    private String name;
    private String address;
    private double salary;
    private String dob;

    /*=========================*/
    @OneToOne(mappedBy = "customer")
    private Vehicle vehicle;

    @OneToMany(mappedBy = "customer")
    private List<Orders> orders=
            new ArrayList<>();

    /*=========================*/

    public Customer() {
    }

    public Customer(long id, String name, String address, double salary, String dob) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.dob = dob;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                ", dob='" + dob + '\'' +
                '}';
    }
}
