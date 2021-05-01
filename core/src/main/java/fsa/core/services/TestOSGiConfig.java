package fsa.core.services;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.osgi.service.metatype.annotations.Option;

@Component(service = TestOSGiConfig.class,immediate = true)
@Designate(ocd = TestOSGiConfig.ServiceConfig.class)
public class TestOSGiConfig {

	@ObjectClassDefinition(name = "Testing Osgi Config",description = "Osgi Config Demo")
	public @interface ServiceConfig{
		
		@AttributeDefinition(name = "Service Name", description = "Enter Service Name", type = AttributeType.STRING)
		String serviceName() default "AEM Default Service";
		
		@AttributeDefinition(name = "Service Count", description = "Enter Service Count", type = AttributeType.INTEGER)
		public int getServiceCount() default 5;
		
		@AttributeDefinition(name = "Live data", description = "Check to get live Data", type = AttributeType.BOOLEAN)
		public boolean getLiveData() default false;
		
		@AttributeDefinition(name = "Countries", description = "Add Countery Locale", type = AttributeType.STRING)
		public String[] getCountries() default {"de","en"};
		
		@AttributeDefinition(name = "Run Mode", description = "Select Run Mode",
				options = {
						@Option(label = "Author",value = "author"),
						@Option(label = "publish",value="publish"),
						@Option(label = "Both",value = "both")
				},
				type = AttributeType.STRING)
		public String getRunMode() default "both";
	}
	
	private String serviceName;
	private int serviceCount;
	private boolean liveData;
	private String[] countries;
	private String runModes;
	
	@Activate
	protected void activate (ServiceConfig serviceConfig) {
		serviceName=serviceConfig.serviceName();
		serviceCount=serviceConfig.getServiceCount();
		liveData=serviceConfig.getLiveData();
		countries=serviceConfig.getCountries();
		runModes=serviceConfig.getRunMode();
	}
	
	public String serviceName() {
		return serviceName;
	}
	public int getServiceCount() {
		return serviceCount;
	}
	public boolean getLiveData() {
		return liveData;
		
	}
	public String[] getCountries() {
		return countries;
		
	}
	public String getRunMode() {
		return runModes;
		
	}
}
