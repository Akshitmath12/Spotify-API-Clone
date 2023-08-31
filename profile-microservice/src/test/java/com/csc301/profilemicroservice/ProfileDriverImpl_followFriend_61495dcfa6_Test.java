package com.csc301.profilemicroservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Record;
import org.neo4j.driver.Session;
import org.neo4j.driver.Transaction;
import org.neo4j.driver.Result;

public class ProfileDriverImpl_followFriend_61495dcfa6_Test {

	@InjectMocks
	ProfileDriverImpl profileDriverImpl;

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

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testFollowFriend_Success() {
		String userName = "testUser";
		String frndUserName = "testFriend";
		Map<String, Object> params = new HashMap<>();
		params.put("userName", userName);
		params.put("frndUserName", frndUserName);

		when(driver.session()).thenReturn(session);
		when(session.beginTransaction()).thenReturn(transaction);
		when(transaction.run("MATCH (n:profile {userName: $userName}) RETURN n.userName as u", params))
				.thenReturn(result);
		when(result.hasNext()).thenReturn(true);

		when(transaction.run("MATCH (n:profile {userName: $frndUserName}) RETURN n.userName as f", params))
				.thenReturn(result);
		when(result.hasNext()).thenReturn(true);

		when(transaction.run(
				"RETURN EXISTS( (:profile {userName: $userName})-[:follows]->(:profile {userName: $frndUserName}) ) as bool",
				params)).thenReturn(result);
		when(result.hasNext()).thenReturn(true);
		when(result.next()).thenReturn(record);
		when(record.get("bool").asBoolean()).thenReturn(false);

		DbQueryStatus dbQueryStatus = profileDriverImpl.followFriend(userName, frndUserName);
		assertEquals(dbQueryStatus.getdbQueryExecResult(), DbQueryExecResult.QUERY_OK);
	}

	@Test
	public void testFollowFriend_Failure() {
		String userName = "testUser";
		String frndUserName = "testFriend";
		Map<String, Object> params = new HashMap<>();
		params.put("userName", userName);
		params.put("frndUserName", frndUserName);

		when(driver.session()).thenReturn(session);
		when(session.beginTransaction()).thenReturn(transaction);
		when(transaction.run("MATCH (n:profile {userName: $userName}) RETURN n.userName as u", params))
				.thenReturn(result);
		when(result.hasNext()).thenReturn(false);

		DbQueryStatus dbQueryStatus = profileDriverImpl.followFriend(userName, frndUserName);
		assertEquals(dbQueryStatus.getdbQueryExecResult(), DbQueryExecResult.QUERY_ERROR_GENERIC);
	}
}
