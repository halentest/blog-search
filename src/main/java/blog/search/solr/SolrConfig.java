package blog.search.solr;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * User: hzhang
 * Date: 11/12/13
 * Time: 2:34 PM
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@ComponentScan(basePackageClasses = {SolrConfig.class})
public class SolrConfig {
}
