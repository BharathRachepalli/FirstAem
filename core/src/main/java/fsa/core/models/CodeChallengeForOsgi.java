package fsa.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import fsa.core.services.CodeChallengeForOSGi;



@Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CodeChallengeForOsgi {
	
	@OSGiService
	CodeChallengeForOSGi codeChallengeForOSGi;
	
	public String getServiceName() {
		return codeChallengeForOSGi.serviceName();
	}
	
	public boolean getLiveData() {
		return codeChallengeForOSGi.getLiveData();
		
	}
	public String[] getCountries() {
		return codeChallengeForOSGi.getCountries();
		
	}
	public String getSubjects() {
		return codeChallengeForOSGi.getSubjects();
		
	}
}
