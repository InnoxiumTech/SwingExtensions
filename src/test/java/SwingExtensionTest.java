import uk.co.innoxium.swing.component.JHyperlink;

import javax.swing.*;
import java.awt.*;

public class SwingExtensionTest {

    public static void main(String... args) {

        JFrame frame = new JFrame("SwingExtensions Test");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 10));

        JHyperlink twitter = new JHyperlink("Twitter");
        twitter.setUrl("twitter.com/shadowchild12");

        frame.getContentPane().add(twitter);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
