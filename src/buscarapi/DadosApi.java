package buscarapi;

import java.util.Map;

public record DadosApi(String base_code, Map<String, Double> conversion_rates) {
}
