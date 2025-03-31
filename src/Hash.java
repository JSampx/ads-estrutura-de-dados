public class Hash {
    /* Classe Hash contém uma função para retonar uma int posição para armazenar na vetor de espalhamento*/
    public static int funcHash(Palavra palavra){
        int posicoes = 31;
        //Casting da primeira letra da palavra em int pela tabela ASCII transformando em lower case
        int initial = (int) palavra.getPalavra().toLowerCase().charAt(0);
        return initial % posicoes;
    }


}
/*
Referência da Tabela ASCII para caracteres em minúsculo

a 	97
b 	98
c 	99
d 	100
e 	101
f 	102
g 	103
h 	104
i 	105
j 	106
l 	108
m 	109
n 	110
o 	111
p 	112
q 	113
r 	114
s 	115
t 	116
u 	117
v 	118
w 	119
x 	120
y 	121
z 	122
*/