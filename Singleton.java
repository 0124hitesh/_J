class Singleton implements Cloneable{

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning of Singleton is not allowed");
    }

    
    private static volatile Singleton instance;

    public Singleton getSingletonInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }
}
