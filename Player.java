import java.awt.event.KeyEvent;

public class Player
{
	private double	x, y;
	private boolean	isAlive;
	private double	speed;
	private int		w, h;
	private int		minPos, maxPos;

	// Constructor :
	public Player(double pSpeed, int pW, int pH)
	{
		w = pW;
		h = pH;
		speed = pSpeed;
		y = 60;
		maxPos = 400 - (int)(0.5 * pW);
		minPos = -maxPos;
	}

	// Getters & Setters :
	public int getX()
	{
		return (int)(x);
	}
	
	public int getY()
	{
		return (int)(y);
	}

	// Moving
	private void moveLeft()
	{
		x -= speed;
		x = (x < minPos) ? minPos : x;
	}

	private void moveRight()
	{
		x += speed;
		x = (x > maxPos) ? maxPos : x;
	}

	// Control :
	public void comportement()
	{
		if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT))
			this.moveLeft();
		if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT))
			this.moveRight();
	}


}
