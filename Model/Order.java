package CaseStudyModule2.Model;

public class Order {
    private String idBookOrder;
    private int quantity;

    public Order(String idBookOrder, int quantity) {
        this.idBookOrder = idBookOrder;
        this.quantity = quantity;
    }

    public String getIdBookOrder() {
        return idBookOrder;
    }

    public void setIdBookOrder(String idBookOrder) {
        this.idBookOrder = idBookOrder;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
