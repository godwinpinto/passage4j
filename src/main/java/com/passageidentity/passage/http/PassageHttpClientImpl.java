package com.passageidentity.passage.http;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.passageidentity.passage.http.exception.HTTPError;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class PassageHttpClientImpl implements PassageHttpClient{

  private OkHttpClient client;

  private static final ObjectMapper objectMapper = new ObjectMapper();
  private static final ObjectReader objectReader = objectMapper.reader();
  private static final ObjectWriter objectWriter = objectMapper.writer();

  private String authorizationHeader;

  String version="1.0";
  public PassageHttpClientImpl(String authorizationHeader){
    if(authorizationHeader!=null || !authorizationHeader.trim().equals("")){
      this.authorizationHeader=authorizationHeader;
    }else{
      authorizationHeader=null;
    }
    initHttpClient();
  }

  public PassageHttpClientImpl(){
    initHttpClient();
  }
  private void initHttpClient(){
    client=new OkHttpClient.Builder()
        .addInterceptor(new GlobalHeaderInterceptor("Passage-Version", String.format("passage-go %s", version)))
        .build();

  }

  private <T> HTTPResponse<T> sendRequest(Request request, TypeReference<T> responseType) throws Exception {
    try (Response response = client.newCall(request).execute()) {
      HTTPResponse<T> httpResponse = new HTTPResponse<>();
      httpResponse.setStatusCode( response.code());
      httpResponse.setStatusText(response.message());

      if (response.isSuccessful()) {
        if (responseType != null && response.body()!=null) {
          String responseBody = response.body().string();
          httpResponse.setBody( objectReader.forType(responseType).readValue(responseBody));
        }
      } else {
        if(response.body()!=null){
          String errorBody = response.body().string();
          httpResponse.setError(objectReader.forType(HTTPError.class).readValue(errorBody));
        }
      }
      return httpResponse;
    }
  }

  public <T> HTTPResponse<T> get(String url, TypeReference<T> responseType) throws Exception {
    Request.Builder requestBuilder = new Request.Builder().get()
        .url(url);
    if(authorizationHeader!=null){
      requestBuilder.header("Authorization","Bearer "+authorizationHeader);
    }
    Request request=requestBuilder.build();
    return sendRequest(request, responseType);
  }

  public <T> HTTPResponse<T> post(String url, Object requestBody, TypeReference<T> responseType) throws Exception {
    String jsonBody = objectWriter.writeValueAsString(requestBody);
    RequestBody body = RequestBody.create(MediaType.parse("application/json"), jsonBody);
    Request.Builder requestBuilder = new Request.Builder()
        .url(url)
        .post(body);
    if(authorizationHeader!=null){
      requestBuilder.header("Authorization","Bearer "+authorizationHeader);
    }
    Request request=requestBuilder.build();

    return sendRequest(request, responseType);
  }

  public <T> HTTPResponse<T> delete(String url, TypeReference<T> responseType) throws Exception {
    Request.Builder requestBuilder = new Request.Builder().delete()
        .url(url);
    if(authorizationHeader!=null){
      requestBuilder.header("Authorization","Bearer "+authorizationHeader);
    }
    Request request=requestBuilder.build();
    return sendRequest(request, responseType);
  }


  public <T> HTTPResponse<T> patch(String url, Object requestBody, TypeReference<T> responseType) throws Exception {
    String jsonBody = objectWriter.writeValueAsString(requestBody);
    RequestBody body = RequestBody.create(jsonBody,MediaType.parse("application/json"));
    Request.Builder requestBuilder = new Request.Builder()
        .url(url)
        .patch(body);
    if(authorizationHeader!=null){
      requestBuilder.header("Authorization","Bearer "+authorizationHeader);
    }
    Request request=requestBuilder.build();

    return sendRequest(request, responseType);
  }


  public <T> HTTPResponse<T> patch(String url, TypeReference<T> responseType) throws Exception {
    RequestBody body = RequestBody.create("{}",MediaType.parse("application/json"));
    Request.Builder requestBuilder = new Request.Builder()
        .url(url)
        .patch(body);
    if(authorizationHeader!=null){
      requestBuilder.header("Authorization","Bearer "+authorizationHeader);
    }
    Request request=requestBuilder.build();

    return sendRequest(request, responseType);
  }

}
