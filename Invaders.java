public class Invaders
{
	public static void main(String[] args)
	{
		System.out.println("Space Invader");
		

		// Initialisation :
		Visualize.initWindow(800, 600);
		boolean stop = false;

		// Game loop :
		while (!stop)
		{
			Visualize.drawGame();
			StdDraw.show(10);
		}
	}
}
