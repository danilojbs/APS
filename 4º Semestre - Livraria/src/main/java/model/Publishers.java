
package model;

import javax.persistence.*;

@Entity
@Table(name = "publishers")
public class Publishers {

@Id
private Integer publisher_id;   
@Column
private String name;
@Column
private String url;

    public Integer getPublisher_ID() {
        return publisher_id;
    }

    public void setPublisher_ID(Integer publisher_ID) {
        this.publisher_id = publisher_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
