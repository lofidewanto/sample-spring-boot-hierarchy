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
		SpringApplicationBuilder appBuilder1 = new SpringApplicationBuilder().parent(RootContext.class)
				.child(ChildContext1.class);
		SpringApplicationBuilder appBuilder2 = appBuilder1.sibling(ChildContext2.class);

		ConfigurableApplicationContext childApplicationContext2 = appBuilder2.run();
		childApplicationContext2.setId("childContext2");

		ConfigurableApplicationContext childApplicationContext1 = appBuilder1.context();
		childApplicationContext1.setId("childContext1");

		for (String bdn : childApplicationContext1.getBeanDefinitionNames()) {
			logger.info("childApplicationContext1 bdn = " + bdn);
		}

		for (String bdn : childApplicationContext2.getBeanDefinitionNames()) {
			logger.info("childApplicationContext2 bdn = " + bdn);
		}

		ConfigurableApplicationContext parentApplicationContext = (ConfigurableApplicationContext) childApplicationContext2
				.getParent();
		parentApplicationContext.setId("rootContext");

		for (String bdn : parentApplicationContext.getBeanDefinitionNames()) {
			logger.info("parentApplicationContext bdn = " + bdn);
		}
	}
}
