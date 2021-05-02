package fsa.core.services;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;


@Component (service = TestOSGiConfigFactory.class,configurationPolicy = ConfigurationPolicy.REQUIRE)
@Designate (ocd = TestOSGiConfigFactory.ServiceConfigFactory.class, factory = true)
public class TestOSGiConfigFactory {
	
	@ObjectClassDefinition(name = "Testing Osgi Config Factory",description = "Factory Testing Osgi Config")
	public @interface ServiceConfigFactory {

		@AttributeDefinition(name = "Service Name", description = "Enter Service Name", type = AttributeType.STRING)
		String serviceName() default "Srevice #";
		
		@AttributeDefinition(name = "Service URL", description = "Enter Service URL", type = AttributeType.STRING)
		String serviceUrl() default "URL #";
	}
	
	private String serviceName;
    private String serviceURL;
    private List<TestOSGiConfigFactory> configsList;
    
    @Activate
    @Modified
    protected void activate (ServiceConfigFactory serviceConfigModular) {
    	serviceName=serviceConfigModular.serviceName();
    	serviceURL=serviceConfigModular.serviceUrl();
    }
    
    
    @Reference(service = TestOSGiConfigFactory.class,cardinality = ReferenceCardinality.MULTIPLE, policy = ReferencePolicy.DYNAMIC)
    public void bindOSGiFactoryConfig(final TestOSGiConfigFactory config) {
    	 if (configsList == null){
             configsList = new ArrayList<>();
         }
         configsList.add(config);
    }
    public void unbindOSGiFactoryConfig(final TestOSGiConfigFactory config) {
        configsList.remove(config);
    }
    
    
    public String getServiceName() {
        return serviceName;
    }
    public String getServiceURL() {
        return serviceURL;
    }
    public List<TestOSGiConfigFactory> getAllConfigs(){
        return configsList;
    }
    
    
}
