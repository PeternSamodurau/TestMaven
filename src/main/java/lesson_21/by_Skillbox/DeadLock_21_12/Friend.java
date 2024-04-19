package lesson_21.by_Skillbox.DeadLock_21_12;

import lombok.Getter;

public class Friend implements Comparable<Friend>{

    private final String name;

    public Friend(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    //было виснет

//    public synchronized void throwBallTo(Friend catcher){
//
//        System.out.format("%s: %s кинул мне мяч! %n", catcher.getName(), this.name);
//        catcher.throwBallTo(this);
//    }
    public void throwBallTo(Friend catcher){                                          // убираем synchronized

        System.out.format("%s: %s кинул мне мяч! %n", catcher.getName(), this.name);
        synchronized (compareTo(catcher) > 0 ? catcher: this){                        //блокируем по обьекту который меньше
        catcher.throwBallTo(this);
        }
    }

    @Override
    public int compareTo(Friend o) {
        return this.getName().compareTo(o.getName());
    }
}
