package kohn.physics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;
import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class ProjectileGui extends JPanel implements PropertyChangeListener{
	
	
	private double angle;
	private double velocity;
	private double time;
	
	private double x;
	private double y;
	Projectile projectile; 
	
	private String angleStr = "Angle:";
	private String velocityStr = "Velocity:";
	private String timeStr = "Time:";
	private String xStr = "X -> ";
	private String yStr = "Y -> ";
	
	private JFormattedTextField angleField;
	private JFormattedTextField velocityField;
	private JFormattedTextField timeField;
	private JFormattedTextField xField;
	private JFormattedTextField yField;
	
	private NumberFormat angleFormat;
	private NumberFormat velocityFormat;
	
	public ProjectileGui() {
		
		
		super(new BorderLayout());
		Projectile projectile = new Projectile(angle, velocity);

		setUpFormats();
		
		JLabel angleLabel = new JLabel(angleStr);
		JLabel velocityLabel = new JLabel(velocityStr);
		JLabel timeLabel = new JLabel(timeStr);		
		JLabel xLabel = new JLabel(xStr);
		JLabel yLabel = new JLabel (yStr);
		
		angleField = new JFormattedTextField(angle);
		angleField.setColumns(5);
		projectile.setAngle(72);
		angleField.setValue(projectile.getAngle());
		angleField.addPropertyChangeListener("value", this);
		
		velocityField = new JFormattedTextField(velocity);
		velocityField.setColumns(5);
		projectile.setVelocity(23);
		velocityField.setValue(projectile.getVelocity());
		velocityField.addPropertyChangeListener("value", this);	
		
		timeField = new JFormattedTextField(time);
		timeField.setColumns(5);
		projectile.setTime(10);
		timeField.setValue(projectile.getTime());
		timeField.addPropertyChangeListener("value", this);
		
		xField = new JFormattedTextField(x);
		xField.setColumns(5);
		xField.setValue(projectile.getX());
		xField.setEditable(false);
		
		yField = new JFormattedTextField(y);
		yField.setColumns(5);
		yField.setValue(projectile.getY());
		yField.setEditable(false);
		
		
		angleLabel.setLabelFor(angleField);
		velocityLabel.setLabelFor(velocityField);
		timeLabel.setLabelFor(timeField);
		xLabel.setLabelFor(xField);
		yLabel.setLabelFor(yField);
		
		
		JPanel labelPane = new JPanel(new GridLayout(0,1));
		
		
		
		labelPane.add(angleLabel);
		labelPane.add(velocityLabel);
		labelPane.add(timeLabel);
		labelPane.add(new JLabel(" "));
		labelPane.add(xLabel);
		labelPane.add(yLabel);

		JPanel fieldPane = new JPanel(new GridLayout(0,1));
		fieldPane.add(angleField);
		fieldPane.add(velocityField);
		fieldPane.add(timeField);
		fieldPane.add(new JLabel(" COORDINATES"));
		fieldPane.add(xField);
		fieldPane.add(yField);
		
		setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
		add(labelPane, BorderLayout.CENTER);
		add(fieldPane, BorderLayout.LINE_END);
		
	}
	
	public void setUpFormats() {
		angleFormat = NumberFormat.getNumberInstance();
		velocityFormat = NumberFormat.getNumberInstance();
	}
	@Override
	public void propertyChange(PropertyChangeEvent e) {
		
		Object o = e.getSource();
		if(o == angleField) {
			angle = ((Number)angleField.getValue()).doubleValue();
		} else if (o == velocityField) {
			velocity = ((Number)velocityField.getValue()).doubleValue();
		} else if (o == timeField) {
			time = ((Number)timeField.getValue()).doubleValue();
		}

		double xO = projectile.getX();
		xField.setValue(new Double(xO));
		double yO = projectile.getY();
		yField.setValue(new Double (yO));
		
		
	}
	
	public static void showGUI() {
		
		JFrame frame = new JFrame("ProjectileGui");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(new ProjectileGui());
		frame.pack();
		
		frame.setVisible(true);
	}
	public static void main (String args[]) {
		
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
		showGUI();
            }
		});
	}
	
	
	

	
	
}
