package fsa.core.models;

import java.util.List;

public interface PageResourceModel {
	public String getPageTitle();
	
	public List<String> getPageAndNode();
	
	public List<String> getCsvData();
}
