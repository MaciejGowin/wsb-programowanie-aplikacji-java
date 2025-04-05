package pl.coderbrother.javadev.jacksonprice.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pl.coderbrother.javadev.jacksonprice.serde.PriceDeserializer;
import pl.coderbrother.javadev.jacksonprice.serde.PriceSerializer;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Product {

    private String name;

    @JsonSerialize(using = PriceSerializer.class)
    @JsonDeserialize(using = PriceDeserializer.class)
    private Price price;
}
