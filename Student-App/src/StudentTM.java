import javafx.scene.control.Button;

public class StudentTM {
    private long id;
    private String name;
    private String address;
    private Button deleteButton;
    private Button updateButton;

    public StudentTM() {
    }

    public StudentTM(long id, String name, String address, Button deleteButton, Button updateButton) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.deleteButton = deleteButton;
        this.updateButton = updateButton;
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

    public Button getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(Button deleteButton) {
        this.deleteButton = deleteButton;
    }

    public Button getUpdateButton() {
        return updateButton;
    }

    public void setUpdateButton(Button updateButton) {
        this.updateButton = updateButton;
    }
}
