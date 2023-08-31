import entity.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class MainFormController {
    public TextField txtId;
    public TextField txtName;
    public TextField txtAddress;
    public Button btn;
    public TableView<StudentTM> tblStudent;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colDel;
    public TableColumn colUpdate;

    public void initialize() {

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colDel.setCellValueFactory(new PropertyValueFactory<>("deleteButton"));
        colUpdate.setCellValueFactory(new PropertyValueFactory<>("updateButton"));

       // loadAll();


        try(Session session = HibernateUtil.getSession()){
            Student student = session.get(Student.class, 1L);
            System.out.println("========================");
            System.out.println(student.getLaptop().getBrand());
            System.out.println("========================");
            student.getBooks().forEach(e-> System.out.println(e.getTitle()));
            System.out.println("========================");
            student.getPrograms().forEach(e-> System.out.println(e.getName()));
        }

    }

    public void btnSubmit(ActionEvent actionEvent) {
        Student student = new Student(Long.parseLong(txtId.getText()),
                txtName.getText(), txtAddress.getText());

        if (btn.getText().equals("Save Student")) {
            try (Session session = HibernateUtil.getSession()) {
                Transaction transaction = session.beginTransaction();
                session.save(student);
                transaction.commit();
                loadAll();
                new Alert(Alert.AlertType.INFORMATION, "Saved!").show();
            }
        } else {
            try (Session session = HibernateUtil.getSession()) {
                Transaction transaction = session.beginTransaction();
                Student selectedStudent = session.get(Student.class, student.getId());
                if (selectedStudent == null) {
                    new Alert(Alert.AlertType.WARNING, "Student not found!").show();
                    return;
                }
                selectedStudent.setName(student.getName());
                selectedStudent.setAddress(student.getAddress());
                transaction.commit();
                btn.setText("Save Student");
                loadAll();
                new Alert(Alert.AlertType.INFORMATION, "Saved!").show();
            }
        }
    }

    private void loadAll() {
        try (Session session = HibernateUtil.getSession()) {
            ObservableList<StudentTM> tms = FXCollections.observableArrayList();
            List<Student> selectedStudentList = session.createQuery("FROM Student").list();
            for (Student tempStudent : selectedStudentList) {
                Button deleteButton = new Button("Delete");
                Button updateButton = new Button("Update");
                tms.add(new StudentTM(tempStudent.getId(), tempStudent.getName(),
                        tempStudent.getAddress(), updateButton, deleteButton));

                deleteButton.setOnAction(e -> {
                    try (Session deleteSession = HibernateUtil.getSession()) {
                        Transaction deleteTransaction = deleteSession.beginTransaction();
                        deleteSession.delete(tempStudent);
                        deleteTransaction.commit();
                        loadAll();
                        new Alert(Alert.AlertType.INFORMATION, "Deleted!").show();
                    }
                });
                updateButton.setOnAction(e -> {
                    txtId.setText(String.valueOf(tempStudent.getId()));
                    txtName.setText(tempStudent.getName());
                    txtAddress.setText(tempStudent.getAddress());
                    btn.setText("Update Student");
                });
            }
            tblStudent.setItems(tms);
        }
    }
}
