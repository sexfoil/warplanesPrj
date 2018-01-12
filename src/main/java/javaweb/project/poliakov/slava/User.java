package javaweb.project.poliakov.slava;

/**
 * Created by SiXFOiL on 16.08.2017.
 */
public class User {

    private int id;
    private String name;
    private String password;
    private String sex;
    private String email;
    private int age;
    private int money;
    private String cart;

    public User() {
    }

    public User(int id, String name, String password, String sex, String email, int age, int money, String cart) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.email = email;
        this.age = age;
        this.money = money;
        this.cart = cart;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getCart() {
        return cart;
    }

    public void setCart(String cart) {
        this.cart = cart;
    }
}
