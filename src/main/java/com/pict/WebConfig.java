package com.pict;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class WebConfig 	extends WebMvcConfigurerAdapter {

	    @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler(
	                "/webjars/**",
	                "/imgs/**",
	                "/css/**",
	                "/js/**",
	                "/less/**",
	                "/jquery/**")
	                .addResourceLocations(
	                        "classpath:/META-INF/resources/webjars/",
	                        "classpath:/com/pict/imgs/",
	                        "classpath:/com/pict/css/",
	                        "classpath:/com/pict/js/",
	                        "classpath:/com/pict/less/",
	                        "classpath:/com/pict/jquery/");
	    }
	    
	    @Override
		public void addInterceptors(InterceptorRegistry registry) {
		    registry.addInterceptor(new ThymeleafLayoutInterceptor());
		}
	    
	 /*   @Override
	    public void addViewControllers(ViewControllerRegistry registry) {
	        registry.addViewController("/home").setViewName("home");
	        registry.addViewController("/").setViewName("home");
	        registry.addViewController("/hello").setViewName("hello");
	        registry.addViewController("/login").setViewName("login");
	    }*/

}