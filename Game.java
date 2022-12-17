package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Game extends JPanel implements ActionListener
{
    int WIDTH = 500;
    int HEIGHT = 500;
    int DOT = 10;
    int DOT_AMOUNT = 2500;
    int DELAY = 500;

    int x[] = new int[DOT_AMOUNT];
    int y[] = new int[DOT_AMOUNT];

    boolean IS_ALIVE = true;
    boolean left = false;
    boolean right = true;
    boolean up = false;
    boolean down = false;

    Timer timer;
    Image snake_food;
    Image snake_head;
    Image snake_tail;

    int food_x;
    int food_y;
    int food_eaten = 0;

    public Game()
    {
        addKeyListener(new SnakeAdapter());
        setBackground(Color.BLACK);
        setFocusable(true);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        ImageIcon im_food = new ImageIcon("src/images/snake_food.png");
        ImageIcon im_head = new ImageIcon("src/images/snake_head.png");
        ImageIcon im_tail = new ImageIcon("src/images/snake_head.png");

        snake_food = im_food.getImage();
        snake_head = im_head.getImage();
        snake_tail = im_tail.getImage();

    }
    @Override
    public void actionPerformed(ActionEvent e)
    {

    }

    private class SnakeAdapter extends KeyAdapter
    {
        @Override
        public void keyPressed(KeyEvent e)
        {
            int key_code = e.getKeyCode();
            if((key_code == KeyEvent.VK_LEFT) && !right)
            {
                left = true;
                up = false;
                down = false;
            }
            if((key_code == KeyEvent.VK_RIGHT) && !left)
            {
                right = true;
                up = false;
                down = false;
            }
            if((key_code == KeyEvent.VK_UP) && !down)
            {
                up = true;
                right = false;
                left = false;
            }
            if((key_code == KeyEvent.VK_DOWN) && !up)
            {
                down = true;
                right = false;
                left = false;
            }
        }
    }
}
