package ch09;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ex03 {

	//共通の親クラスのIOExceptionで宣言する
	public void process() throws IOException {
		try {
			FileInputStream f = new FileInputStream("aa");
			InetAddress.getLocalHost();
		} catch (FileNotFoundException | UnknownHostException ex) {
			throw ex;
		} catch(IOException e){
			throw e;
		}
	}

}
