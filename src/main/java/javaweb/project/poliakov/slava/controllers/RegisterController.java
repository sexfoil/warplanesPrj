package javaweb.project.poliakov.slava.controllers;

import javaweb.project.poliakov.slava.DBWorker;
import javaweb.project.poliakov.slava.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by SiXFOiL on 10.08.2017.
 */

@Controller
//@RequestMapping("/warplanes")
public class RegisterController {

    private User user = null;
    private String pageError = "You should fill in all fields of registration form correctly!";

    @RequestMapping(method = RequestMethod.GET)
    public String showPage(ModelMap model, HttpSession session) {

        session.removeAttribute("pageError");
        session.removeAttribute("loginError");
        session.removeAttribute("passError");
        session.removeAttribute("pass2Error");
        session.removeAttribute("emailError");
        session.removeAttribute("ageError");
        session.removeAttribute("sexError");
        session.removeAttribute("agreeError");

        String object = "Show page of registering";
        model.addAttribute("messageFromController", object);
        return "registerpage";
    }

    @RequestMapping(method = RequestMethod.POST, params = {"login", "password", "password2", "email", "age", "sex", "agree"})
    public String registering(@RequestParam("login") String log,
                              @RequestParam("password") String pass,
                              @RequestParam("password2") String pass2,
                              @RequestParam("email") String email,
                              @RequestParam("age") int age,
                              @RequestParam("sex") String sex,
                              @RequestParam("agree") String agree,
                              ModelMap model, HttpSession session) {

        System.out.println("REGISTER POST with params!!!");

        session.removeAttribute("pageError");

        session.removeAttribute("loginError");
        session.removeAttribute("passError");
        session.removeAttribute("pass2Error");
        session.removeAttribute("emailError");
        session.removeAttribute("ageError");
        session.removeAttribute("sexError");
        session.removeAttribute("agreeError");

        model.addAttribute("oldLogin", log);
        model.addAttribute("oldEmail", email);
        model.addAttribute("oldAge", age);


        boolean validData = true;

        try {
            DBWorker database = new DBWorker();

            if (database.isUserExist(log)) {
                validData = false;
                session.setAttribute("loginError", "This login is already exist!");
            } else {

            }
            if (pass.length() < 4) {
                validData = false;
                session.setAttribute("passError", "Too short password!");
            }
            if (!pass.equals(pass2)) {
                validData = false;
                session.setAttribute("pass2Error", "Different passwords!");
            }
            if (!(email.contains("@") && email.contains("."))) {
                validData = false;
                session.setAttribute("emailError", "Invalid e-mail address!");
            }
            if (age < 21) {
                validData = false;
                session.setAttribute("ageError", "Too young for purchasing warplanes!");
            }
            if (!(sex.equals("male") || sex.equals("female"))) {
                validData = false;
                session.setAttribute("sexError", "Choose your gender please!");
            }
            System.out.println("agree param is: " + agree);
            if (!agree.equals(",yes")) {
                validData = false;
                session.setAttribute("agreeError", "You should agree!");
            }


            if (validData) {
                user = new User(0, log, pass, sex, email, age, 1234567890, "");
                addUser(user, database);
            }

            database.closeConnection();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (user != null) {
            session.setAttribute("newUser", user);
            session.setAttribute("hiUser", new Boolean(true));
            return "registerpage";
        } else {
            session.setAttribute("pageError", pageError);
            return "registerpage";
        }
    }


    @RequestMapping(method = RequestMethod.POST, params = {})
    public String goHome(HttpSession session) {

        session.removeAttribute("loginError");
        session.removeAttribute("passError");
        session.removeAttribute("pass2Error");
        session.removeAttribute("emailError");
        session.removeAttribute("ageError");
        session.removeAttribute("sexError");
        session.removeAttribute("agreeError");

        session.setAttribute("pageError", pageError);
        System.out.println("\nREGISTERPAGE without POSTparams...\n");
        return "registerpage";
    }

    private void addUser(User user, DBWorker database) {

        String query = "INSERT INTO users (`name`, `password`, `sex`, `email`, `age`, `money`, `cart`) " +
                "VALUES ('" + user.getName() + "','" + user.getPassword() +
                "','" + user.getSex() + "','" + user.getEmail() + "','" + user.getAge() +
                "','" + user.getMoney() + "',\'\');";

        System.out.println(query);

        database.updateDatabase(query);
    }

}
