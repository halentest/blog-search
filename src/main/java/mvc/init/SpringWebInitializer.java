package mvc.init;

import blog.search.http.HttpConfig;
import blog.search.solr.SolrConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

/**
 * This class will be loaded by a servlet 3.0 container automatically.
 *
 * @see org.springframework.web.WebApplicationInitializer
 */
public class SpringWebInitializer implements WebApplicationInitializer {

    public void onStartup(ServletContext servletContext) {
    	// Create the 'root' Spring application context
        AnnotationConfigWebApplicationContext rootContext =
          new AnnotationConfigWebApplicationContext();
        rootContext.register(SolrConfig.class);

        // Manage the lifecycle of the root application context
        servletContext.addListener(new ContextLoaderListener(rootContext));

        // Create the dispatcher servlet's Spring application context
        AnnotationConfigWebApplicationContext dispatcherContext =
          new AnnotationConfigWebApplicationContext();
        dispatcherContext.register(MvcConfig.class, HttpConfig.class);

        // Register and map the dispatcher servlet
        ServletRegistration.Dynamic dispatcher =
        		servletContext.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
        
//        //add filter
//        servletContext.addFilter("springSecurityFilterChain", new DelegatingFilterProxy("springSecurityFilterChain"))
//        				.addMappingForUrlPatterns(null, false, "/*");
//      //add filter
//        servletContext.addFilter("userFilterChain", new DelegatingFilterProxy("userFilterChain"))
//        				.addMappingForUrlPatterns(null, false, "/*");
    }
}
