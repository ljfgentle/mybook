/**
 * @Title: LableManager.java
 * @Package com.ccx.manager
 * @Description: 
 * @author ljf
 * @date 2021年11月10日
 * @version V1.0
 */
package com.ccx.manager;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.ccx.data.LableMark;

/**
 * @ClassName: LableManager
 * @Description: 
 * @author LJF
 * @date 2021年11月10日
 *
 */
public class LableManager {
	
	private static Set<LableMark> lableMarks = new HashSet<>();
	
	private static Map<String, LableMark> map = new HashMap<>();
	
	private static int currentLableMarkId = 0;
	
	public static List<LableMark> getAll(){
		return lableMarks.stream().collect(Collectors.toList());
	}
	
	public static int getNextId() {
		return currentLableMarkId++;
	}
	
	public static boolean exist(String name) {
		return map.containsKey(name);
	}
	
	public static void addLableMark(LableMark lableMark) {
		map.put(lableMark.getName(), lableMark);
		lableMarks.add(lableMark);
	}

}
