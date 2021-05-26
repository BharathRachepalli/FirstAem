package fsa.core.services;


public class PageModelForCsv {

    private String parentPage;
    private String pageName;
    private String whichTemplate;
    public String getPageDescp() {
		return pageDescp;
	}

	public void setPageDescp(String pageDescp) {
		this.pageDescp = pageDescp;
	}

	private String pageTitle;
    private String pageDescp;

    public PageModelForCsv() {
        super();
    }

   

    public PageModelForCsv(String parentPage, String pageName, String whichTemplate, String pageTitle,
			String pageDescp) {
		super();
		this.parentPage = parentPage;
		this.pageName = pageName;
		this.whichTemplate = whichTemplate;
		this.pageTitle = pageTitle;
		this.pageDescp = pageDescp;
	}

	public String getParentPage() {
        return parentPage;
    }

    public void setParentPage(String parentPage) {
        this.parentPage = parentPage;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getWhichTemplate() {
        return whichTemplate;
    }

    public void setWhichTemplate(String whichTemplate) {
        this.whichTemplate = whichTemplate;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

}