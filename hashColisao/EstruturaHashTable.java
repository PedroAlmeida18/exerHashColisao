package hashColisao;

public class EstruturaHashTable implements EstruturaDeDados {
    private Integer tabela[];
    private Integer tabelaextra[];
    private int tamanho;

    //TODO adicionar elementos necessários para implementar o porão

    public EstruturaHashTable() {
        tabelaextra = new Integer[100];
        //esse número pode ser alterado
        tabela = new Integer[1000];
        tamanho = 100;
    }

    @Override
    public boolean insert(int chave) {
        int posição = calcularposi(chave);
        if (tabela[posição] == null) {
            tabela[posição] = chave;
            return true;
        } else {
            int posiçãoex = calcularpoisextra(chave);
            for (int i = 0; i < tamanho; i++) {
                if (tabelaextra[(posiçãoex + i) % tamanho] == null) {
                    tabelaextra[(posiçãoex + i) % tamanho] = chave;
                    return true;
                }
            }
        }
        return false;
    }

    // TODO quando inserir, se a posição estiver ocupada, 
    //o elemento NÃO é inserido e retorna false. 
    //Caso contrário, o elemento é inserido na posição calculada e retorna true.

    @Override
    public boolean delete(int chave) {
        int posição = calcularposi(chave);
        if (tabela[posição] != null && tabela[posição] == chave) {
            tabela[posição] = null;
            return true;
        } else {
            int posiçãoextra = calcularpoisextra(chave);
            for (int i = 0; i < tamanho; i++) {
                if (tabelaextra[(posiçãoextra + i) % tamanho] != null
                        && tabelaextra[(posiçãoextra + i) % tamanho] == chave) {
                    tabelaextra[(posiçãoextra + i) % tamanho] = null;
                    return true;
                }
            }
            return false;
        }
    }

    @Override
    public int search(int chave) {
        int posição = calcularposi(chave);
        if (tabela[posição] != null && tabela[posição] == chave) {
            return posição;
        } else {
            int posiçãoex = calcularpoisextra(chave);
            for (int i = 0; i < tamanho; i++) {
                if (tabelaextra[(posiçãoex + i) % tamanho] != null
                        && tabelaextra[(posiçãoex + i) % tamanho] == chave) {
                    return posiçãoex + i + 1000;
                }
            }
            return -1;
        }
    }

    public int calcularposi(int chave) {
        int posi = chave % 1000;
        return posi;
    }

    public int calcularpoisextra(int chave) {
        int posi = chave % 1000;
        int posiçãoextra = posi % 100;
        return posiçãoextra;
    }
}