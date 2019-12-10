package homework_Dao;

import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;

import homework_entity.Order;

public class OrderDao {
	
	public  List<Order> queryAllOrders(){//��ѯδ֧���Ķ���
		
		List<Order> orders = new ArrayList<>();
		String sql = "select * from message where status = 2 and username = ?";
		//jdbcTemplate.queryForObject(sql,new Object[username],Order)
		
	
		return orders;
		
	}
	public boolean updateOrdersStatus(){//�޸Ķ���״̬
		boolean flag = false;
		String sql = "update message set status = 3 where status = 2 and username = ?";
		
		
		return flag;
	}
	public float sum(){
		float sum = 0;
		List<Order> orders = new ArrayList<>();
		orders = queryAllOrders();
		for(Order order:orders){
			sum += order.getPrice()*(float)order.getnumber();
		}
		
		return sum;
	}
	
	public  List<Order> queryAllFinishedOrders(){//��ѯ�����֧���Ķ���
		
		List<Order> orders = new ArrayList<>();
		String sql = "select * from message where status = 3 and username = ?";
		//jdbcTemplate.queryForObject(sql,new Object[username],Order)
		
	
		return orders;
		
	}

}
