package homework_servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homework_entity.Order;
import zbl_homework_Service.OrderService;


@WebServlet("/Order_finished")
public class Order_finished extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Order_finished() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		OrderService oService = new OrderService();
		boolean flag = oService.updateOrdersStatus();
		if(flag){
			//֧���ɹ��������޸ĳɹ�����������������ת��֧���ɹ�ҳ��
		}else{
			//֧��ʧ�ܣ��޸�����ʧ�ܣ���������������ת��֧��ʧ��ҳ������
		}
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
