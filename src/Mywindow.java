import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.URL;
import java.nio.Buffer;
import javax.imageio.ImageIO;
import javax.swing.*;


public class Mywindow extends JFrame {
    BufferedImage backImage;
    CloseButton cButt;
    RegistrationButton rButton;
    RegistrationTextFieldName rTextFieldName;
    RegistrationTextFieldHost rTextFieldHost;
    public Mywindow() {
        super("MyWindow");

        try {
            backImage = ImageIO.read(new URL("https://hdfon.ru/wp-content/uploads/hdfon.ru-987911.jpg"));
        } catch (Exception e){}

        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);

        add(cButt = new CloseButton(this));
        add(rButton = new RegistrationButton());
        add(rTextFieldName = new RegistrationTextFieldName());
        add(rTextFieldHost = new RegistrationTextFieldHost());
        setVisible(true);
    }
    public void paint(Graphics gr) {
        super.paint(gr);
        try {
            gr.drawImage(backImage, 0, 0, getWidth(), getHeight(), null);
        } catch (Exception ex){}
        cButt.repaint();
        rButton.repaint();
        rTextFieldName.repaint();
        rTextFieldHost.repaint();
    }
}

class CloseButton extends JButton implements ActionListener {
    Mywindow parentWin;
    public CloseButton(Mywindow win) {
        super("CLOSE");
        parentWin = win;
        setSize(100, 50);
        setLocation(200, 600);
        setBackground(new Color(127, 20, 20));

        addActionListener(this);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        parentWin.dispose();
    }
}

class RegistrationButton extends JButton implements ActionListener {
    public RegistrationButton() {
        super("Log in");

        setSize(100, 50);
        setLocation(200, 200);
        setBackground(new Color(78, 120, 13));
        addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

    }
}

class RegistrationTextFieldName extends JTextArea {
    public RegistrationTextFieldName() {
        super("Name");
        setSize(100, 20);
        setLocation(200, 100);

    }
}

class RegistrationTextFieldHost extends JTextArea {
    public RegistrationTextFieldHost() {
        super("Host");
        setSize(100, 20);
        setLocation(200, 150);

    }
}
