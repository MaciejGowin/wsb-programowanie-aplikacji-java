package pl.coderbrother.javadev.jacksonprice;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.coderbrother.javadev.jacksonprice.model.Price;
import pl.coderbrother.javadev.jacksonprice.model.Product;

import static pl.coderbrother.javadev.jacksonprice.util.ClassPathFile.readFile;

public class Main {

    public static void main(String[] args) throws Exception {
        Product janNowak = Product.builder()
                .name("Banana")
                .price(Price.builder()
                        .value(12)
                        .currency("EUR")
                        .build())
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(janNowak));
        System.out.println(objectMapper.readValue(readFile("product.json"), Product.class));
    }
}
