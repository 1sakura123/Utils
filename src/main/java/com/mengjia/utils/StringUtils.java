package com.mengjia.utils;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
		判断源字符串是否有值，空引号也算没值	String 源字符串	boolean	null = false
		"" = false
		判断源字符串是否有值，空引号和空格也算没值	String 源字符串	boolean	null = false
		"" = false
		" " = false
		判断是否为手机号码	String 源字符串	boolean	null = false
		" " = false
		"13800138000" = true
		"19203604281" = false
 */
public class StringUtils {
	
	/**
     * 判断是否为空字符串最优代码
     * @param str
     * @return 如果为空，则返回true
     */
    public static boolean isEmpty(String str){
        return str == null || str.trim().length() == 0;
    }
    
    
    /**
	 * 功能说明：判断字符串的值是不是数字<br>
	 * @param validString
	 * @return
	 * boolean
	 */
	public static boolean isNumber(String validString){
		if(!hasText(validString)){
			return false;
		}
		byte[] tempbyte = validString.getBytes();
		for(int i = 0; i < validString.length(); i++){
			if( ( tempbyte[i] == 45 ) && ( i == 0 ) ){
				continue;
			}
			if((tempbyte[i] < 48) || (tempbyte[i] > 57)){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String str = "* Because TreeNodes are about twice the size of regular nodes, we"+
     "* use them only when bins contain enough nodes to warrant use"+
     "* (see TREEIFY_THRESHOLD). And when they become too small (due to"+
     "* removal or resizing) they are converted back to plain bins.  In"+
     "* usages with well-distributed user hashCodes, tree bins are"+
     "* rarely used.  Ideally, under random hashCodes, the frequency of"+
    " * nodes in bins follows a Poisson distribution"+
    " * (http://en.wikipedia.org/wiki/Poisson_distribution) with a"+
     "* parameter of about 0.5 on average for the default resizing"+
    " * threshold of 0.75, although with a large variance because of"+
    " * resizing granularity. Ignoring variance, the expected"+
    " * occurrences of list size k are (exp(-0.5) * pow(0.5, k) /"+
    " * factorial(k)). The first values are";
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		char[] arr = str.toCharArray();
		 for (char c : arr) {
			 map.put(c, !map.containsKey(c)?1:(map.get(c)+1));
		 }
		 for (Character c : map.keySet()) {
			 System.out.println(c+":"+map.get(c));
		 }
		 
	}
	
	/**
	 * 功能说明：判断字符串是否有值，空白字符串和空格也不算<br>
	 * @param src
	 * @return
	 * boolean
	 */
	public static boolean hasText(String src){
		return src != null && src.trim().length() > 0;
	}
	

	/**
	 * 手机号验证
	 * @param str
	 * @return
	 */
	public static boolean isPhone(String str){
		
		String reg = "1[3|5|6|7|8|9]\\d{9}";
		
		return str.matches(reg);
		
	}
	
	/**
	 * 邮箱验证
	 * @param str
	 * @return
	 */
	public static boolean isEmail(String str){
		String reg = "\\w+@\\w+(.com|.cn)";
		return str.matches(reg);
	}
	/*
	*
	*/
	public static boolean isEmpty(Collection c){
		return c.isEmpty();
	}
	
	/*
	*判断参数是否为数字，包含小数
	*/
	public static boolean isFloat(String str){
		boolean blank = StringUtils.isEmpty(str);
		if(!blank){
			Pattern pattern = Pattern.compile("^(\\d+\\.?\\d+|\\d*)$");
			Matcher matcher = pattern.matcher(str);
			if(matcher.matches()){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	public static String getNumber(int length){
	Random random = new Random();
	StringBuffer result = new StringBuffer();
	char[] words = {'1','2','3','4','5','6','7','8','9','0'};
	for(int i = 0 ; i < length ; i++){
		int index = random.nextInt(10);
		String word = words[index] + "";
		if(!StringUtils.isNumber(word)){
			int bigorsmall = random.nextInt();
			if(bigorsmall % 2 == 0){
				word = word.toLowerCase();
			}
		}
		result.append(word);
	}
	
		return result.toString();
	}
		

	/** 随机一个时间  param:int类型的年份，随机日期在该年份之后
	 * @throws ParseException */
	public static Date getRandomDate(int year,String str) throws ParseException{
			Calendar now = Calendar.getInstance();
			int nowYear = now.get(Calendar.YEAR);
			int nowMouth = now.get(Calendar.MONTH)+1;
			int nowDay = now.get(Calendar.DATE);

			Calendar calendar = DateUtils.stringToCalendar(str);
			
			calendar.set(Calendar.YEAR, year+(int)(Math.random()*(nowYear-year)+1));
			
			return calendar.getTime();
			

	}
	
	
	public Integer RandomUtil(Integer start,Integer end){
		
		Integer num = 0;
		
		while (true) {
			Integer endm = (int) (Math.random()*end+1);
			if(endm >=start && endm <=end){
				num = endm;
				break;
			}
		}
		
		return num;
		
}
}
