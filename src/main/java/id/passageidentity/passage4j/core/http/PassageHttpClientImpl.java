package id.passageidentity.passage4j.core.http;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import id.passageidentity.passage4j.core.http.exception.HTTPException;
import id.passageidentity.passage4j.core.util.PassageConstants;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

/**
 * Implementation of the PassageHttpClient interface.
 */
public class PassageHttpClientImpl implements PassageHttpClient {

  private HttpClient client;

  private static final ObjectMapper objectMapper = new ObjectMapper();
  private static final ObjectReader objectReader = objectMapper.reader();
  private static final ObjectWriter objectWriter = objectMapper.writer();

  private String authorizationHeader;

  /**
   * Constructs a PassageHttpClientImpl object with the specified authorization header.
   *
   * @param authorizationHeader The authorization header to be used in requests.
   */
  public PassageHttpClientImpl(String authorizationHeader) {
    if (authorizationHeader != null && !authorizationHeader.trim().equals("")) {
      this.authorizationHeader = authorizationHeader;
    } else {
      this.authorizationHeader = null;
    }
    initHttpClient();
  }

  /**
   * Constructs a PassageHttpClientImpl object without an authorization header.
   */
  public PassageHttpClientImpl() {
    initHttpClient();
  }

  /**
   * Initializes the underlying HttpClient.
   */
  private void initHttpClient() {
    client = HttpClient.newBuilder()
        .connectTimeout(Duration.ofSeconds(10))
        .build();
  }

  /**
   * Sends an HTTP request with the specified request object and response type.
   *
   * @param request      The HTTP request object.
   * @param responseType The type reference for deserializing the response.
   * @param <T>          The type of the response.
   * @return The HTTP response.
   * @throws Exception if an error occurs while sending the request.
   */
  private <T> HTTPResponse<T> sendRequest(HttpRequest request, TypeReference<T> responseType) throws Exception {
    try {
      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
      HTTPResponse<T> httpResponse = new HTTPResponse<>();
      httpResponse.setStatusCode(response.statusCode());
      httpResponse.setStatusText(HttpStatusText.getStatusText(response.statusCode()));

      if (response.statusCode() >= 200 && response.statusCode() < 300) {
        if (responseType != null && response.body() != null) {
          String responseBody = response.body();
          T deserializedBody = deserializeResponse(responseBody, responseType);
          httpResponse.setBody(deserializedBody);
        }
      } else {
        if (response.body() != null) {
          String errorBody = response.body();
          HTTPException error = new HTTPException();
          error.setErrorText(HttpStatusText.getStatusText(response.statusCode()));
          httpResponse.setError(error);
        }
      }
      return httpResponse;
    } catch (IOException | InterruptedException e) {
      throw new Exception("Error sending HTTP request: " + e.getMessage(), e);
    }
  }

  /**
   * Sends an HTTP GET request to the specified URL and returns the response.
   *
   * @param url           The URL to send the request to.
   * @param responseType The type of the response.
   * @param <T>           The type of the response.
   * @return The HTTP response.
   * @throws Exception if an error occurs while making the request.
   */
  @Override
  public <T> HTTPResponse<T> get(String url, TypeReference<T> responseType) throws Exception {
    HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
        .GET()
        .uri(URI.create(url));
    return sendRequestWithHeaders(requestBuilder, responseType);
  }

  /**
   * Sends an HTTP POST request to the specified URL with the given request body and returns the response.
   *
   * @param url           The URL to send the request to.
   * @param requestBody  The request body.
   * @param responseType The type of the response.
   * @param <T>           The type of the response.
   * @return The HTTP response.
   * @throws Exception if an error occurs while making the request.
   */
  @Override
  public <T> HTTPResponse<T> post(String url, Object requestBody, TypeReference<T> responseType) throws Exception {
    String jsonBody = objectWriter.writeValueAsString(requestBody);
    HttpRequest.BodyPublisher body = HttpRequest.BodyPublishers.ofString(jsonBody, StandardCharsets.UTF_8);
    HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
        .POST(body)
        .uri(URI.create(url))
        .header("Content-Type", "application/json");
    return sendRequestWithHeaders(requestBuilder, responseType);
  }

  /**
   * Sends an HTTP DELETE request to the specified URL and returns the response.
   *
   * @param url           The URL to send the request to.
   * @param responseType The type of the response.
   * @param <T>           The type of the response.
   * @return The HTTP response.
   * @throws Exception if an error occurs while making the request.
   */
  @Override
  public <T> HTTPResponse<T> delete(String url, TypeReference<T> responseType) throws Exception {
    HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
        .DELETE()
        .uri(URI.create(url));
    return sendRequestWithHeaders(requestBuilder, responseType);
  }

  /**
   * Sends an HTTP PATCH request to the specified URL with the given request body and returns the response.
   *
   * @param url           The URL to send the request to.
   * @param requestBody  The request body.
   * @param responseType The type of the response.
   * @param <T>           The type of the response.
   * @return The HTTP response.
   * @throws Exception if an error occurs while making the request.
   */
  @Override
  public <T> HTTPResponse<T> patch(String url, Object requestBody, TypeReference<T> responseType) throws Exception {
    String jsonBody = objectWriter.writeValueAsString(requestBody);
    HttpRequest.BodyPublisher body = HttpRequest.BodyPublishers.ofString(jsonBody, StandardCharsets.UTF_8);
    HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
        .method("PATCH", body)
        .uri(URI.create(url))
        .header("Content-Type", "application/json");
    return sendRequestWithHeaders(requestBuilder, responseType);
  }

  /**
   * Sends an HTTP PATCH request to the specified URL and returns the response.
   *
   * @param url           The URL to send the request to.
   * @param responseType The type of the response.
   * @param <T>           The type of the response.
   * @return The HTTP response.
   * @throws Exception if an error occurs while making the request.
   */
  @Override
  public <T> HTTPResponse<T> patch(String url, TypeReference<T> responseType) throws Exception {
    HttpRequest.BodyPublisher body = HttpRequest.BodyPublishers.ofString("{}", StandardCharsets.UTF_8);
    HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
        .method("PATCH", body)
        .uri(URI.create(url))
        .header("Content-Type", "application/json");
    return sendRequestWithHeaders(requestBuilder, responseType);
  }

  /**
   * Sends an HTTP request with headers and returns the response.
   *
   * @param requestBuilder The request builder.
   * @param responseType  The type of the response.
   * @param <T>            The type of the response.
   * @return The HTTP response.
   * @throws Exception if an error occurs while making the request.
   */
  private <T> HTTPResponse<T> sendRequestWithHeaders(HttpRequest.Builder requestBuilder, TypeReference<T> responseType)
      throws Exception {
    if (authorizationHeader != null) {
      requestBuilder.header("Authorization", "Bearer " + authorizationHeader);
    }
    requestBuilder.header("Passage-Version", String.format("passage-4j %s", PassageConstants.PASSAGE_VERSION));
    HttpRequest request = requestBuilder.build();
    return sendRequest(request, responseType);
  }

  /**
   * Deserializes the response body into the specified type.
   *
   * @param responseBody The response body.
   * @param responseType The type of the response.
   * @param <T>          The type of the response.
   * @return The deserialized response.
   * @throws IOException            if an error occurs while deserializing the response.
   * @throws ClassNotFoundException if the response type class cannot be found.
   */
  private <T> T deserializeResponse(String responseBody, TypeReference<T> responseType)
      throws IOException, ClassNotFoundException {
    Class<?> clazz = Class.forName(responseType.getType().getTypeName());
    if (clazz.isAnnotationPresent(JsonRootName.class)) {
      objectMapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
    }
    return objectMapper.readValue(responseBody, responseType);
  }
}