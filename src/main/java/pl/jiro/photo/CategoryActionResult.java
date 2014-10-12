package pl.jiro.photo;

public class CategoryActionResult {
	
	private boolean type; //change to enum
	private String message;
	
	public CategoryActionResult() {}
	
	public CategoryActionResult(String mess) {
		this.message = mess;
	}
	
	public boolean getType() {
		return type;
	}
	
	public void setType(boolean type) {
		this.type = type;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}