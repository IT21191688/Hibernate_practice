import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.*;
import java.util.List;

public class AppInitializer {
    public static void main(String[] args) {
        // save
      /*  try{
            Customer customer = new Customer(1001,"Nimal Silva","Panadura",25000, "2023-08-22");
            if(saveCustomer(customer)){
                System.out.println("Success!");
            }else{
                System.out.println("Try Again!");
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }*/
        // save
        // find by id
     /*   try{
            Customer customer = findById(1001);
            if(customer!=null){
                System.out.println("Success!");
                System.out.println(customer.toString());
            }else{
                System.out.println("Try Again!");
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }*/
        // find by id
        // find All
        findAll().forEach(e-> System.out.println(e.toString()));
        // find All
        // update
       /* try{
            Customer customer = new Customer(1001,"Nimal Siripala",
                    "Colombo",45000, "2023-08-23");
            if(updateCustomer(customer)){
                System.out.println("Success!");
            }else{
                System.out.println("Try Again!");
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }*/
        // update
        // delete
      /*  try {
            if (deleteCustomer(1001)) {
                System.out.println("Success!");
            } else {
                System.out.println("Try Again!");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }*/
        // delete
    }

    private static boolean saveCustomer(Customer c) {
        try (Session session = new HibernateUtil().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(c);
            transaction.commit();
        }
        return true;
    }

    private static Customer findById(long id) {
        try (Session session = new HibernateUtil().openSession()) {
            return session.get(Customer.class, id);
        }
    }

    private static List<Customer> findAll() {
        try (Session session = new HibernateUtil().openSession()) {
            return session.createQuery("FROM Customer", Customer.class).list();
        }
    }

    private static boolean updateCustomer(Customer c) {
        try (Session session = new HibernateUtil().openSession()) {
            Transaction transaction = session.beginTransaction();
            Customer selectedCustomer = session.get(Customer.class, c.getId());
            if (selectedCustomer == null) return false;
            selectedCustomer.setSalary(c.getSalary());
            selectedCustomer.setName(c.getName());
            selectedCustomer.setAddress(c.getAddress());
            selectedCustomer.setDob(c.getDob());
            transaction.commit();
            return true;
        }
    }

    private static boolean deleteCustomer(long id) throws ClassNotFoundException, SQLException {
        try (Session session = new HibernateUtil().openSession()) {
            Transaction transaction = session.beginTransaction();
            Customer selectedCustomer = session.get(Customer.class, id);
            if (selectedCustomer == null) return false;
            session.delete(selectedCustomer);
            transaction.commit();
            return true;
        }
    }
}
