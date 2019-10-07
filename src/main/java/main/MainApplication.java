package main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import child1.ChildContext1;
import child2.ChildContext2;
import root.RootContext;

public class MainApplication {

	private static final Logger logger = LoggerFactory.getLogger(MainApplication.class);

	public static void main(String[] args) {
		SpringApplicationBuilder appBuilder = new SpringApplicationBuilder().parent(RootContext.class)
				.child(ChildContext1.class).sibling(ChildContext2.class);

		ConfigurableApplicationContext applicationContext = appBuilder.run();
		applicationContext.setId("childContext2");

		for (String bdn : applicationContext.getBeanDefinitionNames()) {
			logger.info("applicationContext bdn = " + bdn);
		}

		ConfigurableApplicationContext parentApplicationContext = (ConfigurableApplicationContext) applicationContext
				.getParent();
		parentApplicationContext.setId("rootContext");

		for (String bdn : parentApplicationContext.getBeanDefinitionNames()) {
			logger.info("parentApplicationContext bdn = " + bdn);
		}
	}
}
