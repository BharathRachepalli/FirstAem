package fsa.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import fsa.core.services.TestOSGiConfigModularImpl;

@Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TestOsgiConfigModular {

	@OSGiService
	TestOSGiConfigModularImpl testOSGiConfigModularImpl;
	
	public String getServiceID() {
		return testOSGiConfigModularImpl.getServiceId();
	}
	
	public String getServiceUrl() {
		return testOSGiConfigModularImpl.getServiceUrl();
	}
}
