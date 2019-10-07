package child1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChildController1 {

	@Value("${spring.application.name:notset}")
	private String applicationName;

	@Autowired
	private ChildBean1 childBean1;

	@RequestMapping("/myname")
	public String myName() {
		String result = childBean1.getRootBean().toString() + " - " + this.applicationName + " - "
				+ childBean1.toString();
		return result;
	}
}
