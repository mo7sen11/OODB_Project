package cafebreak;
import javax.persistence.*;
import java.util.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/odbtest.odb");
        EntityManager em = emf.createEntityManager();

        try {
            
            em.getTransaction().begin();

           
            user user1 = new user();
            user1.setName("John Doe");
            user1.setEmail("johndoe@example.com");
            user1.setPassword("securePassword123");
            user1.setPhone("01129348731");

            
            em.persist(user1);

            
            user user2 = new user();
            user2.setName("Jane Smith");
            user2.setEmail("janesmith@example.com");
            user2.setPassword("anotherSecurePassword456");
            user2.setPhone("01284221865");

           
            em.persist(user2);

            
            Table table1 = new Table();
            table1.setNumberOfChairs(4);

            
            em.persist(table1);

            
            Reservation reservation1 = new Reservation();
            reservation1.setUser(user1);  // Associate with user1
            reservation1.setTable(table1);  // Associate with table1
            reservation1.setDate(LocalDate.now());  // Set current date for the reservation

            // Persist the reservation
            em.persist(reservation1);

            // Commit the transaction
            em.getTransaction().commit();

            System.out.println("Data successfully saved to the database!");
        } catch (Exception e) {
            // Rollback transaction in case of error
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
