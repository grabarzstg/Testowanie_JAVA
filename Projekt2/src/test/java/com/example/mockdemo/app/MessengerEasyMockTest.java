package com.example.mockdemo.app;
import static org.junit.Assert.*;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;


import org.easymock.EasyMockRule;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.*;

import com.example.mockdemo.messenger.*;

public class MessengerEasyMockTest {

	@Rule
	public EasyMockRule mocks = new EasyMockRule(this);

	@Mock
	private MessageService mock;

	@TestSubject
	private Messenger messenger = new Messenger(mock);

	
	@Test
	public void checkConnection() {
		expect(mock.checkConnection("abc.pl")).andReturn(ConnectionStatus.SUCCESS);
		replay(mock);
		assertEquals(0, messenger.testConnection("abc.pl"));
		verify(mock);
	} 
	
	@Test
	public void checkConnectionFail() {
		expect(mock.checkConnection("abc.pl")).andReturn(ConnectionStatus.FAILURE);
		replay(mock);
		assertEquals(1, messenger.testConnection("abc.pl"));
		verify(mock);
	} 
	
	@Test
	public void checkSending() throws MalformedRecipientException {
		expect(mock.send("abc.pl", "hello")).andReturn(SendingStatus.SENT);
		replay(mock);
		assertEquals(0, messenger.sendMessage("abc.pl", "hello"));
		verify(mock);
	} 	
	
	@Test
	public void checkSendingFail() throws MalformedRecipientException {
		expect(mock.send("abc.de", "hello")).andReturn(SendingStatus.SENDING_ERROR);
		replay(mock);
		assertEquals(1, messenger.sendMessage("abc.de", "hello"));
		verify(mock);
	} 
	
	@Test
	public void checkSendingException() throws MalformedRecipientException {
		expect(mock.send("a", "aa")).andThrow(new MalformedRecipientException());
		replay(mock);
		assertEquals(0, messenger.sendMessage("a", "aa"));
		verify(mock);
	} 
}
