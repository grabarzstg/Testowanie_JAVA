package com.example.mockdemo.app;

import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import com.example.mockdemo.messenger.*;

public class MessengerMockitoTest {

	private MessageService mock;
	private Messenger messenger;
	
	@Before
	public void setUp() {
		mock = mock(MessageService.class);
		messenger = new Messenger(mock);
	}
	
	
	@Test
	public void checkConnection() {
		when(mock.checkConnection("abc.pl")).thenReturn(ConnectionStatus.SUCCESS);
		assertEquals(0, messenger.testConnection("abc.pl"));
		verify(mock).checkConnection("abc.pl"); 
	}
	
	@Test
	public void checkConnectionFail() {
		when(mock.checkConnection("a.pl")).thenReturn(ConnectionStatus.FAILURE);
		assertEquals(1, messenger.testConnection("a.pl"));
		verify(mock).checkConnection("a.pl"); 
	}
	
	@Test
	public void checkSending() throws MalformedRecipientException {
		when(mock.send("abc.pl", "hello")).thenReturn(SendingStatus.SENT);
		assertEquals(0, messenger.sendMessage("abc.pl", "hello"));
		verify(mock).send("abc.pl", "hello"); 
	}
	
	@Test
	public void checkSendingFail() throws MalformedRecipientException {
		when(mock.send("abc.de", "hello")).thenReturn(SendingStatus.SENDING_ERROR);
		assertEquals(1, messenger.sendMessage("abc.de", "hello"));
		verify(mock).send("abc.de", "hello"); 
	}
	
	@Test
	public void checkSendingException() throws MalformedRecipientException {
		when(mock.send("a", "aa")).thenThrow(new MalformedRecipientException());
		assertEquals(2, messenger.sendMessage("a", "aa"));
		verify(mock).send("a", "aa"); 
	}

}
