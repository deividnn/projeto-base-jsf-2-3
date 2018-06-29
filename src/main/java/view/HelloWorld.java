package view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.Message;
import service.MessageService;

@Named
@RequestScoped
public class HelloWorld implements Serializable {
	private static final long serialVersionUID = 5982358446225235505L;

	private Message msg= new Message();
	private List<Message> messages;

	@Inject
	private MessageService messageService;

	@PostConstruct
	public void init() {
		messages = messageService.list();
	}

	public void submit() {
		messageService.create(msg);
		messages.add(msg);
	}

	public Message getMsg() {
		return msg;
	}

	public List<Message> getMessages() {
		return messages;
	}
	
	
}