package com.example.mockdemo.app;

import static org.junit.Assert.*;

import org.junit.Test;
import com.example.mockdemo.messenger.MalformedRecipientException;


public class SimpleTest {


	MessangerSimpleTest messenger = new MessangerSimpleTest();

	@Test
	public void ConncetionSuccess1() {
		assertEquals(messenger.testConnection("wp.pl"), 0);
	}
	
	@Test
	public void ConncetionSuccess2() {
		assertEquals(messenger.testConnection(".pl"), 0);
	}

	@Test
	public void ConncetionFailure1() {
		assertEquals(messenger.testConnection("pl"), 1);
	}
	
	@Test
	public void ConncetionFailure2() {
		assertEquals(messenger.testConnection(".com"), 1);
	}
	
	@Test
	public void MessageSendSucces1() throws MalformedRecipientException {
		assertEquals(messenger.sendMessage("xyz.pl", "message"), 0);
	}
	@Test
	public void MessageSendSucces2() throws MalformedRecipientException {
		assertEquals(messenger.sendMessage("x.pl", "mes"), 0);
	}
	
	@Test
	public void MessageSendFailure1() throws MalformedRecipientException {
		assertEquals(messenger.sendMessage(".com", "message"), 1);
	}
	
	@Test
	public void MessageSendFailure2() throws MalformedRecipientException {
		assertEquals(messenger.sendMessage("pl", "message"), 1);
	}

	@Test
	public void MessageSendException1() throws MalformedRecipientException {
		assertEquals(messenger.sendMessage(".pl", "message"), 2);
	}
	
	@Test
	public void MessageSendException2() throws MalformedRecipientException {
		assertEquals(messenger.sendMessage("x.pl", "me"), 2);
	}
	
}
