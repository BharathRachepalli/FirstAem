package fsa.core.services;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;

import fsa.core.config.ServiceConfigModular;

@Component(service = TestOSGiConfigModularImpl.class,immediate = true)
@Designate(ocd = ServiceConfigModular.class)
public class TestOSGiConfigModularImpl {
	
	private String serviceId;
	private String serviceUrl;
	
	@Activate
	protected void activate (ServiceConfigModular serviceConfigModular) {
		serviceId=serviceConfigModular.serviceId();
		serviceUrl=serviceConfigModular.serviceUrl();
	}

	public String getServiceId() {
		return serviceId;
	}

	public String getServiceUrl() {
		return serviceUrl;
	}
	
}
