package com.csc301.profilemicroservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.Transaction;

public class PlaylistDriverImpl_likeSong_643385e86e_Test {

    @Mock
    private Driver driver;
    @Mock
    private Session session;
    @Mock
    private Transaction transaction;
    @Mock
    private StatementResult result;

    private PlaylistDriverImpl playlistDriver;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        playlistDriver = new PlaylistDriverImpl();
    }

    @Test
    public void testLikeSong_Success() {
        Map<String, Object> params = new HashMap<>();
        params.put("plName", "testUser-favourites");
        params.put("songId", "song123");

        when(driver.session()).thenReturn(session);
        when(session.beginTransaction()).thenReturn(transaction);
        when(transaction.run(any(), eq(params))).thenReturn(result);
        when(result.hasNext()).thenReturn(true);

        DbQueryStatus status = playlistDriver.likeSong("testUser", "song123");

        assertEquals(DbQueryExecResult.QUERY_OK, status.getdbQueryExecResult());
    }

    @Test
    public void testLikeSong_Failure() {
        Map<String, Object> params = new HashMap<>();
        params.put("plName", "testUser-favourites");
        params.put("songId", "song123");

        when(driver.session()).thenReturn(session);
        when(session.beginTransaction()).thenReturn(transaction);
        when(transaction.run(any(), eq(params))).thenReturn(result);
        when(result.hasNext()).thenReturn(false);

        DbQueryStatus status = playlistDriver.likeSong("testUser", "song123");

        assertEquals(DbQueryExecResult.QUERY_ERROR_GENERIC, status.getdbQueryExecResult());
    }

    @Test
    public void testLikeSong_NullParameters() {
        DbQueryStatus status = playlistDriver.likeSong(null, null);

        assertEquals(DbQueryExecResult.QUERY_ERROR_GENERIC, status.getdbQueryExecResult());
    }
}
