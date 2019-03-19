package leetcode;

import java.util.HashMap;

public class TinyUrl {
    HashMap<Integer, String> map = new HashMap<Integer, String>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
	int hashCode = longUrl.hashCode();
	map.put(hashCode, longUrl);
	return "http://tinyurl.com/" + hashCode;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
	int hashCode = Integer.parseInt(shortUrl.replace("http://tinyurl.com/", ""));
	return map.get(hashCode);
    }
}
