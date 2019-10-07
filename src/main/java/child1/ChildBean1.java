package child1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import root.RootBean;

public class ChildBean1 {

	private static final Logger logger = LoggerFactory.getLogger(ChildBean1.class);

	private final RootBean rootBean;

	public ChildBean1(RootBean rootBean, String fromRoot) {
		logger.info("Creating Child Bean! {}", fromRoot);
		this.rootBean = rootBean;
	}

	public RootBean getRootBean() {
		return rootBean;
	}

}
