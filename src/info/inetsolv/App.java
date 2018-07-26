package info.inetsolv;

import java.io.FileInputStream;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) throws Exception {
		Properties properties = new Properties();
		properties.load(new FileInputStream("hibernate.properties"));

		Configuration configuration = new Configuration();
		configuration.addProperties(properties);
		configuration.addAnnotatedClass(Employee.class);

		SessionFactory sf=configuration.buildSessionFactory();
		Session session=sf.openSession();

		Employee e=new Employee();
		session.load(e, 20);
		System.out.println(e.getEname());

		session.close();
		sf.close();
	}
}