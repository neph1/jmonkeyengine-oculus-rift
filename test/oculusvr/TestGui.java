package oculusvr;

import com.jme3.app.SimpleApplication;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import oculusvr.state.OVRAppState;
import com.jme3.font.BitmapFont;
import com.jme3.font.BitmapText;
import com.jme3.font.Rectangle;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.ui.Picture;
import java.util.logging.Level;
import java.util.logging.Logger;
import oculusvr.app.OVRApplication;
import oculusvr.input.OculusRift;
import oculusvr.util.OculusGuiNode;

public class TestGui extends OVRApplication {

    private static OVRAppState stereoCamAppState;
    Spatial observer = new Node("");

    private String txtB =
    "ABCDEFGHIKLMNOPQRSTUVWXYZ1234567 890`~!@#$%^&*()-=_+[]\\;',./{}|:<>?";

    private BitmapText txt;
    
    boolean moveForward, moveBackwards, rotateLeft, rotateRight;
    Node scene;
    public static void main(String[] args) {
        TestGui app = new TestGui();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        super.simpleInitApp();
        this.flyCam.setMoveSpeed(10);
        Node mainScene=new Node();

        scene = new Node();
        
        observer.setLocalTranslation(new Vector3f(0.0f, 0.0f, -10.0f));//observer.setLocalTranslation(new Vector3f(0,0,5));
        
        observer.addControl(ovrAppState.getCameraControl());
        mainScene.attachChild(observer);
       
        rootNode.attachChild(mainScene);
        
        BitmapFont fnt = assetManager.loadFont("Interface/Fonts/Default.fnt");
        txt = new BitmapText(fnt, false);
        txt.setBox(new Rectangle(settings.getWidth()*0.25f, settings.getHeight()*0.25f, settings.getWidth() * 0.75f, settings.getHeight() * 0.75f));
        txt.setSize(fnt.getPreferredSize() * 2f);
        txt.setColor(ColorRGBA.White);
        txt.setText(txtB);
        
        guiNode.attachChild(txt);
        
        OculusRift.getAppState().getGuiNode().setGuiScale(0.5f);
    }

    @Override
     public void update(){
         super.update();
     }

    
}

