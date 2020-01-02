package innnerclass;

/**
 * @Auther ljn
 * @Date 2020/1/2
 * 仿照hystrix进行属性赋值(其实还是使用了静态内部类),个人认为静态内部类
 * 不依赖外部类的特性是很多代码使用静态内部类最大的原因
 */
public class HystrixThreadPoolProperties {
    /**
     * Factory method to retrieve the default Setter.
     */
    public static Setter Setter() {
        return new Setter();
    }

    public static class Setter {
        private Integer coreSize = null;
        private Integer maxQueueSize = null;

        /**
         * 外部无法通过new来构建
         */
        private Setter() {
        }

        public Setter withCoreSize(int value) {
            this.coreSize = value;
            return this;
        }

        public Setter withMaxQueueSize(int value) {
            this.maxQueueSize = value;
            return this;
        }
    }

    public static void main(String[] args) {
        Setter setter = HystrixThreadPoolProperties.Setter().withCoreSize(10).withMaxQueueSize(5);
    }
}
