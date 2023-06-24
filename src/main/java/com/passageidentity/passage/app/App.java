package com.passageidentity.passage.app;

import com.passageidentity.passage.app.bean.AppInfoBean;
import com.passageidentity.passage.app.bean.CreateMagicLinkBodyBean;
import com.passageidentity.passage.app.bean.MagicLinkBean;
import com.passageidentity.passage.exception.PassageError;

public interface App {

  AppInfoBean getInfo() throws PassageError;

  MagicLinkBean createMagicLink(CreateMagicLinkBodyBean createMagicLinkBodyBean) throws PassageError;

}
