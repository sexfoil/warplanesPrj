package javaweb.project.poliakov.slava;

/**
 * Created by SiXFOiL on 21.08.2017.
 */
public class CartItem {

    private Product product;
    private int qty;

    public CartItem() {
    }

    public CartItem(Product product, int qty) {
        this.product = product;
        this.qty = qty;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}