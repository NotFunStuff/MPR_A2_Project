package hanu.a2_1801040067.MyCart.models;

public class Product {
    private long id;
    private String thumbnail;
    private String name;
    private long unitPrice;
    private long quantity;

    public Product(long id, String thumbnail, String name, long unitPrice, long quantity) {
        this.id = id;
        this.thumbnail = thumbnail;
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(long unitPrice) {
        this.unitPrice = unitPrice;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", thumbnail='" + thumbnail + '\'' +
                ", name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
