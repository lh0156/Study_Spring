package test.spring.scheduler.technical;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.apache.commons.codec.binary.Base64;

@Slf4j
public class CompressionUtils {

	public static void main(String[] args) {

		String temp1 = "1";

		String temp2 = temp1 + temp1;


		String temp10 = "";

		for(int i=0; i<10; ++i) {
			temp10 += temp1;
		}

		String temp100 = "";

		for(int i=0; i<10; ++i) {
			temp100 += temp10;
		}

		String temp1000 = "";

		for(int i=0; i<10; ++i) {
			temp1000 += temp100;
		}

		String temp2000 = temp1000 + temp1000;
		String temp10000 = "";

		for(int i=0; i<10; ++i) {
			temp10000 += temp1000;
		}

		String temp20000 = temp10000 + temp10000;
		String temp100000 = temp20000 + temp20000 + temp20000 + temp20000 + temp20000;

		String temp1000000 = "";

		for(int i=0; i<10; ++i) {
			temp1000000 += temp100000;
		}

		String isEncoding1K = stringToGZipString(temp20000);
		String isDecoding1K = GZIPStringToString(isEncoding1K);

		System.out.println("원문: " + temp20000.length());
		System.out.println("isEncoding: " + isEncoding1K.length());
		System.out.println("isDecoding: " + isDecoding1K.length());

	}


	public static String stringToGZipString(String plainSoruce) {
		if(!StringUtils.isEmpty(plainSoruce)) {
			try {
				// Byte로 내보내기 위한 Output
				ByteArrayOutputStream bytesOut = new ByteArrayOutputStream();
				GZIPOutputStream gos = new GZIPOutputStream(bytesOut);
				gos.write(plainSoruce.getBytes());
				
				bytesOut.close();
				gos.close();

				Base64 base64 = new Base64();
				plainSoruce = new String(base64.encode(bytesOut.toByteArray()));


			} catch (IOException e) {
				log.error(e.getMessage(), e);
			}
		}
		
		return plainSoruce;
	}
	
	public static String GZIPStringToString(String gzipSoruce) {
		StringBuilder sb = new StringBuilder();
		if(!StringUtils.isEmpty(gzipSoruce)) {
			try {

				Base64 base64 = new Base64();
				byte[] decodeBuffer = base64.decode(gzipSoruce.getBytes());
				GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(decodeBuffer));
		        BufferedReader bf = new BufferedReader(new InputStreamReader(gis));
		        
		        sb = new StringBuilder();
		        String line;
		        while ((line = bf.readLine()) != null) {
		        	sb.append(line);
		        }
		        
		        bf.close();
		        gis.close();
			} catch (IOException e) {
				log.error(e.getMessage(), e);
			}
		}
		
		return sb.toString();
	}

}
