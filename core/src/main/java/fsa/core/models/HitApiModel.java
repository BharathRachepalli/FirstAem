package fsa.core.models;

import java.util.List;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import fsa.core.services.HitApiServiceImpl;


@Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class HitApiModel {
    @OSGiService
    HitApiServiceImpl hitApiService;

    public List<String> getCountrynames() {
        return hitApiService.getCountryName();
    }
}
