package academia.modelo;

public class itemTreino extends Entidade{

    private String exercicio;
    private int serie;
    private int repeticao;
    private float intervalo;

    public itemTreino( int id,String exercicio, int serie, int repeticao, float intervalo){
        super(id);
        this.exercicio = exercicio;
        this.serie = serie;
        this.repeticao = repeticao;
        this.intervalo = intervalo;
    }

    public String getExercicio(){
        return exercicio;
    }
    public void setExercicio(String exercicio){
        this.exercicio = exercicio;
    }

    public int getSerie(){
        return serie;
    }
    public void setSerie(int serie){
        this.serie = serie;
    }

    public int getRepeticao(){
        return repeticao;
    }
    public void setRepeticao(int repeticao){
        this.repeticao = repeticao;
    }

    public float getIntervalo(){
        return intervalo;
    } 
    public void setIntervalo(float intervalo){
        this.intervalo = intervalo;
    }

    @Override
    public String toString() {
        return
        " | Exercício: " + exercicio +
        " | Séries: " + serie +
        " | Repetições: " + repeticao +
        " | Intervalo: " + intervalo + " min";
    }



    
} 