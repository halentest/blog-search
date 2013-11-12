package blog.search.http;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * User: hzhang
 * Date: 11/12/13
 * Time: 2:27 PM
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@ComponentScan(basePackageClasses = {HttpConfig.class})
public class HttpConfig {
}
