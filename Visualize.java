public class Visualize
{
	private int w, h;

	public Visualize(int width, int height)
	{
		w = width;
		h = height;
		initWindow();
	}

	public void drawGame()
	{
		StdDraw.clear();
		drawGameBackground();
	}

	public void drawMenu()
	{
	
	}

	public void initWindow()
	{
		StdDraw.setCanvasSize(w, h);
		StdDraw.setXscale(-w/2, w/2);
		StdDraw.setYscale(0, h);
	}
	
	private void drawGameBackground()
	{
		StdDraw.picture(0, 400, "img/black_background.jpg");
	}
}
