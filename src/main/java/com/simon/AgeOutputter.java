package com.simon;

import java.util.function.Consumer;

/**
 * Created by Simon on 09/11/2016.
 */
@FunctionalInterface
public interface AgeOutputter extends Consumer<Details> {
    public void accept(Details details);
}

