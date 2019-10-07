package root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RootBean {

	private static final Logger logger = LoggerFactory.getLogger(RootBean.class);

	public RootBean() {
		logger.info("Created RootBean");
	}
}
