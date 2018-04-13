package kohn.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class SshClient {
	public static void main (String [] args) {
		try {
//			SSLSocketFactory factory = (SSLSocketFactory)SSLSocketFactory.getDefault();
//			
//			SSLSocket socket= (SSLSocket)factory.createSocket("12.42.205.38", 22);
//			socket.startHandshake();
			
			Socket socket = new Socket("google.com", 80);
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			out.print("GET / HTTP/1.0\n\n");
			out.flush();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			String inputLine;
			while((inputLine = reader.readLine()) != null) {
				System.out.println(inputLine);
			}
			socket.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
