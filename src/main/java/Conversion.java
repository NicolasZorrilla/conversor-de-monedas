import java.util.HashMap;

public record Conversion(
        String base_code,
        HashMap<String, Double> conversion_rates) {
}
