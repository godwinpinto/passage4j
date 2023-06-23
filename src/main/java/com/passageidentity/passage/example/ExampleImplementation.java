package com.passageidentity.passage.example;

import com.passageidentity.passage.app.Passage;
import com.passageidentity.passage.app.PassageConfig;
import com.passageidentity.passage.app.PassageNew;
import com.passageidentity.passage.exception.PassageError;

public class ExampleImplementation {

  public static void main(String[] args) {
    PassageConfig config=new PassageConfig();
    config.setHeaderAuth(false);
    config.setApiKey("<PASSAGE_API_KEY>");

    try {
      Passage psg = new PassageNew("<PASSAGE_APP_ID>", config);
    }catch(PassageError pe){
      System.out.println(pe.getMessage());
      pe.printStackTrace();
    }

  }

}
