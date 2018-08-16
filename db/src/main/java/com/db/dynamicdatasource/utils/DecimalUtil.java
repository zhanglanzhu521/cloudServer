package com.db.dynamicdatasource.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @Title :
 * @Description :
 * @Author : zhanglz
 * @Date : 2018-08-17 0:49
 */
public class DecimalUtil {
	public static void main(String[] args) {
		DecimalFormat ddd = new DecimalFormat();
		ddd.applyPattern("#.##");
		Float ddsd=0.057001f;
		System.out.println(new BigDecimal(0.057001).setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue());// 0.23

		System.out.println(ddd.format(ddsd));
		DecimalFormat formater = new DecimalFormat("#0.##");
		formater.setRoundingMode(RoundingMode.FLOOR);
		System.out.println(formater.format(ddsd));
	}
}
