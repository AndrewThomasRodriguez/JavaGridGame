public class Tools {
    static int Clamp(int value, int min, int max) {
        return Math.min(Math.max(value, min), max);
     }

     static long TicksToMs(int tick){
        return (long)tick * (long)GameSettings.UpdateRateMs;
     }

     static int MsToTicks(int milliseconds){
        return milliseconds / GameSettings.UpdateRateMs;
     }
}
