import javax.swing.*;
import java.util.*;
public class Frame extends JFrame {

    public Frame(int width, int height) {
        JFrame frame = new JFrame("Kingdom Builder");
        frame.setSize(width, height);
        frame.setVisible(true);
        frame.setResizable(false);
        add(new JPanel());
    }
}
