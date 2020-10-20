package sakila.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import sakila.service.StatsService;


@WebListener
public class StatsListener implements HttpSessionListener {
	private StatsService statsService;
	
    public StatsListener() {
       
    }

    public void sessionCreated(HttpSessionEvent se)  {  //session 생성됐을때
         if(se.getSession().isNew()) { //session을 받고 처음으로 일어난 session인지 기존이 있던session인지 확인
        	 	//새로운 session이 발생할 때 
        	 statsService = new StatsService();
        	 statsService.countStats();
         }
    }

    public void sessionDestroyed(HttpSessionEvent se)  {  //session 삭제됐을때
        
    }
	
}
