package fretsv;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("mytheme")
@SuppressWarnings("serial")
public class MainUI extends UI {

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = MainUI.class, widgetset = "fretsv.AppWidgetSet")
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);
		
	    TabSheet sample = new TabSheet();
	    sample.setHeight(100.0f, Unit.PERCENTAGE);
	    sample.addStyleName("padded-tabbar");
	      
	    for (int i = 1; i < 8; i++) {
	    	final VerticalLayout pageLayout = new VerticalLayout(
	    		// new Label(getLoremContent(), ContentMode.HTML));
    		    new Label( "<body><h2>Foo bar</h2><p>It's nothing but foorbar.</p></body>", ContentMode.HTML));
	    	pageLayout.setMargin(true);
	    	sample.addTab(pageLayout, "Tab " + i);
	     }
	    
	    TuningPanel tuningPanel = new TuningPanel();
	    sample.addTab( tuningPanel, tuningPanel.toString());
	    
	    ScoringPanel scoringPanel = new ScoringPanel();
	    sample.addTab( scoringPanel, scoringPanel.toString());
	    
    	layout.addComponent( createMenuBar() );
    	
		layout.addComponent(sample);

    }

    public MenuBar createMenuBar() {
    	MenuBar barmenu = new MenuBar();
    	barmenu.addStyleName("mybarmenu");
    	// layout.addComponent(barmenu);
    	        
    	// A feedback component
    	// al Label selection = new Label("-");
    	// out.addComponent(selection);

    	// Define a common menu command for all the menu items
    	MenuBar.Command mycommand = new MenuBar.Command() {
    	    MenuItem previous = null;

    	    public void menuSelected(MenuItem selectedItem) {
    	        // selection.setValue("Ordered a " + selectedItem.getText() + " from menu.");

    	        if (previous != null)
    	            previous.setStyleName(null);
    	        selectedItem.setStyleName("highlight");
    	        previous = selectedItem;
    	    }  
    	};
    	        
    	// Put some items in the menu
    	barmenu.addItem("Beverages", null, mycommand);
    	barmenu.addItem("Snacks", null, mycommand);
    	barmenu.addItem("Services", null, mycommand);
    	return  barmenu;
    }
}
