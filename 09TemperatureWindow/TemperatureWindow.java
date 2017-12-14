import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TemperatureWindow extends JFrame implements ActionListener{
    private Container pane;
    
    private JButton CtoF;
    private JButton FtoC;
    private JTextField text;
    private JLabel description;

    public TemperatureWindow(){
	this.setTitle("Convert Temperatures");
	this.setSize(500, 500);
	this.setLocation(100, 100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());

	CtoF = new JButton("CtoF");
	FtoC = new JButton("FtoC");
	text = new JTextField(5);
	description = new JLabel("Enter, click desired function, and result will appear in the textbox");

	pane.add(CtoF);
	pane.add(FtoC);
	pane.add(text);
	pane.add(description);

	CtoF.addActionListener(this);
	FtoC.addActionListener(this);
	text.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
	String event = e.getActionCommand();
	System.out.println(event);
	if(event.equals("CtoF")){
	    text.setText("" + (Integer.parseInt(text.getText()) * 1.8 + 32) );
	}
	if(event.equals("FtoC")){
	    text.setText("" + ((Integer.parseInt(text.getText()) - 32) / 1.8));
	}
    }
    
    public static void main(String[] args){
	TemperatureWindow theWindow = new TemperatureWindow();
	theWindow.setVisible(true);
    }
}
