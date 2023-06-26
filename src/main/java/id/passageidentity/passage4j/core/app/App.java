package id.passageidentity.passage4j.core.app;

import id.passageidentity.passage4j.core.bean.AppInfoBean;
import id.passageidentity.passage4j.core.bean.CreateMagicLinkBodyBean;
import id.passageidentity.passage4j.core.bean.MagicLinkBean;
import id.passageidentity.passage4j.core.exception.PassageException;

public interface App {

  AppInfoBean getInfo() throws PassageException;

  MagicLinkBean createMagicLink(CreateMagicLinkBodyBean createMagicLinkBodyBean) throws PassageException;

}
