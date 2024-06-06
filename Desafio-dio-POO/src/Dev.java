import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

public class Dev {
    private String nome;
    private Set<Conteudo> conteudosInscritos =  new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public void inscreverBootcamp(Bootcamp bootcamp) {
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }

    public void progredir() {
        Optional<Conteudo> conteudoOptional = this.conteudosInscritos.stream().findFirst();
        if (conteudoOptional.isPresent()) {
            Conteudo conteudo = conteudoOptional.get();
            if (conteudo instanceof Curso) {
                Curso curso = (Curso) conteudo;
                // Verifica se o curso foi concluído com sucesso
                if (cursoConcluidoComSucesso(curso)) {
                    System.out.println("Curso concluído com sucesso: " + curso.getTitulo());
                    this.conteudosConcluidos.add(curso);
                    this.conteudosInscritos.remove(curso);
                    parabenizar(curso.getTitulo());
                } else {
                    System.err.println("Erro ao concluir o curso: " + curso.getTitulo());
                }
            }
        } else {
            System.err.println("Você não está matriculado em nenhum conteúdo!");
        }
    }

    private boolean cursoConcluidoComSucesso(Curso curso) {
        // Lógica para verificar se o curso foi concluído com sucesso
        return true; // Adapte conforme a lógica de conclusão do curso
    }

    private void parabenizar(String nomeCurso) {
        System.out.println("Parabéns por concluir o curso de " + nomeCurso + "!");
    }

    public double calcularTotalXp() {
        return this.conteudosConcluidos.stream()
                                       .mapToDouble(conteudo -> conteudo.calcularXp())
                                       .sum();
    }

     public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((conteudosInscritos == null) ? 0 : conteudosInscritos.hashCode());
        result = prime * result + ((conteudosConcluidos == null) ? 0 : conteudosConcluidos.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Dev other = (Dev) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (conteudosInscritos == null) {
            if (other.conteudosInscritos != null)
                return false;
        } else if (!conteudosInscritos.equals(other.conteudosInscritos))
            return false;
        if (conteudosConcluidos == null) {
            if (other.conteudosConcluidos != null)
                return false;
        } else if (!conteudosConcluidos.equals(other.conteudosConcluidos))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "XP: " + calcularTotalXp();
    }
    
    
}
