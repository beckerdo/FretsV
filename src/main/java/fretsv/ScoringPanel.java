package fretsv;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class ScoringPanel extends CustomComponent {

	public final static String [] TUNINGS = new String [] {
		"E-A-D-G-B-E",
		"D-A-D-G-B-E",
		"B-E-A-D-F#-B",
	};
	
    public ScoringPanel( ) {

        // A layout structure used for composition
        Panel panel = new Panel();
        VerticalLayout layout = new VerticalLayout();
        panel.setContent(layout);
        
        // Compose from multiple components
        Label label = new Label( "Scoring: Standard" );
        label.setSizeUndefined(); // Shrink
        // panel.addComponent(label);
        layout.addComponent(label);
        layout.addComponent( new Label( "   sum: 100%"));
        layout.addComponent( new Label( "   fret bounds: 10%"));
        layout.addComponent( new Label( "   fret span: 25%"));
        layout.addComponent( new Label( "   skip strings: 25%"));
        layout.addComponent( new Label( "   same strings: 40%"));

        // Set the size as undefined at all levels
        panel.getContent().setSizeUndefined();
        panel.setSizeUndefined();
        setSizeUndefined();

        // The composition root MUST be set
        setCompositionRoot(panel);
    }	
	
    public String toString() {
    	return "Scoring: Standard";
    }
}