package id.passageidentity.passage4j.core.http;

import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Interface for an HTTP client.
 */
public interface PassageHttpClient {

  /**
   * Sends an HTTP GET request to the specified URL and returns the response.
   *
   * @param url           The URL to send the request to.
   * @param responseType The type of the response.
   * @param <T>           The type of the response.
   * @return The HTTP response.
   * @throws Exception if an error occurs while making the request.
   */
  <T> HTTPResponse<T> get(String url, TypeReference<T> responseType) throws Exception;

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
  <T> HTTPResponse<T> post(String url, Object requestBody, TypeReference<T> responseType) throws Exception;

  /**
   * Sends an HTTP DELETE request to the specified URL and returns the response.
   *
   * @param url           The URL to send the request to.
   * @param responseType The type of the response.
   * @param <T>           The type of the response.
   * @return The HTTP response.
   * @throws Exception if an error occurs while making the request.
   */
  <T> HTTPResponse<T> delete(String url, TypeReference<T> responseType) throws Exception;

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
  <T> HTTPResponse<T> patch(String url, Object requestBody, TypeReference<T> responseType) throws Exception;

  /**
   * Sends an HTTP PATCH request to the specified URL and returns the response.
   *
   * @param url           The URL to send the request to.
   * @param responseType The type of the response.
   * @param <T>           The type of the response.
   * @return The HTTP response.
   * @throws Exception if an error occurs while making the request.
   */
  <T> HTTPResponse<T> patch(String url, TypeReference<T> responseType) throws Exception;

}
