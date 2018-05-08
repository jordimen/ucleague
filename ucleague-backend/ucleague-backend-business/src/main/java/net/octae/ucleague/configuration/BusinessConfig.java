package net.octae.ucleague.configuration;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

/**
 * The type Business config.
 */
@Configuration
public class BusinessConfig {

    /**
     * Dozer bean dozer bean mapper.
     *
     * @return the dozer bean mapper
     */
    @Bean(name = "org.dozer.Mapper")
    public DozerBeanMapper dozerBean() {
        List<String> mappingFiles = Arrays.asList(
                "dozer/dozer-global-configuration.xml",
                "dozer/dozer-mappings.xml"
        );

        DozerBeanMapper dozerBean = new DozerBeanMapper();
        dozerBean.setMappingFiles(mappingFiles);
        return dozerBean;
    }

}
