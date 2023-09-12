package groupProjectB.demo.controller.dto;

public class OrderDTO {
    private Long productId;
    private String supplier;
    private int quantity;

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "FormBackingOrderUpdate{" +
                ", supplier='" + supplier + '\'' +
                ", product id=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}
