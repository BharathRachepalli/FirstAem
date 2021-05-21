package fsa.core.services;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.osgi.service.metatype.annotations.Option;

@Component(service = CodeChallengeForOSGi.class,immediate = true)
@Designate(ocd = CodeChallengeForOSGi.ServiceConfig.class)
public class CodeChallengeForOSGi {
	@ObjectClassDefinition(name = "CodeChallenge Osgi Config",description = "Osgi Config Demo")
	public @interface ServiceConfig{
		
		@AttributeDefinition(name = "Service Name", description = "Enter Service Name", type = AttributeType.STRING)
		String serviceName() default "Default Name";
		
		
		@AttributeDefinition(name = "Live data", description = "Check to get live Data", type = AttributeType.BOOLEAN)
		public boolean getLiveData() default false;
		
		@AttributeDefinition(name = "Countries", description = "Add Countery Locale", type = AttributeType.STRING)
		public String[] getCountries() default {"de","en"};
		
		@AttributeDefinition(name = "Subjects", description = "Select Subject",
				options = {
						@Option(label = "AEM",value = "aem"),
						@Option(label = "Sling",value="Sling"),
						@Option(label = "Both",value = "both")
				},
				type = AttributeType.STRING)
		public String getSubjects() default "both";
	}
	
	private String serviceName;
	private boolean liveData;
	private String[] countries;
	private String getSubjects;
	
	@Activate
	protected void activate (ServiceConfig serviceConfig) {
		serviceName=serviceConfig.serviceName();
		liveData=serviceConfig.getLiveData();
		countries=serviceConfig.getCountries();
		getSubjects=serviceConfig.getSubjects();
	}
	
	public String serviceName() {
		return serviceName;
	}
	
	public boolean getLiveData() {
		return liveData;
		
	}
	public String[] getCountries() {
		return countries;
		
	}
	public String getSubjects() {
		return getSubjects;
		
	}
}
