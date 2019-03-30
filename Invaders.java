public class Invaders
{
	public static void main(String[] args)
	{
		System.out.println("Space Invader");
		

		// Initialisation :
		Player player = new Player(8, 90, 60);
		Alien[][] aliens = Alien.initAliens(4, 6, 60, 45, 2);
		Visualize display = new Visualize(800, 800, player, aliens);

		int aliensDirection = 1;
		boolean stop = false;

		// Game loop :
		while (!stop)
		{
			player.comportement(aliens);
			if (Alien.changeDirection(aliens))
			{
				aliensDirection = -aliensDirection;
				Alien.aliensDown(aliens);
			}
			Alien.comportement(aliens, aliensDirection);
			display.drawGame();
			StdDraw.show(10);
		}
	}
}
