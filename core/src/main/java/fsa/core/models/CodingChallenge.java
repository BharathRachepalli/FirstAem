package fsa.core.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables = SlingHttpServletRequest.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CodingChallenge {

	
	private static final Logger LOG = LoggerFactory.getLogger(CodingChallenge.class);
	
	@Self
	SlingHttpServletRequest componentResource;
	
	
	@Inject
	@Via("resource")
	boolean testboolean;
	
	@ValueMapValue
	private String fileReference;
	
	@ValueMapValue
	private String findpath;
	
	@ValueMapValue
	private List<String> mfdemo;
	
	public boolean getTestboolean() {
		return testboolean;
	}
	
	public String getFindpath() {
		return findpath;
	}
	
	public String getFileReference() {
		return fileReference;
	}
	
	public List<Map<String, String>> getMultipledemo() {
		List<Map<String, String>> list1 = new ArrayList<Map<String,String>>();
		try {
			Resource res = componentResource.getResource().getChild("multipledemo");
			if (res != null) {
				for(Resource i : res.getChildren()) {
					Map<String, String> map = new HashMap<String, String>();
					map.put("firsttype", i.getValueMap().get("firsttype", String.class));
					map.put("secondtype",i.getValueMap().get("secondtype", String.class));
					list1.add(map); 
				}
			}
		}catch(Exception e) {
			LOG.info("\n Error While Getting book11 details",e.getMessage());
		}
		return list1;
	}
	
	
	public List<String> getMfdemo() {
		if (mfdemo != null) {
			return new ArrayList<String>(mfdemo);
		} else {
			return Collections.emptyList();
		}
	}
}
