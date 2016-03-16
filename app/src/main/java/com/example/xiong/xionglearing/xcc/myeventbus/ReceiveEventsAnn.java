package com.example.xiong.xionglearing.xcc.myeventbus;

public final class ReceiveEventsAnn extends Ann<ReceiveEvents> {

    public final String[] names;

    public ReceiveEventsAnn(ReceiveEvents annotation) {
        super(annotation);
        String[] names;
        if (hackSuccess()) {
            names = (String[]) getElement(NAME);
            cleanup();
        } else {
            names = annotation.name();
        }
        boolean none = (names.length == 1) && isEmpty(names[0]);
        if (none) {
            this.names = new String[0];
        } else {
            this.names = names;
        }
    }

    public static boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

}
