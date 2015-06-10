package com.example.mockdemo.app;

import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.SendingStatus;

public class MessangerSimpleTest implements MessageService {

	@Override
	public ConnectionStatus checkConnection(String server) {
		if (server.endsWith(".pl")) return ConnectionStatus.SUCCESS;
		else return ConnectionStatus.FAILURE;
	}

	
	@Override
	public SendingStatus send(String server, String message)
			throws MalformedRecipientException {
		int lenServer, lenMessage;
		lenServer = server.length();
		lenMessage = message.length();
		if(checkConnection(server) == ConnectionStatus.FAILURE) return SendingStatus.SENDING_ERROR;
		else if(lenServer < 4 || lenMessage < 3) 
			throw new MalformedRecipientException();
		else return SendingStatus.SENT;
	}

	public int testConnection(String server) {
		switch (checkConnection(server)) {
		case FAILURE:
			return 1;
		case SUCCESS:
			return 0;
		}
		return 1;
	}

	public int sendMessage(String server, String message) {

		int result = -1;

		try {
			SendingStatus sStatus = send(server, message);
			switch (sStatus) {
			case SENT:
				result = 0;
				break;
			case SENDING_ERROR:
				result = 1;
				break;
			default:
				result = -1;
			}

		} catch (MalformedRecipientException e) {
			result = 2;
		}
		return result;
	}
	
	
}
