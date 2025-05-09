import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 1. Greeting Interface
interface Greeting {
    void sayHello();
}

// 2. GreetingImpl Class (Implementation of the Greeting Interface)
class GreetingImpl implements Greeting {
    @Override
    public void sayHello() {
        System.out.println("Hello, World!");
    }
}

// 3. Logging Proxy Handler (Intercepts method calls and logs them)
class LoggingProxyHandler implements InvocationHandler {
    private final Object target;

    public LoggingProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // Log the method name
        System.out.println("Method " + method.getName() + " is being called");

        // Call the actual method on the target object
        return method.invoke(target, args);
    }
}

// 4. Main Class to Create and Use the Proxy
class ProxyExample {
    public static void main(String[] args) {
        // Create the original object (GreetingImpl)
        Greeting greeting = new GreetingImpl();

        // Create the logging proxy for the Greeting interface
        Greeting proxyGreeting = (Greeting) Proxy.newProxyInstance(
                Greeting.class.getClassLoader(),
                new Class[]{Greeting.class},
                new LoggingProxyHandler(greeting)
        );

        // Call the method on the proxy object
        proxyGreeting.sayHello(); // This will log the method name before execution
    }
}
