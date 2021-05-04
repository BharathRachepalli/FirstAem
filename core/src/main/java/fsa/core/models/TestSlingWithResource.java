package fsa.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;


@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TestSlingWithResource {
	
	@Inject
	String fname1;
	
	@Inject
	@Default(values = "AeM")
	String lname1;
	
	@Inject
	boolean professor1;
	
	public String getFirstName() {
		return fname1;
	}
	
	public String getLastName() {
		return lname1;
	}
	
	public boolean isProfessor() {
		return professor1;
	}
}
