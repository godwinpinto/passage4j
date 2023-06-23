package com.passageidentity.passage.http;

import javax.print.attribute.standard.Media;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import org.jetbrains.annotations.NotNull;

class GlobalHeaderInterceptor implements Interceptor {
  private final String headerName;
  private final String headerValue;

  public GlobalHeaderInterceptor(String headerName, String headerValue) {
    this.headerName = headerName;
    this.headerValue = headerValue;
  }

  @NotNull
  @Override
  public Response intercept(Chain chain) throws IOException {
    Request originalRequest = chain.request();

    Request modifiedRequest = originalRequest.newBuilder()
        .header(headerName, headerValue)
        .header("Content-Type", "application/json")
        .build();

    return chain.proceed(modifiedRequest);
  }
}