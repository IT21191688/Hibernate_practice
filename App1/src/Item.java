import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long code;
    private int qty;

    @ManyToMany(mappedBy = "items")
    private Set<Orders> orders= new HashSet<>();


    public Item(long code, int qty) {
        this.code = code;
        this.qty = qty;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }


}
