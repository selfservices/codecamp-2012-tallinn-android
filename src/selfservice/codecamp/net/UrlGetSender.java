package selfservice.codecamp.net;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class UrlGetSender {

	private URLConnection conn;

	public UrlGetSender(String url, Header... headers) throws IOException {
		URL urlObject = new URL(url);
		this.conn = urlObject.openConnection();
		for (Header header: headers) {
			this.conn.setRequestProperty(header.getField(), header.getValue());
		}
	}
	
	public String send() throws IOException {
		try {
			return new Scanner(this.conn.getInputStream()).useDelimiter("\\A").next();
		} catch (java.util.NoSuchElementException e) {
			return "";
		}
	}

}
