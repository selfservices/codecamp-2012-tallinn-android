package selfservice.codecamp.net;

public class Header {
	private String field;
	private String value;
	public Header(String field, String value) {
		this.field = field;
		this.value = value;
	}
	public String getField() {
		return field;
	}
	public String getValue() {
		return value;
	}
	
}
