package echo01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		
		//서버 소켓 객체 생성
		ServerSocket serverSocket = new ServerSocket();
		
		serverSocket.bind(new InetSocketAddress("", 10001)); //(ip, port)"
		//ip 주소는 cmd>ipconfig 통해서 확인
		//ip는 문자열임
		//재부팅시 ip주소가 변경될 수도 있기 때문에, 그때그때 확인해 줄 것
		//포트 번호는 본인이 정하면 되지만, 타인과 겹치면 안됨ㅋㅋ
		
		System.out.println("<서버시작>");
		System.out.println("================================================");
		System.out.println("[연결을 기다리고 있습니다.]");
		
		Socket socket = serverSocket.accept();
		System.out.println("[클라이언트가 연결되었습니다.]");
		
		
		
		//메세지 받기용 스트림
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		
		//메세지 보내기용 스트림
		OutputStream os = socket.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);
		
		
		//
		while (true) {
			// 메세지 받기
			String msg = br.readLine();

			if (msg == null) {
				break;
			}

			System.out.println("받은메세지: " + msg);

			// 메세지 보내기
			bw.write(msg);
			bw.newLine();
			bw.flush();
		}
		
		
		
		
		
		/*
		//메세지 받기
		String msg = br.readLine();
		System.out.println("받은메세지: " + msg);
		
		//메세지 보내기
		bw.write(msg);
		bw.newLine();
		bw.flush();
		*/
		
		
		System.out.println("===========================");
		System.out.println("<서버종료>");

		bw.close();
		br.close();
		socket.close();
		serverSocket.close();
	}

}
