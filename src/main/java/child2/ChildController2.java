package child2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChildController2 {

	@Value("${spring.application.name:notset}")
	private String applicationName;

	@Autowired
	private ChildBean2 childBean2;

	@RequestMapping("/myname")
	public String myName() {
		String result = childBean2.getRootBean().toString() + " - " + this.applicationName + " - "
				+ childBean2.toString();
		return result;
	}
}
