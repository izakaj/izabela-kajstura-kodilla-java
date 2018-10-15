package com.kodilla.good.patterns.challenges.food2door;

import java.util.List;

public interface Producer {

    boolean process(List<OrderedProduct> orderFromProducer);
}
