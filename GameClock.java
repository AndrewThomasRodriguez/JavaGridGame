import java.util.EmptyStackException;

public class GameClock {
    static int masterTmer = 0;

    //only call once per game tick
    public static int TickMasterTimer(){
        if (++masterTmer == Integer.MAX_VALUE)
            throw new ArithmeticException("Game Clock timer overflow.");
        return masterTmer;
    }

    //use for loading, value should be bigger than what it is already
    public static void SetMasterTimerStart(int newTimerTicks){
        masterTmer = newTimerTicks;
    }

    public static int GetMasterTimerTicks(){
        return masterTmer;
    }

    public static long MasterTimerInMs(){
        return Tools.TicksToMs(masterTmer);
    }
}
