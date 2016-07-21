package config;

import java.util.Properties;

import javax.sql.DataSource;

import model.Category;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.orm.hibernate5.SessionFactoryUtils;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.niit.vig")
@EnableTransactionManagement
public class ApplicationContextConfig {
@Bean(name = "dataSource")
public DataSource getH2DataSource()
{
DriverManagerDataSource dataSource = new DriverManagerDataSource();	
dataSource.setDriverClassName("org.h2.Driver");
dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
dataSource.setUsername("sa");
dataSource.setPassword("sa");
return dataSource;

}
	
private Properties getHibernateProperties()
{
Properties properties=new Properties();
properties.put("hibernate.show_sql","true");
properties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
return properties;
}

@Autowired
@Bean(name="sessionFactory")
public SessionFactory getSessionFactory(DataSource dataSource)
{
LocalSessionFactoryBuilder sessionBuilder=new LocalSessionFactoryBuilder(dataSource);
sessionBuilder.addProperties(getHibernateProperties());
sessionBuilder.addAnnotatedClass(Category.class);
return sessionBuilder.buildSessionFactory();
}

@SuppressWarnings("deprecation")
@Autowired
@Bean(name="transactionManager")
public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
{
 	HibernateTransactionManager transactionManager= new HibernateTransactionManager(sessionFactory);
 	return transactionManager;

}






















	
}
