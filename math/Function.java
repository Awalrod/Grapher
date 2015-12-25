package math;
import uk.co.cogitolearning.cogpar.*;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by alex on 12/19/15.
 */
public class Function {
    ExpressionNode expr;
    String name;
    public boolean defined;

    public Function(String n, String f){
        expr = (new Parser()).parse(f);
        name = n;
        defined = true;
    }
    public Function(String n, ExpressionNode e){
        expr = e;
        name = n;
        defined = true;
    }
    public Function(String n){
        name = n;
        defined = false;
    }


    public ArrayList<Point> graph(double start, double stop, double definition){

        ArrayList<Point> points = new ArrayList<>();
        for(double x = start; x<stop; x += definition){
            defineVariable("x",x);
            points.add(new Point(x,expr.getValue()));
        }
        return points;
    }
    public void setExpr(ExpressionNode e){
        expr = e;
        defined = true;
    }

    public void defineVariable(String name, double value){
        expr.accept(new SetVariable(name,value));
    }
}
