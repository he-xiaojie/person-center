package com.hexiaojie.person.center.designpattern;

/**
 *
 * 单例模式-DCL（双重检查锁）
 */
public class Singleton {
    /**
     * 1.
     * 默认无参构造方法私有化,这样外界就不能再通过new关键字来创建该对象了。
     * 2.
     * 把对象的创建设置为静态static的,这样在加载时初始化这个类的时候就会自动分配内存空间。方便外部调用该类的静态类方法。
     * 3.
     * 统一通过getInstance()方法返回该对象在内存中的唯一实例。 这里是因为static修饰的引用类型在类加载的时候只会在准备阶段分配空间，然后在初始化阶段实例化一次。
     */
    public static volatile Singleton singleton = null;

    //私有的无参构造方法，防止别人在外部实例化
    private Singleton(){

    }

    public static Singleton getSingleton(){
        if(singleton == null){
            synchronized(Singleton.class){
                if(singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

}
