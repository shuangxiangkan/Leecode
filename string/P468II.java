package string;

import java.util.regex.Pattern;

public class P468II {
	public static void main(String[] args) {
//		String IP="172.16.254.1";
//		String IP="256.256.256.256";
//		String IP="172.16.254.01";
		String IP="2001:0db8:85a3:0:0:8A2E:0370:7334";
		System.out.println(validIPAddress(IP));
	}
	public static String validIPAddress(String IP) {
		
		if(IP.contains(".")) {
			String regexIPv4="[0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5]";
			String[] ips=IP.split("\\.");
			if(IP.endsWith(".")||ips.length!=4)
				return "Neither";
			for (String ip : ips) {
				if(!ip.matches(regexIPv4))
					return "Neither";
			}
			return "IPv4";
		}else if(IP.contains(":")) {
			String regexIPv6="[0-9a-fA-F]{1,4}";
			String[] ips=IP.split(":");
			if(IP.endsWith(":")||ips.length!=8)
				return "Neither";
			for (String ip : ips) {
				if(!ip.matches(regexIPv6))
					return "Neither";
			}
			return "IPv6";
		}else
			return "Neither";
	}
}
