package hashColisao;

public class EstruturaHashTable implements EstruturaDeDados{
    private Integer tabela[];
    //TODO adicionar elementos necessários para implementar o porão

    public EstruturaHashTable() {
        int porão = 100;
        int tamanho = 1000 + porão;
        //esse número pode ser alterado
        tabela = new Integer[tamanho+porão];
    }

    @Override
    public boolean insert(int chave) {
        int posição = calcularposi(chave);
        for (int i = 0;i<tabela.length;i++){
            if ( tabela[posição] == null || tabela[posição]== chave ){
                tabela[posição] = chave ;
                return true ;

            }
         
           
        }
        return false;

        // TODO quando inserir, se a posição estiver ocupada, 
        //o elemento NÃO é inserido e retorna false. 
        //Caso contrário, o elemento é inserido na posição calculada e retorna true.
        
    }

    @Override
    public boolean delete(int chave) {
        // TODO quando inserir, se a posição estiver ocupada, torna o elemento da posição como null e retorna true. Caso contrário, retorna false.
        return false;
        
    }

    @Override
    public int search(int chave) {
        int posição = calcularposi(chave);
        for ( int i = 0 ; i< tabela.length;i++){
            if( tabela[posição] == null){
                return -1;
            }
            else if (tabela[posição] == chave ){
                return chave ;

            }
        }
        // TODO se o elemento estiver presente retorna a sua posição. 
        //Caso contrário, retorna -1.
        return -1;
    }
    public int calcularposi( int chave){
        int posi= chave % 1100;
        return posi;
    }

}
