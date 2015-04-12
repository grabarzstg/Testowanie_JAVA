package com.example.mockdemo.app;
import static org.junit.Assert.*;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

import com.example.mockdemo.messenger.*;

public class MessengerProxyTest {

	
	@Test
	public void checkConnection() {
		InvocationHandler ih = new MessageServiceHandler();
		MessageService msMock = (MessageService) Proxy.newProxyInstance(
				MessageService.class.getClassLoader(), new Class[] { MessageService.class }, ih);
		
		Messenger messenger =  new Messenger(msMock);
		assertEquals(0, messenger.testConnection("abc.pl"));
	}
	
	@Test
	public void checkSending() {
		InvocationHandler ih = new MessageServiceHandler();
		MessageService msMock = (MessageService) Proxy.newProxyInstance(
				MessageService.class.getClassLoader(), new Class[] { MessageService.class }, ih);
		
		Messenger messenger =  new Messenger(msMock);
		assertEquals(0, messenger.sendMessage("abc.pl", "hello"));
	}
	
	class MessageServiceHandler implements InvocationHandler {

		@Override
		public Object invoke(Object proxy, Method method, Object[] args)
				throws Throwable {
			if ("checkConnection".equals(method.getName())) {
				return ConnectionStatus.SUCCESS;
			}
			if ("send".equals(method.getName())) {
				return SendingStatus.SENT;
			}
			return 0.0;
		}
	}
}
