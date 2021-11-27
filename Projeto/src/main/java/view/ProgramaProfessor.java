	package view;
	import java.util.Iterator;
	import java.util.List;
	import control.ProfessorControle;
	import model.Professor; 

public class ProgramaProfessor {

		public static void main(String[] args) {
			//inserindo
			Professor novo = new Professor(null, "Maria", "2", "1989-02-12", "3456789087", "maria@gmail.com", "F");	
			ProfessorControle controle = new ProfessorControle();	
			controle.inserir(novo);
			
			//buscando
			novo = controle.buscarPorId(5); //o id 3 precisa existir no banco, modifique o valor
			System.out.println(novo.getNome()); // substitua por um método get do seu projeto
			
			//modificando
			novo.setNome("Sara Fernandes"); // no seu caso utilize um método set do seu projeto
			controle.alterar(novo);
			
			//buscar todos
			List<Professor> objetos = controle.BuscarTodos();
			for (Iterator iterator = objetos.iterator(); iterator.hasNext();) {
				Professor obj = (Professor) iterator.next();
				System.out.println(obj.getNome());
			}
			
			//excluir
			controle.excluir(objetos.get(0)); 
			
			//excluir por id
			controle.excluirPorId(8); //o id 3 precisa existir no banco, modifique o valor	
		}
	}


