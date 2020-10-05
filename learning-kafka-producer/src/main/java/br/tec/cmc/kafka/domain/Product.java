package br.tec.cmc.kafka.domain;

import org.json.JSONObject;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter 
@Setter 
public class Product {

    private String gtin;
    private String description;
    private String brand;
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
