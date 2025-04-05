package pl.coderbrother.javadev.jacksonprice.serde;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import pl.coderbrother.javadev.jacksonprice.model.Price;

import java.io.IOException;

public class PriceDeserializer extends JsonDeserializer<Price> {

    @Override
    public Price deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        String[] price = jsonParser.getText().split(" ");
        return Price.builder()
                .value(Integer.valueOf(price[0]))
                .currency(price[1])
                .build();
    }
}
