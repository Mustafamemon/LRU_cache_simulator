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
public class Slice {
  double value;
  Color color;
  String text;

  public Slice(double value, Color color,String text) {
    this.value = value;
    this.color = color;
    this.text = text;
  }
}