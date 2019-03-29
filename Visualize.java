public class Visualize
{
	public static void drawGame()
	{
		StdDraw.clear();
		drawGameBackground();
	}

	public static void drawMenu()
	{
	
	}

	public static void initWindow(int w, int h)
	{
		StdDraw.setCanvasSize(w, h);
		StdDraw.setXscale(-w/2, w/2);
		StdDraw.setYscale(0, h);
	}
	
	private static void drawGameBackground()
	{
		StdDraw.picture(0, 400, "img/black_background.jpg");
	}
}
