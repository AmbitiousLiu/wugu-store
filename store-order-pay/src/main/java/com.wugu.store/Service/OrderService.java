package zbl_homework_Service;

import java.util.List;

import homework_Dao.OrderDao;
import homework_entity.Order;

public class OrderService {
	OrderDao orderDao = new OrderDao();
	public List<Order> queryAllOrders(){//��ѯ���ݿⶩ��Ϊδ֧���Ķ���
		return orderDao.queryAllOrders();
	}
	public boolean updateOrdersStatus(){//������ɺ��޸����ݿ�Ķ���״̬
		 return orderDao.updateOrdersStatus();
		
	}
	public float sum(){
		
		return orderDao.sum();
	}

	

}
