public class GameTimer {
    
    int timerTicks = 0;
    int timerTooTicks = 0;

    public int GetTimerTicksRaw(){
        return timerTicks;
    }

    public int GetTimerTooRaw(){
        return timerTooTicks;
    }

    public int SetTimerTicksRaw(int newTickValue){
        timerTicks = newTickValue;
        ClampTimer();
        return timerTicks;
    }

    public int SetTimerTooRaw(int newTimerToo){
        timerTooTicks = newTimerToo;
        ClampTimer();
        return timerTooTicks;
    }

    private void ClampTimer(){
        timerTicks = Tools.Clamp(timerTicks, 0, GameSettings.MaxTimerTicks);
        timerTooTicks = Tools.Clamp(timerTooTicks, 0, GameSettings.MaxTimerTicks);
    }

    //only call once per game tick
    public int TickTimer(){
        return ++timerTicks;
    }

    
}
