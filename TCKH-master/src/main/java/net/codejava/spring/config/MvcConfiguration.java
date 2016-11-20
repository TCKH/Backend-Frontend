package net.codejava.spring.config;
import javax.sql.DataSource;

import net.codejava.spring.dao.CategoryDAO;
import net.codejava.spring.dao.CategoryDAOImpl;
import net.codejava.spring.dao.CommentDAO;
import net.codejava.spring.dao.CommentDAOImpl;
import net.codejava.spring.dao.ContactDAO;
import net.codejava.spring.dao.ContactDAOImpl;
import net.codejava.spring.dao.PostDAO;
import net.codejava.spring.dao.PostDAOImpl;
import net.codejava.spring.dao.UserDAO;
import net.codejava.spring.dao.UserDAOImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages="net.codejava.spring")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter{

	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/tckh");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		
		return dataSource;
	}
	@Bean(name = "multipartResolver")
    public MultipartResolver getMultipartResolver() {
        CommonsMultipartResolver resover = new CommonsMultipartResolver();
        // 1MB
        resover.setMaxUploadSize(1 * 1024 * 1024);
 
        return resover;
    }
	@Bean
	public ContactDAO getContactDAO() {
		return new ContactDAOImpl(getDataSource());
	}
	@Bean
	public PostDAO getPostDAO(){
		return new PostDAOImpl(getDataSource());
	}
	@Bean
	public UserDAO getUserDAO(){
		return new UserDAOImpl(getDataSource());
	}
	@Bean
	public CommentDAO getCommentDAO(){
		return new CommentDAOImpl(getDataSource());
	}
	@Bean
	public CategoryDAO getCategoryDAO(){
		return new CategoryDAOImpl(getDataSource());
	}
}
