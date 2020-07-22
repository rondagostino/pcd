import org.pcollections.ConsPStack;
import org.pcollections.PStack;

public class Main {

    public static void main(String[] args) {
        System.console().printf("[add|del|pop|quit] [key [value]]\n");
        PStack<Handle> handles = ConsPStack.singleton(new Handle());
        String operation = "";
        do {
            String line = System.console().readLine().trim();
            String[] split = line.split(" +", 3);
            operation = split[0];
            if (!operation.equals("quit")) {
                if (operation.equals("pop")) {
                    if (handles.size() > 1) {
                        System.console().printf("Popping\n");
                        handles = handles.minus(0);
                    } else {
                        System.console().printf("Nothing to pop!\n");
                    }
                    print(handles);
                } else if (split.length > 1) {
                    String key = split[1];
                    if (operation.equals("del")) {
                        System.console().printf("Deleting %s\n", key);
                        handles = handles.plus(handles.get(0).del(key));
                        print(handles);
                    } else if (operation.equals("add") && split.length > 2) {
                        String value = split[2];
                        System.console().printf("Adding %s -> %s\n", key, value);
                        handles = handles.plus(handles.get(0).add(key, value));
                        print(handles);
                    }
                }
            }
        } while (!operation.equals("quit"));
    }

    private static void print(PStack<Handle> handles) {
        String maxPad = new String(new char[handles.size()]).replace('\0', ' ');
        for (int index = 0; index < handles.size(); ++index) {
            System.console().printf("%s%s\n",
                    maxPad.substring(0, handles.size() - index),
                    handles.get(index).toString());
        }
    }
}
