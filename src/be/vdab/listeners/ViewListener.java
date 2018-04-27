package be.vdab.listeners;

import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class ViewListener
 *
 */
@WebListener
public class ViewListener implements ServletContextListener, HttpSessionAttributeListener {
	private static final String VIEWS = "views";
	private static final Set<String> UITGESLOTEN_EXTENSIES = 
			new CopyOnWriteArraySet<>(Arrays.asList("png", "gif", "jpg", "css", "js", "ico"));
    /**
     * Default constructor. 
     */
    public ViewListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent event)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent event)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent event)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent event)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event)  { 
         // TODO Auto-generated method stub
    	event.getServletContext().setAttribute(VIEWS, new ConcurrentHashMap<String, AtomicInteger>());
    }
	
    public void requestInitialized(ServletRequestEvent event) {
    	if(event.getServletRequest() instanceof HttpServletRequest) {
    		HttpServletRequest request = (HttpServletRequest) event.getServletRequest();
    		String url = request.getRequestURI();
    		boolean verwerkRequest = true;
    		int laatstePuntIndex = url.lastIndexOf('.');
    		if (laatstePuntIndex != -1) {
    			String extensie = url.substring(laatstePuntIndex + 1).toLowerCase();
    			if (UITGESLOTEN_EXTENSIES.contains(extensie)) {
    				verwerkRequest = false;
    			}
    		}
    		if (verwerkRequest) {
    			int index = url.indexOf(";jsessionid=");
    			if (index != -1) {
    				url = url.substring(0, index);
    			}
    			@SuppressWarnings("unchecked")
    			ConcurrentHashMap<String, AtomicInteger> statistiek =
    			(ConcurrentHashMap<String, AtomicInteger>) request.getServletContext().getAttribute(VIEWS);
    			AtomicInteger aantalReedsAanwezig = statistiek.putIfAbsent(url, new AtomicInteger(1));
    			if (aantalReedsAanwezig != null) {
    				aantalReedsAanwezig.incrementAndGet();
    			}
    		}
    	}
    }
}
