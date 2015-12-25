package gui;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import javax.swing.*;

import math.ConstantVariable;
import math.Function;
import math.Point;

/**
 * Created by alex on 12/19/15.
 */
public class Graph extends JFrame {
    double lowerX;
    double upperX;
    double lowerY;
    double upperY;
    double xInterval;
    double yInterval;
    double sizeX;
    double sizeY;
    double definition;

    ArrayList<Function> functions;
    ArrayList<ConstantVariable> constants;
    static Color colors[] = {Color.BLUE, Color.RED, Color.GREEN, Color.CYAN,Color.PINK,Color.YELLOW};

    public Graph(int sizeX, int sizeY){
        lowerX = -350;
        lowerY = -350;
        upperX = 350;
        upperY = 350;
        xInterval = 10;
        yInterval = 10;
        definition = .01;
        this.sizeX = (double) sizeX;
        this.sizeY = (double) sizeY;
        setSize(sizeX, sizeY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Graph");
        setResizable(false);
        setVisible(true);
        functions = new ArrayList<>();
        constants = new ArrayList<>();
        for(int x = 0; x < 10;x += 1){
            Function f = new Function("f"+Integer.toString(x));
            functions.add(x,f);
        }
    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;

        g2d.setColor(Color.BLACK);
        Point origin = scale(new Point(0,0));

        g2d.draw(new Line2D.Double(0, origin.y, sizeY, origin.y));//x-axis
        g2d.draw(new Line2D.Double(origin.x, 0, origin.x, sizeX));//y-axis

        g2d.setColor(Color.LIGHT_GRAY);
        for(double x = xInterval; x<upperX; x += xInterval){//positive vertical grid
            Point p = scale(new Point(x,0));
            g2d.draw(new Line2D.Double(p.x,0,p.x,sizeY));
        }
        for(double x = -xInterval;x>lowerX;x -= xInterval){//negative vertical grid
            Point p = scale(new Point(x,0));
            g2d.draw(new Line2D.Double(p.x,0,p.x,sizeY));
        }
        for(double y = yInterval;y<upperY;y+= yInterval){//positive horizontal grid
            Point p = scale(new Point(0,y));
            g2d.draw(new Line2D.Double(0,p.y,sizeX,p.y));
        }
        for(double y = -yInterval;y>lowerY;y-= yInterval){//negative horizontal grid
            Point p = scale(new Point(0,y));
            g2d.draw(new Line2D.Double(0,p.y,sizeX,p.y));
        }

        int colorCounter = 0;
        for(Function f : functions){
            if(f.defined){
                for(ConstantVariable k: constants){
                    //System.out.println(k.name+" "+Double.toString(k.value));
                    f.defineVariable(k.name,k.value);
                }
                g2d.setColor(colors[colorCounter%6]);
                colorCounter += 1;
                for(Point p : f.graph(lowerX,upperX,definition)){
                    Point p1 = scale(p);
                    g2d.fill(new Ellipse2D.Double(p1.x,p1.y,2,2));
                }
            }
        }

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    private Point scale(Point p){
        double newX = (sizeX/(upperX-lowerX))*(p.x-lowerX);
        double newY = sizeY - ((sizeY/(upperY-lowerY))*(p.y-lowerY));
        return new Point(newX,newY);
    }

    public void setWindow(double lowerX,double upperX,double lowerY,double upperY){
        this.lowerX = lowerX;
        this.lowerY = lowerY;
        this.upperX = upperX;
        this.upperY = upperY;
        repaint();
    }
    public void setInterval(double xInterval, double yInterval){
        this.xInterval = xInterval;
        this.yInterval = yInterval;
        repaint();
    }
    public void setDefinition(double definition){
        this.definition = definition;
        repaint();
    }

    public void setFunctions(String[] newFunctions){
        for(int x = 0;x < 10;x += 1){
            if(!(newFunctions[x].isEmpty())){
                setFunction(x,new Function("f"+Integer.toString(x),newFunctions[x]));
            }else{
                functions.get(x).defined = false;
            }

        }
        repaint();
    }

    public void setFunction(int index,Function f){
        functions.set(index, f);
    }

    public void addConstant(String name, double value){
        System.out.println(value);
        for(int x = 0; x < constants.size();x+=1){
            if(constants.get(x).name.equals(name)){
                constants.set(x,new ConstantVariable(name,value));
            }
        }

        if(constants.size() == 0){
            constants.add(new ConstantVariable(name,value));
        }
    }

    public void removeConstant(String name){
        for(int x = 0; x < constants.size();x+=0){
            if(name.equals(constants.get(x).name)){
                constants.remove(x);
            }
        }
    }

}
