public class Pedido extends Pacote{
    private int seq;
    private static int seqCount = 10;
    private String mensagem;
    public Pedido(String source, String destino, String mensagem) {
        super(source, destino);
        seq = gerarSeq();
        setMensagem(mensagem);
    }

    protected int gerarSeq() {
        return seqCount++;
    }

    @Override
    public String getMensagem(){
        return mensagem;
    }

    public int getSeq(){
        return seq;
    }

    public void setMensagem(String msg){
        if(msg.length()>1450){
            throw new IllegalArgumentException("Mensagem demasiado comprida");
        } else {
            this.mensagem=msg;
        }
    }

    @Override
    public String toString(){
        return "PEDIDO (source:"+getSource()+", destination: "+getDestino()+", seq: "+getSeq()+") msg: ["+getMensagem()+"]";
    }

}

