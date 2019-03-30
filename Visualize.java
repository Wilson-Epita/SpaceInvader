public class Visualize
{
	private int w, h;
	private Player player;

	public Visualize(int width, int height, Player player)
	{
		w = width;
		h = height;
		this.player = player;
		initWindow();
	}
 
	public void initWindow()
	{
		StdDraw.setCanvasSize(w, h);
		StdDraw.setXscale(-w/2, w/2);
		StdDraw.setYscale(0, h);
	}
	 
	public void drawGame()
	{
		StdDraw.clear();
		drawGameBackground();
		drawPlayer();
	}

	public void drawMenu()
	{
	
	}

	private void drawGameBackground()
	{
		StdDraw.picture(0, 400, "img/black_background.jpg");
	}

	private void drawPlayer()
	{
		StdDraw.picture(player.getX(), player.getY(), "img/player_s.png");
	}
}
