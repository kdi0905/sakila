package sakila.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class DBListener implements ServletContextListener {


    public DBListener() {
      
    }

    public void contextDestroyed(ServletContextEvent sce)  { //톰켓종료할대 자동으로 실행
       
    }

    public void contextInitialized(ServletContextEvent sce)  {  // 톰켓실행할때 자동으로 실행
       System.out.println("DBListener.contextInitialized() 구동실행 ");
       
       try {
       Class.forName("org.mariadb.jdbc.Driver"); 
       System.out.println("mariadb 드라이브로딩 성공");
       }catch(ClassNotFoundException e){
    	   System.out.println("Class.forName()구동 실패 ");
    	   e.printStackTrace();
       }
    }
	
}
