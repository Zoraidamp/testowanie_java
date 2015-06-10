package com.example.mockdemo.app;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.SendingStatus;

public class MockitoTest {

	private MessageService mock = mock(MessageService.class);
	private Messenger messenger = new Messenger(mock);
	
	
	@Test
	public void checkConnectionSuccess1() {
		when(mock.checkConnection(".pl")).thenReturn(ConnectionStatus.SUCCESS);
		assertEquals(messenger.testConnection(".pl"), 0);
		verify(mock).checkConnection(".pl");
	}
	@Test
	public void checkConnectionSuccess2() {
		when(mock.checkConnection("xyz.pl")).thenReturn(ConnectionStatus.SUCCESS);
		assertEquals(messenger.testConnection("xyz.pl"), 0);
		verify(mock).checkConnection("xyz.pl");
	}
	@Test
	public void checkConnectionFailure1() {
		when(mock.checkConnection("pl")).thenReturn(ConnectionStatus.FAILURE);
		assertEquals(messenger.testConnection("pl"), 1);
		verify(mock).checkConnection("pl");
	}
	@Test
	public void checkConnectionFailure2() {
		when(mock.checkConnection(".com")).thenReturn(ConnectionStatus.FAILURE);
		assertEquals(messenger.testConnection(".com"), 1);
		verify(mock).checkConnection(".com");
	}
	@Test
	public void sendMessageSuccess1() throws MalformedRecipientException {
		when(mock.send("x.pl", "mes")).thenReturn(SendingStatus.SENT);
		assertEquals(messenger.sendMessage("x.pl", "mes"), 0);
		verify(mock).send("x.pl", "mes");
	}
	@Test
	public void sendMessageSuccess2() throws MalformedRecipientException {
		when(mock.send("xyz.pl", "message")).thenReturn(SendingStatus.SENT);
		assertEquals(messenger.sendMessage("xyz.pl", "message"), 0);
		verify(mock).send("xyz.pl", "message");
	}
	@Test
	public void sendMessageFailure1() throws MalformedRecipientException {
		when(mock.send("pl", "message")).thenReturn(SendingStatus.SENDING_ERROR);
		assertEquals(messenger.sendMessage("pl", "message"), 1);
		verify(mock).send("pl", "message");
	}
	@Test
	public void sendMessageFailure2() throws MalformedRecipientException {
		when(mock.send(".com", "message")).thenReturn(SendingStatus.SENDING_ERROR);
		assertEquals(messenger.sendMessage(".com", "message"), 1);
		verify(mock).send(".com", "message");
	}
	@Test//(expected = MalformedRecipientException.class)
	public void sendMessageException1() throws MalformedRecipientException {
		when(mock.send(".pl", "message")).thenThrow(new MalformedRecipientException());
		assertEquals(messenger.sendMessage(".pl", "message"), 2);
		verify(mock).send(".pl", "message");
	}
	@Test//(expected = MalformedRecipientException.class)
	public void sendMessageException2() throws MalformedRecipientException {
		when(mock.send("x.pl", "me")).thenThrow(new MalformedRecipientException());
		assertEquals(messenger.sendMessage("x.pl", "me"), 2);
		verify(mock).send("x.pl", "me");
	}
}
