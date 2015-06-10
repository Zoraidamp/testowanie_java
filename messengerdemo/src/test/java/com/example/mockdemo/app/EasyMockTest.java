package com.example.mockdemo.app;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import org.easymock.EasyMockRule;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Rule;
import org.junit.Test;

import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.SendingStatus;

public class EasyMockTest {
	
	@Rule
	public EasyMockRule mocks = new EasyMockRule(this);

	@Mock
	private MessageService mock;

	@TestSubject
	private Messenger messenger = new Messenger(mock);

	
	@Test
	public void checkConnectionSuccess1() {
		expect(mock.checkConnection(".pl")).andReturn(ConnectionStatus.SUCCESS);
		replay(mock);
		assertEquals(messenger.testConnection(".pl"), 0);
		verify(mock);
	}
	@Test
	public void checkConnectionSuccess2() {
		expect(mock.checkConnection("xyz.pl")).andReturn(ConnectionStatus.SUCCESS);
		replay(mock);
		assertEquals(messenger.testConnection("xyz.pl"), 0);
		verify(mock);
	}
	@Test
	public void checkConnectionFailure1() {
		expect(mock.checkConnection("pl")).andReturn(ConnectionStatus.FAILURE);
		replay(mock);
		assertEquals(messenger.testConnection("pl"), 1);
		verify(mock);
	}
	@Test
	public void checkConnectionFailure2() {
		expect(mock.checkConnection(".com")).andReturn(ConnectionStatus.FAILURE);
		replay(mock);
		assertEquals(messenger.testConnection(".com"), 1);
		verify(mock);
	}
	@Test
	public void sendMessageSuccess1() throws MalformedRecipientException {
		expect(mock.send("xyz.pl", "message")).andReturn(SendingStatus.SENT);
		replay(mock);
		assertEquals(messenger.sendMessage("xyz.pl", "message"), 0);
		verify(mock);
	}
	@Test
	public void sendMessageSuccess2() throws MalformedRecipientException {
		expect(mock.send("x.pl", "mes")).andReturn(SendingStatus.SENT);
		replay(mock);
		assertEquals(messenger.sendMessage("x.pl", "mes"), 0);
		verify(mock);
	}
	@Test
	public void sendMessageFailure1() throws MalformedRecipientException {
		expect(mock.send("pl", "message")).andReturn(SendingStatus.SENDING_ERROR);
		replay(mock);
		assertEquals(messenger.sendMessage("pl", "message"), 1);
		verify(mock);
	}
	@Test
	public void sendMessageFailure2() throws MalformedRecipientException {
		expect(mock.send(".com", "message")).andReturn(SendingStatus.SENDING_ERROR);
		replay(mock);
		assertEquals(messenger.sendMessage(".com", "message"), 1);
		verify(mock);
	}
	@Test
	public void sendMessageException1() throws MalformedRecipientException {
		expect(mock.send(".pl", "message")).andThrow(new MalformedRecipientException());
		replay(mock);
		assertEquals(messenger.sendMessage(".pl", "message"), 2);
		verify(mock);
	}
	@Test
	public void sendMessageException2() throws MalformedRecipientException {
		expect(mock.send("x.pl", "me")).andThrow(new MalformedRecipientException());
		replay(mock);
		assertEquals(messenger.sendMessage("x.pl", "me"), 2);
		verify(mock);
	}
}
