public class ArrayList implements List {
    private Object[] arr;
    private int size;

    public ArrayList(){
        arr = new Object[10];
    }

    @Override
    public void add(Object obj) {
        if (arr.length == size){
            growArr();
        }
        arr[size]= obj;
        size++;
    }

    private void growArr() {
        Object newArr[] = new Object[arr.length*2];
        for(int i = 0; i < size; i++){
            newArr[i] = arr[i];
        }

//        System.arraycopy(arr,0,newArr,0,size);
//        Syste
        arr = newArr;
    }

    @Override
    public void add(int pos, Object obj) {
        if (pos < 0 || pos > arr.length){
            try {
                throw new Exception("Invalid range");
            }
            catch (Exception e){
                //do nothing
            }
        }
        if (arr.length == size){
            growArr();
        }

        for (int i = size; i > pos; i --){
            arr[i] = arr[i-1];
        }
        size++;
        arr[pos] = obj;
    }

    @Override
    public Object get(int pos) {
        if (pos < 0 || pos > arr.length){
            try {
                throw new Exception("Invalid range");
            }
            catch (Exception e){
                //do nothing
            }
        }
        return arr[pos];
    }

    @Override
    public Object remove(int pos) {
        if (pos < 0 || pos > arr.length){
            try {
                throw new Exception("Invalid range");
            }
            catch (Exception e){
                //do nothing
            }
        }
        Object rm = arr[pos];
        for (int i = pos; i < size-1; i++){
            arr[i] = arr[i+1];
        }
        size--;
        return rm;
    }

    @Override
    public int size() {
        return size;
    }
}
