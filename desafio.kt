enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(var nome: String, val id: Int) {
    override fun equals(other: Any?) = other is Usuario && other.id == this.id;
}

data class ConteudoEducacional(val nome: String, val duracao: Int = 60, val nivel: Nivel = Nivel.BASICO)

data class Formacao(val nome: String, val conteudos: MutableList<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        //TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
        if (!inscritos.contains(usuario)) inscritos.add(usuario) else throw Exception("O usuário já está inscrito neste curso.");
    }
    
    fun addConteudoEducacional(conteudo: ConteudoEducacional) {
        this.conteudos.add(conteudo);
    }
    
    
}

fun main() {
    //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
    
    val mockUser1 = Usuario("Alfa", id = 1);
    val mockUser2 = Usuario("Beta", id = 1);
    val mockConteudo1 = ConteudoEducacional("Tipos de Variaveis");
    val mockConteudo2 = ConteudoEducacional("Tipos de Condicionais", 30);
    val mockConteudo3 = ConteudoEducacional("Estraturas de Dados", 61, Nivel.INTERMEDIARIO);
    val mockLista: MutableList<ConteudoEducacional> = mutableListOf(mockConteudo1, mockConteudo2);
    val mockFormacao1 = Formacao("Back-end Kotlin", mockLista);
    
    //Mostra um usuario
    println(mockUser1);
    
    //Listando todos conteudos do mock e pegando índice 1 na lista de Conteudo
    println(mockFormacao1.conteudos);
    println(mockFormacao1.conteudos.elementAt(1));
    
    //Tentando matricular um usuario com mesmo ID na formacao
	mockFormacao1.matricular(mockUser1);
    
    //Testando o retorno pra evitar mesmo ID
    try {
        mockFormacao1.matricular(mockUser2);
    }
    catch (e: Exception) {
        println(e.message);
    }
    
    //Adicionando um novo ConteudoEducacional a Formacao
    println(mockFormacao1);
    mockFormacao1.addConteudoEducacional(mockConteudo3);
    println(mockFormacao1);
   
}