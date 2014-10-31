package fretsv;

import java.util.Random;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class TuningPanel extends CustomComponent {

	public final static String [] TUNINGS = new String [] {
		"E-A-D-G-B-E",
		"D-A-D-G-B-E",
		"B-E-A-D-F#-B",
	};
	
	protected int currentTuning = 0;
	
    public TuningPanel( ) {

    	Random random = new Random();
    	currentTuning = random.nextInt( TUNINGS.length );
    	
        // A layout structure used for composition
        Panel panel = new Panel();
        VerticalLayout layout = new VerticalLayout();
        panel.setContent(layout);
        
        // Compose from multiple components
        Label label = new Label( TUNINGS[ currentTuning ] );
        label.setSizeUndefined(); // Shrink
        // panel.addComponent(label);
        layout.addComponent(label);

        // Set the size as undefined at all levels
        panel.getContent().setSizeUndefined();
        panel.setSizeUndefined();
        setSizeUndefined();

        // The composition root MUST be set
        setCompositionRoot(panel);
    }	
	
    public String toString() {
    	return TUNINGS[ currentTuning ];
    }
}