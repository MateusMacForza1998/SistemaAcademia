package academia.modelo;

public class Treino {

    protected String exercicio;
    protected int serie;
    protected int repeticao;
    protected float intervalo;

    public Treino(String exercicio, int serie, int repeticao, float intervalo){
        this.exercicio = exercicio;
        this.serie = serie;
        this.repeticao = repeticao;
        this.intervalo = intervalo;
    }

    public String GetExercicio(){
        return exercicio;
    }
    public void SetExercicio(String exercicio){
        this.exercicio = exercicio;
    }

    public int GetSerie(){
        return serie;
    }
    public void SetSerie(int serie){
        this.serie = serie;
    }

    public int GetRepeticao(){
        return repeticao;
    }
    public void SetRepeticao(int repeticao){
        this.repeticao = repeticao;
    }

    public float GetIntervalo(){
        return intervalo;
    } 
    public void SetIntervalo(float intervalo){
        this.intervalo = intervalo;
    }

    


    
} 