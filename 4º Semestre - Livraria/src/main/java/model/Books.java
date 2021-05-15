package model;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Books {

@Column
private String title;
@Id
private String isbn;        
@Column
private Integer publisher_id;
@Column
private Double price;
@ManyToOne
@JoinColumn(name="authors")    
private Authors author;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getPublisher_ID() {
        return publisher_id;
    }

    public void setPublisher_ID(Integer publisher_ID) {
        this.publisher_id = publisher_ID;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double Price) {
        this.price = Price;
    }

    @Override
    public String toString() {
        return "Books{" + "title=" + title + ", isbn=" + isbn + ", publisher_id=" + publisher_id + ", price=" + price + '}';
    }

    
    
}
