import javax.swing.JFrame;

public class Game {
	
	public static void main(String[] args){
		
		JFrame window  = new JFrame("HIM's Manipulation");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();
		window.setContentPane(new GamePanel());
		window.setLocation(400, 250);
		window.setResizable(false);
		window.setVisible(true);
		window.pack();
		
	}
	

}
