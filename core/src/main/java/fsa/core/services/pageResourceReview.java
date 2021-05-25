//package fsa.core.services;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.apache.sling.api.resource.Resource;
//import org.apache.sling.api.resource.ResourceResolver;
//import org.apache.sling.api.resource.ResourceResolverFactory;
//import org.apache.sling.models.annotations.injectorspecific.SlingObject;
//import org.osgi.service.component.annotations.Component;
//import org.osgi.service.component.annotations.Reference;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.day.cq.wcm.api.Page;
//import com.day.cq.wcm.api.PageManager;
//
//@Component(name = "pageResourceReview", service = pageResourceReview.class, immediate = true)
//public class pageResourceReview {
//	private static final Logger LOG = LoggerFactory.getLogger(PageResourceServiceImpl.class);
//
//	@Reference
//	ResourceResolverFactory resourceResolverFactory;
//
//	@SlingObject
//	Resource resource;
//	
//	@SlingObject
//	ResourceResolver resourceResolver;
//	
//	public String getPageTitle() {
//
//		
//
//		PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
//		Page currentPage = pageManager.getContainingPage(resource);
//
//		LOG.info(currentPage.getTitle());
//
//		return currentPage.getTitle();
//
//	}
//
//	public String getPageDesc() {
//
//		
//		PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
//		Page currentPage = pageManager.getContainingPage(resource);
//
//		LOG.info(currentPage.getDescription());
//
//		return currentPage.getDescription();
//
//	}
//
////	private ResourceResolver getResourceResolver() {
////
////		ResourceResolver resourceResolver = null;
////
////		try {
////
////			final String SERVICE_USER = "testserviceuser";
////
////			Map<String, Object> paramMap = new HashMap<String, Object>();
////
////			paramMap.put(ResourceResolverFactory.SUBSERVICE, SERVICE_USER);
////
////			resourceResolver = resourceResolverFactory.getServiceResourceResolver(paramMap);
////
////			LOG.info("Inside getResourceResolver");
////
////		} catch (Exception e) {
////			LOG.error("this is error" + e.getMessage());
////		}
////
////		return resourceResolver;
////
////	}
//
//}
