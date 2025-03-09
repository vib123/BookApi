package book.example.BookApi.model;

import jakarta.persistence.*;

@Entity
@Table(name="books")


/*
* CREATE TABLE `bookapi`.`books` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `price` INT NULL,
  `type` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
* */

public class Book   {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private String type;

    //Constructors, getters and setters and other methods...

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }
}
