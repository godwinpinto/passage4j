package id.passageidentity.passage4j.core.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Bean class representing layout configuration.
 */
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

  /**
   * Get the ID of the layout configuration.
   *
   * @return The ID of the layout configuration.
   */
  public String getId() {
    return id;
  }

  /**
   * Set the ID of the layout configuration.
   *
   * @param id The ID to set.
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Get the X coordinate of the layout configuration.
   *
   * @return The X coordinate.
   */
  public int getX() {
    return x;
  }

  /**
   * Set the X coordinate of the layout configuration.
   *
   * @param x The X coordinate to set.
   */
  public void setX(int x) {
    this.x = x;
  }

  /**
   * Get the Y coordinate of the layout configuration.
   *
   * @return The Y coordinate.
   */
  public int getY() {
    return y;
  }

  /**
   * Set the Y coordinate of the layout configuration.
   *
   * @param y The Y coordinate to set.
   */
  public void setY(int y) {
    this.y = y;
  }

  /**
   * Get the width of the layout configuration.
   *
   * @return The width.
   */
  public int getW() {
    return w;
  }

  /**
   * Set the width of the layout configuration.
   *
   * @param w The width to set.
   */
  public void setW(int w) {
    this.w = w;
  }

  /**
   * Get the height of the layout configuration.
   *
   * @return The height.
   */
  public int getH() {
    return h;
  }

  /**
   * Set the height of the layout configuration.
   *
   * @param h The height to set.
   */
  public void setH(int h) {
    this.h = h;
  }

  /**
   * Get a string representation of the LayoutConfigBean object.
   *
   * @return The string representation.
   */
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

