public class Resposta extends Pacote {
    private int nSeq;
    private String mensagem;
    public Resposta(String source, String destino, int nSeq, String mensagem) {
        super(source, destino);
        this.nSeq = nSeq;
        setMensagem(mensagem);;
    }

    @Override
    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String msg){
        if(msg.length()>1450){
            throw new IllegalArgumentException("Mensagem demasiado comprida");
        } else {
            this.mensagem=msg;
        }
    }

    public int getNSeq() {
        return nSeq;
    }
    
    @Override
    public String toString(){
        return "RESPOSTA (source:"+getSource()+", destination: "+getDestino()+", seq: "+getNSeq()+") msg: ["+getMensagem()+"]";
    }
}
