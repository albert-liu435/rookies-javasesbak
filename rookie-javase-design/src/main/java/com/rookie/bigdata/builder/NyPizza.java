package com.rookie.bigdata.builder;

import java.util.Objects;

/**
 * @ClassName NyPizza
 * @Description NyPizza
 * @Author
 * @Date 2020/4/15 17:15
 * @Version 1.0
 */
public class NyPizza extends Pizza{
    public enum Size {SMALL, MEDIUM, LARGE}

    private final Size size;

    public static class Builder extends Pizza.Builder<Builder> {
        private final Size size;

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override
        public NyPizza build() {
            return new NyPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }
}
