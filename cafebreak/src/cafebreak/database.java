package cafebreak;
import javax.persistence.*;
import java.time.LocalDate;

public class database {

    // Add
    public static void addUser(user user) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/odbtest.odb");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    public static void addReservation(Reservation reservation) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/odbtest.odb");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(reservation);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    public static void addTable(Table table) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/odbtest.odb");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(table);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    // Get by ID
    public static user getUserById(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/odbtest.odb");
        EntityManager em = emf.createEntityManager();
        user user = em.find(user.class, id);
        em.close();
        emf.close();
        return user;
    }

    public static Reservation getReservationById(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/odbtest.odb");
        EntityManager em = emf.createEntityManager();
        Reservation reservation = em.find(Reservation.class, id);
        em.close();
        emf.close();
        return reservation;
    }

    public static Table getTableById(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/odbtest.odb");
        EntityManager em = emf.createEntityManager();
        Table table = em.find(Table.class, id);
        em.close();
        emf.close();
        return table;
    }

    // Update
    public static void updateUser(int id, String newName, String newEmail, String newPassword, String newPhone) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/odbtest.odb");
        EntityManager em = emf.createEntityManager();
        user user = em.find(user.class, id);

        try {
            if (user != null) {
                em.getTransaction().begin();
                if (newName != null) user.setName(newName);
                if (newEmail != null) user.setEmail(newEmail);
                if (newPassword != null) user.setPassword(newPassword);
                if (newPhone != null) user.setPhone(newPhone);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }

    public static void updateReservation(int id, LocalDate newDate) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/odbtest.odb");
        EntityManager em = emf.createEntityManager();
        Reservation reservation = em.find(Reservation.class, id);

        try {
            if (reservation != null) {
                em.getTransaction().begin();
                if (newDate != null) reservation.setDate(newDate);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }

    public static void updateTable(int id, int newNumberOfChairs) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/odbtest.odb");
        EntityManager em = emf.createEntityManager();
        Table table = em.find(Table.class, id);

        try {
            if (table != null) {
                em.getTransaction().begin();
                if (newNumberOfChairs > 0) table.setNumberOfChairs(newNumberOfChairs);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }

    // Delete
    public static void deleteUser(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/odbtest.odb");
        EntityManager em = emf.createEntityManager();
        user user = em.find(user.class, id);

        if (user != null) {
            em.getTransaction().begin();
            em.remove(user);
            System.out.printf("SUCCESS: User with id: \"%d\" deleted successfully.%n", id);
            em.getTransaction().commit();
        } else {
            System.out.printf("ERROR: There's no User with id: \"%d\" in the database.%n", id);
        }

        em.close();
        emf.close();
    }

    public static void deleteReservation(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/odbtest.odb");
        EntityManager em = emf.createEntityManager();
        Reservation reservation = em.find(Reservation.class, id);

        if (reservation != null) {
            em.getTransaction().begin();
            em.remove(reservation);
            System.out.printf("SUCCESS: Reservation with id: \"%d\" deleted successfully.%n", id);
            em.getTransaction().commit();
        } else {
            System.out.printf("ERROR: There's no Reservation with id: \"%d\" in the database.%n", id);
        }

        em.close();
        emf.close();
    }

    public static void deleteTable(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/odbtest.odb");
        EntityManager em = emf.createEntityManager();
        Table table = em.find(Table.class, id);

        if (table != null) {
            em.getTransaction().begin();
            em.remove(table);
            System.out.printf("SUCCESS: Table with id: \"%d\" deleted successfully.%n", id);
            em.getTransaction().commit();
        } else {
            System.out.printf("ERROR: There's no Table with id: \"%d\" in the database.%n", id);
        }

        em.close();
        emf.close();
    }
}
