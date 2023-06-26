package id.passageidentity.passage4j.core.http;

import com.fasterxml.jackson.core.type.TypeReference;

public interface PassageHttpClient {

  <T> HTTPResponse<T> get(String url, TypeReference<T> responseType) throws Exception;

  <T> HTTPResponse<T> post(String url, Object requestBody, TypeReference<T> responseType) throws Exception;

  <T> HTTPResponse<T> delete(String url, TypeReference<T> responseType) throws Exception;

  <T> HTTPResponse<T> patch(String url, Object requestBody, TypeReference<T> responseType) throws Exception;

  <T> HTTPResponse<T> patch(String url, TypeReference<T> responseType) throws Exception;

}