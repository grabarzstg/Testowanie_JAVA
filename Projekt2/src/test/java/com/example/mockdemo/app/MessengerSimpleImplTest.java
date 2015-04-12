package com.example.mockdemo.app;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.mockdemo.messenger.*;

public class MessengerSimpleImplTest {

	@Test
	public void checkConnection() {
		MessageServiceSimpleImpl mock = new MessageServiceSimpleImpl();
		Messenger messenger = new Messenger(mock);
		assertEquals(0, messenger.testConnection("abc.pl"));
	}
	
	@Test
	public void checkConnectionFailure() {
		MessageServiceSimpleImpl mock = new MessageServiceSimpleImpl();
		Messenger messenger = new Messenger(mock);
		assertEquals(1, messenger.testConnection("abc.de"));
	}
	
	@Test
	public void checkSending() {
		MessageServiceSimpleImpl mock = new MessageServiceSimpleImpl();
		Messenger messenger = new Messenger(mock);
		assertEquals(0, messenger.sendMessage("abc.pl", "hello"));
	}
	
	@Test
	public void checkSendingFailure() {
		MessageServiceSimpleImpl mock = new MessageServiceSimpleImpl();
		Messenger messenger = new Messenger(mock);
		assertEquals(1, messenger.sendMessage("a.de", "hello"));
	}
	
	@Test
	public void checkSendingException() {
		MessageServiceSimpleImpl mock = new MessageServiceSimpleImpl();
		Messenger messenger = new Messenger(mock);
		assertEquals(2, messenger.sendMessage("a", "hello"));
	}
	
}
