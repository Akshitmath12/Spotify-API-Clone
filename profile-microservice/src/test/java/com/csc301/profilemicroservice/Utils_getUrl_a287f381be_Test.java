package com.csc301.profilemicroservice;

import javax.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class Utils_getUrl_a287f381be_Test {

    @Test
    public void testGetUrlWithQueryString() {
        HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
        when(req.getRequestURL()).thenReturn(new StringBuffer("http://localhost:8080/test"));
        when(req.getQueryString()).thenReturn("param1=value1&param2=value2");

        String result = Utils.getUrl(req);
        assertEquals("http://localhost:8080/test?param1=value1&param2=value2", result);
    }

    @Test
    public void testGetUrlWithoutQueryString() {
        HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
        when(req.getRequestURL()).thenReturn(new StringBuffer("http://localhost:8080/test"));
        when(req.getQueryString()).thenReturn(null);

        String result = Utils.getUrl(req);
        assertEquals("http://localhost:8080/test", result);
    }
}
