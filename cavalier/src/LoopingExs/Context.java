package LoopingExs;

public class Context {
	private Object selection;
	
	public Context(Object selection){
		this.selection = selection;
	}

	public Object getSelection() {
		return selection;
	}

	public void setSelection(Object selection) {
		this.selection = selection;
	}
	
}
