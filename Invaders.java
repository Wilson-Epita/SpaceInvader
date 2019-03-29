public class Invaders
{
	public static void main(String[] args)
	{
		System.out.println("Space Invader");
		

		// Initialisation :
		Visualize display = new Visualize(800, 600);
		boolean stop = false;

		// Game loop :
		while (!stop)
		{
			display.drawGame();
			StdDraw.show(10);
		}
	}
}
