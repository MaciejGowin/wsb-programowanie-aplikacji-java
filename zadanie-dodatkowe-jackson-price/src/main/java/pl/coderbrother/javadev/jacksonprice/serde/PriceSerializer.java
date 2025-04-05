package pl.coderbrother.javadev.jacksonprice.serde;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import pl.coderbrother.javadev.jacksonprice.model.Price;

import java.io.IOException;

public class PriceSerializer extends JsonSerializer<Price> {

    @Override
    public void serialize(Price price, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString("%s %s".formatted(price.getValue(), price.getCurrency()));
    }
}
