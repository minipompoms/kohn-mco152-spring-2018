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
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import kohn.dictionary.DictionaryGui;

@SuppressWarnings("serial")
public class ProjectileGui extends JPanel implements PropertyChangeListener {

	private double angle;
	private double velocity;
	private double time;

	private double x;
	private double y;

	private JFormattedTextField angleField;
	private JFormattedTextField velocityField;
	private JFormattedTextField timeField;
	private JFormattedTextField xField;
	private JFormattedTextField yField;

	public ProjectileGui() {

		super(new BorderLayout());

		angleField = new JFormattedTextField(angle);
		angleField.addPropertyChangeListener("value", this);

		velocityField = new JFormattedTextField(velocity);
		velocityField.addPropertyChangeListener("value", this);

		timeField = new JFormattedTextField(time);
		timeField.addPropertyChangeListener("value", this);

		xField = new JFormattedTextField(x);
		xField.setEditable(false);

		yField = new JFormattedTextField(y);
		yField.setEditable(false);


		JPanel labelPane = new JPanel(new GridLayout(0, 1));
		labelPane.add(new JLabel("Angle:"));
		labelPane.add(new JLabel("Velocity: "));
		labelPane.add(new JLabel("Time:"));
		labelPane.add(new JLabel(" "));
		labelPane.add(new JLabel("X ->"));
		labelPane.add(new JLabel("Y ->"));

		JPanel fieldPane = new JPanel(new GridLayout(0, 1));
		fieldPane.add(angleField);
		fieldPane.add(velocityField);
		fieldPane.add(timeField);
		fieldPane.add(new JLabel(" COORDINATES"));
		fieldPane.add(xField);
		fieldPane.add(yField);

		setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
		add(labelPane, BorderLayout.CENTER);
		add(fieldPane, BorderLayout.LINE_END);
		setLocation(540, 320);
		setVisible(true);

		
	}

	@Override
	public void propertyChange(PropertyChangeEvent e) {

		Object o = e.getSource();
		if (o == angleField || o == velocityField || o == timeField) {
			angle = ((Number) angleField.getValue()).doubleValue();
			velocity = ((Number) velocityField.getValue()).doubleValue();
			time = ((Number) timeField.getValue()).doubleValue();
		}
		Projectile updateProjectile = new Projectile(angle, velocity);
		updateProjectile.setTime(time);

		double updateTime = updateProjectile.getTime();
		timeField.setValue(updateTime);
		double updateX = updateProjectile.getX();
		xField.setValue(new Double(updateX));
		double updateY = updateProjectile.getY();
		yField.setValue(new Double(updateY));
	}

	public static void main(String args[]) {
		
		JFrame frame = new JFrame("ProjectileGui");
		
		new ProjectileGui();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
	
		
	}

}
