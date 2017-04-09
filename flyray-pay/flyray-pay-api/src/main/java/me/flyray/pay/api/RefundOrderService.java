package me.flyray.pay.api;

import java.util.List;
import java.util.Map;

import me.flyray.pay.model.RefundOrder;

/** 
* @author: bolei
* @date：2017年3月18日 下午11:20:50 
* @description：退款订单
*/

public interface RefundOrderService {

	List<RefundOrder> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(RefundOrder refundOrder);
	
	void update(RefundOrder refundOrder);
	
	void deleteBatch(Long[] ids);
}