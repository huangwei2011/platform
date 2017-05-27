package org.hw.organization.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;


@Configuration
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class OrmConfig {
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(JpaVendorAdapter jpaVendorAdapter,DataSource datasource)
	{
		
		LocalContainerEntityManagerFactoryBean bean=new LocalContainerEntityManagerFactoryBean();
		bean.setJpaVendorAdapter(jpaVendorAdapter);
		bean.setDataSource(datasource);
		bean.setPackagesToScan("org.hw.organization.domain.entity");
		return bean;
	}
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter()
	{
		HibernateJpaVendorAdapter adapter=new HibernateJpaVendorAdapter();
		adapter.setShowSql(true);
		adapter.setGenerateDdl(true);
		adapter.setDatabase(Database.MYSQL);
		return adapter;
	}
	
	@Bean
	public JpaTransactionManager transactionManager(LocalContainerEntityManagerFactoryBean entityManagerFactory)
	{
		JpaTransactionManager tm=new JpaTransactionManager();
		tm.setEntityManagerFactory(entityManagerFactory.getObject());
		return tm;
	}
	
	@Bean
	public DataSource datasource(){
		ComboPooledDataSource ds=new ComboPooledDataSource();
		try {
			ds.setDriverClass("com.mysql.jdbc.Driver");
			ds.setJdbcUrl("jdbc:mysql://localhost:3306/hw?useUnicode=true&amp;characterEncoding=utf-8");
			ds.setUser("root");
			ds.setPassword("root");
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource datasource)
	{
		LocalSessionFactoryBean sf=new LocalSessionFactoryBean();
		sf.setDataSource(datasource);
		sf.setPackagesToScan("org.hw.organization.domain.entity");
		Properties pro=new Properties();
		pro.setProperty("dialect", "org.hibernate.dialect.H2Dialect");
		pro.setProperty("hibernate.show_sql", "true");
		pro.setProperty("hibernate.format_sql", "true");
		sf.setHibernateProperties(pro);
		return sf;
	}

}
