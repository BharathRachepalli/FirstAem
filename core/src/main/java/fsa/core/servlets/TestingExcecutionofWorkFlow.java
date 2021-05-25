package fsa.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkflowData;
import com.adobe.granite.workflow.model.WorkflowModel;

import fsa.core.services.PageResourceServiceImpl;

@Component(service = Servlet.class)
@SlingServletPaths(
        value = {"/bin/executeworkflow"}
)
public class TestingExcecutionofWorkFlow extends SlingSafeMethodsServlet{
	
	private static final Logger LOG = LoggerFactory.getLogger(TestingExcecutionofWorkFlow.class);

	String status="Workflow Executing";
	
	protected void doGet(final SlingHttpServletRequest req, final SlingHttpServletResponse resp) throws IOException {
		
		final ResourceResolver resourceResolver = req.getResourceResolver();
		
		String payload = req.getRequestParameter("page").getString();
		
		try {
			
			if(StringUtils.isNotBlank(payload)) {
				
				WorkflowSession workflowSession = resourceResolver.adaptTo(WorkflowSession.class);
				WorkflowModel workflowModel = workflowSession.getModel("/var/workflow/models/testingworkflow");
				WorkflowData workflowData = workflowSession.newWorkflowData("JCR_PATH", payload);
				
//				workflowSession.startWorkflow(workflowModel, workflowData);
				
				status=workflowSession.startWorkflow(workflowModel, workflowData).getState();
				
			}
			
		}catch(Exception e) {
			LOG.info(e.getMessage());
		}
		
		resp.setContentType("application/json");
		resp.getWriter().write(status);
		
	}
}
