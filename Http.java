package com.lepus.netty.proxy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Http {

	public static void main(String[] args){
		go();
	}
	
	public static void go(){
		try {
			URL url = new URL("https://www.baidu.com/s?wd=HttpURLConnection%20https&rsv_spt=1&rsv_iqid=0x8986388400009cad&issp=1&f=8&rsv_bp=0&rsv_idx=2&ie=utf-8&tn=baiduhome_pg&rsv_enter=1&rsv_n=2&rsv_sug3=7&rsv_sug1=7&rsv_sug7=100&rsv_sug2=0&inputT=3801&rsv_sug4=3801");
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();	
			conn.setRequestMethod("GET");
			conn.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.106 Safari/537.36");
			conn.setInstanceFollowRedirects(false);
			conn.connect();
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = null;
			while((line = reader.readLine()) != null){
				System.out.println(line);
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
