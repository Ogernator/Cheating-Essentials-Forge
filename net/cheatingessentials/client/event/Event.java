package net.cheatingessentials.client.event;

import java.util.EventObject;

public abstract class Event extends EventObject
{
    public Event(Object source)
    {
        super(source);
    }

    public enum EventType
    {
        ;
    }
}
