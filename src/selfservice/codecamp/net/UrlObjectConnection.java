package selfservice.codecamp.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.net.URLConnection;

public class UrlObjectConnection {

	private URLConnection conn;
	
	public UrlObjectConnection(String url) throws IOException {
		URL urlObject = new URL(url);
		this.conn = urlObject.openConnection();
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getObject() throws IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(this.conn.getInputStream());
		return (T) ois.readObject();
	}
	
}
