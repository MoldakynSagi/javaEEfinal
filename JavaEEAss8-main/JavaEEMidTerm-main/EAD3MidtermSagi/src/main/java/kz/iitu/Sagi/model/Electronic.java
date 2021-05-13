package kz.iitu.Sagi.model;

public class Electronic {

    private Long id;
    private String name;
    private String description;
    private double price;


    public Electronic(){

    }

    public Electronic(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;



    }

    public Electronic(Long id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
