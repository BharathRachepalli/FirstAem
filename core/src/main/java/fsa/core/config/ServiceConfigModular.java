package fsa.core.config;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;


@ObjectClassDefinition(name = "Testing Osgi Config Modular",description = "Modular Testing Osgi Config")
public @interface ServiceConfigModular {

	@AttributeDefinition(name = "Service ID", description = "Enter Service ID", type = AttributeType.STRING)
	String serviceId() default "M106";
	
	@AttributeDefinition(name = "Service URL", description = "Enter Service URL", type = AttributeType.STRING)
	String serviceUrl() default "LocalHost";
}
