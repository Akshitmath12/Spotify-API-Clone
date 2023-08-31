package com.csc301.profilemicroservice;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ProfileDriverImpl_unfollowFriend_3b286938a9_Test {

    @Mock
    Driver driver;

    @Mock
    Session session;

    @Mock
    Transaction transaction;

    @Mock
    Result result;

    @Mock
    Record record;

    @InjectMocks
    ProfileDriverImpl profileDriverImpl;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        when(driver.session()).thenReturn(session);
        when(session.beginTransaction()).thenReturn(transaction);
        when(transaction.run(anyString(), any(Map.class))).thenReturn(result);
    }

    @Test
    public void testUnfollowFriend_Success() {
        String userName = "testUser";
        String frndUserName = "testFriend";

        when(result.hasNext()).thenReturn(true);
        when(result.next()).thenReturn(record);
        when(record.get("bool").asBoolean()).thenReturn(true);

        DbQueryStatus dbQueryStatus = profileDriverImpl.unfollowFriend(userName, frndUserName);
        assertEquals("POST", dbQueryStatus.getdbQueryExecResult().toString());
    }

    @Test
    public void testUnfollowFriend_Failure() {
        String userName = "testUser";
        String frndUserName = "testFriend";

        when(result.hasNext()).thenReturn(true);
        when(result.next()).thenReturn(record);
        when(record.get("bool").asBoolean()).thenReturn(false);

        DbQueryStatus dbQueryStatus = profileDriverImpl.unfollowFriend(userName, frndUserName);
        assertEquals("POST", dbQueryStatus.getdbQueryExecResult().toString());
    }
}
