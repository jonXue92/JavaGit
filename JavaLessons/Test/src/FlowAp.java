import java.awt.Button;
import java.awt.Frame;

public class FlowAp extends Frame{
    public static void main(String argv[]){
        FlowAp fa=new FlowAp();
        fa.setSize(400,300);
        fa.setVisible(true);
    }
    FlowAp(){
        add(new Button("One"));
        add(new Button("Two"));
        add(new Button("Three"));
        add(new Button("Four"));
    }//End of constructor
}//End of Application