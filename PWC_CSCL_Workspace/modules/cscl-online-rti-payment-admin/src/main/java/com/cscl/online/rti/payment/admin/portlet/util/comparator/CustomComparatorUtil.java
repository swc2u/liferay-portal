package com.cscl.online.rti.payment.admin.portlet.util.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.cscl.online.rti.payment.admin.portlet.util.comparator.CustomComparator;

public class CustomComparatorUtil {
	
	public static OrderByComparator getOrderByComparator(String orderByCol, String orderByType) {
		boolean orderByAsc = false;
		if (Validator.isNull(orderByType)) {
			orderByType = "asc";
		}
		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}
		System.out.println("Comparator Util..."+orderByType);
		return new CustomComparator(orderByAsc, orderByCol);
	}
}
