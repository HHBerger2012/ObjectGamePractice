import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ConstructorPractice extends JFrame implements KeyListener
	{
	private static final long serialVersionUID = 1L;
		JLabel label;
		public ConstructorPractice(String s)
			{
				super(s);
				JPanel p = new JPanel();
				label = new JLabel("Arrow key to Move.");
				p.add(label);
				add(p);
				addKeyListener(this);
				setSize(200, 100);
				setVisible(true);
			}
		@Override
		public void keyTyped(KeyEvent e){}
		@Override
		public void keyReleased(KeyEvent e) {}
		@Override
	    public void keyPressed(KeyEvent e) 
		{
	    	if (e.getKeyCode() == KeyEvent.VK_RIGHT)
	    	{
	    		moveRight();
	    	}
	    	if (e.getKeyCode() == KeyEvent.VK_LEFT)
	    	{
	    		moveLeft();
	    	}
	    	if (e.getKeyCode() == KeyEvent.VK_UP)
	    	{
	    		moveUp();
	    	}
	    	if (e.getKeyCode() == KeyEvent.VK_DOWN)
	    	{
	    		moveDown();
	    	}
		}
	    static JFrame frame=new JFrame();
		static String arrayGame[][] = new String [20][20];
		static ArrayList<WonderWeapons>weapons;
		static ArrayList<PlayerWeapon>currentPlayerWeapon;
		static int playerRow = 18;
		static int playerCol = 10;
		public static void main(String[] args)
			{
				makeWWs();
				fillWithStars();
				new ConstructorPractice("Playing.");
			}
		public static void makeWWs()
		{
			weapons= new ArrayList<WonderWeapons>();
			weapons.add(new WonderWeapons("Apothican Servant",1,9,"No Camo"," from The Apothicans","Apothican"));
			weapons.add(new WonderWeapons("Thunder Gun",2,12,"Kino PaP Camo"," from The Group 935 Research Facility in Germany","German"));
			weapons.add(new WonderWeapons("Der Eisendrache Bow",1,9,"No Camo"," from The Apothicans","Fire"));
			weapons.add(new WonderWeapons("Der Eisendrache Bow",1,9,"No Camo"," from The Apothicans","Lightning"));
			weapons.add(new WonderWeapons("Der Eisendrache Bow",1,9,"No Camo"," from The Apothicans","Wolf"));
			weapons.add(new WonderWeapons("Der Eisendrache Bow",1,9,"No Camo"," from The Apothicans","Void"));
			weapons.add(new WonderWeapons("Elemental Staff (Kimbat's Bite)",12,120,"No Camo","Unknown","Lightning"));
			weapons.add(new WonderWeapons("Elemental Staff (Kagutsuchi's Blood)",9,120,"No Camo","Unknown","Fire"));
			weapons.add(new WonderWeapons("Elemental Staff (Boreas' Fury)",3,90,"No Camo","Unknown","Wind"));
			weapons.add(new WonderWeapons("Elemental Staff (Ull's Arrow)",6,90,"No Camo","Unknown","Ice"));
		}
		public static void spinBox()
		{
			int choice;
			Object[] options = {"Spin the Box", "Leave"};
			ImageIcon icon =  new ImageIcon("uu.gif");
			choice = JOptionPane.showOptionDialog(null, 
				"A Small Box",
				"You See a Box",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, 
				icon,
				options, 
				options[1]);
				switch(choice)
				{
				case 0:
					{
					getWeapon();
					break;
					}
				case 1:
					{
					JOptionPane.showMessageDialog(frame, "You Left");
					break;
					}
				}
		}
		public static void getWeapon()
		{
			currentPlayerWeapon= new ArrayList<PlayerWeapon>();
			int rand = (int)(Math.random()*weapons.size());
			currentPlayerWeapon.add(new PlayerWeapon(weapons.get(rand).getName(),weapons.get(rand).getRounds(),weapons.get(rand).getReserveRounds(),weapons.get(rand).getCamo(),weapons.get(rand).getOrigin(),weapons.get(rand).getType()));
			ImageIcon icon2 =  new ImageIcon("667788.mp4");
			JOptionPane.showMessageDialog(
					frame, 
					"You got a "+weapons.get(rand).getName(), 
					"Wonder Weapons", 
					JOptionPane.INFORMATION_MESSAGE, icon2); 
			int choice;
			Object[] options = {"Learn more about this weapon", "Leave"};
			ImageIcon icon =  new ImageIcon("uu.gif");
			choice = JOptionPane.showOptionDialog(null, 
					weapons.get(rand).getName(),
				weapons.get(rand).getName(),
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, 
				icon,
				options, 
				options[1]);
				switch(choice)
				{
				case 0:
					{
						JOptionPane.showMessageDialog(frame, "The Origin of this gun is "+weapons.get(rand).getOrigin());
						JOptionPane.showMessageDialog(frame, "Your weapon is "+weapons.get(rand).getType()+" Type");

						break;
					}
				case 1:
					{
					JOptionPane.showMessageDialog(frame, "You Left");
					break;
					}
				}
			
		}
		public static void packAPunch()
		{
			int choice;
			Object[] options = {"Pack a Punch", "Leave"};
			ImageIcon icon =  new ImageIcon("uu.gif");
			choice = JOptionPane.showOptionDialog(null, 
				"A Pack a Punch Machine",
				"You See a Machine",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, 
				icon,
				options, 
				options[1]);
				switch(choice)
				{
				case 0:
					{
					JOptionPane.showMessageDialog(frame, "You Got Away Safely");
					getPackedWeapon();
					break;
					}
				case 1:
					{
					JOptionPane.showMessageDialog(frame, "You Left");
					break;
					}
				}
		}
		public static void getPackedWeapon()
		{
			
		}
		public static void fillWithStars()
			{
				for(int row = 0; row<arrayGame.length; row++)
					{
						System.out.println(" ");
						for(int col = 0; col<arrayGame[0].length;col++)
							{
								int letter=(int)(Math.random()*48)+1;
								if (letter <= 46)
								{
									arrayGame[row][col] = " ~~ ";
								}
								else if (letter == 47)
								{
									arrayGame[row][col] = " [] ";
								}
								else if (letter == 48)
								{
									arrayGame [row][col] = " {} ";
								}
							}
						arrayGame[playerRow][playerCol]=" @ ";
					}
				for (int r = 0; r < arrayGame.length; r++)
				{
					for (int c = 0; c < arrayGame[0].length; c++)
					{
						if (c==0 || c==arrayGame[0].length-1)
						{
							arrayGame[r][c] = " | ";
						}
						if (r==0 || r==arrayGame.length-1)
						{
							arrayGame[r][c] = " - ";
						}
					}
				}
				for(int row = 0; row<arrayGame.length; row++)
					{
						System.out.println(" ");
						for(int col = 0; col<arrayGame[0].length;col++)
							{
								System.out.print(arrayGame[row][col]);
							}
					}
			}
		public static void display()
			{
				arrayGame[playerRow][playerCol]=" @ ";
				for(int row = 0; row<arrayGame.length; row++)
					{
						System.out.println(" ");
						for(int col = 0; col<arrayGame[0].length;col++)
							{
								System.out.print(arrayGame[row][col]);
							}
					}
			}
		public static void moveUp()
			{
					if (arrayGame[playerRow-1][playerCol].equals(" [] "))
	        			{
        				arrayGame[playerRow-1][playerCol] = " ~~ ";
        				spinBox();
	        			}
	        			else if (arrayGame[playerRow-1][playerCol].equals(" {} "))
	        			{
	        				arrayGame[playerRow-1][playerCol] = " ~~ ";
	        				packAPunch();
	        			}
	        			else if (arrayGame[playerRow-1][playerCol].equals(" | ")||arrayGame[playerRow-1][playerCol].equals(" - "))
	        			{
	        				JOptionPane.showMessageDialog(frame, "You can't move there.");
	        			}
	        			else
	        			{
					arrayGame[playerRow][playerCol]=" ~~ ";
					playerRow=playerRow-1;
					display();
	        			}
			}
			public static void moveLeft()
			{
        			if (arrayGame[playerRow][playerCol-1].equals(" [] "))
        			{
        				arrayGame[playerRow][playerCol-1] = " ~~ ";
        				spinBox();
        			}
        			else if (arrayGame[playerRow][playerCol-1].equals(" {} "))
        			{
        				arrayGame[playerRow][playerCol-1] = " ~~ ";
        				packAPunch();
        			}
        			else if (arrayGame[playerRow][playerCol-1].equals(" | ")||arrayGame[playerRow][playerCol-1].equals(" - "))
        			{
        				JOptionPane.showMessageDialog(frame, "You can't move there.");
        			}
        			else
        			{
        				arrayGame[playerRow][playerCol]=" ~~ ";
						playerCol=playerCol-1;
						display();
        			}
			}
			public static void moveDown()
			{
					if (arrayGame[playerRow+1][playerCol].equals(" [] "))
        			{
        				arrayGame[playerRow+1][playerCol] = " ~~ ";
        				spinBox();
        			}
        			else if (arrayGame[playerRow+1][playerCol].equals(" {} "))
        			{
        				arrayGame[playerRow+1][playerCol] = " ~~ ";
        				packAPunch();
        			}
        			else if (arrayGame[playerRow+1][playerCol].equals(" | ")||arrayGame[playerRow+1][playerCol].equals(" - "))
        			{
        				JOptionPane.showMessageDialog(frame, "You can't move there.");
        			}
        			else
        			{
					arrayGame[playerRow][playerCol]=" ~~ ";
					playerRow=playerRow+1;
					display();
        			}
			}
			public static void moveRight()
			{
					if (arrayGame[playerRow][playerCol+1].equals(" [] "))
	        			{
        					arrayGame[playerRow][playerCol+1] = " ~~ ";
        					spinBox();
	        				
	        			}
	        			else if (arrayGame[playerRow][playerCol+1].equals(" {} "))
	        			{        					
	        			arrayGame[playerRow][playerCol+1] = " ~~ ";
	        			packAPunch();	
	        			}
	        			else if (arrayGame[playerRow][playerCol+1].equals(" | ")||arrayGame[playerRow][playerCol+1].equals(" - "))
	        			{
	        				JOptionPane.showMessageDialog(frame, "You can't move there.");
	        			}
	        			else
	        			{
					arrayGame[playerRow][playerCol]=" ~~ ";
					playerCol=playerCol+1;
					display();
	        			}
				}
	}