package string;

public class P468 {
	public static void main(String[] args) {
//		String IP="172.16.254.1";
//		String IP="256.256.256.256";
//		String IP="172.16.254.01";
//		String IP="2001:0db8:85a3:0:0:8A2E:0370:7334";
//		String IP="2001:0db8:85a3:0:0:8A2E:0370:7334:";
//		String IP="12..33.4";
//		String IP="15.16.-0.1";
		String IP="192.0.0.1";
		System.out.println(validIPAddress(IP));
	}
	public static boolean validIPv4(String[] addresses) {
		int num=0;
		for (String address : addresses) {
			if(address.length()==0||address.length()>4)
				return false;
			else if(address.length()>1&&address.charAt(0)=='0')
				return false;
			for(int i=0;i<address.length();i++)
				if(!Character.isDigit(address.charAt(i)))
					return false;
			try {
				num=Integer.parseInt(address);
			} catch (Exception e) {
				return false;
			}
			if(num<0||num>255)
				return false;
		}
		return true;
	}
	public static boolean validIPv6(String[] addresses) {
		String letters="abcdefABCDEF";
		for (String address : addresses) {
			if(address.length()==0||address.length()>4)
				return false;
			if(address.length()>1&&address.charAt(0)==0&&address.charAt(1)==0)
				return false;
			for(int i=0;i<address.length();i++) {
				if(!Character.isDigit(address.charAt(i))) {
					if(!letters.contains(Character.toString(address.charAt(i))))
						return false;
				}
			}
			
		}
		return true;
	}
	public static String validIPAddress(String IP) {
		
		if(IP.contains(".")) {
			if(IP.charAt(IP.length()-1)=='.')
				return "Neither";
			String[] addresses=IP.split("\\.");
			if(addresses.length!=4)
				return "Neither";
			boolean result=validIPv4(addresses);
			if(result)
				return "IPv4";
			else
				return "Neither";
		}
		else if(IP.contains(":")) {
			if(IP.charAt(IP.length()-1)==':')
				return "Neither";
			String[] addresses=IP.split(":");
//			System.out.println(addresses.length);
			if(addresses.length!=8)
				return "Neither";
			boolean result=validIPv6(addresses);
			if(result)
				return "IPv6";
			else
				return "Neither";
		}else
			return "Neither";
			
    }
}
