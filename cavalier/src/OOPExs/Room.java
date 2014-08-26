package OOPExs;

public class Room {
	private int roomno;
	private String roomtype;
	private double roomarea;
	private Object ACmachine;
	

	public Object getACmachine() {
		return ACmachine;
	}

	public void setACmachine(int aCmachine) {
		ACmachine = aCmachine;
	}

	public double getRoomarea() {
		return roomarea;
	}

	public void setRoomarea(double roomarea) {
		this.roomarea = roomarea;
	}

	public String getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public int getRoomno() {
		return roomno;
	}

	public void setRoomno(int roomno) {
		this.roomno = roomno;
	}
	
	

}
