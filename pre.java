class Message {

    private String msg;

    Message(String str) {
        this.msg = str;
    }

    void setmsg(String str) {
        this.msg = str;
    }

    String getmsg() {
        return msg;
    }
}

class Waiter implements Runnable {

    private Message msg;

    Waiter(Message m) {
        this.msg = m;
    }

    public void run() {
        String name = Thread.currentThread().getName();
        synchronized (msg) {
            try {
                System.out.println(name + "waiting to get nofified at time : " + System.currentTimeMillis());
                msg.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(name + "waiting thread got notified at tiem : " + System.currentTimeMillis());
            // process the message now
            System.out.println(name + "processed:" + msg.getmsg());
        } // syn block
    }
}

class Notifier implements Runnable {
    private Message msg;

    Notifier(Message msg) {
        this.msg = msg;
    }

    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name +  " Started");

        try {
            Thread.sleep(1000);
            synchronized (msg) {
                msg.setmsg(name + "Nofifier work done ");
                msg.notify();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class WaiterNotifyTest {
    public static void main(String arg[]) {
        Message msg = new Message("process it");
        Waiter w = new Waiter(msg);
        new Thread(w, "waiter").start();

        Waiter ww = new Waiter(msg);
        new Thread(ww, "waiter").start();

        Notifier not = new Notifier(msg);
        new Thread(not, "notifier").start();
        System.out.println("All the threads are started ");
    }
}
