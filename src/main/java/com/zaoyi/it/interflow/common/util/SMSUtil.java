package com.zaoyi.it.interflow.common.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URLDecoder;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.URI;
import org.apache.commons.httpclient.methods.GetMethod;

/**
 * @author Beyond
 */
public class SMSUtil {

	/**
	 * 
	 * @param url 搴旂敤鍦板潃锛岀被浼间簬http://ip:port/msg/
	 * @param account 璐﹀彿
	 * @param pswd 瀵嗙爜
	 * @param mobile 鎵嬫満鍙风爜锛屽涓彿鐮佷娇鐢�,"鍒嗗壊
	 * @param msg 鐭俊鍐呭
	 * @param needstatus 鏄惁闇�鐘舵�鎶ュ憡锛岄渶瑕乼rue锛屼笉闇�false
	 * @return 杩斿洖鍊煎畾涔夊弬瑙丠TTP鍗忚鏂囨。
	 * @throws Exception
	 */
	public static String send(String url, String account, String pswd, String mobile, String msg,
			boolean needstatus, String product, String extno) throws Exception {
		HttpClient client = new HttpClient();
		GetMethod method = new GetMethod();
		try {
			URI base = new URI(url, false);
			method.setURI(new URI(base, "HttpSendSM", false));
			method.setQueryString(new NameValuePair[] { 
					new NameValuePair("account", account),
					new NameValuePair("pswd", pswd), 
					new NameValuePair("mobile", mobile),
					new NameValuePair("needstatus", String.valueOf(needstatus)), 
					new NameValuePair("msg", msg),
					new NameValuePair("product", product), 
					new NameValuePair("extno", extno), 
				});
			int result = client.executeMethod(method);
			if (result == HttpStatus.SC_OK) {
				InputStream in = method.getResponseBodyAsStream();
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				byte[] buffer = new byte[1024];
				int len = 0;
				while ((len = in.read(buffer)) != -1) {
					baos.write(buffer, 0, len);
				}
				return URLDecoder.decode(baos.toString(), "UTF-8");
			} else {
				throw new Exception("HTTP ERROR Status: " + method.getStatusCode() + ":" + method.getStatusText());
			}
		} finally {
			method.releaseConnection();
		}

	}

	/**
	 * 
	 * @param url 搴旂敤鍦板潃锛岀被浼间簬http://ip:port/msg/
	 * @param account 璐﹀彿
	 * @param pswd 瀵嗙爜
	 * @param mobile 鎵嬫満鍙风爜锛屽涓彿鐮佷娇鐢�,"鍒嗗壊
	 * @param msg 鐭俊鍐呭
	 * @param needstatus 鏄惁闇�鐘舵�鎶ュ憡锛岄渶瑕乼rue锛屼笉闇�false
	 * @return 杩斿洖鍊煎畾涔夊弬瑙丠TTP鍗忚鏂囨。
	 * @throws Exception
	 */
	public static String batchSend( String mobile, String msg) throws Exception {
		HttpClient client = new HttpClient();
		GetMethod method = new GetMethod();
		try {
			URI base = new URI(SMSConfig.URL, false);
			method.setURI(new URI(base, "HttpBatchSendSM", false));
			method.setQueryString(new NameValuePair[] { 
					new NameValuePair("account", SMSConfig.ACCOUNT),
					new NameValuePair("pswd", SMSConfig.PASSWORD), 
					new NameValuePair("mobile", mobile),
					new NameValuePair("needstatus", String.valueOf(false)), 
					new NameValuePair("msg", msg),
					new NameValuePair("product", null),
					new NameValuePair("extno", null), 
				});
			int result = client.executeMethod(method);
			if (result == HttpStatus.SC_OK) {
				InputStream in = method.getResponseBodyAsStream();
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				byte[] buffer = new byte[1024];
				int len = 0;
				while ((len = in.read(buffer)) != -1) {
					baos.write(buffer, 0, len);
				}
				return URLDecoder.decode(baos.toString(), "UTF-8");
			} else {
				throw new Exception("HTTP ERROR Status: " + method.getStatusCode() + ":" + method.getStatusText());
			}
		} finally {
			method.releaseConnection();
		}

	}
}