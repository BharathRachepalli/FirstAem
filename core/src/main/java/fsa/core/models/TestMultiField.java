package fsa.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.*;

@Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TestMultiField {
	
	private static final Logger LOG = LoggerFactory.getLogger(TestMultiField.class);
	
	
//	@SlingObject
	@Self
	SlingHttpServletRequest componentResource;

//	Resource componentResource;

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

	public List<Map<String, String>> getBookDetails() {
		List<Map<String, String>> bookDetailsMap = new ArrayList<Map<String,String>>();
		try {
//			Resource bookdetails1 = componentResource.getChild("bookdetails");
			Resource bookdetails1 = componentResource.getResource().getChild("bookdetails");
			if (bookdetails1 != null) {
				for(Resource i : bookdetails1.getChildren()) {
					Map<String, String> bookmap = new HashMap<String, String>();
					bookmap.put("bookname", i.getValueMap().get("bookname", String.class));
					bookmap.put("bookprice",i.getValueMap().get("bookprice", String.class));
					bookDetailsMap.add(bookmap); 
				}
			}
		}catch(Exception e) {
			LOG.info("\n Error While Getting book11"+bookDetailsMap.size()+" details",e.getMessage());
		}
		return bookDetailsMap;
	}

	public List<String> getAuthBooks() {
		if (books != null) {
			return new ArrayList<String>(books);
		} else {
			return Collections.emptyList();
		}
	}
}
