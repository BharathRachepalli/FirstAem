package fsa.core.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TestMultiField {
	@Inject
	Resource componentResource;

	@ValueMapValue
	@Default(values = "AeM")
	private String authname;

	
	@ValueMapValue
	private int authage;
	
	@ValueMapValue
	private List<String> books;

	public String getAuthName() {
		return authname;
	}
	public int getAuthAge() {
		return authage;
	}
	public List<String> getAuthBooks() {
		if (books != null) {
			return new ArrayList<String>(books);
		} else {
			return Collections.emptyList();
		}
	}
}
