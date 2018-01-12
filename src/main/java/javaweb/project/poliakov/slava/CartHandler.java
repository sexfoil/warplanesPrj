package javaweb.project.poliakov.slava;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by SiXFOiL on 21.08.2017.
 */
public class CartHandler {

    //private String cartstring = "";
    private ArrayList<Product> items = new ArrayList<>();
    private ArrayList<Integer> itemsQty = new ArrayList<>();
    private ArrayList<CartItem> listOfCartItems = new ArrayList<>();

    public CartHandler() {
        //System.out.println("\nCartHendler created...\n");
    }

    public void removeItemFromCart(String id, int userId) {
        System.out.println("\nRemoving from cart by ID : " + id);
        int index = - 1;
        for (int i = 0; i < listOfCartItems.size(); i++) {

            //if (id.equals(listOfCartItems.get(i).getProduct().getPlane_id())) {
            if (Integer.parseInt(id) == (listOfCartItems.get(i).getProduct().getPlane_id())) {
                index = i;
                System.out.println("removing ... " + i);
            }
        }
        System.out.println("INDEX: " + index);
        if (index >= 0) {
            listOfCartItems.remove(index);
        }
        String query = fromItemslistToCartstring(listOfCartItems, userId);

        try {
            DBWorker database = new DBWorker();
            database.updateDatabase(query);
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
    public void addItemToCart(String idStr, int userId) {
        boolean itemNotExist = true;
        int id = Integer.parseInt(idStr);
        for (CartItem item : listOfCartItems) {
            if (item.getProduct().getPlane_id() == id) {
                itemNotExist = false;
                int currentQty = item.getQty() + 1;
                item.setQty(currentQty);
            }
        }

        if (itemNotExist) {

            try {
                DBWorker database = new DBWorker();
                String kind = " WHERE plane_id='" + id + "'";
                System.out.println(kind);
                Product p = database.getOneProduct("*", kind);
                listOfCartItems.add(new CartItem(p, 1));
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


        String query = fromItemslistToCartstring(listOfCartItems, userId);

        try {
            DBWorker database = new DBWorker();
            database.updateDatabase(query);
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

    public String fromItemslistToCartstring(ArrayList<CartItem> currentListOfCartItems, int userId) {

        String body = "";
        String cartatring;
        for (CartItem item : currentListOfCartItems) {
            body += "," + item.getProduct().getPlane_id() + ":" + item.getQty();

        }
        System.out.println("now CART is: " + body);

        cartatring = body.length() > 0 ? body.substring(1) : body;

        String query = "UPDATE users SET cart='" + cartatring +"' WHERE id='" + userId + "'";
        System.out.println("\n" + query + "\n");

        return query;
    }

    public void fromCartstringToItemslist(String cartstring) {

        if (cartstring.length() > 0) {
            String[] arrayStr = cartstring.split(",");
            ArrayList<String> list = new ArrayList<>();
            for (String str : arrayStr) {
                System.out.println(str.trim());
                list.add(str.trim());
            }

            items = new ArrayList<>();
            itemsQty = new ArrayList<>();

            try {
                DBWorker database = new DBWorker();
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(list.size());
                    String[] currentItem = list.get(i).split(":");
                    System.out.println(currentItem.length);
                    System.out.println(currentItem[0]);
                    String kind = " WHERE plane_id='" + currentItem[0] + "'";
                    System.out.println(kind);
                    Product p = database.getOneProduct("*", kind);
                    items.add(p);
                    itemsQty.add(Integer.parseInt(currentItem[1]));
                }
                database.closeConnection();

                listOfCartItems = new ArrayList<>();
                for (int i = 0; i < items.size(); i++) {
                    listOfCartItems.add(new CartItem(items.get(i), itemsQty.get(i)));
                }

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

    public ArrayList<CartItem> getListOfCartItems() {
        return listOfCartItems;
    }
}
