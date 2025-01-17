/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cache;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.*;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author Mustafa
 */
class MyComponent extends JComponent {
  Slice[] slices =  new Slice[2];
  int hit , miss ,total;

  MyComponent(double hits,double misses,int hit ,int miss , int total) {
    slices[0]=new Slice(hits,Color.green,"Hit Rate : ");
    slices[1]=new Slice(misses,Color.red,"Miss Rate : ");
    this.hit=hit;
    this.miss=miss;
    this.total=total;
  }
  public void paint(Graphics g) {
    drawPie((Graphics2D) g, getBounds(), slices);
  }

  void drawPie(Graphics2D g, Rectangle area, Slice[] slices) {
    double total = 0.0D;
    Font font = new Font("Tahoma", Font.BOLD, 24);
    Font font_1 = new Font("Tahoma", Font.ITALIC, 20);
        g.setFont(font);
// Title of Pie Chart
        g.drawString("LRU Cache Simulator", 100, 30);
        g.setFont(font_1);
        area.x=10;
        area.y=40;
    for (int i = 0; i < slices.length; i++) {
      total += slices[i].value;
    }

    double curValue = 0.0D;
    int startAngle = 0;
    for (int i = 0; i < slices.length; i++) {
            g. setColor(slices[i].color);
            g.fillRect(area.x, area.y, 15, 10);
            g.setColor(Color.BLACK);
            area.y+=20;
            g.drawString(""+slices[i].text + slices[i].value+"%", area.x+25, area.y-10);
    }
    g.drawString("No of Hits : "+ hit , area.x+25, area.y+10);
    g.drawString("No of Misses : "+ miss , area.x+25, area.y+30);
    g.drawString("Total Access : "+ this.total, area.x+25, area.y+50);
    area.y+=60;
    area.x=100;
  for (int i = 0; i < slices.length; i++) {
      startAngle = (int)(curValue * 360 / total);
            int finalAngle = (int)(slices[i].value * 360 / total);
//loop for last slice
            if (i == slices.length-1) 
                        {
                finalAngle = 360 - startAngle;
            }
// Pulling color from array and setting accordingly
        g.setColor(slices[i].color); //pulling color
        // drawing pie piece
                g.fillArc(area.x, area.y, area.width/2, (area.height-100)/2, startAngle, finalAngle);

        curValue += slices[i].value;
        
  
  }
  g.setColor(Color.BLACK);
  area.x = 100;
  area.y = 450;
  g.drawString("Group Members : ",area.x, area.y); 
  g.drawString("Muhammad Mustafa Manga : 17K-3795" , area.x, area.y+30);
  g.drawString("Huzaifa Abid : 17K-3807" , area.x, area.y+60);
  g.drawString("Danish Abdullah : 17K-3720", area.x, area.y+90);
  
  
  }
}