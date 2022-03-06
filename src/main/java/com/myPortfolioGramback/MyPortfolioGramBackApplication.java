package com.myPortfolioGramback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class MyPortfolioGramBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyPortfolioGramBackApplication.class, args);
	}

}
