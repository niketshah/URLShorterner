package com.urlshorter.login.service;

import java.util.HashMap;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service("ShortnerURl")
public class ShortnerURl {
	
	private HashMap<String, String> keyMap =new HashMap<>(); 
	private HashMap<String, String> valueMap=new HashMap<>();
	private String prefix;
	private char myChars[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6','7','8','9'}; 
	private Random myRand =new Random(); 
	private int keyLength = 8 ; 
	private String domain="www.pre.ur";


	public String create(String longURL) {
		String shortURL = "";

			longURL = makeValidURL(longURL);
			if (valueMap.containsKey(longURL)) {
				shortURL = domain + "/" + valueMap.get(longURL);
			} else {
				shortURL = domain + "/" + getKey(longURL);
			}
		return shortURL;
	}
	
	
		public String expandURL(String shortURL) {
			String longURL = "";
			String key = shortURL.substring(domain.length() + 1);
			longURL = keyMap.get(key);
			return longURL;
		}

		String makeValidURL(String url) {
			if (url.substring(0, 7).equals("http://"))
				url = url.substring(7);

			if (url.substring(0, 8).equals("https://"))
				url = url.substring(8);

			if (url.charAt(url.length() - 1) == '/')
				url = url.substring(0, url.length() - 1);
			return url;
		}

		private String getKey(String longURL) {
			String key;
			key = generateKey();
			keyMap.put(key, longURL);
			valueMap.put(longURL, key);
			return key;
		}

		private String generateKey() {
			String key = "";
			boolean flag = true;
			while (flag) {
				key = "";
				for (int i = 0; i <= keyLength; i++) {
					key += myChars[myRand.nextInt(62)];
				}
				if (!keyMap.containsKey(key)) {
					flag = false;
				}
			}
			return key;
		}

}
