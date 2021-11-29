package pl.wsb.programowaniejava.maciejgowin.przyklad60;

public class ProductTotal {

    private String product;
    private double total;

    public ProductTotal(String product, double total) {
        this.product = product;
        this.total = total;
    }

    @Override
    public String toString() {
        return String.format("{%s, %f}", product, total);
    }
}
