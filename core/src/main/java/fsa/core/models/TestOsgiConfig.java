package fsa.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import fsa.core.services.TestOSGiConfig;

@Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TestOsgiConfig {
	
	@OSGiService
	TestOSGiConfig testOSGiConfig;
	
	public String getServiceName() {
		return testOSGiConfig.serviceName();
	}
	public int getServiceCount() {
		return testOSGiConfig.getServiceCount();
	}
	public boolean getLiveData() {
		return testOSGiConfig.getLiveData();
		
	}
	public String[] getCountries() {
		return testOSGiConfig.getCountries();
		
	}
	public String getRunMode() {
		return testOSGiConfig.getRunMode();
		
	}
	
}
