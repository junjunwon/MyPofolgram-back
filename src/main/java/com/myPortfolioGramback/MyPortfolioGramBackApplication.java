package com.myPortfolioGramback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

@ServletComponentScan
@SpringBootApplication
public class MyPortfolioGramBackApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MyPortfolioGramBackApplication.class, args);
	}

	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		//Max size of one file
		factory.setMaxFileSize(DataSize.parse("1000MB"));
		//Max Size of All files
		factory.setMaxRequestSize(DataSize.parse("1000MB"));
		return factory.createMultipartConfig();
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MyPortfolioGramBackApplication.class);
	}
}
