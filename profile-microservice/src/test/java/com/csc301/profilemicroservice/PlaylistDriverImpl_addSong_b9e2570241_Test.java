package com.csc301.profilemicroservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.Transaction;

@ExtendWith(MockitoExtension.class)
public class PlaylistDriverImpl_addSong_b9e2570241_Test {

    @Mock
    private Driver driver;

    @Mock
    private Session session;

    @Mock
    private Transaction transaction;

    private PlaylistDriverImpl playlistDriverImpl;

    @BeforeEach
    public void setup() {
        playlistDriverImpl = new PlaylistDriverImpl();
    }

    @Test
    public void testAddSong_Success() {
        String songId = "1";
        String songName = "Song1";
        String queryStr = "MERGE (s:song {songId: $songId, songName: $songName})";
        Map<String, Object> params = new HashMap<>();
        params.put("songId", songId);
        params.put("songName", songName);

        when(driver.session()).thenReturn(session);
        when(session.writeTransaction(any())).thenReturn(null);

        DbQueryStatus result = playlistDriverImpl.addSong(songId, songName);

        verify(driver, times(1)).session();
        verify(session, times(1)).writeTransaction(any());
        verify(session, times(1)).close();

        assertEquals("POST", result.getdbQueryStatusCode());
        assertEquals(DbQueryExecResult.QUERY_OK, result.getdbQueryExecResult());
    }

    @Test
    public void testAddSong_Failure() {
        String songId = "1";
        String songName = "Song1";

        when(driver.session()).thenThrow(new RuntimeException());

        DbQueryStatus result = playlistDriverImpl.addSong(songId, songName);

        verify(driver, times(1)).session();

        assertEquals("POST", result.getdbQueryStatusCode());
        assertEquals(DbQueryExecResult.QUERY_ERROR_GENERIC, result.getdbQueryExecResult());
    }
}
