public class Invaders
{
	public static void main(String[] args)
	{
		System.out.println("Space Invader");
		

		// Initialisation :
		Player player = new Player(5, 90, 60);
		Visualize display = new Visualize(800, 800, player);
		boolean stop = false;

		// Game loop :
		while (!stop)
		{
			player.comportement();
			display.drawGame();
			StdDraw.show(10);
		}
	}
}
