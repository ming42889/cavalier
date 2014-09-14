package ChartRoom;

import java.io.Serializable;

public class Message implements Serializable{
	private static final long serialVersionUID = 8311338716911018974L;
	private int type;
	private String content;
	protected static final int MESSAGE = 0, LOGOUT = 1, WHOISIN = 2;
	
	public Message(int type){
		this(type, null);
	}
	
	public Message(String content){
		this(0, content);
	}
	
	private Message(int type, String content){
		this.type = type;
		this.content = content;
	}

	public int getType() {
		return type;
	}

	public String getContent() {
		return content;
	}

	
}
