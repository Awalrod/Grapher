package math;

/**
 * Created by alex on 12/20/15.
 */
public class ConstantVariable  {
    public String name;
    public double value;
    public ConstantVariable(String name, double value){
        this.name = name;
        this.value = value;
    }

    public boolean isEqual(ConstantVariable k){
        if(value == k.value){
            return true;
        }
        else{
            return false;
        }
    }
}
