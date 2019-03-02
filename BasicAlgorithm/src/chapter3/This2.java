package chapter3;

class Time {
    private int hour;
    private int minute;
    private int second;
    public Time(){
        this(12,0,0);
        System.out.println("time():"+this);
    }
    public Time(int hour,int minute,int sccond){
        System.out.println("construct:"+hour+" "+minute+" "+second);
        this.hour=hour;
        this.minute=minute;
        this.second=second;
    }
    public String incSecondAndOutput(){
        this.incSecond();
        return new String(this.hour+":"+this.minute+":"+this.second);
    }
    public void incSecond(){
        this.second+=1;
    }
}

public class This2 {
    public static void main(String args[]) {
        Time myTime = new Time(0,0,0);
        System.out.println("main(): " + myTime);
        String t=myTime.incSecondAndOutput();
        System.out.println(t);
    }
}