package cz.dostalma.monolithicshop.configuration;

import cz.dostalma.monolithicshop.facade.ProductFacade;
import cz.dostalma.monolithicshop.facade.ProductFacadeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Base configuration for application beans
 */
@Configuration
public class ApplicationConfiguration {

    @Autowired
    private Environment env;

    @Autowired
    private ApplicationContext appContext;

    @Bean(name="productFacade")
    public ProductFacade productFacade() {
        return new ProductFacadeImpl();
    }

}
