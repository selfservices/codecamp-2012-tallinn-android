package selfservice.codecamp.net;

import selfservice.codecamp.net.UrlGetSender.Header;

public class UrlTester {

	public static void main(String... args) throws Exception {
		Object[][] objects = new UrlObjectConnection("http://172.17.37.69:8080/task3/puzzle").getObject();
		for (Object[] objectRow: objects) {
			for (Object object: objectRow) {
				byte[] bytes = (byte[]) object;
				System.out.println(bytes.length);
			}

		}
		String o = new UrlGetSender("http://172.17.37.69:8080/task3/solution/foo", new Header("teamId", "test")).send();
		System.out.println(o);
	}

}
