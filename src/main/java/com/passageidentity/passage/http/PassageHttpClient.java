package com.passageidentity.passage.http;

import com.fasterxml.jackson.core.type.TypeReference;

public interface PassageHttpClient {

  public <T> HTTPResponse<T> get(String url, TypeReference<T> responseType) throws Exception;

  public <T> HTTPResponse<T> post(String url, Object requestBody, TypeReference<T> responseType) throws Exception;

  public <T> HTTPResponse<T> delete(String url, TypeReference<T> responseType) throws Exception;

  public <T> HTTPResponse<T> patch(String url, Object requestBody, TypeReference<T> responseType) throws Exception;

  public <T> HTTPResponse<T> patch(String url, TypeReference<T> responseType) throws Exception;

}
