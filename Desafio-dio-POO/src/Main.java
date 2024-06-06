import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Curso JS = new Curso();
        JS.setTitulo("curso java");
        JS.setDescricao("descrição JS");
        JS.setCargaHoraria(8);

        Curso java = new Curso();
        java.setTitulo("curso js");
        java.setDescricao("descrição Java");
        java.setCargaHoraria(2);

        Curso git = new Curso();
        git.setTitulo("curso Git");
        git.setDescricao("descrição Git");
        git.setCargaHoraria(4);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("mentoria java");
        mentoria.setDescricao("descrição mentoria java");
        mentoria.setData(LocalDate.now());


        
        /*System.out.println(JS);
        System.out.println(java);
        System.out.println(mentoria);*/

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(JS);
        bootcamp.getConteudos().add(java);
        bootcamp.getConteudos().add(mentoria);
        bootcamp.getConteudos().add(git);

        Dev devLucas = new Dev();
        devLucas.setNome("Lucas");
        devLucas.inscreverBootcamp(bootcamp);
        System.out.println("Conteudos inscritos Lucas"+ devLucas.getConteudosInscritos());
        devLucas.progredir();
        devLucas.progredir();
        System.out.println("-");
        System.out.println("Conteudos concluidos Lucas"+ devLucas.getConteudosConcluidos());
        System.out.println("Conteudos inscritos Lucas"+ devLucas.getConteudosInscritos());
        System.out.println("Xp: "+ devLucas.calcularTotalXp());

        System.out.println("Porcentagem de cursos concluídos: " + bootcamp.calcularProgresso() + "%");
    }
}

