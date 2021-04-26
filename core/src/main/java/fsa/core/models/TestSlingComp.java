package fsa.core.models;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Required;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.RequestAttribute;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.day.cq.wcm.api.Page;

@Model(adaptables = SlingHttpServletRequest.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TestSlingComp {
	
	
	@ScriptVariable
	Page currentPage;
	
	@Inject
	@Via("resource")
	String fname;
	
	@ValueMapValue
	@Default(values = "AeM")
	String lname;
	
	@Inject
	@Via("resource")
	boolean professor;
	
	@RequestAttribute(name = "rAttribute")
	private String reqAttribute;
	
	@Inject
	@Via("resource")
	@Named("jcr:lastModifiedBy")
	String modifiedBy;
	
	
	public String getFirstName() {
		return fname;
	}

	public String getLastName() {
		return lname;
	}

	public boolean getIsProfessor() {
		return professor;
	}

	public String getPageTitle() {
		return currentPage.getTitle();
	}
	
	public String getRequestAttribute() {
		return reqAttribute;
	}
	
	public String getLastModifiedBy() {
		return modifiedBy;
	}
}
