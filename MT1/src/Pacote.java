public abstract class Pacote {
    public String source;
    public String destino;
    public Pacote(String source, String destino){
        setSource(source);
        setDestino(destino);
    }

    public String getSource(){
        return source;
    }

    public String getMensagem(){ return "";}

    public String getDestino(){
        return destino;
    }

    public void setSource(String source) {
        if (source.matches("^([0-2]?[0-9]{1,2}[.]){3}[0-2]?[0-9]{1,2}$")) { // Validação com regex
            this.source = source;
        } else {
            throw new IllegalArgumentException("Source inválido!");
        }
    }

    public void setDestino(String destino) {
        if (destino.matches("^([0-2]?[0-9]{1,2}[.]){3}[0-2]?[0-9]{1,2}$")) { // Validação com regex
            this.destino = destino;
        } else {
            throw new IllegalArgumentException("Destino inválido!");
        }
    }

    @Override
    public String toString(){
        return "Pacote = {Source: "+getSource()+"; Destino: "+getDestino()+"}";
    }
}
