package Devileean.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Goods {
    private String name;
    private double price;
    private int sort;
    private int weight;
    private String country;

}