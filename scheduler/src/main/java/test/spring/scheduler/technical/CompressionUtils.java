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
		
		String temp1K = "public static void main(Stirng[] args]";

		String isEncoding1K = stringToGZipString(temp1K);
		String isDecoding1K = GZIPStringToString(isEncoding1K);

		System.out.println("원문: " + temp1K);
		System.out.println("isEncoding: " + isEncoding1K);
		System.out.println("isDecoding: " + isDecoding1K);

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
