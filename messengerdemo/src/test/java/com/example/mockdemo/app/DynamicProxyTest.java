package com.example.mockdemo.app;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;


import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.MessageServiceSimpleImpl;
import com.example.mockdemo.messenger.SendingStatus;


public class DynamicProxyTest {

	InvocationHandler ih = new MessangerHandler();
	MessageService messMock = (MessageService) Proxy.newProxyInstance(
	MessageService.class.getClassLoader(),
	new Class[] { MessageService.class }, ih);
	
	Messenger messenger = new Messenger(messMock);
	
	
	@Test
	public void testConnectionSuccess1() {
		assertEquals(messenger.testConnection(".pl"),0);
	}
	@Test
	public void testConnectionSuccess2() {
		assertEquals(messenger.testConnection("inf.pl"),0);
	}
	@Test
	public void testConnectionFailure1() {
		assertEquals(messenger.testConnection(".com"),1);
	}
	@Test
	public void testConnectionFailure2() {
		assertEquals(messenger.testConnection("pl"),1);
	}

	@Test
	public void sendMessageSuccess1() {
		assertEquals(messenger.sendMessage("xyz.pl", "message"), 0);
	}
	@Test
	public void sendMessageSuccess2() {
		assertEquals(messenger.sendMessage("x.pl", "mes"), 0);
	}
	@Test
	public void sendMessageFailure1() {
		assertEquals(messenger.sendMessage("pl", "mess"), 1);
	}
	@Test
	public void sendMessageFailure2() {
		assertEquals(messenger.sendMessage(".com", "mess"), 1);
	}
	@Test
	public void sendMessageException1() {
		assertEquals(messenger.sendMessage(".pl", "mes"), 2);
	}
	@Test
	public void sendMessageException2() {
		assertEquals(messenger.sendMessage("x.pl", "me"), 2);
	}
	
	public class MessangerHandler implements InvocationHandler {

		@Override
		public Object invoke(Object proxy, Method method, Object[] args)
				throws Throwable {
			
			//ConnectionStatus checkConnection(String server);
			if ("checkConnection".equals(method.getName())) {
				if (args[0].toString().endsWith(".pl")) return ConnectionStatus.SUCCESS;
				else return ConnectionStatus.FAILURE;
			}	
			//SendingStatus send(String server, String message) throws MalformedRecipientException;
			if ("send".equals(method.getName())) {
				if (args[0].toString().endsWith(".pl")){
					if(args[0].toString().length() < 4 || args[1].toString().length() < 3) throw new MalformedRecipientException();
					else return SendingStatus.SENT;
				}
				else return SendingStatus.SENDING_ERROR;
			}
			return null;

		}

	}
	
}
