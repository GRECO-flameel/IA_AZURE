import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CognitiveService {
    public static void main(String[] args) throws Exception {
        // Sua chave e URL do Azure Cognitive Services
        String subscriptionKey = "31e28f96407e4262beeb1a1d01ec6a10";  // Substitua pela sua chave real
        String endpoint = "https://iaazure.cognitiveservices.azure.com/";  // Seu ponto de extremidade

        // URL para Text Analytics - Análise de sentimentos
        String url = endpoint + "/text/analytics/v3.0/sentiment";

        // JSON com o texto a ser analisado
        String requestBody = "{ \"documents\": [{ \"id\": \"1\", \"text\": \"Estou muito feliz com o resultado!\" }] }";

        // Criar o cliente HTTP e a requisição
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .header("Ocp-Apim-Subscription-Key", subscriptionKey)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        // Enviar a requisição e obter a resposta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Exibir a resposta
        System.out.println("Resposta da API: " + response.body());
    }
}
