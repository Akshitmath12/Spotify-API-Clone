package com.csc301.profilemicroservice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Session;
import org.neo4j.driver.Transaction;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProfileDriverImpl_InitProfileDb_644c73bfe7_Test {

    @Mock
    private Driver driver;

    @Mock
    private Session session;

    @Mock
    private Transaction transaction;

    @Test
    public void testInitProfileDb_Success() {
        when(driver.session()).thenReturn(session);
        when(session.beginTransaction()).thenReturn(transaction);

        ProfileMicroserviceApplication.driver = driver;
        ProfileDriverImpl profileDriver = new ProfileDriverImpl();
        profileDriver.InitProfileDb();

        verify(transaction, times(3)).run(anyString());
        verify(transaction, times(1)).success();
        verify(session, times(1)).close();
    }

    @Test
    public void testInitProfileDb_Failure() {
        when(driver.session()).thenReturn(session);
        when(session.beginTransaction()).thenThrow(new RuntimeException());

        ProfileMicroserviceApplication.driver = driver;
        ProfileDriverImpl profileDriver = new ProfileDriverImpl();

        try {
            profileDriver.InitProfileDb();
        } catch (Exception e) {
            verify(transaction, times(0)).run(anyString());
            verify(transaction, times(0)).success();
            verify(session, times(1)).close();
        }
    }
}
