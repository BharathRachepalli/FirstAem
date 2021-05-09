package fsa.core.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.jcr.Node;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

import fsa.core.models.TestMultiField;

@Component(name = "PageResourceService",service = PageResourceService.class,immediate = true)
public class PageResourceServiceImpl implements PageResourceService{

	private static final Logger LOG = LoggerFactory.getLogger(PageResourceServiceImpl.class);

	@Reference
	ResourceResolverFactory resourceResolverFactory;
	
	@Override
	public String getPageTitle() {
		
		
		ResourceResolver resourceResolver=getResourceResolver();
		
		Resource resource = resourceResolver.getResource("/content/fsa/en"); // is a class  The page is a resource object 
		
		LOG.info(resource.getName());
		
		return resource.getName();
		
		
	}

	
	private ResourceResolver getResourceResolver() {
		
		ResourceResolver resourceResolver=null;
		
		try {
			
			final String SERVICE_USER = "testserviceuser";
			
			Map<String, Object> paramMap = new HashMap<String, Object>();
			
			paramMap.put( ResourceResolverFactory.SUBSERVICE, SERVICE_USER );
			
			resourceResolver = resourceResolverFactory.getServiceResourceResolver(paramMap);
			
			LOG.info("Inside getResourceResolver");
			
		}catch (Exception e) {
			LOG.error("this is error"+e.getMessage());
		}
		
		return resourceResolver;
		
	}


	@Override
	public List<String> getPageAndNode() {
		
		List<String> pageInfo =new ArrayList<String>();
		
		ResourceResolver resourceResolver = getResourceResolver();
		
		Resource resource = resourceResolver.getResource("/content/fsa/en");
		
		Page page = resource.adaptTo(Page.class);
		
//		PageManager pm = page.getPageManager();
//		Node node = resource.adaptTo(Node.class);
		
		Iterator<Page> pageChild = page.listChildren();
		
		while(pageChild.hasNext()) {
			
			Page page1 = pageChild.next();
			
			pageInfo.add(page1.getTitle());
			
		}
		
		return pageInfo;
	}
}
