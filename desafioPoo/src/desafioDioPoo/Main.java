package desafioDioPoo;

import java.time.LocalDate;

import desafioDioPoo.dominio.Bootcamp;
import desafioDioPoo.dominio.Conteudo;
import desafioDioPoo.dominio.Curso;
import desafioDioPoo.dominio.Dev;
import desafioDioPoo.dominio.Mentoria;

public class Main {

	public static void main(String[] args) {
		
		Curso curso1 = new Curso();
		curso1.setTitulo("Curso Java");
		curso1.setDescricao("Sobre curso Java");
		curso1.setCargaHoraria(8);
	
		Curso curso2 = new Curso();
		curso2.setTitulo("Curso Python");
		curso2.setDescricao("Sobre curso Python");
		curso2.setCargaHoraria(4);
		
		Mentoria mentoria = new Mentoria();
		mentoria.setTitulo("Mentoria de Java");
		mentoria.setDescricao("Sobre mentoria");
		mentoria.setData(LocalDate.now());

		Bootcamp bootcamp = new Bootcamp();
		bootcamp.setNome("Bootcamp Java Dev");
		bootcamp.setDescricao("Sobre Bootcamp Java");
		bootcamp.getConteudos().add(curso1);
		bootcamp.getConteudos().add(curso2);
		bootcamp.getConteudos().add(mentoria);
		
		Dev devFer = new Dev();
		devFer.setNome("Fernanda");
		devFer.insccreverBoot(bootcamp);
		System.out.println("Fer inscritos: " + devFer.getInscritos());
		devFer.progredir();
		devFer.progredir();
		System.out.println("Concluidos: " + devFer.getConcluidos());
		System.out.println("XP: " + devFer.calcularTotalXp());
		
		Dev devJoao = new Dev();
		devJoao.setNome("Joao");
		devJoao.insccreverBoot(bootcamp);
		System.out.println("\nJoao inscritos: " + devJoao.getInscritos());
		devJoao.progredir();
		devJoao.progredir();
		devJoao.progredir();
		System.out.println("Concluidos: " + devJoao.getConcluidos());
		System.out.println("XP: " + devJoao.calcularTotalXp());
	
	
	}
	
}
