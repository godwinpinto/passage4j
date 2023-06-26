package id.passageidentity.passage4j.core.app;

/**
 * The main interface for interacting with Passage.
 */
public interface Passage {

  /**
   * Retrieves the {@link App} instance for working with app-related functionality.
   *
   * @return the {@link App} instance
   */
  App app();

  /**
   * Retrieves the {@link User} instance for working with user-related functionality.
   *
   * @return the {@link User} instance
   */
  User user();

  /**
   * Retrieves the {@link Auth} instance for working with authentication-related functionality.
   *
   * @return the {@link Auth} instance
   */
  Auth auth();
}
