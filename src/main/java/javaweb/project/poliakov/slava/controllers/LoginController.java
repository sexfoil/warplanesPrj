package javaweb.project.poliakov.slava.controllers;

import javaweb.project.poliakov.slava.CartHandler;
import javaweb.project.poliakov.slava.CartItem;
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
public class LoginController {

    private User user = null;
    ArrayList<CartItem> listOfCartItems = null;
    CartHandler cartHandler = new CartHandler();

    @RequestMapping(method = RequestMethod.GET, params = "logout")
    public String showPage(@RequestParam("logout") Boolean logout, ModelMap model, HttpSession session) {

        System.out.println("LOGIN PAGE BY - GET METHOD");

        if (logout) {
            user = null;
            session.removeAttribute("user");
            session.removeAttribute("wrong");
        }
        return "loginpage";
    }

    @RequestMapping(method = RequestMethod.POST, params = {"login", "password"})
    public String loggining(@RequestParam("login") String log,
                            @RequestParam("password") String pass,
                            ModelMap model, HttpSession session) {

        //session.setAttribute("hiUser", new Boolean(false));
        session.setAttribute("oldLog", log);

        initUser(log, pass);

        if (user != null) {
            session.setAttribute("user", user);
            System.out.println("\n--------------------------------------");
            System.out.println("L: " + log);
            System.out.println("P: " + pass);
            System.out.println("--------------------------------------\n");

            String cartstring = user.getCart();

            cartHandler.fromCartstringToItemslist(cartstring);
            listOfCartItems = cartHandler.getListOfCartItems();

            session.setAttribute("cartList", listOfCartItems);
            session.setAttribute("cartHandler", cartHandler);

        } else {
            System.out.println("------------ USER IS NULL ---------------");
            session.setAttribute("wrong", "Wrong login or password!");
        }

        //session.setAttribute();

        return "loginpage";
    }

    @RequestMapping(method = RequestMethod.POST, params = {})
    public String goHome() {
        //session.setAttribute("hiUser", new Boolean(false));

        System.out.println("------------------ loginpage post without params! ------------");
        return "view";
    }

    private void initUser(String login, String password){
        try {
            DBWorker database = new DBWorker();
            user = database.getUser(login, password);
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
    }

}
