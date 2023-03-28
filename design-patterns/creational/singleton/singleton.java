// eager loading
class singleton {
    private static singleton instance = new singleton();
    private singleton(){
        System.out.println("Singleton created");
    }
    public static getInstance(){
        return instance;
    }
}

// lazy loading - with concurrency issues
class singleton{
    private static singleton instance = null;
    private singleton(){
        System.out.println("Singleton created");
    }
    /*
     if two threads - t1 and t2 - call getInstance() at the same time,
     both threads will get null and both will create a new instance.
    */
    public static getInstance(){
        if(instance == null){
            instance = new singleton();
        }
        return instance;
    }
}

// lazy loading - without concurrency issues
class singleton{
    private static singleton instance = null;
    private singleton(){
        System.out.println("Singleton created");
    }
    /*
     if two threads - t1 and t2 - call getInstance() at the same time,
     handle by using in-built java synchronized keyword.
    */
    
}