
package model;

import javax.persistence.*;

@Entity
@Table(name = "authors")
public class Authors {

@Id
private Integer author_id;      // Primary Key
@Column
private String name;
@Column
private String fname;

    public Integer getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Integer author_id) {
        this.author_id = author_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    

}
