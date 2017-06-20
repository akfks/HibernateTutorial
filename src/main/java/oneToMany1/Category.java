package oneToMany1;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by cihangir on 6/20/17.
 */
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "category_book",
               joinColumns = @JoinColumn(
                       name = "category_id",
                       referencedColumnName = "id"),
                            inverseJoinColumns = @JoinColumn(
                               name = "book_id",
                               referencedColumnName = "id"))
    private Set<Book> bookSet=new HashSet<Book>(0);


    public Category(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBookSet() {
        return bookSet;
    }

    public void setBookSet(Set<Book> bookSet) {
        this.bookSet = bookSet;
    }
}
