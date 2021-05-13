package fsa.core.services;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.dam.api.Asset;
import com.day.cq.dam.api.Rendition;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Component(name = "CreatePageUsingCSV",immediate = true)
public class CreatePageUsingCSVImpl implements CreatePageUsingCSV{

	@Reference
    ResourceResolverFactory resourceResolverFactory;
	
	private static final Logger LOG = LoggerFactory.getLogger(CreatePageUsingCSVImpl.class);
	
	public static final String SERVICE_NAME = "testserviceuser";
	
	public static final String RESOURCE_PATH = "/content/dam/fsa/mapping.csv";
	
	ResourceResolver resourceResolver = null;
	
	@Activate
    @Modified
    public void activate() {
        
        Map<String, Object> map = new HashMap<>();
        map.put(ResourceResolverFactory.SUBSERVICE, SERVICE_NAME);
        try {
        	
            resourceResolver = resourceResolverFactory.getServiceResourceResolver(map);
            LOG.info("Resource Resolver registered");
            
        } catch (Exception e) {
            LOG.error("Login Failed");
        }
    }
	public List<PageModelForCsv> getCsvContent() {

        List<PageModelForCsv> pageProperties = null;

        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;

        try {
            Resource resource = resourceResolver.getResource(RESOURCE_PATH);
            LOG.info("resource is coming");
            Asset asset = resource.adaptTo(Asset.class);
            Rendition rendition = asset.getOriginal();
            inputStream = rendition.adaptTo(InputStream.class);
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);

            pageProperties = new LinkedList<>();

            pageProperties = bufferedReader.lines().skip(1).map(singleLine -> {
                String[] arr = singleLine.split(",");
                PageModelForCsv pageModel = new PageModelForCsv();
                pageModel.setParentPage(arr[0].trim());
                pageModel.setPageName(arr[1].trim());
                pageModel.setWhichTemplate(arr[2].trim());
                pageModel.setPageTitle(arr[3].trim());
                return pageModel;
            }).collect(Collectors.toList());
            
        } catch (Exception e) {
            LOG.error("We failed to get the CSV datas");
        } finally {
            try {
                if (bufferedReader != null)
                    bufferedReader.close();
                if (inputStreamReader != null)
                    inputStreamReader.close();
                if (inputStream != null)
                    inputStream.close();
            } catch (Exception e) {
                LOG.error("Resources could not be released properly");
            }
        }

        return pageProperties;
    }
	@Override
	public List<Page> addPage() {
		List<Page> pagesCreated = new LinkedList<>();
        List<PageModelForCsv> pageProperties = getCsvContent(); // excluded the csv for now
        PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
        try {
            for (PageModelForCsv pageModel : pageProperties) {

                Page page = pageManager.create(pageModel.getParentPage(), pageModel.getPageName(),
                        pageModel.getWhichTemplate(), pageModel.getPageTitle());

                // Page page = pageManager.create(PARENT_PATH, PAGE_NAME, WHICH_TEMPLATE,
                // PAGE_TITLE);

                if (page != null) {
                    pagesCreated.add(page);
                }
            }
            return pagesCreated;
        } catch (Exception e) {
            LOG.error("Page not created");
        }
		return pagesCreated;
		
	}
	
}
