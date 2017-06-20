package oneToMany1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by cihangir on 6/20/17.
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hibernate one to many (Annotation)");

        //=================================================================
        Set<Book> bookSet=new HashSet<Book>();

        Category categoryA = new Category("Category A");
        Book book=new Book("A1");
        Book book1=new Book("A2");
        Book book2=new Book("A3");

        bookSet.add(book);
        bookSet.add(book2);
        bookSet.add(book1);

        categoryA.setBookSet(bookSet);


        //=================================================================
        Set<Book> bookSet2=new HashSet<Book>();

        Category categoryB = new Category("Category B");
        Book book3=new Book("B1");
        Book book4=new Book("B2");
        Book book5=new Book("B3");

        bookSet2.add(book3);
        bookSet2.add(book4);
        bookSet2.add(book5);

        categoryB.setBookSet(bookSet2);

        //=================================================================
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        //=================================================================


        session.save(categoryA);
        session.save(categoryB);

        //=================================================================
        session.getTransaction().commit();
        System.out.println("Done");
    }
}

