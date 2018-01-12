package javaweb.project.poliakov.slava.controllers;

/**
 * Created by SiXFOiL on 10.08.2017.
 */

import javaweb.project.poliakov.slava.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;

@Controller
//@SessionAttributes("sessAttr")
public class ProductController {

    User user;
    ArrayList<Product> listOfProducts = null;
    ArrayList<CartItem> listOfCartItems = null;
    CartHandler cartHandler = new CartHandler();

    @RequestMapping(method = RequestMethod.GET, params = {"category", "addId"})
    public String showPage(@RequestParam("category") String category, @RequestParam("addId") String addId,
                           ModelMap model, HttpSession session) {
        user = (User) session.getAttribute("user");
        listOfCartItems = (ArrayList<CartItem>) session.getAttribute("cartList");
        cartHandler = (CartHandler) session.getAttribute("cartHandler");

        if (!addId.equals("0")) {

            cartHandler.addItemToCart(addId, user.getId());
            cartHandler.fromItemslistToCartstring(listOfCartItems, user.getId());
            if (user != null) {
                String l = user.getName();
                String p = user.getPassword();

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
            }
            String cartstring = user.getCart();
            cartHandler.fromCartstringToItemslist(cartstring);
            listOfCartItems = cartHandler.getListOfCartItems();

        }


        String kind = "";
        String previousPage = "all";

        if (category.equals("interceptor") || category.equals("ground-attack") || category.equals("reconnaissance")) {
            kind = " WHERE role='" + category +"'";
            previousPage = category;
        }

        setListOfProducts("*", kind);

        System.out.println("category = " + category);

        model.addAttribute("allProducts", listOfProducts);
        model.addAttribute("planeID", 0);

        session.setAttribute("productsList", listOfProducts);
        session.setAttribute("prePage", previousPage);



        return "products";
    }

    @RequestMapping(method = RequestMethod.POST, params = {"seeDetails", "category"})
    public String seeDetails(@RequestParam("seeDetails") Integer planeID,
                             @RequestParam("category") String category,
                             ModelMap model, HttpSession session) {

        listOfCartItems = (ArrayList<CartItem>) session.getAttribute("cartList");
        cartHandler = (CartHandler) session.getAttribute("cartHandler");


        System.out.println("----------------------");
        System.out.println("seeDetails: " + planeID);
        System.out.println("category: " + category);
        System.out.println("----------------------");
        model.addAttribute("planeID", planeID);

        //model.addAttribute("someParam2", "nothing");
        return "products";
    }

    @RequestMapping(method=RequestMethod.POST,params={})
    public String goHome(ModelMap model, HttpSession session){
        Boolean isEmpty = new Boolean(true);
        session.setAttribute("isEmpty", isEmpty);
        return "product";
    }

    private void setListOfProducts(String what, String kind){
        try {
            DBWorker database = new DBWorker();
            listOfProducts = database.getProducts(what, kind);
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
