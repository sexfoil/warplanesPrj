package javaweb.project.poliakov.slava.controllers;

/**
 * Created by SiXFOiL on 10.08.2017.
 */

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

@Controller
//@RequestMapping("/warplanes")
public class CartController {

    User user = null;
    ArrayList<CartItem> listOfCartItems;
    CartHandler cartHandler;

    @RequestMapping(method = RequestMethod.GET, params = {"remove", "id"})
    public String showPage(@RequestParam("remove") Boolean remove, @RequestParam("id") String id,
                           ModelMap model, HttpSession session) {

        System.out.println("\nCART method GET\n-----------------");
        listOfCartItems = (ArrayList<CartItem>) session.getAttribute("cartList");
        cartHandler = (CartHandler) session.getAttribute("cartHandler");


        user = (User) session.getAttribute("user");
        String l = user.getName();
        String p = user.getPassword();

        if (remove) {
            System.out.println("\nREMOVING BLOCK...........");
            cartHandler.removeItemFromCart(id, user.getId());

            try {
                DBWorker database = new DBWorker();
                user = database.getUser(l, p);
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
            session.setAttribute("user", user);
            user = (User) session.getAttribute("user");

            String cartstring = user.getCart();

            System.out.println("\nCART: " + cartstring + "\n");
            cartHandler.fromCartstringToItemslist(cartstring);
            listOfCartItems = cartHandler.getListOfCartItems();
        } else {
            System.out.println("\nNOT REMOVE BLOCK --------------------");
            String cartstring = user.getCart();

            System.out.println("\nCART: " + cartstring + "\n");

            cartHandler.fromCartstringToItemslist(cartstring);
            listOfCartItems = cartHandler.getListOfCartItems();

            //model.addAttribute("messageFromController", object);
        }
        session.setAttribute("cartList", listOfCartItems);

        return "cart";
    }

    @RequestMapping(method = RequestMethod.POST, params = {})
    public String goHome() {
        return "index";
    }


}

