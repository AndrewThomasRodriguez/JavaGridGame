public class GameSettings {
    public static final String VERSION = "0.0.1";
    static final int WINDOW_WIDTH = 480;
    static final int WINDOW_HEIGHT = 270;

    //timing
    static final int MillisecondsInsecond = 1_000;
    static final int UpdateRateHz = 25;
    static final int UpdateRateMs = MillisecondsInsecond / UpdateRateHz;
    
    static final int MaxTimerTicks = 1_000_000;

    //graphics
    public static final String FILE_GRAPHICS_BASE = "sprites//";
    public static final String TEST_SPRITE_FILE = FILE_GRAPHICS_BASE + "TestSprite.png";
}
