package calculator.Client.cache;

import java.util.LinkedList;
import calculator.NotepadPlus;;
import java.util.ListIterator;

/**
 * Created by boecn on 12.05.2017.
 */
public class DoubleCache {
    public static LinkedList<NotepadPlus> cacheOperation1 = new LinkedList<>();
    public static LinkedList<NotepadPlus> cacheOperation2 = new LinkedList<>();
    private ListIterator<NotepadPlus> iterator;

    public LinkedList<NotepadPlus> getCacheOperation1() {
        return cacheOperation1;
    }

    public void setCacheOperation1(LinkedList<NotepadPlus> cacheOperation1) {
        this.cacheOperation1 = cacheOperation1;
    }

    public LinkedList<NotepadPlus> getCacheOperation2() {
        return cacheOperation2;
    }

    public void setCacheOperation2(LinkedList<NotepadPlus> cacheOperation2) {
        this.cacheOperation2 = cacheOperation2;
    }


    public void push(NotepadPlus node){
        if(cacheOperation1.size()==10) {
            cacheOperation2.addFirst(cacheOperation1.getLast());
            cacheOperation1.removeLast();
        }
        cacheOperation1.addFirst(node);
    }

    public NotepadPlus getFirst(){
        return cacheOperation1.getFirst();
    }

    //search value in cache and addFirst
    //поиск значения в кэше и занесение его в голову в случае нахождения
    public synchronized boolean searchElement(NotepadPlus node){
        if(cacheOperation1.size()>0){
            NotepadPlus temp;
            //Circumvention cache 1
            for (iterator=cacheOperation1.listIterator();iterator.hasNext();) {
                temp=iterator.next();
                if(temp.equals(node)){
                    node.setResult(temp.getResult());
                    cacheOperation1.remove(temp);
                    cacheOperation1.addFirst(node);
                    return true;
                }
            }
            //Circumvention cache 2
            if(node.getResult()==null)
                for (iterator=cacheOperation2.listIterator();iterator.hasNext();) {
                    temp=iterator.next();
                    if(temp.equals(node)){
                        node.setResult(temp.getResult());
                        cacheOperation2.remove(temp);
                        push(node);
                        return true;
                    }
                }
        }
        return false;
    }
}
