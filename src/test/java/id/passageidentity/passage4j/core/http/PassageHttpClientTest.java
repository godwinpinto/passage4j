package id.passageidentity.passage4j.core.http;

import id.passageidentity.passage4j.core.exception.PassageException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

public class PassageHttpClientTest {

    @Test
    void testPassageException(){
        PassageException passageException=assertThrows(PassageException.class,()->{
           throw new PassageException("message",400,"statusText","errorText");
        });
        assertEquals(400,passageException.getStatusCode());
        assertEquals("statusText",passageException.getStatusText());
        assertEquals("errorText",passageException.getErrorText());
        assertNotNull(passageException.getMessage());
    }
}
