package uk.co.innoxium.swing.component;

import uk.co.innoxium.swing.util.DesktopUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * When using this class
 */
public class JHyperlink extends JLabel {

    private String url;
    private String protocol = "http://";
    private String html = "<html><a href = ''>%s</a></html>";
    private Color colour = Color.BLUE.darker();
    private Color highlightedColour = colour;
    private Color clickedColour = Color.decode("#663366");

    private boolean isClicked = false;

    public JHyperlink(String text) {

        this(text, null, null);
    }

    public JHyperlink(String text, String url) {

        this(text, url, null);
    }

    public JHyperlink(String text, String url, String toolTip) {

        super(text);
        this.url = url;

        this.setForeground(colour);
        this.setToolTipText(toolTip);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                isClicked = true;
                setForeground(clickedColour);
                DesktopUtil.openURL(JHyperlink.this.protocol, JHyperlink.this.url);
//                    Desktop.getDesktop().browse(new URI(String.format("%s%s", JHyperlink.this.protocol, JHyperlink.this.url)));
            }

            @Override
            public void mouseEntered(MouseEvent e) {

                setText(String.format(html, text));
                if(!isClicked) setForeground(highlightedColour);
            }

            @Override
            public void mouseExited(MouseEvent e) {

                setText(text);
                if(!isClicked) setForeground(colour);
            }
        });
    }

    public String getUrl() {

        return url;
    }

    public void setUrl(String url) {

        this.url = url;
    }

    public String getProtocol() {

        return protocol;
    }

    public void setProtocol(String protocol) {

        this.protocol = protocol;
    }

    public Color getColour() {

        return colour;
    }

    public void setColour(Color colour) {

        this.colour = colour;
    }

    public Color getHighlightedColour() {

        return highlightedColour;
    }

    public void setHighlightedColour(Color highlightedColour) {

        this.highlightedColour = highlightedColour;
    }

    public Color getClickedColour() {

        return clickedColour;
    }

    public void setClickedColour(Color clickedColour) {

        this.clickedColour = clickedColour;
    }
}
