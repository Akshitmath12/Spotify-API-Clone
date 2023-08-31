package com.csc301.profilemicroservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DbQueryStatus_getMessage_cebf167bb8_Test {

    @InjectMocks
    DbQueryStatus dbQueryStatus;

    @Test
    public void testGetMessage_WithValidMessage() {
        dbQueryStatus.setMessage("Test Message");
        String result = dbQueryStatus.getMessage();
        assertEquals("Test Message", result);
    }

    @Test
    public void testGetMessage_WithEmptyMessage() {
        dbQueryStatus.setMessage("");
        String result = dbQueryStatus.getMessage();
        assertEquals("", result);
    }
}
