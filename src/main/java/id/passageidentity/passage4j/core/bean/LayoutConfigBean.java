package id.passageidentity.passage4j.core.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public class LayoutConfigBean {

  @JsonProperty("id")
  private String id;
  @JsonProperty("x")
  private int x;
  @JsonProperty("y")
  private int y;
  @JsonProperty("w")
  private int w;
  @JsonProperty("h")
  private int h;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public int getW() {
    return w;
  }

  public void setW(int w) {
    this.w = w;
  }

  public int getH() {
    return h;
  }

  public void setH(int h) {
    this.h = h;
  }

  @Override
  public String toString() {
    return "LayoutConfigBean{" +
        "id='" + id + '\'' +
        ", x=" + x +
        ", y=" + y +
        ", w=" + w +
        ", h=" + h +
        '}';
  }
}
