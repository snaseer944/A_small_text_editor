package TextEditor;

public class IO <T> {
    private T data;
    private boolean correct;

    public IO(boolean correct, T data) {
        this.correct = correct;
        this.data = data;
    }
    public boolean isCorrect(){
        return correct;
    }
    public boolean hasData() {
        return data != null;
    }
    public T getData(){
        return data;
    }
}

