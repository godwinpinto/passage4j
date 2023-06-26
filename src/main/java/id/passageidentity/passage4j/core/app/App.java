package id.passageidentity.passage4j.core.app;

import id.passageidentity.passage4j.core.bean.AppInfoBean;
import id.passageidentity.passage4j.core.bean.CreateMagicLinkBodyBean;
import id.passageidentity.passage4j.core.bean.MagicLinkBean;
import id.passageidentity.passage4j.core.exception.PassageException;

/**
 * Interface representing a Passage app.
 */
public interface App {

  /**
   * Retrieves information about the app.
   *
   * @return the {@link AppInfoBean} containing the app information
   * @throws PassageException if there is an error retrieving the app information
   */
  AppInfoBean getInfo() throws PassageException;

  /**
   * Creates a magic link for the specified body.
   *
   * @param createMagicLinkBodyBean the body for creating the magic link
   * @return the {@link MagicLinkBean} representing the created magic link
   * @throws PassageException if there is an error creating the magic link
   */
  MagicLinkBean createMagicLink(CreateMagicLinkBodyBean createMagicLinkBodyBean) throws PassageException;

}
