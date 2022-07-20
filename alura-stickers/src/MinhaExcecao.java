public class MinhaExcecao extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public MinhaExcecao(String msg){
        super(msg);
    }

    public MinhaExcecao(String msg, Throwable cause){
        super(msg, cause);
    }
     
}
