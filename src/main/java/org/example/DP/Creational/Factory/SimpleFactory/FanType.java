package org.example.DP.Creational.Factory.SimpleFactory;

import static org.example.DP.Creational.Factory.SimpleFactory.IFan.cf;
import static org.example.DP.Creational.Factory.SimpleFactory.IFan.jf;

public enum FanType {
    TABLE_FAN(TableFan.class),
    CEILING_FAN(cf.getClass()),
    EXHAUST_FAN(jf.getClass());

    private final Class<? extends IFan> clazz;

    FanType(Class<? extends IFan> clazz) {
        this.clazz = clazz;
    }

    public IFan createFan() {
        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            return null;
        }
    }
}
