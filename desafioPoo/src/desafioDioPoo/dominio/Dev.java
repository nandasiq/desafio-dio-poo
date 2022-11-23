package desafioDioPoo.dominio;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {

	private String nome;
	private Set<Conteudo> inscritos = new LinkedHashSet<>();
	private Set<Conteudo> concluidos = new LinkedHashSet<>();

	public void insccreverBoot(Bootcamp bootcamp) {
		this.inscritos.addAll(bootcamp.getConteudos());
		bootcamp.getDevsInscritos().add(this);
	}
	
	public void progredir() {
		Optional<Conteudo> conteudo = this.inscritos.stream().findFirst();
		if(conteudo.isPresent()) {
			this.concluidos.add(conteudo.get());
			this.inscritos.remove(conteudo.get());
		} else {
			System.err.println("Voce nao esta inscrito em nenhim conteudo");
		}
	}
	
	public double calcularTotalXp() {
		
		Iterator<Conteudo> iterator = this.concluidos.iterator();
		double soma = 0;
		while(iterator.hasNext()) {
			double next = iterator.next().calcularXp();
			soma += next;
		}
		return soma;
//		return this.concluidos.stream()
//				.mapToDouble(Conteudo::calcularXp)
//				.sum();
		}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Conteudo> getInscritos() {
		return inscritos;
	}

	public void setInscritos(Set<Conteudo> inscritos) {
		this.inscritos = inscritos;
	}

	public Set<Conteudo> getConcluidos() {
		return concluidos;
	}

	public void setConcluidos(Set<Conteudo> concluidos) {
		this.concluidos = concluidos;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(concluidos, inscritos, nome);
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
		return Objects.equals(concluidos, other.concluidos) && Objects.equals(inscritos, other.inscritos)
				&& Objects.equals(nome, other.nome);
	}

	

}
