import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		Socket google = new Socket("google.com", 80);
		InputStream response = google.getInputStream();
		OutputStream request = google.getOutputStream();

		byte[] data = ("GET / HTTP/1.1\n" + "HOST: google.com\n\n").getBytes();

		request.write(data);

		int some;

		while((some = response.read()) != -1) {
			System.out.print((char) some);
		}
	}
}