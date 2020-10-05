package br.tec.cmc.kafka.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.json.JSONObject;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product")
@NoArgsConstructor
@Getter 
@Setter 
public class Product extends PanacheEntityBase {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="gtin")
    private String gtin;

    @Column(name="description")
    private String description;

    @Column(name="brand")
    private String brand;

    @Column(name="category")
    private String category;

    public JSONObject toJSONObject() {
        return new JSONObject(this);
    }

    public String toString() {
        return toJSONObject().toString();
    }

    public String toString(int ident) {
        return toJSONObject().toString(ident);
    }

}
