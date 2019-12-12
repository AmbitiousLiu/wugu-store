package com.wugu.store.service;

import com.alibaba.fastjson.JSON;
import com.wugu.store.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.Cookie;

@Service
public class OrderService {

    private OrderDao orderDao;
    private RestTemplate restTemplate;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public String select(Cookie[] cookies) {
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("sessionID".equals(cookie.getName())) {
                    String sessionID = cookie.getValue();
                    String userName = restTemplate.postForObject("http://localhost:8050/login/getLogin", sessionID, String.class);
                    if (userName != null) {
                        return JSON.toJSONString(orderDao.select(userName));
                    }
                }
            }
        }
        return null;
    }

    public boolean pay(Cookie[] cookies) {
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("sessionID".equals(cookie.getName())) {
                    String sessionID = cookie.getValue();
                    String userName = restTemplate.postForObject("http://localhost:8050/login/getLogin", sessionID, String.class);
                    if (userName != null) {
                        return orderDao.pay(userName);
                    }
                }
            }
        }
        return false;
    }

    public boolean add(Cookie[] cookies, String phoneName) {
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("sessionID".equals(cookie.getName())) {
                    String sessionID = cookie.getValue();
                    String userName = restTemplate.postForObject("http://localhost:8050/login/getLogin", sessionID, String.class);
                    if (userName != null) {
                        return orderDao.add(userName, phoneName);
                    }
                }
            }
        }
        return false;
    }

    public boolean createOrder(String messageID) {
        return orderDao.createOrder(messageID);
    }
}
