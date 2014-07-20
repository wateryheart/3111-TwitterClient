package hk.ust.cse.TwitterClient.StyleTweet.core;

import hk.ust.cse.TwitterClient.Views.TweetView;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Event;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Chan Ka Yue Martin
 */

public class StyleTweetMouseListener implements IStyleTweetMouseListener {

    static final Logger logger = Logger.getLogger("styleTweet");

    private TweetView TweetView;
    private Set<IHandler> ClickedHandlers;

    public StyleTweetMouseListener(TweetView tweetView) {
        ClickedHandlers = new HashSet<IHandler>();
        TweetView = tweetView;
    }

    private boolean mouseDown = false;
    private boolean mouseMoved = false;
    private float prevX = 0;
    private float prevY = 0;

    @Override
    public void handleEvent(Event event) {

        MouseEvent e = new MouseEvent(event);

        switch (event.type) {
            case SWT.MouseDown:
                mouseDown = true;
                prevX = e.x;
                prevY = e.y;
                 logger.log(Level.INFO, "mouseDown");
                break;
            case SWT.MouseMove:
                if (mouseDown) {
                    float dx = Math.abs(prevX - e.x);
                    float dy = Math.abs(prevY - e.y);

                    if (dx > 10 || dy > 10)
                        mouseMoved = true;
                     logger.log(Level.INFO, "dx: " + dx + ",  dy: " + dy);

                }
                break;
            case SWT.MouseUp:

                if (mouseMoved) {
                     logger.log(Level.INFO, "MouseUp: mouse moved");
                } else {

                    try {
                        StyledText Parent = (StyledText) event.widget;
                        int offset = Parent.getOffsetAtLocation(new Point(e.x, e.y));
                        StyleRange style = Parent.getStyleRangeAtOffset(offset);
                        if (style != null) {
                            boolean triggered = false;
                            for (IHandler handler : ClickedHandlers) {
                                event.data = offset;
                                if (triggered = handler.eventHandle(event))
                                    break;
                            }
                            if (!triggered)
                                TweetView.toggleExpand(e);
                        } else
                            TweetView.toggleExpand(e);
                    } catch (IllegalArgumentException ex) {
                        // no character under event.x, event.y
                        TweetView.toggleExpand(e);
                    }

                     logger.log(Level.INFO, "MouseUp: mouse not moved");
                }
                mouseDown = false;
                mouseMoved = false;
                break;
        }
    }

    @Override
    public void AddClickedHandler(IHandler handler) {
        if (handler != null)
            ClickedHandlers.add(handler);
    }
}
