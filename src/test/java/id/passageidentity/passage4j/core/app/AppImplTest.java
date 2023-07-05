package id.passageidentity.passage4j.core.app;

import id.passageidentity.passage4j.core.exception.PassageException;
import id.passageidentity.passage4j.core.http.PassageHttpClient;
import id.passageidentity.passage4j.core.http.PassageHttpClientImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AppImplTest {

/*
    @Test
    void testGetInfoFailure() throws Exception {
        PassageHttpClient passageHttpClient= Mockito.mock(PassageHttpClient.class);
        AppBean appBean=new AppBean();
        App app=new AppImpl(appBean);
        when(passageHttpClient.get(anyString(),any())).thenThrow(new Exception("Some exception"));
        doThrow(new RuntimeException("Mocked exception")).when(passageHttpClient).get(anyString(),any());
        PassageException passageException=assertThrows(PassageException.class, app::getInfo);
        //assertEquals(400,passageException.getStatusCode());
    }
*/
}
