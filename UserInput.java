import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.CacheRequest;

enum KEYS {
  UP, //1
  DOWN, //2
  LEFT, //3
  RIGHT, //4
  SELECT, //5
  INTERACT, //6
  BACK, //7
  //update keyCount in UserInput if you add more
}

public class UserInput implements KeyListener {

    final int keyCount = 7; //count of all the keys
    boolean[] keyState = new boolean[keyCount];
    int[] keyStateTimer = new int[keyCount]; 
    int keyTimerLastUpdate = 0;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public static int KeytoId(KEYS inKey){
        return inKey.ordinal();
    }

    //call only once per game tick to udpate the key timers
    public void UpdateKeyTimers(){

        for(int keyId = 0; keyId < keyCount; ++keyId){
            //move timer based on key state
            if (keyState[keyId]){
                if (keyStateTimer[keyId] < 0) keyStateTimer[keyId] = 0; //reset timer if new state
                keyStateTimer[keyId]++;
            } else { 
                if (keyStateTimer[keyId] > 0) keyStateTimer[keyId] = 0;
                keyStateTimer[keyId]--;
            }

            //make sure to not go over max
            keyStateTimer[keyId] = Tools.Clamp(keyStateTimer[keyId], -GameSettings.MaxTimerTicks, GameSettings.MaxTimerTicks);
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
        //System.out.println("keyPressed="+e.getKeyCode());
        
        int keyCode = e.getKeyCode();
        
        switch(keyCode){
            case 'W':
            case 38: //up arrow
                keyState[KeytoId(KEYS.UP)] = true;
                break;
            case 'S':
            case 40: //down arrow
                keyState[KeytoId(KEYS.DOWN)] = true;
                break;
            case 'D': //right
            case 39:
                keyState[KeytoId(KEYS.RIGHT)] = true;
                break;
            case 'A':
            case 37:
                keyState[KeytoId(KEYS.LEFT)] = true;
                break;
            case 27: //esc
            case 'P':
            case 192: //`
                keyState[KeytoId(KEYS.SELECT)] = true;
                break;
            case 10: //enter
            case 32: //space
                keyState[KeytoId(KEYS.INTERACT)] = true;
                break;
            case 8: //backspace
            case 17: //Ctrl
                keyState[KeytoId(KEYS.BACK)] = true;
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        //System.out.println("keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
        
        int keyCode = e.getKeyCode();
        
        switch(keyCode){
            case 'W':
            case 38: //up arrow
                keyState[KeytoId(KEYS.UP)] = false;
                break;
            case 'S':
            case 40: //down arrow
                keyState[KeytoId(KEYS.DOWN)] = false;
                break;
            case 'D': //right
            case 39:
                keyState[KeytoId(KEYS.RIGHT)] = false;
                break;
            case 'A':
            case 37:
                keyState[KeytoId(KEYS.LEFT)] = false;
                break;
            case 27: //esc
            case 'P':
            case 192: //`
                keyState[KeytoId(KEYS.SELECT)] = false;
                break;
            case 10: //enter
            case 32: //space
                keyState[KeytoId(KEYS.INTERACT)] = false;
                break;
            case 8: //backspace
            case 17: //Ctrl
                keyState[KeytoId(KEYS.BACK)] = false;
                break;
        }

    }
 
}