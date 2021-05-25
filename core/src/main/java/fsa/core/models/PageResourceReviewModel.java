package fsa.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.settings.SlingSettingsService;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;


@Model(adaptables = SlingHttpServletRequest.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class PageResourceReviewModel {

//	private static final Logger LOG = LoggerFactory.getLogger(PageResourceModelImpl.class);
//	
//	@OSGiService
//	pageResourceReview pageResourceReviewvar;
//	
//	
//	public String getPageTitle() {
//		
//		return pageResourceReviewvar.getPageTitle();
//	}
//
//public String getPageDesc() {
//		
//		return pageResourceReviewvar.getPageDesc();
//	}
	
	protected String resourceType;

    @OSGiService
    private SlingSettingsService settings;
    @SlingObject
    private Resource currentResource;
    @SlingObject
    private ResourceResolver resourceResolver;

    public String getPageTitle() {
    	PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
        Page currentPage = pageManager.getContainingPage(currentResource);
        return currentPage.getTitle();
    }
    
    public String getPageDesc() {
    	PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
        Page currentPage = pageManager.getContainingPage(currentResource);
        return currentPage.getDescription();
    }
}
