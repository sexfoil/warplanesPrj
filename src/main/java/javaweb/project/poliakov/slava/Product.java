package javaweb.project.poliakov.slava;

/**
 * Created by SiXFOiL on 16.08.2017.
 */
public class Product {
    private int plane_id;
    private String name;
    private String mark;
    private String model;
    private String role;
    private String country;
    private String description;
    private int crew;
    private int maxSpeed;
    private int serviceCeiling;
    private String picture;
    private int price;

    public Product() {
    }

    public Product(int plane_id, String name, String mark, String model,
                   String role, String country, String description,
                   int crew, int maxSpeed, int serviceCeiling,
                   String picture, int price) {

        this.plane_id = plane_id;
        this.name = name;
        this.mark = mark;
        this.model = model;
        this.role = role;
        this.country = country;
        this.description = description;
        this.crew = crew;
        this.maxSpeed = maxSpeed;
        this.serviceCeiling = serviceCeiling;
        this.picture = picture;
        this.price = price;
    }


    public int getPlane_id() {
        return plane_id;
    }

    public void setPlane_id(int plane_id) {
        this.plane_id = plane_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCrew() {
        return crew;
    }

    public void setCrew(int crew) {
        this.crew = crew;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getServiceCeiling() {
        return serviceCeiling;
    }

    public void setServiceCeiling(int serviceCeiling) {
        this.serviceCeiling = serviceCeiling;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
