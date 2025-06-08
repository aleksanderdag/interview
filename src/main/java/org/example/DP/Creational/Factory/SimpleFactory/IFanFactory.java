package org.example.DP.Creational.Factory.SimpleFactory;

@FunctionalInterface
public interface IFanFactory {
    IFan createFan(FanType type);

    IFanFactory FanFactory = FanType::createFan;
}
